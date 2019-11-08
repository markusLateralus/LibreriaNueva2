package mensajeErrorEtiqueta;

import javax.swing.JOptionPane;

import utiles.validadoresJTextField.Validador;
	

public class ErrorPrecio implements DarMensaje{

	
	private Validador validador=new Validador();
	public void error(String texto) {
		boolean seguir=true;
		do {
		if(validador.validaSoloNumeros(texto)==false) {
			 JOptionPane.showMessageDialog(null, " campo de Precio no válido ");
		}
		else if(validador.validaSoloNumeros(texto)) {
			seguir=true;
		}
		}while(!seguir);
		
	}
}
