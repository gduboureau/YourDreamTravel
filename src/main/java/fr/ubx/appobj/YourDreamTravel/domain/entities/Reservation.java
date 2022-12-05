package main.java.fr.ubx.appobj.YourDreamTravel.domain.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Flight;

public class Reservation {
    
    private final UUID id;
    private Service service;
    private Flight flight;
    private Date dateDepartureFilght;
    private Boolean premiumClass;

    public Reservation(UUID id, Service service, Date dateDepartureFilght, Flight flight, Boolean premiumClass){
        this.id = id;
        this.service = service;
        this.dateDepartureFilght = dateDepartureFilght;
        this.flight = flight;
        this.premiumClass = premiumClass;
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

    public Date getDateDepartureFilght(){
        return dateDepartureFilght;
    }

    public void setService(Service service){
        this.service = service;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public void setDateDepartureFilght(Date dateDepartureFilght){
        this.dateDepartureFilght = dateDepartureFilght;
    }
    
    public int getFinalPrice(){
        int finalPrice = 0;
        if (service != null){
            finalPrice += service.getPrice();
        }
        if (premiumClass){
            finalPrice += flight.getPrice()*1.30;
        }else{
            finalPrice += flight.getPrice();
        }
        return finalPrice;
    }

    public String getInformations(){
        DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm");
        float tmp = 1;
        String info = ("Le vol " + getFlight().getNameFlight());
        info += ("\nDépart de " + getFlight().getDeparture());
        info += ("\nA destination de " + getFlight().getDestination());
        info += ("\nLe " + dateFormat.format(dateDepartureFilght));
        if (premiumClass){
            info += ("\nAvec option 1ère classe");
            tmp += 0.30;
        }
        info += ("\nPour un prix total du billet à " + (getFlight().getPrice()*tmp));
        return info;
    }
}
