package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelVerContactos extends JPanel{

	private ImageIcon imagenes;
	private JLabel titulo;
	private JLabel amigos;
	private JLabel contactos;
	private JTable infoamigos;
	private JTable infocontactos;
	private JButton volver;
	
	
	
	
	public PanelVerContactos()
	{
	
		this.setSize(700,450);
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);
		this.setLayout(null);
	
		panelDeControl();
	
	}
	
	public void panelDeControl()
	{

		JLabel fondo = new JLabel();
		fondo.setBounds(0,0,750,450);
		imagenes = new ImageIcon("Resources/fondolistar.jpeg");
		fondo.setIcon(imagenes);
		fondo.setLayout(null);
		
		
		String[][] datosamigos = new String[20][4];
		String[] cabezeraamigos = {"NOMBRE","PA�S","TEL�FONO","E-MAIL"};
		
		infoamigos = new JTable(datosamigos,cabezeraamigos);
		JScrollPane scroll = new JScrollPane(infoamigos);
		scroll.setBounds(30,70,610,100);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(infoamigos);
		scroll.getViewport().setView(infoamigos);
		
		String[][] datoscontactos = new String[20][5];
		String[] cabezeracontactos = {"NOMBRE","PA�S","TEL�FONO","E-MAIL","EMPRESA"};

		infocontactos = new JTable(datoscontactos,cabezeracontactos);
		JScrollPane scroll2 = new JScrollPane(infocontactos);
		scroll2.setBounds(30,210,610,100);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setViewportView(infocontactos);
		scroll2.getViewport().setView(infocontactos);
		
		
		titulo = new JLabel("DIRECTORIO");
		titulo.setBounds(30,0,200,50);
		titulo.setFont(new Font("helvetica",Font.BOLD,25));
		titulo.setForeground(Color.BLACK);
		
		amigos = new JLabel("AMIGOS");
		amigos.setBounds(40,50,100,20);
		amigos.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		amigos.setForeground(Color.WHITE);
		
		contactos = new JLabel("CONTACTOS");
		contactos.setBounds(40,190,100,20);
		contactos.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		contactos.setForeground(Color.WHITE);
		
		volver = new JButton();
		volver.setBounds(530,330,110,40);
		imagenes = new ImageIcon("Resources/botonvolver.jpeg");
		imagenes = new ImageIcon(imagenes.getImage().getScaledInstance(110,40, Image.SCALE_DEFAULT));
		volver.setIcon(imagenes);
		volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		add(fondo);
		fondo.add(scroll);
		fondo.add(scroll2);
		fondo.add(titulo);
		fondo.add(amigos);
		fondo.add(contactos);
		fondo.add(volver);
		
		
		
	}
	
	public void reestablecer()
	{
		for(int i = 0;i<20;i++)
		{
			infoamigos.setValueAt("",i,0);
			infoamigos.setValueAt("",i,1);
			infoamigos.setValueAt("",i,2);
			infoamigos.setValueAt("",i,3);
			
			infocontactos.setValueAt("",i,0);
			infocontactos.setValueAt("",i,1);
			infocontactos.setValueAt("",i,2);
			infocontactos.setValueAt("",i,3);
			infocontactos.setValueAt("",i,4);
			
		}
	}

	public JTable getInfoamigos() {
		return infoamigos;
	}

	public JTable getInfocontactos() {
		return infocontactos;
	}

	public JButton getVolver() {
		return volver;
	}



}
