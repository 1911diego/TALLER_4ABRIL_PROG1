package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import co.edu.unbosque.model.Trabajo;

import javax.swing.JOptionPane;

public class ArchivoTrabajo {
	
	private File archivoTrabajo = new File("datos/agendaDigitalTrabajo");
	
	public ArchivoTrabajo() {
		if(archivoTrabajo.exists()) {
			JOptionPane.showMessageDialog(null, "El archivo ya existe");
		} else {
			try {
				archivoTrabajo.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Hubo un error al crear el archivo");
				e.printStackTrace();
			}
		}
	}
	
	public void guardarDatosTrabajo(ArrayList<Trabajo> trabajo) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoTrabajo));
			oos.writeObject(trabajo);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getArchivoTrabajo() {
		return archivoTrabajo;
	}

}
