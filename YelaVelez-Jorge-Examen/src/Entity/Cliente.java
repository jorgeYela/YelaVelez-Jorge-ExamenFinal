package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String nombres;
	private String correo;
	private String direccion;
	private String telefono;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Reserva> reservas;

	public Cliente() {
		super();
	}

	public Cliente(int id, String cedula, String nombres, String correo, String direccion, String telefono) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombres = nombres;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.reservas = reservas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
   
}
