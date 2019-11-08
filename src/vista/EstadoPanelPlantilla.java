package vista;

import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlador.ParaUI;

public class EstadoPanelPlantilla {

	ParaUI ui;

	public EstadoPanelPlantilla(ParaUI ui) {
		this.ui = ui;
	}

	
	public void activar(boolean estado, boolean estadoISBN) {
		this.iniciarAplicacion(estado, estadoISBN);
	}

ArrayList<JTextField> listaCuadro = new ArrayList<JTextField>();
ArrayList<JRadioButton> listaRadioButton = new ArrayList<JRadioButton>();

private void iniciarAplicacion(boolean estado, boolean estadoISBN) {
	listaCuadro = ui.getPanelPlantilla().listaTextField();
	for (JTextField e : listaCuadro) {
		e.setText("");
		e.setEnabled(estado);
	}
	listaRadioButton = ui.getPanelPlantilla().dameListaRadioButtonPrincipal();
	for (JRadioButton e : listaRadioButton) {
		e.setEnabled(estado);
	}
	ui.getPanelPlantilla().getComboBoxTema().setEnabled(estado);
	ui.getPanelPlantilla().getBotonCambiar().setVisible(false);
	
}
}
	



