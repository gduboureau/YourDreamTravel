package main.java.fr.ubx.appobj.YourDreamTravel.domain.aggregates;

import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.Client;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.Reservation;

public class Travel {
    
    private final UUID id;
    private Client client;
    private Reservation reservation;

    public Travel(Client client, Reservation reservation){
        id = UUID.randomUUID();
        this.client = client;
        this.reservation = reservation;
    }

    public Client getClient(){
        return client;
    }

    public Reservation getReservation(){
        return reservation;
    }

    public UUID getId(){
        return id;
    }
}
