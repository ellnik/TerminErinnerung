package main;

import gui.Style;
import gui.TerminGUI;

/*
 * Hauptklasse des Programms.
 * 
 * Die Klasse startet die Anwendung
 * und öffnet die grafische Benutzeroberfläche.
 * 
 * @author olenanikolaienko
 */

public class Main {

    /*
     * Startmethode des Programms.
     * 
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {

    	Style.setup();
    	
    	new TerminGUI();
        

    }

}