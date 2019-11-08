package modelo;

import java.util.AbstractList;
import java.util.ArrayList;

public class AlmacenIndividualLibro<Libro> {

	
	
	private AbstractList<Libro> list;
	private String path;
	private DAO<AbstractList<Libro>> dao;
	
	
	public ArrayList <Libro> dameLista(){
		ArrayList <Libro>lista=(ArrayList<Libro>) this.list;
		return lista;
	}
	


	public AlmacenIndividualLibro(AbstractList<Libro> list, String path) {
		super();
		assert list!=null&& path!=null;
		this.list = list;
		this.path = path;
		dao = new DAO<AbstractList<Libro>>();
		
	}

	public Libro obtener(int index) {
		getList();
		Libro retorno = null;
		if (index < list.size()) {
			retorno = list.get(index);
		}
		return retorno;
	}


	public boolean grabar(Libro libro) {
		assert libro!=null;
		boolean retorno = false;
		getList();
		if (list.add(libro) && dao.grabar(path, list)) {
			retorno = true;
		}
		getList();
		return retorno;
	}

	public ArrayList <Libro> getList() {
		ArrayList<Libro> temporal = (ArrayList<Libro>) dao.leer(path);
		if (temporal == null) {
			dao.grabar(path, list);
		} else {
			list = temporal;
		}
		return temporal;
	}

	
	public void borrar(String pathDatos, Integer posicion) {
		AbstractList<Libro> temporal = dao.leer(path);
		Libro retorno = null;
		if (posicion < list.size()) {
			retorno = list.get(posicion);
			list.remove(posicion);
	}
	}
	
	public void borrarElemento(Libro t) {
		AbstractList<Libro> temporal = dao.leer(path);
		list.remove(t);
	}
	
	
	public ArrayList <Libro> leerLista(String path) {
		AbstractList<Libro> temporal = dao.leer(path);
		ArrayList <Libro> lista=(ArrayList<Libro>) temporal;
		return  lista;
		}
	
	public ArrayList <String> leerLista2(String path) {
		AbstractList<Libro> temporal = dao.leer(path);
		if(temporal==null) {
			dao.grabar(path, list);
			ArrayList <String>listado=new ArrayList<String>();
			ArrayList <Libro> lista=(ArrayList<Libro>) temporal;
			for(String e:listado) {
				listado.add(lista.toString());
			}
			return listado;
			
		}else {
			list=temporal;
		
		ArrayList <String>listado=new ArrayList<String>();
		ArrayList <Libro> lista=(ArrayList<Libro>) temporal;
		for(String e:listado) {
			listado.add(lista.toString());
		}
		
		return listado;
	}
	}
	
}
