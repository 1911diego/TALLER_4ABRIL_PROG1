package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
	
	private ImageIcon imagenes;
	private JLabel principal;
	private JButton botonagregar;
	private JButton botonver;
	private JButton botonmodificar;
	private JButton cargararchivo;
	private JButton botoneliminar;
	
	public PanelPrincipal()
	{
		this.setSize(700,450);
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);
		panelDeControl();
	}
	
public void panelDeControl() {
	
		JLabel fondo = new JLabel();
		fondo.setBounds(0,0,700,450);
		imagenes = new ImageIcon("Resources/fondoprincipal.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(700, 450, Image.SCALE_DEFAULT));
		fondo.setIcon(imagenes);
		fondo.setLayout(null);
		
		cargararchivo = new JButton();
		cargararchivo.setBounds(240,30,200,40);
		imagenes = new ImageIcon("Resources/botonagenda.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 40, Image.SCALE_DEFAULT));
		cargararchivo.setIcon(imagenes);
		cargararchivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botonagregar = new JButton();
		botonagregar.setBounds(240,90,200,70);
		imagenes = new ImageIcon("Resources/botonagregar.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
		botonagregar.setIcon(imagenes);
		botonagregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botonmodificar = new JButton();
		botonmodificar.setBounds(240,170,200,70);
		imagenes = new ImageIcon("Resources/botoneditar.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
		botonmodificar.setIcon(imagenes);
		botonmodificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botoneliminar = new JButton();
		botoneliminar.setBounds(240,250,200,70);
		imagenes = new ImageIcon("Resources/botoneliminar.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
		botoneliminar.setIcon(imagenes);
		botoneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botonver = new JButton();
		botonver.setBounds(240,330,200,70);
		imagenes = new ImageIcon("Resources/botonverlista.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
		botonver.setIcon(imagenes);
		botonver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		add(fondo);
		fondo.add(botonagregar);
		fondo.add(botonver);
		fondo.add(botonmodificar);
		fondo.add(cargararchivo);
		fondo.add(botoneliminar);
		
		
	}

public JButton getBotonagregar() {
	return botonagregar;
}

public JButton getBotonver() {
	return botonver;
}

public JButton getBotonmodificar() {
	return botonmodificar;
}

public JButton getCargararchivo() {
	return cargararchivo;
}

public JButton getBotoneliminar() {
	return botoneliminar;
}


	
}
