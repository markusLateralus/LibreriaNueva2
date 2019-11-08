package modelo;

import java.io.Serializable;

public class Libro implements Serializable{

	private String titulo;
	private String ISBN;
	private Tema tema;
	private Edicion edicion;
	private Formato formato;
	private String autor;
	private double precio;
	private int totalPaginas;
	private int contador;
	private boolean eliminado=false;
	public Libro() {
	};
	public Libro(String ISBN) {
		this.ISBN=ISBN;
	}

	public Libro(String titulo, String ISBN, int totalPaginas, double precio, String autor, Tema tema, Edicion edicion,
			Formato formato, int contador) {
		this.ISBN = ISBN;
		this.precio = precio;
		this.titulo = titulo;
		this.totalPaginas = totalPaginas;
		this.autor = autor;
		this.tema = tema;
		this.edicion = edicion;
		this.formato = formato;
		this.contador = contador;

	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getContador() {
		// TODO Auto-generated method stub
		return this.contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "TÍTULO:" + titulo + ", ISBN= " + ISBN + " NÚMERO PÁG.: " + totalPaginas + " PRECIO: " + precio
				+ " euros, AUTOR: " + autor + " TEMA: " + tema + " EDICIÓN: " + edicion + " FORMATO : " + formato
				+ " TOTAL LIBROS : " + contador ;

	}


	
	@Override
	public boolean equals(Object obj) {
		Libro libro = (Libro) obj;
		boolean retorno = super.equals(obj);
		if (!retorno) {
			retorno = this.ISBN.equals(libro.ISBN);
		}
		return retorno;
		
	}

	public int compareTo(Libro o) {
		return this.ISBN.compareTo(o.ISBN);
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Edicion getEdicion() {
		return edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	public boolean isEliminado() {
		return eliminado;
	}

}
