package controller;

import model.Fornecedor;
import model.Tecido;
import java.util.List;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleTecido{

	private MajuModasDAO bdTecido = new MajuModasDAOImpl();
	
	public void adicionarTecido(Tecido tecido){
		bdTecido.adicionar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Tecido buscar(Tecido tecido){
		List<Tecido> listaTecido = bdTecido.buscarTecido();
		return listaTecido.get(0);
	}
	
	public void alterar(Tecido tecido){
		bdTecido.alterar(tecido);
		JOptionPane.showMessageDialog(null, "Tecido alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Fornecedor> buscarFornecedor(){
		return bdTecido.buscarFornecedor();
	}
	
}
