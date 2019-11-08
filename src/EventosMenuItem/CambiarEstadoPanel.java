package EventosMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ParaUI;
import vista.EstadoPanelPlantilla;

public class CambiarEstadoPanel implements ActionListener{
	private ParaUI iu;
	
	public CambiarEstadoPanel(ParaUI iu) {
		this.iu=iu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		EstadoPanelPlantilla estado=new EstadoPanelPlantilla(iu);
		estado.activar(true, true);
		iu.getPanelPlantilla().getBotonCambiar().setVisible(false);
		
	}
	}

	
	

