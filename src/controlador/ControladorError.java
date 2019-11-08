package controlador;

import mensajeErrorEtiqueta.ErrorAutor;
import mensajeErrorEtiqueta.ErrorISBN;
import mensajeErrorEtiqueta.ErrorPrecio;
import mensajeErrorEtiqueta.ErrorTitulo;

public class ControladorError {
private ErrorISBN errorISBN=new ErrorISBN();
private ErrorTitulo errorTitulo=new ErrorTitulo();
private ErrorAutor errorAutor=new ErrorAutor();
private ErrorPrecio errorPrecio=new ErrorPrecio();

	
	public void controlErrorISBN(String texto) {
		 this.errorISBN.error(texto);
	}
	public void controlErrorTitulo(String texto) {
		 this.errorTitulo.error(texto);
	}
	public void controlErrorAutor(String texto) {
		 this.errorAutor.error(texto);
	}
	public void controlErrorPrecio(String texto) {
		 this.errorPrecio.error(texto);
	}
	

}
