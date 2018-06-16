package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Aviamento;
import model.Fornecedor;
import dao.MajuModasDAOImplAviamento;
import dao.MajuModasDAOImplFornecedor;

public class ControleAviamento{
	
	private MajuModasDAOImplAviamento bdAviamento = new MajuModasDAOImplAviamento();
	private MajuModasDAOImplFornecedor forn = new MajuModasDAOImplFornecedor();
	
	public void adicionarAviamento(Aviamento aviamento){
		bdAviamento.adicionar(aviamento);
		JOptionPane.showMessageDialog(null, "Aviamento adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	public Aviamento buscar(Aviamento aviamento){
		return bdAviamento.buscaEspecifico(aviamento);
	}
	
	public void alterar(Aviamento aviamento){
		bdAviamento.alterar(aviamento);
		JOptionPane.showMessageDialog(null, "Aviamento alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	public List<Fornecedor> buscarFornecedor() {
		return forn.buscarFornecedor();
	}

	
}
	

