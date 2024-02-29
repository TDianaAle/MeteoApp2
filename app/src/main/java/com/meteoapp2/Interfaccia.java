package com.meteoapp2;
 import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;
import javax.swing.text.DateFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.VideoSurface;

import javax.swing.border.LineBorder;


public class Interfaccia extends JFrame {
	
    private JLabel temperatureText;
	private JLabel weatherDescription;
	private JLabel maxText;
    private JLabel minText;
	private JLabel pressioneText;
	private static  JLabel  CurrentDateText;
	private JLabel windspeedText;
	private JLabel sunsetText;
	private JLabel sunriseText;
	private JLabel humidityText; 
	private JLabel visibilitaText;
	private JLabel weatherDataLabel;

	public Interfaccia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaccia.class.getResource("/assets/clear.png")));
		
		// Inizializzazione del frame
        setTitle("Domoteo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(616, 432);
        setLocationRelativeTo(null);
        initComponents();  
	}
        //inizializzazione dei componenti dell'interfaccia utente
	static EmbeddedMediaPlayerComponent myMedia = new EmbeddedMediaPlayerComponent();
	
	//Canvas canvas = new Canvas();
   // MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
 //   CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
   // EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
   // mediaPlayer.setVideoSurface(videoSurface);

  //  mediaPlayer.playMedia(String with the name of the file);
        private void initComponents() {
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(false);
        contentPane.setLayout(null);
    //   myMedia.mediaPlayer().media().start("/app/src/main/java/assets/rain.mp4.mp4");
     //   myMedia.setBounds(0, 0, 610, 430);
      //  contentPane.setDisplayedMnemonicIndex(NORMAL);
        
        // Inizializzazione delle variabili
        temperatureText = new JLabel();
        temperatureText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        maxText = new JLabel();
        minText = new JLabel();
        pressioneText = new JLabel();
        weatherDescription = new JLabel();
        weatherDescription.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        weatherDescription.setForeground(new Color(0, 0, 0));
        weatherData();
        CurrentDateText = new JLabel();
        CurrentDateText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        windspeedText = new JLabel();
        sunsetText = new JLabel();
        sunriseText = new JLabel();
        humidityText = new JLabel();
        visibilitaText = new JLabel();
        
        // Impostazione del contentPane del frame 
        setContentPane(contentPane);
      //  contentPane.setBounds(0, 0, 600, 400);
      //  contentPane.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/bcksunny.jpg")));
        contentPane.setLayout(null);
        
        //aggiunta delle label per le icone e descrizione di esse; ad ogni label appartiene una seconda label.Text dove verannò visualizzati i dati chiamati dall'API
        JLabel weatherDataLabel = new JLabel();
        weatherDataLabel.setToolTipText("");
        weatherDataLabel.setBounds(20, 70, 132, 85);
        weatherDataLabel.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        weatherDataLabel.setBackground(new Color(255, 255, 255, 100));
        weatherDataLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        weatherDataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        weatherDataLabel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mparty.png")));
        weatherDataLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        weatherDataLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        contentPane.add(weatherDataLabel);
        
        temperatureText.setBounds(20, 163, 132, 55);
        temperatureText.setBackground(new Color(255, 255, 255, 100));
        temperatureText.setHorizontalTextPosition(SwingConstants.CENTER);
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        temperatureText.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(temperatureText);
       
        weatherDescription.setBounds(20, 226, 133, 27);
        weatherDescription.setHorizontalTextPosition(SwingConstants.CENTER);
        weatherDescription.setHorizontalAlignment(SwingConstants.CENTER);
        weatherDescription.setBackground(new Color(255, 255, 255, 100));
        weatherDescription.setLayout(null);
        
        weatherDescription.setFont(new Font("Dialog", Font.BOLD, 12));
        weatherDescription.setText("Parzialmente Nuvoloso");
        contentPane.add(weatherDescription);
        
        CurrentDateText.setBounds(20, 265, 133, 111);
        CurrentDateText.setFont(new Font("Tahoma", Font.BOLD, 11));
        CurrentDateText.setHorizontalAlignment(SwingConstants.CENTER);
        CurrentDateText.setBackground(new Color(240, 240, 240, 100));
        contentPane.add(CurrentDateText);
 
        JLabel min = new JLabel();
        min.setBounds(167, 71, 97, 56);
        min.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        min.setMaximumSize(new Dimension(50, 70));
        min.setPreferredSize(new Dimension(70, 50));
        min.setVerticalTextPosition(SwingConstants.TOP);
        min.setVerticalAlignment(SwingConstants.BOTTOM);
        min.setOpaque(true);
        min.setHorizontalTextPosition(SwingConstants.CENTER);
        min.setHorizontalAlignment(SwingConstants.CENTER);
        min.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/hot.png")));
        min.setBackground(new Color(255, 255, 255, 100));
        min.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
        		contentPane.add(min);
        		
        		 maxText.setBounds(167, 134, 98, 24);
        		 maxText.setFont(new Font("Tahoma", Font.BOLD, 11));
        		 maxText.setHorizontalTextPosition(SwingConstants.CENTER);
        		 maxText.setHorizontalAlignment(SwingConstants.CENTER);
        		
        		 maxText.setBackground(new Color(255, 255, 255, 100));
        		 maxText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        		 contentPane.add(maxText);
 
        		JLabel max = new JLabel();
        		max.setBounds(166, 164, 99, 57);
        		max.setVerticalTextPosition(SwingConstants.TOP);
        		max.setVerticalAlignment(SwingConstants.TOP);
        		max.setOpaque(true);
        		max.setHorizontalTextPosition(SwingConstants.CENTER);
        		max.setHorizontalAlignment(SwingConstants.CENTER);
        		max.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/cold2.png")));
        		max.setBackground(new Color(255, 255, 255, 100));
        		max.setBorder(new LineBorder(new Color(128, 128, 255), 1, true));
        		contentPane.add(max);
        		
        		//JLabel maxText = new JLabel();
        		minText.setBounds(166, 228, 99, 25);
        		minText.setFont(new Font("Tahoma", Font.BOLD, 11));
        		minText.setHorizontalTextPosition(SwingConstants.CENTER);
        		minText.setHorizontalAlignment(SwingConstants.CENTER);
      
        		minText.setBackground(new Color(255, 255, 255, 100));
        		minText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        		contentPane.add(minText);

     JLabel windspeed = new JLabel("Vento");
     windspeed.setBounds(479, 71, 97, 58);
     windspeed.setBackground(new Color(240, 240, 240, 100));
     windspeed.setOpaque(true);
     windspeed.setFont(new Font("Tahoma", Font.BOLD, 10));
     windspeed.setHorizontalAlignment(SwingConstants.CENTER);
     windspeed.setText("Vento");
     windspeed.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     windspeed.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/windspeed2.png")));
	 windspeed.setHorizontalTextPosition(SwingConstants.CENTER);
	 windspeed.setAlignmentY(Component.TOP_ALIGNMENT);
	 windspeed.setVerticalAlignment(SwingConstants.TOP);
	 windspeed.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
    contentPane.add(windspeed);

     windspeedText.setBounds(479, 134, 98, 24);
     windspeedText.setHorizontalAlignment(SwingConstants.CENTER);
     windspeedText.setFont(new Font("Tahoma", Font.BOLD, 11));
   
     windspeedText.setBackground(new Color(240, 240, 240, 100));
     windspeedText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     contentPane.add(windspeedText);

     JLabel lblhumidity = new JLabel();
     lblhumidity.setBounds(272, 165, 99, 56);
     lblhumidity.setVerticalAlignment(SwingConstants.TOP);
     lblhumidity.setOpaque(true);
     lblhumidity.setBackground(new Color(240, 240, 240, 100));
     lblhumidity.setFont(new Font("Tahoma", Font.BOLD, 10));
    
     lblhumidity.setHorizontalAlignment(SwingConstants.CENTER);
     lblhumidity.setText("Umidità");
     lblhumidity.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     lblhumidity.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/humidity.png")));

	 lblhumidity.setHorizontalTextPosition(SwingConstants.CENTER);
	 lblhumidity.setAlignmentY(Component.TOP_ALIGNMENT);
	 lblhumidity.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(lblhumidity);
     
     humidityText.setBounds(272, 228, 98, 24);
     humidityText.setBackground(new Color(240, 240, 240, 100));
     humidityText.setFont(new Font("Tahoma", Font.BOLD, 11));
     humidityText.setHorizontalAlignment(SwingConstants.CENTER);
     humidityText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     contentPane.add(humidityText);
     
     JLabel Sunset = new JLabel("Sunset");
     Sunset.setBounds(479, 165, 99, 55);
     Sunset.setOpaque(true);
     Sunset.setBackground(new Color(240, 240, 240, 100));
     Sunset.setFont(new Font("Tahoma", Font.BOLD, 10));
     Sunset.setHorizontalAlignment(SwingConstants.CENTER);
     Sunset.setText("Tramonto");
     Sunset.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     Sunset.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/sunset2.png")));
     Sunset.setHorizontalTextPosition(SwingConstants.CENTER);
     Sunset.setAlignmentY(Component.TOP_ALIGNMENT);
     Sunset.setVerticalAlignment(SwingConstants.TOP);
     Sunset.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
    contentPane.add(Sunset);
     
     sunsetText.setBounds(480, 228, 98, 23);
     sunsetText.setHorizontalAlignment(SwingConstants.CENTER);
     sunsetText.setFont(new Font("Tahoma", Font.BOLD, 11));
     sunsetText.setBackground(new Color(240, 240, 240, 100));
     sunsetText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     contentPane.add(sunsetText);
     
     JLabel pressione = new JLabel("PressionePanel");
     pressione.setBounds(379, 71, 95, 57);
     pressione.setOpaque(true);
     pressione.setBackground(new Color(240, 240, 240, 100));
     pressione.setFont(new Font("Tahoma", Font.BOLD, 10));
     pressione.setHorizontalAlignment(SwingConstants.CENTER);
     pressione.setText("Pressione Atm");
     pressione.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     pressione.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Downloads\\WhatsApp Image 2024-02-20 at 23.23.10.jpeg"));

	 pressione.setHorizontalTextPosition(SwingConstants.CENTER);
	 pressione.setAlignmentY(Component.TOP_ALIGNMENT);
	 pressione.setVerticalAlignment(SwingConstants.TOP);
	 pressione.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(pressione);
     
     pressioneText.setBounds(379, 134, 94, 24);
     pressioneText.setBackground(new Color(240, 240, 240, 100));
     pressioneText.setHorizontalAlignment(SwingConstants.CENTER);
     pressioneText.setFont(new Font("Tahoma", Font.BOLD, 11));
     pressioneText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     contentPane.add(pressioneText);
     
  
     JLabel Sunrise = new JLabel("Alba");
     Sunrise.setBounds(378, 165, 96, 56);
     Sunrise.setOpaque(true);
     Sunrise.setBackground(new Color(255, 255, 255, 100));
     Sunrise.setFont(new Font("Tahoma", Font.BOLD, 10));
     Sunrise.setHorizontalAlignment(SwingConstants.CENTER);
    
     Sunrise.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     Sunrise.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\sunrise2.png"));
     
	 Sunrise.setHorizontalTextPosition(SwingConstants.CENTER);
	 Sunrise.setAlignmentY(Component.TOP_ALIGNMENT);
	 Sunrise.setVerticalAlignment(SwingConstants.TOP);
	 Sunrise.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(Sunrise);
     
     sunriseText.setBounds(377, 228, 97, 24);
     sunriseText.setHorizontalAlignment(SwingConstants.CENTER);
    
     sunriseText.setFont(new Font("Tahoma", Font.BOLD, 11));
     sunriseText.setBackground(new Color(240, 240, 240, 100));
     sunriseText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     contentPane.add(sunriseText);
    
     JLabel visibilità= new JLabel();
     visibilità.setForeground(new Color(0, 0, 0));
     visibilità.setBounds(274, 71, 96, 56);
     visibilità.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     visibilità.setBackground(new Color(240, 240, 240, 100));
     visibilità.setOpaque(true);
     visibilità.setFont(new Font("Tahoma", Font.BOLD, 10));
     visibilità.setHorizontalAlignment(SwingConstants.CENTER);
     visibilità.setText("Visibilità");
     visibilità.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     visibilità.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/fog.png")));
	 visibilità.setHorizontalTextPosition(SwingConstants.CENTER);
	 visibilità.setAlignmentY(Component.TOP_ALIGNMENT);
	 visibilità.setVerticalAlignment(SwingConstants.TOP);
	 contentPane.add(visibilità);
     
     visibilitaText.setBounds(273, 133, 97, 24);
     visibilitaText.setHorizontalTextPosition(SwingConstants.CENTER);
     visibilitaText.setHorizontalAlignment(SwingConstants.CENTER);
     visibilitaText.setFont(new Font("Tahoma", Font.BOLD, 11));
     visibilitaText.setBackground(new Color(255, 255, 255, 100));
     visibilitaText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     contentPane.add(visibilitaText);
     
   
     
      
	 
	   JPanel weatherForecastPanel = new JPanel();
	   weatherForecastPanel.setBounds(167, 264, 411, 109);
	   weatherForecastPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   weatherForecastPanel.setBackground(new Color(240, 240, 240, 100));
	   weatherForecastPanel.setAlignmentX(CENTER_ALIGNMENT);
	   weatherForecastPanel.setAlignmentY(CENTER_ALIGNMENT);
	 
       weatherForecastPanel.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
       contentPane.add(weatherForecastPanel);
       
	 weatherForecastPanel.setLayout(null);

	 JLabel lblLunedi = new JLabel();
	 lblLunedi.setVerticalTextPosition(SwingConstants.TOP);
	 lblLunedi.setFont(new Font("Tahoma", Font.BOLD, 11));
	 lblLunedi.setBounds(0, 6, 61, 60);
	 lblLunedi.setHorizontalAlignment(SwingConstants.CENTER);
	 lblLunedi.setSize(55, 65);
	 lblLunedi.setText("Lunedi");
	
	 lblLunedi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/cloudy.png")));

	 lblLunedi.setHorizontalTextPosition(SwingConstants.CENTER);
	  weatherForecastPanel.add(lblLunedi); 
	  
	  JLabel lunediText = new JLabel();
	  lunediText.setOpaque(true);
	  lunediText.setBackground(new Color(240, 240, 240, 100));
	  lunediText.setFont(new Font("Tahoma", Font.BOLD, 15));
	  lunediText.setHorizontalAlignment(SwingConstants.CENTER);
	  lunediText.setText("15°C");
	  lunediText.setBounds(0, 75, 55, 23);
	  weatherForecastPanel.add(lunediText);
	 

		 JLabel lblMartedi = new JLabel();
		 lblMartedi.setRequestFocusEnabled(false);
		 lblMartedi.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblMartedi.setBounds(56, 6, 55, 73);
		 lblMartedi.setSize(55, 65);
		 lblMartedi.setVerticalTextPosition(SwingConstants.TOP);
		
		 lblMartedi.setHorizontalAlignment(SwingConstants.CENTER);
		 lblMartedi.setText("Martedi");
	
		 lblMartedi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/msun.png")));
		
		 lblMartedi.setHorizontalTextPosition(SwingConstants.CENTER);
		 lblMartedi.setAlignmentY(Component.TOP_ALIGNMENT);
		  weatherForecastPanel.add(lblMartedi); 
		  
		  JLabel martediText = new JLabel();
		  martediText.setBackground(new Color(240, 240, 240, 100));
		  martediText.setHorizontalAlignment(SwingConstants.CENTER);
		  martediText.setText("17°C\r\n");
		  martediText.setFont(new Font("Tahoma", Font.BOLD, 15));
		  martediText.setOpaque(true);
		  martediText.setBounds(58, 75, 54, 23);
		  weatherForecastPanel.add(martediText);
		  

			 JLabel lblMercoledi = new JLabel();
			 lblMercoledi.setVerticalTextPosition(SwingConstants.TOP);
			 lblMercoledi.setFont(new Font("Tahoma", Font.BOLD, 11));
			 lblMercoledi.setBounds(115, 6, 55, 73);
			 lblMercoledi.setHorizontalAlignment(SwingConstants.CENTER);
			 lblMercoledi.setSize(55, 65);
			 lblMercoledi.setText("Mercoledi");
			
			 lblMercoledi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mparty.png")));
			 lblMercoledi.setHorizontalTextPosition(SwingConstants.CENTER);
			 lblMercoledi.setAlignmentY(Component.TOP_ALIGNMENT);
			  weatherForecastPanel.add(lblMercoledi); 
			  
			  JLabel mercolediText = new JLabel();
			  mercolediText.setBackground(new Color(240, 240, 240, 100));
			  mercolediText.setText("14°C");
			  mercolediText.setFont(new Font("Tahoma", Font.BOLD, 15));
			  mercolediText.setHorizontalAlignment(SwingConstants.CENTER);
			  mercolediText.setOpaque(true);
			  mercolediText.setBounds(115, 75, 55, 23);
			  weatherForecastPanel.add(mercolediText);
			  
			  JLabel lblGiovedi = new JLabel();
			  lblGiovedi.setVerticalTextPosition(SwingConstants.TOP);
			  lblGiovedi.setFont(new Font("Tahoma", Font.BOLD, 11));
				 lblGiovedi.setBounds(175, 5, 55, 64);
				 lblGiovedi.setSize(55, 65);
				
				 lblGiovedi.setHorizontalAlignment(SwingConstants.CENTER);
				 lblGiovedi.setText("Giovedi");
				 lblGiovedi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mrain.png")));
				 lblGiovedi.setHorizontalTextPosition(SwingConstants.CENTER);
				 lblGiovedi.setAlignmentY(Component.TOP_ALIGNMENT);
				  weatherForecastPanel.add(lblGiovedi); 
				  
				  JLabel giovediText = new JLabel();
				  giovediText.setBackground(new Color(240, 240, 240, 100));
				  giovediText.setHorizontalAlignment(SwingConstants.CENTER);
				  giovediText.setText("15°C");
				  giovediText.setFont(new Font("Tahoma", Font.BOLD, 15));
				  giovediText.setOpaque(true);
				  giovediText.setBounds(174, 75, 55, 23);
				  weatherForecastPanel.add(giovediText);
				  
				  JLabel lblVenerdi = new JLabel();
				  lblVenerdi.setFont(new Font("Tahoma", Font.BOLD, 11));
					 lblVenerdi.setBounds(232, 5, 55, 73);
					 lblVenerdi.setHorizontalAlignment(SwingConstants.CENTER);
					 lblVenerdi.setSize(55, 65);
					 lblVenerdi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/msun.png")));
					 lblVenerdi.setText("Venerdi");
					 lblVenerdi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);

					 lblVenerdi.setHorizontalTextPosition(SwingConstants.CENTER);
					 lblVenerdi.setAlignmentY(Component.TOP_ALIGNMENT);
					  weatherForecastPanel.add(lblVenerdi); 
					  
					  JLabel venerdiText = new JLabel();
					  venerdiText.setBackground(new Color(240, 240, 240, 100));
					  venerdiText.setFont(new Font("Tahoma", Font.BOLD, 15));
					  venerdiText.setText("20°C");
					  venerdiText.setHorizontalAlignment(SwingConstants.CENTER);
					  venerdiText.setOpaque(true);
					  venerdiText.setBounds(234, 75, 55, 23);
					  weatherForecastPanel.add(venerdiText);
					  
					  
					
					  JLabel lblSabato = new JLabel();
					  lblSabato.setFont(new Font("Tahoma", Font.BOLD, 11));
						 lblSabato.setBounds(290, 5, 55, 73);
						 lblSabato.setVerticalTextPosition(SwingConstants.TOP);
						 lblSabato.setHorizontalAlignment(SwingConstants.CENTER);
						 lblSabato.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/partly.png")));
						
						 lblSabato.setSize(55, 65);
						 
						 lblSabato.setText("Sabato");
						
						 lblSabato.setHorizontalTextPosition(SwingConstants.CENTER);
						 lblSabato.setAlignmentY(Component.TOP_ALIGNMENT);
						  weatherForecastPanel.add(lblSabato); 
			  
						  
						  JLabel sabatoText = new JLabel();
						  sabatoText.setBackground(new Color(240, 240, 240, 100));
						  sabatoText.setHorizontalAlignment(SwingConstants.CENTER);
						  sabatoText.setText("17°C");
						  sabatoText.setFont(new Font("Tahoma", Font.BOLD, 15));
						  sabatoText.setOpaque(true);
						  sabatoText.setBounds(294, 75, 55, 23);
						  weatherForecastPanel.add(sabatoText);
						  
						  JLabel lblDomenica = new JLabel();
						  lblDomenica.setFont(new Font("Tahoma", Font.BOLD, 11));
							 lblDomenica.setBounds(353, 4, 53, 65);
							 lblDomenica.setSize(55, 65);
							 lblDomenica.setVerticalTextPosition(SwingConstants.TOP);
							 lblDomenica.setHorizontalAlignment(SwingConstants.CENTER);
							 lblDomenica.setText("Domenica");
						
							 lblDomenica.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mrain.png")));

							 lblDomenica.setHorizontalTextPosition(SwingConstants.CENTER);
							 lblDomenica.setVerticalAlignment(SwingConstants.TOP);
							  weatherForecastPanel.add(lblDomenica); 
							  
							  JLabel domenicaText = new JLabel();
							  domenicaText.setBackground(new Color(240, 240, 240, 100));
							  domenicaText.setFont(new Font("Tahoma", Font.BOLD, 15));
							  domenicaText.setText("10°C");
							  domenicaText.setHorizontalAlignment(SwingConstants.CENTER);
							  domenicaText.setOpaque(true);
							  domenicaText.setBounds(354, 75, 55, 23);
							  weatherForecastPanel.add(domenicaText);
							  
							  JTextField searchTextField = new JTextField();
							  searchTextField.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
							  searchTextField.setBounds(275, 13, 173, 44);
							  contentPane.add(searchTextField);
							  
							  JButton domoButton = new JButton();
							  domoButton.addActionListener(new ActionListener() {
							  	public void actionPerformed(ActionEvent e) {
							  		 // Chiudi la finestra corrente (Interfaccia)
					                dispose();
							  		// Quando il pulsante viene premuto, crea un'istanza di InterfacciaDue e la rende visibile
					                InterfacciaDue interfacciaDue = new InterfacciaDue();
					                setLocationRelativeTo(null);
					                interfacciaDue.setVisible(true);
							  	}
							  });
							  domoButton.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
							  domoButton.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mhome.png")));
							  domoButton.setBounds(524, 13, 51, 45);
							  domoButton.setLayout(null);
							  contentPane.add(domoButton);
							  //PULSANTE CERCA PER IL METEO
							  JButton searchButton = new JButton();
							  searchButton.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
						
        
							  searchButton.setBounds(459, 13, 53, 45);
							  searchButton.setHorizontalTextPosition(SwingConstants.LEFT);
							  contentPane.add(searchButton);
							  searchButton.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/search.png")));

							  searchButton.addActionListener(new ActionListener() {
								    @Override
								    public void actionPerformed(ActionEvent e) {
								        String cityName = searchTextField.getText();
								        if (!cityName.isEmpty()) {
								            JSONObject weatherData = MeteoApp.getWeatherData(cityName);
								            if (weatherData != null) {
								                updateUI(weatherData);
								            } else {
								                JOptionPane.showMessageDialog(null, "Dati meteo non disponibili per questa città", "Errore", JOptionPane.ERROR_MESSAGE);
								            }
								        } else {
								            JOptionPane.showMessageDialog(null, "Inserire città", "Errore", JOptionPane.ERROR_MESSAGE);
								        }
								    }
								});
        }
        private void weatherData() {
			// TODO Auto-generated method stub
			
		}
		//METODO PER ESTRARRE I DATI DAL JSON, FORMATO SIA DA UN ARRAY E PIU' OGGETTI
								private void updateUI(JSONObject weatherData) {
									
			
								    JSONObject main = (JSONObject) weatherData.get("main");
								    JSONArray weatherArray = (JSONArray) weatherData.get("weather");
								    JSONObject weatherObject = (JSONObject) weatherArray.get(0);
								       
							    	JSONObject wind = (JSONObject) weatherData.get("wind");
					
							    	JSONObject sys = (JSONObject) weatherData.get("sys");
							        
								    if (main != null && weatherArray != null && weatherArray.size() > 0) {
								        
								    	long id = (long) weatherData.get("id");
								    	double temp = (double) main.get("temp");
								        double temp_min = (double) main.get("temp_min");
								        double temp_max = (double) main.get("temp_max");
								        long pressure = (long) main.get("pressure");
								        long humidity = (long) main.get("humidity");
								        String description = (String) weatherObject.get("description");
								        double windSpeed = (double) wind.get("speed");
								        long sunrise = (long) sys.get("sunrise");
								        long sunset = (long) sys.get("sunset");		
								        long visibility = (long) weatherData.get("visibility");
								        long dt = (long) weatherData.get("dt");
								        
								     // Aggiorna le etichette con i valori appropriati
								        updateTime(sunrise * 1000, sunset * 1000, dt * 1000);
								        
								        temperatureText.setText(String.valueOf(temp + " " + "°C"));
								        maxText.setText(String.valueOf(temp_max + " " + "°C"));
								        minText.setText(String.valueOf(temp_min + " " +  "°C"));
								        pressioneText.setText(String.valueOf(pressure + " " + "hPa"));
								        humidityText.setText(String.valueOf(humidity +  " " + "%"));
								        weatherDescription.setText(description);
								        windspeedText.setText(String.valueOf(windSpeed + " " + "m/h"));
								        visibilitaText.setText(String.valueOf(visibility + " " + "m"));
								        weatherDataLabel.setText(String.valueOf(dt));
								        
								        //gestione degli errori
								    } else {
								        temperatureText.setText("Errore");
								        maxText.setText("Errore");
								        minText.setText("Errore");
								        pressioneText.setText("Errore");
								        humidityText.setText("Errore");
								        weatherDescription.setText("Errore");
								        windspeedText.setText("Errore");
								        sunriseText.setText("Errore");
								        sunsetText.setText("Errore");
								        CurrentDateText.setText("Errore");
								        visibilitaText.setText("Errore");
								    }
								}
								
								private void updateTime(long sunrise, long sunset, long dt) {
									
									 TimeZone.setDefault(TimeZone.getTimeZone("UTC+1"));
							        // Conversione di timestamp in oggetti Date
							        Date sunriseDate = new Date(sunrise * 1000);
							        Date sunsetDate = new Date(sunset * 1000);
							        Date dtDate = new Date(dt * 1000);
							  
								// Formattazione delle date in stringhe leggibili
						        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
						        String formattedSunrise = dateFormat.format(sunriseDate);
						        String formattedSunset = dateFormat.format(sunsetDate);
						        String formattedDt = dateFormat.format(dtDate);
								
						        sunriseText.setText(" " + formattedSunrise);
						        sunsetText.setText(" " + formattedSunset);
						        CurrentDateText.setText(" " + formattedDt);
								
						    }
								
							    

								    public static void main(String[] args) {
								        SwingUtilities.invokeLater(() -> {
								            Interfaccia interfaccia = new Interfaccia();
								            interfaccia.setVisible(true);
								        });
								    }
								}