package controller;

import java.util.Set;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Grade;
import model.Modelo;

public class ControleGrade{

	
	private MajuModasDAO bdGrade = new MajuModasDAOImpl();
	
	public void adicionarGrade(Grade grade) {
		bdGrade.adicionar(grade);
		JOptionPane.showMessageDialog(null, "Grade adicionada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alterarGrade(Grade grade) {
		bdGrade.alterar(grade);
		JOptionPane.showMessageDialog(null, "Grade alterada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Set<Modelo> buscarModelo() {
		return bdGrade.buscarModelo1();
	}
}
