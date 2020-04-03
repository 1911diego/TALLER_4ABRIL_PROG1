package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAgregar extends JPanel {
	
	private ImageIcon imagenes;
	private JLabel titulo;
	private JComboBox<String> tipodecontacto;
	private JLabel lnombre, lpais, lcorreo, ltelefono, lempresa;
	private JTextField txtnombre;
	private JComboBox<String> pais;
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
		fondo.setBounds(0,0,750,450);
		imagenes = new ImageIcon("Resources/fondoagregar.jpg");
		fondo.setIcon(imagenes);
		fondo.setLayout(null);
		
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
		lnombre.setForeground(Color.WHITE);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(160,90,140,30);
		txtnombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		lpais = new JLabel("PAIS");
		lpais.setBounds(50,130,120,50);
		lpais.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		lpais.setForeground(Color.WHITE);
		
		pais = new JComboBox<String>();
		pais.setBounds(160,140,140,30);
		pais.addItem("COLOMBIA");
		pais.addItem("PERU");
		pais.addItem("CHILE");
		pais.addItem("ESPAÑA");
		pais.addItem("ARGENTINA");
		pais.addItem("MEXICO");
		
		pais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		ltelefono = new JLabel("TELÉFONO");
		ltelefono.setBounds(50,180,120,50);
		ltelefono.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		ltelefono.setForeground(Color.WHITE);
		
		txttelefono = new JTextField();
		txttelefono.setBounds(160,190,140,30);
		txttelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		lcorreo = new JLabel("E-MAIL");
		lcorreo.setBounds(50,230,120,50);
		lcorreo.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		lcorreo.setForeground(Color.WHITE);
		
		txtcorreo = new JTextField();
		txtcorreo.setBounds(160,240,140,30);
		txtcorreo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		lempresa = new JLabel("EMPRESA");
		lempresa.setBounds(50,280,120,50);
		lempresa.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		lempresa.setForeground(Color.WHITE);
		
		txtempresa = new JTextField();
		txtempresa.setBounds(160,290,140,30);
		txtempresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botoncrear = new JButton();
		botoncrear.setBounds(380,100,200,70);
		imagenes = new ImageIcon("Resources/botonagregar.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
		botoncrear.setIcon(imagenes);
		botoncrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botoneditar = new JButton();
		botoneditar.setBounds(380,100,200,70);
		imagenes = new ImageIcon("Resources/botoneditar.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
		botoneditar.setIcon(imagenes);
		botoneditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		botoneliminar = new JButton();
		botoneliminar.setBounds(380,200,200,70);
		imagenes = new ImageIcon("Resources/botoneliminar.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT));
		botoneliminar.setIcon(imagenes);
		botoneliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		volver = new JButton();
		volver.setBounds(470,320,110,40);
		imagenes = new ImageIcon("Resources/botonvolver.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(110,40, Image.SCALE_DEFAULT));
		volver.setIcon(imagenes);
		volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		add(fondo);
		fondo.add(titulo);
		fondo.add(lnombre);
		fondo.add(lpais);
		fondo.add(ltelefono);
		fondo.add(lcorreo);
		fondo.add(lempresa);
		fondo.add(txtnombre);
		fondo.add(pais);
		fondo.add(txttelefono);
		fondo.add(txtcorreo);
		fondo.add(txtempresa);
		fondo.add(botoncrear);
		fondo.add(botoneliminar);
		fondo.add(botoneditar);
		fondo.add(tipodecontacto);
		fondo.add(volver);
	}
	
	public void reestablecer()
	{
		txtnombre.setText("");
		txttelefono.setText("");
		txtcorreo.setText("");
		txtempresa.setText("");
		tipodecontacto.setSelectedItem("SELECCIONE TIPO");
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


	public JComboBox<String> getPais() {
		return pais;
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
