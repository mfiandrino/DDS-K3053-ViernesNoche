package quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.excepciones.PrendaInexistenteException;

class GuardarropaTest {
  private Guardarropa unGuardarropa;
  private List<Prenda> prendas;
  private Prenda collar;
  private Prenda remera;
  private Prenda remeraMangaLarga;
  private Prenda jeans;
  private Prenda pantalonCorto;
  private Prenda zapatillas;
  private ServicioMeteorologico unServicio;

  @BeforeEach
  void init() {
    collar = new Prenda(TipoDePrenda.COLLAR, null, null, null, null);
    remera = new Prenda(TipoDePrenda.REMERA, null, null, null, null);
    remeraMangaLarga = new Prenda(TipoDePrenda.REMERA_MANGA_LARGA, null, null, null, null);
    jeans = new Prenda(TipoDePrenda.PANTALON, null, null, null, null);
    pantalonCorto = new Prenda(TipoDePrenda.SHORT, null, null, null, null);
    zapatillas = new Prenda(TipoDePrenda.ZAPATILLA, null, null, null, null);

    prendas = new ArrayList<>();
    prendas.add(collar);
    prendas.add(remeraMangaLarga);
    prendas.add(jeans);
    prendas.add(pantalonCorto);
    prendas.add(zapatillas);

    unServicio = mock(ServicioMeteorologico.class);
    unGuardarropa = new Guardarropa(prendas, unServicio);
  }

  @Test
  void siHaceCalorYNoHayRemeraLanzaUnaExcepcion() {
    when(unServicio.getTemperature("Buenos Aires")).thenReturn(32);

    assertThrows(PrendaInexistenteException.class,
        () -> unGuardarropa.generarAtuendo("Buenos Aires"));
  }

  @Test
  void siHaceCalorGeneraAtuendoConRemeraYPantalonCorto() {
    when(unServicio.getTemperature("Buenos Aires")).thenReturn(32);

    prendas.add(remera);

    assertEquals(remera, unGuardarropa.generarAtuendo("Buenos Aires").getPrendaSuperior());
    assertEquals(pantalonCorto, unGuardarropa.generarAtuendo("Buenos Aires").getPrendaInferior());
  }
}