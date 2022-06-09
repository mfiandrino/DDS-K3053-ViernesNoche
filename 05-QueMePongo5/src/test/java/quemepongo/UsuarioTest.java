package quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.command.Propuesta;

class UsuarioTest {

  private Usuario unUsuario;
  private Usuario otroUsuario;
  private Guardarropa unGuardarropa;
  private List<Prenda> prendas;
  private Prenda collar;
  private Prenda remera;
  private Prenda jeans;
  private Prenda zapatillas;

  @BeforeEach
  void init() {
    collar = new Prenda(TipoDePrenda.COLLAR, null, null, null, null);
    remera = new Prenda(TipoDePrenda.REMERA, null, null, null, null);
    jeans = new Prenda(TipoDePrenda.PANTALON, null, null, null, null);
    zapatillas = new Prenda(TipoDePrenda.ZAPATILLA, null, null, null, null);

    prendas = new ArrayList<>();
    prendas.add(collar);
    prendas.add(jeans);
    prendas.add(zapatillas);

    unGuardarropa = new Guardarropa(prendas, null);

    List<Guardarropa> guardarropas = new ArrayList<>();
    guardarropas.add(unGuardarropa);

    unUsuario = new Usuario(guardarropas);
    otroUsuario = new Usuario(guardarropas);
  }

  @Test
  void dosUsuariosPuedenCompartirGuardarropa() {
    assertTrue(unUsuario.getGuardarropas().contains(unGuardarropa));
    assertTrue(otroUsuario.getGuardarropas().contains(unGuardarropa));
  }

  @Test
  void siUnUsuarioProponeAgregarUnaPrendaSeLeAgregaComoPropuestaPendiente() {
    Prenda nuevaPrenda = new Prenda(null, null, null, null, null);
    unUsuario.proponerAgregarPrendaA(otroUsuario, unGuardarropa, nuevaPrenda);

    assertEquals(1, otroUsuario.getPropuestasPendientes().size());
  }

  @Test
  void siUnUsuarioProponeQuitarUnaPrendaSeLeAgregaComoPropuestaPendiente() {
    unUsuario.proponerQuitarPrendaA(otroUsuario, unGuardarropa, collar);

    assertEquals(1, otroUsuario.getPropuestasPendientes().size());
  }

  @Test
  void siUnUsuarioAceptaUnaPropuestaPendienteDeAgregarPrendaSeAgregaASuGuardarropaYSeAlmacenaComoPropuestaAceptada() {
    Prenda nuevaPrenda = new Prenda(null, null, null, null, null);
    unUsuario.proponerAgregarPrendaA(otroUsuario, unGuardarropa, nuevaPrenda);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);

    assertFalse(unGuardarropa.getPrendasDisponibles().contains(nuevaPrenda));
    otroUsuario.aceptarPropuesta(laPropuesta);
    assertTrue(unGuardarropa.getPrendasDisponibles().contains(nuevaPrenda));

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
  }

  @Test
  void siUnUsuarioAceptaUnaPropuestaPendienteDeQuitarPrendaSeEliminaDeSuGuardarropaYSeAlmacenaComoPropuestaAceptada() {
    unUsuario.proponerQuitarPrendaA(otroUsuario, unGuardarropa, collar);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);

    assertTrue(unGuardarropa.getPrendasDisponibles().contains(collar));
    otroUsuario.aceptarPropuesta(laPropuesta);
    assertFalse(unGuardarropa.getPrendasDisponibles().contains(collar));

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
  }

  @Test
  void siUnUsuarioDeshaceUnaPropuestaAceptadaDeAgregarPrendaSeQuitaDeSuGuardarropaYSeEliminaDePropuestaAceptadas() {
    Prenda nuevaPrenda = new Prenda(null, null, null, null, null);
    unUsuario.proponerAgregarPrendaA(otroUsuario, unGuardarropa, nuevaPrenda);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);
    otroUsuario.aceptarPropuesta(laPropuesta);

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
    otroUsuario.deshacerPropuesta(laPropuesta);
    assertTrue(otroUsuario.getPropuestasAceptadas().isEmpty());
    assertFalse(unGuardarropa.getPrendasDisponibles().contains(nuevaPrenda));
  }

  @Test
  void siUnUsuarioDeshaceUnaPropuestaAceptadaDeQuitarPrendaSeVuelveAAgregarASuGuardarropaYSeEliminaDePropuestaAceptadas() {
    unUsuario.proponerQuitarPrendaA(otroUsuario, unGuardarropa, collar);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);
    otroUsuario.aceptarPropuesta(laPropuesta);

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
    otroUsuario.deshacerPropuesta(laPropuesta);
    assertTrue(otroUsuario.getPropuestasAceptadas().isEmpty());
    assertTrue(unGuardarropa.getPrendasDisponibles().contains(collar));
  }
}