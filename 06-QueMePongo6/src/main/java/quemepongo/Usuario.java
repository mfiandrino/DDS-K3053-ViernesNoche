package quemepongo;

import java.util.List;

public class Usuario {
  private List<Guardarropa> guardarropas;

  public Usuario(List<Guardarropa> guardarropas) {
    this.guardarropas = guardarropas;
  }

  public List<Guardarropa> getGuardarropas() {
    return guardarropas;
  }

}
