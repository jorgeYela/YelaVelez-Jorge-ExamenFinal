package Entity;

import java.io.Serializable; 
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity

public class Reserva implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int num_personas;
	private String fecha;
	private String hora;
	@JoinColumn
	@ManyToOne
	private Cliente cliente;
	@JoinColumn
	@ManyToOne
	private Restaurante restaurante;
	
	public Reserva() {
		super();
	}

	public Reserva(int id, int num_personas, String fecha, String hora, Cliente cliente, Restaurante restaurante) {
		super();
		this.id = id;
		this.num_personas = num_personas;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.restaurante = restaurante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum_personas() {
		return num_personas;
	}

	public void setNum_personas(int num_personas) {
		this.num_personas = num_personas;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", num_personas=" + num_personas + ", fecha=" + fecha + ", hora=" + hora
				+ ", cliente=" + cliente + ", restaurante=" + restaurante + "]\n\n";
	}
   
}
