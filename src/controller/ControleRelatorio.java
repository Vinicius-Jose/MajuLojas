package controller;

import java.util.HashMap;
import java.util.List;

import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import dao.RelatorioDao;

public class ControleRelatorio {
	private RelatorioDao rela = new RelatorioDao();
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	
	public ControleRelatorio() {
//		if(ultimoCapital()){
//			Set<Modelo> modelo =(Set<Modelo>) banco.buscarModelo();
//			Set<CorteCostura> corte  = rela.buscarCorte();
//			Set<Tecido> tecidos  = rela.buscarTecidos();
//			Capital capital = new Capital();
//			capital.setCorteCostura(corte);
//			capital.setModelo(modelo);
//			capital.setTecido(tecidos);
//			capital.setMesAno((java.sql.Date) Calendar.getInstance().getTime());
//			banco.adicionar(capital);
//			
//		}
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
