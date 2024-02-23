package com.meteoapp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

public class MeteoApp {
    private static final String API_KEY = "e58f4fd59c7b9967eebedc1d199162db";

    public static JSONObject getWeatherData(String cityName) {
        try {
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(cityName, "UTF-8") + "&lang=it&units=metric&APPID=" + "e58f4fd59c7b9967eebedc1d199162db";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     //       StringBuilder response = new StringBuilder();
      //      String line;
       //     while ((line = reader.readLine()) != null) {
       //         response.append(line);
       //     }
            
       //     reader.close();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore richiesta API", "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

	public static String getApiKey() {
		return API_KEY;
	}


public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Interfaccia());
}
}