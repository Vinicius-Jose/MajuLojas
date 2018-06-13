package controller;

import model.Motorista;
import java.util.List;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleMotorista{

	private MajuModasDAO bdMotorista = new MajuModasDAOImpl();
	
	public void adicionarMotorista(Motorista motorista){
		bdMotorista.adicionar(motorista);
		JOptionPane.showMessageDialog(null, "Motorista adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Motorista buscar(Motorista motorista){
		List<Motorista> listaMotorista = bdMotorista.buscarMotorista();
		return listaMotorista.get(0);
	}
	
	public void alterar(Motorista motorista){
		bdMotorista.alterar(motorista);
		JOptionPane.showMessageDialog(null, "Motorista alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
