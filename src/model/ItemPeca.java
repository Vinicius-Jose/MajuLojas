package model;

public class ItemPeca {
	
	private int quantidadeAviamento;
	
	private float valorAviamento;

	public int getQuantidadeAviamento() {
		return quantidadeAviamento;
	}

	public void setQuantidadeAviamento(int quantidadeAviamento) {
		this.quantidadeAviamento = quantidadeAviamento;
	}

	public float getValorAviamento() {
		valorAviamento *= quantidadeAviamento;
		return valorAviamento;
	}

	public void setValorAviamento(float valorAviamento) {
		this.valorAviamento = valorAviamento;
	}

}
