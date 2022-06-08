package quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BorradorTest {

  @Test
  public void laTramaDeUnaPrendaEsLisaSiElUsuarioNoLaEspecifica() {
    Borrador unPantalonBorrador = new Borrador();
    unPantalonBorrador.setTipoDePrenda(TipoDePrenda.PANTALON);
    unPantalonBorrador.setMaterial(Material.ALGODON);
    unPantalonBorrador.setColorPrimario(new Color(0, 0, 0));

    Prenda pantalonDefinitivo = unPantalonBorrador.crearPrenda();

    assertEquals("LISA", pantalonDefinitivo.getTrama().toString());
  }

  @Test
  public void tipoPrendaMaterialYColorPrimarioNoPuedenEstarVacios() {
    Borrador unaCamisaBorrador = new Borrador();
    assertThrows(NullPointerException.class, () -> unaCamisaBorrador.crearPrenda());
  }
}