package demo.list.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Java8LambdaExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Poco a poco Java 8 se va dando a conocer como plataforma de
		// desarrollo e incluye una serie de novedades. Entre las cuales hay que
		// destacar las lambda expresions (Expresiones Lambda) que se echaban
		// bastante ya que otros lenguajes como C# ya soportaban estructuras
		// similares. El uso de Expresiones Lambda nos permitirá simplificar de
		// forma muy clara algunos de los bloques de código que construíamos
		// hasta ahora. Bloques que en muchos casos hacían uso de clases
		// anónimas para solventar problemas que una expresión lambda expresa de
		// una forma mucho mas directa. Vamos a ver un sencillo bloque de código
		// que usa un Comparador para ordenar una lista de Personas.

		ArrayList<Persona> milista = new ArrayList<Persona>();
		milista.add(new Persona("Miguel"));
		milista.add(new Persona("Alicia"));
		
		Collections.sort(milista,new Comparator<Persona>(){

			@Override
			public int compare(Persona p1, Persona p2) {
				// TODO Auto-generated method stub
				return p1.getNombre().compareTo(p2.getNombre());
			}
			
		});
		
		milista.stream().map(p-> p.getNombre()).forEach(System.out::println);
		
		System.out.println("Expressiones lambda...");
		milista.stream()         
         .map((p) -> p.getNombre())
         .sorted()
         .forEach((p) -> System.out.println(p));
	}

}
