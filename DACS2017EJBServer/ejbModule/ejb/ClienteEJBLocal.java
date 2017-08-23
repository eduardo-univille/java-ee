package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface ClienteEJBLocal {
	public void insert(Cliente cliente);

	public void save(Cliente cliente);

	public void remove(Cliente cliente);

	public List<Cliente> getAll();

	public List<Cliente> getAllByName(String name);

	public Cliente getById(long id);
}
