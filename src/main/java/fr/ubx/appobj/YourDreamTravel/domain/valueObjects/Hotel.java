package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.UUID;

public class Hotel {
    
    private final String name;
    private final int price;
    private final Adress adress;
    private final UUID id;    

    public Hotel(String name, int price, Adress adress, UUID id){
        this.name = name;
        this.price = price;
        this.adress = adress;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public Adress getAdress(){
        return adress;
    }

    public UUID getId(){
        return id;
    }
    
    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object object){
        Hotel hotel = (Hotel) object;
        return this.id.equals(hotel.id);
    }
}
