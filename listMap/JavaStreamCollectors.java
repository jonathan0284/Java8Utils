package demo.list.map;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamCollectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Cuanto más usamos los streams más usamos los diferentes Java Stream
		// Collectors para transformar estos. Vamos a ver cuales son las
		// diferentes opciones que Java soporta para transformar un stream a
		// otro tipo de estructura. Para ello nos vamos a crear la clase Libro y
		// usarla en diferentes ejemplos.

		Libro l1 = new Libro("El señor de los anillos", "", 1000);
		Libro l2 = new Libro("La fundacion", "", 500);
		Libro l3 = new Libro("El caliz de fuego", "", 600);

		Stream<Libro> st = Stream.of(l1, l2, l3);
		st.forEach((l) -> System.out.println(l.getTitulo()));

		// En muchas ocaciones no queremos simplemente imprimir un resultado
		// sino que lo que queremos es convertir el Stream a un tipo de dato
		// para su posterior gestión .

		// Vamos a ver algunas opciones, una de las más sencillas es convertirlo
		// a un array con el método toArray() :

		System.out.println("Convertir Stream a Array...");
		Stream<Libro> stream2 = Stream.of(l1, l2, l3);
		Libro[] arrayLibro = stream2.toArray(Libro[]::new);
		for (int i = 0; i < arrayLibro.length; i++) {
			System.out.println(arrayLibro[i].getPaginas());
		}

		// Java Stream Collectors
		// De igual forma que podemos convertir el Stream a un array, podemos
		// usar los Java Stream Collectors y convertir nuestro stream a una
		// Lista o Conjunto , utilizando la clase Collectors y su método
		// toList() o toSet().

		Stream<Libro> stream3 = Stream.of(l1, l2, l3);
		List<Libro> lista1 = stream3.collect(Collectors.toList());
		for (Libro l : lista1) {
			System.out.println(l.getTitulo());
		}

		Stream<Libro> stream4 = Stream.of(l1, l2, l3);
		Set<Libro> lista2 = stream4.collect(Collectors.toSet());
		for (Libro l : lista2) {
			System.out.println(l.getTitulo());
		}

		// Los Java Stream collectors nos permiten realizar operaciones más
		// complejas con poco código . Por ejemplo podemos obligar a que todos
		// los títulos de los Libros se impriman en una única linea usando el
		// método joining de la clase Collectors.

		Stream<Libro> stream5 = Stream.of(l1, l2, l3);
		String resultado = stream5.map((l) -> l.getTitulo()).collect(Collectors.joining(","));
		System.out.println("Resultado de unir cadenas: " + resultado);

		Stream<Libro> stream6 = Stream.of(l1, l2, l3);
		Optional<Integer> resultado3 = stream6.map((l) -> l.getPaginas()).collect(Collectors.reducing(Integer::sum));
		System.out.println("Resultado de suma: " + resultado3.get());
	}

}
