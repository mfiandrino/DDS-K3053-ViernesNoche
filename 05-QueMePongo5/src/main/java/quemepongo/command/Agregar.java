package quemepongo.command;

import quemepongo.Guardarropa;
import quemepongo.Prenda;

public class Agregar implements Propuesta {
  private Guardarropa guardarropa;
  private Prenda prenda;

  public Agregar(Guardarropa guardarropa, Prenda prenda) {
    this.guardarropa = guardarropa;
    this.prenda = prenda; 
  }

  @Override
  public void ejecutar() {
    guardarropa.agregarPrenda(prenda);
  }

  @Override
  public void deshacer() {
    guardarropa.quitarPrenda(prenda);
  }
}
