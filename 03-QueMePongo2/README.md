# Qué Me Pongo

### Segunda Iteración

En esta iteración seguiremos trabajando sobre la carga de prendas válidas:
~~~
Como usuarie de QuéMePongo, quiero poder cargar prendas válidas para generar atuendos con ellas.
~~~


Sin embargo, agregaremos algunos requerimiento adicionales:

- Como usuarie de QuéMePongo, quiero especificar qué trama tiene la tela de una prenda (lisa, rayada, con lunares, a cuadros o un estampado).

- Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.

- Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.

- Como usuarie de QuéMePongo, quiero guardar un borrador de la última prenda que empecé a cargar para continuar después.

- Como usuarie de QuéMePongo, quiero poder no indicar ninguna trama para una tela, y que por defecto ésta sea lisa.

- Como usuarie de QuéMePongo, quiero poder guardar una prenda solamente si esta es válida.

BONUS:Por otro lado, el equipo de producto está analizando potenciales futuras funcionalidades para la aplicación y, a fin de tener una estimación de su complejidad, nos pidió que esbocemos una solución a los siguientes requerimientos, orientados a integrar el software con colegios e instituciones privadas:

- Como usuario QueMePongo, quiero poder recibir sugerencias de uniformes armados.

- Como usuario QueMePongo, quiero que un uniforme siempre conste de una prenda superior, una inferior y un calzado

- Como administrador de QueMePongo, quiero poder configurar diferentes uniformes para distintas instituciones (Ej: para el colegio San Juan debe ser una chomba verde de piqué, un pantalón de acetato gris y zapatillas blancas, mientras que para el Instituto Johnson siempre será una camisa blanca, pantalón de vestir negro y zapatos negros) 
<br><br><br>

## Solución

### Requerimientos:
 El usuario sigue queriendo poder cargar prendas válidas, pero en esta iteración incluye:
- 1\) El usuario quiere especificar qué trama tiene el material de la prenda
- 2\) El usuario quiere crear una prenda especificando primero de qué tipo es
- 3\) El usuario quiere crear una prenda especificando segundo los aspectos relacionados al material (color, material, trama)
- 4\) El usuario quiere guardar un borrador de la última prenda que empezó a cargar
- 5\) El usuario quiere poder no indicar ninguna trama para una tela, y que por defecto ésta sea lisa.
- 6\) El usuario quiere poder guardar una prenda solamente si esta es válida 

El diagrama de clases de la solución:
![Imagen del diagrama de clases](https://raw.githubusercontent.com/mfiandrino/DDS-K3053-ViernesNoche/master/03-QueMePongo2/EjercicioQueMePongo2.jpeg)
