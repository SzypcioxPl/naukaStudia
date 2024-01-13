import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scraper.SatBeam;
import scraper.SatBeamScraper;
import scraper.WebsiteData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    protected static final Logger menu = LogManager.getLogger();
    public int startMenu() throws InterruptedException {

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

    public void scrapeMenu() throws InterruptedException {
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

    public void useScraper(int rangeStart, int rangeEnd, String status) throws InterruptedException {
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

    public void useData(List<WebsiteData.Satellite> SatelliteList) throws InterruptedException {
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
                    printSatBySetInfo(SatelliteList);
                    break;
                case 2:
                    int whichSat = 0;
                    String printAll = "no";

                    for(WebsiteData.Satellite sat: SatelliteList){
                        System.out.println(sat.toString());
                        whichSat++;
                        Thread.sleep(100);
                        if(printAll != "all"){
                            if(whichSat % 5 == 0){

                                System.out.print("Provide 'n' and click Enter to continue, and print next 5 Satellites or provide 'all' and click Enter to print all remaining Satellites. ");

                                String cont = "random";
                                Scanner scanner = new Scanner(System.in);
                                while(!cont.equals("n") && !cont.equals("all")) {
                                    System.out.print("\nProvide choice: ");
                                    cont = scanner.nextLine();
                                    if(cont.equals("all")){
                                        printAll = "all";
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    runUseDataMenu = false;
                    break;
            }

        }
    }

    public void printSatBySetInfo(List<WebsiteData.Satellite> SatelliteList){
        boolean getInfo = true;
        List<WebsiteData.Satellite> SortedSatList = new ArrayList<>();

        String name = "";
        int norad = 0;

        List<String> similarNames = new ArrayList<>();




        while (getInfo){
            getInfo = true;
            System.out.println("\n================= Choose type of sorting ================");
            System.out.println("  - 1: By name");
            System.out.println("  - 2: By norad");
//            System.out.println("  - 3: By operator");
//            System.out.println("  - 4: By launch site");
//            System.out.println("  - 5: Manufacturer");
//            System.out.println("  - 6: Orbital Position");

            int choice = -1;
            Scanner scanner = new Scanner(System.in);
            while(getInfo){
                try {
                    System.out.print("Choose: ");
                    choice = scanner.nextInt();
                    if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                        throw new Exception("Wrong value. Try again!\n");
                    }

                    getInfo = false;
                }catch (Exception er){
                    menu.warn("Error while choosing sort method: " + er);
                }
            }

            boolean runSort = true;
            switch (choice) {
                case 1:

                    while(runSort){
                        System.out.print("Type name: ");
                        name = scanner.next();

                        boolean nameExist = false;
                        for (WebsiteData.Satellite sat : SatelliteList){
                            if(sat.getNames().get(0).contains(name)){
                                SortedSatList.add(sat);
                                similarNames.add(sat.getNames().get(0));
                                nameExist = true;
                            }
                        }

                        boolean runNameChoose = true;
                        if(nameExist){
                            while(runNameChoose){
                                int whichName=0;
                                System.out.println("\nNames Similar to Given:");
                                System.out.println("   - -1"+": End Sort");

                                for(String tempName: similarNames){
                                    System.out.println("   - " + whichName + ": " + tempName);
                                    whichName++;
                                }


                                int choosedName = -1;
                                try{
                                    System.out.print("\nChoose sat: ");
                                    choosedName = scanner.nextInt();
                                }catch (Exception er){
                                    menu.warn("Error while choosing sat name");
                                }

                                if(Objects.equals(choosedName, -1)){
                                    runNameChoose = false;
                                }else {
                                    System.out.println(SortedSatList.get(choosedName).toString());
                                }

                                runSort = false;
                            }
                        }else {
                            System.out.println("There is no Satellite with name similar to provided.");
                        }
                    }



                    break;
                case 2:
                    System.out.print("Type Norad: ");
                    norad = scanner.nextInt();

                    boolean exist = false;
                    for (WebsiteData.Satellite sat : SatelliteList){
                        if(sat.getNorad() == norad){
                            System.out.print(sat.toString());
                            exist = true;
                        }
                    }
                    if(!exist){
                        System.out.print("There is no Sat with provided Norad");
                    }
                    break;
            }
        }

    }

}
