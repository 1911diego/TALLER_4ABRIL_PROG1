package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregar extends JPanel {
	
	private JLabel titulo;
	private JComboBox<String> tipodecontacto;
	private JLabel lnombre, lpais, lcorreo, ltelefono, lempresa;
	private JTextField txtnombre;
	private JTextField txtpais;
	private JTextField txtcorreo;
	private JTextField txttelefono;
	private JTextField txtempresa;
	
	private JButton botoncrear;
	private JButton botoneditar;
	private JButton botoneliminar;
	private JButton volver;
	
	private String validar;
	
	
	public PanelAgregar ()
	{
		this.setSize(700,450);
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);
		
		panelDeControl();
		
	}
	
	
	public void panelDeControl()
	{
		JLabel fondo = new JLabel();
		fondo.setBounds(20,20,640,370);
		fondo.setBackground(Color.BLACK);
		fondo.setLayout(null);
		fondo.setOpaque(true);
		fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.DARK_GRAY, Color.WHITE));
		
		titulo = new JLabel("CONTACTOS");
		titulo.setBounds(20,15,200,80);
		titulo.setFont(new Font("helvetica",Font.BOLD,25));
		titulo.setForeground(Color.WHITE);
		
		
		tipodecontacto = new JComboBox<String>();
		tipodecontacto.setBounds(200,45,150,20);
		tipodecontacto.addItem("SELECCIONE TIPO");
		tipodecontacto.addItem("AMIGO");
		tipodecontacto.addItem("CONTACTO");
		tipodecontacto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		lnombre = new JLabel("NOMBRE");
		lnombre.setBounds(50,80,120,50);
		lnombre.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		lnombre.setForeground(Color.LIGHT_GRAY);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(160,90,140,30);
		txtnombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		lpais = new JLabel("PAIS");
		lpais.setBounds(50,130,120,50);
		lpais.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		lpais.setForeground(Color.LIGHT_GRAY);
		
		txtpais = new JTextField();
		txtpais.setBounds(160,140,140,30);
		txtpais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		ltelefono = new JLabel("TELÉFONO");
		ltelefono.setBounds(50,180,120,50);
		ltelefono.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		ltelefono.setForeground(Color.LIGHT_GRAY);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(160,190,140,30);
		txttelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		lcorreo = new JLabel("E-MAIL");
		lcorreo.setBounds(50,230,120,50);
		lcorreo.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		lcorreo.setForeground(Color.LIGHT_GRAY);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(160,240,140,30);
		txtcorreo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		lempresa = new JLabel("EMPRESA");
		lempresa.setBounds(50,280,120,50);
		lempresa.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		lempresa.setForeground(Color.LIGHT_GRAY);
		
		txtempresa = new JTextField();
		txtempresa.setBounds(160,290,140,30);
		txtempresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botoncrear = new JButton("CREAR CONTACTO");
		botoncrear.setBounds(380,100,220,80);
		botoncrear.setBackground(Color.BLUE);
		botoncrear.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		botoncrear.setForeground(Color.WHITE);
		botoncrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botoneditar = new JButton("EDITAR CONTACTO");
		botoneditar.setBounds(380,100,220,80);
		botoneditar.setBackground(Color.BLUE);
		botoneditar.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		botoneditar.setForeground(Color.WHITE);
		botoneditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botoneliminar = new JButton("ELIMINAR CONTACTO");
		botoneliminar.setBounds(380,200,220,80);
		botoneliminar.setBackground(Color.RED);
		botoneliminar.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		botoneliminar.setForeground(Color.WHITE);
		botoneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		volver = new JButton("VOLVER");
		volver.setBounds(490,320,110,40);
		volver.setBackground(Color.WHITE);
		volver.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		volver.setForeground(Color.BLUE);
		volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		add(fondo);
		fondo.add(titulo);
		fondo.add(lnombre);
		fondo.add(lpais);
		fondo.add(ltelefono);
		fondo.add(lcorreo);
		fondo.add(lempresa);
		fondo.add(txtnombre);
		fondo.add(txtpais);
		fondo.add(txttelefono);
		fondo.add(txtcorreo);
		fondo.add(txtempresa);
		fondo.add(botoncrear);
		fondo.add(botoneliminar);
		fondo.add(botoneditar);
		fondo.add(tipodecontacto);
		fondo.add(volver);
	}


	public JComboBox<String> getTipodecontacto() {
		return tipodecontacto;
	}


	public JLabel getLempresa() {
		return lempresa;
	}


	public JTextField getTxtnombre() {
		return txtnombre;
	}


	public JTextField getTxtpais() {
		return txtpais;
	}


	public JTextField getTxtcorreo() {
		return txtcorreo;
	}


	public JTextField getTxttelefono() {
		return txttelefono;
	}


	public JTextField getTxtempresa() {
		return txtempresa;
	}


	public JButton getBotoncrear() {
		return botoncrear;
	}


	public JButton getBotoneditar() {
		return botoneditar;
	}


	public JButton getBotoneliminar() {
		return botoneliminar;
	}


	public JButton getVolver() {
		return volver;
	}


	public String getValidar() {
		return validar;
	}


	public void setValidar(String validar) {
		this.validar = validar;
	}
	
	
}
