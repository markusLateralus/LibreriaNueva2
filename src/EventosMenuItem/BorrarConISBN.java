package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import almacen.AlmacenUnico;
import controlador.Controlador;
import controlador.ParaUI;
import vista.EstadoPanelPlantilla;

public class BorrarConISBN implements ActionListener{

	private Controlador controlador;
	private ParaUI ui;
	 public BorrarConISBN(Controlador controlador, ParaUI ui) {
		this.controlador= controlador;
		this.ui=ui;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		ui.getPanelPlantilla().getBotonCambiar().setVisible(false);
		
boolean seguir=false;
String seleccion = JOptionPane.showInputDialog(ui,
		   "escriba el ISBN del libro que quierers borrar", "CUIDADO",
		   JOptionPane.WARNING_MESSAGE); 

if(seleccion==null || seleccion.length()==0) {
	seguir=true;
}
else {
	//controlador.borrarLibroISBN(seleccion);
	ui.getPanelPlantilla().getLabelResultado().setText("LIBRO BORRADO");	
	ui.getPanelPlantilla().getTextAreaResultado().setText(null);
	
	 ArrayList<AlmacenUnico> lista = controlador.getLibrosAlmacen();
		for (int j = 0; j < lista.size(); j++) {
			ui.getPanelPlantilla().getTextAreaResultado().append(lista.get(j) + "\n");
		}
		
		int index=Integer.parseInt(seleccion);
		
		for (int i = 0; i < controlador.getLista().size(); i++) {		
				 DefaultTableModel tb = (DefaultTableModel) ui.getPanelPlantilla().getTable().getModel();
				if(controlador.getLista().get(i).getISBN().compareTo(seleccion)==0) {
					int indice=controlador.getLista().indexOf(controlador.getLista().get(i));
					 tb.removeRow(indice);
				}
				 controlador.borrarLibroISBN(seleccion);
				// controlador.borrarLibroISBN(seleccion);
				//controlador.borrarLibro(index);
			 } 
		 }
ui.getPanelPlantilla().getTextAreaResultado().setText(null);

ArrayList<AlmacenUnico> lista = controlador.getLibrosAlmacen();
	for (int j = 0; j < lista.size(); j++) {
		ui.getPanelPlantilla().getTextAreaResultado().append(lista.get(j) + "\n");
	}
		
		}
}
	 


		
	


