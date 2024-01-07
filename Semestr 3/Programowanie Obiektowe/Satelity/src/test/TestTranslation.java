package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeam;
import scraper.SatBeamScraper;
import scraper.WebsiteData;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TestTranslation {

    protected static final Logger logger = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

    public void checkWhetherSatBeamListIsScrapedProperly(){
        logger.info(">>> Test Whether Scraper Properly Fetch Data From Website <<<");
        List<SatBeam> satellites = new ArrayList<SatBeam>();

        try{
            satellites = scraper.ScrapeData(1,5);
        }catch (Exception er){
            logger.error(er.getMessage());
        }


        for(SatBeam SingleSat : satellites){
            System.out.println(SingleSat.toString());
        }

    }

    public void checkWhetherSatBeamIsTranslatedToWebsiteSatellites() throws ParseException {
        System.out.println("\n\n");
        logger.info(">>> Test Whether SatBeam Object Is Properly Translated To Satellite Object <<<");

        List<SatBeam> satellites = new ArrayList<SatBeam>();

        try{
            satellites = scraper.ScrapeData(1,1);
        }catch (Exception er){
            logger.error(er.getMessage());
        }


        WebsiteData.Satellite testSat = new WebsiteData.Satellite();
        ;
        try {
            testSat = satellites.getFirst().toSatellite();
        }catch (Exception err){
            logger.error(err);
        }
        System.out.println(testSat.toString());

    }

    public void checkWhetherSatBeamDataIsTranslatedExistingWebsiteSatellite(){
        System.out.println("\n\n");
        logger.info(">>> Test Whether SatBeam Object Is Properly Translated and Update Data in Already Created Satellite <<<");

        List<SatBeam> satellites = new ArrayList<SatBeam>();

        try{
            satellites = scraper.ScrapeData(1,1);
        }catch (Exception er){
            logger.error(er.getMessage());
        }

        SatBeam satBeam = new SatBeam();
        try {
           satBeam = satellites.getFirst();
        }catch (Exception err){
            logger.error(err);
        }
        ;
        WebsiteData.Satellite testSat = new WebsiteData.Satellite();
        try{
            testSat = satBeam.updateSatelliteBySatBeam(testSat);
            System.out.println(testSat.toString());
        }catch (Exception er){
            logger.error(er);
        }
    }

    public void checkWhetherSatBeamListIsTranslatedToWebsiteSatellitesList() throws ParseException {
        System.out.println("\n\n");
        logger.info(">>> Test Whether SatBeam Object List Is Properly Translated To Satellite Object List <<<");

        List<SatBeam> satellites = new ArrayList<SatBeam>();

        try{
            satellites = scraper.ScrapeData(1,77);
        }catch (Exception er){
            logger.error(er.getMessage());
        }

        ArrayList<WebsiteData.Satellite> testSattelites = scraper.SatBeamListToSatellites(satellites);

        for(WebsiteData.Satellite oneSattelite: testSattelites){
            System.out.println(oneSattelite.toString());
        }
    }

}
