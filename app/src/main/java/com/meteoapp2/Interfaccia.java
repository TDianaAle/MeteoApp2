package com.meteoapp2;
 import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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


public class Interfaccia extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
    private JLabel temperatureText;
	private JLabel weatherDescription;
	private JLabel maxText;
    private JLabel minText;
	private JLabel pressioneText;
	private static  JLabel  CurrentDateText;
	private static  JLabel CurrentTimeText;
	private JLabel windspeedText;
	private JLabel sunsetText;
	private JLabel sunriseText;
	private JLabel humidityText; 
	private JLabel visibilitaText;

	
	public Interfaccia() {
		
		
		// Inizializzazione del frame
        setTitle("Domoteo");
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(616, 432);
    
	}
        //inizializzazione dei componenti dell'interfaccia utente
  
        private void initComponents() {
        JPanel contentPane = new JPanel();
        contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setLayout(null);
        
        
        // Inizializzazione delle variabili
        temperatureText = new JLabel();
        maxText = new JLabel();
        minText = new JLabel();
        pressioneText = new JLabel();
        weatherDescription = new JLabel();
        weatherDescription.setVerticalAlignment(SwingConstants.TOP);
        weatherDescription.setForeground(new Color(0, 0, 0));
        weatherData();
        CurrentDateText = new JLabel();
        CurrentDateText.setVerticalAlignment(SwingConstants.TOP);
        CurrentTimeText = new JLabel();
        CurrentTimeText.setVerticalAlignment(SwingConstants.TOP);
        windspeedText = new JLabel();
        sunsetText = new JLabel();
        sunriseText = new JLabel();
        humidityText = new JLabel();
        visibilitaText = new JLabel();
        
        // Impostazione del contentPane del frame 
        setContentPane(contentPane);
        contentPane.setBounds(0, 0, 600, 400);
        contentPane.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/bcksunny.jpg")));
        contentPane.setLayout(null);
        
        //aggiunta delle label per le icone e descrizione di esse; ad ogni label appartiene una seconda label.Text dove verannò visualizzati i dati chiamati dall'API
        JLabel weatherDataLabel = new JLabel();
        weatherDataLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        weatherDataLabel.setToolTipText("");
        weatherDataLabel.setBounds(20, 70, 133, 85);
        weatherDataLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
        weatherDataLabel.setBackground(new Color(255, 255, 255, 100));
        weatherDataLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        weatherDataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        weatherDataLabel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mparty.png")));
        weatherDataLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        weatherDataLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        contentPane.add(weatherDataLabel);
        
        temperatureText.setBounds(20, 163, 134, 55);
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
        
        CurrentDateText.setBounds(19, 264, 135, 38);
        CurrentDateText.setFont(new Font("Tahoma", Font.BOLD, 11));
        CurrentDateText.setText("");
        CurrentDateText.setHorizontalAlignment(SwingConstants.CENTER);
        CurrentDateText.setBackground(new Color(240, 240, 240, 100));
        contentPane.add(CurrentDateText);
         
        CurrentTimeText.setBounds(17, 318, 136, 54);
        CurrentTimeText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        CurrentTimeText.setHorizontalAlignment(SwingConstants.CENTER);
        CurrentTimeText.setText("");
        CurrentTimeText.setBackground(new Color(240, 240, 240, 100));
        contentPane.add(CurrentTimeText);
        
        JLabel min = new JLabel();
        min.setBounds(167, 70, 99, 58);
        min.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
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
        		 maxText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
        		 contentPane.add(maxText);
 
        		JLabel max = new JLabel();
        		max.setBounds(166, 163, 99, 58);
        		max.setVerticalTextPosition(SwingConstants.TOP);
        		max.setVerticalAlignment(SwingConstants.TOP);
        		max.setOpaque(true);
        		max.setHorizontalTextPosition(SwingConstants.CENTER);
        		max.setHorizontalAlignment(SwingConstants.CENTER);
        		max.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/cold2.png")));
        		max.setBackground(new Color(255, 255, 255, 100));
        		max.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
        		contentPane.add(max);
        		
        		//JLabel maxText = new JLabel();
        		minText.setBounds(166, 227, 99, 26);
        		minText.setFont(new Font("Tahoma", Font.BOLD, 11));
        		minText.setHorizontalTextPosition(SwingConstants.CENTER);
        		minText.setHorizontalAlignment(SwingConstants.CENTER);
      
        		minText.setBackground(new Color(255, 255, 255, 100));
        		minText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
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

     windspeedText.setBounds(479, 134, 98, 22);
     windspeedText.setHorizontalAlignment(SwingConstants.CENTER);
     windspeedText.setFont(new Font("Tahoma", Font.BOLD, 11));
   
     windspeedText.setBackground(new Color(240, 240, 240, 100));
     windspeedText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(windspeedText);

     JLabel lblhumidity = new JLabel();
     lblhumidity.setBounds(272, 162, 102, 59);
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
     
     humidityText.setBounds(272, 226, 102, 26);
     humidityText.setBackground(new Color(240, 240, 240, 100));
     humidityText.setFont(new Font("Tahoma", Font.BOLD, 11));
     humidityText.setHorizontalAlignment(SwingConstants.CENTER);
     humidityText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(humidityText);
     
     JLabel Sunset = new JLabel("Sunset");
     Sunset.setBounds(479, 162, 99, 58);
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
     
     sunsetText.setBounds(480, 226, 98, 27);
     sunsetText.setHorizontalAlignment(SwingConstants.CENTER);
     sunsetText.setFont(new Font("Tahoma", Font.BOLD, 11));
     sunsetText.setBackground(new Color(240, 240, 240, 100));
     sunsetText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
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
     pressioneText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(pressioneText);
     
  
     JLabel Sunrise = new JLabel("Alba");
     Sunrise.setBounds(378, 163, 96, 58);
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
     
     sunriseText.setBounds(379, 227, 95, 25);
     sunriseText.setHorizontalAlignment(SwingConstants.CENTER);
    
     sunriseText.setFont(new Font("Tahoma", Font.BOLD, 11));
     sunriseText.setBackground(new Color(240, 240, 240, 100));
     sunriseText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(sunriseText);
    
     JLabel visibilità= new JLabel();
     visibilità.setForeground(new Color(0, 0, 0));
     visibilità.setBounds(274, 70, 99, 57);
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
     
     visibilitaText.setBounds(273, 133, 101, 24);
     visibilitaText.setHorizontalTextPosition(SwingConstants.CENTER);
     visibilitaText.setHorizontalAlignment(SwingConstants.CENTER);
     visibilitaText.setFont(new Font("Tahoma", Font.BOLD, 11));
     visibilitaText.setBackground(new Color(255, 255, 255, 100));
     visibilitaText.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
     contentPane.add(visibilitaText);
     
   
     
      
	 
	   JPanel weatherForecastPanel = new JPanel();
	   weatherForecastPanel.setBounds(167, 264, 411, 109);
	   weatherForecastPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   weatherForecastPanel.setBackground(new Color(240, 240, 240, 100));
	   weatherForecastPanel.setAlignmentX(CENTER_ALIGNMENT);
	   weatherForecastPanel.setAlignmentY(CENTER_ALIGNMENT);
	 
       weatherForecastPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 255)));
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
							  searchTextField.setBounds(317, 12, 122, 34);
							  contentPane.add(searchTextField);
							  
							  JButton domoButton = new JButton();
							  domoButton.setLayout(null);
							  contentPane.add(domoButton);
							  //PULSANTE CERCA PER IL METEO
							  JButton searchButton = new JButton();
						
        
							  searchButton.setBounds(455, 11, 55, 49);
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
								        
								        temperatureText.setText(String.valueOf(temp + " " + "°C"));
								        maxText.setText(String.valueOf(temp_max + " " + "°C"));
								        minText.setText(String.valueOf(temp_min + " " +  "°C"));
								        pressioneText.setText(String.valueOf(pressure + " " + "hPa"));
								        humidityText.setText(String.valueOf(humidity +  " " + "%"));
								        weatherDescription.setText(description);
								        windspeedText.setText(String.valueOf(windSpeed + " " + "m/h"));
								        sunriseText.setText(String.valueOf(sunrise*1000));
								        sunsetText.setText(String.valueOf(sunset*1000));
								        visibilitaText.setText(String.valueOf(visibility + " " + "m"));
								        
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
								        visibilitaText.setText("Errore");
								   
								    }
								}

								public static void main(String[] args) {
							        // imposto l'orario e la data corrente nelle relative label
								
							        String currentDateTime = getCurrentDateTime();{

							        // Imposta la data attuale nella label CurrentDateText
							       CurrentDateText.setText(currentDateTime.split(" ")[0]);

							        // Imposta l'orario attuale nella label CurrentTimeText
							         CurrentTimeText.setText(currentDateTime.split(" ")[1]);
							      
							
    SwingUtilities.invokeLater(() -> new Interfaccia());
							        }
								}
								private static String getCurrentDateTime() {
									// TODO Auto-generated method stub
									return null;
								}
}
