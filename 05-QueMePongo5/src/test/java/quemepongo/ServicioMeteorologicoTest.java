package quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class ServicioMeteorologicoTest {

  @Test
  public void laTemperaturaEsDe10() {
    ServicioMeteorologico unServicio = mock(ServicioMeteorologico.class);
    when(unServicio.getTemperature("Buenos Aires")).thenReturn(10);

    assertEquals(10, unServicio.getTemperature("Buenos Aires"));
  }
}