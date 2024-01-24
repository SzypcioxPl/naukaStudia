package Tools;

import satelity.WebsiteData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Merge {

    public static List<WebsiteData.Satellite> mergeSatBeamToOtherSat(List<WebsiteData.Satellite> SatBeams, List<WebsiteData.Satellite> OtherSats){

        List <WebsiteData.Satellite> tempSatList = new ArrayList<>();
        int counter = 0;

        boolean updated = false;
        for(WebsiteData.Satellite OSat: OtherSats ){
            for(WebsiteData.Satellite SSat: SatBeams){
                if(SSat.getNames().get(0).contains(OSat.getNames().get(0))){
                    counter++;
                    updated = true;
                    //update norad
                    if(Objects.equals(OSat.getNorad(), 0)){
                        OSat.setNorad(SSat.getNorad());
                    }

                    // update operator
                    if(Objects.equals(OSat.getOperator(), null)){
                        OSat.setOperator(SSat.getOperator());
                    }

                    //update status
                    if(Objects.equals(OSat.getStatus(), null)){
                        OSat.setStatus(SSat.getStatus());
                    }

                    //update orbital position
                    if(Objects.equals(OSat.getOrbitalPosition(), 0.0F)){
                        OSat.setOrbitalPosition(SSat.getOrbitalPosition());
                    }

                    //update actual position
                    if(Objects.equals(OSat.getActualPosition(), 0.0F)){
                        OSat.setActualPosition(SSat.getActualPosition());
                    }

                    // update launch date
                    if(Objects.equals(OSat.getLaunchDate(), null)){
                        OSat.setLaunchDate(SSat.getLaunchDate());
                    }

                    // update launch site
                    if(Objects.equals(OSat.getLaunchSite(), null)){
                        OSat.setLaunchSite(SSat.getLaunchSite());
                    }

                    // update launch mass
                    if(Objects.equals(OSat.getLaunchMass(), 0.0)){
                        OSat.setLaunchMass(SSat.getLaunchMass());
                    }

                    // update launch vehicle
                    if(Objects.equals(OSat.getLaunchVehicle(), null)){
                        OSat.setLaunchVehicle(SSat.getLaunchVehicle());
                    }

                    // update satellite manufacturer
                    if(Objects.equals(OSat.getSatelliteManufacturer(), null)){
                        OSat.setSatelliteManufacturer(SSat.getSatelliteManufacturer());
                    }

                    // update satellite model
                    if(Objects.equals(OSat.getSatelliteModel(), null)){
                        OSat.setSatelliteModel(SSat.getSatelliteModel());
                    }

                    // update satellite expected lifetime
                    if(Objects.equals(OSat.getSatelliteExpectedLifetime(), null)){
                        OSat.setSatelliteExpectedLifetime(SSat.getSatelliteExpectedLifetime());
                    }

                    try {
                        //update transmiters
                        if(!Objects.equals(SSat.getTransmitters(), null) ){
                            for(WebsiteData.Satellite.Transmitter transmitter : SSat.getTransmitters()){
                                if(!Objects.equals(transmitter, null)){
                                    String newName = (!Objects.equals(transmitter.getTransponder(), null)?(transmitter.getTransponder()+"(SatBeam)"):"(SatBeam)");
                                    transmitter.setTransponder(newName);
                                    OSat.addTransmitter(transmitter);
                                }
                            }
                        }
                    }catch (Exception er){
                       System.out.println(er);
                    }

                    System.out.println("Merged Sat with name: \n" +
                            "   Name: " + OSat.getNames().get(0) + " = "+ SSat.getNames().get(0)+ "\n" +
                            "   Norad: " + OSat.getNorad() + " = " + SSat.getNorad());
                    tempSatList.add(OSat);
//                    break;
                }
            }

        }
        System.out.println("Updated data of " + counter + " satellites :)" );

        // list of updated sats
        return tempSatList;
    }

    public static List<WebsiteData.Satellite> mergeOtherSatToSatBeam(List<WebsiteData.Satellite> OtherSats, List<WebsiteData.Satellite> SatBeams, String fromWhichSite){

        List <WebsiteData.Satellite> tempSatList = new ArrayList<>();
        int counter = 0;
        boolean update= false;

        for(WebsiteData.Satellite SSat: SatBeams){
            update = false;
            for(WebsiteData.Satellite OSat: OtherSats ){
                if(Objects.equals(SSat.getNorad(), OSat.getNorad()) || OSat.getNames().get(0).contains(SSat.getNames().get(0))){

                    // update actual position
                    if(!Objects.equals(OSat.getActualPosition(), 0.0) && !Objects.equals(OSat.getActualPosition(), null)){
                        SSat.setActualPosition(OSat.getActualPosition());
                        update = true;
                    }

                    try {
                        if(!Objects.equals(OSat.getTransmitters(), null)){
                            for(WebsiteData.Satellite.Transmitter transmitter : OSat.getTransmitters()){

                                if(!Objects.equals(transmitter, null)){
                                    String newName = (!Objects.equals(transmitter.getTransponder(), null)?transmitter.getTransponder()+" ("+fromWhichSite.toUpperCase()+")":"("+fromWhichSite.toUpperCase()+")");
                                    transmitter.setTransponder(newName);
                                    SSat.addTransmitter(transmitter);
                                }
                                update = true;
                            }
                        }
                    }catch (Exception er){
                        System.out.println("Can't update transmitters for " + OSat.getNames().get(0) + ": " + er.getMessage());
                    }

                    tempSatList.add(SSat);
                    if (update){
                        // for test
//                        System.out.println("Merged Sat with name: \n" +
//                                "   Name: " + OSat.getNames().getFirst() + " = "+ SSat.getNames().getFirst()+ "\n" +
//                                "   Norad: " + OSat.getNorad() + " = " + SSat.getNorad());
//                    System.out.println(SSat.toString());    // testing

                        counter++;
                    }
                    break;
                }
            }
            if(!update){
                tempSatList.add(SSat);
            }
        }
        System.out.println("Updated data of " + counter + " satellites from SatBeam :)" );

        return tempSatList;
    }

    public static List<WebsiteData.Satellite> listOfOtherSatNotInSatBeam(List<WebsiteData.Satellite> OtherSats, List<WebsiteData.Satellite> SatBeams){

        List <WebsiteData.Satellite> tempSatList = new ArrayList<>();
        int counter = 0;
        boolean inSatBeam = false;

        for(WebsiteData.Satellite OSat: OtherSats){
            inSatBeam = false;

            for(WebsiteData.Satellite SSat: SatBeams ){

                // if OtherSat exist in SatBeam go to next OtherSat
                // check by sat name
            	try {
            		if(Objects.equals(SSat.getNorad(), OSat.getNorad()) || SSat.getNames().get(0).contains(OSat.getNames().get(0))){
                        inSatBeam = true;
                        break;
                    }
            	}catch(Exception er) {System.out.println("Blad przy sprawdzaniu czy nazwy sie zgadzaja");}
                
            }

            // if OtherSat didn't exist in SatBeam add to list
            if(Objects.equals(inSatBeam, false)){
                counter++;
//                System.out.println(OSat.getNames().getFirst());
                tempSatList.add(OSat);
            }
        }
        System.out.println("Count of sats not in SatBeam " + counter + " satellites" );

        return tempSatList;
    }



}
