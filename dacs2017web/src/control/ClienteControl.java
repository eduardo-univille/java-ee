package control;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ClienteEJBLocal;
import model.Cliente;

@ManagedBean(name = "clienteControl")
@ViewScoped
public class ClienteControl {
	@EJB
	private ClienteEJBLocal clienteEJB;

	private Cliente model = new Cliente();

	public void remove() {
		if (model != null) {
			clienteEJB.remove(model);
		}
	}

	public void insert() {
		model = new Cliente();
	}

	public void save() {
		clienteEJB.save(model);
	}

	public Cliente getModel() {
		return model;
	}

	public void setModel(Cliente model) {
		this.model = model;
	}

	public List<Cliente> getAll() {
		return clienteEJB.getAll();
	}

	public void inserirCliente() {
		System.out.println("Clicou no botão");
		Cliente cliente = new Cliente();
		cliente.setNome("Zezinho");
		cliente.setDataNascimento(new Date());
		clienteEJB.insert(cliente);
	}
}
