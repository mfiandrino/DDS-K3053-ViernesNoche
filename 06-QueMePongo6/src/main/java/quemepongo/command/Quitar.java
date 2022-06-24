package quemepongo.command;

import quemepongo.Guardarropa;
import quemepongo.Prenda;

public class Quitar implements Propuesta {
  private Guardarropa guardarropa;
  private Prenda prenda;

  public Quitar(Guardarropa guardarropa, Prenda prenda) {
    this.guardarropa = guardarropa;
    this.prenda = prenda;
  }

  @Override
  public void ejecutar() {
    guardarropa.quitarPrenda(prenda);
  }

  @Override
  public void deshacer() {
    guardarropa.agregarPrenda(prenda);
  }
}
