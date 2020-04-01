package co.edu.unbosque.view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
	
	private JPanel fondo;
	private JButton añadirContactos;
	private JButton modificarContactos;
	private JButton eliminarContactos;
	private JButton verContactos;
	private JLabel texto1;
	private JLabel texto2;
	
	public View() {
		
		this.setSize(550, 400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Contactos rosita");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializar();
		
	}
	
	public void inicializar() {
		
		fondo = new JPanel();
		fondo.setVisible(true);
		fondo.setSize(600, 400);
		fondo.setLayout(null);
		
		texto1 = new JLabel();
		texto1.setText("Contactos");
		texto1.setBounds(200, 50, 150, 60);
		texto1.setFont(new Font("arial", Font.BOLD, 24));
		
		texto2 = new JLabel();
		texto2.setText("Rosita");
		texto2.setBounds(220, 80, 150, 60);
		texto2.setFont(new Font("arial", Font.BOLD, 24));
		
		añadirContactos = new JButton();
		añadirContactos.setText("Añadir contactos");
		añadirContactos.setBounds(60, 200, 180, 30);
		añadirContactos.setFont(new Font("arial", Font.BOLD, 14));
		
		modificarContactos = new JButton();
		modificarContactos.setText("Modificar contactos");
		modificarContactos.setBounds(60, 280, 180, 30);
		modificarContactos.setFont(new Font("arial", Font.BOLD, 14));
		
		eliminarContactos = new JButton();
		eliminarContactos.setText("Eliminar contactos");
		eliminarContactos.setBounds(280, 200, 180, 30);
		eliminarContactos.setFont(new Font("arial", Font.BOLD, 14));
		
		verContactos = new JButton();
		verContactos.setText("Ver contactos");
		verContactos.setBounds(280, 280, 180, 30);
		verContactos.setFont(new Font("arial", Font.BOLD, 14));
		
		add(fondo);
		fondo.add(texto1);
		fondo.add(texto2);
		fondo.add(añadirContactos);
		fondo.add(modificarContactos);
		fondo.add(eliminarContactos);
		fondo.add(verContactos);
		
	}
	
	public JLabel getTexto1() {
		return texto1;
	}

	public JPanel getFondo() {
		return fondo;
	}

	public JButton getAñadirContactos() {
		return añadirContactos;
	}

	public JButton getVerContactos() {
		return verContactos;
	}
	
	public JButton getModificarContactos() {
		return modificarContactos;
	}

	public JButton getEliminarContactos() {
		return eliminarContactos;
	}

	public JLabel getTexto2() {
		return texto2;
	}

}
