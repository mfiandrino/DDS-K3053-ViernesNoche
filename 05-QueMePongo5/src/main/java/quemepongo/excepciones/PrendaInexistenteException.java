package quemepongo.excepciones;

public class PrendaInexistenteException extends RuntimeException {
  public PrendaInexistenteException() {
    super("No existe ninguna prenda que cumpla los requerimientos");
  }
}
