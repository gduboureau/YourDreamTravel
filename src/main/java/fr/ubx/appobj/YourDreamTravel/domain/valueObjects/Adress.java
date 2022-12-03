package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.UUID;

public class Adress {
    
    private final int number;
    private final String street;
    private final String city;
    public final String country;
    private final UUID id;

    public Adress(int number, String street, String city, String country, UUID id){
        this.number = number;
        this.street = street;
        this.city = city;
        this.country = country;
        this.id = id;
    }

    public String getAdress(){
        return number + " " + street + ", " + city + ", " + country;
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object object){
        Adress adress = (Adress) object;
        return this.id.equals(adress.id);
    }

}
