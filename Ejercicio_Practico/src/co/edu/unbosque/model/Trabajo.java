package co.edu.unbosque.model;

import java.io.Serializable;

public class Trabajo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String empresa;
	protected String pais;
	protected String telManager;
	
	public Trabajo(String nombre, String empresa, String pais, String telManager) {
		this.nombre = nombre;
		this.empresa = empresa;
		this.pais = pais;
		this.telManager = telManager;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	
	public String getPais() {
		return pais;
	}
	
	public String getTelManager() {
		return telManager;
	}

}
