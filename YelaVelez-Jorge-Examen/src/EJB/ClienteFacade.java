package EJB;

import java.util.List; 
import javax.ejb.Stateless; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Entity.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{

	@PersistenceContext(unitName = "YelaVelez-Jorge-Examen")
	private EntityManager em;
	
	public ClienteFacade() {
		super(Cliente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Cliente buscarCliente(String cedula) {
		Cliente cliente = null;
		System.out.println("Clase: ClienteFacada.java - Valor: "+cedula);
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.cedula = '"+cedula+"'");
		cliente = (Cliente)query.getSingleResult();
		return cliente;
	}

}
