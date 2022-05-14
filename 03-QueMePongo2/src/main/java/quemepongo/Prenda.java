package quemepongo;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Trama trama;

  public Prenda(TipoDePrenda tipoDePrenda,
                Material material,
                Color colorPrimario,
                Color colorSecundario,
                Trama trama) {
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    if (trama == null) {
      this.trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
  }

  public Material getMaterial() {
    return material;
  }

  public Color getColorPrimario() {
    return colorPrimario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public Categoria getCategoria() {
    return tipoDePrenda.getCategoria();
  }

  public Trama getTrama() {
    return trama;
  }
}
