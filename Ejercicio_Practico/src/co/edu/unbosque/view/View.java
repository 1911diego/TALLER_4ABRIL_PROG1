package co.edu.unbosque.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JFrame{
	
	
	private PanelPrincipal pPrincipal;
	private PanelAgregar pAgregar;
	private PanelVerContactos pVer;
	
	public View() {
		
		
		pPrincipal = new PanelPrincipal();
		pPrincipal.setVisible(true);
		
		pAgregar = new PanelAgregar();
		pAgregar.setVisible(false);
		
		pVer = new PanelVerContactos();
		pVer.setVisible(false);
		
		getContentPane().add(pPrincipal);
		getContentPane().add(pAgregar);
		getContentPane().add(pVer);
		
	}
	
	public String mensajes (String mensaje)
	{
		if(mensaje.equalsIgnoreCase("AMIGO_AGREGADO"))
		{
			JOptionPane.showMessageDialog(null, "SE HA AGREGADO UN NUEVO AMIGO EN LA AGENDA EXITOSAMENTE");
		}
		if(mensaje.equalsIgnoreCase("NO_AGREGADO"))
		{
			JOptionPane.showMessageDialog(null,"!ESTE NÚMERO DE TELÉFONO YA EXISTE EN LA AGENDA!");
		}
		if(mensaje.equalsIgnoreCase("CONTACTO_AGREGADO"))
		{
			JOptionPane.showMessageDialog(null, "SE HA AGREGADO UN NUEVO CONTACTO EN LA AGENDA EXITOSAMENTE");
		}
		if(mensaje.equalsIgnoreCase("VALIDAR_MODIFICACION"))
		{
			String validacion = JOptionPane.showInputDialog("INGRESE EL NÚMERO DE TELÉFONO DEL AMIGO/CONTACTO QUE DESEA MODIFICAR");
			return validacion;
		}
		
		if(mensaje.equalsIgnoreCase("NO_ENCONTRADO"))
		{
			JOptionPane.showMessageDialog(null,"EL NÚMERO DE TELÉFONO INGRESADO NO EXISTE EN LA AGENDA");
		}
		
		if(mensaje.equalsIgnoreCase("ELIMINAR"))
		{
			String validacion = JOptionPane.showInputDialog("INGRESE EL NÚMERO DE TELÉFONO DEL AMIGO/CONTACTO QUE DESEA ELIMINAR");
			return validacion;	
		}
		
		if(mensaje.equalsIgnoreCase("ELIMINADO"))
		{
			JOptionPane.showMessageDialog(null, "EL AMIGO/CONTACTO A SIDO ELIMINADO DE LA AGENDA");
		}
		if(mensaje.equalsIgnoreCase("NO_ELIMINADO"))
		{
			JOptionPane.showMessageDialog(null, "!EL NÚMERO DE TELÉFONO INGRESADO NO EXISTE EN LA AGENDA!");
		}
		return null;
		
	}
	public PanelPrincipal getpPrincipal() {
		return pPrincipal;
	}

	public PanelAgregar getpAgregar() {
		return pAgregar;
	}

	public PanelVerContactos getpVer() {
		return pVer;
	}
	

	
}
