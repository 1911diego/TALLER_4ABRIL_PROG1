package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Amigos;

public class AmigosDAO {
	
	private ArchivoAmigos archivoAmigos;
	
	public AmigosDAO(ArchivoAmigos archivoAmigos) {
		this.archivoAmigos = archivoAmigos;
	}
	
	/**
	 * prueba pull
	 */
	public Amigos buscarAmigos(String pNumTel, ArrayList<Amigos> listaAmigos) {
		Amigos encontrado = null;
		if(!listaAmigos.isEmpty()) {
			for (int i = 0; i < listaAmigos.size(); i++) {
				if(listaAmigos.get(i).getNumTelefono().equals(pNumTel)){
					encontrado = listaAmigos.get(i);
				}
			}
		}
		return encontrado;
	}
	
	public boolean agregarAmigo(String nombre, String pais, String numTelefono, String correo, ArrayList<Amigos> listaAmigos) {
		Amigos a = new Amigos(nombre, pais, numTelefono, correo);
		if(buscarAmigos(numTelefono, listaAmigos) == null) {
			listaAmigos.add(a);
			archivoAmigos.guardarDatosAmigos(listaAmigos);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe un amigo con ese numero de telefono");
			return false;
		}
	}
	
	public boolean eliminarAmigo(String pNumTel, ArrayList<Amigos> listaAmigos) {
		try {
			Amigos a = buscarAmigos(pNumTel, listaAmigos);
			listaAmigos.remove(a);
			archivoAmigos.getArchivo().delete();
			archivoAmigos.getArchivo().createNewFile();
			archivoAmigos.guardarDatosAmigos(listaAmigos);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modificarAmigo(String nombre, String pais, String numTelefono, String correo, ArrayList<Amigos> listaAmigos) {
		eliminarAmigo(numTelefono, listaAmigos);
		agregarAmigo(nombre, pais, numTelefono, correo, listaAmigos);
		return true;
	}

}
