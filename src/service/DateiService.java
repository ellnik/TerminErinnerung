package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import termin.Termin;

public class DateiService {

    private final String DATEI_NAME = "termine.txt";

    // speichern
    public void saveTermine(ArrayList<Termin> termine) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATEI_NAME));

            for(Termin termin : termine) {
                writer.write(termin.getTitel() + ";" + termin.getDatum() + ";" + termin.getUhrzeit());
                writer.newLine();
            }

            writer.close();
            System.out.println("Datei gespeichert!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // laden
    public ArrayList<Termin> loadTermine() {
        ArrayList<Termin> termine = new ArrayList<>();

        try { 
        	BufferedReader reader = new BufferedReader(new FileReader(DATEI_NAME));
            String line;

            while((line = reader.readLine()) != null) {
                String[] daten = line.split(";");

                String titel = daten[0];
                String datum = daten[1];
                String uhrzeit = daten[2];

                Termin termin = new Termin(titel, datum, uhrzeit);
                termine.add(termin);
            }

            reader.close();
            System.out.println("Datei geladen!");

        } catch (IOException e) {
            System.out.println("Keine Datei gefunden.");
        }
        return termine;
    }
}