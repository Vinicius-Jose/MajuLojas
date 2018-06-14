package controller;


import java.text.Collator;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.CorteCostura;
import model.Estoque;
import model.Modelo;
import dao.MajuModasDAO;
import dao.MajuModasDAOImpl;

public class ControleCorteCostura{
	
	private MajuModasDAO bdCorteCostura = new MajuModasDAOImpl();


	public void adicionarCorteCostura(CorteCostura corteCostura){
		bdCorteCostura.adicionar(corteCostura);
		JOptionPane.showMessageDialog(null, "Corte & Costura adicionados com sucesso", "Ssucesso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public CorteCostura buscar(CorteCostura corteCostura){
		List<CorteCostura> listaCorteCostura = bdCorteCostura.buscarCorteCostura();
		return listaCorteCostura.get(0);
	}
	
	public void alterar(CorteCostura corteCostura){
		bdCorteCostura.alterar(corteCostura);
		JOptionPane.showMessageDialog(null, "Corte & Costura alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Modelo> buscarModelos(){
		return bdCorteCostura.buscarModelo();
	}
	
	public void atualizarEstoque(Modelo modelo, String grade){
		Collator col = Collator.getInstance(new Locale ("pt", "BR"));
		Estoque b = null;
		for (Estoque a : modelo.getEstoque()) {
			if(col.compare(a.getGrade(), grade)>1){
				b = a;
			}
		 break;
		}
		bdCorteCostura.alterar(b);
		JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	
}
