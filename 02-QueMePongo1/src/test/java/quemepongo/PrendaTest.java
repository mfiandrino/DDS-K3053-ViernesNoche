package quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrendaTest {

  @Test
  public void unZapatoEsDeCategoriaCalzado() {
    Prenda zapatos = new Prenda(TipoDePrenda.ZAPATO, Material.CUERO, new Color(0, 0, 0));
    assertEquals(zapatos.getCategoria().toString(), "CALZADO");
  }

  @Test
  public void unCamisaEsDeCategoriaSuperior() {
    Prenda unaCamisa = new Prenda(TipoDePrenda.CAMISA, Material.ALGODON, new Color(0, 0, 0));
    assertEquals(unaCamisa.getCategoria().toString(), "SUPERIOR");
  }
}
