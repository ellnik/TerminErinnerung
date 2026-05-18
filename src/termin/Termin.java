package termin;

/*
 * Die Klasse Termin speichert Informationen
 * über einen Termin.
 * 
 * Ein Termin besteht aus:
 * - Titel
 * - Datum
 * - Uhrzeit
 * 
 * Zusätzlich kann überprüft werden,
 * ob der Termin heute stattfindet.
 * 
 * @author olenanikolaienko
 */

public class Termin {

    private String titel;
    private String datum;
    private String uhrzeit;

    /*
     * Konstruktor für einen Termin.
     * 
     * @param titel Titel des Termins
     * @param datum Datum des Termins
     * @param uhrzeit Uhrzeit des Termins
     */
    public Termin(String titel, String datum, String uhrzeit) {
        this.titel = titel;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
    }

    /*
     * Gibt den Titel des Termins zurück.
     * 
     * @return Titel des Termins
     */
    public String getTitel() {
        return titel;
    }

    /*
     * Gibt das Datum des Termins zurück.
     * 
     * @return Datum des Termins
     */
    public String getDatum() {
        return datum;

    }

    /*
     * Gibt die Uhrzeit des Termins zurück.
     * 
     * @return Uhrzeit des Termins
     */
    public String getUhrzeit() {
        return uhrzeit;

    }

    /*
     * Überprüft, ob der Termin heute stattfindet.
     * 
     * @return true, wenn der Termin heute ist
     */
    public boolean isHeute() {

        String heute = java.time.LocalDate.now().toString();
        return datum.equals(heute);

    }

    /*
     * Gibt den Termin als String zurück.
     * 
     * @return Termin als Text
     */
    @Override
    public String toString() {
        return titel + " | " + datum + " | " + uhrzeit;

    }

}