package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Modelo;
import dao.MajuModasDAO;
import dao.MajuModasDAOEstoque;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplEstoque;

public class ControleEstoque {
	

	private MajuModasDAO banco = new MajuModasDAOImpl();
	private MajuModasDAOEstoque bdEstoque  = new MajuModasDAOImplEstoque();
	
	public Set<Modelo> buscarModelos(){
		Set<Modelo> listaModelo = banco.buscarModelo1();
		return listaModelo;
	}
	
	public List<HashMap<String, Object>> buscarEstoque(Modelo modelo){
		return bdEstoque.buscarEspecifico(modelo);
	}

}
