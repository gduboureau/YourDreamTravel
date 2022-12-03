package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.UUID;

public class RentalCar {
    
    private final Adress departure;
    private final Adress destination;
    private final int price;        //prix par jour
    private final Car car;
    private final UUID id;

    public RentalCar(Adress departure, Adress destination, int price, Car car, UUID id){
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.car = car;
        this.id = id;
    }

    public String getDeparture(){
        return departure.getAdress();
    }

    public String getDestination(){
        return destination.getAdress();
    }

    public int getPrice(){
        return price;
    }

    public String getCar(){
        return car.getCar();
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
        RentalCar rentalCar = (RentalCar) object;
        return this.id.equals(rentalCar.id);
    }
}
