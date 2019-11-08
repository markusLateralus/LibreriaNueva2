package vista;

import javax.swing.*;


public class BarraMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu MenuAbrir;
	private JMenuItem MenuItemNuevoLibro;
	private JMenu MenuOpciones;
	private JMenuItem MenuItemBuscarLibro;
	private JMenuItem MenuItemBorrar;
	private JMenu MenuAlmacen;
	private JMenuItem MenuItemAumentarCantidad;
	private JMenuItem MenuItemDisminuirCantidad;
	private JMenuItem MenuItemIniciar;
	private JMenuItem MenuItemVerListaCompleta;
	private JMenuItem MenuItemBorrarISBN;
	private JMenuItem MenuItemModificar;
	
	public BarraMenu() {
		this.MenuAbrir=new JMenu("Abrir");
		this.add(MenuAbrir);
		
		MenuItemIniciar = new JMenuItem("Iniciar");
		MenuAbrir.add(MenuItemIniciar);
		MenuItemNuevoLibro=new JMenuItem("Nuevo Libro");
		this.MenuAbrir.add(MenuItemNuevoLibro);
		
		this.MenuOpciones=new JMenu("Opciones");
		this.add(MenuOpciones);
		this.MenuItemBuscarLibro= new JMenuItem("Buscar");
		this.MenuOpciones.add(MenuItemBuscarLibro);
		
		MenuItemModificar = new JMenuItem("Modificar");
		MenuOpciones.add(MenuItemModificar);
		
		MenuItemBorrar = new JMenuItem("Borrar");
		MenuOpciones.add(MenuItemBorrar);
		
		MenuItemBorrarISBN = new JMenuItem("Borrar con ISBN");
		MenuOpciones.add(MenuItemBorrarISBN);
		
		MenuItemVerListaCompleta = new JMenuItem("Ver Lista Completa");
		MenuOpciones.add(MenuItemVerListaCompleta);
		
		MenuAlmacen = new JMenu("Almacen");
		add(MenuAlmacen);
		
		MenuItemAumentarCantidad = new JMenuItem("Aumentar Stock");
		MenuAlmacen.add(MenuItemAumentarCantidad);
		
		MenuItemDisminuirCantidad = new JMenuItem("Ventas Stock");
		MenuAlmacen.add(MenuItemDisminuirCantidad);
		
		
	}
	public JMenuItem getMenuItemModificar() {
		return MenuItemModificar;
	}
	public JMenuItem getMenuItemBorrarISBN() {
		return MenuItemBorrarISBN;
	}
	public JMenuItem getMenuItemVerListaCompleta() {
		return MenuItemVerListaCompleta;
	}

	public JMenu getMenuAbrir() {
		return MenuAbrir;
	}

	public JMenu getMenuOpciones() {
		return MenuOpciones;
	}
	public JMenuItem getMenuItemNuevoLibro() {
		return MenuItemNuevoLibro;
	}
	public JMenuItem getMenuItemBuscarLibro() {
		return MenuItemBuscarLibro;
	}
	public JMenuItem getMenuItemBorrar() {
		return MenuItemBorrar;
	}
	public JMenu getMenuAlmacen() {
		return MenuAlmacen;
	}
	public JMenuItem getMenuItemAumentarCantidad() {
		return MenuItemAumentarCantidad;
	}
	public JMenuItem getMenuItemDisminuirCantidad() {
		return MenuItemDisminuirCantidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public JMenuItem getMenuItemIniciar() {
		return MenuItemIniciar;
	}

}
