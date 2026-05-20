package rendener;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import termin.Termin;

/**
 * Renderer für die Darstellung der Termine in der Liste.
 * 
 * Heutige Termine werden rot angezeigt.
 * Andere Termine werden schwarz angezeigt.
 * 
 * @author olenanikolaienko
 */
public class TreminListRendener extends DefaultListCellRenderer {

    /**
     * Bestimmt die Darstellung eines Elements in der Liste.
     * 
     * @param list Die JList
     * @param value Das aktuelle Objekt
     * @param index Index des Elements
     * @param isSelected Ob Element ausgewählt ist
     * @param cellHasFocus Ob Fokus vorhanden ist
     * 
     * @return Komponente für Darstellung
     */
    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(
                list,
                value,
                index,
                isSelected,
                cellHasFocus
        );

        Termin termin = (Termin) value;

        if (termin.isHeute()) {

            c.setForeground(Color.RED);

        } else {

            c.setForeground(Color.BLACK);
        }

        return c;
    }
}