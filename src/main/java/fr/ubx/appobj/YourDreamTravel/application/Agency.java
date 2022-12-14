package main.java.fr.ubx.appobj.YourDreamTravel.application;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.aggregates.Travel;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.*;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Flight;
import main.java.fr.ubx.appobj.YourDreamTravel.repository.DataTripInMemory;

public class Agency {
    
    private HashMap<String,Client> clients;
    private DataTripInMemory datas;
    private Map<String,Integer> poolTickets;

    public Agency(){
        clients = new HashMap<>();
        datas = new DataTripInMemory();
        poolTickets = new HashMap<String,Integer>();
        initializePoolTickets();
    }

    public void initializePoolTickets(){
        poolTickets.put("Paris", 70);
        poolTickets.put("Bordeaux", 70);
        poolTickets.put("Camberra", 70);
        poolTickets.put("Tokyo", 70);
        poolTickets.put("Delhi", 70);
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

    public void makeNewTravel(Client client, Service service, Date dateDepartureFilght, Flight flight, boolean premiumClass){
        String destination = flight.getDestination();
        Reservation reservation = null;
        if (poolTickets.get(destination) > 0 ){
            reservation = new Reservation(UUID.randomUUID(), service, dateDepartureFilght, flight, premiumClass, true);
        }else{
            reservation = new Reservation(UUID.randomUUID(), service, dateDepartureFilght, flight, premiumClass, false);
        }
        poolTickets.put(destination,poolTickets.get(destination) - 1);
        Travel travel = new Travel(client, reservation);
        datas.saveTravel(client, travel);
    }

}
