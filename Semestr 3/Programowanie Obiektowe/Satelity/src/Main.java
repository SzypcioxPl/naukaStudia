import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeam;
import scraper.SatBeamScraper;
import scraper.WebsiteData;
import test.TestTranslation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    protected static final Logger logger = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

    private static TestTranslation testTranslation = new TestTranslation();

    public Main() {}

    public static void main(String[] args) throws Exception {
        logger.info("Start of APP\n\n");

        testTranslation.checkWhetherSatBeamListIsScrapedProperly();

        testTranslation.checkWhetherSatBeamIsTranslatedToWebsiteSatellites();

        testTranslation.checkWhetherSatBeamDataIsTranslatedExistingWebsiteSatellite();

        testTranslation.checkWhetherSatBeamListIsTranslatedToWebsiteSatellitesList();


    }
}