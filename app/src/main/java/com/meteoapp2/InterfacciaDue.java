package com.meteoapp2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class InterfacciaDue extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JLabel weatherDataLabel;
	public JLabel weatherDescription;
	public JLabel temperatureText;
	public Interfaccia interfaccia;
	

	public InterfacciaDue() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfacciaDue.class.getResource("/assets/mhome.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(616, 432);
		setTitle("Domoteo");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new LineBorder(new Color(239, 239, 239), 5, true));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel telecamere = new JLabel("");
		telecamere.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/cameras2.jpg")));
		telecamere.setBounds(461, 33, 109, 99);
		telecamere.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		telecamere.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(telecamere);
		
		JLabel alarme = new JLabel("");
		alarme.setBounds(167, 157, 141, 109);
		alarme.setHorizontalAlignment(SwingConstants.CENTER);
		alarme.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/alarm.jpg")));
		contentPane.add(alarme);
		
		JLabel lavanderia = new JLabel("");
		lavanderia.setBounds(306, 25, 141, 114);
		lavanderia.setHorizontalAlignment(SwingConstants.CENTER);
		lavanderia.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/laundry.jpg")));
		contentPane.add(lavanderia);
		
		JLabel cucina = new JLabel("");
		cucina.setBounds(178, 32, 121, 100);
		cucina.setHorizontalAlignment(SwingConstants.CENTER);
		cucina.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/kitchen.jpg")));
		contentPane.add(cucina);
		
		JLabel bagno = new JLabel("");
		bagno.setBounds(305, 154, 145, 115);
		bagno.setHorizontalAlignment(SwingConstants.CENTER);
		bagno.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/bathroom.png")));
		contentPane.add(bagno);
		
		 JLabel weatherDataLabel = new JLabel();
		 weatherDataLabel.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/background.jpg")));
	     //   weatherDataLabel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/backsunny.jpg")));
	        weatherDataLabel.setToolTipText("");
	        weatherDataLabel.setBounds(26, 32, 134, 230);
	        weatherDataLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
	             temperatureText.setForeground(new Color(255, 255, 255));
	             temperatureText.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/mparty.png")));
	             temperatureText.setBounds(4, 2, 130, 148);
	             weatherDataLabel.add(temperatureText);
	             temperatureText.setBorder(new LineBorder(new Color(128, 128, 255), 0, true));
	        temperatureText.setBackground(new Color(255, 255, 255, 100));
	        temperatureText.setHorizontalTextPosition(SwingConstants.CENTER);
	        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
	        temperatureText.setFont(new Font("Tahoma", Font.BOLD, 24));
	        weatherDescription = new JLabel();
	        weatherDescription.setText("poche nuvole");
	        weatherDescription.setBounds(-1, 157, 137, 25);
	        weatherDataLabel.add(weatherDescription);
	        weatherDescription.setBorder(new LineBorder(new Color(128, 128, 255), 0, true));
	        weatherDescription.setForeground(new Color(255, 255, 255));
	        weatherDescription.setHorizontalTextPosition(SwingConstants.CENTER);
	        weatherDescription.setHorizontalAlignment(SwingConstants.CENTER);
	        weatherDescription.setBackground(new Color(255, 255, 255, 100));
	        weatherDescription.setLayout(null);
	        
	        weatherDescription.setFont(new Font("Dialog", Font.BOLD, 14));
	
		weatherDataLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	
                // Chiudi la finestra corrente (Interfaccia)
                dispose();

                // Riapri la finestra dell'interfaccia precedente
                Interfaccia interfaccia = new Interfaccia();
                setLocationRelativeTo(null);
                interfaccia.setVisible(true);
            }
            @Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				 // Cambia il cursore quando il mouse entra nel pulsante
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				 // Ripristina il cursore quando il mouse esce dal pulsante
                setCursor(Cursor.getDefaultCursor());
			
			}
        });
	



   	JLabel camera = new JLabel("");
	 camera.setHorizontalAlignment(SwingConstants.CENTER);
		camera.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/bedroom2.jpg")));
		camera.setBounds(459, 150, 112, 121);
		contentPane.add(camera);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
		lblNewLabel.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/med-ext.png")));
		lblNewLabel.setBounds(26, 316, 160, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
		lblNewLabel_2.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/sec-ext.png")));
		lblNewLabel_2.setBounds(215, 316, 218, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBorder(new LineBorder(new Color(239, 239, 239), 4, true));
		lblNewLabel_3.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/buzz-ext.png")));
		lblNewLabel_3.setBounds(461, 316, 109, 44);
		contentPane.add(lblNewLabel_3);
		
		  // temperatureText.setText(String.valueOf(temp + "°C"));
	       // weatherDescription.setText(description);
		
	}
	
public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            InterfacciaDue interfacciaDue = new InterfacciaDue();
	            interfacciaDue.setVisible(true);
	        });

}
    	 

public static long getSerialversionuid() {
	return serialVersionUID;
}

public void updateUI(JSONObject weatherData) {
	JSONObject main = (JSONObject) weatherData.get("main");

	
	JSONArray weatherArray = (JSONArray) weatherData.get("weather"); // Ottieni l'array "weather"

	 if (main != null && weatherArray != null && weatherArray.size() > 0) {
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
    	
        String description = (String) weather.get("description");
 
        temperatureText.setText(String.valueOf(temp + "°C"));
       
        weatherDescription.setText(description + " ");
   
        // Formatta le date in stringhe leggibili
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
   
}
	
}



}


