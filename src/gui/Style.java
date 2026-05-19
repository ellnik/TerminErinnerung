package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class Style {

    public static void setup() {

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);


        Border border = BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true);        

        UIManager.put("TextField.border", border);
    }
}