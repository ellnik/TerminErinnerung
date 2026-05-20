package gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rendener.TreminListRendener;
import termin.Termin;

/*
 * Panel für die Anzeige der Terminliste.
 * 
 * Das Panel enthält:
 * - JList mit allen Terminen
 * - JScrollPane für Scroll-Funktion
 * - eigenen Renderer für Farben
 * 
 * @author olenanikolaienko
 */
public class TerminListPanel extends JPanel {

    private JList<Termin> terminList;
    private DefaultListModel<Termin> listModel;

    /*
     * Konstruktor des Listen-Panels.
     */
    public TerminListPanel() {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Termine"));
        listModel = new DefaultListModel<>();
        terminList = new JList<>(listModel);
        terminList.setCellRenderer(new TreminListRendener());
       JScrollPane scrollPane = new JScrollPane(terminList);
        add(scrollPane, BorderLayout.CENTER);
    }

    /*
     * Gibt die Terminliste zurück.
     * 
     * @return Terminliste
     */
    public JList<Termin> getTerminList() {
        return terminList;
    }

    /*
     * Gibt das Listenmodell zurück.
     * 
     * @return Listenmodell
     */
    public DefaultListModel<Termin> getListModel() {
        return listModel;
    }
}