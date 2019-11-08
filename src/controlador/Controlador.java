package controlador;
import java.util.ArrayList;

import almacen.AlmacenUnico;
import modelo.Edicion;
import modelo.Formato;
import modelo.Libro;
import modelo.Logica;
import modelo.Tema;


public class Controlador {
	private Logica logica;
	
	public Controlador() {
		
		this.logica = new Logica();

	}
	public void altaLibro(String titulo, String ISBN, int totalPaginas, double precio, String autor, Tema tema, Edicion edicion,
			Formato formato, int contador) {
		this.logica.altaLibro(titulo, ISBN, totalPaginas, precio, autor, tema, edicion, formato, contador);
	}
	
	public void  borrarLibro(int selectedIndex) {
		 logica.borrarLibro(selectedIndex);
	}
	public ArrayList <String> getTituloLibros() {
		return logica.getTituloLibros();
	}
	public ArrayList <String> getAutorLibros() {
		return logica.getAutorLibros();
		
	}
	public ArrayList <String> getISBNLibros() {
		return logica.getISBNLibros();
	}

	public Libro comprobarISBNdiferentes(String isbnNumber) {
		return logica.comprobarISBNdiferentes(isbnNumber);
	}

	public ArrayList <AlmacenUnico>  getLibrosAlmacen() {
		return logica.getLibrosAlmacen();
	}
	
	public ArrayList <Libro> getLista(){
		return logica.getLibros();
	}
	public void borrarLibroISBN(String ISBN) {
		logica.borrarLibroISBN(ISBN);
	}

public boolean comparaISBN(String ISBN){
return logica.comparaISBN(ISBN);
}
public boolean almacena(ArrayList <AlmacenUnico> obj){
	return logica.almacena(obj);
}
public void modificarLibro(String titulo, String ISBN, int totalPaginas, double precio, String autor, Tema tema, Edicion edicion,
		Formato formato, int contador) {
	logica.modificarLibro(titulo, ISBN, totalPaginas, precio, autor, tema, edicion, formato, contador);
}

public ArrayList <Integer> getCantidadLibros() {
	return logica.getCantidadLibros();
	
}
public void aumentarCantidad(String ISBN, int cantidad) {
	logica.aumentarCantidad(ISBN, cantidad);
}
public void disminuirCantidad(String ISBN, int cantidad) {
	logica.disminuirCantidad(ISBN, cantidad);
}



	/*
	public String verTitulo(int index) {
		return logica.verTitulo(index);
	}
	public String verAutor(int index) {
		return logica.verAutor(index);
	}
	public Long verISBN(int index) {
		return logica.verISBN(index);
	}
	public ArrayList <String> verTitulos(){
		return logica.verTitulos();
	}
	
	public void borrarCantidadTotalLibro(Long ISBN,int cantidad) {
		 logica.borrarCantidadLibro(ISBN, cantidad);
	}
	public String dameTituloLibro(Long ISBN) {
		return logica.dameTituloLibro(ISBN);
	}
	public String dameAutorLibro(Long ISBN) {
		return logica.dameAutorLibro(ISBN);
	}
	public double damePrecioLibro(Long ISBN) {
		return logica.damePrecioLibro(ISBN);
	}
	public int dameTotalPaginaLibro(Long ISBN) {
		return logica.dameTotalPaginaLibro(ISBN);
	}
	public int dameContadorLibro(Long ISBN) {
		return logica.dameContadorLibro(ISBN);
	}
	
	public int eliminarCantidadLibro(Long ISBN, int cantidad) {
		return logica.eliminarCantidadLibro(ISBN, cantidad);
	}
	public int sumarrCantidadLibro(Long ISBN, int cantidad) {
		return logica.sumarrCantidadLibro(ISBN, cantidad);
	}
	
	*/
}
