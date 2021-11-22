package de.limago;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {


    public Main()  {

        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Taste wurde gedrückt");
                beenden();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               beenden();
            }
        });

        add(button);
    }

    private void beenden() {
        // Speichern
        dispose();
    }

    public static void main(String[] args) {

        new Main().setVisible(true);
    }



}
