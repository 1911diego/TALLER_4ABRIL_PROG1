package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Amigos;

public class AmigosDAO {
	
	private Archivo archivo;

	/**
	 * Constructor de la calse AmigosDAO
	 * @param archivo Es el archivo de donde se cogen los datos
	 */
	public AmigosDAO(Archivo archivo) {
		super();
		this.archivo = archivo;
	}
	
	/**
	 * Metodo que busca el contacto de amigos
	 * <b>pre</b>la agenda debe estar inicializada y el numero de telefono del amigo debe ser diferente de null
	 * <b>pos</b>encuentra el contacto de amigo
	 * @param pNumTel Es el numero de telefono del amigo
	 * @param agenda Es la agenda de contactos
	 * @return devuelve el contacto con sus datos
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
	
	/**
	 * Agrega un nuevo amigo a la agenda
	 * <b>pre</b>se necesita toda la informacion del contacto
	 * <b>pos</b>agrega un nuevo contacto de amigo a la agenda
	 * @param nombre Es el nombre del amigo 
	 * @param pais Es el pais de origen del amigo
	 * @param numTelefono Es el numero de telefono del amigo
	 * @param correo Es el correo del amigo
	 * @param agenda Es la agenda de contactos
	 * @return Devuelve un valor de true si se agrego el contacto a la agenda, de lo contrario devuelve false 
	 */
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
	
	/**
	 * Este metodo elimina un contacto de la agenda
	 * <b>pre</b>Se necesita el numero del amigo
	 * <b>pos</b>elimina el contacto
	 * @param pNumTel Es el numero de telefono del amigo
	 * @param agenda Es la agenda de contactos
	 * @return devuelve un valor de true si el contacto fue eliminado de lo contrario devolvera un valor de false
	 */
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
	
<<<<<<< HEAD
	public int cantidadDeAmigosPorPais(String pais, ArrayList<ArrayList> agenda) {
		int cantidadAmigos =0;
		ArrayList <Amigos> listaAmigos = agenda.get(0);
		if(!listaAmigos.isEmpty()) {
			for (int i = 0; i < listaAmigos.size(); i++) {
				if(listaAmigos.get(i).getPais().equals(pais)){
					cantidadAmigos++;
				}
			}
		}
		
		 return cantidadAmigos;
	}
	
=======
	/**
	 * Metodo que modifica un contacto deseado
	 * <b>pre</b>Se debe saber el numero de telefono del amigo
	 * <b>pos</b>Se modifica el contacto deseado
	 * @param nombre Es el nombre del amigo
	 * @param pais Es el pais de origen del amigo
	 * @param numTelefono Es el numero de telefono del amigo
	 * @param agenda Es la agenda de contactos
	 * @return devuelve un valor de true si se modifico el contacto, de lo contrario devolvera false si no se pudo modificar
	 */
>>>>>>> branch 'master' of https://github.com/1911diego/TALLER_4ABRIL_PROG1
	public boolean modificarAmigo(String nombre, String pais, String numTelefono, String correo, ArrayList<ArrayList> agenda) {
		try {
			eliminarAmigo(numTelefono, agenda);
			agregarAmigo(nombre, pais, numTelefono, correo, agenda);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo modificar el contacto");
			return false;
		}
	}

}
