package main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects;

public class Car {

    private final String brand;
    private final String motorization;
    private final int numberSeats;
    private final String carType;

    public Car(String brand, String motorization, int numberSeats, String carType){
        this.brand = brand;
        this.motorization = motorization;
        this.numberSeats = numberSeats;
        this.carType = carType;
    }

    public String getCar(){
        return "Brand: " + brand + "\nMotorization: " + motorization + "\nNumber of seats: " + numberSeats + "\nCar's type : " + carType;
    }
    
}
