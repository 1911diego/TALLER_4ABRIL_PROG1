package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Trabajo;

public class TrabajoDAO {
	
	private Archivo archivo;
	
	
	
	public TrabajoDAO(Archivo archivo) {
		super();
		this.archivo = archivo;
	}

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
	
	public boolean modificarContactoTrabajo(String pNombre, String pEmpresa, String pPais, String pTelManager, ArrayList<ArrayList> agenda) {
		eliminarContactoTrabajo(pTelManager, agenda);
		agregarContactoTrabajo(pNombre, pEmpresa, pPais, pTelManager, agenda);
		return true;
	}

}
