package controller;
import java.util.Set;

import model.Modelagem;
import model.Modelo;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplModelagem;
import dao.MajuModasDAOModelagem;

public class ControleModelagem{
	
	private MajuModasDAOModelagem bdModelagem = new MajuModasDAOImplModelagem();
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public Set<Modelo> buscarModelo(){
		return banco.buscarModelo1();
	}
	
	public Modelagem buscarModelagem(Modelo modelo){
		return bdModelagem.buscarModelagemEspecifica(modelo);
	}

}

