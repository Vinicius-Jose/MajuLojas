/**
 * @autor Vinícius José
 */
package controller;

import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Encomenda;
import model.Modelo;
import model.Motorista;
import dao.MajuModasDAOCliente;
import dao.MajuModasDAOEncomenda;
import dao.MajuModasDAOImplCliente;
import dao.MajuModasDAOImplEncomenda;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOImplMotorista;
import dao.MajuModasDAOModelo;
import dao.MajuModasDAOMotorista;

public class ControleEncomenda {


	private MajuModasDAOCliente bdCliente = new MajuModasDAOImplCliente();
	private MajuModasDAOMotorista bdMotorista = new MajuModasDAOImplMotorista();
	private MajuModasDAOEncomenda bdEncomenda = new MajuModasDAOImplEncomenda();
	private MajuModasDAOModelo bdModelo = new MajuModasDAOImplModelo();
	
	public void finalizarEncomenda(Encomenda encomenda) {
		bdEncomenda.adicionar(encomenda);
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
		return bdModelo.buscarModeloInfoBasica();
	}

	public List<Encomenda> buscarEncomendas(Cliente cliente) {
		return bdEncomenda.buscarEncomenda(cliente);
	}
	
	

}
