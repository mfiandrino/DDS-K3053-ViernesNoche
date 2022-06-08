package quemepongo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ServicioMeteorologicoTest {

  @Test
  public void laTemperaturaEsDe10() {
    ServicioMeteorologico unServicio = mock(ServicioMeteorologico.class);
    when(unServicio.getTemperature("Buenos Aires")).thenReturn(10);

    assertEquals(10, unServicio.getTemperature("Buenos Aires"));
  }
}