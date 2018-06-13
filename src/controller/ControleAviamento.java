package controller;

import model.Aviamento;

import java.util.List;

import javax.swing.JOptionPane;

import model.Fornecedor;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleAviamento{
	
	private MajuModasDAO bdAviamento = new MajuModasDAOImpl();

	
	public void adicionarAviamento(Aviamento aviamento){
		bdAviamento.adicionar(aviamento);
		JOptionPane.showMessageDialog(null, "Aviamento adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	public Aviamento buscar(Aviamento aviamento){
		List<Aviamento> listaAviamento= bdAviamento.buscarAviamento();
		return listaAviamento.get(0);
	}
	
	public void alterar(Aviamento aviamento){
		bdAviamento.alterar(aviamento);
		JOptionPane.showMessageDialog(null, "Aviamento alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}

	public List<Fornecedor> buscarFornecedor() {
		return bdAviamento.buscarFornecedor();
	}

	
}
	

