package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Tema;

public class UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelContenedor;
	public JPanel getPanelContenedor() {
		return this.panelContenedor;
	}
	
	private PanelPlantilla panelPlantilla;
	 private BarraMenu menuBar = new BarraMenu();
	 public BarraMenu getMenuBarr() {
		 return menuBar;
	 }
	 public void setMenuBar(BarraMenu menuBar) {
		this.menuBar = menuBar;
	}
	

	public UI() {
		panelPlantilla=new PanelPlantilla();
		panelPlantilla.getComboBoxTema().setModel(new DefaultComboBoxModel(Tema.values()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 454);
		panelContenedor = new JPanel();
		panelContenedor.setBackground(Color.WHITE);
		panelContenedor.setForeground(Color.MAGENTA);
		panelContenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelContenedor);
		panelContenedor.setLayout(new BorderLayout(0, 0));
		panelContenedor.add(panelPlantilla);		
		panelContenedor.add(menuBar, BorderLayout.NORTH);	

	}
	public PanelPlantilla getPanelPlantilla() {
		// TODO Auto-generated method stub
		return this.panelPlantilla;
	}
	
}
