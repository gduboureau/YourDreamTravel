package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

public class Adress {
    
    private final int number;
    private final String street;
    private final String city;
    public final String country;

    public Adress(int number, String street, String city, String country){
        this.number = number;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getAdress(){
        return number + " " + street + ", " + city + ", " + country;
    }

}
