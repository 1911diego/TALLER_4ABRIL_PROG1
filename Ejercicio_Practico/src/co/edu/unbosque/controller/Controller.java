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

		//Constructor de la clase Controller
		public Controller() {
			agenda = new ArrayList<ArrayList>();
			archivo = new Archivo();
			amigosdao = new AmigosDAO(archivo);
			trabajodao = new TrabajoDAO(archivo);
			ArrayList <Amigos> listaAmigos = new ArrayList<Amigos>();
			ArrayList <Trabajo> listaTrabajo = new ArrayList<Trabajo>();
			ArrayList<String> paises = new ArrayList<String>();
			agenda = archivo.cargarAgenda();
			agenda.add(listaAmigos);
			agenda.add(listaTrabajo);
			agenda.add(paises);
			
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
		
		/**
		 * Metodo que da los oyentes a los componentes de la vista
		 */
		public void setActionListeners()
		{
			//LISTENERS PANEL PRINCIPAL
			vista.getpPrincipal().getBotonagregar().addActionListener(this);
			vista.getpPrincipal().getBotonmodificar().addActionListener(this);
			vista.getpPrincipal().getBotonver().addActionListener(this);
			vista.getpPrincipal().getCargararchivo().addActionListener(this);
			vista.getpPrincipal().getBotoneliminar().addActionListener(this);
			
			//LISTENERS PANEL AGREGAR
			vista.getpAgregar().getBotoncrear().addActionListener(this);
			vista.getpAgregar().getBotoneditar().addActionListener(this);
			vista.getpAgregar().getTipodecontacto().addActionListener(this);
			vista.getpAgregar().getVolver().addActionListener(this);
			//vista.getpAgregar().getPais().addActionListener(this);
			
			//LISTENERS PANEL VER CONTACTOS
			
			vista.getpVer().getVolver().addActionListener(this);
			
			
		}

		//Metodo implementado de la interfaz actionListener
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
						ArrayList<String> paises = archivo.cargarAgendaFisica(f).get(2);
						for(int i = 0; i < amigos.size(); i++) {
							String [] conc =amigos.get(i).split(";");
							if(amigosdao.buscarAmigos(conc[2], agenda)!=null) {
								
							}else {

								amigosdao.agregarAmigo(conc[0], conc[1], conc[2], conc[3], agenda);
							}
							
						}
						
						for(int i = 0; i < trabajo.size(); i++) {
							String [] conc =trabajo.get(i).split(";");
							if(trabajodao.buscarContactoTrabajo(conc[3], agenda)!=null) {
								
							}else {
								trabajodao.agregarContactoTrabajo(conc[0], conc[1], conc[2], conc[3],conc[4], agenda);
							}
							
						}
						
						for(int i=0; i<paises.size(); i++) {
							String pais = paises.get(i);
							if(agenda.get(2).contains(pais)) {
								
							}else {
								agenda.get(2).add(pais);
							}
							
							
						}
						System.out.println(agenda.size());
						System.out.println(agenda.get(2).size());
					} catch (Exception excep) {
						//excep.printStackTrace();
						vista.mensajes("ERROR_AGENDA");
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
				vista.getpAgregar().getTipodecontacto().setEnabled(true);
				vista.getpAgregar().reestablecer();
			}
			
			//BOT�N VOLVER DEL PANEL AGREGAR
			if(e.getSource()==vista.getpAgregar().getVolver())
			{
				vista.getpPrincipal().setVisible(true);
				vista.getpAgregar().setVisible(false);
				vista.getpVer().setVisible(false);
				
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
				String nombre, pais, telefono, correo, empresa, validar;
				nombre = vista.getpAgregar().getTxtnombre().getText();
				pais = (String) vista.getpAgregar().getPais().getSelectedItem();
				telefono = vista.getpAgregar().getTxttelefono().getText();
				correo = vista.getpAgregar().getTxtcorreo().getText();
				empresa = vista.getpAgregar().getTxtempresa().getText();
				
				if(vista.getpAgregar().getTipodecontacto().getSelectedItem().equals("SELECCIONE TIPO"))
				{
					vista.mensajes("INGRESE_COMBOBOX");
				}
				
				
				if(vista.getpAgregar().getTipodecontacto().getSelectedItem().equals("AMIGO"))
				{
					if(nombre.isEmpty()||telefono.isEmpty()||correo.isEmpty())
					{
						vista.mensajes("INGRESE_TODOS_LOS_DATOS");
					}
					else
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
				}
				if(vista.getpAgregar().getTipodecontacto().getSelectedItem().equals("CONTACTO"))
				{
					if(nombre.isEmpty()||telefono.isEmpty()||correo.isEmpty()||empresa.isEmpty())
					{
						vista.mensajes("INGRESE_TODOS_LOS_DATOS");
					}
					else
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
				
				
			}
			
			//BOT�N EDITAR CONTACTOS
			if(e.getSource()==vista.getpPrincipal().getBotonmodificar())
			{
				
				String validar = vista.mensajes("VALIDAR_MODIFICACION");
				String nombre, pais, telefono, correo, empresa;
				
				Amigos buscaramigos = amigosdao.buscarAmigos(validar, agenda);
				Trabajo buscarcontacto = trabajodao.buscarContactoTrabajo(validar, agenda);
				
				if(buscaramigos!=null)
				{
					nombre = buscaramigos.getNombre();
					pais = buscaramigos.getPais();
					telefono = buscaramigos.getNumTelefono();
					correo = buscaramigos.getCorreo();
					System.out.print(pais);
					
					vista.getpAgregar().getTxtnombre().setText(nombre);
					vista.getpAgregar().getTxttelefono().setText(telefono);
					vista.getpAgregar().getTxtcorreo().setText(correo);
					vista.getpAgregar().getTipodecontacto().setSelectedItem("AMIGO");
					vista.getpAgregar().getTipodecontacto().setEnabled(false);
					vista.getpAgregar().setValidar(telefono);
					vista.getpAgregar().getPais().setSelectedItem(pais.toUpperCase());
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
					vista.getpAgregar().getTxttelefono().setText(telefono);
					vista.getpAgregar().getTxtcorreo().setText(correo);
					vista.getpAgregar().getTxtempresa().setText(empresa);
					vista.getpAgregar().getTipodecontacto().setSelectedItem("CONTACTO");
					vista.getpAgregar().getTipodecontacto().setEnabled(false);
					vista.getpAgregar().setValidar(telefono);
					vista.getpAgregar().getPais().setSelectedItem(pais.toUpperCase());
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
			
			if(e.getSource()==vista.getpPrincipal().getBotoneliminar())
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
			
			
			//BOT�N EDITAR CONTACTOS
			
			if(e.getSource()==vista.getpAgregar().getBotoneditar())
			{
				String nombre,pais,telefono,correo,empresa,telvalidar;
				
				nombre = vista.getpAgregar().getTxtnombre().getText();
				pais = (String) vista.getpAgregar().getPais().getSelectedItem();
				telvalidar = vista.getpAgregar().getValidar();
				telefono = vista.getpAgregar().getTxttelefono().getText();
				correo = vista.getpAgregar().getTxtcorreo().getText();
				empresa = vista.getpAgregar().getTxtempresa().getText();
				
				if(vista.getpAgregar().getTipodecontacto().getSelectedItem().equals("AMIGO"))
				{
					if(nombre.isEmpty()||telefono.isEmpty()||correo.isEmpty())
					{
						vista.mensajes("INGRESE_TODOS_LOS_DATOS");
					}
					else
					{
					amigosdao.modificarAmigo(telvalidar,nombre, pais, telefono, correo, agenda);
					vista.mensajes("EDITADO_EXITOSO");
					}
				}
				
				if(vista.getpAgregar().getTipodecontacto().getSelectedItem().equals("CONTACTO"))
				{
					if(nombre.isEmpty()||telefono.isEmpty()||correo.isEmpty()||empresa.isEmpty())
					{
						vista.mensajes("INGRESE_TODOS_LOS_DATOS");
					}
					else
					{
					trabajodao.modificarContactoTrabajo(telvalidar,nombre, empresa, pais, telefono, correo, agenda);
					vista.mensajes("EDITADO_EXITOSO");
					}
				}
			}
			
			
			//BOT�N VER CONTACTOS
			if(e.getSource()==vista.getpPrincipal().getBotonver())
			{
				Amigos listaramigos;
				Trabajo listarcontactos;
				vista.getpVer().reestablecer();
				vista.getpPrincipal().setVisible(false);
				vista.getpAgregar().setVisible(false);
				vista.getpVer().setVisible(true);
				
				String colombia, peru, chile, espa�a, argentina, mexico;
				
				int col = amigosdao.cantidadDeAmigosPorPais("colombia", agenda);
				int per = amigosdao.cantidadDeAmigosPorPais("peru", agenda);
				int chi = amigosdao.cantidadDeAmigosPorPais("chile", agenda);
				int esp = amigosdao.cantidadDeAmigosPorPais("espa�a", agenda);
				int arg = amigosdao.cantidadDeAmigosPorPais("argentina", agenda);
				int mex = amigosdao.cantidadDeAmigosPorPais("mexico", agenda);
				
				colombia = String.valueOf(col);
				peru = String.valueOf(per);
				chile = String.valueOf(chi);
				espa�a = String.valueOf(esp);
				argentina = String.valueOf(arg);
				mexico = String.valueOf(mex);
				
				vista.getpVer().getInfopais().setValueAt("AMIGOS",0,0);
				vista.getpVer().getInfopais().setValueAt(colombia,0,1);
				vista.getpVer().getInfopais().setValueAt(peru,0,2);
				vista.getpVer().getInfopais().setValueAt(chile,0,3);
				vista.getpVer().getInfopais().setValueAt(espa�a,0,4);
				vista.getpVer().getInfopais().setValueAt(argentina,0,5);
				vista.getpVer().getInfopais().setValueAt(mexico,0,6);
				
				
				int col1 = trabajodao.cantidadDeContactosTrabajoPorPais("colombia", agenda);
				int per1 = trabajodao.cantidadDeContactosTrabajoPorPais("peru", agenda);
				int chi1 = trabajodao.cantidadDeContactosTrabajoPorPais("chile", agenda);
				int esp1 = trabajodao.cantidadDeContactosTrabajoPorPais("espa�a", agenda);
				int arg1 = trabajodao.cantidadDeContactosTrabajoPorPais("argentina", agenda);
				int mex1 = trabajodao.cantidadDeContactosTrabajoPorPais("mexico", agenda);
				
				String colombia1 = String.valueOf(col1);
				String peru1 = String.valueOf(per1);
				String chile1 = String.valueOf(chi1);
				String espa�a1 = String.valueOf(esp1);
				String argentina1 = String.valueOf(arg1);
				String mexico1 = String.valueOf(mex1);
				
				vista.getpVer().getInfopais().setValueAt("CONTACTOS",1,0);
				vista.getpVer().getInfopais().setValueAt(colombia1,1,1);
				vista.getpVer().getInfopais().setValueAt(peru1,1,2);
				vista.getpVer().getInfopais().setValueAt(chile1,1,3);
				vista.getpVer().getInfopais().setValueAt(espa�a1,1,4);
				vista.getpVer().getInfopais().setValueAt(argentina1,1,5);
				vista.getpVer().getInfopais().setValueAt(mexico1,1,6);
				
				
				
				
				
				for(int i = 0; i<agenda.size();i++)
				{
					try {
					listaramigos = amigosdao.listarAmigos(agenda,i);
					vista.getpVer().getInfoamigos().setValueAt(listaramigos.getNombre().toUpperCase(),i,0);
					vista.getpVer().getInfoamigos().setValueAt(listaramigos.getPais().toUpperCase(),i,1);
					vista.getpVer().getInfoamigos().setValueAt(listaramigos.getNumTelefono().toUpperCase(),i,2);
					vista.getpVer().getInfoamigos().setValueAt(listaramigos.getCorreo().toUpperCase(),i,3);
					
					String cantidadamigos = String.valueOf(i+1);
					vista.getpVer().getLcantamigos().setText("CANTIDAD DE AMIGOS EN LA AGENDA: "+cantidadamigos);
					
					}
					catch(Exception excepcion)
					{
						
					}
					
					try {
						listarcontactos = trabajodao.listarContactos(agenda,i);
						vista.getpVer().getInfocontactos().setValueAt(listarcontactos.getNombre().toUpperCase(),i,0);
						vista.getpVer().getInfocontactos().setValueAt(listarcontactos.getPais().toUpperCase(),i,1);
						vista.getpVer().getInfocontactos().setValueAt(listarcontactos.getTelManager().toUpperCase(),i,2);
						vista.getpVer().getInfocontactos().setValueAt(listarcontactos.getCorreoT().toUpperCase(),i,3);
						vista.getpVer().getInfocontactos().setValueAt(listarcontactos.getEmpresa().toUpperCase(),i,4);
						
						String cantidadcontactos = String.valueOf(i+1);
						vista.getpVer().getLcantcontactos().setText("CANTIDAD DE AMIGOS EN LA AGENDA: "+cantidadcontactos);
						}
						catch(Exception excepcion)
						{
							
						}
					
					
				}
				
				
				
			}
			
			
		}

}
