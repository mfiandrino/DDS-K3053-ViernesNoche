package quemepongo;

import java.util.ArrayList;
import java.util.List;
import quemepongo.command.Agregar;
import quemepongo.command.Propuesta;
import quemepongo.command.Quitar;

public class Usuario {
  private List<Guardarropas> guardarropas;
  private List<Propuesta> propuestasPendientes;
  private List<Propuesta> propuestasAceptadas;

  public Usuario(List<Guardarropas> guardarropas) {
    this.guardarropas = guardarropas;
    this.propuestasPendientes = new ArrayList<>();
    this.propuestasAceptadas = new ArrayList<>();
  }

  public void proponerAgregarPrendaA(Usuario otroUsuario,
                                     Guardarropas guardarropas,
                                     Prenda prenda) {
    otroUsuario.guardarPropuesta(new Agregar(guardarropas, prenda));
  }

  public void proponerQuitarPrendaA(Usuario otroUsuario, Guardarropas guardarropas, Prenda prenda) {
    otroUsuario.guardarPropuesta(new Quitar(guardarropas, prenda));
  }

  private void guardarPropuesta(Propuesta propuesta) {
    this.propuestasPendientes.add(propuesta);
  }

  public List<Guardarropas> getGuardarropas() {
    return guardarropas;
  }

  public List<Propuesta> getPropuestasPendientes() {
    return propuestasPendientes;
  }

  public List<Propuesta> getPropuestasAceptadas() {
    return propuestasAceptadas;
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.ejecutar();
    this.propuestasAceptadas.add(propuesta);
  }

  public void deshacerPropuesta(Propuesta propuesta) {
    propuesta.deshacer();
    this.propuestasAceptadas.remove(propuesta);
  }
}
