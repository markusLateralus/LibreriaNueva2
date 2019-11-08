package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import controlador.ParaUI;
import modelo.Edicion;
import modelo.Formato;
import modelo.Libro;
import modelo.Tema;
import utiles.validadoresJTextField.Validador;

public class ModificarLibro implements ActionListener {

	private Controlador controlador;
	private ParaUI ui;
	public  ModificarLibro(Controlador controlador, ParaUI ui ) {
		// TODO Auto-generated constructor stub
		this.controlador=controlador;
		this.ui=ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean seguir=false;
		
		String seleccion = JOptionPane.showInputDialog(ui,
				   "escriba el ISBN del libro para modificarlo", "MODIFICANDO...",
				   JOptionPane.QUESTION_MESSAGE); 
		
	
		if(seleccion==null || seleccion.length()==0) {
			seguir=true;
		}
		else {
		for(Libro u:controlador.getLista()) {
			if(u.getISBN().compareTo(seleccion)!=0) {
				ui.getPanelPlantilla().getTextFieldISBN().setText(null);
				 JOptionPane.showMessageDialog(null, "El ISBN no exsite");
			}else {
				ui.getPanelPlantilla().getTextFieldISBN().setText(seleccion);
				ui.getPanelPlantilla().getBotonCambiar().setVisible(true);
		}	
			
		}
		}
			
	}
	
	
	
}
