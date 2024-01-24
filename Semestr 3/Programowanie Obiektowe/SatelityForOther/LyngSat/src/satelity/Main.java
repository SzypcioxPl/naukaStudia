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


public class Main {


    public Main() {}

    public static void main(String[] args) throws Exception {
       
    	int counter = 0;
    	
    	// odkomentuj try catche
    	
    	
    	 //LyngSat
    	try {
			// Self test
			WebsiteData LyngSat = new LyngSat();
    	
    	
			System.out.println("Found " + LyngSat.getSatellites().size() + " satellites.");
			
//			counter = 0;
//			for(WebsiteData.Satellite sats : LyngSat.getSatellites()) {
//    		System.out.println(sats.toString());
//			counter++;
//    		}
//			System.out.println("Wypisano " + counter + " satelit z LyngSat");
			
		} catch (IOException e) {
			System.out.println("LyngSat failed!");
		}
    	
    	// KingOfSat
    	try {
			WebsiteData KingOfSat = new WebsiteData();
    	
    	
    		InsertIntoClass GETKingOfSat = new InsertIntoClass();
    		List<WebsiteData.Satellite> SatsKingOfSat = GETKingOfSat.getSatelitaList();
    		KingOfSat.setSatellites((ArrayList<Satellite>) SatsKingOfSat);
//    		System.out.println(SatsKingOfSat.get(115).toString());
    		
//    		counter = 0;
//    		for(WebsiteData.Satellite sats : KingOfSat.getSatellites()) {
//    			System.out.println(sats.toString());
//    			counter ++;
//    		}
//    		System.out.println("Wypisano " + counter + " satelit z KingOfSats");
    		
    	}catch(Exception er) {System.out.println("Blad w KingOfSat");}
    	
    	
    	// SatBeam
    	try {
    		WebsiteData SatBeam = new SatBeamScraper();
    		
//    		counter = 0;
//    		for(WebsiteData.Satellite sats : SatBeam.getSatellites()) {
//    			System.out.println(sats.toString());
//    			counter ++;
//    		}
//    		System.out.println("Wypisano " + counter + " satelit z SatBeam");
    		
    	}catch(Exception er) {System.out.println("Blad w SatBeam");}

    }
}