package controller;

import java.util.Set;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOGrade;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplGrade;
import model.Grade;
import model.Modelo;

public class ControleGrade{

	
	private MajuModasDAOGrade bdGrade = new MajuModasDAOImplGrade();
	private MajuModasDAO bd = new MajuModasDAOImpl();
	
	public void adicionarGrade(Grade grade) {
		bdGrade.adicionar(grade);
		JOptionPane.showMessageDialog(null, "Grade adicionada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alterarGrade(Grade grade) {
		bdGrade.alterar(grade);
		JOptionPane.showMessageDialog(null, "Grade alterada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Set<Modelo> buscarModelo() {
		return bd.buscarModelo1();
	}
}
