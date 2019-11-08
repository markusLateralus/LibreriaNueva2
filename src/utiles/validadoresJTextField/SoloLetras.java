package utiles.validadoresJTextField;		

public class SoloLetras extends Validador implements Validando{
	final String letras="[a-zA-Z\\s]{2,13}";
	public boolean valida(String palabra) {
		return palabra.matches(letras) && palabra != "" && palabra != null;
	}
}

