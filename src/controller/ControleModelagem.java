package controller;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;
import dao.MajuModasDAOImplModelagem;
import dao.MajuModasDAOModelagem;
import model.Modelagem;
import model.Modelo;

public class ControleModelagem{
	
	private MajuModasDAOModelagem bdModelagem = new MajuModasDAOImplModelagem();
	private MajuModasDAO banco = new MajuModasDAOImpl();
	
	public Set<Modelo> buscarModelo(){
		return banco.buscarModelo1();
	}
	
	public Modelagem buscarModelagem(Modelagem modelagem){
		return bdModelagem.buscarModelagemEspecifica(modelagem);
	}

}

