package controller;
import java.util.Set;

import model.Modelagem;
import model.Modelo;
import dao.MajuModasDAOImplModelagem;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOModelagem;
import dao.MajuModasDAOModelo;

public class ControleModelagem{
	
	private MajuModasDAOModelagem bdModelagem = new MajuModasDAOImplModelagem();
	private MajuModasDAOModelo banco = new MajuModasDAOImplModelo();
	
	public Set<Modelo> buscarModelo(){
		return banco.buscarModeloInfoBasica();
	}
	
	public Modelagem buscarModelagem(Modelo modelo){
		return bdModelagem.buscarModelagemEspecifica(modelo);
	}

}

