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
	
	private String nuevoo;
	private String nombre_restaurante;
	private String cedula;
	private String fecha;
	private String fecha_recuperada;
	private String hora;
	private String hora_recuperada;
	private int aforo_max;
	private int aforo_max_recuperado;
	private String resultado;
	private String resultado2;
	private int id_cliente;
	private String cedula_cliente;
	private String cedula_obtenida;
	private String nombres;
	private String nombre_obtenido;
	private String correo;
	private String correo_obtenido;
	private String direccion;
	private String telefono;
	private String nombreR;
	private String nombreRR;
	
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
			System.out.println("El cliente o el restaurante no se encuentran registrados en la base de datos...");
		}

	}
	
	/*public String buscarCliente() {
		String cedula = this.cedula;
		System.out.println("cedula que se envia para obtener user: "+cedula);
		Cliente clienteEE = ejbClienteFacade.buscarCliente(cedula);
		System.out.println("Ingresa metodo buscar cliente desde reservaBean, ahora verificando existencia...");
		System.out.println(clienteEE.getCorreo());
		if(clienteEE != null) {
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
		//Restaurante restaurante = ejbRestauranteFacade.buscarRestaurante(nombre_restaurante);
		Restaurante restaurante = ejbRestauranteFacade.find(nombre_restaurante);
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
	}*/
	
	public void buscarReservaCliente(){


		Reserva reserva = ejbReservaFacade.buscarReservaCliente(cedula);
        
        fecha_recuperada = reserva.getFecha();
        hora_recuperada = reserva.getHora();
        aforo_max_recuperado = reserva.getNum_personas();
        
        Cliente cliente = ejbClienteFacade.buscarCliente(cedula);
        
        id_cliente = cliente.getId();
        cedula_obtenida = cliente.getCedula();
        nombre_obtenido = cliente.getNombres();
        correo_obtenido = cliente.getCorreo();
        direccion = cliente.getDireccion();
        telefono = cliente.getTelefono();

    }
	
	public void buscarReservaRestaurante(){

		List<Reserva> listRe = null;
		//Reserva reserva = ejbReservaFacade.buscarReserva(nombreR, fecha);
        listRe = ejbReservaFacade.listaReserva(nombreR, fecha);
		//nombreRR = reserva.getRestaurante().getNombre();
        /*fecha_recuperada = reserva.getFecha();
        hora_recuperada = reserva.getHora();
        aforo_max_recuperado = reserva.getNum_personas();*/
        System.out.println(listRe.toString());
        nuevoo = listRe.toString();

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

	public String getResultado2() {
		return resultado2;
	}

	public void setResultado2(String resultado2) {
		this.resultado2 = resultado2;
	}

	public String getFecha_recuperada() {
		return fecha_recuperada;
	}

	public void setFecha_recuperada(String fecha_recuperada) {
		this.fecha_recuperada = fecha_recuperada;
	}

	public String getHora_recuperada() {
		return hora_recuperada;
	}

	public void setHora_recuperada(String hora_recuperada) {
		this.hora_recuperada = hora_recuperada;
	}

	public int getAforo_max_recuperado() {
		return aforo_max_recuperado;
	}

	public void setAforo_max_recuperado(int aforo_max_recuperado) {
		this.aforo_max_recuperado = aforo_max_recuperado;
	}

	public String getCedula_obtenida() {
		return cedula_obtenida;
	}

	public void setCedula_obtenida(String cedula_obtenida) {
		this.cedula_obtenida = cedula_obtenida;
	}

	public String getNombre_obtenido() {
		return nombre_obtenido;
	}

	public void setNombre_obtenido(String nombre_obtenido) {
		this.nombre_obtenido = nombre_obtenido;
	}

	public String getCorreo_obtenido() {
		return correo_obtenido;
	}

	public void setCorreo_obtenido(String correo_obtenido) {
		this.correo_obtenido = correo_obtenido;
	}

	public String getNombreR() {
		return nombreR;
	}

	public void setNombreR(String nombreR) {
		this.nombreR = nombreR;
	}
	
	public String getNombreRR() {
		return nombreRR;
	}

	public void setNombreRR(String nombreRR) {
		this.nombreR = nombreRR;
	}

	public String getNuevoo() {
		return nuevoo;
	}

	public void setNuevoo(String nuevoo) {
		this.nuevoo = nuevoo;
	}

	
	
}
