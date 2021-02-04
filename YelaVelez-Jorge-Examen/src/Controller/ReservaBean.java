package Controller;

import java.io.Serializable;  
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
public class ReservaBean implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@EJB
	private ReservaFacade ejbReservaFacade;
	@EJB
	private ClienteFacade ejbClienteFacade;
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	
	private String nombre_restaurante;
	private String cedula;
	private String fecha;
	private String hora;
	private int aforo_max;
	private String resultado;
	private String resultado2;
	private int id_cliente;
	private String cedula_cliente;
	private String nombres;
	private String correo;
	private String direccion;
	private String telefono;
	
	public void addReserva() {
		String fecha = this.fecha;
		String hora = this.hora;
		int aforo_max = this.aforo_max;
		Cliente cliente = ejbClienteFacade.buscarCliente(cedula);
		Restaurante restaurante = ejbRestauranteFacade.buscarRestaurante(nombre_restaurante);
		if(cliente != null && restaurante !=null) {
			Reserva reserva = new Reserva(0,aforo_max,fecha,hora,cliente,restaurante);
			ejbReservaFacade.create(reserva);
			System.out.println("Reserva agregada correctamente...");
		}else {
			System.out.println("Error al guardar la reserva...");
		}
	}
	
	public String buscarCliente() {
		String cedula = this.cedula;
		Cliente cliente = ejbClienteFacade.buscarCliente(cedula);
		System.out.println("Ingresa metodo buscar cliente desde reservaBean, ahora verificando existencia...");
		System.out.println(cliente.getCorreo());
		if(cliente != null) {
			resultado =  "Usuario Disponible";
			this.cedula = "";
		}else {
			resultado =  "Usuario no Disponible";
			this.cedula = "";
		}
		return resultado;
	}
	
	public String buscarRestaurante() {
		String nombre_restaurante = this.nombre_restaurante;
		Restaurante restaurante = ejbRestauranteFacade.buscarRestaurante(nombre_restaurante);
		System.out.println("Ingresa metodo buscar cliente desde reservaBean, ahora verificando existencia...");
		System.out.println(restaurante.getNombre());
		if(restaurante != null) {
			resultado2 =  "Usuario Disponible";
			this.nombre_restaurante = "";
		}else {
			resultado2 =  "Usuario no Disponible";
			this.nombre_restaurante = "";
		}
		return resultado2;
	}
	
	public void buscarReserva(){


		Reserva reserva = ejbReservaFacade.buscarReserva(cedula, fecha);
        
        fecha = reserva.getFecha();
        hora = reserva.getHora();
        aforo_max = reserva.getNum_personas();
        
        Cliente cliente = ejbClienteFacade.buscarCliente(cedula);
        
        id_cliente = cliente.getId();
        cedula_cliente = cliente.getCedula();
        nombres = cliente.getNombres();
        correo = cliente.getCorreo();
        direccion = cliente.getDireccion();
        telefono = cliente.getTelefono();

    }

	public ReservaFacade getEjbReservaFacade() {
		return ejbReservaFacade;
	}

	public void setEjbReservaFacade(ReservaFacade ejbReservaFacade) {
		this.ejbReservaFacade = ejbReservaFacade;
	}

	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}

	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}

	public RestauranteFacade getEjbRestauranteFacade() {
		return ejbRestauranteFacade;
	}

	public void setEjbRestauranteFacade(RestauranteFacade ejbRestauranteFacade) {
		this.ejbRestauranteFacade = ejbRestauranteFacade;
	}

	public String getNombre_restaurante() {
		return nombre_restaurante;
	}

	public void setNombre_restaurante(String nombre_restaurante) {
		this.nombre_restaurante = nombre_restaurante;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getAforo_max() {
		return aforo_max;
	}

	public void setAforo_max(int aforo_max) {
		this.aforo_max = aforo_max;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
