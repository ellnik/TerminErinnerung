package service;

import javax.swing.JOptionPane;

/*
 * Serviceklasse für Nachrichten und Dialoge.
 * 
 * Die Klasse zeigt Informationsmeldungen
 * mit JOptionPane an.
 * 
 * @author olenanikolaienko
 */

public class TerminService {
	 /*
     * Zeigt eine Nachricht als Dialogfenster an.
     * 
     * @param message Nachricht für den Benutzer
     */
    public void showMessage(String message) {

        JOptionPane.showMessageDialog(null, message);
    }

}