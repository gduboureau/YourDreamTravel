package main.java.fr.ubx.appobj.YourDreamTravel.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.application.Agency;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.*;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.*;
import main.java.fr.ubx.appobj.YourDreamTravel.repository.DataTripInMemory;

public class TripPlanning {

    public static Agency agency = new Agency(); //on creer une nouvelle agence
    public static DataTripInMemory datasAgency = agency.getDatas();
    public static ArrayList<Flight> flights = datasAgency.GetAllFlights(); //on initialise le tableau des vols en recuperant les données depuis DataTripInMemory 
    public static ArrayList<Flight> indirectFlights = datasAgency.getAllIndirectFlights();
    public static BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
    

    public static void main(String[] args) throws IOException, ParseException{

        System.out.println("Ouverture de l'agence.\n");
        homePage();
    }

    public static void homePage() throws IOException, ParseException{
        System.out.println("\nQue souhaitez-vous faire: \n");
        System.out.println("1 - Créer un compte client.\n");
        System.out.println("2 - Réserver un voyage en tant que client.\n");
        System.out.println("3 - Fermer l'agence.\n");
        try{                                                //on demande a l'utilisateur de choisir choix 1 ou 2
            int num = Integer.parseInt(text.readLine());
            if (num==1){
                AddClient();
            }
            else if (num==2){
                NewReservation();
            }
            else if (num==3){
                System.out.println("Fermeture de l'agence.");
                return;
            }
            else{
                System.out.println("\nChoix inconnu, veuillez réessayer.\n");
                homePage();
            }
        } catch(Exception e){ //si le caractere est different d'un int on indique l'erreur a l'utilisateur et on redemande un choix
            System.out.println("\nChoix inconnu, veuillez réessayer.\n");
            homePage();
        }
    }

    public static void AddClient() throws IOException, ParseException{
        System.out.println("\nCréation de compte:\n");
        String firstName = printConsole("Prénom:");
        while (firstName == null || firstName.isEmpty() || !(firstName.matches("^[a-zA-ZËëÏï]+[ -]?[[a-zA-ZËëÏï]+[ -]?]*[a-zA-ZËëÏï]+$"))){ //si la str contient un !char/format incorect est vide ou null on indique que le prénom est invalide et on invite l'utilisateur a effectuer une nouvelle saisie
            System.out.println("\nPrénom invalide, veuillez réessayer.\n\n");
            firstName = printConsole("Prénom:");
        }
        String lastName = printConsole("Nom: ");
        while (lastName == null || lastName.isEmpty() || !(lastName.matches("^[a-zA-ZËëÏï]+[ -]?[[a-zA-ZËëÏï]+[ -]?]*[a-zA-ZËëÏï]+$"))){ //si la str contient un !char/format incorect est vide ou null on indique que le nom est invalide et on invite l'utilisateur a effectuer une nouvelle saisie
            System.out.println("\nNom invalide, veuillez réessayer.\n\n");
            lastName = printConsole("Nom:");
        }
        String sexe = printConsole("Sexe (M/F): ");
        while (sexe == null || sexe.isEmpty() || !(sexe.matches("^[MmFf]+$"))){ //si la str contient format incorect est vide ou null on indique que le sexe est invalide et on invite l'utilisateur a effectuer une nouvelle saisie
            System.out.println("\nSexe invalide, veuillez réessayer.\n\n");
            sexe = printConsole("Sexe:");
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false); //permet de rentrer jour/mois valide
        Date birthday = null;
        while(birthday==null)
            try{
                birthday = format.parse(printConsole("Date de naissance (jj/mm/aaaa): ")); //tant que la date n'est pas valide on reste en null et on redemande au client une date de naissance valide
            }catch(Exception e){
                System.out.println("\nDate de naissance invalide, veuillez réessayer.\n\n");
            }
        Client client = new Client(firstName, lastName, sexe, birthday, UUID.randomUUID());
        agency.addClient(client);
        System.out.println("\nVotre compte client à bien été créé sur YourDreamTravel ! Bienvenu parmis nous\n");
        homePage();
    }

    public static void NewReservation() throws IOException, ParseException{
        System.out.println("Veuillez vous identifier grâce à votre nom pour effectuer une réservation: ");
        String lastName = printConsole("Nom: ");
        if (agency.getClient(lastName) == null){
            System.out.println("Ce compte client est inexistant, veuillez réessayer ou créer un compte.");
            homePage();
        }
        else{
            ReservationPage(agency.getClient(lastName)); // on se 'connecte' au compte du client en retenant l'id -> toute reservation sera 'enregistrer' grace a son id
        }
        
    }

    public static void ReservationPage(Client client) throws NumberFormatException, IOException{
        System.out.println("Que souhaitez vous faire ?:\n");
        System.out.println("1 - Créer un nouveau projet de voyage.\n");
        System.out.println("2 - Consulter mon projet de voyage.\n");
        System.out.println("3 - Consulter le prix de mon projet de voyage.\n");
        System.out.println("4 - Déconnexion du compte client.\n");
        int num = Integer.parseInt(text.readLine());
        try{                                                //on demande a l'utilisateur de choisir choix 1 ou 2
            if (num==1){
                ChoseTrip(client);
            }
            else if (num==2){
                DisplayTrip(client);
                ReservationPage(client);
            }
            else if (num == 3){
                DisplayPriceDetail(client);
                ReservationPage(client);
            }
            else if (num==4){
                client = null;
                homePage();
            }
            else{
                System.out.println("\nChoix inconnu, veuillez réessayer.\n");
                ReservationPage(client);
            }
        }catch(Exception e){ //si le caractere est different d'un int on indique l'erreur a l'utilisateur et on redemande un choix
            System.out.println("\nChoix inconnu, veuillez réessayer.\n");
            ReservationPage(client);
        }
    }

    public static void ChoseTrip(Client client) throws NumberFormatException, IOException{
        System.out.println("Quel type de voyage souhaiteriez vous ?\n");
        System.out.println("1 - Réserver un voyage sans service (réservation d’un vol sec).\n");
        System.out.println("2 - Réserver un voyage avec service (possibilité de réserver un hotel pour plusieurs jours ou louer une voiture).\n");
        try{                                    //on demande a l'utilisateur de choisir choix 1 ou 2
            Service service = null;
            Flight flight = null;
            Boolean flightOption = null;
            Date dateDepartureFilght = null;
            int num = Integer.parseInt(text.readLine());
            if (num==1){
                flight = ChoseFlight();
                flightOption = FlightOption(flight);
                dateDepartureFilght = ChoseFlightDate(flight);
            }
            else if (num==2){
                flight = ChoseFlight();
                service = chooseService(flight);
                flightOption = FlightOption(flight);
                dateDepartureFilght = ChoseFlightDate(flight);
            }
            else{
                System.out.println("\nChoix inconnu, veuillez réessayer.\n");
                ReservationPage(client);
            }
            agency.makeNewTravel(client, service, dateDepartureFilght, flight, flightOption);
            ReservationPage(client);
        }catch(Exception e){ //si le caractere est different d'un int on indique l'erreur a l'utilisateur et on redemande un choix
            System.out.println("\nChoix inconnu, veuillez réessayer.\n");
            ReservationPage(client);
        }
    }

    public static Service chooseService(Flight flight){
        System.out.println("Souhaitez vous un service simple (hôtel et voiture dans un seul lieu) ou un service de haut de gamme (hôtel et voitures dans deux lieux différents) ? :\n");
        System.out.println("1 - Service simple.\n");
        System.out.println("2 - Service haut de gamme.\n");
        Service service = null;
        try{                                                //on demande a l'utilisateur de choisir choix 1 ou 2
            int num = Integer.parseInt(text.readLine());
            Boolean benefit = false;
            Boolean benefit2 = false;
            if (num==1){
                Hotel hotel = datasAgency.GetHotel(flight.getDestination());
                System.out.println("Très bien, voici l'hôtel disponible pour votre séjour dans la ville de " + flight.getDestination() + " : " + hotel.getName() + "\n");
                RentalCar rentalCar = chooseCar(hotel);
                benefit = benefitOption(flight);
                service = new BasicService(hotel, rentalCar, UUID.randomUUID(), benefit);
            }
            else if (num==2){
                Hotel hotel = datasAgency.GetHotel(flight.getDestination());
                benefit = benefitOption(flight);
                System.out.println("Très bien, voici le premier hôtel disponible pour votre séjour dans la ville de " + flight.getDestination() + " : " + hotel.getName() + "\n");
                System.out.println("Vous devez maintenant choisir pour le deuxième hotel : \n");
                Hotel hotel2 = datasAgency.GetSecondHotel(flight.getDestination());
                benefit2 = benefitOption(flight);
                System.out.println("Très bien, voici le deuxième hôtel disponible pour votre séjour dans la ville de " + flight.getDestination() + " : " + hotel.getName() + "\n");
                RentalCar rentalCar = chooseCar(hotel);
                System.out.println("\nVous aurez cette voiture pour aller de votre premier hotel au second.\n");
                System.out.println("\nVeuillez en sélectionner une autre pour le deuxième hotel.\n");
                RentalCar rentalCar2 = chooseCar(hotel2);
                service = new PremiumService(hotel, hotel2, rentalCar, rentalCar2, UUID.randomUUID(), benefit, benefit2);
            }
            else{
                System.out.println("\nChoix inconnu, veuillez réessayer.\n");
                chooseService(flight);
            }
        }catch(Exception e){ //si le caractere est different d'un int on indique l'erreur a l'utilisateur et on redemande un choix
            System.out.println("\nChoix inconnu, veuillez réessayer.\n");
            chooseService(flight);
        }
        return service;
    }

    public static RentalCar chooseCar(Hotel hotel) throws NumberFormatException, IOException{
        System.out.println("Voici la liste des voitures disponibles: \n");
        for (int i = 0; i < datasAgency.getCar().size(); i++){
            System.out.println("Voiture "+ (i+1) + ":    " + datasAgency.getCar().get(i).getBrand());
        }
        System.out.println("\n\nVeuillez choisir une voiture: \n");
        int carChoice = Integer.parseInt(text.readLine());
        System.out.println("Vous venez de selectionner la voiture " + carChoice + " (" + datasAgency.getCar().get(carChoice-1).getBrand() + ")\n");
        
        return datasAgency.newRentalCar(datasAgency.getCar().get(carChoice-1), hotel.getAdress(), null);
    }

    public static Boolean benefitOption(Flight flight){
        System.out.println("Souhaitez vous des prestations luxueuses ? (vous devrez acquitter d'une majoration de 20%)\n");
        System.out.println("1 - Oui\n");
        System.out.println("2 - Non\n");
        Boolean luxuriousServices = null;
        try{                                                //on demande a l'utilisateur de choisir choix 1 ou 2
            int num = Integer.parseInt(text.readLine());
            if (num==1){
                luxuriousServices = true;
            }
            else if (num==2){
                luxuriousServices = false;
            }
            else{
                System.out.println("\nChoix inconnu, veuillez réessayer.\n");
                chooseService(flight);
            }
        }catch(Exception e){ //si le caractere est different d'un int on indique l'erreur a l'utilisateur et on redemande un choix
            System.out.println("\nChoix inconnu, veuillez réessayer.\n");
            FlightOption(flight);
        }
        return luxuriousServices;
    }

    public static Flight ChoseFlight() throws NumberFormatException, IOException{
        System.out.println("Voici la liste des vols disponibles: \n");
        int cpt = 0;
        for (int i = 0; i < flights.size(); i++){
            System.out.println("Vol direct "+ (i+1) + ":    " + flights.get(i).getNameFlight());
            cpt ++;
        }
        for (int i = cpt; i < indirectFlights.size() + cpt; i++){
            System.out.println("Vol indirect "+ (i+1) + ":    " + indirectFlights.get(i-cpt).getNameFlight());
        }
        System.out.println("\n\nVeuillez choisir un vol: \n");
        int flightChoice = Integer.parseInt(text.readLine());
        if (flightChoice <= flights.size()){
            System.out.println("Vous venez de selectionner le vol " + flightChoice + " (" + flights.get(flightChoice-1).getNameFlight() + ")\n");
        
            return flights.get(flightChoice-1);
        }else{
            System.out.println("Vous venez de selectionner le vol " + flightChoice + " (" + indirectFlights.get(flightChoice-1-cpt).getNameFlight() + ")\n");
        
            return indirectFlights.get(flightChoice-1-cpt);
        }
        
    }

    public static Boolean FlightOption(Flight flight){
            System.out.println("Souhaitez vous voyager en 1ère classe ? (vous devrez acquitter d'une majoration de 30%)\n");
            System.out.println("1 - Oui\n");
            System.out.println("2 - Non\n");
            Boolean premiumClass=null;
            try{                                                //on demande a l'utilisateur de choisir choix 1 ou 2
                int num = Integer.parseInt(text.readLine());
                if (num==1){
                    premiumClass = true;
                }
                else if (num==2){
                    premiumClass = false;
                }
                else{
                    System.out.println("\nChoix inconnu, veuillez réessayer.\n");
                    FlightOption(flight);
                }
            }catch(Exception e){ //si le caractere est different d'un int on indique l'erreur a l'utilisateur et on redemande un choix
                System.out.println("\nChoix inconnu, veuillez réessayer.\n");
                FlightOption(flight);
            }
            return premiumClass;
    }

    public static Date ChoseFlightDate(Flight flight) throws NumberFormatException, IOException{
        DateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm"); //Thu, 01 Dec 2022 13:30
        System.out.println("Voici la liste des dates disponibles pour votre vol: \n");
        for (int i = 0; i < flight.getDate().size(); i++){
            System.out.println("Date "+ (i+1) + ":  " + dateFormat.format(flight.getDate().get(i)));
        }
        System.out.println("\n\nVeuillez choisir une date: \n");
        int dateChoice = Integer.parseInt(text.readLine());
        System.out.println("Vous venez d'ajouter à votre projet de voyage le vol " + flight.getNameFlight() + ",\nDate de départ le " + dateFormat.format(flight.getDate().get(dateChoice-1)) + "\n");
        
        return flight.getDate().get(dateChoice-1);
    }

    public static void DisplayTrip(Client client){
        if(datasAgency.getTravel(client.getId()) != null){
            System.out.println("Voici votre projet de voyage ! :\n");
            System.out.println(datasAgency.getTravel(client.getId()).getReservation().getInformations() + "\n\n\n");
        }else{
            System.out.println("Il n'y a rien pour le moment ...\n\n");
        }
    }

    public static void DisplayPriceDetail(Client client){
        if(datasAgency.getTravel(client.getId()) != null){
            System.out.println("Voici le detail du prix de votre voyage :\n");
            System.out.println(datasAgency.getTravel(client.getId()).getReservation().getPriceInformation() + "\n\n\n");
        }else{
            System.out.println("Il n'y a rien pour le moment ...\n\n");
        }
    }

    public static String printConsole(String chaine) throws IOException{
        System.out.println(chaine);
        return text.readLine();
    }

}

    
