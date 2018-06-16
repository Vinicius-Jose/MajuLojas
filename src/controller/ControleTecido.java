/**
 * @autor Alicia Yoshida
 */
package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Fornecedor;
import model.Tecido;
import dao.MajuModasDAOFornecedor;
import dao.MajuModasDAOImplFornecedor;
import dao.MajuModasDAOImplTecido;
import dao.MajuModasDAOTecido;

public class ControleTecido{


	private MajuModasDAOTecido bdTecido = new MajuModasDAOImplTecido();
	private MajuModasDAOFornecedor bdFornecedor = new MajuModasDAOImplFornecedor();
	
	public void adicionarTecido(Tecido tecido){
		bdTecido.adicionar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Tecido buscar(Tecido tecido){
		
		return bdTecido.buscarTecidoEspecifico(tecido);
	}
	
	public void alterar(Tecido tecido){
		bdTecido.alterar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Fornecedor> buscarFornecedor(){
		return bdFornecedor.buscarFornecedor();
	}
	
}
