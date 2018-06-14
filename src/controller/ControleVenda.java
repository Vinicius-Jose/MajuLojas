package controller;

import java.util.List;
import java.util.Set;

import dao.MajuModasDAO;
import dao.MajuModasDAOEstoque;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplEstoque;
import model.Estoque;
import model.Modelo;
import model.Venda;

public class ControleVenda {
	private MajuModasDAO bd = new MajuModasDAOImpl();
	private MajuModasDAOEstoque bdEstoque = new MajuModasDAOImplEstoque();

	public Set<Modelo> buscarModelos() {
		return  bd.buscarModelo1();
	}
	
	public void adicionarVenda(Venda venda){
		bd.adicionar(venda);
	}

	public List<Estoque> buscarEstoque(Modelo modelo) {
		return bdEstoque.buscarEstoque(modelo);
	}

	public void atualizarEstoque(Estoque estoque) {
		bdEstoque.alterar(estoque);
		
	}

}
