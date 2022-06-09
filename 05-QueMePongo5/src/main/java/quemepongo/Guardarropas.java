package quemepongo;

import java.util.List;
import quemepongo.excepciones.PrendaInexistenteException;

public class Guardarropas {
  private List<Prenda> prendasDisponibles;
  private ServicioMeteorologico servicioMeteorologico;

  public Guardarropas(List<Prenda> prendasDisponibles,
                      ServicioMeteorologico servicioMeteorologico) {
    this.prendasDisponibles = prendasDisponibles;
    this.servicioMeteorologico = servicioMeteorologico;
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

  public void agregarPrenda(Prenda prenda) {
    this.prendasDisponibles.add(prenda);
  }

  public void quitarPrenda(Prenda prenda) {
    this.prendasDisponibles.remove(prenda);
  }

  public List<Prenda> getPrendasDisponibles() {
    return prendasDisponibles;
  }
}
