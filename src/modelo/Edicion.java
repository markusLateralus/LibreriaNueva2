package modelo;


public enum Edicion {
Novedad("Novedad"), Reedicion("Reedici�n");
	private String valor;
	private Edicion(String valor) {
		this.valor=valor;
	}

	public String toStringEdicion() {
		return this.valor;
	}

	
}
