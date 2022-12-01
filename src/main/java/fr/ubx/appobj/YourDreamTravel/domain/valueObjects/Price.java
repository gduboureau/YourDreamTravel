package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

public class Price {
    
    private final int number;
    private final String currency;

    public Price(int number, String currency){
        this.number = number;
        this.currency = currency;
    }

    public String getPrice(){
        return number + " " + currency;
    }
}
