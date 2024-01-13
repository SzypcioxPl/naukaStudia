import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeamScraper;
import test.TestKingOfSat;
import test.TestTranslation;

import javax.swing.*;
import java.awt.*;

public class Main {

    protected static final Logger main = LogManager.getLogger();

    private static SatBeamScraper scraper = new SatBeamScraper();

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

        main.info("End of program");

    }
}