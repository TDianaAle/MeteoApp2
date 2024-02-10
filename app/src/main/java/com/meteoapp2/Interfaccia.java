package com.meteoapp2;
 import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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


		

		JPanel contentPane = new JPanel();{
			 contentPane.setLayout(null);
				//Background
				ImageIcon background_image = new ImageIcon("bcksunny.jpg");
			Image img = background_image.getImage();
			Image temp_img = img.getScaledInstance(555, 350, Image.SCALE_SMOOTH);
			contentPane.setBounds(0, 0, 600, 400);
			contentPane.setVisible(true);
		
			contentPane.setBackground(Color.PINK);
			
			
			
			
			
			 JPanel destroalto = new JPanel();
		     destroalto.setBounds(218, 22, 357, 202);
		     contentPane.add(destroalto);
		
		destroalto.setOpaque(false); //
		     destroalto.setBackground(new Color(0, 255, 255));
		     destroalto.setBorder(new LineBorder(new Color(0, 0, 0)));
		     destroalto.setLayout(null);
			 JTextField searchbar = new JTextField();
			 
		     
		     searchbar.setBounds(123, 5, 120, 20);
			searchbar.setFont(new Font("Dialog", Font.PLAIN, 15));
		     destroalto.add(searchbar);
		     searchbar.setColumns(10);
		     
		     JButton btnDomotica = new JButton("Domotica");
		     btnDomotica.setBounds(275, 3, 38, 23);
		     destroalto.add(btnDomotica);
		   
		     
	

		//carico immagini
		
        new ImageIcon ("app/src/assets/bcksunny.jpg");
        new ImageIcon("app/src/assets/cloudy.png");
        new ImageIcon("windspeed.png");
       new ImageIcon("rain.png");
        new ImageIcon("clear.png");
        new ImageIcon("snow.png");
     
        JPanel sinistro = new JPanel();
        sinistro.setOpaque(false);
        sinistro.setBounds(19, 21, 137, 366);
        sinistro.setBorder(new LineBorder(new Color(0, 0, 0)));
	    sinistro.setLayout(null);
        contentPane.add(sinistro);
        
        JLabel lblWeatherData = new JLabel(loadImage("cloudy.png"));
        lblWeatherData.setBounds(8, 17, 101, 141);
        ImageIcon image1 = new ImageIcon("cloudy.png");
        
        
        
        sinistro.setLayout(null);
        sinistro.setLayout(null);
        sinistro.add(lblWeatherData);
        
        
        
        JLabel lblDateTime = new JLabel("sinistrobassa");
        lblDateTime.setBounds(3, 269, 127, 94);
        sinistro.add(lblDateTime);
        
     
     JLabel label_1 = new JLabel("Vento");
     label_1.setBounds(247, 82, 73, 14);
     destroalto.add(label_1);
     JLabel label_2 = new JLabel("WeatherAlertPanel");
     label_2.setBounds(17, 82, 91, 14);
     destroalto.add(label_2);
     JLabel label_3 = new JLabel("Sunrise");
     label_3.setBounds(247, 136, 35, 14);
     destroalto.add(label_3);
     JLabel label_4 = new JLabel("PressionePanel");
     label_4.setBounds(147, 82, 72, 14);
     destroalto.add(label_4);
     JLabel label_5 = new JLabel("Sunset");
     label_5.setBounds(168, 137, 33, 14);
     destroalto.add(label_5);
     
    
     //destroalto.add(btnSearch);
    // btnSearch.addActionListener(new ActionListener() {
        
     //@Override
         
     //public void actionPerformed(ActionEvent e) {
             // Perform search action here
          ///   String searchText = btnSearch.getText();
            // JOptionPane.showMessageDialog(btnSearch.this, "Città: " + searchText);
       ////  }
    ////////// });
   
     
      
	 
	   JPanel weatherForecastPanel = new JPanel();
	   weatherForecastPanel.setSize(414, 101);
	   weatherForecastPanel.setLocation(173, 282);
       weatherForecastPanel.setBorder(null);
       weatherForecastPanel.setVisible(true);
       weatherForecastPanel.setOpaque(false);
       contentPane.add(weatherForecastPanel);
       
     ImageIcon icon = new ImageIcon("C:\\\\Users\\\\15-DW1087\\\\Desktop\\\\MeteoApp2\\\\app\\\\src\\\\main\\\\java\\\\assets\\\\msun2.png");
	 weatherForecastPanel.setLayout(null);

	 JLabel lblLunedi = new JLabel();
	 lblLunedi.setBounds(0, 6, 69, 73);
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
		 lblMartedi.setBounds(60, 6, 69, 85);
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





