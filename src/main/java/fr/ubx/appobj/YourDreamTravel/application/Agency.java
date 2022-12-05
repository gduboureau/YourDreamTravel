package main.java.fr.ubx.appobj.YourDreamTravel.application;

import java.util.HashMap;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.aggregates.Travel;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.*;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Flight;
import main.java.fr.ubx.appobj.YourDreamTravel.repository.DataTripInMemory;

public class Agency {
    
    private HashMap<String,Client> clients;
    private DataTripInMemory datas;

    public Agency(){
        clients = new HashMap<>();
        datas = new DataTripInMemory();
    }

    public DataTripInMemory getDatas(){
        return datas;
    }

    public void addClient(Client client){
        clients.put(client.getLastName(),client);
    }

    public HashMap<String,Client> getAllClients(){
        return clients;
    }

    public Client getClient(String lastName){
        return clients.get(lastName);
    }

    public Travel getTravel(UUID id){
        return datas.getTravel(id);
    }

    public void makeNewTravel(Client client, Service service, Flight flight, boolean premiumClass){
        Reservation reservation = new Reservation(UUID.randomUUID(), service, flight, premiumClass);
        Travel travel = new Travel(client, reservation);
        datas.saveTravel(client, travel);
    }

}
