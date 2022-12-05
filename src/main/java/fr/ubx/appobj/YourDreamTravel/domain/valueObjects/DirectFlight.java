package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.ArrayList;
import java.util.Date;

public class DirectFlight implements Flight{

    private final String departure;
    private final String destination;
    private final int price;
    private final ArrayList<Date> dates;
    private final NameFlight nameFlight;
    

    public DirectFlight(String departure, String destination, int price, ArrayList<Date> dates, NameFlight nameFlight){
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.dates = dates;
        this.nameFlight = nameFlight;
    }

    @Override
    public String getDeparture(){
        return departure;
    }

    @Override
    public String getDestination(){
        return destination;
    }

    @Override
    public int getPrice(){
        return price;
    }

    @Override
    public ArrayList<Date> getDate(){ 
        return dates;
    }

    @Override
    public String getNameFlight(){
        return nameFlight.getNameFlight();
    }

    @Override
    public int hashCode(){
        return nameFlight.getId().hashCode();
    }

    @Override
    public boolean equals(Object object){
        DirectFlight directFlight = (DirectFlight) object;
        return this.nameFlight.getId().equals(directFlight.nameFlight.getId());
    }

}
