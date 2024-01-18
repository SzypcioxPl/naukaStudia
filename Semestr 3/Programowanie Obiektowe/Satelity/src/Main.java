import OtherGroupsWork.LyngSat.LyngSat;
import OtherGroupsWork.Merge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeamScraper;
import test.TestKingOfSat;
import test.TestTranslation;


public class Main {

    protected static final Logger main = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

    private static LyngSat scraperLyngSat = new LyngSat();

    private static Merge merge = new Merge();
    private static TestTranslation testTranslation = new TestTranslation();
    private  static TestKingOfSat testKingOfSat = new TestKingOfSat();

    private static Menu menu = new Menu();

    public Main() {}

    public static void main(String[] args) throws Exception {
        main.info("Start of APP\n\n");

        try{
            menu.startMenu();
        }catch (Exception er){
            main.error("Error: " + er.getMessage());
        }

//        WebsiteData AllData = new WebsiteData();
//
//        System.out.println("Scraping SatBeams");
//        List<SatBeam> sats = scraper.ScrapeData(1,608, "active");
//        List<WebsiteData.Satellite> satsSatBeam = scraper.SatBeamListToSatellites(sats);
//
//        System.out.println("Scraping LyngSat");
//        List<WebsiteData.Satellite> satsLyngSat = scraperLyngSat.ScrapeLyngSat();
//
////        satsLyngSat = merge.mergeSatBeamToLyngSat(satsSatBeam, satsLyngSat);
////        satsSatBeam = merge.mergeLyngSatToSatBeam(satsLyngSat,satsSatBeam);
//
//        List<WebsiteData.Satellite> LyngSatNotInSatBeam = merge.listOfLyngSatNotInSatBeam(satsLyngSat, satsSatBeam);
//
////        for(WebsiteData.Satellite sat : satsLyngSat){
////            System.out.println(sat.toString());
////        }

        main.info("End of program");

    }
}