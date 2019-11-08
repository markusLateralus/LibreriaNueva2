package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridLayout;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;

 public class PanelPlantilla extends JPanel {
	private JTextField textFieldISBN;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldPrecio;
	private JTextField textFieldCantidad;
	private JTextField textFieldTotalPagina;
	private JTextField textFieldAlmacen;
	private JButton botonOpciones;
	private JButton botonCambiar;
	private  ButtonGroup buttonGroupFormato = new ButtonGroup();
	private  ButtonGroup buttonGroupEdicion = new ButtonGroup();
	

	public JTextField getTextFieldISBN() {
		return textFieldISBN;
	}
	public JTextField getTextFieldAlmacen() {
		return textFieldAlmacen;
	}
	public void setTextFieldISBN(JTextField textFieldISBN) {
		this.textFieldISBN = textFieldISBN;
	}
	public JTextField getTextFieldTitulo() {
		return textFieldTitulo;
	}
	public void setTextFieldTitulo(JTextField textFieldTitulo) {
		this.textFieldTitulo = textFieldTitulo;
	}
	public JTextField getTextFieldAutor() {
		return textFieldAutor;
	}
	public void setTextFieldAutor(JTextField textFieldAutor) {
		this.textFieldAutor = textFieldAutor;
	}
	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}
	public void setTextFieldPrecio(JTextField textFieldPrecio) {
		this.textFieldPrecio = textFieldPrecio;
	}
	public JTextField getTextFieldCantidad() {
		return textFieldCantidad;
	}
	public void setTextFieldCantidad(JTextField textFieldContador) {
		this.textFieldCantidad = textFieldContador;
	}
	public JTextField getTextFieldTotalPagina() {
		return textFieldTotalPagina;
	}
	public void setTextFieldTotalPagina(JTextField textFieldTotalPagina) {
		this.textFieldTotalPagina = textFieldTotalPagina;
	}
	public ButtonGroup getButtonGroupFormato() {
		return buttonGroupFormato;
	}
	public ButtonGroup getButtonGroupEdicion() {
		return buttonGroupEdicion;
	}

	private ArrayList <JTextField> listaCuadroTexto=new ArrayList <JTextField>();
public ArrayList <JTextField> getListaCuadroTexto(){
	return this.listaCuadroTexto;
}
	
	public ArrayList <JTextField> listaTextField(){
	listaCuadroTexto.add(textFieldAutor);
	listaCuadroTexto.add(textFieldTitulo);
	listaCuadroTexto.add(textFieldISBN);
	listaCuadroTexto.add(textFieldPrecio);
	listaCuadroTexto.add(textFieldCantidad);
	listaCuadroTexto.add(textFieldTotalPagina);
	return this.listaCuadroTexto;
}

	private JRadioButton radioButtonCartone;
	private JRadioButton radioButtonRustica;
	private JRadioButton radioButtonTapaDura ;
	private JRadioButton radioButtonNovedad ;
	private JRadioButton radioButtonReedicion;
    private JComboBox comboBoxTema;
    private JTextArea textAreaResultado;
    public JTextArea getTextAreaResultado() {
    	return textAreaResultado;
    }
	/**
	 * Create the panel.
	 */
	private JPanel panelAgregarDatosLibro;
	public JPanel getPanelAgregarDatosLibro() {
		return panelAgregarDatosLibro;
	}

	
	public PanelPlantilla() {
		
		setBackground(Color.CYAN);
		
	    panelAgregarDatosLibro = new JPanel();
		panelAgregarDatosLibro.setBackground(new Color(0, 255, 255));
		
		JLabel labelCabeceraAgregarLibro = new JLabel("LIBRERIA");
		labelCabeceraAgregarLibro.setHorizontalAlignment(SwingConstants.CENTER);
		labelCabeceraAgregarLibro.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		JPanel panelAgregarOpcionesLibro = new JPanel();
		panelAgregarOpcionesLibro.setBackground(Color.CYAN);
		
		 textAreaResultado = new JTextArea();
		
		botonIniciar = new JButton("Iniciar");
		
		scrollPane = new JScrollPane();
		
	     labelResultado = new JLabel("B\u00DASQUEDA");
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		DefaultTableModel modelo=new DefaultTableModel();
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBN", "TITULO", "AUTOR"
			}
		));

	Controlador controlador=new Controlador();
		//int contador = controlador.getTituloLibros().size();

	int  contador=controlador.getLibrosAlmacen().size();
	
		int conta=0;
		int numeroColumnas = table.getModel().getColumnCount();
		Object[] fila = new Object[numeroColumnas];
		try {
		if(conta>=0) {
		do {

			fila[0] = controlador.getISBNLibros().get(conta);
			fila[1] = controlador.getTituloLibros().get(conta);
			fila[2] = controlador.getAutorLibros().get(conta);
			contador--;
			conta++;
			((DefaultTableModel) table.getModel()).addRow(fila);
		
		} while (contador > 0);
		}
		}catch(IndexOutOfBoundsException r) {
			
		}

		/*
		 * 
		 *  int numeroColumnas= table.getModel().getColumnCount();
		 *  
		 *  Object [] fila=new Object[numeroColumnas];
		 *  fila[0]="marcos";
		 *  fila[1]=
		 *  fila[2]=
		 *  ((DefaultTableModel) table.getModel()).adRow(fila);
		 */
		
		scrollPane.setViewportView(table);
		
		JLabel labelFormato = new JLabel("   Formato");
		
		radioButtonCartone = new JRadioButton("Carton\u00E9");
		radioButtonCartone.setBackground(Color.CYAN);
		buttonGroupFormato.add(radioButtonCartone);
		
	   radioButtonRustica = new JRadioButton("R\u00FAstica");
		radioButtonRustica.setBackground(Color.CYAN);
		buttonGroupFormato.add(radioButtonRustica);
		
		radioButtonTapaDura = new JRadioButton("Tapa Dura");
		radioButtonTapaDura.setBackground(Color.CYAN);
		buttonGroupFormato.add(radioButtonTapaDura);
		
		JLabel labelEdicion = new JLabel("   Edicion");
		
		radioButtonNovedad = new JRadioButton("Novedad");
		radioButtonNovedad.setBackground(Color.CYAN);
		buttonGroupEdicion.add(radioButtonNovedad);
		
	   radioButtonReedicion = new JRadioButton("Reedici\u00F3n");
		radioButtonReedicion.setBackground(Color.CYAN);
		buttonGroupEdicion.add(radioButtonReedicion);
		panelAgregarOpcionesLibro.setLayout(new GridLayout(7, 0, 0, 0));
		panelAgregarOpcionesLibro.add(labelFormato);
		panelAgregarOpcionesLibro.add(radioButtonCartone);
		panelAgregarOpcionesLibro.add(radioButtonRustica);
		panelAgregarOpcionesLibro.add(radioButtonTapaDura);
		panelAgregarOpcionesLibro.add(labelEdicion);
		panelAgregarOpcionesLibro.add(radioButtonNovedad);
		panelAgregarOpcionesLibro.add(radioButtonReedicion);
		panelAgregarDatosLibro.setLayout(new GridLayout(0, 2, 0, 0));
		
	    labelISBN = new JLabel("ISBN  ");
		labelISBN.setBackground(new Color(0, 128, 128));
		labelISBN.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAgregarDatosLibro.add(labelISBN);
		
		textFieldISBN = new JTextField();
		panelAgregarDatosLibro.add(textFieldISBN);
		textFieldISBN.setColumns(10);
		
	    labelTitulo = new JLabel("T\u00EDtulo  ");
		labelTitulo.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAgregarDatosLibro.add(labelTitulo);
		
		textFieldTitulo = new JTextField();
		panelAgregarDatosLibro.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
	    labelAutor = new JLabel("Autor  ");
		labelAutor.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAgregarDatosLibro.add(labelAutor);
		
		textFieldAutor = new JTextField();
		panelAgregarDatosLibro.add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
	    labelTotalPagina = new JLabel("N\u00FAmero P\u00E1ginas  ");
		labelTotalPagina.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAgregarDatosLibro.add(labelTotalPagina);
		
		textFieldTotalPagina = new JTextField();
		panelAgregarDatosLibro.add(textFieldTotalPagina);
		textFieldTotalPagina.setColumns(10);
		
		 labelPrecio = new JLabel("Precio  ");
		labelPrecio.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAgregarDatosLibro.add(labelPrecio);
		
		textFieldPrecio = new JTextField();
		panelAgregarDatosLibro.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
	    labelContador = new JLabel("Unidades  ");
		labelContador.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAgregarDatosLibro.add(labelContador);
		
		textFieldCantidad = new JTextField();
		panelAgregarDatosLibro.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel labelTema = new JLabel("Tema  ");
		labelTema.setHorizontalAlignment(SwingConstants.TRAILING);
		panelAgregarDatosLibro.add(labelTema);
		
	    comboBoxTema = new JComboBox();
		panelAgregarDatosLibro.add(comboBoxTema);
		
		textFieldAlmacen = new JTextField();
		textFieldAlmacen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAlmacen.setColumns(10);
		
		botonCambiar = new JButton("GUARDAR CAMBIOS");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(labelCabeceraAgregarLibro, GroupLayout.PREFERRED_SIZE, 935, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(botonIniciar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(textAreaResultado, GroupLayout.PREFERRED_SIZE, 821, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(82)
									.addComponent(panelAgregarDatosLibro, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(226)
									.addComponent(labelResultado, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(76)
									.addComponent(botonCambiar)
									.addGap(288)
									.addComponent(textFieldAlmacen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panelAgregarOpcionesLibro, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
									.addGap(50)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(labelCabeceraAgregarLibro)
					.addGap(6)
					.addComponent(botonIniciar)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelAgregarDatosLibro, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelAgregarOpcionesLibro, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelResultado)
								.addComponent(textFieldAlmacen, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(6))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(botonCambiar)
							.addGap(27)))
					.addComponent(textAreaResultado, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		
		JLabel lblBuscar = new JLabel("                             BUSQUEDA                      ");
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setVerticalAlignment(SwingConstants.TOP);
		lblBuscar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 28));
		

	}
	public JButton getBotonCambiar(){
		return  botonCambiar;
	}
	public JButton getBotonOpciones() {
		return botonOpciones;
	}

	public JButton getBotonIniciar() {
		return botonIniciar;
	}
	public JRadioButton getRadioButtonCartone() {
		return radioButtonCartone;
	}
	public JRadioButton getRadioButtonRustica() {
		return radioButtonRustica;
	}
	public JRadioButton getRadioButtonTapaDura() {
		return radioButtonTapaDura;
	}
	public JRadioButton getRadioButtonNovedad() {
		return radioButtonNovedad;
	}
	public JRadioButton getRadioButtonReedicion() {
		return radioButtonReedicion;
	}
	
	public JComboBox getComboBoxTema() {
		return comboBoxTema;
	}
	private ArrayList<JRadioButton> listaRadioButton=new ArrayList<JRadioButton>();
	public ArrayList<JRadioButton> dameListaRadioButtonPrincipal(){
		listaRadioButton.add(radioButtonCartone);
		listaRadioButton.add(radioButtonTapaDura);
		listaRadioButton.add(radioButtonRustica);
		listaRadioButton.add(radioButtonReedicion);
		listaRadioButton.add(radioButtonNovedad);
		return this.listaRadioButton;
	}
	private JLabel labelISBN; 
	private JLabel labelAutor;
	private JLabel labelTitulo;
	private JLabel labelTotalPagina;
	private JLabel labelPrecio ;
	private JLabel labelContador;
	private JLabel labelResultado;
	public JLabel getLabelResultado() {
		return this.labelResultado;
	}
	public JLabel getLabelISBN() {
		return labelISBN;
	}
	public ArrayList<JRadioButton> getListaRadioButton() {
		return listaRadioButton;
	}
	public JLabel getLabelAutor() {
		return labelAutor;
	}
	public JLabel getLabelTitulo() {
		return labelTitulo;
	}
	public JLabel getLabelTotalPagina() {
		return labelTotalPagina;
	}
	public JLabel getLabelPrecio() {
		return labelPrecio;
	}
	public JLabel getLabelContador() {
		return labelContador;
	}
	
	private ArrayList <JLabel>listaEtiqueta=new ArrayList<JLabel>();
	private JButton botonIniciar;
	private JScrollPane scrollPane;
	private JTable table;

	public JTable getTable() {
		return table;
	}
	public ArrayList <JLabel> getListaEtiqueta(){
		listaEtiqueta.add(labelISBN);
		listaEtiqueta.add(labelTitulo);
		listaEtiqueta.add(labelAutor);
		listaEtiqueta.add(labelTotalPagina);
		listaEtiqueta.add(labelContador);
		listaEtiqueta.add(labelPrecio);
		return listaEtiqueta;
	}
	public void volverNombreOriginalEtiqueta() {
		labelISBN.setText("ISBN");
		labelTitulo.setText("Título");
		labelAutor.setText("Autor");
		labelTotalPagina.setText("Número Página");
		labelContador.setText("Unidades");
		labelPrecio.setText("Precio");
		
		
	}
	
	
	
	public void borrarCampos() {
		for (JTextField e : listaCuadroTexto) {
			e.setText("");
		}
		buttonGroupEdicion.clearSelection();
		buttonGroupFormato.clearSelection();
		

	}
}
