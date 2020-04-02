package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Trabajo;

public class TrabajoDAO {
	
	private Archivo archivo;
	
	/**
	 * Constructor de la clase TrabajoDAO
	 * @param archivo Es el archivo donde se cogen los datos
	 */
	public TrabajoDAO(Archivo archivo) {
		super();
		this.archivo = archivo;
	}

	/**
	 * Este metodo busca el contacto de trabajo
	 * <b>pre</b>la agenda debe estar inicializada y el numero del manager debe ser diferente de null
	 * <b>pos</b>encuentra el contacto de trabajo
	 * @param pTelManager es el numero de telefono del manager
	 * @param agenda es la lista de contactos
	 * @return devuelve el contacto con todos sus datos
	 */
	public Trabajo buscarContactoTrabajo(String pTelManager, ArrayList<ArrayList> agenda) {
		Trabajo contactoEncontrado = null;
		ArrayList<Trabajo> listaContactos = agenda.get(1);
		if(!listaContactos.isEmpty()) {
			for (int i = 0; i < listaContactos.size(); i++) {
				if(listaContactos.get(i).getTelManager().equals(pTelManager)) {
					contactoEncontrado = listaContactos.get(i);
				}
			}
		}
		return contactoEncontrado;
	}
	
	/**
	 * Este metodo agreaga un contacto en la agenda
	 * <b>pre</b>se necesita toda la informacion del contacto
	 * <b>pos</b>Agrega un contacto nuevo de trabajo en la agenda
	 * @param pNombre Es el nombre del contacto
	 * @param pEmpresa Es el nombre de la empresa del contacto
	 * @param pPais Es el pais de origen del contacto
	 * @param pTelManager Es el numero del manager del contacto
	 * @param agenda Es la agenda de contactos
	 * @return Devuelve un valor de true si se agrego el contacto, de lo contrario devolvera false
	 */
	public boolean agregarContactoTrabajo(String pNombre, String pEmpresa, String pPais, String pTelManager,  ArrayList<ArrayList> agenda) {
		Trabajo t = new Trabajo(pNombre, pEmpresa, pPais, pTelManager);
		if(buscarContactoTrabajo(pTelManager, agenda) == null) {
			agenda.get(1).add(t);
			archivo.guardarAgenda(agenda);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe un contacto de trabajo con ese numero de telefono");
			return false;
		}
	}
	
	/**
	 * Este metodo elimina un contacto de la agenda
	 * <b>pre</b>Se necesita el numero del manager
	 * <b>pos</b>Se elimina el contacto
	 * @param pTelManager Es el numero de telefono del manager
	 * @param agenda Es la agenda de contactos
	 * @return devuelve un valor de true si el contacto fue eliminado de lo contrario devolvera un valor de false
	 */
	public boolean eliminarContactoTrabajo(String pTelManager, ArrayList<ArrayList> agenda) {
		try {
			Trabajo t = buscarContactoTrabajo(pTelManager, agenda);
			agenda.get(1).remove(t);
			archivo.getArchivo().delete();
			archivo.getArchivo().createNewFile();
			archivo.guardarAgenda(agenda);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo que modifica un contacto deseado
	 * <b>pre</b>Se debe saber el numero de telefono del manager
	 * <b>pos</b>Se modifica el contacto deseado
	 * @param pNombre 
	 * @param pEmpresa
	 * @param pPais
	 * @param pTelManager
	 * @param agenda
	 * @return devuelve un valor de true si se modifico el contacto, de lo contrario devolvera false si no se pudo modificar
	 */
	public boolean modificarContactoTrabajo(String pNombre, String pEmpresa, String pPais, String pTelManager, ArrayList<ArrayList> agenda) {
		try {
			eliminarContactoTrabajo(pTelManager, agenda);
			agregarContactoTrabajo(pNombre, pEmpresa, pPais, pTelManager, agenda);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo modificar el contacto");
			return false;
		}
	}

}
