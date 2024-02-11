package com.meteoapp2;
 import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
			backgroundLabel.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\bcksunny.jpg"));
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
			 
		     
		     searchbar.setBounds(193, 9, 120, 20);
			searchbar.setFont(new Font("Dialog", Font.PLAIN, 15));
		     destroalto.add(searchbar);
		     searchbar.setColumns(10);
		     
		     JButton btnDomotica = new JButton("Domotica");
		     btnDomotica.setHorizontalTextPosition(SwingConstants.CENTER);
		     btnDomotica.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\mhome2.png"));
		     btnDomotica.setBounds(342, 7, 49, 49);
		     destroalto.add(btnDomotica);
		   
		     
	

		//carico immagini
		
        new ImageIcon ("app/src/assets/bcksunny.jpg");
        new ImageIcon("app/src/assets/cloudy.png");
        new ImageIcon("windspeed.png");
       new ImageIcon("rain.png");
        new ImageIcon("clear.png");
        new ImageIcon("snow.png");
     
        JPanel sinistro = new JPanel();
        sinistro.setBounds(19, 9, 141, 365);
        sinistro.setOpaque(false);
        sinistro.setBorder(new LineBorder(new Color(0, 0, 0)));
	    sinistro.setLayout(null);
        contentPane.add(sinistro);
        
        JLabel lblWeatherData = new JLabel(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\mparty.png"));
        lblWeatherData.setBounds(9, 10, 125, 180);
        ImageIcon image1 = new ImageIcon("cloudy.png");
        
        
        
        sinistro.setLayout(null);
        sinistro.setLayout(null);
        sinistro.add(lblWeatherData);
        
        
        
        JLabel lblDateTime = new JLabel("sinistrobassa");
        lblDateTime.setBounds(7, 274, 127, 80);
        sinistro.add(lblDateTime);
        
     ImageIcon ventoicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel label_1 = new JLabel("Vento");
     label_1.setFont(new Font("Tahoma", Font.BOLD, 10));
     label_1.setBounds(312, 91, 73, 62);
     label_1.setHorizontalAlignment(SwingConstants.CENTER);
     label_1.setText("Vento");
     label_1.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     label_1.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\windspeed2.png"));
     label_1.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 label_1.setHorizontalTextPosition(SwingConstants.CENTER);
	 label_1.setAlignmentY(Component.TOP_ALIGNMENT);
	 label_1.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(label_1);
     
     
     ImageIcon alerticon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
    
     JLabel lblMin = new JLabel("WeatherAlertPanel");
     lblMin.setFont(new Font("Tahoma", Font.BOLD, 10));
     lblMin.setBounds(66, 123, 75, 85);
     lblMin.setHorizontalAlignment(SwingConstants.CENTER);
     lblMin.setText("Min");
     lblMin.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     lblMin.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/cold2.png")));
     lblMin.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 lblMin.setHorizontalTextPosition(SwingConstants.CENTER);
	 lblMin.setAlignmentY(Component.TOP_ALIGNMENT);
	 lblMin.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(lblMin);
     
     
     ImageIcon alerticon2 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel lblMax = new JLabel("WeatherAlertPanel");
     lblMax.setFont(new Font("Tahoma", Font.BOLD, 10));
     lblMax.setBounds(1, 122, 73, 93);
    
     lblMax.setHorizontalAlignment(SwingConstants.CENTER);
     lblMax.setText("Max");
     lblMax.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     lblMax.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/hot2.png")));
     lblMax.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 lblMax.setHorizontalTextPosition(SwingConstants.CENTER);
	 lblMax.setAlignmentY(Component.TOP_ALIGNMENT);
	 lblMax.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(lblMax);
     
     
     
     
     ImageIcon sunriseicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel label_3 = new JLabel("Sunrise");
     label_3.setFont(new Font("Tahoma", Font.BOLD, 10));
     label_3.setBounds(316, 174, 62, 61);
     label_3.setHorizontalAlignment(SwingConstants.CENTER);
     label_3.setText("Tramonto");
     label_3.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     label_3.setIcon(sunriseicon);
     label_3.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 label_3.setHorizontalTextPosition(SwingConstants.CENTER);
	 label_3.setAlignmentY(Component.TOP_ALIGNMENT);
	 label_3.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(label_3);
     
     ImageIcon pressioneicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel label_4 = new JLabel("PressionePanel");
     label_4.setFont(new Font("Tahoma", Font.BOLD, 10));
     label_4.setBounds(204, 92, 79, 64);
     label_4.setHorizontalAlignment(SwingConstants.CENTER);
     label_4.setText("Pressione Atm");
     label_4.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     label_4.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\pressione2.png"));
     label_4.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 label_4.setHorizontalTextPosition(SwingConstants.CENTER);
	 label_4.setAlignmentY(Component.TOP_ALIGNMENT);
	 label_4.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(label_4);
     
     ImageIcon albaicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel label_5 = new JLabel("Sunrise");
     label_5.setFont(new Font("Tahoma", Font.BOLD, 10));
     label_5.setBounds(194, 173, 99, 74);
     label_5.setHorizontalAlignment(SwingConstants.CENTER);
     label_5.setText("Alba");
     label_5.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
     label_5.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\sunrise2.png"));
     label_5.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 label_5.setHorizontalTextPosition(SwingConstants.CENTER);
	 label_5.setAlignmentY(Component.TOP_ALIGNMENT);
	 label_5.setVerticalAlignment(SwingConstants.TOP);
     destroalto.add(label_5);
     
    
     AbstractButton btnSearch;
	destroalto.add(btnSearch);
    btnSearch.addActionListener(new ActionListener() {
   //     
     //@Override
         
   //  public void actionPerformed(ActionEvent e) {
           //  Perform search action here
         //   String searchText = btnSearch.getText();
         //    JOptionPane.showMessageDialog(btnSearch.this, "Città: " + searchText);
       //}
  // });
     
ImageIcon lunaicon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\sunset2.png");
     
     JLabel luna= new JLabel("Vento");
     luna.setFont(new Font("Tahoma", Font.BOLD, 12));
     luna.setBounds(13, 14, 135, 113);
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
	 lblLunedi.setBounds(-2, 8, 69, 73);
	 lblLunedi.setHorizontalAlignment(SwingConstants.CENTER);
	 lblLunedi.setText("Lunedi");
	 lblLunedi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
	 lblLunedi.setIcon(icon);
	 lblLunedi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
	 lblLunedi.setHorizontalTextPosition(SwingConstants.CENTER);
	 lblLunedi.setAlignmentY(Component.TOP_ALIGNMENT);
	 lblLunedi.setVerticalAlignment(SwingConstants.TOP);
	  weatherForecastPanel.add(lblLunedi); 
	        
	  ImageIcon icon2 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");

		 JLabel lblMartedi = new JLabel();
		 lblMartedi.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblMartedi.setBounds(56, 7, 69, 85);
		 lblMartedi.setHorizontalAlignment(SwingConstants.CENTER);
		 lblMartedi.setText("Martedi");
		 lblMartedi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
		 lblMartedi.setIcon(icon2);
		 lblMartedi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
		 lblMartedi.setHorizontalTextPosition(SwingConstants.CENTER);
		 lblMartedi.setAlignmentY(Component.TOP_ALIGNMENT);
		 lblMartedi.setVerticalAlignment(SwingConstants.TOP);
		  weatherForecastPanel.add(lblMartedi); 
		  
		  ImageIcon icon3 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");

			 JLabel lblMercoledi = new JLabel();
			 lblMercoledi.setFont(new Font("Tahoma", Font.BOLD, 11));
			 lblMercoledi.setBounds(116, 7, 69, 85);
			 lblMercoledi.setHorizontalAlignment(SwingConstants.CENTER);
			 lblMercoledi.setText("Mercoledi");
			 lblMercoledi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
			 lblMercoledi.setIcon(icon3);
			 lblMercoledi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
			 lblMercoledi.setHorizontalTextPosition(SwingConstants.CENTER);
			 lblMercoledi.setAlignmentY(Component.TOP_ALIGNMENT);
			 lblMercoledi.setVerticalAlignment(SwingConstants.TOP);
			  weatherForecastPanel.add(lblMercoledi); 
			  
			  ImageIcon icon4 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
			  JLabel lblGiovedi = new JLabel();
			  lblGiovedi.setFont(new Font("Tahoma", Font.BOLD, 11));
				 lblGiovedi.setBounds(171, 7, 69, 85);
				 lblGiovedi.setHorizontalAlignment(SwingConstants.CENTER);
				 lblGiovedi.setText("Giovedi");
				 lblGiovedi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
				 lblGiovedi.setIcon(icon4);
				 lblGiovedi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
				 lblGiovedi.setHorizontalTextPosition(SwingConstants.CENTER);
				 lblGiovedi.setAlignmentY(Component.TOP_ALIGNMENT);
				 lblGiovedi.setVerticalAlignment(SwingConstants.TOP);
				  weatherForecastPanel.add(lblGiovedi); 
		  
				  ImageIcon icon5 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
				  JLabel lblVenerdi = new JLabel();
				  lblVenerdi.setFont(new Font("Tahoma", Font.BOLD, 11));
					 lblVenerdi.setBounds(223, 7, 69, 85);
					 lblVenerdi.setHorizontalAlignment(SwingConstants.CENTER);
					 lblVenerdi.setText("Venerdi");
					 lblVenerdi.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
					 lblVenerdi.setIcon(new ImageIcon("C:\\Users\\15-DW1087\\Desktop\\MeteoApp2\\app\\src\\main\\java\\assets\\msun2.png"));
					 lblVenerdi.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
					 lblVenerdi.setHorizontalTextPosition(SwingConstants.CENTER);
					 lblVenerdi.setAlignmentY(Component.TOP_ALIGNMENT);
					 lblVenerdi.setVerticalAlignment(SwingConstants.TOP);
					  weatherForecastPanel.add(lblVenerdi); 
					  
					  ImageIcon icon6 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
					  JLabel lblSabato = new JLabel();
					  lblSabato.setFont(new Font("Tahoma", Font.BOLD, 11));
						 lblSabato.setBounds(277, 7, 69, 85);
						 lblSabato.setHorizontalAlignment(SwingConstants.CENTER);
						 lblSabato.setText("Sabato");
						 lblSabato.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
						 lblSabato.setIcon(icon6);
						 lblSabato.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
						 lblSabato.setHorizontalTextPosition(SwingConstants.CENTER);
						 lblSabato.setAlignmentY(Component.TOP_ALIGNMENT);
						 lblSabato.setVerticalAlignment(SwingConstants.TOP);
						  weatherForecastPanel.add(lblSabato); 
			  
						  ImageIcon icon7 = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
						  JLabel lblDomenica = new JLabel();
						  lblDomenica.setFont(new Font("Tahoma", Font.BOLD, 11));
							 lblDomenica.setBounds(334, 7, 69, 85);
							 lblDomenica.setHorizontalAlignment(SwingConstants.CENTER);
							 lblDomenica.setText("Domenica");
							 lblDomenica.setVerticalTextPosition(javax.swing.SwingConstants.NORTH);
							 lblDomenica.setIcon(icon7);
							 lblDomenica.setVerticalTextPosition(javax.swing.SwingConstants.SOUTH);
							 lblDomenica.setHorizontalTextPosition(SwingConstants.CENTER);
							 lblDomenica.setVerticalAlignment(SwingConstants.TOP);
							  weatherForecastPanel.add(lblDomenica); 
				  
		        
}





	public JPanel getContentPane() {
			return contentPane;
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





