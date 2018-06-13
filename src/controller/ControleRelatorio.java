package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import model.Capital;
import model.CorteCostura;
import model.Encomenda;
import model.Modelo;
import model.RelatorioLucro;
import model.Tecido;
import model.Venda;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import dao.RelatorioDao;

public class ControleRelatorio {
	private RelatorioDao rela = new RelatorioDao();
	private MajuModasDAO banco = new MajuModasDAOImpl();
//	private MajuModasDAOModelo bancoModelo = new MajuModasDAOImplModelo();
	
	
	public ControleRelatorio() {
		if(ultimoCapital()){
			Set<Modelo> modelo =(Set<Modelo>) banco.buscarModelo1();
			Set<CorteCostura> corte  = rela.buscarCorte();
			Set<Tecido> tecidos  = rela.buscarTecidos();
			Capital capital = new Capital();
			capital.setCorteCostura(corte);
			capital.setModelo(modelo);
			capital.setTecido(tecidos);
			Date dataAtual = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			capital.setMesAno(new java.sql.Date(dataAtual.getTime()));
			banco.adicionar(capital);
			capital.setCodigo(rela.getMaxIdCapital());
			Set<Venda> vendas = rela.buscarVenda();
			Set<Encomenda> encomendas = rela.buscarEncomendas();
			RelatorioLucro lucro = new RelatorioLucro();
			lucro.setVenda(vendas);
			lucro.setEncomenda(encomendas);
			lucro.setCapital(capital);
			lucro.setCodigo(rela.getMaxIdLucro());
			lucro.setMesAno(new java.sql.Date(dataAtual.getTime()));
			banco.adicionar(lucro);
		}
	}

	public List<Integer> mesesCapital(){
		return rela.buscaMesesCapital();
	}
	
	public List<Integer> anosCapital(){
		return rela.buscaAnoCapital();
	}
	
	public double buscarCapital(int mes, int ano){
		return rela.buscarCapital(mes, ano);
	}
	
	public List<HashMap<String,Object>> buscaDadosCapital(int mes, int ano){
		return rela.buscaDadosCapital(mes, ano);
	}
	
	private boolean ultimoCapital(){
		return rela.ultimoCapital();
	}

	public double buscarLucro(int mes, int ano) {
		return rela.buscarLucro(mes, ano);
	}

	public List<HashMap<String, Object>> buscaDadosLucro(int mes, int ano) {
		return rela.buscaDadosLucro(mes, ano);
	}
}
