package controller;

import java.util.Set;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Modelo;
import model.Venda;

public class ControleVenda {
	private MajuModasDAO bd = new MajuModasDAOImpl();

	public Set<Modelo> buscarModelos() {
		return  bd.buscarModelo1();
	}
	
	public void adicionarVenda(Venda venda){
		bd.adicionar(venda);
	}

}
