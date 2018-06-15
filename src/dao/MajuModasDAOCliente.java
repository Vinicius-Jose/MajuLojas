package dao;

import java.util.List;

import model.Cliente;

public interface MajuModasDAOCliente {

	
	public void adicionar(Cliente cliente);
	public void remover(Cliente cliente);
	public void alterar(Cliente cliente);
	public List<Cliente> buscarCliente();
	public Cliente buscarClienteEspecifico(Cliente cliente);
	
}
