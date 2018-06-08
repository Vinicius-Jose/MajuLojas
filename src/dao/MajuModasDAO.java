package dao;

import java.util.List;

import model.Aviamento;
import model.Capital;
import model.Cliente;
import model.CorteCostura;
import model.Encomenda;
import model.Estoque;
import model.Fornecedor;
import model.Grade;
import model.Modelagem;
import model.Modelo;
import model.Motorista;
import model.Piloto;
import model.RelatorioLucro;
import model.Tecido;
import model.Venda;

public interface MajuModasDAO {
	
	public void adicionar(Aviamento aviamento);
	public void Remover(Aviamento aviamento);
	public void Alterar(Aviamento aviamento);
	public List<Aviamento> buscarAviamento();
	
	public void adicionar(Capital capital);
	public void Remover(Capital capital);
	public void Alterar(Capital capital);
	public List<Capital> buscarCapital();
	
	public void adicionar(Cliente cliente);
	public void Remover(Cliente cliente);
	public void Alterar(Cliente cliente);
	public List<Cliente> buscarCliente();
	
	public void adicionar(CorteCostura corteCostura);
	public void Remover(CorteCostura corteCostura);
	public void Alterar(CorteCostura corteCostura);
	public List<CorteCostura> buscarCorteCostura();
	
	public void adicionar(Encomenda encomenda);
	public void Remover(Encomenda encomenda, Integer codigoEncomenda);
	public void Alterar(Encomenda encomenda);
	public List<Encomenda> buscarEncomenda();

	public void adicionar(Estoque estoque);
	public void Remover(Estoque estoque);
	public void Alterar(Estoque estoque);
	public List<Estoque> buscarEstoque();
	
	public void adicionar(Fornecedor fornecedor);
	public void Remover(Fornecedor fornecedor);
	public void Alterar(Fornecedor fornecedor);
	public List<Fornecedor> buscarFornecedor();
	
	public void adicionar(Grade grade);
	public void Remover(Grade grade);
	public void Alterar(Grade grade);
	public List<Grade> buscarGrade();
	
	public void adicionar(Modelagem modelagem);
	public void Remover(Modelagem modelagem);
	public void Alterar(Modelagem modelagem);
	public List<Modelagem> buscarModelagem();
	
	public void adicionar(Modelo modelo);
	public void Remover(Modelo modelo, Integer codigoAviamento);
	public void Alterar(Modelo modelo);
	public List<Modelo> buscarModelo();
	
	public void adicionar(Motorista motorista);
	public void Remover(Motorista motorista);
	public void Alterar(Motorista motorista);
	public List<Motorista> buscarMotorista();
	
	public void adicionar(Piloto piloto);
	public void Remover(Piloto piloto);
	public void Alterar(Piloto piloto);
	public List<Piloto> buscarPiloto();
	
	public void adicionar(RelatorioLucro lucro);
	public void Remover(Integer codigoVenda);
	public void Alterar(RelatorioLucro lucro);
	public List<RelatorioLucro> buscarRelatorioLucro();
	
	public void adicionar(Tecido tecido);
	public void Remover(Tecido tecido);
	public void Alterar(Tecido tecido);
	public List<Tecido> buscarTecido();	
	
	public void adicionar(Venda venda);
	public void Remover(Venda venda);
	public void Alterar(Venda venda);
	public List<Venda> buscarVenda();
	
}
