package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import co.edu.unbosque.model.Amigos;

public class Archivo{
	
	private File archivo = new File("datos/agendaDigital.dat");
	
	/**
	 * Constructor de la clase Archivo
	 */
	public Archivo() {
		if(archivo.exists()) {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Este metodo agrega un contacto a la agenda
	 * <b>pre</b>la lista de los contactos debe estar inicializada
	 * <b>pos</b>se guardan los contactos en el archivo
	 * @param agenda es la lista de contactos
	 */
	public void guardarAgenda(ArrayList<ArrayList> agenda){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(agenda);
			oos.writeObject("\n");
			oos.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al escribir en el archivo");
		}
	}
	
	/**
	 * este metodo carga los datos de los contactos
	 * <b>pre</b>el archivo debe estar creado
	 * <b>pos</b>se lee y se guarda en un ArrayList los datos leidos del archivo
	 * @return devuelve la lista de contactos
	 */
	public ArrayList<ArrayList> cargarAgenda(){
		ArrayList<ArrayList> agenda = new ArrayList<ArrayList>();
		if(archivo.length()!=0) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
				agenda = (ArrayList<ArrayList>) ois.readObject();
				JOptionPane.showMessageDialog(null, "Se cargaron los datos");
				ois.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "No se encontro el archivo");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al leer el archivo");
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "No se encontro la clase");
			}
		}
		return agenda;
	}
	
	/**
	 * Metodo getter del archivo
	 * @return devuelve el valor del archivo
	 */
	public File getArchivo() {
		return archivo;
	}
	
}
