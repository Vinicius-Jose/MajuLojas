package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Encomenda;
import model.RelatorioLucro;
import model.Venda;

public interface MajuModasDAORelatorioLucro {

	
	public void adicionar(RelatorioLucro lucro);
	public void remover(Integer codigoVenda);
	public void alterar(RelatorioLucro lucro);
	public int getMaxIdLucro();
	public List<HashMap<String, Object>> buscaDadosLucro(int mes, int ano);
	public double buscarLucro(int mes, int ano);


	
	
	
}
