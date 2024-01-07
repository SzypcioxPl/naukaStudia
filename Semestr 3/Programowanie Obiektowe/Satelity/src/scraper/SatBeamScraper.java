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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SatBeamScraper {

    protected static final Logger logger = LogManager.getLogger();

    public SatBeamScraper() {
    }

    public List<SatBeam> ScrapeData(int rangeStart, int rangeEnd) throws Exception {
        Document document;
        try {
            Connection connect = Jsoup.connect("https://www.satbeams.com/satellites");
//            document = connect.timeout(10 * 60000).get();
            document = connect.get();
        } catch (Exception er) {
            logger.warn("Unable to connect!");
            logger.error(er);
            return new ArrayList<>();
        }

        if(Math.abs(rangeStart-rangeEnd) >= 77){
            throw new Exception("Maximum number which you can save to single list is equal 77 objects");
        }

        if(rangeEnd < rangeStart){
            throw new Exception("Start of range can't have lower value than End of range");
        }else{
            rangeEnd++;
        }
        if(rangeEnd > 608 || rangeEnd <= 0){
            throw new Exception("End of range must be between 1 and 608");
        }

        if(rangeStart <= 0 || rangeStart >= 609){
            throw new Exception("Start of range must be between 1 and 608");
        }else{
            rangeStart++;
        }


        Document parse = Jsoup.parse("<tr class=\"head_tr\"><th></th></tr>");

        Elements headRow = document.select(".head_tr");

//        for (Element columns : headRow) {
//            System.out.println("text : " + columns.text());
//        }

        List<SatBeam> Satellites = new ArrayList<SatBeam>();
        int whichColumn = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH); //FORMAT STRING TO DATE

        // goes by rows
        for (int i = rangeStart; i <= rangeEnd; i++) {

            //get data from single row
            String condition = "table > tbody > tr > td:nth-child(2) tr:nth-child(" + i + ") td";
            Elements trRow = document.select(condition);
            SatBeam tempSat = new SatBeam();
            // handle single row data and save it to object
            for (Element tr : trRow) {

                switch (whichColumn){
                    case 0:
                        tempSat.setId(Long.parseLong(tr.text()));
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
                        tempSat.setNorad(Integer.parseInt(tr.text()));
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
                        tempSat.setLaunchMass(Integer.parseInt(tr.text()));
                        break;
                    case 10:
                        LocalDate dateTime = LocalDate.parse(tr.text(), formatter); // to pretty date
                        Date date =  Date.from(dateTime.atStartOfDay(ZoneId.systemDefault()).toInstant()); // to other format, more details
                        tempSat.setLaunchDate(date);
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
            whichColumn = 0;
            Satellites.add(tempSat);
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
