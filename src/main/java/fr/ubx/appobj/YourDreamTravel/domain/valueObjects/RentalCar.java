package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

public class RentalCar {
    
    private final Adress departure;
    private final Adress destination;
    private final Price price;        //prix par jour
    private final Car car;

    public RentalCar(Adress departure, Adress destination, Price price, Car car){
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.car = car;
    }

    public String getDeparture(){
        return departure.getAdress();
    }

    public String getDestination(){
        return destination.getAdress();
    }

    public String getPrice(){
        return price.getPrice();
    }

    public String getCar(){
        return car.getCar();
    }

}
