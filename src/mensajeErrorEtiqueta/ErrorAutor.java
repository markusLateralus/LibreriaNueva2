package mensajeErrorEtiqueta;

import javax.swing.JOptionPane;
import utiles.validadoresJTextField.Validador;

		
public class ErrorAutor implements DarMensaje {
	private Validador validador=new Validador();
	public void error(String texto) {
		boolean seguir=true;
		do {
		if(validador.validaSoloLetras(texto)==false) {
			 JOptionPane.showMessageDialog(null, " campo de AUTOR no válido o insuficiente ");
				
		}
		else if(validador.validaSoloLetras(texto)==true) {
			seguir=true;
		}
		}while(!seguir);
		
	}
}
