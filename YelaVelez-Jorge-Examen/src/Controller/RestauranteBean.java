package Controller;

import java.io.Serializable;   
import java.util.ArrayList;
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
public class RestauranteBean implements Serializable{

private static final long serialVersionUID = 1L;
	
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	@EJB
	private ReservaFacade ejbReservaFacade;
	@EJB
	private ClienteFacade ejbClienteFacade;
	
	private String nombre;
	private String direccion;
	private int aforo_maximo;
	private String resultado;
	
	public void addRestaurante() {
		String nombre = this.nombre;
		String direccion = this.direccion;
		int aforo_maximo = this.aforo_maximo;
	
		try {
			Restaurante restaurante = new Restaurante(0,nombre,direccion,aforo_maximo);
			ejbRestauranteFacade.create(restaurante);
			System.out.println("Usuario registrado....");
		} catch(Exception e){
			System.out.println("Error: " +e.getMessage());
		}

	}
	
	public String buscarRestaurante() {
		String nombre = this.nombre;
		Restaurante restaurante = ejbRestauranteFacade.buscarRestaurante(nombre);
		System.out.println("ingreso al metodo del controller buscar, ahora comprobando...");
		if(restaurante != null) {
			resultado =  "restaurante Disponible";
		}else {
			resultado =  "restaurante no Disponible";
		}
		return resultado;
	}

	public RestauranteFacade getEjbRestauranteFacade() {
		return ejbRestauranteFacade;
	}

	public void setEjbRestauranteFacade(RestauranteFacade ejbRestauranteFacade) {
		this.ejbRestauranteFacade = ejbRestauranteFacade;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getAforo_maximo() {
		return aforo_maximo;
	}

	public void setAforo_maximo(int aforo_maximo) {
		this.aforo_maximo = aforo_maximo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	

}
