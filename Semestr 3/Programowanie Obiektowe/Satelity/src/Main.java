import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeam;
import scraper.SatBeamScraper;
import scraper.WebsiteData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    protected static final Logger logger = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

    public Main() {}

    public static void main(String[] args) throws Exception {
        logger.info("Start of APP\n\n");

        logger.info(">>> Test Whether Scraper Properly Fetch Data From Website <<<");
        List<SatBeam> satellites = new ArrayList<SatBeam>();

        try{
            satellites = scraper.ScrapeData(1,1);
        }catch (Exception er){
            logger.error(er.getMessage());
        }


        for(SatBeam SingleSat : satellites){
            System.out.println(SingleSat.toString());
        }

        SatBeam test = satellites.getFirst();

        System.out.println("\n\n");
        logger.info(">>> Test Whether SatBeam Object Is Properly Translated To Satellite Object <<<");
        WebsiteData.Satellite testSat1 = new WebsiteData.Satellite();
        testSat1 = test.toSatellite();
        System.out.println(testSat1.toString());

        System.out.println("\n\n");
        logger.info(">>> Test Whether SatBeam Object Is Properly Translated and Update Data in Already Created Satellite <<<");
        WebsiteData.Satellite testSat2 = new WebsiteData.Satellite();
        testSat2 = test.updateSatelliteBySatBeam(testSat2);
        System.out.println(testSat2.toString());

        System.out.println("\n\n");
        logger.info(">>> Test Whether SatBeam Object List Is Properly Translated To Satellite Object List <<<");
        try{
            satellites = scraper.ScrapeData(1,5);
        }catch (Exception er){
            logger.error(er.getMessage());
        }

        ArrayList<WebsiteData.Satellite> testSattelites = scraper.SatBeamListToSatellites(satellites);

        for(WebsiteData.Satellite oneSattelite: testSattelites){
            System.out.println(oneSattelite.toString());
        }

    }
}