package main.java.fr.ubx.appobj.YourDreamTravel.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.aggregates.Travel;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.*;

public class DataTripInMemory {
    
    HashMap<UUID,Travel> memory;
    
    public DataTripInMemory(){
        memory = new HashMap<>();
    }

    public void saveTravel(Travel travel){
        memory.put(travel.getId(), travel);
    }

    public Travel getTravel(UUID id){
        return memory.get(id);
    }

    public Hotel GetHotel(String destination){
        Hotel hotel = null;
        if (destination == "Paris"){
            Adress adress = new Adress(12, "rue des oliviers", "Paris", "France", UUID.randomUUID());
            hotel = new Hotel("ParisHotel", 45, adress, UUID.randomUUID());
        }
        if (destination == "Bordeaux"){
            Adress adress = new Adress(2, "avenue de Paris", "Bordeaux", "France", UUID.randomUUID());
            hotel = new Hotel("BordeauxHotel", 70, adress, UUID.randomUUID());
        }
        if (destination == "Camberra"){
            Adress adress = new Adress(30, "Brandella Place", "Camberra", "Australia", UUID.randomUUID());
            hotel = new Hotel("CamberraHotel", 20, adress, UUID.randomUUID());
        }
        if (destination == "Tokyo"){
            Adress adress = new Adress(427-1195, "Nishishinjuku Shinjuku Sukueatawa", "Tokyo", "Japan", UUID.randomUUID());
            hotel = new Hotel("TokyoHotel", 32, adress, UUID.randomUUID());
        }
        if (destination == "Delhi"){
            Adress adress = new Adress(36, "Ground Floor", "Delhi", "India", UUID.randomUUID());
            hotel = new Hotel("DelhiHotel", 41, adress, UUID.randomUUID());
        }
        return hotel;
    }

    public ArrayList<Flight> GetAllFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        //From Paris
        flights.add(new DirectFlight("Paris", "Bordeaux", 100, null, new NameFlight("Paris", "Bordeaux", new UUID(2, 2))));
        flights.add(new DirectFlight("Paris", "Camberra", 500, null, new NameFlight("Paris", "Camberra", new UUID(2, 2))));
        flights.add(new DirectFlight("Paris", "Tokyo", 1100, null, new NameFlight("Paris", "Tokyo", new UUID(2, 2))));
        flights.add(new DirectFlight("Paris", "Delhi", 985, null, new NameFlight("Paris", "Delhi", new UUID(2, 2))));

        //From Bordeaux
        flights.add(new DirectFlight("Bordeaux", "Paris", 100, null, new NameFlight("Bordeaux", "Paris", new UUID(2, 2))));
        flights.add(new DirectFlight("Bordeaux", "Tokyo", 1000, null, new NameFlight("Bordeaux", "Tokyo", new UUID(2, 2))));
        flights.add(new DirectFlight("Bordeaux", "Delhi", 700, null, new NameFlight("Bordeaux", "Delhi", new UUID(2, 2))));
        
        //From Camberra
        flights.add(new DirectFlight("Camberra", "Paris", 450, null, new NameFlight("Camberra", "Paris", new UUID(2, 2))));
        flights.add(new DirectFlight("Camberra", "Tokyo", 600, null, new NameFlight("Camberra", "Tokyo", new UUID(2, 2))));
        
        //From Tokyo
        flights.add(new DirectFlight("Tokyo", "Bordeaux", 1300, null, new NameFlight("Tokyo", "Bordeaux", new UUID(2, 2))));
        flights.add(new DirectFlight("Tokyo", "Camberra", 600, null, new NameFlight("Tokyo", "Camberra", new UUID(2, 2))));
        
        //From Delhi
        flights.add(new DirectFlight("Delhi", "Paris", 1000, null, new NameFlight("Delhi", "Paris", new UUID(2, 2))));
        flights.add(new DirectFlight("Delhi", "Bordeaux", 1240, null, new NameFlight("Delhi", "Bordeaux", new UUID(2, 2))));
        flights.add(new DirectFlight("Delhi", "Camberra", 365, null, new NameFlight("Delhi", "Camberra", new UUID(2, 2))));
                
        return flights;
    }
}
