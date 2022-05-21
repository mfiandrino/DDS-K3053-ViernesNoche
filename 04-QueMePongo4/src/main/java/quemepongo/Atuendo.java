package quemepongo;

public class Atuendo {
  private Prenda prendaAccesorio;
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda prendaCalzado;

  public Atuendo(Prenda prendaAccesorio, Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado) {
    this.prendaAccesorio = prendaAccesorio;
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.prendaCalzado = prendaCalzado;
  }
}
