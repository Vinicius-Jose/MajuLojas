package controller;

import java.util.Set;

import javax.swing.JOptionPane;

import model.Modelo;
import model.Piloto;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplPiloto;
import dao.MajuModasDAOPiloto;

public class ControlePiloto{
	
	private MajuModasDAO banco = new MajuModasDAOImpl();
	private MajuModasDAOPiloto bdPiloto = new MajuModasDAOImplPiloto();
	
	public void adicionarPiloto(Piloto piloto) {
		banco.adicionar(piloto);
		JOptionPane.showMessageDialog(null, "Piloto adicionado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Piloto buscarPiloto(Modelo modelo) {
		return bdPiloto.buscarPilotoEspecifico(modelo);
	}
	
	public void alterarPiloto(Piloto piloto) {
		banco.alterar(piloto);
		JOptionPane.showMessageDialog(null, "Piloto alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Set<Modelo> buscarModelo(){
		return banco.buscarModelo1();
	}

}

