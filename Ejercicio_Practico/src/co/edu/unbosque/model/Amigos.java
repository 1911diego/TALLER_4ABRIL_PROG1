package co.edu.unbosque.model;

import java.io.Serializable;

public class Amigos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String pais;
	protected String numTelefono;
	protected String correo;
	
	/**
	 * Constructor de la clase amigos
	 * @param nombre del amigo
	 * @param pais donde vive el amigo
	 * @param numTelefono numero de telefono del amigo
	 * @param correo del amigo
	 */
	public Amigos(String nombre, String pais, String numTelefono, String correo) {
		this.nombre = nombre;
		this.pais = pais;
		this.numTelefono = numTelefono;
		this.correo = correo;
	}

	/**
	 * Metodo getter de la variable nombre
	 * @return devuelve el valor de la variable nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo getter de la variable pais
	 * @return Devuelve el valor de la variable pais
	 */
	public String getPais() {
		return pais;
	}
	
	/**
	 * Metodo getter de la variable numTelefono
	 * @return Devuelve el valor de la variable numTelefono
	 */
	public String getNumTelefono() {
		return numTelefono;
	}
	
	/**
	 * Metodo getter de la variable correo
	 * @return Devuelve el valor de la variable correo
	 */
	public String getCorreo() {
		return correo;
	}

}
