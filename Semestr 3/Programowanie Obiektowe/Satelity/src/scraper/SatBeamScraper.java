package scraper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.util.*;

public class SatBeamScraper {

    protected static final Logger scraper = LogManager.getLogger();

    public SatBeamScraper() {
    }

    public List<SatBeam> ScrapeData(int rangeStart, int rangeEnd, String status) throws Exception {

        // check connection
        Document document;
        try {
            Connection connect = Jsoup.connect("https://www.satbeams.com/satellites");
            document = connect.get();
        } catch (Exception er) {
            scraper.warn("Unable to connect!");
            scraper.error(er);
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

        if(!status.contains("active") && !status.contains("deorbited") && !status.contains("retired") && !status.contains("failed") && !status.contains("any")){
            throw new Exception("Provided wrong type of status");
        }


        // start scraping data
        List<SatBeam> Satellites = new ArrayList<SatBeam>();
        int whichColumn = 0;
        String anim= "|/-\\"; //for loading animation
        int scrapedSatCount = 1;

        // goes every row from given range
        for (int i = rangeStart; i <= rangeEnd; i++) {

            // loading animation
            String data = "\r  Scraped Sat's with '" + status + "' status: " + scrapedSatCount + " " +  anim.charAt(i% anim.length()) + "   |   ";
            System.out.write(data.getBytes());

            //get data from single row
            String condition = "table > tbody > tr > td:nth-child(2) tr:nth-child(" + i + ") td";

            //check whether no error occure while getting row
            try{
                Elements trRow = document.select(condition);
                SatBeam tempSat = new SatBeam();

                // check whether row we got is not empty
                if(!Objects.equals(trRow.text(), "")){

                    // check if satellite has given status
                    if(status.equals("any") || trRow.get(2).text().contains(status)){
                        // handle single row data and save it to object
                        for (Element tr : trRow) {

                            switch (whichColumn){
                                case 0:
                                    try{
                                        tempSat.setId(Long.parseLong(tr.text()));
                                    }catch (Exception er) {
                                        scraper.warn("Can't scrape ID for Sat number " + Satellites.getLast().getId() + " : " + er.getMessage());
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
                                    try{
                                        Elements aLinkHref = document.select("table > tbody > tr > td:nth-child(2) tr:nth-child(" + i + ") td > a");
//                                    System.out.println("Link: " + "https://www.satbeams.com" + aLinkHref.getFirst().attr("href"));
                                        String link = "https://www.satbeams.com" + aLinkHref.getFirst().attr("href");
                                        try{
                                            tempSat = this.GetAdditionalData(link, tempSat);
                                        }catch (Exception er){
                                            scraper.error("While getting additional data to Sat with id = " + tempSat.getId() + " error occured: " + er);
                                        }
                                    }catch (Exception er){
                                        scraper.error("While scraping url to more detailed info about Sat error occured: " + er);
                                    }
                                    break;
                                case 4:
                                    try{
                                        tempSat.setNorad(Integer.parseInt(tr.text()));
                                    }catch (Exception er){
                                        scraper.warn("Can't scrape Norad for Sat with id " + tempSat.getId() + " : "+ er.getMessage());
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
                                        scraper.warn("Can't scrape Launch Mass for Sat with id " + tempSat.getId() + ": "+ er.getMessage());
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
                        scrapedSatCount++;
                        Satellites.add(tempSat);
                    }
                }else {
                    scraper.warn("Scraped line number " + Satellites.getLast().getId() + " is empty!");
                }
            }
            catch (Exception er){
                scraper.error("Problem Reading Info from Row " + Satellites.getLast().getId() + " : " + er.getMessage());
            }
        }

        scraper.info("Successfully scraped " + (scrapedSatCount-1) + " satellites!");
        return Satellites;
    }

    public SatBeam GetAdditionalData(String url, SatBeam sat) throws Exception {
        SatBeam tempSat = sat;
        Document document;
        try {
            Connection connect = Jsoup.connect(url);
            document = connect.get();
//            OkHttpClient okHttp = new OkHttpClient();
//            Request request = new Request.Builder().url(url).get().build();
//            document = Jsoup.parse(okHttp.newCall(request).execute().body().string());
        } catch (Exception er) {
            throw new Exception("Unable to connect! Error: " + er);
        }

        String condition = "div#table_wrap table tbody > tr:nth-child(2) > td:first-child";
        Elements items = document.select(condition);
        String[] toAnalyze = items.toString().split("(\\<br\\>|\\<td\\>)\\<b\\>*[a-z A-Z0-9:()]*\\<\\/b\\>");

        int whichLine = 0;
        for (String oneItem : toAnalyze){

            String value;

            if(oneItem.contains("<a href")){
                String[] item = oneItem.split("\">");
                item = item[1].split("</a>");
                value = item[0];
            }else{
                value = oneItem;
            }

            switch (whichLine){
                case  9:
                    if (value.contains("&nbsp;")){
                        tempSat.setLaunchVehicle(null);
                    }else{
                        tempSat.setLaunchVehicle(value);
                    }
                    break;
                case 12:
                    if (value.contains("&nbsp;")){
                        tempSat.setManufacturer(null);
                    }else{
                        tempSat.setManufacturer(value);
                    }
                    break;
                case 15:
                    if (value.contains("&nbsp;")){
                        tempSat.setExpectedLifetime(null);
                    }else{
                        tempSat.setExpectedLifetime(value.split("<br></td>")[0]);
                    }
                    break;
            }

            whichLine++;
        }
        return tempSat;
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
