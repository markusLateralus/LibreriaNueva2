package EventosMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import controlador.ControladorError;
import controlador.ParaUI;
import modelo.Edicion;
import modelo.Formato;
import modelo.Libro;
import modelo.Tema;
import utiles.validadoresJTextField.Validador;

public class GuardarCambios implements ActionListener {
	 private ParaUI ui;
	 private Controlador controlador;
	public GuardarCambios(Controlador controlador,ParaUI ui){
		this.ui=ui;
		this.controlador=controlador;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {	

		String ISBN=ui.getPanelPlantilla().getTextFieldISBN().getText();
				
		
			Validador validate = new Validador();
			ControladorError controladorError=new ControladorError();
			String preci = ui.getPanelPlantilla().getTextFieldPrecio().getText();
			double precio = Double.parseDouble(preci);
			Tema tema = this.dameTema();
			Formato formato = dameFormato();
			Edicion edicion = dameEdicion();
		
			if(validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldAutor().getText())==false 
					|| validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldTitulo().getText())==false
					|| validate.validaSoloNumeros(ui.getPanelPlantilla().getTextFieldPrecio().getText())==false
					|| validate.validaTamananoISBN(ISBN)==false){
				
				controladorError.controlErrorAutor(ui.getPanelPlantilla().getTextFieldAutor().getText());
				controladorError.controlErrorTitulo(ui.getPanelPlantilla().getTextFieldTitulo().getText());
				controladorError.controlErrorPrecio(ui.getPanelPlantilla().getTextFieldPrecio().getText());
				controladorError.controlErrorISBN(ISBN);
			}
		if(validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldAutor().getText()) 
				&& validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldTitulo().getText())
				&&  validate.validaSoloNumeros(ui.getPanelPlantilla().getTextFieldPrecio().getText())
				&& validate.validaTamananoISBN(ISBN)){
				
				controladorError.controlErrorAutor(ui.getPanelPlantilla().getTextFieldAutor().getText());
				controladorError.controlErrorTitulo(ui.getPanelPlantilla().getTextFieldTitulo().getText());
				controladorError.controlErrorPrecio(ui.getPanelPlantilla().getTextFieldPrecio().getText());
				controladorError.controlErrorISBN(ISBN);
				controlador.modificarLibro(ui.getPanelPlantilla().getTextFieldTitulo().getText(),
						(ISBN),
						Integer.parseInt(ui.getPanelPlantilla().getTextFieldTotalPagina().getText()), precio,
						ui.getPanelPlantilla().getTextFieldAutor().getText(), tema, edicion, formato,
						Integer.parseInt(ui.getPanelPlantilla().getTextFieldCantidad().getText()));
				
				this.iniciarAplicacion(false, true);
				ui.getPanelPlantilla().getLabelResultado().setText(" LIBRO MODIFICADO");			
			 ui.getPanelPlantilla().getTextAreaResultado().setText(ui.getPanelPlantilla().getTextFieldTitulo().getText() + ", " + ui.getPanelPlantilla().getTextFieldAutor().getText());	
				
			 
			  int numeroColumnas= ui.getPanelPlantilla().getTable().getModel().getColumnCount();
			 
			   Object [] fila=new Object[numeroColumnas];
			   fila[0]=ui.getPanelPlantilla().getTextFieldISBN().getText();
			   fila[1]=ui.getPanelPlantilla().getTextFieldTitulo().getText();
			   fila[2]=ui.getPanelPlantilla().getTextFieldAutor().getText();
			   ((DefaultTableModel) ui.getPanelPlantilla().getTable().getModel()).addRow(fila);
			   
			   ui.getPanelPlantilla().borrarCampos();
		}
		
		 int indice=0;
		 for (int s = 0; s < controlador.getLibrosAlmacen().size(); s++) {
		for (int j = 0; j < controlador.getLista().size(); j++) {	
			if(controlador.getLista().get(j).getISBN().equalsIgnoreCase(ISBN)) {
				indice=controlador.getLibrosAlmacen().indexOf(controlador.getLista().get(j));
			}
		}
		 }
		

			for (int i = 0; i < controlador.getLibrosAlmacen().size(); i++) {			
				 if(controlador.getLibrosAlmacen().indexOf(controlador.getLibrosAlmacen().get(i))==indice) {
					 DefaultTableModel tb = (DefaultTableModel) ui.getPanelPlantilla().getTable().getModel();
					
					 tb.removeRow(indice);
					// controlador.borrarLibroISBN(seleccion);
					//controlador.borrarLibro(indice);
				 
			 }
				 
			}
				
			
	
			}catch(NumberFormatException s) {
	
	
	}
	}
	

	ArrayList<JTextField> listaCuadro = new ArrayList<JTextField>();
	ArrayList<JRadioButton> listaRadioButton = new ArrayList<JRadioButton>();

	private void iniciarAplicacion(boolean estado, boolean estadoISBN) {
		listaCuadro = ui.getPanelPlantilla().listaTextField();
		for (JTextField e : listaCuadro) {
			e.setEnabled(estado);
		}
		listaRadioButton = ui.getPanelPlantilla().dameListaRadioButtonPrincipal();
		for (JRadioButton e : listaRadioButton) {
			e.setEnabled(estado);
		}
		ui.getPanelPlantilla().getComboBoxTema().setEnabled(estado);
	}

	
	private JComboBox comboBoxTema = new JComboBox();

	private Tema dameTema() {
		comboBoxTema = ui.getPanelPlantilla().getComboBoxTema();
		if (comboBoxTema.getSelectedItem() == Tema.Accion) {
			return Tema.Accion;
		}
		if (comboBoxTema.getSelectedItem() == Tema.Aventura) {
			return Tema.Aventura;
		}
		if (comboBoxTema.getSelectedItem() == Tema.Biologia) {
			return Tema.Biologia;
		}
		if (comboBoxTema.getSelectedItem() == Tema.Ciencia) {
			return Tema.Ciencia;
		}
		if (comboBoxTema.getSelectedItem() == Tema.Drama) {
			return Tema.Drama;
		}
		if (comboBoxTema.getSelectedItem() == Tema.Misterio) {
			return Tema.Misterio;
		}
		if (comboBoxTema.getSelectedItem() == Tema.Terror) {
			return Tema.Terror;
		}

		return null;
	}

	private Formato dameFormato() {

		if (ui.getPanelPlantilla().getRadioButtonCartone().isSelected()) {

			return Formato.Cartone;
		}
		if (ui.getPanelPlantilla().getRadioButtonTapaDura().isSelected()) {

			return Formato.TapaDura;
		}
		if (ui.getPanelPlantilla().getRadioButtonRustica().isSelected()) {

			return Formato.Rustica;
		}
		return null;
	}

	private Edicion dameEdicion() {

		if (ui.getPanelPlantilla().getRadioButtonNovedad().isSelected()) {
			return Edicion.Novedad;
		}
		if (ui.getPanelPlantilla().getRadioButtonReedicion().isSelected()) {
			return Edicion.Reedicion;
		}
		return null;
	}
	
	
	}


