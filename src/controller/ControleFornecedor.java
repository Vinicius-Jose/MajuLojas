package controller;

import model.Fornecedor;
import java.util.List;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleFornecedor{

	private MajuModasDAO bdFornecedor = new MajuModasDAOImpl();
	
	public void adicionarfornecedor(Fornecedor fornecedor){
		bdFornecedor.adicionar(fornecedor);
		JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Fornecedor buscar(Fornecedor fornecedor){
		List<Fornecedor> listaFornecedor = bdFornecedor.buscarFornecedor();
		return listaFornecedor.get(0);
	}
	
	public void alterar(Fornecedor fornecedor){
		bdFornecedor.alterar(fornecedor);
		JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
