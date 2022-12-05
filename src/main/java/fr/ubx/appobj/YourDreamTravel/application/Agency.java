package main.java.fr.ubx.appobj.YourDreamTravel.application;

import java.util.ArrayList;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.aggregates.Travel;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.*;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Flight;
import main.java.fr.ubx.appobj.YourDreamTravel.repository.DataTripInMemory;

public class Agency {
    
    private ArrayList<Client> clients;
    private DataTripInMemory datas;

    public Agency(){
        clients = new ArrayList<>();
        datas = new DataTripInMemory();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public ArrayList<Client> getAllClients(){
        return clients;
    }

    public Travel getTravel(UUID id){
        return datas.getTravel(id);
    }

    public void makeNewTravel(Client client, Service service, Flight flight, boolean premiumClass){
        Reservation reservation = new Reservation(UUID.randomUUID(), service, flight, client, premiumClass);
        Travel travel = new Travel(client, reservation);
        datas.saveTravel(travel);
    }

}
