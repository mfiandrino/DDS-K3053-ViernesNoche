package quemepongo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Usuario {
  private List<Prenda> prendas;
  private ServicioMeteorologico servicioMeteorologico;

  public Usuario(List<Prenda> prendas, ServicioMeteorologico servicioMeteorologico) {
    this.prendas = prendas;
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public Atuendo generarAtuendo() {
    return new Atuendo(generarPrenda(Categoria.ACCESORIO), generarPrenda(Categoria.SUPERIOR), generarPrenda(Categoria.INFERIOR), generarPrenda(Categoria.CALZADO));
  }

  public Prenda generarPrenda(Categoria categoria) {
    List<Prenda> prendasDeLaCategoria = this.prendas
        .stream()
        .filter(p -> p.getCategoria() == categoria)
        .collect(Collectors.toList());

    Integer randomIndex = new Random().nextInt(prendasDeLaCategoria.size());

    return prendasDeLaCategoria.get(randomIndex);
  }
}
