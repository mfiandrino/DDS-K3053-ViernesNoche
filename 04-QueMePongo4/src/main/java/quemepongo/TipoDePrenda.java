package quemepongo;

public enum TipoDePrenda {

  ZAPATO(Categoria.CALZADO, 40),
  ZAPATILLA(Categoria.CALZADO, 60),
  PANTALON(Categoria.INFERIOR, 30),
  SHORT(Categoria.INFERIOR, 60),
  REMERA(Categoria.SUPERIOR, 60),
  REMERA_MANGA_LARGA(Categoria.SUPERIOR, 20),
  CAMISA(Categoria.SUPERIOR, 30),
  COLLAR(Categoria.ACCESORIO, 60),
  GORRA(Categoria.ACCESORIO, 60);
  private Integer tempMaxima;
  private Categoria categoria;

  TipoDePrenda(Categoria categoria, Integer tempMaxima) {
    this.categoria = categoria;
    this.tempMaxima = tempMaxima;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Boolean esAptaParaTemperatura(Integer temperatura) {
    return temperatura <= this.tempMaxima;
  }
}
