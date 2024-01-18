package OtherGroupsWork;

import scraper.WebsiteData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Merge {

    public List<WebsiteData.Satellite> mergeSatBeamToLyngSat(List<WebsiteData.Satellite> SatBeams, List<WebsiteData.Satellite> LyngSats){

        List <WebsiteData.Satellite> tempSatList = new ArrayList<>();
        int counter = 0;

        boolean updated = false;
        for(WebsiteData.Satellite LSat: LyngSats ){
            for(WebsiteData.Satellite SSats: SatBeams){
                if(SSats.getNames().getFirst().contains(LSat.getNames().getFirst())){
                    counter++;
                    updated = true;
                    //update norad
                    if(Objects.equals(LSat.getNorad(), 0)){
                        LSat.setNorad(SSats.getNorad());
                    }

                    // update operator
                    if(Objects.equals(LSat.getOperator(), null)){
                        LSat.setOperator(SSats.getOperator());
                    }

                    //update status
                    if(Objects.equals(LSat.getStatus(), null)){
                        LSat.setStatus(SSats.getStatus());
                    }

                    //update orbital position
                    if(Objects.equals(LSat.getOrbitalPosition(), 0.0)){
                        LSat.setOrbitalPosition(SSats.getOrbitalPosition());
                    }

                    // update launch date
                    if(Objects.equals(LSat.getLaunchDate(), null)){
                        LSat.setLaunchDate(SSats.getLaunchDate());
                    }

                    // update launch site
                    if(Objects.equals(LSat.getLaunchSite(), null)){
                        LSat.setLaunchSite(SSats.getLaunchSite());
                    }

                    // update launch mass
                    if(Objects.equals(LSat.getLaunchMass(), 0.0)){
                        LSat.setLaunchMass(SSats.getLaunchMass());
                    }

                    // update launch vehicle
                    if(Objects.equals(LSat.getLaunchVehicle(), null)){
                        LSat.setLaunchVehicle(SSats.getLaunchVehicle());
                    }

                    // update satellite manufacturer
                    if(Objects.equals(LSat.getSatelliteManufacturer(), null)){
                        LSat.setSatelliteManufacturer(SSats.getSatelliteManufacturer());
                    }

                    // update satellite model
                    if(Objects.equals(LSat.getSatelliteModel(), null)){
                        LSat.setSatelliteModel(SSats.getSatelliteModel());
                    }

                    // update satellite expected lifetime
                    if(Objects.equals(LSat.getSatelliteExpectedLifetime(), null)){
                        LSat.setSatelliteExpectedLifetime(SSats.getSatelliteExpectedLifetime());
                    }

                    try {
                        //update transmiters
                        if(!(Objects.equals(SSats.getTransmitters(), null)) &&(Objects.equals(LSat.getTransmitters(), null) || LSat.getTransmitters().size() < SSats.getTransmitters().size())){
                            for(WebsiteData.Satellite.Transmitter transmitter : SSats.getTransmitters()){
                                LSat.addTransmitter(transmitter);
                            }
                        }
                    }catch (Exception er){
                       System.out.println(er);
                    }

                    System.out.println("\nMerged Sat wit name:" + LSat.getNames().getFirst() + "\n");
                    tempSatList.add(LSat);
//                    break;
                }
            }

        }
        System.out.println("Updated data of " + counter + " satellites from LyngSat :)" );

        return tempSatList;
    }

    public List<WebsiteData.Satellite> mergeLyngSatToSatBeam(List<WebsiteData.Satellite> LyngSats, List<WebsiteData.Satellite> SatBeams){

        List <WebsiteData.Satellite> tempSatList = new ArrayList<>();
        int counter = 0;
        boolean update= false;

        for(WebsiteData.Satellite SSat: SatBeams){
            update = false;
            for(WebsiteData.Satellite LSat: LyngSats ){
                if(LSat.getNames().getFirst().contains(SSat.getNames().getFirst())){


                    // update actual position
                    if(Objects.equals(SSat.getActualPosition(), 0.0) && !Objects.equals(LSat.getActualPosition(), 0.0)){
                        SSat.setActualPosition(LSat.getActualPosition());
                        update = true;
                    }

                    try {
                        //update transmiters
                        if((Objects.equals(SSat.getTransmitters(), null)) && !Objects.equals(LSat.getTransmitters(), null)){
                            for(WebsiteData.Satellite.Transmitter transmitter : LSat.getTransmitters()){
                                if(!Objects.equals(transmitter.getTransponder(), null)) {
                                    LSat.addTransmitter(transmitter);
                                    update = true;
                                }
                            }
                        }
                    }catch (Exception er){
                        System.out.println(er);
                    }



                    System.out.println("Merged Sat with name:" + SSat.getNames().getFirst()); // for change, like counter
//                    System.out.println(SSat.toString());    // testing
                    tempSatList.add(SSat);
                    if (update){
                        update = false;
                        counter++;
                    }
                    break;
                }
            }

        }
        System.out.println("Updated data of " + counter + " satellites from SatBeam :)" );

        return tempSatList;
    }

    public List<WebsiteData.Satellite> listOfLyngSatNotInSatBeam(List<WebsiteData.Satellite> LyngSats, List<WebsiteData.Satellite> SatBeams){

        List <WebsiteData.Satellite> tempSatList = new ArrayList<>();
        int counter = 0;
        boolean inSatBeam = false;

        for(WebsiteData.Satellite LSat: LyngSats){
            inSatBeam = false;

            for(WebsiteData.Satellite SSat: SatBeams ){

                // if LyngSat exist in SatBeam go to next LyngSat
                // check by sat name
                if(SSat.getNames().getFirst().contains(LSat.getNames().getFirst())){
                    inSatBeam = true;
                    break;
                }
            }

            // if LyngSat didn't exist in SatBeam add to list
            if(Objects.equals(inSatBeam, false)){
                counter++;
                System.out.println(LSat.getNames().getFirst());
                tempSatList.add(LSat);
            }
            inSatBeam = false;

        }
        System.out.println("\nCount of LyngSat not in SatBeam " + counter + " satellites\n" );

        return tempSatList;
    }

}
