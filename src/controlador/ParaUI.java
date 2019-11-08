	package controlador;
import EventosMenuItem.CambiarEstadoPanel;
import EventosMenuItem.DisminuiAlmacen;
import EventosMenuItem.GuardarCambios;
import EventosMenuItem.ModificarLibro;
import EventosMenuItem.VerListaLibro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import EventosMenuItem.AgregarNuevoLibro;
import EventosMenuItem.AumentarAlmacen;
import EventosMenuItem.BorrarConISBN;
import EventosMenuItem.BorrarLibro;
import EventosMenuItem.BorrarLibroSeleccionadoTabla;
import EventosMenuItem.BuscarLibro;
import vista.UI;


public class ParaUI extends UI {

//relacina la vista con los eventos
	public ParaUI() {
		super();
		Controlador controlador = new Controlador();
		getMenuBarr().getMenuItemIniciar().addActionListener(new CambiarEstadoPanel(this));
		getPanelPlantilla().getBotonIniciar().addActionListener(new CambiarEstadoPanel(this) );
		getMenuBarr().getMenuItemNuevoLibro().addActionListener(new AgregarNuevoLibro( controlador,this) );
		//getMenuBarr().getMenuItemBorrar().addActionListener(new BorrarLibro(controlador,this));
		getMenuBarr().getMenuItemBuscarLibro().addActionListener(new BuscarLibro(controlador,this));
		getMenuBarr().getMenuItemVerListaCompleta().addActionListener(new VerListaLibro(controlador,this));
		getMenuBarr().getMenuItemBorrar().addActionListener(new BorrarLibroSeleccionadoTabla(controlador,this));
		getMenuBarr().getMenuItemAumentarCantidad().addActionListener(new AumentarAlmacen(controlador,this));
		getMenuBarr().getMenuItemBorrarISBN().addActionListener(new BorrarConISBN(controlador,this));
		getMenuBarr().getMenuItemModificar().addActionListener(new ModificarLibro(controlador,this));
		getPanelPlantilla().getBotonCambiar().addActionListener(new GuardarCambios(controlador,this));
		getMenuBarr().getMenuItemDisminuirCantidad().addActionListener(new DisminuiAlmacen(controlador,this));
	}
	
	
	
}





	










