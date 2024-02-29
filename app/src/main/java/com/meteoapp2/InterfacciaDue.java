package com.meteoapp2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;

public class InterfacciaDue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel Time;
	private JLabel Date;
	

	/**
	 * Create the frame.
	 */
	public InterfacciaDue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(616, 432);
		getTitle();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(104, 193, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Domotica");
		lblNewLabel.setBounds(455, 3, 141, 39);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(161, 144, 141, 109);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/alarm.jpg")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(288, 17, 141, 100);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/laundry.jpg")));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(162, 18, 141, 100);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/kitchen.jpg")));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(289, 148, 141, 100);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/bathroom.png")));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("<soleggiato");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setBounds(46, 18, 101, 100);
		lblNewLabel_6.setIcon(new ImageIcon(InterfacciaDue.class.getResource("/assets/clear.png")));
		contentPane.add(lblNewLabel_6);
		
		JLabel Date = new JLabel("");
		Date.setBackground(new Color(255, 255, 255));
		Date.setBounds(50, 150, 103, 43);
		contentPane.add(Date);
		
		JLabel Time = new JLabel("");
		Time.setBackground(new Color(255, 255, 255));
		Time.setBounds(49, 201, 107, 43);
		contentPane.add(Time);
	}

	public  String getCurrentDateTime() {
		
		Date = new JLabel();
		Time = new JLabel();
		
        // Ottieni data e orario attuali
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Formatta data e orario in stringhe separate
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatta data e orario attuali nelle stringhe separate
        String formattedDate = currentDateTime.format(dateFormatter);
        String formattedTime = currentDateTime.format(timeFormatter);

        // Ritorna la concatenazione di data e orario
        return formattedDate + " " + formattedTime;
	}

	public  void main(String[] args) {
        // imposto l'orario e la data corrente nelle relative label
        String currentDateTime = getCurrentDateTime();{

        // Imposta la data attuale nella label CurrentDateText
        Date.setText(currentDateTime.split(" ")[0]);

        // Imposta l'orario attuale nella label CurrentTimeText
         Time.setText(currentDateTime.split(" ")[1]);
      

SwingUtilities.invokeLater(() -> new Interfaccia());
        }
	}
}
