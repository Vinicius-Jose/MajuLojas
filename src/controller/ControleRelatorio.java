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
import dao.MajuModasDAOCapital;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplCapital;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOImplRelatorioLucro;
import dao.MajuModasDAOModelo;
import dao.MajuModasDAORelatorioLucro;
import dao.RelatorioDao;

public class ControleRelatorio {
	private RelatorioDao rela = new RelatorioDao();
	private MajuModasDAO banco = new MajuModasDAOImpl();
	private MajuModasDAOModelo bdModelo = new MajuModasDAOImplModelo(); 
	private MajuModasDAORelatorioLucro bdLucro = new MajuModasDAOImplRelatorioLucro();
	private MajuModasDAOCapital bdCapital = new MajuModasDAOImplCapital();
//	private MajuModasDAOModelo bancoModelo = new MajuModasDAOImplModelo();
	
	
	public ControleRelatorio() {
		if(ultimoCapital()){
			Set<Modelo> modelo = bdModelo.buscarModeloInfoBasica();
			Set<CorteCostura> corte  = bdCapital.buscarCorte();
			Set<Tecido> tecidos  = bdCapital.buscarTecidos();
			Capital capital = new Capital();
			capital.setCorteCostura(corte);
			capital.setModelo(modelo);
			capital.setTecido(tecidos);
			Date dataAtual = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			capital.setMesAno(new java.sql.Date(dataAtual.getTime()));
			bdCapital.adicionar(capital);
			capital.setCodigo(rela.getMaxIdCapital());
			Set<Venda> vendas = bdCapital.buscarVenda();
			Set<Encomenda> encomendas = bdCapital.buscarEncomendas();
			RelatorioLucro lucro = new RelatorioLucro();
			lucro.setVenda(vendas);
			lucro.setEncomenda(encomendas);
			lucro.setCapital(capital);
			lucro.setCodigo(bdLucro.getMaxIdLucro());
			lucro.setMesAno(new java.sql.Date(dataAtual.getTime()));
			bdLucro.adicionar(lucro);
		}
	}

	public List<Integer> mesesCapital(){
		return bdCapital.buscaMesesCapital();
	}
	
	public List<Integer> anosCapital(){
		return bdCapital.buscaAnoCapital();
	}
	
	public double buscarCapital(int mes, int ano){
		return bdCapital.buscarCapital(mes, ano);
	}
	
	public List<HashMap<String,Object>> buscaDadosCapital(int mes, int ano){
		return bdCapital.buscaDadosCapital(mes, ano);
	}
	
	private boolean ultimoCapital(){
		return bdCapital.ultimoCapital();
	}

	public double buscarLucro(int mes, int ano) {
		return bdLucro.buscarLucro(mes, ano);
	}

	public List<HashMap<String, Object>> buscaDadosLucro(int mes, int ano) {
		return bdLucro.buscaDadosLucro(mes, ano);
	}
}
