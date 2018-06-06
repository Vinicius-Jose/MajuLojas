package dao;

import model.*;

public interface MajuModasDAO {
	
	public void adicionar(Aviamento aviamento);
	public void Remover(Aviamento aviamento);
	public void Alterar(Aviamento aviamento);
	
	public void adicionar(Capital capital);
	public void Remover(Capital capital);
	public void Alterar(Capital capital);

	public void adicionar(Cliente cliente);
	public void Remover(Cliente cliente);
	public void Alterar(Cliente cliente);
	
	public void adicionar(CorteCostura corteCostura);
	public void Remover(CorteCostura corteCostura);
	public void Alterar(CorteCostura corteCostura);
	
	public void adicionar(Encomenda encomenda);
	public void Remover(Encomenda encomenda, Integer codigoEncomenda);
	public void Alterar(Encomenda encomenda);

	public void adicionar(Estoque estoque);
	public void Remover(Estoque estoque);
	public void Alterar(Estoque estoque);
	
	public void adicionar(Fornecedor fornecedor);
	public void Remover(Fornecedor fornecedor);
	public void Alterar(Fornecedor fornecedor);
	
	public void adicionar(Grade grade);
	public void Remover(Grade grade);
	public void Alterar(Grade grade);
	
	public void adicionar(Modelagem modelagem);
	public void Remover(Modelagem modelagem);
	public void Alterar(Modelagem modelagem);
	
	public void adicionar(Modelo modelo);
	public void Remover(Modelo modelo, Integer codigoAviamento);
	public void Alterar(Modelo modelo);
	
	public void adicionar(Motorista motorista);
	public void Remover(Motorista motorista);
	public void Alterar(Motorista motorista);
	
	public void adicionar(Piloto piloto);
	public void Remover(Piloto piloto);
	public void Alterar(Piloto piloto);

	public void adicionar(RelatorioLucro lucro);
	public void Remover(Integer codigoVenda);
	public void Alterar(RelatorioLucro lucro);
	
	public void adicionar(Tecido tecido);
	public void Remover(Tecido tecido);
	public void Alterar(Tecido tecido);
	
	public void adicionar(Venda venda);
	public void Remover(Venda venda);
	public void Alterar(Venda venda);
	
}