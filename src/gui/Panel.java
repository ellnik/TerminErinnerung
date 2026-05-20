package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Panel für die Eingabe neuer Termine.
 * 
 * Dieses Panel enthält:
 * - Eingabefelder für Titel, Datum und Uhrzeit
 * - Buttons zum Hinzufügen und Löschen von Terminen
 * 
 * @author olenanikolaienko
 */
public class Panel extends JPanel {

    private JTextField titelField;
    private JTextField datumField;
    private JTextField uhrzeitField;

    private JButton addButton;
    private JButton deleteButton;

    /*
     * Konstruktor des Eingabe-Panels.
     */
    public Panel() {

        setLayout(new GridLayout(4, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Termin Eingabe"));

        // Titel
        add(new JLabel("Titel:"));
        titelField = new JTextField();
        add(titelField);

        // Datum
        add(new JLabel("Datum:"));
        datumField = new JTextField();
        add(datumField);

        // Uhrzeit
        add(new JLabel("Uhrzeit:"));
        uhrzeitField = new JTextField();
        add(uhrzeitField);

        // Buttons
        addButton = new JButton("Termin hinzufügen");
        deleteButton = new JButton("Termin löschen");

        addButton.setPreferredSize(new Dimension(150, 40));
        deleteButton.setPreferredSize(new Dimension(150, 40));

        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);

        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);

        add(addButton);
        add(deleteButton);
    }

    /*
     * Gibt das Titel-Feld zurück.
     * 
     * @return Titel-Feld
     */
    public JTextField getTitelField() {
        return titelField;
    }

    /*
     * Gibt das Datums-Feld zurück.
     * @return Datums-Feld
     */
    public JTextField getDatumField() {
        return datumField;
    }

    /*
     * Gibt das Uhrzeit-Feld zurück.
     * @return Uhrzeit-Feld
     */
    public JTextField getUhrzeitField() {
        return uhrzeitField;
    }

    /*
     * Gibt den Hinzufügen-Button zurück.
     * @return Add-Button
     */
    public JButton getAddButton() {
        return addButton;
    }

    /*
     * Gibt den Löschen-Button zurück. 
     * @return Delete-Button
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }
}