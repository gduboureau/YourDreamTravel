package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.Date;

public class DirectFlight implements Flight{

    private final String departure;
    private final String destination;
    private final int price;
    private final Date date;
    private final NameFlight nameFlight;

    public DirectFlight(String departure, String destination, int price, Date date, NameFlight nameFlight){
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.date = date;
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
    public Date getDate(){
        return date;
    }

    @Override
    public String getNameFlight(){
        return nameFlight.getNameFlight();
    }

}
