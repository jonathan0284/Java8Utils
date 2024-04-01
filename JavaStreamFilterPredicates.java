package demo.list.map;

import java.util.Arrays;
import java.util.List;

public class JavaStreamFilterPredicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Las opciones de Java Stream Filter son muy amplias pero para poder
		// trabajar con ellas de forma cómoda hay que entender el funcionamiento
		// del interface Predicate a detalle. Vamos a construir un ejemplo con
		// una lista de libros que nos permite entender mejor como funcionan los
		// filtros. Para ello vamos a partir de los siguientes objetos.

		Libro l = new Libro("El señor de los anillos", "fantasia", 1100);
		Libro l2 = new Libro("El Juego de Ender", "ciencia ficcion", 500);
		Libro l3 = new Libro("La fundacion", "ciencia ficcion", 500);
		Libro l4 = new Libro("Los pilares de la tierra", "historica", 1200);
		List<Libro> lista = Arrays.asList(l, l2, l3, l4);

		// Tenemos cuatro libros y acabamos de usar un filtro sencillo que nos
		// selecciona los libros que pasan de 1000 páginas utilizando un
		// Predicate con una expresión lambda. El resultado se imprime en la
		// consola.

		lista.stream().filter(libro -> libro.getPaginas() > 1000).map(libro -> libro.getTitulo())
				.forEach(System.out::println);

		// Java Stream Filter
		// El filtro funciona de forma correcta , pero no siempre queremos
		// filtran usando una expresión lambda de una forma directa ya que no
		// tiene una gran capacidad de reutilización. En muchos casos suele ser
		// mejor tener alguna clase de apoyo que defina una serie de expresiones
		// lambda y predicados que nos ayuden y se reutilicen.

		lista.stream().filter(LibroUtils.filtroCategoria("ciencia ficcion")).map(libro -> libro.getTitulo())
				.forEach(System.out::println);

		// De esta forma nosotros podemos invocar este tipo de filtro y
		// reutilizarlo.
		System.out.println("Filtro-> buenosLibros...");
		lista.stream().filter(LibroUtils::buenosLibros).map(Libro::getTitulo).forEach(System.out::println);

	}

}
