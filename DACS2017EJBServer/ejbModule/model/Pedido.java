package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	private Cliente cliente;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PedidoID")
	private List<ItemPedido> colItens = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getColItens() {
		return colItens;
	}

	public void setColItens(List<ItemPedido> colItens) {
		this.colItens = colItens;
	}
}
