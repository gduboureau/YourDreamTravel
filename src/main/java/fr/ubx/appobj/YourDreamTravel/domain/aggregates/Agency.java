package main.java.fr.ubx.appobj.YourDreamTravel.domain.aggregates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.Client;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.Reservation;

public class Agency {
    
    private final UUID id;
    private HashMap<String,Client> clients;
    private ArrayList<Reservation> reservations;

    public Agency(){
        id = new UUID(10, 10);
        clients = new HashMap<>();
        reservations = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.put(client.getLastName(),client);
    }

    public Client getClient(String lastName){
        return clients.get(lastName);
    }

    public void removeClient(String lastName){
        clients.remove(lastName);
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    public UUID getId(){
        return id;
    }
}
