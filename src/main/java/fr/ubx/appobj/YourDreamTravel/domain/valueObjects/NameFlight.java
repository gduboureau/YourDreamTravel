package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.UUID;

public class NameFlight {
    
    private final String departure;
    private final String destination;
    private final UUID id;

    public NameFlight(String departure, String destination, UUID id){
        this.departure = departure;
        this.destination = destination;
        this.id = id;
    }

    public UUID getId(){
        return id;
    }

    public String getNameFlight(){
        return departure + " - " + destination + " / Flight: " + id;
    }
}
