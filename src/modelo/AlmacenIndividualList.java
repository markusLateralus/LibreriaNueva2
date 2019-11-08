package modelo;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * 
 * @author estar
 *
 *Cuando en un fichero hemos almacenado un solo elemento y es una Lis
 * @param <T>
 */
public class AlmacenIndividualList<T> {

	private AbstractList<T> list;
	private String path;
	private DAO<AbstractList<T>> dao;

	public AlmacenIndividualList(AbstractList<T> list, String path) {
		super();
		assert list!=null&& path!=null;
		this.list = list;
		this.path = path;
		dao = new DAO<AbstractList<T>>();
	}

	public T obtener(int index) {
		getList();
		T retorno = null;
		if (index < list.size()) {
			retorno = list.get(index);
		}
		return retorno;

	}

	
	public T leerLista(String path) {
	AbstractList<T> temporal = dao.leer(path);
	ArrayList <T> lista=(ArrayList<T>) temporal;
	return (T) lista;
	}
	
	
	public boolean grabar(T t) {
		assert t!=null;
		boolean retorno = false;
		getList();
		if (list.add(t) && dao.grabar(path, list)) {
			retorno = true;
		}
		getList();
		return retorno;
	}

	private void getList() {
		AbstractList<T> temporal = dao.leer(path);
		if (temporal == null) {
			dao.grabar(path, list);
		} else {
			list = temporal;
		}
	}
	
	
	public void borrarElemento(String pathDatos, Integer posicion) {
		getList();
		T retorno = null;
		if (posicion < list.size()) {
			retorno = list.get(posicion);
			list.remove(posicion);
		}
	}
	
	public void borrarElemento(T t) {
		getList();
		list.remove(t);
	}
	

	


	
	
}
