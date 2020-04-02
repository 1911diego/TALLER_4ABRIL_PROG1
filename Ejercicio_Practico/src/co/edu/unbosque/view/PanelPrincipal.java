package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
	
	
	private JLabel principal;
	private JButton botonagregar;
	private JButton botonver;
	private JButton botonmodificar;
	private JButton cargararchivo;
	
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
		fondo.setBounds(20,20,640,370);
		fondo.setBackground(Color.BLACK);
		fondo.setLayout(null);
		fondo.setOpaque(true);
		fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.DARK_GRAY, Color.WHITE));
		
		principal = new JLabel("AGENDA");
		principal.setBounds(190,17,500,100);
		principal.setFont(new Font("helvetica",Font.HANGING_BASELINE,60));
		principal.setForeground(Color.WHITE);
		
		cargararchivo = new JButton("CARGAR AGENDA FÍSICA");
		cargararchivo.setBounds(225,120,200,30);
		cargararchivo.setBackground(Color.BLUE);
		cargararchivo.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		cargararchivo.setForeground(Color.WHITE);
		cargararchivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botonagregar = new JButton("CONTACTOS");
		botonagregar.setBounds(100,180,200,70);
		botonagregar.setBackground(Color.WHITE);
		botonagregar.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		botonagregar.setForeground(Color.BLUE);
		botonagregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botonmodificar = new JButton("EDITAR CONTACTO");
		botonmodificar.setBounds(360,180,200,70);
		botonmodificar.setBackground(Color.WHITE);
		botonmodificar.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		botonmodificar.setForeground(Color.RED);
		botonmodificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botonver = new JButton("VER CONTACTOS");
		botonver.setBounds(230,280,200,70);
		botonver.setBackground(Color.WHITE);
		botonver.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		botonver.setForeground(Color.BLUE);
		botonver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		add(fondo);
		fondo.add(botonagregar);
		fondo.add(botonver);
		fondo.add(botonmodificar);
		fondo.add(cargararchivo);
		fondo.add(principal);
		
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
	
}
