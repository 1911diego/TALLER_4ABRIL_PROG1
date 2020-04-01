package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Amigos;

public class AmigosDAO {
	
	private Archivo archivo;

	
	public AmigosDAO(Archivo archivo) {
		super();
		this.archivo = archivo;
	}

	/**
	 * prueba pull
	 */
	public Amigos buscarAmigos(String pNumTel, ArrayList<ArrayList> agenda) {
		ArrayList <Amigos> listaAmigos = agenda.get(0);
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
	
	public boolean agregarAmigo(String nombre, String pais, String numTelefono, String correo, ArrayList<ArrayList> agenda) {
		Amigos a = new Amigos(nombre, pais, numTelefono, correo);
		if(buscarAmigos(numTelefono, agenda) == null) {
			agenda.get(0).add(a);
			archivo.guardarAgenda(agenda);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe un amigo con ese numero de telefono");
			return false;
		}
	}
	
	public boolean eliminarAmigo(String pNumTel, ArrayList<ArrayList> agenda) {
		try {
			Amigos a = buscarAmigos(pNumTel, agenda);
			agenda.get(0).remove(a);
			archivo.getArchivo().delete();
			archivo.getArchivo().createNewFile();
			archivo.guardarAgenda(agenda);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modificarAmigo(String nombre, String pais, String numTelefono, String correo, ArrayList<ArrayList> agenda) {
		eliminarAmigo(numTelefono, agenda);
		agregarAmigo(nombre, pais, numTelefono, correo, agenda);
		return true;
	}

}
