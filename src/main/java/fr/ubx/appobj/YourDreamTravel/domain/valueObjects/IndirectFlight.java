package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndirectFlight implements Flight{

    private final List<DirectFlight> directFlight;

    public IndirectFlight(){
        directFlight = new ArrayList<DirectFlight>();
    }

    public void AddFlight(DirectFlight flight){
        directFlight.add(flight);
    }

    public String getEscaleWithIndex(int i){
        return directFlight.get(i).getDeparture();
    }

    @Override
    public String getDeparture(){
        return directFlight.get(0).getDeparture();
    }

    @Override
    public String getDestination(){
        return directFlight.get(directFlight.size()-1).getDestination();
    }

    @Override
    public int getPrice(){
        int totalPrice = 0;
        for (DirectFlight flight: directFlight){
            totalPrice += flight.getPrice();
        } 
        return totalPrice;
    }

    @Override
    public ArrayList<Date> getDate(){
        return directFlight.get(0).getDate();
    }

    @Override
    public String getNameFlight(){
        String namesFlight = directFlight.get(0).getNameFlight();
        for (int i = 1; i<directFlight.size(); i++ ){
            namesFlight += " -> " + directFlight.get(i).getNameFlight();
        }
        return namesFlight;
    }

}
