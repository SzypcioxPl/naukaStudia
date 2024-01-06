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

    private WebsiteData data = new WebsiteData();

    public Main() {}

    public static void main(String[] args) throws Exception {
        logger.info("Start of APP");

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

        // translating SatBeam to WebsiteData Satellite
        WebsiteData.Satellite testSat1 = new WebsiteData.Satellite();
        testSat1 = test.toSatellite();

        System.out.println(testSat1.toString());

        // translating SatBeam to WebsiteData Satellite
        WebsiteData.Satellite testSat2 = new WebsiteData.Satellite();
        testSat2 = test.updateSatelliteBySatBeam(testSat2);

        System.out.println(testSat2.toString());


    }
}