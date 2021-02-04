package Controller;

import java.io.Serializable; 
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import Entity.*;
import EJB.*;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	private String cedula;
	private String nombres;
	private String correo;
	private String direccion;
	private String telefono;
	private List<Cliente> listCliente;
	private String resultado;
	HttpSession session;
	FacesContext context;
	
	public void init() {
		listCliente = ejbClienteFacade.findAll();
	}
	
	public void addCliente() {
		
		String cedula = this.cedula;
		String nombres = this.nombres;
		String correo = this.correo;
		String direccion = this.direccion;
		String telefono = this.telefono;
	
		try {
			Cliente cliente = new Cliente(0,cedula,nombres,correo,direccion,telefono);
			ejbClienteFacade.create(cliente);
			System.out.println("Usuario registrado....");
		} catch(Exception e){
			System.out.println("Error: " +e.getMessage());
		}

	}
	
	public String buscarCliente() {
		String cedula = this.cedula;
		Cliente cliente = ejbClienteFacade.buscarCliente(cedula);
		System.out.println("ingreso al metodo del controller buscar, ahora comprobando...");
		if(cliente != null) {
			resultado =  "Usuario Disponible";
		}else {
			resultado =  "Usuario no Disponible";
		}
		return resultado;
	}

	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}

	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Cliente> getListCliente() {
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}
	
}
