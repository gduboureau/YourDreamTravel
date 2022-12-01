package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class IndirectFlight implements Flight{

    private final List<DirectFlight> directFlight;

    public IndirectFlight(){
        directFlight = new ArrayList<DirectFlight>();
    }

    public void AddFlight(DirectFlight flight){
        directFlight.add(flight);
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
    public String getDate(){
        String datesFlight = "";
        for (DirectFlight flight: directFlight){
            datesFlight += flight.getDate() + "\n";
        }
        return datesFlight;
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
