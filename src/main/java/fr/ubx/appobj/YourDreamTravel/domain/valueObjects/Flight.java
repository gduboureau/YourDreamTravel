package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;
import java.util.Date;

public interface Flight{

    public String getDeparture();

    public String getDestination();

    public int getPrice();

    public Date getDate();

    public String getNameFlight();

}