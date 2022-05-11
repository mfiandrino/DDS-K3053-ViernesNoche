package quemepongo;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Color colorPrimario) {
    this.tipoDePrenda = requireNonNull(tipoDePrenda, "El tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "El material es obligatorio");
    this.colorPrimario = requireNonNull(colorPrimario, "El color primario es obligatorio");
  }

  public Prenda(TipoDePrenda tipoDePrenda,
                Material material,
                Color colorPrimario,
                Color colorSecundario) {
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
  }

  public Categoria getCategoria() {
    return tipoDePrenda.getCategoria();
  }
}
