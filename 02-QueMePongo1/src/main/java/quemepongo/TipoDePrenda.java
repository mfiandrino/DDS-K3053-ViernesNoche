package quemepongo;

public enum TipoDePrenda {

  ZAPATO(Categoria.CALZADO),
  ZAPATILLA(Categoria.CALZADO),
  PANTALON(Categoria.INFERIOR),
  SHORT(Categoria.INFERIOR),
  REMERA(Categoria.SUPERIOR),
  CAMISA(Categoria.SUPERIOR),
  COLLAR(Categoria.ACCESORIO),
  GOORA(Categoria.ACCESORIO);
  private Categoria categoria;

  TipoDePrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }
}
