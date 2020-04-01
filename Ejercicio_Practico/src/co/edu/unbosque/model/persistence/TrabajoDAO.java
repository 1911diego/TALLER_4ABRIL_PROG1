package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Trabajo;

public class TrabajoDAO {
	
	private ArchivoTrabajo archivoTrabajo;
	
	public TrabajoDAO(ArchivoTrabajo archivoTrabajo) {
		this.archivoTrabajo = archivoTrabajo;
	}
	
	public Trabajo buscarContactoTrabajo(String pTelManager, ArrayList<Trabajo> listaContactos) {
		Trabajo contactoEncontrado = null;
		if(!listaContactos.isEmpty()) {
			for (int i = 0; i < listaContactos.size(); i++) {
				if(listaContactos.get(i).getTelManager().equals(pTelManager)) {
					contactoEncontrado = listaContactos.get(i);
				}
			}
		}
		return contactoEncontrado;
	}
	
	public boolean agregarContactoTrabajo(String pNombre, String pEmpresa, String pPais, String pTelManager, ArrayList<Trabajo> listaContactos) {
		Trabajo t = new Trabajo(pNombre, pEmpresa, pPais, pTelManager);
		if(buscarContactoTrabajo(pTelManager, listaContactos) == null) {
			listaContactos.add(t);
			archivoTrabajo.guardarDatosTrabajo(listaContactos);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe un contacto de trabajo con ese numero de telefono");
			return false;
		}
	}
	
	public boolean eliminarContactoTrabajo(String pTelManager, ArrayList<Trabajo> listaContactos) {
		try {
			Trabajo t = buscarContactoTrabajo(pTelManager, listaContactos);
			listaContactos.remove(t);
			archivoTrabajo.getArchivoTrabajo().delete();
			archivoTrabajo.getArchivoTrabajo().createNewFile();
			archivoTrabajo.guardarDatosTrabajo(listaContactos);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modificarContactoTrabajo(String pNombre, String pEmpresa, String pPais, String pTelManager, ArrayList<Trabajo> listaContactos) {
		eliminarContactoTrabajo(pTelManager, listaContactos);
		agregarContactoTrabajo(pNombre, pEmpresa, pPais, pTelManager, listaContactos);
		return true;
	}

}
