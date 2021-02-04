package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Restaurante
 *
 */
@Entity

public class Restaurante implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String direccion;
	private int aforo_maximo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
	private List<Reserva> reservas;
	
	public Restaurante() {
		super();
	}

	public Restaurante(int id, String nombre, String direccion, int aforo_maximo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.aforo_maximo = aforo_maximo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", aforo_maximo="
				+ aforo_maximo + ", reservas=" + reservas + "]";
	}
   
}
