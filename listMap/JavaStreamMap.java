package demo.list.map;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class JavaStreamMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Vamos a ver algunos ejemplos que nos ayuden a clarificar como se
		// utiliza Java Stream map. Para ello nos vamos a apoyar en una lista de
		// Personas .

		Persona p1 = new Persona("pedro", "perez", 20);
		Persona p2 = new Persona("juan", "perez", 25);
		Persona p3 = new Persona("ana", "perez", 30);
		List<Persona> lista = Arrays.asList(p1,p2,p3);		

		// La primera operación que vamos a realizar es convertir nuestra lista
		// de personas a una lista de números enteros.

		lista.stream().map(Persona::getEdad).reduce((a, b) -> a + b).ifPresent(System.out::println);

		// Sin embargo esta aunque este una solución válida no es la mejor
		// solución

		// Java Stream Map vs MapInt y MapDouble
		// El método map viene con dos métodos adicionales orientados a trabajar
		// con datos numéricos. Estos métodos son maptoInt y mapToDouble. Si
		// cambiamos nuestro método de map a maptoInt o maptoDouble se nos
		// abrirá la posibilidad de acceder a métodos adicionales muy orientados
		// a estadísticas.

		int total = lista.stream().mapToInt(Persona::getEdad).sum();
		System.out.println(total);
		lista.stream().mapToDouble(Persona::getEdad).average().ifPresent(System.out::println);
		lista.stream().mapToInt(Persona::getEdad).max().ifPresent(System.out::println);
		lista.stream().mapToInt(Persona::getEdad).min();

		// Es una forma más cómoda de trabajar con valores numéricos ya que las
		// transformaciones directamente nos lo pasan a tipos fundamentales.

		// Java Stream map statistics
		// Hay situaciones en las que podemos querer acceder de forma directa a
		// todas las estadísticas. Los streams numéricos soportan el método de
		// summaryStatistics que nos permite acceder directamente a todos los
		// valores.

		DoubleSummaryStatistics estadisticas = lista.stream().mapToDouble(Persona::getEdad).summaryStatistics();
		System.out.println(estadisticas.getAverage());

	}

}
