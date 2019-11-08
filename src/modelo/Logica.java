package modelo;


import java.util.ArrayList;

import almacen.AlmacenUnico;

public class Logica {
	private  String ruta= "Libros";
	private ArrayList<Libro> listaLibros;
	private AlmacenUnico almacenUnico;
	
	public Logica() {
		super();
		this.almacenUnico = new AlmacenUnico(ruta);
		this.almacenUnico.crearFile(ruta);
		this.listaLibros = getLibros();
	}

	public void altaLibro(String titulo, String ISBN, int totalPaginas, double precio, String autor, Tema tema, Edicion edicion,
			Formato formato, int contador) {
		Libro libro=new Libro(titulo, ISBN, totalPaginas, precio, autor, tema, edicion, formato, contador);
		
		listaLibros = getLibros();
		boolean igual= this.comparaISBN(ISBN);
		if(igual==false) {
			listaLibros.add(libro);
			almacenUnico.almacena(listaLibros);
			this.getLibrosAlmacen();
		}
		else{
			almacenUnico.almacena(listaLibros);
			this.getLibrosAlmacen();
		}
		
	
	
	}
		
	
	public boolean comparaISBN(String ISBN){
		boolean repetido=false;
		listaLibros = getLibros();
	
		for (int i = 0; i < listaLibros.size(); i++) {
			if(listaLibros.get(i).getISBN().compareTo(ISBN)!=0) {
				repetido=false;
				return repetido;
				
			}
			else if (listaLibros.get(i).getISBN().compareTo(ISBN)==0){
				repetido=true;
				return repetido;
			}
			
		}
		this.getLibrosAlmacen();
		return repetido;
	}
	
	public void borrarLibro(int selectedIndex) {
		listaLibros = getLibros();
		if(listaLibros.size()>0) {
			listaLibros.remove(selectedIndex);	
		}
		almacenUnico.almacena(listaLibros);
		this.getLibrosAlmacen();
	}
	
	public void borrarLibroISBN(String ISBN) {
		listaLibros = getLibros();
		try {
		this.almacenUnico.getFIle().delete();
		this.almacenUnico.crearFile(ruta);
		} catch(Exception s) {
			
		}
		Libro li=new Libro(ISBN);
		for (Libro libro : listaLibros) {
			if (libro.getISBN().equals(li.getISBN())!=true) {
				
				this.almacenUnico.almacena(listaLibros);
			}
		}
		
		this.getLibrosAlmacen();
	}
	

	
	
	
	
	
	
	public ArrayList<Libro> getLibros() {
		try {
			this.listaLibros = (ArrayList<Libro>) almacenUnico.recuperar();
		} catch (Exception e) {
			this.listaLibros = new ArrayList<>();
			almacenUnico.almacena(this.listaLibros);
			this.listaLibros = (ArrayList<Libro>) almacenUnico.recuperar();
		}
		return this.listaLibros;
	}
	public ArrayList <String> getTituloLibros() {
		String nombre="aa";
		ArrayList <String> nombres=new ArrayList <String>();
		ArrayList<Libro> lista = (ArrayList<Libro>) almacenUnico.recuperar();

		if(lista.size()>0) {
		for(int i=0; i<lista.size(); i++) {
			nombres.add(lista.get(i).getTitulo());
		}
		}
		if(lista.size()==0) {
			
		}
	
		return nombres;
	}
	public ArrayList <String> getAutorLibros() {
		String nombre="aa";
		ArrayList <String> nombres=new ArrayList <String>();
		ArrayList<Libro> lista = (ArrayList<Libro>) almacenUnico.recuperar();
		for(int i=0; i<lista.size(); i++) {
			nombres.add(lista.get(i).getAutor());
			
		}
	
		return nombres;
	}
	public ArrayList <String> getISBNLibros() {
		String nombre="aa";
		ArrayList <String> nombres=new ArrayList <String>();
		ArrayList<Libro> lista = (ArrayList<Libro>) almacenUnico.recuperar();
		for(int i=0; i<lista.size(); i++) {
			nombres.add(lista.get(i).getISBN());
			
		}
	
		return nombres;
	}
	public ArrayList <Integer> getCantidadLibros() {
		String nombre="aa";
		ArrayList <Integer> cantidades=new ArrayList <Integer>();
		ArrayList<Libro> lista = (ArrayList<Libro>) almacenUnico.recuperar();
		for(int i=0; i<lista.size(); i++) {
			cantidades.add(lista.get(i).getContador());
			
		}
	
		return cantidades;
	}

	public void aumentarCantidad(String ISBN, int cantidad) {
		int total=0;
		listaLibros = getLibros();
		for (int i = 0; i < listaLibros.size(); i++) {
			if(listaLibros.get(i).getISBN().compareTo(ISBN)==0) {
				total=listaLibros.get(i).getContador() ;
				listaLibros.get(i).setContador(total+ cantidad);
				this.almacenUnico.almacena(listaLibros);
			}
		}
		
	}
	public void disminuirCantidad(String ISBN, int cantidad) {
		listaLibros = getLibros();
		int total=0;
		for (int i = 0; i < listaLibros.size(); i++) {
			if(listaLibros.get(i).getISBN().compareTo(ISBN)==0) {
				if(listaLibros.get(i).getContador()>cantidad) {
				 total=listaLibros.get(i).getContador();
					listaLibros.get(i).setContador(total - cantidad);
					
				}
				
				if(listaLibros.get(i).getContador()<=cantidad) {
					listaLibros.get(i).setContador(0);
				
				}
			}
			
		}
		this.almacenUnico.almacena(listaLibros);
	}
	
	
	public ArrayList <AlmacenUnico>  getLibrosAlmacen() {
		
		 return (ArrayList<AlmacenUnico>) this.almacenUnico.recuperar();
	
	}
	
	public boolean almacena(ArrayList <AlmacenUnico> obj){
		return this.almacenUnico.almacena(obj);
		
	}
	
	
	public void modificarLibro(String titulo, String ISBN, int totalPaginas, double precio, String autor, Tema tema, Edicion edicion,
			Formato formato, int contador) {	
		listaLibros = getLibros();
		for (int i = 0; i < listaLibros.size(); i++) {
		if(listaLibros.get(i).getISBN().compareTo(ISBN)==0){
			listaLibros.remove(listaLibros.get(i));
			Libro nuevoLibro=new Libro(titulo, ISBN, totalPaginas, precio, autor, tema, edicion, formato, contador);
			listaLibros.add(nuevoLibro);
			almacenUnico.almacena(listaLibros);
		
		}
		else {
			
			almacenUnico.almacena(listaLibros);
			
		}
		}
	}
	
	
	
	
	
	
	
	
	public Libro comprobarISBNdiferentes(String isbnNumber) {
		
		for (Libro libro : listaLibros) {
			if(libro.getISBN().compareTo(isbnNumber)==1) {
				return libro;
			}
		}
		return null;
	}
	
}
