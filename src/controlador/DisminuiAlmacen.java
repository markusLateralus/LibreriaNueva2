package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Libro;

public class DisminuiAlmacen implements ActionListener {

	private Controlador controlador;
	private ParaUI ui;

	public DisminuiAlmacen(Controlador controlador, ParaUI ui) {
		this.controlador = controlador;
		this.ui = ui;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean seguir = false;
		String ISBN = JOptionPane.showInputDialog(ui, "escriba el ISBN del libro", "INFORMATIVO",
				JOptionPane.INFORMATION_MESSAGE);

		if (ISBN == null || ISBN.length() == 0) {
			seguir = true;
		}

		else {
			if (controlador.comparaISBN(ISBN) == false) {
				JOptionPane.showMessageDialog(null, "El ISBN no existe");
			}

			if (controlador.comparaISBN(ISBN)) {
				int cantidad = 0;
				// ui.getPanelPlantilla().getTextFieldAlmacen().setVisible(true);
				cantidad = Integer.parseInt(ui.getPanelPlantilla().getTextFieldAlmacen().getText());
				controlador.disminuirCantidad(ISBN, cantidad);
				JOptionPane.showMessageDialog(null, "almacen diminuido exitosamente");
				for (Libro a : controlador.getLista()) {
					if (a.getISBN().equalsIgnoreCase(ISBN) && a.getContador() >= 1) {
					
							ui.getPanelPlantilla().getTextAreaResultado().setText("el libro con isbn " + ISBN
									+ " ha disminuido su almacenamiento en " + a.getContador() + " unidades en total");
								System.out.println(a.getContador());
						}
					 if ( a.getISBN().equalsIgnoreCase(ISBN) && a.getContador() == 0) {

							ui.getPanelPlantilla().getTextAreaResultado().setText("el libro con isbn " + ISBN
									+ " ha disminuido su almacenamiento en " + a.getContador() + " unidades en total");
							JOptionPane.showMessageDialog(null, "se han vendido todas las unidades");
						}
					}

				}

			}
		}

	}

