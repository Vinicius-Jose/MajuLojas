package model;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Modelo {

	private int codigo;
	
	private String modelo;
	
	private float custoConfeccao;
	
	private float margemCusto;
	
	private Piloto piloto;
	
	private Modelagem modelagem;
	
	private CorteCostura corteCostura;
	
	private float valorVenda;
	
	private Date dtCastastroPeca;
	
	private Set<Estoque> pecaEstoque;
	
	private Set<ItemPeca> itemPeca;
	
	private Tecido tecido;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getCustoConfeccao() {
		Iterator<ItemPeca> a = itemPeca.iterator();
		while(a.hasNext()){
			ItemPeca b = a.next();
			custoConfeccao+=b.getValorAviamento();
		}
		custoConfeccao+=modelagem.getValor();
		custoConfeccao+=piloto.getValorPiloto();
		custoConfeccao+=corteCostura.getValorCorte();
		custoConfeccao+=corteCostura.getValorCostura();
		return custoConfeccao;
	}

	public void setCustoConfeccao(float custoConfeccao) {
		this.custoConfeccao = custoConfeccao;
	}

	public float getMargemCusto() {
		margemCusto = getCustoConfeccao()/corteCostura.getQuantidadePecasCortadas();
		margemCusto = custoConfeccao * 2;
		return margemCusto;
	}

	public void setMargemCusto(float margemCusto) {
		this.margemCusto = margemCusto;
	}



	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public Modelagem getModelagem() {
		return modelagem;
	}

	public void setModelagem(Modelagem modelagem) {
		this.modelagem = modelagem;
	}

	public CorteCostura getCorteCostura() {
		return corteCostura;
	}

	public void setCorteCostura(CorteCostura corteCostura) {
		this.corteCostura = corteCostura;
	}

	public Date getDtCastastroPeca() {
		return dtCastastroPeca;
	}

	public void setDtCastastroPeca(Date dtCastastroPeca) {
		this.dtCastastroPeca = dtCastastroPeca;
	}
	
	public float getValorVenda() {
		
		return valorVenda;
	}
	
	public Set<Estoque> getEstoque(){
		
		return pecaEstoque;
	}
	
	public void setEstoque(Set<Estoque> pecaEstoque) {
		
		this.pecaEstoque = pecaEstoque;
	}
	
	public Set<ItemPeca> getItemPeca(){
		
		return itemPeca;
	}
	
	public void setItemPeca(Set<ItemPeca> itemPeca) {
		
		this.itemPeca = itemPeca;
	}

	public Tecido getTecido() {
		return tecido;
	}

	public void setTecido(Tecido tecido) {
		this.tecido = tecido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
