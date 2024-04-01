package demo.list.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FlatMapStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Java 8 FlatMap y Streams

		// El uso de Java 8 FlatMap es algo que en muchas ocasiones cuesta
		// entender . La programaci�n funcional en Java 8 esta empezando y para
		// la mayor parte de la gente es algo muy nuevo. Vamos a crear un
		// ejemplo sencillo de flatMap, partiremos de dos clases relacionadas
		// Personas y Viajes.

		// Una persona realiza varios viajes y contiene por lo tanto una lista
		// de viajes:

		// Es momento de crear y recorrer la estructura en c�digo para obtener
		// todos los paises a los cuales se ha viajado

		Viajero viajero1 = new Viajero("pedro");
		Viaje v = new Viaje("Francia");
		Viaje v2 = new Viaje("Inglaterra");
		viajero1.addViaje(v);
		viajero1.addViaje(v2);

		Viajero viajero2 = new Viajero("gema");
		Viaje v3 = new Viaje("Italia");
		Viaje v4 = new Viaje("Belgica");
		viajero2.addViaje(v3);
		viajero2.addViaje(v4);

		List<Viajero> lista = new ArrayList<Viajero>();
		lista.add(viajero1);
		lista.add(viajero2);

		for (Viajero viajero : lista) {
			for (Viaje viaje : viajero.getLista()) {
				System.out.println(viaje.getPais());
			}
		}

		// Listas y bucles anidados
		// El problema es que en ning�n caso hemos usado programaci�n funcional
		// para recorrer la lista, simplemente dos bucles anidados. No es una
		// mala soluci�n pero es mejorable con programaci�n funcional.

		// Usando Java 8 Map
		// El primer paso va a ser usar la funci�n map para que a trav�s de
		// programaci�n funcional nos imprima los nombres de las personas.

		System.out.println("Nombres de viajeros...");
		lista.stream().map(viajero -> viajero.getNombre()).forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});

		// Ser�a mucho m�s �ptimo usar varios Java reference method y realizarlo
		// as� :

		System.out.println("Usando Map...");
		lista.stream().map(Viajero::getNombre).forEach(System.out::println);

		// Lamentablemente no es suficiente ya que lo que quer�amos ya que
		// necesitamos imprimir el nombre de los pa�ses. As� pues tenemos que
		// trabajar un poquito m�s:

		// Para conseguir la lista de pa�ses debemos operar de otra manera y
		// usar la funci�n flatMap. Para ello combinamos map y flatMap. . Con
		// map obtenemos la lista de viajes de cada Persona. Una vez que tenemos
		// esto claro lo que abremos seleccionado en el Stream son multiples
		// arrays de datos cada uno con una lista de Paises.

		System.out.println("Lista de paises...");
		lista.stream().map(persona -> persona.getLista()).flatMap(viajes -> viajes.stream())
				.forEach(p -> System.out.println(p.getPais()));

		// Lo que hacemos ahora es usar Java 8 FlatMap y obligar a que esos dos
		// arrays se conviertan en uno solo ya que la operaci�n de flatMap
		// aplana el array y consigue que lo operemos como un �nico array con 4
		// elementos.

		// Ahora bien ,�C�mo funciona exactamente flatMap? . FlatMap es una
		// funci�n que recibe una entrada y devuelve varias salidas para esa
		// entrada . Esa es la diferencia con Map que tiene una entrada y
		// devuelve una �nica salida.

	}

}
