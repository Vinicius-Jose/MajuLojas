package model;

public enum Status {
	
	RETIRADO, ARETIRAR, EMPRODUCAO, CANCELADO;

	private String valorEnum;

	public String getValorEnum() {
		return valorEnum;
	}

	public void setStatus(String valorEnum) {
		this.valorEnum = valorEnum;
	}
	
}
