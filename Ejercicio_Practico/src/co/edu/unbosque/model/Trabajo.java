package co.edu.unbosque.model;

import java.io.Serializable;

public class Trabajo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String empresa;
	protected String pais;
	protected String telManager;
	
	/**
	 * Constructor de la clase Trabajo
	 * @param nombre es el nombre de la persona
	 * @param empresa nombre de la empresa
	 * @param pais donde esta ubicada la empresa
	 * @param telManager numero de telefono del manager
	 */
	public Trabajo(String nombre, String empresa, String pais, String telManager) {
		this.nombre = nombre;
		this.empresa = empresa;
		this.pais = pais;
		this.telManager = telManager;
	}
	
	/**
	 * Metodo getter de la variable nombre
	 * @return Devuelve el valor de la variable nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo getter de la variable empresa
	 * @return Devuelve el valor de la variable empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	
	/**
	 * Metodo getter de la varable pais
	 * @return Devuelve el valor de la variable pais
	 */
	public String getPais() {
		return pais;
	}
	
	/**
	 * Metodo getter de la variable telManager
	 * @return Devuelve el valor de la variable telManager
	 */
	public String getTelManager() {
		return telManager;
	}

}
