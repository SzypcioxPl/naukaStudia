import OtherGroupsWork.LyngSat.LyngSat;
import OtherGroupsWork.Merge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeam;
import scraper.SatBeamScraper;
import scraper.WebsiteData;
import test.TestKingOfSat;
import test.TestTranslation;

import java.io.*;
import java.util.List;


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

//        try{
//            menu.startMenu();
//        }catch (Exception er){
//            main.error("Error: " + er.getMessage());
//        }

//        WebsiteData AllData = new WebsiteData();
//
        System.out.println("Scraping SatBeams");
        List<SatBeam> sats = scraper.ScrapeData(1,1, "any");
        List<WebsiteData.Satellite> satsSatBeam = scraper.SatBeamListToSatellites(sats);

        System.out.println("Scraping LyngSat");
        List<WebsiteData.Satellite> satsLyngSat = scraperLyngSat.ScrapeLyngSat();
//
////        satsLyngSat = merge.mergeSatBeamToLyngSat(satsSatBeam, satsLyngSat);
////        satsSatBeam = merge.mergeLyngSatToSatBeam(satsLyngSat,satsSatBeam);
//
        List<WebsiteData.Satellite> LyngSatNotInSatBeam = merge.listOfLyngSatNotInSatBeam(satsLyngSat, satsSatBeam);
//
////        for(WebsiteData.Satellite sat : satsLyngSat){
////            System.out.println(sat.toString());
////        }

        try{
//            //Serialization SatBeam
//            FileOutputStream satBeamFile = new FileOutputStream("SatBeam.data");
//            ObjectOutputStream satBeamOut = new ObjectOutputStream(satBeamFile);
//
//            satBeamOut.writeObject(satsSatBeam);
//
//            satBeamOut.close();
//            satBeamFile.close();
//            System.out.println("SatBeams has been serialized");

            //Serialization LyngSat
            FileOutputStream lyngSatFile = new FileOutputStream("LyngSat.data");
            ObjectOutputStream lyngSatOut = new ObjectOutputStream(lyngSatFile);

            lyngSatOut.writeObject(LyngSatNotInSatBeam);

            lyngSatOut.close();
            lyngSatFile.close();
            System.out.println("LyngSat has been serialized");

        }catch (Exception er){
            main.warn(er);
        }

        try{
//            //Deserialization SatBeam
//            FileInputStream satBeamFile = new FileInputStream("SatBeam.data");
//            ObjectInputStream satBeamIn = new ObjectInputStream(satBeamFile);
//
//            List<WebsiteData.Satellite> deSats = (List<WebsiteData.Satellite>)satBeamIn.readObject();
//
//            satBeamIn.close();
//            satBeamFile.close();
//
//            System.out.println("Object has been deserialized ");
//            for(WebsiteData.Satellite deSat : deSats){
//                System.out.println(deSat.toString());
//            }

            //Deserialization LyngSat
            FileInputStream lyngSatFile = new FileInputStream("LyngSat.data");
            ObjectInputStream lyngSatIn = new ObjectInputStream(lyngSatFile);

            List<WebsiteData.Satellite> deLyngSat = (List<WebsiteData.Satellite>)lyngSatIn.readObject();

            lyngSatIn.close();
            lyngSatFile.close();

            System.out.println("Object has been deserialized ");
            for(WebsiteData.Satellite deSat : deLyngSat){
                System.out.println(deSat.toString());
            }

        }catch (Exception er){
            main.warn(er);
        }







        main.info("End of program");

    }
}