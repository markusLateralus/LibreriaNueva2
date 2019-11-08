package utiles.validadoresJTextField;

import java.util.ArrayList;
import controlador.Controlador;
import modelo.Libro;

public class ISBNunico {
private ArrayList <Libro> listaLibros;
private Controlador controlador=new Controlador();
public ISBNunico() {

	//listaLibros=new ArrayList <Libro> ();
}
	public boolean esUnico(String ISBN) {
		boolean repetido=true;
		listaLibros=controlador.getLista();
		for ( Libro li : listaLibros) {
			if(li.getISBN().compareTo(ISBN)==0) {
				System.out.println("desde validador has repetido isbn");
				repetido=true;
				return repetido;
			}
			else if(li.getISBN().compareTo(ISBN)!=0) {
				repetido=false;
				System.out.println("desde validador no has repetido");
				return repetido;
			}
			
}
		return repetido;
}
}