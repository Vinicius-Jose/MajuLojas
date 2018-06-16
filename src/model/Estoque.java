/**
 * @author Suzana Portilho
 * 
 */



package model;

public class Estoque {
	

	private int quantidade;
	private Grade grade;
	

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	
	
	@Override
	public String toString() {
		return grade.getLetra();
	}
}
