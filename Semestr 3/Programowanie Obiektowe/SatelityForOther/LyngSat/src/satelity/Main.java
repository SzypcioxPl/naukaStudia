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
    	boolean scrapowanie = false;
    	boolean zapisDoPliku = false;
    	
    	
    	boolean wyswietlanie = true;
    	
    	boolean wyswietlanieZPliku = true;
    	
    	
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
        		
    		}
    	}catch(Exception er) {
    		System.out.println("Bład w czasie scrapoania " + er);
    	}
    	
    	
    	// odczyt zserializowanych danych
    	
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
    			
    		}
    			
    	}catch(Exception er) {
    		System.out.println("Bład w czasie odczytu z plikow " + er);
    	}
    	
    	
    }
}