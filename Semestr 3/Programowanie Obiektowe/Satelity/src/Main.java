import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeamScraper;
import test.TestTranslation;

public class Main {

    protected static final Logger logger = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

    private static TestTranslation testTranslation = new TestTranslation();

    public Main() {}

    public static void main(String[] args) throws Exception {
        logger.info("Start of APP\n\n");

        testTranslation.checkWhetherSatBeamListIsScrapedProperly(1, 608);
        testTranslation.checkWhetherSatBeamIsTranslatedToWebsiteSatellites(78);
        testTranslation.checkWhetherSatBeamDataIsTranslatedToExistingWebsiteSatellite(56);
        testTranslation.checkWhetherSatBeamListIsTranslatedToWebsiteSatellitesList(1, 608);


    }
}