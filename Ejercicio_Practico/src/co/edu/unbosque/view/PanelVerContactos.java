package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelVerContactos extends JPanel{

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
		fondo.setBounds(20,20,640,370);
		fondo.setBackground(Color.BLACK);
		fondo.setLayout(null);
		fondo.setOpaque(true);
		fondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.DARK_GRAY, Color.WHITE));
		
		
		
		String[][] datosamigos = {{"","","",""},
						{"","","",""}};
		String[] cabezeraamigos = {"NOMBRE","PAÍS","TELÉFONO","E-MAIL"};
		
		infoamigos = new JTable(datosamigos,cabezeraamigos);
		JScrollPane scroll = new JScrollPane(infoamigos);
		scroll.setBounds(30,70,590,100);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(infoamigos);
		scroll.getViewport().setView(infoamigos);
		
		String[][] datoscontactos = {{"","","","",""},
				{"","","","",""}};
		String[] cabezeracontactos = {"NOMBRE","PAÍS","TELÉFONO","E-MAIL","EMPRESA"};

		infocontactos = new JTable(datoscontactos,cabezeracontactos);
		JScrollPane scroll2 = new JScrollPane(infocontactos);
		scroll2.setBounds(30,210,590,100);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setViewportView(infocontactos);
		scroll2.getViewport().setView(infocontactos);
		
		
		titulo = new JLabel("DIRECTORIO");
		titulo.setBounds(30,0,200,50);
		titulo.setFont(new Font("helvetica",Font.BOLD,25));
		titulo.setForeground(Color.WHITE);
		
		amigos = new JLabel("AMIGOS");
		amigos.setBounds(40,50,100,20);
		amigos.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		amigos.setForeground(Color.LIGHT_GRAY);
		
		contactos = new JLabel("CONTACTOS");
		contactos.setBounds(40,190,100,20);
		contactos.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		contactos.setForeground(Color.LIGHT_GRAY);
		
		volver = new JButton("VOLVER");
		volver.setBounds(490,320,110,40);
		volver.setBackground(Color.WHITE);
		volver.setFont(new Font("helvetica",Font.HANGING_BASELINE,15));
		volver.setForeground(Color.BLUE);
		volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		add(fondo);
		fondo.add(scroll);
		fondo.add(scroll2);
		fondo.add(titulo);
		fondo.add(amigos);
		fondo.add(contactos);
		fondo.add(volver);
		
		
		
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
