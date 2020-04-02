package co.edu.unbosque.model;

import java.io.Serializable;

public class Trabajo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String empresa;
	private String pais;
	private String telManager;
	private String correoT;
	
	
	
	
	public Trabajo(String nombre, String empresa, String pais, String telManager, String correoT) {
		super();
		this.nombre = nombre;
		this.empresa = empresa;
		this.pais = pais;
		this.telManager = telManager;
		this.correoT = correoT;
	}

	public void setCorreoT(String correoT) {
		this.correoT = correoT;
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
