package dao;

import java.util.List;

import model.RelatorioLucro;

public interface MajuModasDAORelatorioLucro {

	
	public void adicionar(RelatorioLucro lucro);
	public void remover(Integer codigoVenda);
	public void alterar(RelatorioLucro lucro);
	public List<RelatorioLucro> buscarRelatorioLucro();
	
	
	
}
