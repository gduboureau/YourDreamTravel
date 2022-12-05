package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

import java.util.UUID;

public class Car {

    private final String brand;
    private final String motorization;
    private final int numberSeats;
    private final String carType;
    private final UUID id;

    public Car(String brand, String motorization, int numberSeats, String carType, UUID id){
        this.brand = brand;
        this.motorization = motorization;
        this.numberSeats = numberSeats;
        this.carType = carType;
        this.id = id;
    }

    public String getBrand(){
        return brand;
    }

    public String getCar(){
        return "Brand: " + brand + "\nMotorization: " + motorization + "\nNumber of seats: " + numberSeats + "\nCar's type : " + carType;
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object object){
        Car car = (Car) object;
        return this.id.equals(car.id);
    }
    
}
