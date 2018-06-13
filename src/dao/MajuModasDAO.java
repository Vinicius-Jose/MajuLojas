package dao;

import java.util.List;
import java.util.Set;

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

	public boolean verificarUsuario(String usuario, String senha);
	
	public void adicionar(Aviamento aviamento);
	public void remover(Aviamento aviamento);
	public void alterar(Aviamento aviamento);
	public List<Aviamento> buscarAviamento();
	
	public void adicionar(Capital capital);
	public void remover(Capital capital);
	public void alterar(Capital capital);
	public List<Capital> buscarCapital();
	
	public void adicionar(Cliente cliente);
	public void remover(Cliente cliente);
	public void alterar(Cliente cliente);
	public List<Cliente> buscarCliente();
	
	public void adicionar(CorteCostura corteCostura);
	public void remover(CorteCostura corteCostura);
	public void alterar(CorteCostura corteCostura);
	public List<CorteCostura> buscarCorteCostura();
	
	public void adicionar(Encomenda encomenda);
	public void remover(Encomenda encomenda, Integer codigoEncomenda);
	public void alterar(Encomenda encomenda);
	public List<Encomenda> buscarEncomenda();

	public void adicionar(Estoque estoque);
	public void remover(Estoque estoque);
	public void alterar(Estoque estoque);
	public List<Estoque> buscarEstoque();
	
	public void adicionar(Fornecedor fornecedor);
	public void remover(Fornecedor fornecedor);
	public void alterar(Fornecedor fornecedor);
	public List<Fornecedor> buscarFornecedor();
	
	public void adicionar(Grade grade);
	public void remover(Grade grade);
	public void alterar(Grade grade);
	public List<Grade> buscarGrade();
	
	public void adicionar(Modelagem modelagem);
	public void remover(Modelagem modelagem);
	public void alterar(Modelagem modelagem);
	public List<Modelagem> buscarModelagem();
	
	public void adicionar(Modelo modelo);
	public void remover(Modelo modelo, Integer codigoAviamento);
	public void alterar(Modelo modelo);
	public List<Modelo> buscarModelo();
	
	public void adicionar(Motorista motorista);
	public void remover(Motorista motorista);
	public void alterar(Motorista motorista);
	public List<Motorista> buscarMotorista();
	
	public void adicionar(Piloto piloto);
	public void remover(Piloto piloto);
	public void alterar(Piloto piloto);
	public List<Piloto> buscarPiloto();
	
	public void adicionar(RelatorioLucro lucro);
	public void remover(Integer codigoVenda);
	public void alterar(RelatorioLucro lucro);
	public List<RelatorioLucro> buscarRelatorioLucro();
	
	public void adicionar(Tecido tecido);
	public void remover(Tecido tecido);
	public void alterar(Tecido tecido);
	public List<Tecido> buscarTecido();	
	
	public void adicionar(Venda venda);
	public void remover(Venda venda);
	public void alterar(Venda venda);
	public List<Venda> buscarVenda();

	Set<Modelo> buscarModelo1();

	Aviamento buscaEspecifico(Aviamento aviamento);
	
}
