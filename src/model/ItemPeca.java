package model;

public class ItemPeca {
	
	private int quantidadeAviamento;
	
	private float valorAviamento;
	
	private Aviamento aviamento;

	public int getQuantidadeAviamento() {
		return quantidadeAviamento;
	}

	public void setQuantidadeAviamento(int quantidadeAviamento) {
		this.quantidadeAviamento = quantidadeAviamento;
	}

	public float getValorAviamento() {
		if(valorAviamento == 0){
			valorAviamento = aviamento.getValorCompra()* quantidadeAviamento;
		}
		return valorAviamento;
	}

	public void setValorAviamento(float valorAviamento) {
		this.valorAviamento = valorAviamento;
	}

	public Aviamento getAviamento() {
		return aviamento;
	}

	public void setAviamento(Aviamento aviamento) {
		this.aviamento = aviamento;
	}
}
