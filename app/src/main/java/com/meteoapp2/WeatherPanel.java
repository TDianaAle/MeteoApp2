package com.meteoapp2;

import javax.swing.*;
import java.awt.*;

public class WeatherPanel extends JPanel {

    private JLabel cityLabel;
    private JLabel temperatureLabel;
    private JLabel weatherIconLabel;

    public WeatherPanel() {
        setLayout(new BorderLayout());

        cityLabel = new JLabel("Città: Cesena");
        cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(cityLabel, BorderLayout.NORTH);

        temperatureLabel = new JLabel("Temperatura: ");
        temperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureLabel, BorderLayout.CENTER);

        weatherIconLabel = new JLabel(new ImageIcon("path/to/default/icon.png"));
        weatherIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherIconLabel, BorderLayout.CENTER);

        setOpaque(false);
    }

    public void updateWeather(String temperature, ImageIcon weatherIcon) {
        temperatureLabel.setText("Temperatura: " + temperature);
        weatherIconLabel.setIcon(weatherIcon);
    }

	public void updateWeather(WeatherData weatherData) {
		// TODO Auto-generated method stub
		
	}
}
