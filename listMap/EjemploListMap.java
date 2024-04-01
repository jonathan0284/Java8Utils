package demo.list.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EjemploListMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ModeloCoche modelo1 = new ModeloCoche(1, "Y1Yaris", "Toyota", 16000);
		ModeloCoche modelo2 = new ModeloCoche(2, "N123_Nissan", "Nissan", 20000);
		ModeloCoche modelo3 = new ModeloCoche(3, "M856_Mercedez", "Mercedez", 22000);
		List<ModeloCoche> modelos = Arrays.asList(modelo1, modelo2, modelo3);

		// Supongamos que deseamos buscar dentro de la lista el Toyota Yaris
		// �Y1Yaris� e imprimir sus datos por pantalla. Con Java 8 es
		// relativamente sencillo. Podemos usar un stream y el m�todo findFirst
		// que nos devuelve un optional.

		Optional<ModeloCoche> optional = modelos.stream().filter(m -> m.getIdentificador().equals("Y1Yaris"))
				.findFirst();

		if (optional.isPresent()) {
			System.out.println(optional.get().getMarca());
			System.out.println(optional.get().getPrecio());
		}

		// �Es esta la soluci�n correcta? . La realidad es que �depende� .
		// Depende de si sobre esta lista vamos a buscar una �nica vez o vamos a
		// buscar muchas veces. Por ejemplo imagin�monos que la lista de
		// elementos contiene todas las marcas y los modelos de los coches.
		// Puede ser una lista muy grande de elementos que nos interese tener
		// cargada en memoria en una aplicaci�n web ya sea a trav�s de un
		// mecanismo de cache o a trav�s del ServletContext.
		// Si la consultamos en muchas p�ginas para sacar la informaci�n de uno
		// u otro modelo de coche. Tendremos continuamente que buscar dentro de
		// la lista un �nico resultado.
		// Ser�a mucho mejor almacenar esta estructura en memoria convertida en
		// un mapa. Los mapas nos permiten acceder mucho m�s r�pido a un
		// elemento a trav�s de su hash ya que accedemos a una sublista.
		// �C�mo podemos hacer esto? . Muy sencillo podemos usar Java 8 y el
		// collector de mapas para convertir de forma directa la estructura de
		// list a una estructura map
		// De esta forma ser� mucho m�s r�pido y mucho m�s sencillo acceder a
		// los datos de un elemento concreto a trav�s de del uso de su
		// identificador. Acabamos de usar Java Streams para realizar una
		// conversi�n autom�tica de Java List to Map. Este tipo de colectores
		// nos puede ser muy �til cuando necesitemos almacenar informaci�n que
		// va a ser continuamente consultada a traves de una cache o mecanismo
		// similar.

		List<ModeloCoche> modelos2 = Arrays.asList(modelo1, modelo2, modelo3);

		Map<Integer, ModeloCoche> mapa = modelos2.stream().collect(Collectors.toMap(x -> x.getId(), x -> x));

		ModeloCoche nuevoModelo1 = mapa.get(2);

		System.out.println(nuevoModelo1.getMarca());
		System.out.println(nuevoModelo1.getPrecio());

	}
}
