package main.java.fr.ubx.appobj.YourDreamTravel.domain.entities;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.Hotel;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.RentalCar;

import java.util.UUID;

public class PremiumService implements Service{

    private Hotel hotelA;
    private Hotel hotelB;
    private RentalCar rentalCarA;
    private RentalCar rentalCarB;
    private final UUID id;

    public PremiumService(Hotel hotelA, Hotel hotelB, RentalCar rentalCarA, RentalCar rentalCarB, UUID id){
        this.hotelA = hotelA;
        this.hotelB = hotelB;
        this.rentalCarA = rentalCarA;
        this.rentalCarB = rentalCarB;
        this.id = id;
    }

    @Override
    public int getPrice() {
        int price = 0;
        if (hotelA.getBenefit()){
            price += hotelA.getPrice()*1.20;
        }else{
            price += hotelA.getPrice();
        }
        if (hotelB.getBenefit()){
            price += hotelB.getPrice()*1.20;
        }else{
            price += hotelB.getPrice();
        }
        if (rentalCarA != null){
            price += rentalCarA.getPrice();
        }
        if (rentalCarB != null){
            price += rentalCarB.getPrice();
        }
        return price;
    }

    @Override
    public UUID getId() {
        return id;
    }
    
}
