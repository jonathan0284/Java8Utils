package demo.list.map;

import java.util.function.Predicate;

public class LibroUtils {

	public static Predicate<Libro> filtroCategoria(String categoria) {
		return (Libro l) -> {
			return l.getCategoria().equals(categoria);
		};
	}

	// Sin embargo lo más habitual en muchos casos es generar expresiones
	// funcionales complejas y luego ligarlas a través de métodos de
	// referencia . Por ejemplo algo como la siguiente expresion.

	public static boolean buenosLibros(Libro libro) {
		Predicate<Libro> p1 = (Libro l) -> l.getCategoria().equals("ciencia ficcion");
		Predicate<Libro> p2 = (Libro l) -> l.getCategoria().equals("fantasia");
		Predicate<Libro> p3 = (Libro l) -> l.getPaginas() > 1000;
		Predicate<Libro> ptotal = p1.or(p2).and(p3);
		return ptotal.test(libro);
	}
}
