package demo.list.map;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class JavaStreamString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// El uso de Java Stream String es muy com�n cuando utilizamos Java 8.
		// La realidad es que en muchos casos necesitamos transformar una cadena
		// de texto en otra cosa y que mejor que usar los Streams y la
		// programaci�n funcional para hacerlo. As� que todos nosotros
		// r�pidamente vamos a revisar el API de Java y ver si los Strings
		// soportan Streams para empezar a usarlo. Pronto nos encontramos con el
		// m�todo chars() que nos devuelve un String de caracteres. Esto nos
		// permite hacer operaciones como la siguiente.

		String texto = "hola que tal estas ahi? ";
		long total = texto.chars().mapToObj(i -> (char) i).filter(l -> l == 'a').count();
		System.out.println(total);

		// Acabamos de contar el numero de letras �a� que tiene una cadena y lo
		// hemos impreso por la consola.

		// La verdad es que esta muy bien pero es poco �til , no nos enga�emos.
		// Lo que nosotros queremos no es un Stream de chars.
		// Lo que queremos es un Stream de Strings.

		// Lamentablemente por mucho que revisemos el API de la clase String no
		// lo encontraremos. �Donde se encuentra ubicado este m�todo?. Este
		// m�todo se encuentra ubicado en el API de expresiones regulares lo
		// cual tiene tambi�n sentido , aunque a veces nos resulte extra�o.
		// Vamos a utilizar este API para partir una cadena y filtrarla.

		System.out.println("Stream de String...");
		String textoString = "nombre:pedro,nombre:gema,nombre:ana,nombre:jonathan";
		Stream<String> bloques = Pattern.compile(",").splitAsStream(textoString);
		bloques.map(cadena -> cadena.substring(7, cadena.length())).forEach(System.out::println);

		// En este caso hemos le�do una cadena de texto la hemos convertido en
		// un Stream utilizando el api de expresiones regulares partiendola por
		// el caracter �,� . Una vez hecho esto simplemente realizamos una
		// operaci�n de transformaci�n con map y nos quedamos con los nombres
		// que es lo que imprimimos por la consola.
	}

}
