package solucionB;

public class prueba {
	public static boolean probador(Validador validador, String texto) {
		return validador.validar(texto);
	}

	public static void main(String[] args) {
		probador(new ValidadorISBN()
,"mitexto");

	}

}
