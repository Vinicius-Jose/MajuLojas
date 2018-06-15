package controller;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Encomenda;
import model.Modelo;
import model.Motorista;
import dao.MajuModasDAO;
import dao.MajuModasDAOCliente;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplCliente;
import dao.MajuModasDAOImplMotorista;
import dao.MajuModasDAOMotorista;

public class ControleEncomenda {


	private MajuModasDAOCliente bdCliente = new MajuModasDAOImplCliente();
	private MajuModasDAO banco = new MajuModasDAOImpl();
	private MajuModasDAOMotorista bdMotorista = new MajuModasDAOImplMotorista();

	public void finalizarEncomenda(Encomenda encomenda) {
		banco.adicionar(encomenda);
		JOptionPane.showMessageDialog(null, "Encomenda adicionado com sucesso",
				"Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	public List<Cliente> buscarClientes() {
		return bdCliente.buscarCliente();
	}
	
	public List<Motorista> buscarMotoristas(){
		return bdMotorista.buscarMotorista();
	}
	
	public Set<Modelo> buscarModelos(){
		return banco.buscarModelo1();
	}

	public List<Encomenda> buscarEncomendas(Cliente cliente) {
		return banco.buscarEncomenda();
	}
	
	

}
