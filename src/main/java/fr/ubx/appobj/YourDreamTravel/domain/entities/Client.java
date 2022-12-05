package main.java.fr.ubx.appobj.YourDreamTravel.domain.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Client {
    
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private final UUID id;


    public Client(String firstName, String lastName, String gender, Date birthday, UUID id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.id = id;
    }

    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }
    
    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    public void setGender(String newGender){
        this.gender = newGender;
    }

    public void setBirthday(Date newBirthday){
        this.birthday = newBirthday;
    }

    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }

    public String getGender(){
        return gender;
    }

    public Date getBirthday(){
        return birthday;
    }

    public UUID getId(){
        return id;
    }

    public String getInformations(){ 
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //Thu, 01 Dec 2022 13:30
        return firstName + " " + lastName + " " + gender + " " + dateFormat.format(birthday);
    }
}
