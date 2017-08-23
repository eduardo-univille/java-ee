package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;

/**
 * Session Bean implementation class ClienteEJB
 */
@Stateless
@LocalBean
public class ClienteEJB implements ClienteEJBLocal {
	@PersistenceContext(name = "dacs2017context")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ClienteEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}

	@Override
	public void save(Cliente cliente) {
		if (em.find(Cliente.class, cliente.getId()) == null) {
			em.persist(cliente);
		} else {
			em.merge(cliente);
		}
	}

	@Override
	public void remove(Cliente cliente) {
		cliente = em.find(Cliente.class, cliente.getId());
		em.remove(cliente);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getAll() {
		Query q = em.createNamedQuery("getall");
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getAllByName(String name) {
		Query q = em.createNamedQuery("getallbyname");
		q.setParameter("name", name);
		return q.getResultList();
	}

	@Override
	public Cliente getById(long id) {
		return em.find(Cliente.class, id);
	}
}
