package modelo;

public enum Tema  {
Accion("Acci�n"), Aventura("Aventura"), Ciencia("Ciencia"), Biologia("Biolog�a"), Drama("Drama"), Misterio("Misterio"), Terror("Terror");
	private String valor;
	private Tema(String valor) {
		this.valor=valor;
	}



	public void setValor(String valor) {
		// TODO Auto-generated method stub
		this.valor=valor;
	}


	public String toStringTema() {
		// TODO Auto-generated method stub
		return this.valor;
	}
}
