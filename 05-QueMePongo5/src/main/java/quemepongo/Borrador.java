package quemepongo;

import static java.util.Objects.requireNonNull;

public class Borrador {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Trama trama;

  public Borrador() {
    this.trama = Trama.LISA;
  }

  public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public void setColorPrimario(Color colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTrama(Trama trama) {
    if (trama == null) {
      this.trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
  }

  public Prenda crearPrenda() {
    this.validarPrenda();
    return new Prenda(tipoDePrenda, material, colorPrimario, colorSecundario, trama);
  }

  private void validarPrenda() {
    requireNonNull(tipoDePrenda, "El tipo de prenda es obligatorio");
    requireNonNull(material, "El material es obligatorio");
    requireNonNull(colorPrimario, "El color primario es obligatorio");
  }
}
