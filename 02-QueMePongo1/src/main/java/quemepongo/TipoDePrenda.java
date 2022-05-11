package quemepongo;

public class TipoDePrenda {
  private Categoria categoria;

  public TipoDePrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  static TipoDePrenda ZAPATO = new TipoDePrenda(Categoria.CALZADO);
  static TipoDePrenda ZAPATILLA = new TipoDePrenda(Categoria.CALZADO);
  static TipoDePrenda PANTALON = new TipoDePrenda(Categoria.INFERIOR);
  static TipoDePrenda SHORT = new TipoDePrenda(Categoria.INFERIOR);
  static TipoDePrenda REMERA = new TipoDePrenda(Categoria.SUPERIOR);
  static TipoDePrenda CAMISA = new TipoDePrenda(Categoria.SUPERIOR);
  static TipoDePrenda COLLAR = new TipoDePrenda(Categoria.ACCESORIO);
  static TipoDePrenda GORRA = new TipoDePrenda(Categoria.ACCESORIO);

  public Categoria getCategoria() {
    return categoria;
  }
}
