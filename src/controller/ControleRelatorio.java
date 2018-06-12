package controller;

import java.util.HashMap;
import java.util.List;

import model.Capital;

import dao.RelatorioDao;

public class ControleRelatorio {
	private RelatorioDao rela = new RelatorioDao();
	
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
}
