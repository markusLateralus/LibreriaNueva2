package mensajeErrorEtiqueta;

import javax.swing.JOptionPane;
import utiles.validadoresJTextField.Validador;


public class ErrorISBN implements DarMensaje{

	private Validador validador=new Validador();
	public void error(String texto) {
		boolean seguir=true;
		do {
		if(validador.validaTamananoISBN(texto)==false) {
			 JOptionPane.showMessageDialog(null, " campo de ISBN no válido o insuficiente");
			
		}
		
		else if(validador.validaTamananoISBN(texto)) {
			seguir=true;
			
		}
		}while(!seguir);
		
	}
}
