package terminManager;

import java.util.ArrayList;

import termin.Termin;

public class TerminManager {

    private ArrayList<Termin> termine;

    public TerminManager() {

        termine = new ArrayList<>();

    }

    public void addTermin(Termin termin) {

        termine.add(termin);

    }

    public void removeTermin(int index) {

        if(index >= 0 && index < termine.size()) {

            termine.remove(index);

        }

    }

    public ArrayList<Termin> getTermine() {

        return termine;

    }

}