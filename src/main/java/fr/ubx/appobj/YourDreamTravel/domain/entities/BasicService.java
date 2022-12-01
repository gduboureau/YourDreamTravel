package main.java.fr.ubx.appobj.YourDreamTravel.domain.entities;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Hotel;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.RentalCar;

import java.util.UUID;

public class BasicService implements Service{

    private Hotel hotel;
    private RentalCar rentalCar;
    private final UUID id;

    public BasicService(Hotel hotel, RentalCar rentalCar, UUID id){
        this.hotel = hotel;
        this.rentalCar = rentalCar;
        this.id = id;
    }

    @Override
    public int getPrice() {
        int price = 0;
        if (hotel.getBenefit()){
            price += hotel.getPrice()*1.20;
        }else{
            price += hotel.getPrice();
        }
        if (rentalCar != null){
            price += rentalCar.getPrice();
        }
        return price;
    }

    @Override
    public UUID getId() {
        return id;
    }  

}
