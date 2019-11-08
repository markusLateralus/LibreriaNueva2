package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import almacen.AlmacenUnico;
import controlador.Controlador;
import controlador.ParaUI;
import modelo.Libro;

public class BorrarLibro implements ActionListener {
private Controlador controlador;
private ParaUI ui;
public BorrarLibro(Controlador controlador,ParaUI ui) {
	this.controlador=controlador;
	this.ui=ui;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//ui.getPanelPlantilla().getTable().setVisible(false);
	//	this.limpiarTabla();
		        
		boolean seguir=false;
		String seleccion = JOptionPane.showInputDialog(ui,
				   "escriba el INDICE de la lista para borrar el  libro", "CUIDADO",
				   JOptionPane.WARNING_MESSAGE); 
	
		if(seleccion==null || seleccion.length()==0) {
			seguir=true;
		}
		else {
			//controlador.borrarLibroISBN(seleccion);
			
			ui.getPanelPlantilla().getTextAreaResultado().setText(null);
			 int index=Integer.parseInt(seleccion);
			 try {
			for (int i = 0; i < controlador.getLibrosAlmacen().size(); i++) {			
				 if(controlador.getLibrosAlmacen().indexOf(controlador.getLibrosAlmacen().get(i))==index) {
					 DefaultTableModel tb = (DefaultTableModel) ui.getPanelPlantilla().getTable().getModel();
					
					 tb.removeRow(index);
					// controlador.borrarLibroISBN(seleccion);
					controlador.borrarLibro(index);
				 
			 }
				 }
			 }catch(Exception o) {
			}
			 ArrayList<AlmacenUnico> lista = controlador.getLibrosAlmacen();
				for (int j = 0; j < lista.size(); j++) {
					ui.getPanelPlantilla().getTextAreaResultado().append(lista.get(j) + "\n");

				}
		}
	}
			
			

			
					
			//		ui.getPanelPlantilla().getTextAreaResultado().append(lista.get(i) + "\n");
				
				
			
			
			/*
			ArrayList<AlmacenUnico> lista = controlador.getLibrosAlmacen();
			ui.getPanelPlantilla().getTextAreaResultado().setText(null);
			for (int i = 0; i < lista.size(); i++) {
				ui.getPanelPlantilla().getTextAreaResultado().append(lista.get(i) + "\n");

			}
				*/ 
			
		

	


/*					juan antonio
 * 		logica.borrarLibro(logicaGrafica.getPosicionLibroActual());
		logicaGrafica.pintarLista(logica.getLibros());
		logicaGrafica.resetearInformacion();
		logicaGrafica.mostrarMensajeError("libro eliminado", false);
 */
		
		public void limpiarTabla() {
			
			        DefaultTableModel tb = (DefaultTableModel) ui.getPanelPlantilla().getTable().getModel();
			        int a = ui.getPanelPlantilla().getTable().getRowCount()-1;
			        for (int i = a; i >= 0; i--) {          
			        tb.removeRow(tb.getRowCount()-1);
			        }
			        //cargaTicket();
			        tb.setRowCount(0);
			    }
		
		
		
}	
		



