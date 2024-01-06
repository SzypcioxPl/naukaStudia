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

        List<SatBeam> Satellites = new ArrayList<SatBeam>();

        try{
            Satellites = scraper.ScrapeData(1,3);
        }catch (Exception er){
            logger.error(er.getMessage());
        }


        for(SatBeam SingleSat : Satellites){
            System.out.println(SingleSat.toString());
        }

        // TODO: Prepare model mapper which will translate SatBeam Object to WebsiteData Object

    }
}