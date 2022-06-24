package quemepongo;

import java.util.Map;

public class ServicioAccuWeather implements ServicioMeteorologico {
  AccuWeatherApi apiClima = new AccuWeatherApi();

  @Override
  public Integer getTemperature(String location) {
    Map<String, Object> hashTemperature = (Map<String, Object>) apiClima
        .getWeather(location)
        .get(0)
        .get("Temperature");
    return (Integer) hashTemperature.get("Value");
  }
}
