package EJB;

import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ejb.Stateless;
import Entity.*;

@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante>{

	@PersistenceContext(unitName = "YelaVelez-Jorge-Examen")
	private EntityManager em;
	
	public RestauranteFacade() {
		super(Restaurante.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public Restaurante buscarRestaurante(String nombre) {
		Restaurante restaurante = null;
		System.out.println("Clase: RestauranteFacada.java - Valor: " + nombre);
		Query query = em.createQuery("SELECT r FROM Restaurante r WHERE r.nombre = '"+nombre+"'");
		restaurante = (Restaurante)query.getSingleResult();
		return restaurante;
	}

}
