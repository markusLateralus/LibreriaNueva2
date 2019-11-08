package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import controlador.ParaUI;

public class BorrarLibroSeleccionadoTabla implements ActionListener {

	private Controlador controlador;
	private ParaUI ui;
	
	public BorrarLibroSeleccionadoTabla(Controlador controlador, ParaUI ui) {
		this.controlador=controlador;
		this.ui=ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ui.getPanelPlantilla().getBotonCambiar().setVisible(false);
		if(ui.getPanelPlantilla().getTable().getSelectedRow()!=-1) {
			int indice=ui.getPanelPlantilla().getTable().getSelectedRow();
			 DefaultTableModel tb = (DefaultTableModel) ui.getPanelPlantilla().getTable().getModel();
			 tb.removeRow(ui.getPanelPlantilla().getTable().getSelectedRow());
			 controlador.borrarLibro(indice);
			}
		
		

}
}