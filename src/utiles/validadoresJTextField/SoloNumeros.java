package  utiles.validadoresJTextField;		


public class SoloNumeros extends Validador implements Validando{
	final String valoresNumericos="[0-9]{1,4}";
	public boolean valida(String palabra) {
		return palabra.matches(valoresNumericos) && palabra != "" && palabra != null;
	}
}
