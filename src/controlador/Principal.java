package controlador;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ParaUI frame = new ParaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

}
