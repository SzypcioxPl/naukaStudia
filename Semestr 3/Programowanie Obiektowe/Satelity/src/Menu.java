import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeam;
import scraper.SatBeamScraper;
import scraper.WebsiteData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    protected static final Logger menu = LogManager.getLogger();
    public int startMenu(){

        boolean run = true;
        boolean runMainChoice = true;
        while(run){


                System.out.println("===================== Satellites Project Menu ==========");
                System.out.println("Choose action ");
                System.out.println("  - 1: Scrape Data");
                System.out.println("  - 2: End Program");


            int choice = -1;
            while(runMainChoice){
                System.out.print("Choose: ");
                try{
                    Scanner scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                    if(choice != 1 && choice !=2){
                        throw new Exception("Wrong value. Try again!\n");
                    }

                    runMainChoice = false;
                }catch (Exception er){
                    menu.warn(er.getMessage());
                }
            }


            switch (choice) {
                case 1:
                    run = false;
                    scrapeMenu();
                    break;
                case 2:
                    return 0;
            }

        }

        return 0;
    }

    public void scrapeMenu(){
        boolean runScraperMenu = true;
        int rangeStart = 0;
        int rangeEnd = 0;
        String status = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===================== Set Options For Scraper ==========");
        while(runScraperMenu){
            System.out.print("Range Start (ID of first Sat to scrap; min 1): ");
            try{
                rangeStart = scanner.nextInt();

                if(rangeStart <= 0 || rangeStart >= 609) {
                    throw new Exception("Start of range must be between 1 and 608");
                }
                runScraperMenu = false;
            }catch (Exception er){
                menu.warn(er.getMessage());
            }
        }

        runScraperMenu = true;
        while(runScraperMenu){
            System.out.print("Range End (ID of last Sat to scrap; max 608): ");
            try{
                rangeEnd = scanner.nextInt();

                if(rangeEnd > 609 || rangeEnd <= rangeStart-1){
                    throw new Exception("End of range must be between " + rangeStart + " and 608");
                }
                runScraperMenu = false;
            }catch (Exception er){
                menu.warn(er.getMessage());
            }
        }

        runScraperMenu = true;
        while(runScraperMenu){
            System.out.print("Status(any, active, deorbited, failed, retired) ");
            System.out.print("Status (Info about Sats current condition): ");
            try{
                status = scanner.next();

                if(!status.contains("active") && !status.contains("deorbited") && !status.contains("retired") && !status.contains("failed") && !status.contains("any")){
                    throw new Exception("Provided wrong type of status");
                }
                runScraperMenu = false;
            }catch (Exception er){
                menu.warn(er.getMessage());
            }
        }

        runScraperMenu = false;

//        System.out.println("Chooses");
//        System.out.println("Chooses 1: " + rangeStart);
//        System.out.println("Chooses 2: " + rangeEnd);
//        System.out.println("Chooses 3: " + status);

        useScraper(rangeStart, rangeEnd, status);
    }

    public void useScraper(int rangeStart, int rangeEnd, String status){
        SatBeamScraper scraper = new SatBeamScraper();
        List<SatBeam> SatBeamList = new ArrayList<>();
        List<WebsiteData.Satellite> SatelliteList = new ArrayList<>();

        System.out.println("\n");
        try {
            SatBeamList = scraper.ScrapeData(rangeStart, rangeEnd, status);
            SatelliteList = scraper.SatBeamListToSatellites(SatBeamList);
        }catch (Exception er){
            menu.warn("Error in useScraper: " + er);
        }

        useData(SatelliteList);
    }

    public void useData(List<WebsiteData.Satellite> SatelliteList){
        boolean runUseDataMenu = true;
        boolean runUseDataChoice = true;

        while(runUseDataMenu){
            runUseDataChoice = true;
            System.out.println("\n================== Choose what to do with data ==========");
            System.out.println("\nChoose action ");
            System.out.println("  - 1: Print Sat's In Reagard To Given Info");
            System.out.println("  - 2: Print All Sat's");
            System.out.println("  - 3: End Program");

            int choice = -1;
            while(runUseDataChoice) {
                System.out.print("Choose: ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                    if (choice != 1 && choice != 2 && choice != 3) {
                        throw new Exception("Wrong value. Try again!\n");
                    }

                    runUseDataChoice = false;
                } catch (Exception er) {
                    menu.warn(er.getMessage());
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Satellite One");
                    printSatBySetInfo();
                    break;
                case 2:
                    for(WebsiteData.Satellite sat: SatelliteList){
                        System.out.println(sat.toString());
                    }
                    break;
                case 3:
                    runUseDataMenu = false;
                    break;
            }

        }
    }

    public void printSatBySetInfo(){
        boolean getInfo = true;

        System.out.println("Work in progress!");

    }

}
