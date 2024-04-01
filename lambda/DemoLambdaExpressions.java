package demo.lambda.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoLambdaExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ejemploFunction();
		ordenarPersonas();
	}

	public static void ejemploFunction() {

		Function<String, Integer> sizeOf = (String s) -> {
			return s.length();
		};

		// Function<String,Integer> sizeOf_ = s-> s.length();

		Integer r1 = sizeOf.apply("hola java 8");

		System.out.println("Longitud de la cadena: " + r1);

	}

	public static void ordenarPersonas() {

		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Pepe"));
		personas.add(new Persona("Jimena"));
		personas.add(new Persona("Lucia"));
		personas.add(new Persona("Zara"));
		personas.add(new Persona("Andrés"));

		//System.out.println("Listado => " + personas.toString());

		// personas.sort((l,q)-> l.getNombre().compareTo(q.getNombre()));

		Comparator<Persona> comp = (l, q) -> l.getNombre().compareTo(q.getNombre());
		personas.sort(comp);

		//System.out.println("Listado => " + personas.toString());

		Stream<Persona> stream = personas.stream();

		List<String> nombres = stream
				// filtrado de los elementos que tienen nombre nullo
				.filter(p -> p.getNombre() != null)
				// aplicar una conversión, de Persona a String quedándonos con
				// el nombre
				.map(p -> p.getNombre())
				// recolectar los elementos en una lista
				.collect(Collectors.toList());

		System.out.println("Mostrar lista ->: " + nombres);
		


	}

}
