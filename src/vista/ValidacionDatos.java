package vista;



import controlador.ControladorError;
import utiles.validadoresJTextField.Validador;

public class ValidacionDatos {
	private Validador validate=new Validador();
	private ControladorError controladorError=new ControladorError();
	public boolean compruebaDatosIncorrectos(String autor, String titulo, String precio, String ISBN) {
		boolean comprobar= false;
		if(validate.validaSoloLetras(autor)==false 
				|| validate.validaSoloLetras(titulo)==false
				|| validate.validaSoloNumeros(precio)==false
				|| validate.validaTamananoISBN(ISBN)==false){

			controladorError.controlErrorAutor(autor);
			controladorError.controlErrorTitulo(titulo);
			controladorError.controlErrorPrecio(precio);
			controladorError.controlErrorISBN(ISBN);
			return comprobar;
		}
		if(validate.validaSoloLetras(autor)
				&& validate.validaSoloLetras(titulo)
				&& validate.validaSoloNumeros(precio)
				&& validate.validaTamananoISBN(ISBN))
	{
			controladorError.controlErrorAutor(autor);
			controladorError.controlErrorTitulo(titulo);
			controladorError.controlErrorPrecio(precio);
			controladorError.controlErrorISBN(ISBN);
			comprobar=true;
			return comprobar;
	}
		return comprobar;
	}
	
	
	
	
public void  compruebaDatosCorrectos(String autor, String titulo, String precio, String ISBN) {
	if(validate.validaSoloLetras(autor)
			&& validate.validaSoloLetras(titulo)
			&& validate.validaSoloNumeros(precio)
			&& validate.validaTamananoISBN(ISBN))
{
		controladorError.controlErrorAutor(autor);
		controladorError.controlErrorTitulo(titulo);
		controladorError.controlErrorPrecio(precio);
		controladorError.controlErrorISBN(ISBN);
		
}
			
}
				
		
			
	
	
	
	
	
}

/*
 * 
 * 	if(validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldAutor().getText())==false 
				|| validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldTitulo().getText())==false
				|| validate.validaSoloNumeros(ui.getPanelPlantilla().getTextFieldPrecio().getText())==false
				|| validate.validaTamananoISBN(ui.getPanelPlantilla().getTextFieldISBN().getText())==false){
			*/
