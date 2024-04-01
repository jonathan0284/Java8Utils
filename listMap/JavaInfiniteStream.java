package demo.list.map;

import java.util.stream.DoubleStream;

public class JavaInfiniteStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �Qu� es un Java Infinite Stream? . Los streams infinitos son una de
		// las caracter�sticas m�s interesantes del API de Java 8. Nos permiten
		// realizar operaciones habituales enfoc�ndolas desde la programaci�n
		// funcional. Por ejemplo supongamos que queremos sumar los primeros
		// 1000 n�meros enteros en Java . Es una operaci�n muy sencilla
		// simplemente construimos un bucle for, lo recorremos y sumamos.

		double total = 0;
		long t1 = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			total = total + (i + 1);
		}
		long t2 = System.nanoTime();

		System.out.println(total);
		System.out.println(t2 - t1);

		// En este caso he usado tambi�n el m�todo System.nanoTime() que permite
		// hacer un calculo preciso del tiempo que esta operaci�n tarda en
		// ejecutarse.

		// Todo funciona correctamente y Java nos realiza la suma . Ahora bien
		// podemos enfocar de otra manera

		// Java Infinite Stream
		// Podemos usar un Stream infinito y realizar la misma operaci�n
		// apoy�ndonos en programaci�n funcional.

		System.out.println("Java Infinite Stream ....");
		long t3 = System.nanoTime();

		double resultado = DoubleStream.iterate(0, i -> i + 1).limit(1001).sum();

		long t4 = System.nanoTime();

		System.out.println(resultado);
		System.out.println(t4 - t3);

		// Acabamos de usar la clase DoubleStream que es capaz de generar
		// Streams de Doubles , en este caso hemos usado el m�todo iterate()
		// para generar un stream infinito. Esto quiere decir que se generar�n
		// n�meros hasta que decidamos un l�mite. En este caso como queremos que
		// sean los primeros 1000 elementos ponemos el tope en 1001. El
		// resultado ser� id�ntico con la salvedad del tiempo de ejecuci�n que
		// ser� mucho mayor.

		// -----------------------------------------------------------------------------------

		// Acabamos de realizar la operaci�n de suma de n t�rminos con un Java
		// Infinite Stream. El resultado parece anecd�tico ya que el bucle for
		// se ejecuta mucho m�s r�pido. Esto es normal ya que es una operaci�n
		// b�sica . Sin embargo la gran ventaja de los Streams infinitos viene
		// en que se pueden paralelizar utilizando el m�todo parallel() de los
		// streams .

		System.out.println("Java Infinite Stream (Parallel)....");

		long t5 = System.nanoTime();
		double resultadoParallel = DoubleStream.iterate(0, i -> i + 1).limit(1001).parallel().sum();
		long t6 = System.nanoTime();

		System.out.println(resultadoParallel);
		System.out.println(t6 - t5);

		// Esto abre la posibilidad de procesar una operaci�n compleja entre
		// varios hilos de forma concurrente, mejorando el rendimiento algo que
		// un simple bucle for no es sencillo
		// Los streams infinitos son �tiles cuando queremos realizar operaciones
		// complejas sobre un conjunto amplio de datos.

	}

}
