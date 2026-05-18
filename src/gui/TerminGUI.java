package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import service.DateiService;
import service.TerminService;
import termin.Termin;
import terminManager.TerminManager;

public class TerminGUI extends JFrame {

    private JTextField titelField;
    private JTextField datumField;
    private JTextField uhrzeitField;

    private JButton addButton;
    private JButton deleteButton;

    private JList<Termin> terminList;
    private DefaultListModel<Termin> listModel;

    private TerminManager manager;
    private TerminService service;
    private DateiService dateiService;

    public TerminGUI() {

        manager = new TerminManager();
        service = new TerminService();
        dateiService = new DateiService();

        setTitle("Termin Erinnerung");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // PANEL FÜR EINGABE
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Titel:"));

        titelField = new JTextField();
        inputPanel.add(titelField);

        inputPanel.add(new JLabel("Datum:"));

        datumField = new JTextField();
        inputPanel.add(datumField);

        inputPanel.add(new JLabel("Uhrzeit:"));

        uhrzeitField = new JTextField();
        inputPanel.add(uhrzeitField);

        addButton = new JButton("Termin hinzufügen");
        inputPanel.add(addButton);

        deleteButton = new JButton("Termin löschen");
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);

        // LISTE
        listModel = new DefaultListModel<>();

        terminList = new JList<>(listModel);

        // FARBEN
        terminList.setCellRenderer(
                new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                Termin termin = (Termin) value;
                if(termin.isHeute()) {
                    c.setForeground(Color.RED);
                } else {
                    c.setForeground(Color.BLACK);
                }
                return c;
            }

        });

        JScrollPane scrollPane =
                new JScrollPane(terminList);

        add(scrollPane, BorderLayout.CENTER);

        // geladene termine
        for(Termin termin : dateiService.loadTermine()) {
            manager.addTermin(termin);
            listModel.addElement(termin);
        }

        // buttons
        addButton.addActionListener(e -> addTermin());
        deleteButton.addActionListener(e -> deleteTermin());
        setVisible(true);

    }

    private void addTermin() {

        String titel = titelField.getText();
        String datum = datumField.getText();
        String uhrzeit = uhrzeitField.getText();

        Termin termin = new Termin(titel, datum, uhrzeit);

        manager.addTermin(termin);
        listModel.addElement(termin);
        dateiService.saveTermine(manager.getTermine());
        service.showMessage("Termin hinzugefügt!");
        clearFields();

    }

    private void deleteTermin() {
        int index = terminList.getSelectedIndex();
        if(index != -1) {

            manager.removeTermin(index);
            listModel.remove(index);
            dateiService.saveTermine(manager.getTermine());
            service.showMessage("Termin gelöscht!");
        }
    }

    private void clearFields() {
        titelField.setText("");
        datumField.setText("");
        uhrzeitField.setText("");

    }

}