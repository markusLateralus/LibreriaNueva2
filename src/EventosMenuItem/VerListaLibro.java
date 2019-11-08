package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import almacen.AlmacenUnico;
import controlador.Controlador;
import controlador.ParaUI;

public class VerListaLibro implements ActionListener {

	private Controlador controlador;
	private ParaUI ui;

	public VerListaLibro(Controlador controlador, ParaUI ui) {
		// TODO Auto-generated constructor stub
		this.controlador = controlador;
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ui.getPanelPlantilla().getLabelResultado().setText("  LISTADO  ");
		ui.getPanelPlantilla().getBotonCambiar().setVisible(false);
		ui.getPanelPlantilla().getTextAreaResultado().setText(null);
	ArrayList<AlmacenUnico> lista = controlador.getLibrosAlmacen();

	
		try {
		if(lista.size()==0) {
			ui.getPanelPlantilla().getTextAreaResultado().append( "no hay libros en la librería");
		}
		else {
		for (int i = 0; i < lista.size(); i++) {
			ui.getPanelPlantilla().getTextAreaResultado().append(lista.get(i) + "\n");

		}
		}
		}catch(Exception a) {
			
		}
	

	}

}
