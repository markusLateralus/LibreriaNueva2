package  utiles.validadoresJTextField;


public class Validador {

public boolean validaSoloLetras(String palabra) {
	
	return new SoloLetras().valida(palabra);
}
public boolean validaSoloNumeros( String palabra) {

	return new SoloNumeros().valida(palabra);
}
public boolean validaTamananoISBN( String ISBN) {
	return new TamanoISBN().valida(ISBN);
}
public boolean esUnico(String ISBN) {
	return new ISBNunico().esUnico(ISBN);
}

}


 