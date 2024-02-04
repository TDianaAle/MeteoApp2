package com.meteoapp2;

import javax.swing.*;
import java.awt.*;

public class WeatherForecastPanel extends JPanel {

    private JLabel forecastLabel;

    public WeatherForecastPanel() {
        setLayout(new BorderLayout());
        forecastLabel = new JLabel("Previsione settimanale:");
        forecastLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(forecastLabel, BorderLayout.EAST);

        setOpaque(false);
    }

    public void updateForecast(String forecast) {
        forecastLabel.setText(forecast);
    }
}
