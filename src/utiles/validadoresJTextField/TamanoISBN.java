package  utiles.validadoresJTextField;

public class TamanoISBN extends Validador implements Validando {

	final String tamanoISBN="^[0-9]{2}$";
	
	public boolean valida(String ISBN) {
		return ISBN.matches(tamanoISBN) ;
	}
}
