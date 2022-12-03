package main.java.fr.ubx.appobj.YourDreamTravel.domain.entities;

import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Flight;

public class Reservation {
    
    private final UUID id;
    private Service service;
    private Flight flight;
    private Client client;

    public Reservation(UUID id, Service service, Flight flight, Client client){
        this.id = id;
        this.service = service;
        this.flight = flight;
        this.client = client;
    }

    public UUID getID(){
        return id;
    }

    public Service getService(){
        return service;
    }

    public Flight getFlight(){
        return flight;
    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public void setService(Service service){
        this.service = service;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }
    
    public int getFinalPrice(){
        int finalPrice = 0;
        if (service != null){
            finalPrice += service.getPrice();
        }
        finalPrice += flight.getPrice();
        return finalPrice;
    }
}
