package co.edu.unbosque.model;

import java.io.Serializable;

public class Amigos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String pais;
	protected String numTelefono;
	protected String correo;
	
	public Amigos(String nombre, String pais, String numTelefono, String correo) {
		this.nombre = nombre;
		this.pais = pais;
		this.numTelefono = numTelefono;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getPais() {
		return pais;
	}
	
	public String getNumTelefono() {
		return numTelefono;
	}
	
	public String getCorreo() {
		return correo;
	}

}
