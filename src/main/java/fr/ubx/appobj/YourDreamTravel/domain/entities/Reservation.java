package main.java.fr.ubx.appobj.YourDreamTravel.domain.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Flight;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Hotel;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.RentalCar;

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
        if (service != null){
            info += ("\nVotre voyage comprend également des services :");
            if (service instanceof BasicService){
                Hotel hotel = ((BasicService) service).getHotel();
                RentalCar rentalCar = ((BasicService) service).getRentalCar();
                info += ("\nVous logerez dans l'hôtel " + hotel.getName() + " dont l'adresse est " + hotel.getAdress().getAdress());
                info += ("\nVous avez également loué une voiture : \n" + rentalCar.getCar());
                info += ("\n\nLe prix total de votre projet est de "+getFinalPrice());
            }
            if (service instanceof PremiumService){
                Hotel hotelA = ((PremiumService) service).getHotelA();
                Hotel hotelB = ((PremiumService) service).getHotelB();
                RentalCar rentalCarA = ((PremiumService) service).getRentalCarA();
                RentalCar rentalCarB = ((PremiumService) service).getRentalCarB();
                info += ("\nVous logerez dans le premier hôtel " + hotelA.getName() + " dont l'adresse est " + hotelA.getAdress().getAdress());
                info += ("\nPuis vous logerez dans le deuxième hôtel " + hotelB.getName() + " dont l'adresse est " + hotelB.getAdress().getAdress());
                info += ("\nVous avez également loué une voiture pour aller du premier au deuxième hôtel : \n" + rentalCarA.getCar());
                info += ("\nVous avez également loué une voiture pour le deuxième hôtel : \n" + rentalCarB.getCar());
                info += ("\n\nLe prix total de votre projet est de "+getFinalPrice());
            }

        }
        return info;
    }
}
