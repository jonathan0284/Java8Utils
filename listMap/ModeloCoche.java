package demo.list.map;

public class ModeloCoche {

	private int id;
	private String identificador;
	private String marca;
	private double precio;

	public ModeloCoche(int id, String identificador, String marca, double precio) {
		super();
		
		this.id = id;
		this.identificador = identificador;
		this.marca = marca;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
