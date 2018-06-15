package controller;

import java.util.List;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplCliente;
import model.Cliente;

public class ControleCliente{

	private MajuModasDAOImplCliente bdCliente = new MajuModasDAOImplCliente();
	

	
	public void adicionarCliente(Cliente cliente){
		bdCliente.adicionar(cliente);
		JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Cliente buscar(Cliente cliente){
		return bdCliente.buscarClienteEspecifico(cliente);
	}
	
	public void alterar(Cliente cliente){
		bdCliente.alterar(cliente);
		JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	
	
}
