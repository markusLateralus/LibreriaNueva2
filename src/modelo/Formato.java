package modelo;

public enum Formato {
	Rustica("R�stica"), Cartone("Carton�"), TapaDura("Tapa dura");
	private String valor;

	private Formato(String valor) {
		this.valor = valor;
	}

	public String toStringFormato() {
		return this.valor;
	}
}
