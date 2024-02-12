package com.meteoapp2;
 import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import java.awt.Dimension;


public class Interfaccia extends JFrame {
	

	public Interfaccia() {
		
		
	}
	//Avvio dellapplicazione
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaccia frame = new Interfaccia();
				frame.setVisible(true);
				frame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			
				
			}
		});
	}

	ImageIcon bckicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
	 JLabel backgroundLabel = new JLabel();
	 backgroundLabel.setOpaque(false);
	 backgroundLabel.setLayout(null);
     backgroundLabel.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\bcksunny.jpg"));
     backgroundLabel.setBounds(0, 0, 300, 300);

		JPanel contentPane = new JPanel();{
			 contentPane.setOpaque(false);
				//Background
				ImageIcon bckicon = new ImageIcon("C:\\\\\\\\Users\\\\\\\\15-DW1087\\\\\\\\Desktop\\\\\\\\MeteoApp2\\\\\\\\app\\\\\\\\src\\\\\\\\main\\\\\\\\java\\\\\\\\assets\\\\\\\\bcksunny.jpg\"");
				 contentPane.setIcon(bckicon);
			contentPane.setBounds(0, 0, 600, 400);
			backgroundLabel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/bcksunny.jpg")));
			backgroundLabel.add(contentPane);
			 contentPane.setLayout(null);
		
			
			
			
			
			
			 JPanel destroalto = new JPanel();
			 destroalto.setBounds(183, 10, 404, 245);
		     contentPane.add(destroalto);
		
		destroalto.setOpaque(false); //
		     destroalto.setBackground(new Color(0, 255, 255));
		     destroalto.setBorder(null);
		     destroalto.setLayout(null);
		     
		     
			 JTextField searchbar = new JTextField();
		     searchbar.setBounds(153, 13, 120, 20);
			searchbar.setFont(new Font("Dialog", Font.PLAIN, 15));
		     destroalto.add(searchbar);
		     searchbar.setColumns(10);
		     
		     JButton searchbutton = new JButton();
		     searchbutton.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/search.png")));
		     searchbutton.setBounds(278, 11, 52, 47);
		     
		     searchbutton.setLayout(null);
		     
		     destroalto.add(searchbutton);
		     searchbutton.setVisible(true);
		     
		     
		     
		     JButton btnDomotica = new JButton("Domotica");
		     btnDomotica.setHorizontalTextPosition(SwingConstants.CENTER);
		     btnDomotica.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/mhome2.png")));
		     btnDomotica.setBounds(336, 11, 49, 49);
		     destroalto.add(btnDomotica);
		     btnDomotica.addActionListener(new ActionListener() {
		    	 public void actionPerformed(ActionEvent e) {
		    		 InterfacciaDue InterfacciaDue = new InterfacciaDue();
		    		 InterfacciaDue.setVisible(true);
		    		 InterfacciaDue.setOpaque(true);
		    		 dispose();
		    	 }
		     
		    	 
		     });
		   
		     
	

		//carico immagini
		
        new ImageIcon ("app/src/assets/bcksunny.jpg");
        new ImageIcon("app/src/assets/cloudy.png");
        new ImageIcon("windspeed.png");
       new ImageIcon("rain.png");
        new ImageIcon("clear.png");
        new ImageIcon("snow.png");
     
        JPanel sinistro = new JPanel();
        sinistro.setOpaque(false);
        sinistro.setBounds(19, 9, 141, 365);
        sinistro.setBorder(null);
        contentPane.add(sinistro);
        sinistro.setLayout(null);
        
        JLabel WeatherData = new JLabel(new ImageIcon(Interfaccia.class.getResource("/assets/parzialmentesereno.png")));
        WeatherData.setBackground(new Color(255, 255, 255, 100));
        WeatherData.setOpaque(true);
        WeatherData.setBounds(-1, 13, 139, 200);
        WeatherData.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        WeatherData.setText("Cesena, Italia");
        WeatherData.setHorizontalAlignment(SwingConstants.CENTER);
        WeatherData.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
        WeatherData.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/parzialmentesereno.png")));
        WeatherData.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
        WeatherData.setHorizontalTextPosition(SwingConstants.CENTER);
        WeatherData.setAlignmentY(Component.TOP_ALIGNMENT);
        WeatherData.setVerticalAlignment(SwingConstants.TOP);
        sinistro.add(WeatherData);
        
        JLabel temperatureText = new JLabel();
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        temperatureText.setFont(new Font("Tahoma", Font.BOLD, 25));
        temperatureText.setText("15°C");
        temperatureText.setBounds(19, 129, 102, 39);
        sinistro.add(temperatureText);
        temperatureText.setVisible(true);
        
        JLabel descrizioneMeteo = new JLabel ();
        descrizioneMeteo.setHorizontalAlignment(SwingConstants.CENTER);
        descrizioneMeteo.setFont(new Font("Tahoma", Font.BOLD, 11));
        descrizioneMeteo.setText("Parzialmente Nuvoloso");
        descrizioneMeteo.setBounds(1, 171, 135, 25);
        sinistro.add(descrizioneMeteo);
        
        
        
        JLabel CurrentDateTime = new JLabel();
        CurrentDateTime.setBackground(new Color(240, 240, 240, 100));
        CurrentDateTime.setBounds(2, 230, 136, 125);
        CurrentDateTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
        CurrentDateTime.setText("Data, Ora");
        CurrentDateTime.setHorizontalAlignment(SwingConstants.CENTER);
        CurrentDateTime.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
        CurrentDateTime.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
        CurrentDateTime.setHorizontalTextPosition(SwingConstants.CENTER);
        CurrentDateTime.setAlignmentY(Component.TOP_ALIGNMENT);
        CurrentDateTime.setVerticalAlignment(SwingConstants.TOP);
        sinistro.add(CurrentDateTime);
        CurrentDateTime.setVisible(true);
        CurrentDateTime.setOpaque(true);
        
        JLabel currentDateText = new JLabel();
        currentDateText.setFont(new Font("Tahoma", Font.PLAIN, 23));
        currentDateText.setText("12.02.2024");
        currentDateText.setHorizontalAlignment(SwingConstants.CENTER);
        currentDateText.setBackground(new Color(240, 240, 240, 100));
        currentDateText.setBounds(3, 259, 135, 38);
        sinistro.add(currentDateText);
        
        JLabel currentTimeText = new JLabel();
        currentTimeText.setFont(new Font("Tahoma", Font.PLAIN, 23));
        currentTimeText.setHorizontalAlignment(SwingConstants.CENTER);
        currentTimeText.setText("11:34");
        currentTimeText.setBackground(new Color(240, 240, 240, 100));
        currentTimeText.setBounds(3, 309, 137, 28);
        sinistro.add(currentTimeText);
        
        
 
     
     JLabel windspeed = new JLabel("Vento");
     windspeed.setBackground(new Color(240, 240, 240, 100));
     windspeed.setOpaque(true);
     windspeed.setFont(new Font("Tahoma", Font.BOLD, 10));
     windspeed.setBounds(295, 73, 99, 58);
     windspeed.setHorizontalAlignment(SwingConstants.CENTER);
     windspeed.setText("Vento");
     windspeed.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     windspeed.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/windspeed2.png")));
     windspeed.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 windspeed.setHorizontalTextPosition(SwingConstants.CENTER);
	 windspeed.setAlignmentY(Component.TOP_ALIGNMENT);
	 windspeed.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(windspeed);
     
     JLabel windspeedText = new JLabel();
     windspeedText.setHorizontalAlignment(SwingConstants.CENTER);
     windspeedText.setFont(new Font("Tahoma", Font.BOLD, 11));
     windspeedText.setOpaque(true);
     windspeedText.setText("10 km/h");
     windspeedText.setBackground(new Color(240, 240, 240, 100));
     windspeedText.setBounds(295, 135, 97, 16);
     destroalto.add(windspeedText);
     
     
     
     ImageIcon alerticon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     
     ImageIcon alerticon2 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel lblMax = new JLabel();
     lblMax.setOpaque(true);
     lblMax.setBackground(new Color(240, 240, 240, 100));
     lblMax.setFont(new Font("Tahoma", Font.BOLD, 10));
     lblMax.setBounds(90, 158, 92, 62);
    
     lblMax.setHorizontalAlignment(SwingConstants.CENTER);
     lblMax.setText("Umidità");
     lblMax.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     lblMax.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/humidity.png")));
     lblMax.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 lblMax.setHorizontalTextPosition(SwingConstants.CENTER);
	 lblMax.setAlignmentY(Component.TOP_ALIGNMENT);
	 lblMax.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(lblMax);
     
     JLabel humidityText = new JLabel();
     humidityText.setBackground(new Color(240, 240, 240, 100));
     humidityText.setFont(new Font("Tahoma", Font.BOLD, 11));
     humidityText.setHorizontalAlignment(SwingConstants.CENTER);
     humidityText.setText("60%");
     humidityText.setBounds(89, 223, 94, 20);
     humidityText.setOpaque(true);
     destroalto.add(humidityText);
     
     
     
     
     
     ImageIcon sunriseicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel label_3 = new JLabel("Sunrise");
     label_3.setOpaque(true);
     label_3.setBackground(new Color(240, 240, 240, 100));
     label_3.setFont(new Font("Tahoma", Font.BOLD, 10));
     label_3.setBounds(295, 157, 100, 60);
     label_3.setHorizontalAlignment(SwingConstants.CENTER);
     label_3.setText("Tramonto");
     label_3.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     label_3.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/sunset2.png")));
     label_3.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 label_3.setHorizontalTextPosition(SwingConstants.CENTER);
	 label_3.setAlignmentY(Component.TOP_ALIGNMENT);
	 label_3.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(label_3);
     
     JLabel sunsetText = new JLabel();
     sunsetText.setOpaque(true);
     sunsetText.setHorizontalAlignment(SwingConstants.CENTER);
     sunsetText.setFont(new Font("Tahoma", Font.BOLD, 11));
     sunsetText.setText("17.15");
     sunsetText.setBackground(new Color(240, 240, 240, 100));
     sunsetText.setBounds(295, 222, 99, 21);
     destroalto.add(sunsetText);
     
     ImageIcon pressioneicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel label_4 = new JLabel("PressionePanel");
     label_4.setOpaque(true);
     label_4.setBackground(new Color(240, 240, 240, 100));
     label_4.setFont(new Font("Tahoma", Font.BOLD, 10));
     label_4.setBounds(191, 73, 95, 57);
     label_4.setHorizontalAlignment(SwingConstants.CENTER);
     label_4.setText("Pressione Atm");
     label_4.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     label_4.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/pressione2.png")));
     label_4.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 label_4.setHorizontalTextPosition(SwingConstants.CENTER);
	 label_4.setAlignmentY(Component.TOP_ALIGNMENT);
	 label_4.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(label_4);
     
     JLabel pressioneText = new JLabel();
     pressioneText.setOpaque(true);
     pressioneText.setBackground(new Color(240, 240, 240, 100));
     pressioneText.setHorizontalAlignment(SwingConstants.CENTER);
     pressioneText.setFont(new Font("Tahoma", Font.BOLD, 11));
     pressioneText.setText("1.005 hPa");
     pressioneText.setBounds(190, 136, 95, 14);
     destroalto.add(pressioneText);
     
     ImageIcon albaicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel label_5 = new JLabel("Sunrise");
     label_5.setOpaque(true);
     label_5.setBackground(new Color(255, 255, 255, 100));
     label_5.setFont(new Font("Tahoma", Font.BOLD, 10));
     label_5.setBounds(189, 157, 99, 62);
     label_5.setHorizontalAlignment(SwingConstants.CENTER);
     label_5.setText("Alba: 07:15");
     label_5.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     label_5.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\sunrise2.png"));
     label_5.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 label_5.setHorizontalTextPosition(SwingConstants.CENTER);
	 label_5.setAlignmentY(Component.TOP_ALIGNMENT);
	 label_5.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(label_5);
     
     JLabel sunriseText = new JLabel();
     sunriseText.setOpaque(true);
     sunriseText.setHorizontalAlignment(SwingConstants.CENTER);
     sunriseText.setText("07:15");
     sunriseText.setFont(new Font("Tahoma", Font.BOLD, 11));
     sunriseText.setBackground(new Color(240, 240, 240, 100));
     sunriseText.setBounds(190, 223, 100, 19);
     destroalto.add(sunriseText);
    
     
ImageIcon lunaicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel luna= new JLabel("Vento");
     luna.setBackground(new Color(240, 240, 240, 100));
     luna.setOpaque(true);
     luna.setFont(new Font("Tahoma", Font.BOLD, 12));
     luna.setBounds(7, 12, 72, 104);
     luna.setHorizontalAlignment(SwingConstants.CENTER);
     luna.setText("Luna Piena");
     luna.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     luna.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/moon3.png")));
     luna.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 luna.setHorizontalTextPosition(SwingConstants.CENTER);
	 luna.setAlignmentY(Component.TOP_ALIGNMENT);
	 luna.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(luna);
   
     
      
	 
	   JPanel weatherForecastPanel = new JPanel();
	   weatherForecastPanel.setBounds(173, 270, 414, 103);
       weatherForecastPanel.setBorder(null);
       weatherForecastPanel.setVisible(true);
       weatherForecastPanel.setOpaque(false);
       contentPane.add(weatherForecastPanel);
       
     ImageIcon icon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
	 weatherForecastPanel.setLayout(null);

	 JLabel lblLunedi = new JLabel();
	 lblLunedi.setFont(new Font("Tahoma", Font.BOLD, 11));
	 lblLunedi.setBounds(-1, 8, 55, 73);
	 lblLunedi.setHorizontalAlignment(SwingConstants.CENTER);
	 lblLunedi.setText("Lunedi");
	 lblLunedi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
	 lblLunedi.setIcon(icon);
	 lblLunedi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 lblLunedi.setHorizontalTextPosition(SwingConstants.CENTER);
	 lblLunedi.setAlignmentY(Component.TOP_ALIGNMENT);
	 lblLunedi.setVerticalAlignment(SwingConstants.TOP);
	  weatherForecastPanel.add(lblLunedi); 
	  
	  JLabel lunediText = new JLabel();
	  lunediText.setOpaque(true);
	  lunediText.setBounds(-1, 75, 55, 23);
	  weatherForecastPanel.add(lunediText);
	  
	  
	        
	  ImageIcon icon2 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");

		 JLabel lblMartedi = new JLabel();
		 lblMartedi.setRequestFocusEnabled(false);
		 lblMartedi.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblMartedi.setBounds(54, 8, 55, 73);
		 lblMartedi.setHorizontalAlignment(SwingConstants.CENTER);
		 lblMartedi.setText("Martedi");
		 lblMartedi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
		 lblMartedi.setIcon(icon2);
		 lblMartedi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
		 lblMartedi.setHorizontalTextPosition(SwingConstants.CENTER);
		 lblMartedi.setAlignmentY(Component.TOP_ALIGNMENT);
		 lblMartedi.setVerticalAlignment(SwingConstants.TOP);
		  weatherForecastPanel.add(lblMartedi); 
		  
		  JLabel martediText = new JLabel();
		  martediText.setOpaque(true);
		  martediText.setBounds(58, 76, 55, 23);
		  weatherForecastPanel.add(martediText);
		  
		  
		  ImageIcon icon3 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");

			 JLabel lblMercoledi = new JLabel();
			 lblMercoledi.setFont(new Font("Tahoma", Font.BOLD, 11));
			 lblMercoledi.setBounds(111, 7, 55, 73);
			 lblMercoledi.setHorizontalAlignment(SwingConstants.CENTER);
			 lblMercoledi.setText("Mercoledi");
			 lblMercoledi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
			 lblMercoledi.setIcon(icon3);
			 lblMercoledi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
			 lblMercoledi.setHorizontalTextPosition(SwingConstants.CENTER);
			 lblMercoledi.setAlignmentY(Component.TOP_ALIGNMENT);
			 lblMercoledi.setVerticalAlignment(SwingConstants.TOP);
			  weatherForecastPanel.add(lblMercoledi); 
			  
			  JLabel mercolediText = new JLabel();
			  mercolediText.setOpaque(true);
			  mercolediText.setBounds(116, 76, 55, 23);
			  weatherForecastPanel.add(mercolediText);
			  
			  
			  ImageIcon icon4 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
			  JLabel lblGiovedi = new JLabel();
			  lblGiovedi.setFont(new Font("Tahoma", Font.BOLD, 11));
				 lblGiovedi.setBounds(175, 8, 55, 73);
				 lblGiovedi.setHorizontalAlignment(SwingConstants.CENTER);
				 lblGiovedi.setText("Giovedi");
				 lblGiovedi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
				 lblGiovedi.setIcon(icon4);
				 lblGiovedi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
				 lblGiovedi.setHorizontalTextPosition(SwingConstants.CENTER);
				 lblGiovedi.setAlignmentY(Component.TOP_ALIGNMENT);
				 lblGiovedi.setVerticalAlignment(SwingConstants.TOP);
				  weatherForecastPanel.add(lblGiovedi); 
				  
				  JLabel giovediText = new JLabel();
				  giovediText.setOpaque(true);
				  giovediText.setBounds(175, 77, 55, 23);
				  weatherForecastPanel.add(giovediText);
				  
		  
				  ImageIcon icon5 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
				  JLabel lblVenerdi = new JLabel();
				  lblVenerdi.setFont(new Font("Tahoma", Font.BOLD, 11));
					 lblVenerdi.setBounds(233, 7, 55, 73);
					 lblVenerdi.setHorizontalAlignment(SwingConstants.CENTER);
					 lblVenerdi.setText("Venerdi");
					 lblVenerdi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
					 lblVenerdi.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\msun2.png"));
					 lblVenerdi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
					 lblVenerdi.setHorizontalTextPosition(SwingConstants.CENTER);
					 lblVenerdi.setAlignmentY(Component.TOP_ALIGNMENT);
					 lblVenerdi.setVerticalAlignment(SwingConstants.TOP);
					  weatherForecastPanel.add(lblVenerdi); 
					  
					  JLabel venerdiText = new JLabel();
					  venerdiText.setOpaque(true);
					  venerdiText.setBounds(234, 78, 55, 23);
					  weatherForecastPanel.add(venerdiText);
					  
					  
					  ImageIcon icon6 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
					  JLabel lblSabato = new JLabel();
					  lblSabato.setFont(new Font("Tahoma", Font.BOLD, 11));
						 lblSabato.setBounds(292, 6, 55, 73);
						 lblSabato.setHorizontalAlignment(SwingConstants.CENTER);
						 lblSabato.setText("Sabato");
						 lblSabato.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
						 lblSabato.setIcon(icon6);
						 lblSabato.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
						 lblSabato.setHorizontalTextPosition(SwingConstants.CENTER);
						 lblSabato.setAlignmentY(Component.TOP_ALIGNMENT);
						 lblSabato.setVerticalAlignment(SwingConstants.TOP);
						  weatherForecastPanel.add(lblSabato); 
			  
						  
						  JLabel sabatoText = new JLabel();
						  sabatoText.setOpaque(true);
						  sabatoText.setBounds(294, 78, 55, 23);
						  weatherForecastPanel.add(sabatoText);
						  
						  
						  ImageIcon icon7 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
						  JLabel lblDomenica = new JLabel();
						  lblDomenica.setFont(new Font("Tahoma", Font.BOLD, 11));
							 lblDomenica.setBounds(355, 7, 55, 73);
							 lblDomenica.setHorizontalAlignment(SwingConstants.CENTER);
							 lblDomenica.setText("Domenica");
							 lblDomenica.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
							 lblDomenica.setIcon(icon7);
							 lblDomenica.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
							 lblDomenica.setHorizontalTextPosition(SwingConstants.CENTER);
							 lblDomenica.setVerticalAlignment(SwingConstants.TOP);
							  weatherForecastPanel.add(lblDomenica); 
							  
							  JLabel domenicaText = new JLabel();
							  domenicaText.setOpaque(true);
							  domenicaText.setBounds(353, 78, 55, 23);
							  weatherForecastPanel.add(domenicaText);
							  
		}
							  
     






	public JPanel getContentPane() {
			return contentPane;
		}

		private JButton newJButton() {
		// TODO Auto-generated method stub
		return null;
	}
		private JButton newJButton(Icon loadImage) {
		// TODO Auto-generated method stub
		return null;
	}

		public void setContentPane(JPanel contentPane) {
			this.contentPane = contentPane;
		}

	private Icon resourcePath(String string) {
		// TODO Auto-generated method stub
		return null;
	}





	private Icon loadImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}





	private void setOpacity(boolean b) {
		// TODO Auto-generated method stub
		
	}





	private Component sfondoImage() {
		// TODO Auto-generated method stub
		return null;
	}
}



