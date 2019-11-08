package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import almacen.AlmacenUnico;
import controlador.Controlador;
import controlador.ParaUI;

public class BuscarLibro implements ActionListener {
private Controlador controlador;
private ParaUI ui;
public BuscarLibro(Controlador controlador,ParaUI ui) {
	this.controlador=controlador;
	this.ui=ui;
}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ui.getPanelPlantilla().getLabelResultado().setText("BÚSQUEDA");
		ui.getPanelPlantilla().getBotonCambiar().setVisible(false);
		boolean seguir=false;
		String seleccion = JOptionPane.showInputDialog(ui,
				   "escriba el ISBN del libro para buscarlo", "BUSCANDO...",
				   JOptionPane.QUESTION_MESSAGE); 
		
	
		if(seleccion==null || seleccion.length()==0) {
			seguir=true;
		}
		else {	
		 int index=Integer.parseInt(seleccion);
		
		for (int i = 0; i < controlador.getLibrosAlmacen().size(); i++) {			
			 if(controlador.getLibrosAlmacen().indexOf(controlador.getLibrosAlmacen().get(i))==index) {
				 DefaultTableModel tb = (DefaultTableModel) ui.getPanelPlantilla().getTable().getModel();
			//	 tb.removeRow(index);
				 int contador=controlador.getLibrosAlmacen().size();
				 int numeroColumnas = ui.getPanelPlantilla().getTable().getModel().getColumnCount();
				 Object[] fila = new Object[numeroColumnas];
						fila[0] = controlador.getISBNLibros().get(index);
						fila[1] = controlador.getTituloLibros().get(index);
						fila[2] = controlador.getAutorLibros().get(index);
			 ((DefaultTableModel) ui.getPanelPlantilla().getTable().getModel()).addRow(fila);
			//	 ((DefaultTableModel) table.getModel()).addRow(fila);
			//	 controlador.buscarLibro(index);
		 }
		
		}
		
		ArrayList<AlmacenUnico> lista = controlador.getLibrosAlmacen();
		ui.getPanelPlantilla().getTextAreaResultado().setText(null);
		for (int i = 0; i < controlador.getISBNLibros().size(); i++) {
			if(controlador.getISBNLibros().get(i).equalsIgnoreCase(seleccion)){
				ui.getPanelPlantilla().getTextAreaResultado().append(lista.get(i) + "\n");
			}
			
		}
		
	
	
	
		}
		
		
	}

}
