package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.ArrayList;
import java.util.Date;

public interface Flight{

    public String getDeparture();

    public String getDestination();

    public int getPrice();

    public ArrayList<Date> getDate();

    public String getNameFlight();

}