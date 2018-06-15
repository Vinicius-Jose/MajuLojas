package controller;

import javax.swing.JOptionPane;

import model.Motorista;
import dao.MajuModasDAOImplMotorista;
import dao.MajuModasDAOMotorista;

public class ControleMotorista{

	private MajuModasDAOMotorista bdMotorista = new MajuModasDAOImplMotorista();
	
	public void adicionarMotorista(Motorista motorista){
		bdMotorista.adicionar(motorista);
		JOptionPane.showMessageDialog(null, "Motorista adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Motorista buscar(Motorista motorista){
		return bdMotorista.buscarMotoristaEspecifico(motorista);
	}
	
	public void alterar(Motorista motorista){
		bdMotorista.alterar(motorista);
		JOptionPane.showMessageDialog(null, "Motorista alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
