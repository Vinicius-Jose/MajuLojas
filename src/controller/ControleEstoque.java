package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Modelo;
import dao.MajuModasDAOEstoque;
import dao.MajuModasDAOImplEstoque;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOModelo;

public class ControleEstoque {
	

	private MajuModasDAOModelo bdModelo = new MajuModasDAOImplModelo();
	private MajuModasDAOEstoque bdEstoque  = new MajuModasDAOImplEstoque();
	
	public Set<Modelo> buscarModelos(){
		Set<Modelo> listaModelo = bdModelo.buscarModeloInfoBasica();
		return listaModelo;
	}
	
	public List<HashMap<String, Object>> buscarEstoque(Modelo modelo){
		return bdEstoque.buscarEspecifico(modelo);
	}

}
