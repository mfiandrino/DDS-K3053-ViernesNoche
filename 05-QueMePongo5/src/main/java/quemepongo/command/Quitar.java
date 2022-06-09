package quemepongo.command;

import quemepongo.Guardarropas;
import quemepongo.Prenda;

public class Quitar implements Propuesta {
  private Guardarropas guardarropas;
  private Prenda prenda;

  public Quitar(Guardarropas guardarropas, Prenda prenda) {
    this.guardarropas = guardarropas;
    this.prenda = prenda;
  }

  @Override
  public void ejecutar() {
    guardarropas.quitarPrenda(prenda);
  }

  @Override
  public void deshacer() {
    guardarropas.agregarPrenda(prenda);
  }
}
