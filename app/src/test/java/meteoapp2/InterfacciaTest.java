package meteoapp2;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.meteoapp2.Interfaccia;

public class InterfacciaTest {
    private Interfaccia interfaccia;

    @Before
    public void setUp() {
        interfaccia = new Interfaccia();
    }

    @Test
    public void testUpdateUI() {
        JSONObject weatherData = new JSONObject();
        JSONObject main = new JSONObject();
        main.put("temp", 20.0);
        main.put("temp_min", 15.0);
        main.put("temp_max", 25.0);
        main.put("pressure", 1013L);
        main.put("humidity", 70L);

        JSONObject wind = new JSONObject();
        wind.put("speed", 5.0);

        JSONObject sys = new JSONObject();
        sys.put("sunrise", 1615795200L); // Timestamp per una data e ora di esempio
        sys.put("sunset", 1615838400L); // Timestamp per una data e ora di esempio

        JSONArray weatherArray = new JSONArray();
        JSONObject weather = new JSONObject();
        weather.put("description", "Sunny");
        weatherArray.add(weather);

        weatherData.put("main", main);
        weatherData.put("wind", wind);
        weatherData.put("sys", sys);
        weatherData.put("weather", weatherArray);

     

    }
}
