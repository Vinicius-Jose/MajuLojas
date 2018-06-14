package controller;

import model.Fornecedor;
import java.util.List;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOFornecedor;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplFornecedor;

public class ControleFornecedor{

	private MajuModasDAOFornecedor bdFornecedor = new MajuModasDAOImplFornecedor();
	
	public void adicionarfornecedor(Fornecedor fornecedor){
		bdFornecedor.adicionar(fornecedor);
		JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Fornecedor buscar(Fornecedor fornecedor){
		Fornecedor fornecedorRet = bdFornecedor.buscarFornecedorEspecifico(fornecedor);
		return fornecedorRet;
	}
	
	public void alterar(Fornecedor fornecedor){
		bdFornecedor.alterar(fornecedor);
		JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
