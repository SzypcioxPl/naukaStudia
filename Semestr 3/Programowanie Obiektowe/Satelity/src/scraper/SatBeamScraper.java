package scraper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SatBeamScraper {

    protected static final Logger logger = LogManager.getLogger();

    public SatBeamScraper() {
    }

    public List<SatBeam> ScrapeData(int rangeStart, int rangeEnd) throws Exception {
        Document document;
        try {
            Connection connect = Jsoup.connect("https://www.satbeams.com/satellites");
            document = connect.timeout(10 * 6000).get();

        } catch (Exception er) {
            logger.warn("Unable to connect!");
            logger.error(er);
            return new ArrayList<>();
        }

        if(rangeStart <= 0 || rangeStart >= 609){
            throw new Exception("Start of range must be between 1 and 608");
        }else{
            rangeStart++;
        }

        if(rangeEnd > 608 || rangeEnd <= 0){
            throw new Exception("End of range must be between 1 and 608");
        }

        if(rangeEnd < rangeStart){
            throw new Exception("Start of range can't have lower value than End of range");
        }else{
            rangeEnd++;
        }



        Document parse = Jsoup.parse("<tr class=\"head_tr\"><th></th></tr>");

        Elements headRow = document.select(".head_tr");

        for (Element columns : headRow) {
            System.out.println("text : " + columns.text());
        }

        List<SatBeam> Satellites = new ArrayList<SatBeam>();
        int whichColumn = 0;


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
            whichColumn = 0;
            Satellites.add(tempSat);
        }

        logger.info("Successfully scraped Sattelites with id from " + rangeStart + " to " + rangeEnd);
        return Satellites;
    }
}
