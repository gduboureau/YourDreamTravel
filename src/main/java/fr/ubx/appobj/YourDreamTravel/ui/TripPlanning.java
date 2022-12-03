package main.java.fr.ubx.appobj.YourDreamTravel.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import main.java.fr.ubx.appobj.YourDreamTravel.domain.aggregates.*;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.entities.*;
import main.java.fr.ubx.appobj.YourDreamTravel.domain.valueObjects.*;
import main.java.fr.ubx.appobj.YourDreamTravel.repository.DataTripInMemory;

public class TripPlanning {
    public static void main(String[] args) throws ParseException, NumberFormatException, IOException {

        Agency agency = new Agency();
        DataTripInMemory datas = new DataTripInMemory();
        BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ouverture de l'agence.\n");
        System.out.println("Que souhaitez-vous faire : ");
        System.out.println("1 - Ajouter un client.\n");
        System.out.println("2 - Réserver un voyage pour un client.\n");
        int num = Integer.parseInt(text.readLine());

        while(true){
            switch(num){
                case 1:
                    AddClient(text, agency);
                    break;
                case 2:
                    NewReservation(text, agency, datas);
                    break;
                case 3:
                    return;
            }
            num = Integer.parseInt(text.readLine());
        }
    }

    public static void AddClient(BufferedReader reader, Agency agency) throws IOException, ParseException{
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Veuillez entrer dans vos informations :\n");
        String firstName = printConsole(reader, "Prénom : ");
        String lastName = printConsole(reader, "Nom : ");
        String sexe = printConsole(reader, "Sexe : ");
        Date birthday = sdformat.parse(printConsole(reader, "Date (aaaa-mm-dd) : "));
        Client client = new Client(firstName, lastName, sexe, birthday, UUID.randomUUID());
        agency.addClient(client);
    }

    public static void NewReservation(BufferedReader reader, Agency agency, DataTripInMemory datas) throws IOException{
        Client client = agency.getClient(printConsole(reader, "Veuilez rentrer le nom du client pour effectuer sa réservation : "));
        System.out.println("Voici la liste des vols disponibles : \n");
        for (int i = 0; i < datas.GetAllFlights().size(); i++){
            System.out.println(datas.GetAllFlights().get(i).getNameFlight());
        }
    }

    public static String printConsole(BufferedReader text, String chaine) throws IOException{
        System.out.println(chaine);
        return text.readLine();
    }
}
