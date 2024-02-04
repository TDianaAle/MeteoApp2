package com.meteoapp2;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavbarPanel extends JPanel {

    private JButton searchButton;
    private JButton homeAutomationButton;

    public NavbarPanel() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        searchButton = new JButton("Cerca: "); // pulsante per cercare location
        homeAutomationButton = new JButton(new ImageIcon("path/icon.png"));//pulsante con icona per nuova interfaccia per domotica

        add(searchButton);
        add(Box.createHorizontalStrut(20)); // Spazio tra i bottoni
        add(homeAutomationButton);

        setOpaque(false);
    }

    public void setSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void setHomeAutomationButtonListener(ActionListener listener) {
        homeAutomationButton.addActionListener(listener);
    }
}
