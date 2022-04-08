# MacoWins

## Enunciado

Se requiere:
- Identificar los requerimientos.
- Presentar una solución usando el paradigma de objetos (pseudocódigo, diagrama de clases).
- Explicar todo lo que considere necesario en prosa.
- Si se descarta alguna alternativa durante el desarrollo de la solución, o si se tiene otra solución, explicarla brevemente.

La conocida empresa de ropa formal para caballeros, Macowins, es capaz de darle soporte a la venta de prendas. Un fragmento de la grabación del analista con el cliente:  <br><br>
*“Queremos saber el precio de venta de una prenda y sus tipos, los tipos de prenda son: sacos, pantalones, camisas.”*  <br><br>
*El cálculo del precio de una prenda es, el precio propio de la prenda modificado según el estado de la prenda, que pueden ser:*
- *Nueva: en este caso no modifican el precio base.*
- *Promoción: Le resta un valor fijo decidido por el usuario.*
- *Liquidación: Es un 50% del valor del producto.*


*Ah, un requerimiento más: Macowins registra las ventas de estas prendas y necesita saber las ganancias de un determinado día.*<br><br>
*“Cada venta tiene asociada las prendas que se vendieron, su cantidad y la fecha de venta. 
Las ventas pueden ser en efectivo o con tarjeta. En el caso que sea con tarjeta, tienen el mismo comportamiento que en efectivo (el cual no modifica el precio), sólo que se le aplica un recargo según la cantidad de cuotas seleccionadas (cantidad de cuotas * un coeficiente fijo + 0.01 del valor de cada prenda).”*<br><br>

## Solución

### Requerimientos:
- 1\) El cliente quiere saber las ganancias de un determinado dia
- 2\) El cliente quiere saber el precio de venta de una prenda
- 3\) El cliente quiere saber los tipos de prenda que ofrece

Como solución realicé un diagrama de clases, empezando por la clase Venta como centro del análisis.

![Imagen del diagrama de clases](https://raw.githubusercontent.com/mfiandrino/DDS-K3053-ViernesNoche/master/01-Macowins/EjercicioMacowins.jpeg)



**Observación:** a la hora de modelar el medio de pago, había pensado crear un atributo "medioDePago" y aplicar composición con las clases "Efectivo" y "Tarjeta", pero al notar que la clase Efectivo no iba a tener ningun comportamiento (solo dejar el precio total como estaba) decidí no aplicarlo. Para modelar los intereses al pagar con tarjeta de crédito decidí crear una clase "VentaConTarjeta" que hereda de Venta, ya que lo pensé como un caso particular de Venta donde se sobreescribiría el método "montoTotal()" para añadirle los intereses.




