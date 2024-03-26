package com.meteoapp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MeteoApp {
    private static final String API_KEY = "e58f4fd59c7b9967eebedc1d199162db";
    private static final String WEATHER_DATA_FILE = "weather_data.json";
    public static JSONObject getWeatherData(String cityName) {
        try {
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(cityName, "UTF-8") + "&lang=it&units=metric&APPID=" + URLEncoder.encode("e58f4fd59c7b9967eebedc1d199162db", "UTF-8");
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(reader);
                reader.close();
                
                writeJSONToFile(jsonObject, "weather_data.json");
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
    private static void writeJSONToFile(JSONObject jsonObject, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nella scrittura dei dati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
		
	
		public static String getApiKey() {
	        return API_KEY;
	    }
	
		 public static JSONObject getStoredWeatherData() {
		        JSONObject weatherData = null;
		        try {
		            Path filePath = Paths.get("weather_data.json");
		            if (Files.exists(filePath)) {
		                FileReader reader = new FileReader("weather_data.json");
		                JSONParser jsonParser = new JSONParser();
		                weatherData = (JSONObject) jsonParser.parse(reader);
		                reader.close();
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return weatherData;
		    }

		 public static void main(String[] args) {
		        SwingUtilities.invokeLater(() -> {
		            new Interfaccia();
		        });
		    }
		}

    
