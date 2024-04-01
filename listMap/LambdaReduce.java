package demo.list.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LambdaReduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Java Lambda reduce es una de las operaciones m�s utilizadas cuanto
		// trabajamos con colecciones de objetos y expresiones lambda. Reduce
		// sirve para convertir un Array de elementos en un �nico elemento y se
		// usa por ejemplo para calcular la suma de "n" t�rminos. Veamos un
		// ejemplo sin expresiones lambda

		List<Integer> lista = new ArrayList<Integer>();
		lista.add(5);
		lista.add(2);
		lista.add(7);
		lista.add(9);
		int total = 0;
		for (int numero : lista) {

			total += numero;
		}
		System.out.println(total);

		// Java Lambda reduce
		// Es f�cil convertir esto al mundo de los Streams y las expresiones
		// lambda utilizando Java Lambda reduce para que sea esa funci�n la que
		// sume.

		int resultado = IntStream.of(5, 2, 7, 9).reduce(0, (x, y) -> x + y);
		System.out.println(resultado);

		// El c�digo se reduce de forma clara , la realidad es que este tipo de
		// operaciones las tenemos que hacer continuamente. La nueva forma de
		// operar con Streams y Lambda lo simplifica mucho .�Podemos mejorar un
		// poco el c�digo?. Si en vez de crear nosotros nuestra propia expresi�n
		// lambda podemos usar un reference method y apuntar a la clase
		// wrapper(Integer) que ser� la encargada de realizar la suma
		// apoy�ndonos en el m�todo sum.

		int resultado2 = IntStream.of(5, 2, 7, 9).reduce(0, Integer::sum);
		System.out.println(resultado2);

	}

}
