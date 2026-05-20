package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Panel für Buttons.
 * 
 * @author olenanikolaienko
 */
public class ButtonPanel extends JPanel {

    private JButton addButton;
    private JButton deleteButton;

    /**
     * Konstruktor des Button-Panels.
     */
    public ButtonPanel() {

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setBorder(BorderFactory.createTitledBorder("Aktionen"));
        setPreferredSize(new Dimension(700, 80));
        
        addButton = new JButton("Termin hinzufügen");
        deleteButton = new JButton("Termin löschen");

        Dimension buttonSize = new Dimension(160, 35);

        addButton.setPreferredSize(buttonSize);
        deleteButton.setPreferredSize(buttonSize);

        Font font = new Font("Arial", Font.BOLD, 15);

        addButton.setFont(font);
        deleteButton.setFont(font);

        // Farben
        addButton.setBackground(new Color(76, 175, 80));
        addButton.setForeground(Color.WHITE);
        
        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);

        add(addButton);
        add(deleteButton);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}