package quemepongo.command;

import quemepongo.Guardarropas;
import quemepongo.Prenda;

public class Agregar implements Propuesta {
  private Guardarropas guardarropas;
  private Prenda prenda;

  public Agregar(Guardarropas guardarropas, Prenda prenda) {
    this.guardarropas = guardarropas;
    this.prenda = prenda;
  }

  @Override
  public void ejecutar() {
    guardarropas.agregarPrenda(prenda);
  }

  @Override
  public void deshacer() {
    guardarropas.quitarPrenda(prenda);
  }
}
