/**
 * @autor Alicia Yoshida
 */

package controller;

import javax.swing.JOptionPane;

import model.Cliente;
import dao.MajuModasDAOImplCliente;

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
