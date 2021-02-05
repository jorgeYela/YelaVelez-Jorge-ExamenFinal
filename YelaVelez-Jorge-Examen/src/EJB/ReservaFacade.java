package EJB;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import javax.ejb.Stateless;
import Entity.*;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva>{

	@PersistenceContext(unitName = "YelaVelez-Jorge-Examen")
	private EntityManager em;
	
	public ReservaFacade() {
		super(Reserva.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Reserva buscarReserva(String nombre, String fecha) {
		Reserva reservaR = null;
		Query query = em.createQuery("SELECT r FROM Reserva r WHERE r.restaurante.nombre = '"+nombre+"' AND r.fecha = '"+fecha+"'");
		reservaR = (Reserva)query.getSingleResult();
		return reservaR;
	}
	
	public Reserva buscarReservaCliente(String cedula) {
		Reserva reserva = null;
		System.out.println("Clase: ReservaFacada.java - Valor: " + cedula);
		Query query = em.createQuery("SELECT r FROM Reserva r WHERE r.cliente.cedula = '"+cedula+"'");
		reserva = (Reserva)query.getSingleResult();
		return reserva;
	}
	
	public List<Reserva> listaReserva(String nombre, String fecha){
		
		List<Reserva> listaRes = null;
			
		Query query = em.createQuery("SELECT r FROM Reserva r WHERE r.restaurante.nombre = '"+nombre+"' AND r.fecha = '"+fecha+"'");
		listaRes = query.getResultList();
	
		return listaRes;
	
	}

}
