package EJB;

import java.util.List; 
import javax.ejb.Stateless; 
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	public Cliente buscarCliente(String cedulaEnviada) {
		Cliente cliente = null;
		System.out.println("Clase: PacienteFacada.java - Valor: "+cedulaEnviada);
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.cedula = '"+cedulaEnviada+"'");
		cliente = (Cliente)query.getSingleResult();
		return cliente;
	}

}
