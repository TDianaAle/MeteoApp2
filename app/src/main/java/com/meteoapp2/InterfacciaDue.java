package com.meteoapp2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class InterfacciaDue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel weatherDataLabel;
	private JLabel weatherDescription;
	private JLabel temperatureText;
	

	public InterfacciaDue() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InterfacciaDue.class.getResource("/assets/mhome.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(616, 432);
		setTitle("Domoteo");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(104, 193, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/cameras2.jpg")));
		lblNewLabel.setBounds(461, 33, 109, 99);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(167, 157, 141, 109);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/alarm.jpg")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(306, 25, 141, 114);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/laundry.jpg")));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(178, 32, 121, 100);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/kitchen.jpg")));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(305, 154, 145, 115);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/bathroom.png")));
		contentPane.add(lblNewLabel_5);
		
		 JLabel weatherDataLabel = new JLabel();
	        weatherDataLabel.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/backsunny.jpg")));
	        weatherDataLabel.setToolTipText("");
	        weatherDataLabel.setBounds(26, 32, 134, 230);
	        weatherDataLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        weatherDataLabel.setBorder(new LineBorder(new Color(128, 128, 255), 2, true));
	        weatherDataLabel.setBackground(new Color(255, 255, 255, 100));
	        weatherDataLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	  
	        weatherDataLabel.setAlignmentY(Component.TOP_ALIGNMENT);
	        contentPane.add(weatherDataLabel);
	             weatherDataLabel.setLayout(null);
	        

	             
	             // Inizializzazione delle variabili
	             temperatureText = new JLabel();
	            
	             temperatureText.setVerticalTextPosition(SwingConstants.BOTTOM);
	             temperatureText.setText("17 °C");
	             temperatureText.setIcon(new ImageIcon(Interfaccia.class.getResource("/assets/clear.png")));
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
		
		JLabel bedroom = new JLabel("");
	 bedroom.setHorizontalAlignment(SwingConstants.CENTER);
		bedroom.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/bedroom2.jpg")));
		bedroom.setBounds(459, 150, 112, 121);
		contentPane.add(bedroom);
	}

	
	public  void main(String[] args) {
      

SwingUtilities.invokeLater(() -> new Interfaccia());
        }


	public JLabel getWeatherDataLabel() {
		return weatherDataLabel;
	}


	public void setWeatherDataLabel(JLabel weatherDataLabel) {
		this.weatherDataLabel = weatherDataLabel;
	}
	}

