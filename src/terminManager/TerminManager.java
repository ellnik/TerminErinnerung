package terminManager;

import java.util.ArrayList;

import termin.Termin;
/*
 * Die Klasse TerminManager verwaltet
 * alle Termine der Anwendung.
 * 
 * Die Klasse ermöglicht:
 * - Termine hinzufügen
 * - Termine löschen
 * - Zugriff auf die Terminliste
 * 
 * @author olenanikolaienko
 */

public class TerminManager {

    private ArrayList<Termin> termine;
    
    /*
     * Konstruktor des TerminManagers.
     * 
     * Erstellt eine neue ArrayList
     * für Termine.
     */

    public TerminManager() {
        termine = new ArrayList<>();

    }
     
    /*
     * Fügt einen Termin zur Liste hinzu.
     * 
     * @param termin Neuer Termin
     */
    public void addTermin(Termin termin) {
        termine.add(termin);

    }
    
    /*
     * Löscht einen Termin anhand des Index.
     * 
     * @param index Position des Termins
     */
    public void removeTermin(int index) {
        if(index >= 0 && index < termine.size()) {
            termine.remove(index);
        }
    }

    /*
     * Gibt die Liste aller Termine zurück.
     * 
     * @return ArrayList mit Terminen
     */
    public ArrayList<Termin> getTermine() {
        return termine;

    }

}