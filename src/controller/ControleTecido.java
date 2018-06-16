package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Fornecedor;
import model.Tecido;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplTecido;
import dao.MajuModasDAOTecido;

public class ControleTecido{

	private MajuModasDAO bdTecido = new MajuModasDAOImpl();
	private MajuModasDAOTecido bd = new MajuModasDAOImplTecido();
	
	public void adicionarTecido(Tecido tecido){
		bdTecido.adicionar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Tecido buscar(Tecido tecido){
		
		return bd.buscarTecidoEspecifico(tecido);
	}
	
	public void alterar(Tecido tecido){
		bdTecido.alterar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Fornecedor> buscarFornecedor(){
		return bdTecido.buscarFornecedor();
	}
	
}
