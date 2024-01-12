import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeamScraper;
import test.TestTranslation;

import javax.swing.*;
import java.awt.*;

public class Main {

    protected static final Logger main = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

    private static TestTranslation testTranslation = new TestTranslation();

    public Main() {}

    public static void main(String[] args) throws Exception {
        main.info("Start of APP\n\n");

        // possible status = 'any', 'active', 'retires', 'failed', 'deorbited'
        testTranslation.checkWhetherSatBeamListIsScrapedProperly(1, 20, "active");

//        testTranslation.checkWhetherSatBeamIsTranslatedToWebsiteSatellites(78);               // status of Sat in test 'any'
//        testTranslation.checkWhetherSatBeamDataIsTranslatedToExistingWebsiteSatellite(56);    // status of Sat in test 'any'
//        testTranslation.checkWhetherSatBeamListIsTranslatedToWebsiteSatellitesList(1, 608);   // status of Sat in test 'any'


    }
}