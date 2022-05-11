package quemepongo;

public class Color {
  private Integer red;
  private Integer green;
  private Integer blue;

  public Color(Integer red, Integer green, Integer blue) {
    if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("El valor de cada color debe ser entre 0 y 255");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
}
