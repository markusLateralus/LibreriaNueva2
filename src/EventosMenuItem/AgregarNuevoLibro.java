package EventosMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import controlador.ControladorError;
import controlador.ParaUI;
import modelo.Edicion;
import modelo.Formato;

import modelo.Tema;

import utiles.validadoresJTextField.Validador;
;


public class AgregarNuevoLibro implements ActionListener {
	private Controlador controlador;
	private ParaUI ui;
	public AgregarNuevoLibro(Controlador controlador, ParaUI ui) {
		this.controlador = controlador;
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
try {
		ui.getPanelPlantilla().getTable().setVisible(true);
		ui.getPanelPlantilla().getBotonCambiar().setVisible(false);
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
				|| validate.validaTamananoISBN(ui.getPanelPlantilla().getTextFieldISBN().getText())==false){
	
			controladorError.controlErrorAutor(ui.getPanelPlantilla().getTextFieldAutor().getText());
			controladorError.controlErrorTitulo(ui.getPanelPlantilla().getTextFieldTitulo().getText());
			controladorError.controlErrorPrecio(ui.getPanelPlantilla().getTextFieldPrecio().getText());
			controladorError.controlErrorISBN(ui.getPanelPlantilla().getTextFieldISBN().getText());
		}
		
	
		
	if(validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldAutor().getText()) 
			&& validate.validaSoloLetras(ui.getPanelPlantilla().getTextFieldTitulo().getText())
			&&  validate.validaSoloNumeros(ui.getPanelPlantilla().getTextFieldPrecio().getText())
			&& validate.validaTamananoISBN(ui.getPanelPlantilla().getTextFieldISBN().getText())){
			
	
				
			controladorError.controlErrorAutor(ui.getPanelPlantilla().getTextFieldAutor().getText());
			controladorError.controlErrorTitulo(ui.getPanelPlantilla().getTextFieldTitulo().getText());
			controladorError.controlErrorPrecio(ui.getPanelPlantilla().getTextFieldPrecio().getText());
			controladorError.controlErrorISBN(ui.getPanelPlantilla().getTextFieldISBN().getText());
			
			if(controlador.getLista().size()>=0 ||controlador.getLista()==null) {
				boolean salir=true;
			
	
	    
			controlador.altaLibro(ui.getPanelPlantilla().getTextFieldTitulo().getText(),
					(ui.getPanelPlantilla().getTextFieldISBN().getText()),
					Integer.parseInt(ui.getPanelPlantilla().getTextFieldTotalPagina().getText()), precio,
					ui.getPanelPlantilla().getTextFieldAutor().getText(), tema, edicion, formato,
					Integer.parseInt(ui.getPanelPlantilla().getTextFieldCantidad().getText()));
			
			this.iniciarAplicacion(false, true);
			ui.getPanelPlantilla().getLabelResultado().setText("NUEVO INGRESO");			
		 ui.getPanelPlantilla().getTextAreaResultado().setText(ui.getPanelPlantilla().getTextFieldTitulo().getText() + ", " + ui.getPanelPlantilla().getTextFieldAutor().getText());	
			
		 
		  int numeroColumnas= ui.getPanelPlantilla().getTable().getModel().getColumnCount();
		 if(controlador.comparaISBN(ui.getPanelPlantilla().getTextFieldISBN().getText())==false) {
			 
		
		   Object [] fila=new Object[numeroColumnas];
		   fila[0]=controlador.getLista().get(1).getISBN();
		   fila[1]=ui.getPanelPlantilla().getTextFieldTitulo().getText();
		   fila[2]=ui.getPanelPlantilla().getTextFieldAutor().getText();
		   ((DefaultTableModel) ui.getPanelPlantilla().getTable().getModel()).addRow(fila);
		   
		   ui.getPanelPlantilla().borrarCampos();
	}
			}
	    }
	
		 
			
				
			
	
	
	}catch(NumberFormatException o) {
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
