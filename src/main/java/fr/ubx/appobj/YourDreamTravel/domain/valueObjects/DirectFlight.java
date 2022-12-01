package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public String getDate(){ 
        DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm"); //Thu, 01 Dec 2022 13:30
        return dateFormat.format(date);
    }

    @Override
    public String getNameFlight(){
        return nameFlight.getNameFlight();
    }

}
