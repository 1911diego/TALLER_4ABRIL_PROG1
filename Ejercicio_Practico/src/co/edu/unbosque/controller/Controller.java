package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
			agenda = archivo.cargarAgenda();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}

}
