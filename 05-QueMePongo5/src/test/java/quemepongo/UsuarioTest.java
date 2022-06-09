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
  private Guardarropas unGuardarropas;
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

    unGuardarropas = new Guardarropas(prendas, null);

    List<Guardarropas> listaGuardarropas = new ArrayList<>();
    listaGuardarropas.add(unGuardarropas);

    unUsuario = new Usuario(listaGuardarropas);
    otroUsuario = new Usuario(listaGuardarropas);
  }

  @Test
  void dosUsuariosPuedenCompartirGuardarropas() {
    assertTrue(unUsuario.getGuardarropas().contains(unGuardarropas));
    assertTrue(otroUsuario.getGuardarropas().contains(unGuardarropas));
  }

  @Test
  void siUnUsuarioProponeAgregarUnaPrendaSeLeAgregaComoPropuestaPendiente() {
    Prenda nuevaPrenda = new Prenda(null, null, null, null, null);
    unUsuario.proponerAgregarPrendaA(otroUsuario, unGuardarropas, nuevaPrenda);

    assertEquals(1, otroUsuario.getPropuestasPendientes().size());
  }

  @Test
  void siUnUsuarioProponeQuitarUnaPrendaSeLeAgregaComoPropuestaPendiente() {
    unUsuario.proponerQuitarPrendaA(otroUsuario, unGuardarropas, collar);

    assertEquals(1, otroUsuario.getPropuestasPendientes().size());
  }

  @Test
  void siUnUsuarioAceptaUnaPropuestaPendienteDeAgregarPrendaSeAgregaASuGuardarropasYSeAlmacenaComoPropuestaAceptada() {
    Prenda nuevaPrenda = new Prenda(null, null, null, null, null);
    unUsuario.proponerAgregarPrendaA(otroUsuario, unGuardarropas, nuevaPrenda);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);

    assertFalse(unGuardarropas.getPrendasDisponibles().contains(nuevaPrenda));
    otroUsuario.aceptarPropuesta(laPropuesta);
    assertTrue(unGuardarropas.getPrendasDisponibles().contains(nuevaPrenda));

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
  }

  @Test
  void siUnUsuarioAceptaUnaPropuestaPendienteDeQuitarPrendaSeEliminaDeSuGuardarropasYSeAlmacenaComoPropuestaAceptada() {
    unUsuario.proponerQuitarPrendaA(otroUsuario, unGuardarropas, collar);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);

    assertTrue(unGuardarropas.getPrendasDisponibles().contains(collar));
    otroUsuario.aceptarPropuesta(laPropuesta);
    assertFalse(unGuardarropas.getPrendasDisponibles().contains(collar));

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
  }

  @Test
  void siUnUsuarioDeshaceUnaPropuestaAceptadaDeAgregarPrendaSeQuitaDeSuGuardarropasYSeEliminaDePropuestaAceptadas() {
    Prenda nuevaPrenda = new Prenda(null, null, null, null, null);
    unUsuario.proponerAgregarPrendaA(otroUsuario, unGuardarropas, nuevaPrenda);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);
    otroUsuario.aceptarPropuesta(laPropuesta);

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
    otroUsuario.deshacerPropuesta(laPropuesta);
    assertTrue(otroUsuario.getPropuestasAceptadas().isEmpty());
    assertFalse(unGuardarropas.getPrendasDisponibles().contains(nuevaPrenda));
  }

  @Test
  void siUnUsuarioDeshaceUnaPropuestaAceptadaDeQuitarPrendaSeVuelveAAgregarASuGuardarropasYSeEliminaDePropuestaAceptadas() {
    unUsuario.proponerQuitarPrendaA(otroUsuario, unGuardarropas, collar);

    Propuesta laPropuesta = otroUsuario.getPropuestasPendientes().stream().findFirst().orElse(null);
    otroUsuario.aceptarPropuesta(laPropuesta);

    assertEquals(1, otroUsuario.getPropuestasAceptadas().size());
    otroUsuario.deshacerPropuesta(laPropuesta);
    assertTrue(otroUsuario.getPropuestasAceptadas().isEmpty());
    assertTrue(unGuardarropas.getPrendasDisponibles().contains(collar));
  }
}