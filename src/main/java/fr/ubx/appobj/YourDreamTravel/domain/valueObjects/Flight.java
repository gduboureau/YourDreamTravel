package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;
import java.util.Date;

public class Flight{

    private final String departure;
    private final String destination;
    private final Price price;
    private final Date date;
    private final NameFlight nameFlight;

    public Flight(String departure, String destination, Price price, Date date, NameFlight nameFlight){
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.date = date;
        this.nameFlight = nameFlight;
    }

    public String getDeparture(){
        return departure;
    }

    public String getDestination(){
        return destination;
    }

    public String getPrice(){
        return price.getPrice();
    }

    public Date getDate(){
        return date;
    }

    public String getNameFlight(){
        return nameFlight.getNameFlight();
    }

}