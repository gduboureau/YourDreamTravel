package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.UUID;

public class Hotel {
    
    private final String name;
    private final int price;
    private final Adress adress;
    private final UUID id;
    private final Boolean benefit;

    public Hotel(String name, int price, Adress adress, UUID id, Boolean benefit){
        this.name = name;
        this.price = price;
        this.adress = adress;
        this.id = id;
        this.benefit = benefit;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public String getAdress(){
        return adress.getAdress();
    }

    public UUID getId(){
        return id;
    }

    public Boolean getBenefit(){
        return benefit;
    }
    
}
