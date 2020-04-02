package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Amigos;
import co.edu.unbosque.model.Trabajo;
import co.edu.unbosque.model.persistence.AmigosDAO;
import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.TrabajoDAO;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener{

		private ArrayList<ArrayList> agenda;
		private Archivo archivo;
		private AmigosDAO amigosdao;
		private TrabajoDAO trabajodao;
		private View vista;

		public Controller() {
			agenda = new ArrayList<ArrayList>();
			archivo = new Archivo();
			amigosdao = new AmigosDAO(archivo);
			trabajodao = new TrabajoDAO(archivo);
			ArrayList <Amigos> listaAmigos = new ArrayList<Amigos>();
			ArrayList <Trabajo> listaTrabajo = new ArrayList<Trabajo>();
			agenda = archivo.cargarAgenda();
			agenda.add(listaAmigos);
			agenda.add(listaTrabajo);
			
			vista = new View();
			vista.setSize(700, 450);
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
			vista.setTitle("Contactos Rosita");
			vista.setResizable(false);
			vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			vista.setLayout(null);
			
			setActionListeners();
			
		}
		
		
		public void setActionListeners()
		{
			//LISTENERS PANEL PRINCIPAL
			vista.getpPrincipal().getBotonagregar().addActionListener(this);
			vista.getpPrincipal().getBotonmodificar().addActionListener(this);
			vista.getpPrincipal().getBotonver().addActionListener(this);
			vista.getpPrincipal().getCargararchivo().addActionListener(this);
			
			//LISTENERS PANEL AGREGAR
			vista.getpAgregar().getBotoncrear().addActionListener(this);
			vista.getpAgregar().getBotoneditar().addActionListener(this);
			vista.getpAgregar().getBotoneliminar().addActionListener(this);
			vista.getpAgregar().getTipodecontacto().addActionListener(this);
			vista.getpAgregar().getVolver().addActionListener(this);
			
			//LISTENERS PANEL VER CONTACTOS
			
			vista.getpVer().getVolver().addActionListener(this);
			
		}
/**
		public static void main(String[]args) {
			Controller c = new Controller();
			Archivo ar = new Archivo();
			AmigosDAO am = new AmigosDAO(ar);
			c.cargarAgendaF();
			System.out.println(am.cantidadDeAmigosPorPais("Colombia", c.agenda));
			System.out.println(c.agenda.size());
	
		}
		
		**/
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//BOT�N CARGAR ARCHIVO
			if(e.getSource()==vista.getpPrincipal().getCargararchivo())
			{
				 JFileChooser fc=new JFileChooser(System.getProperty("user.dir"));   
					fc.showOpenDialog(fc);
					File f = fc.getSelectedFile();
					try {
						ArrayList<String> amigos = archivo.cargarAgendaFisica(f).get(0);
						ArrayList<String> trabajo = archivo.cargarAgendaFisica(f).get(1);
						for(int i = 0; i < amigos.size(); i++) {
							String [] conc =amigos.get(i).split(";");
							amigosdao.agregarAmigo(conc[0], conc[1], conc[2], conc[3], agenda);
							
						}
						
						for(int i = 0; i < trabajo.size(); i++) {
							String [] conc =trabajo.get(i).split(";");
							trabajodao.agregarContactoTrabajo(conc[0], conc[1], conc[2], conc[3],conc[4], agenda);
						}
						
					} catch (Exception excep) {
						excep.printStackTrace();
						JOptionPane.showMessageDialog(null, "Hubo un error leyendo la agenda f�sica");
					}
			}
			
			//BOT�N CONTACTOS
			if(e.getSource()==vista.getpPrincipal().getBotonagregar())
			{
				vista.getpPrincipal().setVisible(false);
				vista.getpAgregar().setVisible(true);
				vista.getpVer().setVisible(false);
				vista.getpAgregar().getBotoncrear().setVisible(true);
				vista.getpAgregar().getBotoneditar().setVisible(false);
			}
			
			//BOT�N VOLVER DEL PANEL AGREGAR
			if(e.getSource()==vista.getpAgregar().getVolver())
			{
				vista.getpPrincipal().setVisible(true);
				vista.getpAgregar().setVisible(false);
				vista.getpVer().setVisible(false);
				
			}
			
			
			//BOT�N VER CONTACTOS
			if(e.getSource()==vista.getpPrincipal().getBotonver())
			{
				vista.getpPrincipal().setVisible(false);
				vista.getpAgregar().setVisible(false);
				vista.getpVer().setVisible(true);
				
			}
			
			//BOT�N VOLVER PANEL VER CONTACTOS
			if(e.getSource()==vista.getpVer().getVolver())
			{
				vista.getpPrincipal().setVisible(true);
				vista.getpAgregar().setVisible(false);
				vista.getpVer().setVisible(false);
				
			}
			
			//LISTENER DE COMBOBOX PANEL AGREGAR
			if(e.getSource()==vista.getpAgregar().getTipodecontacto())
			{
				String validacion = (String) vista.getpAgregar().getTipodecontacto().getSelectedItem();
				
				if(validacion.equalsIgnoreCase("AMIGO"))
				{
					vista.getpAgregar().getLempresa().setVisible(false);
					vista.getpAgregar().getTxtempresa().setVisible(false);
				}
				else
				{
					vista.getpAgregar().getLempresa().setVisible(true);
					vista.getpAgregar().getTxtempresa().setVisible(true);
				}
			}
			
			
			
			//LISTENER BOT�N CREAR CONTACTO PANEL AGREGAR
			if(e.getSource() == vista.getpAgregar().getBotoncrear())
			{
				Amigos nuevoamigo;
				Trabajo nuevocontacto;
				String nombre, pais, telefono, correo, empresa;
				nombre = vista.getpAgregar().getTxtnombre().getText();
				pais = vista.getpAgregar().getTxtpais().getText();
				telefono = vista.getpAgregar().getTxttelefono().getText();
				correo = vista.getpAgregar().getTxtcorreo().getText();
				empresa = vista.getpAgregar().getTxtempresa().getText();
				
				if(vista.getpAgregar().getTipodecontacto().getSelectedItem().equals("AMIGO"))
				{
					nuevoamigo = amigosdao.buscarAmigos(telefono, agenda);
					
					if(nuevoamigo==null)
					{
						amigosdao.agregarAmigo(nombre, pais, telefono, correo, agenda);
						vista.mensajes("AMIGO_AGREGADO");
					}
					else
					{
						vista.mensajes("NO_AGREGADO");
					}
				}
				if(vista.getpAgregar().getTipodecontacto().getSelectedItem().equals("CONTACTO"))
				{
					nuevocontacto = trabajodao.buscarContactoTrabajo(telefono, agenda);
					if(nuevocontacto==null)
					{
						trabajodao.agregarContactoTrabajo(nombre, empresa, pais, telefono, correo, agenda);
						vista.mensajes("CONTACTO_AGREGADO");
					}
					else
					{
						vista.mensajes("NO_AGREGADO");
					}
					
					
					
				}
				
				
			}
			
			//BOT�N EDITAR CONTACTOS
			if(e.getSource()==vista.getpPrincipal().getBotonmodificar())
			{
				String prueba = vista.mensajes("VALIDAR_MODIFICACION");
				String nombre, pais, telefono, correo, empresa;
				
				Amigos buscaramigos = amigosdao.buscarAmigos(prueba, agenda);
				Trabajo buscarcontacto = trabajodao.buscarContactoTrabajo(prueba, agenda);
				
				if(buscaramigos!=null)
				{
					nombre = buscaramigos.getNombre();
					pais = buscaramigos.getPais();
					telefono = buscaramigos.getNumTelefono();
					correo = buscaramigos.getCorreo();
					
					vista.getpAgregar().getTxtnombre().setText(nombre);
					vista.getpAgregar().getTxtpais().setText(pais);
					vista.getpAgregar().getTxttelefono().setText(telefono);
					vista.getpAgregar().getTxtcorreo().setText(correo);
					vista.getpAgregar().getTipodecontacto().setSelectedItem("AMIGO");
					
					vista.getpPrincipal().setVisible(false);
					vista.getpAgregar().setVisible(true);
					vista.getpVer().setVisible(false);
					vista.getpAgregar().getBotoncrear().setVisible(false);
					vista.getpAgregar().getBotoneditar().setVisible(true);
				}
				
				if(buscarcontacto!=null)
				{
					nombre = buscarcontacto.getNombre();
					pais = buscarcontacto.getPais();
					telefono = buscarcontacto.getTelManager();
					correo = buscarcontacto.getCorreoT();
					empresa = buscarcontacto.getEmpresa();
					
					vista.getpAgregar().getTxtnombre().setText(nombre);
					vista.getpAgregar().getTxtpais().setText(pais);
					vista.getpAgregar().getTxttelefono().setText(telefono);
					vista.getpAgregar().getTxtcorreo().setText(correo);
					vista.getpAgregar().getTxtempresa().setText(empresa);
					vista.getpAgregar().getTipodecontacto().setSelectedItem("CONTACTO");
					
					vista.getpPrincipal().setVisible(false);
					vista.getpAgregar().setVisible(true);
					vista.getpVer().setVisible(false);
					vista.getpAgregar().getBotoncrear().setVisible(false);
					vista.getpAgregar().getBotoneditar().setVisible(true);
				}
				
				if(buscaramigos==null&&buscarcontacto==null)
				{
					vista.mensajes("NO_ENCONTRADO");
				}
				
				
				
			}
			
			//BOT�N ELIMINAR CONTACTOS
			
			if(e.getSource()==vista.getpAgregar().getBotoneliminar())
			{
				String eliminar = vista.mensajes("ELIMINAR");
				
				Amigos buscaramigos = amigosdao.buscarAmigos(eliminar, agenda);
				Trabajo buscarcontacto = trabajodao.buscarContactoTrabajo(eliminar, agenda);
				
				if(buscaramigos!=null)
				{
					amigosdao.eliminarAmigo(eliminar, agenda);
					vista.mensajes("ELIMINADO");
				}
				
				if(buscarcontacto!=null)
				{
					trabajodao.eliminarContactoTrabajo(eliminar, agenda);
					vista.mensajes("ELIMINADO");
				}
				
				if(buscarcontacto==null&&buscaramigos==null)
				{
					vista.mensajes("NO_ELIMINADO");
				}
				
			}
			
			
		}

}
