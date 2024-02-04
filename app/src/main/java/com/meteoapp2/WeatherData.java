package com.meteoapp2;

import javax.swing.ImageIcon;

public class WeatherData {

    private String temperature;
    private ImageIcon weatherIcon;
    //private String moonPhase;
    private String weatherForecast;
    private String weatherAlert;

    public WeatherData(String temperature, ImageIcon weatherIcon, String weatherForecast, String weatherAlert) {
        this.temperature = temperature;
        this.weatherIcon = weatherIcon;
        //this.moonPhase = moonPhase;
        this.weatherForecast = weatherForecast;
        this.weatherAlert = weatherAlert;
    }

    public String getTemperature() {
        return temperature;
    }

    public ImageIcon getWeatherIcon() {
        return weatherIcon;
    }

   // public String getMoonPhase() {
    //    return moonPhase;
    //}

    public String getWeatherForecast() {
        return weatherForecast;
    }

    public String getWeatherAlert() {
        return weatherAlert;
    }
}
//Nella classe WeatherData, abbiamo definito un costruttore che accetta le informazioni meteo e
//le memorizza nei campi privati della classe.
//Inoltre, abbiamo fornito i metodi getter per ottenere i valori di temperatura, icona meteo,
//fase lunare(optional al momento implementati come commenti), previsioni meteo e allerta meteo.
//Ora è necessario implementare la logica per effettuare una richiesta HTTP all'API di OpenWeatherMap per
// ottenere i dati meteo e creare un oggetto WeatherData con queste informazioni.
//Una volta ottenuti i dati meteo si potranno aggiornare i pannelli dell'applicazione
//con le informazioni corrette utilizzando il metodo updateWeather() della classe WeatherPanel.
