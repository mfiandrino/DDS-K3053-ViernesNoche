# Qué Me Pongo

### Cuarta Iteración

En esta iteración continuaremos trabajando sobre las sugerencias de atuendos:
~~~
Como usuarie de QuéMePongo, quiero recibir sugerencias de atuendos para vestirme ajustándome a las condiciones climáticas con ropa de mi agrado
~~~

En esta oportunidad, atacaremos solamente los siguientes requerimientos específicos:

- Como usuarie de QuéMePongo, quiero poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes.

- Como usuarie de QuéMePongo, quiero poder recibir sugerencias de atuendos que tengan una prenda para cada categoría, aunque a futuro podrán tener más (Ej.: Una remera, un pantalón, zapatos y un gorro).

- Como usuarie de QuéMePongo, quiero que al generar una sugerencia las prendas sean acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada. (Ej.: “Remera de mangas largas” no es apta a más de 20°C)

- Como administradore de QuéMePongo, quiero poder configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas.

- Como stakeholder de QuéMePongo, quiero poder asegurar la calidad de mi aplicación sin incurrir en costos innecesarios. 

Además, tras investigar en el mercado encontramos que la conocida empresa AccuWeather provee un SDK para Java que nos entrega una lista con el clima de las próximas 12 horas en un diccionario.

En su documentación, incluyen el siguiente ejemplo de uso:
~~~
AccuWeatherAPI apiClima = new AccuWeatherAPI();
List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(“Buenos Aires, Argentina”);  condicionesClimaticas.get(0).get("PrecipitationProbability"); //Devuelve un número del 0 al 1
~~~

Y nos cobra 0,05 USD por cada vez que la llamamos a partir del décimo llamado diario.
<br><br><br>

## Solución

### Requerimientos:
 El usuario sigue queriendo poder cargar prendas válidas, pero en esta iteración incluye:
- 1\) El usuario quiere poder conocer las condiciones climáticas de Buenos Aires en un momento dado
- 2\) El usuario quiere poder recibir sugerencias de atuendos que tengan una prenda para cada categoría
- 3\) El usuario quiere que al generar una sugerencia las prendas sean acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada
- 4\) El administrador quiere poder configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas
- 5\) Los stakeholders quieren poder asegurar la calidad de mi aplicación sin incurrir en costos innecesarios
