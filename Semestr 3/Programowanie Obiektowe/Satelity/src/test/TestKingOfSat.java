package test;

import OtherGroupsWork.KingOfSats.InsertIntoClass;
import OtherGroupsWork.KingOfSats.rapersc;
import scraper.WebsiteData;

import java.util.ArrayList;

import static OtherGroupsWork.KingOfSats.InsertIntoClass.extractData;

public class TestKingOfSat {

    public void testScraperKingOfSat(){
        rapersc scraper = new rapersc();
        InsertIntoClass toWebsiteData = new InsertIntoClass();

        ArrayList<ArrayList<String>> data1 = scraper.getscrapedDataMain();
//        System.out.println(data1);
        ArrayList<ArrayList<ArrayList<String>>> data2 = scraper.getscrapedDataInSat();
//        System.out.println(data2);



        ArrayList<WebsiteData.Satellite> SatList =  toWebsiteData.extractData();
        toWebsiteData.extractTransmitterData();

        for(WebsiteData.Satellite sat : SatList){
            System.out.println(sat);
        }




    }

}
