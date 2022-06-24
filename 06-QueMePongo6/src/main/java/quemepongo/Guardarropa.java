package quemepongo;

import java.util.ArrayList;
import java.util.List;

import quemepongo.command.Agregar;
import quemepongo.command.Propuesta;
import quemepongo.command.Quitar;
import quemepongo.excepciones.PrendaInexistenteException;

public class Guardarropa {
  private List<Prenda> prendasDisponibles;
  private ServicioMeteorologico servicioMeteorologico;
  private List<Propuesta> propuestasPendientes;
  private List<Propuesta> propuestasAceptadas;

  public Guardarropa(List<Prenda> prendasDisponibles,
                     ServicioMeteorologico servicioMeteorologico) {
    this.prendasDisponibles = prendasDisponibles;
    this.servicioMeteorologico = servicioMeteorologico;
    this.propuestasPendientes = new ArrayList<>();
    this.propuestasAceptadas = new ArrayList<>();
  }

  public Atuendo generarAtuendo(String lugar) {
    Integer temperatura = servicioMeteorologico.getTemperature(lugar);
    return new Atuendo(generarPrenda(Categoria.ACCESORIO, temperatura),
        generarPrenda(Categoria.SUPERIOR, temperatura),
        generarPrenda(Categoria.INFERIOR, temperatura),
        generarPrenda(Categoria.CALZADO, temperatura));
  }

  private Prenda generarPrenda(Categoria categoria, Integer temperatura) {
    Prenda unaPrenda = prendasDisponibles
        .stream()
        .filter(prenda -> prenda.getCategoria().equals(categoria))
        .filter(prenda -> prenda.esAptaParaTemperatura(temperatura))
        .findAny()
        .orElse(null);

    if (unaPrenda == null) {
      throw new PrendaInexistenteException();
    }
    return unaPrenda;
  }

  public Propuesta proponerAgregar(Prenda prenda) {
    Propuesta propuesta = new Agregar(this, prenda);
    propuestasPendientes.add(propuesta);
    return propuesta;
  }

  public Propuesta proponerQuitar(Prenda prenda) {
    Propuesta propuesta = new Quitar(this, prenda);
    propuestasPendientes.add(propuesta);
    return propuesta;
  }

  public void aceptarPropuesta(Propuesta propuesta) {
    propuesta.ejecutar();
    this.propuestasPendientes.remove(propuesta);
    this.propuestasAceptadas.add(propuesta);
  }

  public void rechazarPropuesta(Propuesta propuesta) {
    this.propuestasPendientes.remove(propuesta);
  }

  public void deshacerPropuesta(Propuesta propuesta) {
    propuesta.deshacer();
    this.propuestasAceptadas.remove(propuesta);
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendasDisponibles.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    this.prendasDisponibles.remove(prenda);
  }

  public List<Prenda> getPrendasDisponibles() {
    return prendasDisponibles;
  }

  public List<Propuesta> getPropuestasPendientes() {
    return propuestasPendientes;
  }

  public List<Propuesta> getPropuestasAceptadas() {
    return propuestasAceptadas;
  }


}
