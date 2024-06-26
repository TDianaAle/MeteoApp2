
package com.meteoapp2;
 import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.awt.Toolkit;

public class Interfaccia extends JFrame {
	
	public static final long serialVersionUID = 1L;
	public JLabel temperatureText;
	public JLabel weatherDescription;
	public JLabel maxText;
        public JLabel minText;
	public JLabel pressioneText;
	private static  JLabel  CurrentDateText;
	public JLabel windspeedText;
	public JLabel sunsetText;
	public JLabel sunriseText;
	public JLabel humidityText; 
	private JLabel visibilitaText;
	public JButton domoButton;
	public JTextField searchTextField;
	
public Interfaccia(){
	
	setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaccia.class.getResource("/assets/partly.png")));

	setFont(new Font("Dialog", Font.BOLD, 10));
	setResizable(false);	
	// Inizializzazione del frame
        setTitle("Domoteo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(613, 434);
        setLocationRelativeTo(null);
        initComponents();
	}
        //inizializzazione dei componenti dell'interfaccia 
        private void initComponents() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(239, 239, 239), 5));
        contentPane.setBackground(new Color(0, 191, 191));
        maxText = new JLabel();
        minText = new JLabel();
        pressioneText = new JLabel();
        CurrentDateText = new JLabel();
        CurrentDateText.setHorizontalTextPosition(SwingConstants.CENTER);
        CurrentDateText.setText("<html><center>06-12-2014 <br> 14:36:00 </center></html>");
        CurrentDateText.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/backsunny.jpg")));
        CurrentDateText.setBorder(new LineBorder(new Color(239, 239, 239), 5, true));
        windspeedText = new JLabel();
        sunsetText = new JLabel();
        sunriseText = new JLabel();
        humidityText = new JLabel();
        visibilitaText = new JLabel();

        //Impostazione del contentPane del frame 
        setContentPane(contentPane);
      //contentPane.setBounds(0, 0, 600, 400);
      //contentPane.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/bcksunny.jpg")));
        contentPane.setLayout(null);
        
        //aggiunta delle label per le icone e descrizione di esse; ad ogni label appartiene una seconda label.Text dove verannò visualizzati i dati chiamati dall'API
        JLabel weatherDataLabel = new JLabel();
        weatherDataLabel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/bcksunny.jpg")));
        weatherDataLabel.setToolTipText("");
        weatherDataLabel.setBounds(20, 71, 130, 184);
        weatherDataLabel.setBorder(new LineBorder(new Color(239, 239, 239), 5, true));
        weatherDataLabel.setBackground(new Color(255, 255, 255, 100));
        weatherDataLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        weatherDataLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        contentPane.add(weatherDataLabel);
        weatherDataLabel.setLayout(null);
		
	// Inizializzazione delle variabili
        temperatureText = new JLabel();
        temperatureText.setVerticalTextPosition(SwingConstants.BOTTOM);
        temperatureText.setText("17°C");
        temperatureText.setIcon(new javax.swing.ImageIcon("src/main/resources/assets/clear.png"));
        temperatureText.setBounds(4, 2, 130, 148);
        weatherDataLabel.add(temperatureText);
        temperatureText.setBorder(new LineBorder(new Color(128, 128, 255), 0, true));
        temperatureText.setBackground(new Color(255, 255, 255, 100));
        temperatureText.setHorizontalTextPosition(SwingConstants.CENTER);
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        temperatureText.setFont(new Font("Tahoma", Font.BOLD, 24));
		
        weatherDescription = new JLabel();
        weatherDescription.setBounds(-1, 157, 137, 25);
        weatherDataLabel.add(weatherDescription);
        weatherDescription.setBorder(new LineBorder(new Color(128, 128, 255), 0, true));
        weatherDescription.setForeground(new Color(0, 0, 0));
        weatherDescription.setHorizontalTextPosition(SwingConstants.CENTER);
        weatherDescription.setHorizontalAlignment(SwingConstants.CENTER);
        weatherDescription.setBackground(new Color(255, 255, 255, 100));
        weatherDescription.setLayout(null);
        weatherDescription.setFont(new Font("Dialog", Font.BOLD, 12));
        weatherDescription.setText("sereno");
        
        CurrentDateText.setBounds(18, 265, 133, 111);
        CurrentDateText.setFont(new Font("Tahoma", Font.BOLD, 14));
        CurrentDateText.setHorizontalAlignment(SwingConstants.CENTER);
        CurrentDateText.setBackground(new Color(240, 240, 240, 100));
        contentPane.add(CurrentDateText);
        
        // Ottieni la data e l'ora correnti
        Date currentDate = new Date();
		
        // Formatta la data e l'ora correnti	
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        String formattedDateTime = dateFormat.format(currentDate);
            
	 // Imposta il testo del label con la data e l'ora correnti
        CurrentDateText.setText(formattedDateTime);
        
        JLabel min = new JLabel();
        min.setOpaque(true);
        min.setBounds(167, 71, 97, 56);
        min.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
        min.setHorizontalTextPosition(SwingConstants.CENTER);
        min.setHorizontalAlignment(SwingConstants.CENTER);
        min.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/hot.png")));
        min.setBackground(new Color(255, 255, 255, 100));
        contentPane.add(min);
        		
        maxText.setBounds(167, 134, 98, 24);
	maxText.setFont(new Font("Tahoma", Font.BOLD, 11));
        maxText.setHorizontalTextPosition(SwingConstants.CENTER);
        maxText.setHorizontalAlignment(SwingConstants.CENTER);
        maxText.setBackground(new Color(255, 255, 255, 100));
        maxText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
        contentPane.add(maxText);
 
        JLabel max = new JLabel();
        max.setOpaque(true);
        max.setBounds(165, 165, 99, 56);
        max.setHorizontalTextPosition(SwingConstants.CENTER);
        max.setHorizontalAlignment(SwingConstants.CENTER);
        max.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/cold.png")));
        max.setBackground(new Color(255, 255, 255, 100));
        max.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
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
    	windspeed.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/windspeed2.png")));
     	windspeed.setBounds(484, 71, 94, 56);
     	windspeed.setBackground(new Color(240, 240, 240, 100));
     	windspeed.setOpaque(true);
     	windspeed.setFont(new Font("Tahoma", Font.BOLD, 10));
     	windspeed.setHorizontalAlignment(SwingConstants.CENTER);
     	windspeed.setText("");
     	windspeed.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
	windspeed.setHorizontalTextPosition(SwingConstants.CENTER);
	windspeed.setAlignmentY(Component.TOP_ALIGNMENT);
	windspeed.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
    	contentPane.add(windspeed);

     	windspeedText.setBounds(484, 134, 94, 24);
     	windspeedText.setHorizontalAlignment(SwingConstants.CENTER);
     	windspeedText.setFont(new Font("Tahoma", Font.BOLD, 11));
   
    	windspeedText.setBackground(new Color(240, 240, 240, 100));
    	windspeedText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     	contentPane.add(windspeedText);

     	JLabel lblhumidity = new JLabel();
     	lblhumidity.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/humidity.png")));
     	lblhumidity.setBounds(273, 165, 96, 56);
     	lblhumidity.setVerticalAlignment(SwingConstants.TOP);
     	lblhumidity.setOpaque(true);
     	lblhumidity.setBackground(new Color(240, 240, 240, 100));
     	lblhumidity.setFont(new Font("Tahoma", Font.BOLD, 10));
     	lblhumidity.setHorizontalAlignment(SwingConstants.CENTER);
     	lblhumidity.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
	lblhumidity.setHorizontalTextPosition(SwingConstants.CENTER);
	lblhumidity.setAlignmentY(Component.TOP_ALIGNMENT);
	lblhumidity.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
     	contentPane.add(lblhumidity);
		
     	humidityText.setBounds(272, 228, 98, 24);
     	humidityText.setBackground(new Color(240, 240, 240, 100));
     	humidityText.setFont(new Font("Tahoma", Font.BOLD, 11));
     	humidityText.setHorizontalAlignment(SwingConstants.CENTER);
     	humidityText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     	contentPane.add(humidityText);
     
     	JLabel Sunset = new JLabel("Sunset");
     	Sunset.setBounds(484, 165, 94, 56);
     	Sunset.setOpaque(true);
     	Sunset.setBackground(new Color(240, 240, 240, 100));
     	Sunset.setFont(new Font("Tahoma", Font.BOLD, 10));
     	Sunset.setHorizontalAlignment(SwingConstants.CENTER);
     	Sunset.setText("");
     	Sunset.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     	Sunset.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/sunset.clipart-md.png")));
     	Sunset.setHorizontalTextPosition(SwingConstants.CENTER);
     	Sunset.setAlignmentY(Component.TOP_ALIGNMENT);
     	Sunset.setVerticalAlignment(SwingConstants.TOP);
     	Sunset.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
    	contentPane.add(Sunset);
     
	sunsetText.setBounds(483, 228, 94, 23);
	sunsetText.setHorizontalAlignment(SwingConstants.CENTER);
	sunsetText.setFont(new Font("Tahoma", Font.BOLD, 11));
	sunsetText.setBackground(new Color(240, 240, 240, 100));
	sunsetText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
	contentPane.add(sunsetText);
     
	JLabel pressione = new JLabel("PressionePanel");
	pressione.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/pressure.png")));
	pressione.setBounds(379, 71, 95, 56);
	pressione.setOpaque(true);
	pressione.setBackground(new Color(240, 240, 240, 100));
	pressione.setFont(new Font("Tahoma", Font.BOLD, 10));
	pressione.setHorizontalAlignment(SwingConstants.CENTER);
	pressione.setText("");
	pressione.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
	pressione.setHorizontalTextPosition(SwingConstants.CENTER);
	pressione.setAlignmentY(Component.TOP_ALIGNMENT);
	pressione.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
     	contentPane.add(pressione);
     
     	pressioneText.setBounds(379, 134, 94, 24);
     	pressioneText.setBackground(new Color(240, 240, 240, 100));
     	pressioneText.setHorizontalAlignment(SwingConstants.CENTER);
     	pressioneText.setFont(new Font("Tahoma", Font.BOLD, 11));
     	pressioneText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     	contentPane.add(pressioneText);
		
     	JLabel Sunrise = new JLabel("");
     	Sunrise.setVerticalAlignment(SwingConstants.TOP);
     	Sunrise.setVerticalTextPosition(SwingConstants.TOP);
     	Sunrise.setBounds(378, 165, 96, 56);
     	Sunrise.setOpaque(true);
     	Sunrise.setBackground(new Color(255, 255, 255, 100));
     	Sunrise.setFont(new Font("Tahoma", Font.BOLD, 10));
     	Sunrise.setHorizontalAlignment(SwingConstants.CENTER);
     	Sunrise.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/sunrise-clipart-md.png")));
	Sunrise.setHorizontalTextPosition(SwingConstants.CENTER);
	Sunrise.setAlignmentY(Component.TOP_ALIGNMENT);
	Sunrise.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
     	contentPane.add(Sunrise);
     
     	sunriseText.setBounds(377, 228, 97, 24);
     	sunriseText.setHorizontalAlignment(SwingConstants.CENTER);
     	sunriseText.setFont(new Font("Tahoma", Font.BOLD, 11));
     	sunriseText.setBackground(new Color(240, 240, 240, 100));
     	sunriseText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     	contentPane.add(sunriseText);
    
     	JLabel visibilita= new JLabel();
     	visibilita.setForeground(new Color(0, 0, 0));
     	visibilita.setBounds(274, 71, 96, 56);
     	visibilita.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
     	visibilita.setBackground(new Color(240, 240, 240, 100));
     	visibilita.setOpaque(true);
     	visibilita.setFont(new Font("Tahoma", Font.BOLD, 10));
     	visibilita.setHorizontalAlignment(SwingConstants.CENTER);
     	visibilita.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     	visibilita.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/fog2.png")));
	visibilita.setHorizontalTextPosition(SwingConstants.CENTER);
	visibilita.setAlignmentY(Component.TOP_ALIGNMENT);
	visibilita.setVerticalAlignment(SwingConstants.TOP);
	contentPane.add(visibilita);
     
     	visibilitaText.setBounds(273, 133, 97, 24);
     	visibilitaText.setHorizontalTextPosition(SwingConstants.CENTER);
     	visibilitaText.setHorizontalAlignment(SwingConstants.CENTER);
     	visibilitaText.setFont(new Font("Tahoma", Font.BOLD, 11));
     	visibilitaText.setBackground(new Color(255, 255, 255, 100));
     	visibilitaText.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
     	contentPane.add(visibilitaText);
		
	JLabel weatherForecastPanel = new JLabel();
	weatherForecastPanel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/bcksunny.jpg")));
	weatherForecastPanel.setBounds(167, 264, 411, 109);   
	weatherForecastPanel.setBackground(new Color(240, 240, 240, 100));
	weatherForecastPanel.setAlignmentX(CENTER_ALIGNMENT);
	weatherForecastPanel.setAlignmentY(CENTER_ALIGNMENT); 
        weatherForecastPanel.setBorder(new LineBorder(new Color(239, 239, 239), 5, true));
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
	lblMartedi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/clear.png")));
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
        lblMercoledi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/partly.png")));
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
	lblGiovedi.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/partly.png")));
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
	lblSabato.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/msun.png")));
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
	lblDomenica.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/partly.png")));
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
	searchTextField.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
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
		
	domoButton.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
	domoButton.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mhome.png")));
	domoButton.setBounds(524, 13, 51, 45);
	domoButton.setLayout(null);
	domoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	contentPane.add(domoButton);
	domoButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		 // Chiudi la finestra corrente (InterfacciaDue)
		dispose();
		}
	});					

	//PULSANTE CERCA PER IL METEO
	JButton searchButton = new JButton();
	searchButton.setBackground(new Color(255, 255, 255));
	searchButton.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
	searchButton.setBounds(459, 13, 53, 45);
	searchButton.setHorizontalTextPosition(SwingConstants.LEFT);
	searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	contentPane.add(searchButton);
	searchButton.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/search.png")));
	searchButton.addActionListener(new ActionListener() {
	 @Override
		 public void actionPerformed(ActionEvent e) {
		String cityName = searchTextField.getText();
			if (!cityName.isEmpty()) {
			JSONObject weatherData = MeteoApp.getWeatherData(cityName);
				if (weatherData != null) {
					try {
						updateUI(weatherData);
					} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}   
				} else {
				 JOptionPane.showMessageDialog(null, "Dati meteo non disponibili per questa città", "Errore", JOptionPane.ERROR_MESSAGE);
					 }
			} else {
			JOptionPane.showMessageDialog(null, "Inserire città", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		}
				
	});
        }
 	//METODO PER ESTRARRE I DATI DAL JSON, FORMATO DA UN ARRAY E PIU' OGGETTI
	
		public void updateUI(JSONObject weatherData) throws JSONException {
				
			JSONObject main = (JSONObject) weatherData.get("main");					 
			JSONObject wind = (JSONObject) weatherData.get("wind");		
			JSONObject sys = (JSONObject) weatherData.get("sys");				    	
			JSONArray weatherArray = (JSONArray) weatherData.get("weather"); // Ottieni l'array "weather"
				 if (main != null && wind != null && sys != null && weatherArray != null && weatherArray.size() > 0) {
					// Estrarre i dati dall'array "weather"
					JSONObject weather = (JSONObject) weatherArray.get(0); // Prendi il primo elemento dell'array 
					double temp = 0.0;
						try {
							temp = (double)main.get("temp");
						}
						catch (Exception e) {
							Long longTemp = (long) main.get("temp");
							temp= longTemp.doubleValue();
						}
						//double temp = (double) main.get("temp");
						double temp_min = (double) main.get("temp_min");
						double temp_max = (double) main.get("temp_max");
						long pressure = (long) main.get("pressure");
						long humidity = (long) main.get("humidity");
						String description = (String) weather.get("description");
						double windSpeed = (double) wind.get("speed");
						long sunrise = (long) sys.get("sunrise");
						long sunset = (long) sys.get("sunset");	
						long visibility = (long) weatherData.get("visibility");
					 
						Object sunriseObject = sys.get("sunrise");
							if (sunriseObject instanceof Long) {
								sunrise = (Long) sunriseObject;
							} else if (sunriseObject instanceof Integer) {
								sunrise = ((Integer) sunriseObject).longValue();
							} else {
								throw new IllegalArgumentException("Valore non valido per sunrise: " + sunriseObject);
							}

						 Object sunsetObject = sys.get("sunset");
							if (sunsetObject instanceof Long) {
								sunset = (Long) sunsetObject;
							} else if (sunsetObject instanceof Integer) {
								sunset = ((Integer) sunsetObject).longValue();
							} else {
								throw new IllegalArgumentException("Valore non valido per sunset: " + sunsetObject);
							}
								      
							temperatureText.setText(String.valueOf(temp + "°C"));
							maxText.setText(String.valueOf(temp_max + "°C"));
							minText.setText(String.valueOf(temp_min + "°C"));
							pressioneText.setText(String.valueOf(pressure + " " + "hPa"));
							humidityText.setText(String.valueOf(humidity +  " " + "%"));
							weatherDescription.setText(description + " ");
							windspeedText.setText(String.valueOf(windSpeed + " " + "m/h"));
							sunriseText.setText(String.valueOf(sunrise));
							sunsetText.setText(String.valueOf(sunset));
							visibilitaText.setText(String.valueOf(visibility + " " + "m"));
					 
							// Converti il timestamp di alba e tramonto in oggetti Date
							 Date sunriseDate = new Date(sunrise * 1000);
							 Date sunsetDate = new Date(sunset * 1000);

							 // Formatta le date in stringhe leggibili
							 SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
							 String formattedSunrise = dateFormat.format(sunriseDate);
							 String formattedSunset = dateFormat.format(sunsetDate);

							 // Imposta il testo dei componenti dell'interfaccia utente con le stringhe formattate
							 sunriseText.setText(formattedSunrise);
							 sunsetText.setText(formattedSunset);
							    }
							}
			
							// public void actionPerformed(ActionEvent e) {
							//   dispose(); // Nascondi la prima interfaccia
							//  }
							public static void main(String[] args) {
							SwingUtilities.invokeLater(() -> {
								Interfaccia interfaccia = new Interfaccia(); // Creazione dell'istanza della classe Interfaccia
									interfaccia.setVisible(true);
								});
							}
						}
								
