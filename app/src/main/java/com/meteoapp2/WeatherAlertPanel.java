package com.meteoapp2;

import javax.swing.*;
import java.awt.*;

public class WeatherAlertPanel extends JPanel {

    private JLabel alertLabel;

    public WeatherAlertPanel() {
        setLayout(new BorderLayout());
        alertLabel = new JLabel("Allerte Meteo:");
        alertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(alertLabel, BorderLayout.CENTER);

        setOpaque(false);
    }

    public void updateAlert(String alert) {
        alertLabel.setText(alert);
    }
}
