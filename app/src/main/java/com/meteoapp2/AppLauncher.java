package com.meteoapp2;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JPanel;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                // display interfaccia app
               Interfaccia finestraPrincipale = new Interfaccia();
               finestraPrincipale.setResizable(true);
               finestraPrincipale.setVisible(true);
               
               
//                System.out.println(WeatherApp.getLocationData("Cesena"));

//                System.out.println(WeatherApp.getCurrentTime());

            }
        });
    }
}
