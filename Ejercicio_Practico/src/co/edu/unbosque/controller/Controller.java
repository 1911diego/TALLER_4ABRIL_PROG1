package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Amigos;
import co.edu.unbosque.model.Trabajo;
import co.edu.unbosque.model.persistence.AmigosDAO;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.TrabajoDAO;

public class Controller implements ActionListener{

		private ArrayList<ArrayList> agenda;
		private Archivo archivo;
		private AmigosDAO amigosdao;
		private TrabajoDAO trabajodao;

		public Controller() {
			agenda = new ArrayList<ArrayList>();
			archivo = new Archivo();
			amigosdao = new AmigosDAO(archivo);
			trabajodao = new TrabajoDAO(archivo);
			ArrayList <Amigos> listaAmigos = new ArrayList<Amigos>();
			ArrayList <Trabajo> listaTrabajo = new ArrayList<Trabajo>();
			agenda = archivo.cargarAgenda();
			agenda.add(listaAmigos);
			agenda.add(listaTrabajo);
			
			
		}
		
		
		public void cargarAgendaF() {
			 JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));   
				fc.showOpenDialog(fc);
				File f = fc.getSelectedFile();
				try {
					ArrayList<String> amigos = archivo.cargarAgendaFisica(f).get(0);
					ArrayList<String> trabajo = archivo.cargarAgendaFisica(f).get(1);
					for(int i = 0; i < amigos.size(); i++) {
						String [] conc =amigos.get(i).split(";");
						amigosdao.agregarAmigo(conc[0], conc[1], conc[2], conc[3], agenda);
						
					}
					
					for(int i = 0; i < trabajo.size(); i++) {
						String [] conc =trabajo.get(i).split(";");
						trabajodao.agregarContactoTrabajo(conc[0], conc[1], conc[2], conc[3],conc[4], agenda);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Hubo un error leyendo la agenda física");
				}
		}

		public static void main(String[]args) {
			Controller c = new Controller();
			Archivo ar = new Archivo();
			AmigosDAO am = new AmigosDAO(ar);
			c.cargarAgendaF();
			System.out.println(am.cantidadDeAmigosPorPais("Colombia", c.agenda));
			System.out.println(c.agenda.size());
	
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}

}
