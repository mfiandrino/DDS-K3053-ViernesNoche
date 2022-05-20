package quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PrendaTest {

  @Test
  public void unZapatoEsDeCategoriaCalzado() {
    Prenda zapatos = new Prenda(TipoDePrenda.ZAPATO, Material.CUERO, new Color(0, 0, 0),null, Trama.A_CUADROS);
    assertEquals(zapatos.getCategoria().toString(), "CALZADO");
  }

  @Test
  public void unCamisaEsDeCategoriaSuperior() {
    Prenda unaCamisa = new Prenda(TipoDePrenda.CAMISA, Material.ALGODON, new Color(0, 0, 0),null,Trama.A_CUADROS);
    assertEquals(unaCamisa.getCategoria().toString(), "SUPERIOR");
  }

  @Test
  public void tipoPrendaMaterialYColorPrimarioNoPuedenEstarVacios() {
    Borrador unaCamisaBorrador = new Borrador();
    assertThrows(NullPointerException.class, () -> unaCamisaBorrador.crearPrenda());
  }

  @Test
  public void laTramaDeUnaPrendaEsLisaSiElUsuarioNoLaEspecifica() {
    Borrador unPantalonBorrador = new Borrador();
    unPantalonBorrador.setTipoDePrenda(TipoDePrenda.PANTALON);
    unPantalonBorrador.setMaterial(Material.ALGODON);
    unPantalonBorrador.setColorPrimario(new Color(0,0,0));

    Prenda pantalonDefinitivo = unPantalonBorrador.crearPrenda();

    assertEquals("LISA", pantalonDefinitivo.getTrama().toString());
  }
}
