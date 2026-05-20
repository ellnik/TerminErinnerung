package gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import service.DateiService;
import service.TerminService;
import termin.Termin;
import terminManager.TerminManager;

/*
 * Hauptfenster der Anwendung.
 * 
 * Die Klasse verbindet:
 * - Eingabe-Panel
 * - Terminliste
 * - Services
 * 
 * @author olenanikolaienko
 */
public class TerminGUI extends JFrame {

    private Panel inputPanel;
    private TerminListPanel listPanel;

    private TerminManager manager;
    private TerminService service;
    private DateiService dateiService;

    /**
     * Konstruktor der GUI.
     */
    public TerminGUI() {

        manager = new TerminManager();
        service = new TerminService();
        dateiService = new DateiService();

        setTitle("Termin Erinnerung");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // main panel
        setLayout(new BorderLayout(10, 10));
        ((javax.swing.JComponent) getContentPane())
                .setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // panels
        inputPanel = new Panel();
        listPanel = new TerminListPanel();
        add(inputPanel, BorderLayout.NORTH);
        add(listPanel, BorderLayout.CENTER);

        // termine laden
        loadTermine();

        // buttons events
        inputPanel.getAddButton().addActionListener(e -> addTermin());
        inputPanel.getDeleteButton().addActionListener(e -> deleteTermin());

        setVisible(true);
    }

    /**
     * Lädt gespeicherte Termine.
     */
    private void loadTermine() {

        for (Termin termin : dateiService.loadTermine()) {
            manager.addTermin(termin);
            listPanel.getListModel().addElement(termin);
        }
    }

    /**
     * Fügt einen neuen Termin hinzu.
     */
    private void addTermin() {

        String titel = inputPanel.getTitelField().getText();
        String datum = inputPanel.getDatumField().getText();
        String uhrzeit = inputPanel.getUhrzeitField().getText();
        Termin termin = new Termin(titel, datum, uhrzeit);
        manager.addTermin(termin);
        listPanel.getListModel().addElement(termin);
        dateiService.saveTermine(manager.getTermine());
        service.showMessage("Termin hinzugefügt!");
        clearFields();
    }

    /*
     * Löscht einen Termin.
     */
    private void deleteTermin() {

        int index = listPanel.getTerminList().getSelectedIndex();
        if (index != -1) {
            manager.removeTermin(index);
            listPanel.getListModel().remove(index);
            dateiService.saveTermine(manager.getTermine());
            service.showMessage("Termin gelöscht!");
        }
    }

    /*
     * Leert die Eingabefelder.
     */
    private void clearFields() {

        inputPanel.getTitelField().setText("");
        inputPanel.getDatumField().setText("");
        inputPanel.getUhrzeitField().setText("");
    }
}