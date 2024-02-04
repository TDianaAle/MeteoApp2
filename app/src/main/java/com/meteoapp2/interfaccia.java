package com.meteoapp2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class interfaccia extends JFrame {

	
    private WeatherPanel weatherPanel;
    private DateTimePanel dateTimePanel;
  //  private MoonPhasePanel moonPhasePanel se vogliamo è già implementata ma non possiamo aggiornarla dall'API
    private WeatherForecastPanel weatherForecastPanel;
    private WeatherAlertPanel weatherAlertPanel;
    private NavbarPanel navbarPanel;
    private JLabel pressureLabel;
    private JLabel visibilityLabel;
    private JLabel sunriseLabel;
    private JLabel sunsetLabel;
    private EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public interfaccia() {
        setTitle("Meteo App");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        

        // Creazione dei pannelli
        weatherPanel = new WeatherPanel();
        dateTimePanel = new DateTimePanel();
      //  moonPhasePanel = new MoonPhasePanel();
        weatherForecastPanel = new WeatherForecastPanel();
        navbarPanel = new NavbarPanel();
        weatherPanel = new WeatherPanel();
        dateTimePanel = new DateTimePanel();
        weatherForecastPanel = new WeatherForecastPanel();
        weatherAlertPanel = new WeatherAlertPanel();
        navbarPanel = new NavbarPanel();
        new NativeDiscovery().discover();
        
     // Carica i video corrispondenti al tempo
        String videoPath = "path/to/default/video.mp4"; // Video predefinito
        // Controllo delle condizioni meteo e impostazione del video appropriato
        if (isSunnyWeather()) {
            videoPath = "path/to/sunny/video.mp4";
        } else if (isCloudyWeather()) {
            videoPath = "path/to/cloudy/video.mp4";
        }

        // Inizializzazione del componente video
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.getMediaPlayer().prepareMedia(videoPath);
        mediaPlayerComponent.getMediaPlayer().setRepeat(true);
        mediaPlayerComponent.getMediaPlayer().play();

        getContentPane().add(mediaPlayerComponent, BorderLayout.CENTER);
        getContentPane().add(weatherAlertPanel, BorderLayout.SOUTH);
        getContentPane().add(dateTimePanel, BorderLayout.EAST);
        getContentPane().add(weatherForecastPanel, BorderLayout.WEST);
        getContentPane().add(navbarPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private boolean isSunnyWeather() {
        // Implementa la logica per verificare se il tempo è soleggiato
        return true; // Esempio di implementazione
    }

    private boolean isCloudyWeather() {
        // Implementa la logica per verificare se il tempo è nuvoloso
        return false; // Esempio di implementazione

     // Inizializzazione delle altre label
        
        pressureLabel = new JLabel("Pressione: ");
        visibilityLabel = new JLabel("Visibilità: ");
        sunriseLabel = new JLabel("Alba: ");
        sunsetLabel = new JLabel("Tramonto: ");
        
        // Aggiunta dei pannelli al frame principale
        getContentPane().add(weatherPanel, BorderLayout.CENTER);
        weatherAlertPanel = new WeatherAlertPanel();
        weatherPanel.add(weatherAlertPanel, BorderLayout.SOUTH);
        getContentPane().add(dateTimePanel, BorderLayout.EAST);
      //  add(moonPhasePanel, BorderLayout.WEST);
        getContentPane().add(weatherForecastPanel, BorderLayout.SOUTH);
        getContentPane().add(navbarPanel, BorderLayout.NORTH);

     // Aggiunta delle label al pannello del meteo
        JPanel weatherInfoPanel = new JPanel(new GridLayout(4, 1));
        weatherInfoPanel.add(pressureLabel);
        weatherInfoPanel.add(visibilityLabel);
        weatherInfoPanel.add(sunriseLabel);
        weatherInfoPanel.add(sunsetLabel);
        weatherPanel.add(weatherInfoPanel, BorderLayout.WEST);

        setVisible(true);
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(interfaccia::new);
    }
    }
 