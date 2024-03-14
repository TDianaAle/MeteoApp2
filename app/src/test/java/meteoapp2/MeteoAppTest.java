package meteoapp2;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.meteoapp2.MeteoApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MeteoAppTest {

    @Test
    public void testGetWeatherData() {
        // Arrange
        String cityName = "Rome"; // Città di esempio per il test

        // Act
        JSONObject weatherData = MeteoApp.getWeatherData(cityName);

        // Assert
        assertNotNull("Il JSONObject non dovrebbe essere nullo", weatherData);
    }
    }

