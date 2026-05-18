package termin;

public class Termin {

    private String titel;
    private String datum;
    private String uhrzeit;

    public Termin(String titel, String datum, String uhrzeit) {
        this.titel = titel;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
    }

    public String getTitel() {
        return titel;
    }

    public String getDatum() {
        return datum;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    @Override
    public String toString() {
        return titel + " | " + datum + " | " + uhrzeit;
    }
    public boolean isHeute() {

        String heute = java.time.LocalDate.now().toString();
        return datum.equals(heute);

    }
}
