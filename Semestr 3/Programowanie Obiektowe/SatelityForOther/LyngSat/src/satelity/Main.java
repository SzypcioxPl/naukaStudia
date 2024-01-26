package satelity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import LyngSat.LyngSat;
import KingOfSat.InsertIntoClass;
import KingOfSat.rapersc;
import satelity.WebsiteData.Satellite;
import satelity.WebsiteData.Satellite.Transmitter;
import SatBeam.SatBeam;
import SatBeam.SatBeamScraper;
import Tools.Merge;
import Tools.Serialization;


public class Main {


    public Main() {}

    public static void main(String[] args) throws Exception {
       
    	int counter = 0;
    	

    	/* Poniżej znajdują się try catch, gdzie można przetestować poszczególne scrapery */
    	
//    	 //LyngSat
//    	try {
//			// Self test
//			WebsiteData LyngSat = new LyngSat();
//    	
//    	
//			System.out.println("Found " + LyngSat.getSatellites().size() + " satellites.");
//			
////			counter = 0;
////			for(WebsiteData.Satellite sats : LyngSat.getSatellites()) {
////    		System.out.println(sats.toString());
////			counter++;
////    		}
////			System.out.println("Wypisano " + counter + " satelit z LyngSat");
//			
//		} catch (IOException e) {
//			System.out.println("LyngSat failed!");
//		}
//    	
//    	// KingOfSat
//    	try {
//			WebsiteData KingOfSat = new WebsiteData();
//    	
//    	
//    		InsertIntoClass GETKingOfSat = new InsertIntoClass();
//    		List<WebsiteData.Satellite> SatsKingOfSat = GETKingOfSat.getSatelitaList();
//    		KingOfSat.setSatellites((ArrayList<Satellite>) SatsKingOfSat);
////    		System.out.println(SatsKingOfSat.get(115).toString());
//    		
////    		counter = 0;
////    		for(WebsiteData.Satellite sats : KingOfSat.getSatellites()) {
////    			System.out.println(sats.toString());
////    			counter ++;
////    		}
////    		System.out.println("Wypisano " + counter + " satelit z KingOfSats");
//    		
//    	}catch(Exception er) {System.out.println("Blad w KingOfSat");}
//    	
//    	
//    	// SatBeam
//    	try {
//    		WebsiteData SatBeam = new SatBeamScraper();
//
//    		
////    		counter = 0;
////    		for(WebsiteData.Satellite sats : SatBeam.getSatellites()) {
////    			System.out.println(sats.toString());
////    			counter ++;
////    		}
////    		System.out.println("Wypisano " + counter + " satelit z SatBeam");
//    		
//    	}catch(Exception er) {System.out.println("Blad w SatBeam");}

    	//tu sterujemy
    	
    	// ----------| Żródło danych
    	boolean scrapowanie = false;
    	boolean wyswietlanieZPliku = true;
    	
    	// ----------| Czy zapisać do pliku .data, możliwe od razu po zescrapowania
    	boolean zapisDoPliku = false;
    	
    	// ----------| czy wyswietlić zescrapowane lub wczytane z pliku .data danych
    	boolean wyswietlanie = true;
    	
    	
    	// ----------| czy użyć funkcji porównujących dane satelit z SatBeam, LyngSat i SatBeam
    	boolean mergeDataNotIn = true;
    	boolean mergeDataFillSatInfo = true;
    	
    	// --------- Żródło internet(scrapowanie)
    	try {
    		//scrapowanie danych
    		if(scrapowanie) {
    			WebsiteData SatBeam = new SatBeamScraper();
        		
        		WebsiteData KingOfSat = new WebsiteData();
        		InsertIntoClass GETKingOfSat = new InsertIntoClass();
        		List<WebsiteData.Satellite> SatsKingOfSat = GETKingOfSat.getSatelitaList();
        		KingOfSat.setSatellites((ArrayList<Satellite>) SatsKingOfSat);
        		
        		WebsiteData LyngSat = new LyngSat();
        		
        		// serializacja danych
        		if(zapisDoPliku) {
        			Serialization.SerializeOutput(SatBeam, "satbeam");
        			Serialization.SerializeOutput(LyngSat, "lyngsat");
        			Serialization.SerializeOutput(KingOfSat, "kingofsat");
        		}
        		
        		// wyswietlanie danych
        		counter = 0;
        		if(wyswietlanie) {
            		for(WebsiteData.Satellite sats : SatBeam.getSatellites()) {
            			System.out.println("SatBeams "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		counter = 0;
            		for(WebsiteData.Satellite sats : LyngSat.getSatellites()) {
            			System.out.println("LyngSat "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		counter = 0;
            		for(WebsiteData.Satellite sats : KingOfSat.getSatellites()) {
            			System.out.println("KingOfSat "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		counter = 0;
        		}
        		
        		// listowanie satelit z KingOfSat i LyngSat, których nie ma w SatBeam
        		if(mergeDataNotIn){
        			ArrayList<WebsiteData.Satellite> LyngSatNotInSatBeam =  (ArrayList<Satellite>) Merge.listOfOtherSatNotInSatBeam(LyngSat.getSatellites(), SatBeam.getSatellites());
        			ArrayList<WebsiteData.Satellite> KingOfSatNotInSatBeam =  (ArrayList<Satellite>) Merge.listOfOtherSatNotInSatBeam(KingOfSat.getSatellites(), SatBeam.getSatellites());
        			
            		counter = 0;
            		for(WebsiteData.Satellite sats : LyngSatNotInSatBeam) {
            			System.out.println("LyngSatNotInSatBeam "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		
            		counter = 0;
            		for(WebsiteData.Satellite sats : KingOfSatNotInSatBeam) {
            			System.out.println("KingOfSatNotInSatBeam "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
        		}
        		
        		// uzupełnianie danych satelit z satbema o dane z satelit w LyngSat i KingOfSat
        		if(mergeDataFillSatInfo) {
        			List<WebsiteData.Satellite> SatBeamSatUpdated = Merge.mergeOtherSatToSatBeam(KingOfSat.getSatellites(),SatBeam.getSatellites(), "kingofsat");
        			SatBeamSatUpdated = Merge.mergeOtherSatToSatBeam(LyngSat.getSatellites(), SatBeam.getSatellites(), "lyngsat");
        			
            		counter = 0;
            		for(WebsiteData.Satellite sats : SatBeamSatUpdated) {
            			System.out.println("SatBeamSatUpdated "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
        		}
        		

    		}
    	}catch(Exception er) {
    		System.out.println("Bład w czasie scrapoania " + er);
    	}
    	
    	
    	// odczyt zserializowanych danych
    	
    	
    	
    	// --------- Żródło plik .data
    	try {
    		if(wyswietlanieZPliku) {
    			WebsiteData SatBeamF = Serialization.SerializeInput("satbeam");
    			WebsiteData LyngSatF = Serialization.SerializeInput("lyngsat");
    			WebsiteData KingOfSatF = Serialization.SerializeInput("kingofsat");
    			
        		// wyswietlanie danych
        		counter = 0;
        		if(wyswietlanie) {
            		for(WebsiteData.Satellite sats : SatBeamF.getSatellites()) {
            			System.out.println("SatBeams "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		counter = 0;
            		for(WebsiteData.Satellite sats : LyngSatF.getSatellites()) {
            			System.out.println("LyngSat "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		counter = 0;
            		for(WebsiteData.Satellite sats : KingOfSatF.getSatellites()) {
            			System.out.println("KingOfSat "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		counter = 0;
        		}
        		
        		// listowanie satelit z KingOfSat i LyngSat, których nie ma w SatBeam
        		if(mergeDataNotIn){
        			ArrayList<WebsiteData.Satellite> LyngSatNotInSatBeam =  (ArrayList<Satellite>) Merge.listOfOtherSatNotInSatBeam(LyngSatF.getSatellites(), SatBeamF.getSatellites());
        			ArrayList<WebsiteData.Satellite> KingOfSatNotInSatBeam =  (ArrayList<Satellite>) Merge.listOfOtherSatNotInSatBeam(KingOfSatF.getSatellites(), SatBeamF.getSatellites());
        			
            		counter = 0;
            		for(WebsiteData.Satellite sats : LyngSatNotInSatBeam) {
            			System.out.println("LyngSatNotInSatBeam "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
            		
            		counter = 0;
            		for(WebsiteData.Satellite sats : KingOfSatNotInSatBeam) {
            			System.out.println("KingOfSatNotInSatBeam "+counter+" : " + sats.getNames().get(0));
            			counter ++;
            		}
        		}
        		
        		// uzupełnianie danych satelit z satbema o dane z satelit w LyngSat i KingOfSat
        		if(mergeDataFillSatInfo) {
        			List<WebsiteData.Satellite> SatBeamSatUpdated = Merge.mergeOtherSatToSatBeam(KingOfSatF.getSatellites(), SatBeamF.getSatellites(), "kingofsat");
        			SatBeamSatUpdated = Merge.mergeOtherSatToSatBeam(LyngSatF.getSatellites(), SatBeamF.getSatellites(), "lyngsat");
        			
            		counter = 0;
            		for(WebsiteData.Satellite sats : SatBeamSatUpdated) {
            			System.out.println("SatBeamSatUpdated "+counter+" : " + sats.getNames().get(0));
//            			System.out.println(sats.toString());
            			counter ++;
            		}
        		}
    			
    		}
    			
    	}catch(Exception er) {
    		System.out.println("Bład w czasie odczytu z plikow " + er);
    	}
    	
    	
    }
}