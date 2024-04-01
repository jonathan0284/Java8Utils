package demo.list.map;

import java.util.ArrayList;
import java.util.List;

public class Viajero {

	private String nombre;
	private List<Viaje> lista = new ArrayList<Viaje>();

	public Viajero(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addViaje(Viaje v) {
		lista.add(v);
	}

	public List<Viaje> getLista() {
		return lista;
	}
}
