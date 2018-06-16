/**
 * @autor Vinícius José
 */
package controller;


import java.text.Collator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.swing.JOptionPane;

import model.CorteCostura;
import model.Estoque;
import model.Modelo;
import dao.MajuModasDAOCorteCostura;
import dao.MajuModasDAOEstoque;
import dao.MajuModasDAOImplCorteCostura;
import dao.MajuModasDAOImplEstoque;
import dao.MajuModasDAOImplModelo;
import dao.MajuModasDAOModelo;

public class ControleCorteCostura{
	
	private MajuModasDAOCorteCostura bdCorteCostura = new MajuModasDAOImplCorteCostura();
	private MajuModasDAOEstoque bdEstoque = new MajuModasDAOImplEstoque();
	private MajuModasDAOModelo bdModelo = new MajuModasDAOImplModelo();

	public void adicionarCorteCostura(CorteCostura corteCostura){
		bdCorteCostura.adicionar(corteCostura);
		JOptionPane.showMessageDialog(null, "Corte & Costura adicionados com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public CorteCostura buscar(CorteCostura corteCostura){
		List<CorteCostura> listaCorteCostura = bdCorteCostura.buscarCorteCostura();
		return listaCorteCostura.get(0);
	}
	
	public void alterar(CorteCostura corteCostura){
		bdCorteCostura.alterar(corteCostura);
		JOptionPane.showMessageDialog(null, "Corte & Costura alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Set<Modelo> buscarModelos(){
		return bdModelo.buscarModeloInfoBasica();
	}
	
	public void atualizarEstoque(Modelo modelo, String grade, int qtd){
		Collator col = Collator.getInstance(new Locale ("pt", "BR"));
		Estoque b = null;
		modelo.setEstoque(bdEstoque.buscarEstoque(modelo));
		for (Estoque a : modelo.getEstoque()) {
			if(col.compare(a.getGrade().getLetra(), grade)>=1){
				b = a;
				b.setQuantidade(b.getQuantidade() + qtd);
			}
		}
		if(b!= null)bdEstoque.alterar(b, modelo.getCodigo());
		else JOptionPane.showMessageDialog(null, "Erro ao atualizar o estoque", "Erro", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	}

	
}
