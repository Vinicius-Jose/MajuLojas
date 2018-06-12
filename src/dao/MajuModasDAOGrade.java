package dao;

import java.util.List;

import model.Grade;

public interface MajuModasDAOGrade {
	
	
	public void adicionar(Grade grade);
	public void remover(Grade grade);
	public void alterar(Grade grade);
	public List<Grade> buscarGrade();
	
	
}
