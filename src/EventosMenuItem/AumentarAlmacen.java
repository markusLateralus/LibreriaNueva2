package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import almacen.AlmacenUnico;
import controlador.Controlador;
import controlador.ParaUI;
import modelo.Libro;

public class AumentarAlmacen implements ActionListener {
	private Controlador controlador;
	private ParaUI ui;

public AumentarAlmacen(Controlador controlador, ParaUI ui) {
	this.controlador=controlador;
	this.ui=ui;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean seguir=false;
		String ISBN = JOptionPane.showInputDialog(ui,
				   "escriba el ISBN del libro", "INFORMATIVO",
				   JOptionPane.INFORMATION_MESSAGE); 
	
		if(ISBN==null || ISBN.length()==0) {
			seguir=true;
		}
		
		
		else {
		if(controlador.comparaISBN(ISBN)==false) {
			JOptionPane.showMessageDialog(null, "El ISBN no existe");
		}
			
		if(controlador.comparaISBN(ISBN)){
			int cantidad=0;		
		//	ui.getPanelPlantilla().getTextFieldAlmacen().setVisible(true);
			cantidad=Integer.parseInt(ui.getPanelPlantilla().getTextFieldAlmacen().getText());
					controlador.aumentarCantidad(ISBN, cantidad);
					JOptionPane.showMessageDialog(null, "almacen aumentado exitosamente");
				for(Libro a: controlador.getLista()) {
					if(a.getISBN().equalsIgnoreCase(ISBN)) {
						ui.getPanelPlantilla().getTextAreaResultado().setText("el libro con isbn " + ISBN +" ha aumentado su almacenamiento en " +  a.getContador() + " unidades");
					}
				}
					
					}
					
				}
		}
				
		
			
			
			}		
	
		
				
			
	

	
	
