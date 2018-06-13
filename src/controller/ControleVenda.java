package controller;

import java.util.Set;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import model.Modelo;

public class ControleVenda {
	private MajuModasDAO bd = new MajuModasDAOImpl();

	public Set<Modelo> buscarModelos() {
		return  bd.buscarModelo1();
	}

}
