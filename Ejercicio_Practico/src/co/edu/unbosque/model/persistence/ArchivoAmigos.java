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

public class ArchivoAmigos {
	
	private File archivo = new File("datos/agendaDigitalAmigos.dat");
	
	public ArchivoAmigos() {
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
	
	public void guardarDatosAmigos(ArrayList<Amigos> amigos){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo,true));
			oos.writeObject(amigos);
			oos.writeObject("\n");
			oos.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al escribir en el archivo");
		}
	}
	
	public ArrayList<Amigos> cargarDatosAmigos(){
		ArrayList<Amigos> listaAmigos = new ArrayList<Amigos>();
		if(archivo.length()!=0) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
				listaAmigos = (ArrayList<Amigos>) ois.readObject();
				System.out.println(listaAmigos.size());
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
		return listaAmigos;
	}
	
	public File getArchivo() {
		return archivo;
	}
	
}
