package controller;

import java.util.Set;

import model.Estoque;
import model.Modelo;
import model.Venda;
import dao.MajuModasDAOEstoque;
import dao.MajuModasDAOImplEstoque;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOImplVenda;
import dao.MajuModasDAOModelo;
import dao.MajuModasDAOVenda;

public class ControleVenda {
	private MajuModasDAOEstoque bdEstoque = new MajuModasDAOImplEstoque();
	private MajuModasDAOModelo bdModelo = new MajuModasDAOImplModelo();
	private MajuModasDAOVenda bdVenda  = new MajuModasDAOImplVenda();

	public Set<Modelo> buscarModelos() {
		return  bdModelo.buscarModeloInfoBasica();
	}
	
	public void adicionarVenda(Venda venda){
		bdVenda.adicionar(venda);
	}

	public Set<Estoque> buscarEstoque(Modelo modelo) {
		return bdEstoque.buscarEstoque(modelo);
	}

	public void atualizarEstoque(Estoque estoque, int idModelo) {
		bdEstoque.alterar(estoque,idModelo);
		
	}

}
