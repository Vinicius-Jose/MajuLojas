/**
 * @autor Alicia Yoshida
 */

package controller;

import java.util.Set;

import javax.swing.JOptionPane;

import model.Grade;
import model.Modelo;
import dao.MajuModasDAOGrade;
import dao.MajuModasDAOImplGrade;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOModelo;

public class ControleGrade{

	
	private MajuModasDAOGrade bdGrade = new MajuModasDAOImplGrade();
	private MajuModasDAOModelo bdModelo = new MajuModasDAOImplModelo();
	
	public void adicionarGrade(Grade grade) {
		bdGrade.adicionar(grade);
		JOptionPane.showMessageDialog(null, "Grade adicionada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alterarGrade(Grade grade) {
		bdGrade.alterar(grade);
		JOptionPane.showMessageDialog(null, "Grade alterada com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Set<Modelo> buscarModelo() {
		return bdModelo.buscarModeloInfoBasica();
	}
}
