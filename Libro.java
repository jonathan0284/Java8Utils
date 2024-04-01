package demo.list.map;

public class Libro {

	private String titulo;
	private String categoria;
	private int paginas;

	public Libro(String titulo, String categoria, int paginas) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

}
