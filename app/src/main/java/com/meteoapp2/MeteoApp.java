package com.meteoapp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MeteoApp {
    private static final String API_KEY = "e58f4fd59c7b9967eebedc1d199162db";

    public static JSONObject getWeatherData(String cityName) {
        try {
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(cityName, "UTF-8") + "&lang=it&units=metric&APPID=" + "e58f4fd59c7b9967eebedc1d199162db";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                reader.close();
                return jsonObject;
            } else {
                System.err.println("HTTP request failed with response code: " + responseCode);
                JOptionPane.showMessageDialog(null, "Errore nella richiesta API", "Errore", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nella richiesta API", "Errore", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
	public static String getApiKey() {
		return API_KEY;
	}

	public static JSONObject getjsonObject(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new Interfaccia());

}
}
