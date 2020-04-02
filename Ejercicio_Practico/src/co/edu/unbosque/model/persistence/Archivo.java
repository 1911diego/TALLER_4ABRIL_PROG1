package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.Amigos;

public class Archivo{
	
	private File archivo = new File("datos/agendaDigital.dat");
	
	public Archivo() {
		if(archivo.exists()) {
		} else {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void guardarAgenda(ArrayList<ArrayList> agenda){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(agenda);
			oos.writeObject("\n");
			oos.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al escribir en el archivo");
		}
	}
	
	
	public ArrayList<ArrayList> cargarAgenda(){
		
		ArrayList <ArrayList> agend= new ArrayList<ArrayList>();
		if (archivo.length() != 0) {
			try {
				ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));
				agend = (ArrayList<ArrayList>) entrada.readObject();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return agend;
	}
	
	
	public ArrayList<ArrayList> cargarAgendaFisica( File agend) throws Exception{
		ArrayList<String> aux = new ArrayList<String>();
		ArrayList<String> aux1 = new ArrayList<String>();
		ArrayList<ArrayList> agendF = new ArrayList<ArrayList>();
        // Cargar las letras del archivo de propiedades
        Properties infoAgendaFisica = new Properties( );
        InputStream in = new FileInputStream( agend );
        infoAgendaFisica.load( in );
        
        // Cargar las letras
        int numAmigos = Integer.parseInt( infoAgendaFisica.getProperty( "amigo.cantidad" ) );
        int numTrabajo = Integer.parseInt( infoAgendaFisica.getProperty( "contacto.cantidad" ) );
        for( int i = 1; i <= numAmigos; i++ ){
            String nombre = infoAgendaFisica.getProperty( "amigo.nombre" + i );
            String pais = infoAgendaFisica.getProperty( "amigo.pais" + i );
            String telefono = infoAgendaFisica.getProperty( "amigo.telefono" + i );
            String correo = infoAgendaFisica.getProperty( "amigo.correo" + i );
            String conc = nombre + ";" + pais+ ";" + telefono + ";" + correo;
            aux.add(conc);
        }
        
        for( int i = 1; i <= numTrabajo; i++ ){
            String nombre = infoAgendaFisica.getProperty( "contacto.nombre" + i );
            String empresa = infoAgendaFisica.getProperty("contacto.empresa" + i);
            String pais = infoAgendaFisica.getProperty( "contacto.pais" + i );
            String telefono = infoAgendaFisica.getProperty( "contacto.telefonoManager" + i );
            String correo = infoAgendaFisica.getProperty( "contacto.correo" + i );
            String conc1 = nombre + ";" + empresa + ";" + pais+ ";" + telefono + ";" + correo;
            aux1.add(conc1);
        }
        
        agendF.add(aux);
        agendF.add(aux1);
        
		return agendF;
    }
	public File getArchivo() {
		return archivo;
	}

	
}
