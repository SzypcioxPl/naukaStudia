package scraper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SatBeamScraper {

    protected static final Logger logger = LogManager.getLogger();

    public SatBeamScraper() {
    }

    public List<SatBeam> ScrapeData(int rangeStart, int rangeEnd) throws Exception {

        // check connection
        Document document;
        try {
            Connection connect = Jsoup.connect("https://www.satbeams.com/satellites");
            document = connect.get();
        } catch (Exception er) {
            logger.warn("Unable to connect!");
            logger.error(er);
            return new ArrayList<>();
        }

        // check whether start is lower number than start
        if(rangeEnd < rangeStart){
            throw new Exception("Start of range can't have lower value than End of range");
        }else{
            rangeEnd++;
        }

        // check range end
        if(rangeEnd > 609 || rangeEnd <= 0){
            throw new Exception("End of range must be between 1 and 608");
        }

        // check rang start
        if(rangeStart <= 0 || rangeStart >= 609){
            throw new Exception("Start of range must be between 1 and 608");
        }else{
            rangeStart++;
        }


        // start scraping data
        List<SatBeam> Satellites = new ArrayList<SatBeam>();
        int whichColumn = 0;

        // goes every row from given range
        for (int i = rangeStart; i <= rangeEnd; i++) {

            //get data from single row
            String condition = "table > tbody > tr > td:nth-child(2) tr:nth-child(" + i + ") td";

            //check whether no error occure while getting row
            try{
                Elements trRow = document.select(condition);
                SatBeam tempSat = new SatBeam();

                // check whether row we got is not empty
                if(!Objects.equals(trRow.text(), "")){

                    // handle single row data and save it to object
                    for (Element tr : trRow) {

                        switch (whichColumn){
                            case 0:
                                try{
                                    tempSat.setId(Long.parseLong(tr.text()));
                                }catch (Exception er) {
                                    logger.warn("Can't scrape ID for Sat number " + Satellites.getLast().getId() + " : " + er.getMessage());
                                    tempSat.setId(null);
                                }
                                break;
                            case 1:
                                tempSat.setPosition(tr.text());
                                break;
                            case 2:
                                tempSat.setStatus(tr.text());
                                break;
                            case 3:
                                tempSat.setSateliteName(tr.text());
                                break;
                            case 4:
                                try{
                                    tempSat.setNorad(Integer.parseInt(tr.text()));
                                }catch (Exception er){
                                    logger.warn("Can't scrape Norad for Sat with id " + tempSat.getId() + " : "+ er.getMessage());
                                    tempSat.setNorad(0);
                                }
                                break;
                            case 5:
                                tempSat.setCospar(tr.text());
                                break;
                            case 6:
                                tempSat.setSatelliteModel(tr.text());
                                break;
                            case 7:
                                tempSat.setOperator(tr.text());
                                break;
                            case 8:
                                tempSat.setLaunchSite(tr.text());
                                break;
                            case 9:
                                try{
                                    tempSat.setLaunchMass(Integer.parseInt(tr.text()));
                                }catch (Exception er){
                                    logger.warn("Can't scrape Launch Mass for Sat with id " + tempSat.getId() + ": "+ er.getMessage());
                                    tempSat.setLaunchMass(0);
                                }
                                break;
                            case 10:
                                tempSat.setLaunchDate(tr.text());
                                break;
                            case 11:
                                break;
                            case 12:
                                break;
                            case 13:
                                tempSat.setComments(tr.text());
                                break;
                        }
                        whichColumn++;
                    }

                    // add Sat Objects to List<SatBeam> Objects
                    whichColumn = 0;
                    Satellites.add(tempSat);
                }else {
                    logger.warn("Scraped line number " + Satellites.getLast().getId() + " is empty!");
                }
            }
            catch (Exception er){
                logger.error("Problem Reading Info from Row " + Satellites.getLast().getId() + " : " + er.getMessage());
            }
        }

        logger.info("Successfully scraped Satellites with id from " + (rangeStart - 1) + " to " + (rangeEnd-1));
        return Satellites;
    }

    // translating SatBeam Objects List to WebsiteData.Satellites Objects List
    public ArrayList<WebsiteData.Satellite> SatBeamListToSatellites(List<SatBeam> satBeams) throws ParseException {
        ArrayList<WebsiteData.Satellite> satellites = new ArrayList<WebsiteData.Satellite>();

        for(SatBeam satBeam : satBeams){
            satellites.add(satBeam.toSatellite());
        }

        return  satellites;
    }
}
