package EJB;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	
	public Reserva buscarReserva(String cedula, String fecha) {
		Reserva reserva = null;
		System.out.println("Clase: ReservaFacada.java - Valor: " + cedula + " valor fecha: " + fecha);
		Query query = em.createQuery("SELECT r FROM Reserva r WHERE r.cliente.cedula = '"+cedula+"' AND r.fecha = '"+fecha+"'");
		reserva = (Reserva)query.getSingleResult();
		return reserva;
	}

}
