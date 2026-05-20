package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel für Eingabefelder.
 * 
 * @author olenanikolaienko
 */
public class Panel extends JPanel {

    private JTextField titelField;
    private JTextField datumField;
    private JTextField uhrzeitField;

    /**
     * Konstruktor des Panels.
     */
    public Panel() {

        setLayout(new GridLayout(3, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Termin Eingabe"));
        setMaximumSize(new Dimension(700, 140));
        Font font = new Font("Arial", Font.PLAIN, 16);

        // Titel
        add(new JLabel("Titel:"));
        titelField = new JTextField();
        titelField.setFont(font);
        add(titelField);

        // Datum
        add(new JLabel("Datum:"));
        datumField = new JTextField();
        datumField.setFont(font);
        add(datumField);

        // Uhrzeit
        add(new JLabel("Uhrzeit:"));
        uhrzeitField = new JTextField();
        uhrzeitField.setFont(font);
        add(uhrzeitField);
    }

    public JTextField getTitelField() {
        return titelField;
    }

    public JTextField getDatumField() {
        return datumField;
    }

    public JTextField getUhrzeitField() {
        return uhrzeitField;
    }
}