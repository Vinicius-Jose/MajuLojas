package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.text.MaskFormatter;

import controller.ControleCorteCostura;
import model.CorteCostura;
import model.Modelo;

import javax.swing.JButton;
import java.awt.Color;

public class FRMCorteCostura extends JPanel implements ActionListener{
	private JTextField txtGrade;
	private JTextField txtQtd;
	private JTextField txtCorte;
	private JTextField txtCostura;
	private JComboBox cbModelo;
	private JFormattedTextField fttData;
	private JButton btnPesquisar, btnCancelar, btnAtualizarEstoque, btnSalvar;
	private ControleCorteCostura ctrlCorteCostura = new ControleCorteCostura();

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMCorteCostura() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);
		
		JLabel lblCorte = new JLabel("Corte & Costura");
		lblCorte.setForeground(Color.BLACK);
		lblCorte.setBackground(Color.WHITE);
		lblCorte.setBounds(12, 0, 224, 34);
		lblCorte.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblCorte);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 80, 68, 20);
		add(lblModelo);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setForeground(Color.BLACK);
		lblGrade.setBackground(Color.WHITE);
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrade.setBounds(371, 81, 56, 16);
		add(lblGrade);
		
		txtGrade = new JTextField();
		txtGrade.setForeground(Color.BLACK);
		txtGrade.setBackground(Color.WHITE);
		txtGrade.setBounds(439, 78, 26, 22);
		add(txtGrade);
		txtGrade.setColumns(10);
		
		cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(70, 80, 235, 22);
		add(cbModelo);
		
		JLabel lblQuantidadePeasCortadas = new JLabel("Quantidade Pe\u00E7as Cortadas");
		lblQuantidadePeasCortadas.setForeground(Color.BLACK);
		lblQuantidadePeasCortadas.setBackground(Color.WHITE);
		lblQuantidadePeasCortadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadePeasCortadas.setBounds(582, 82, 207, 16);
		add(lblQuantidadePeasCortadas);
		
		fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setForeground(Color.BLACK);
		fttData.setBackground(Color.WHITE);
		fttData.setBounds(629, 183, 83, 22);
		add(fttData);
		
		txtQtd = new JTextField();
		txtQtd.setForeground(Color.BLACK);
		txtQtd.setBackground(Color.WHITE);
		txtQtd.setBounds(801, 80, 41, 22);
		add(txtQtd);
		txtQtd.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.BLACK);
		lblData.setBackground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(568, 185, 48, 16);
		add(lblData);
		
		txtCorte = new JTextField();
		txtCorte.setForeground(Color.BLACK);
		txtCorte.setBackground(Color.WHITE);
		txtCorte.setBounds(168, 180, 116, 22);
		add(txtCorte);
		txtCorte.setColumns(10);
		
		txtCostura = new JTextField();
		txtCostura.setForeground(Color.BLACK);
		txtCostura.setBackground(Color.WHITE);
		txtCostura.setBounds(168, 236, 116, 22);
		add(txtCostura);
		txtCostura.setColumns(10);
		
		JLabel lblPreoDoCorte = new JLabel("Pre\u00E7o do Corte");
		lblPreoDoCorte.setForeground(Color.BLACK);
		lblPreoDoCorte.setBackground(Color.WHITE);
		lblPreoDoCorte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoDoCorte.setBounds(12, 186, 148, 16);
		add(lblPreoDoCorte);
		
		JLabel lblPreoDaCostura = new JLabel("Pre\u00E7o da Costura");
		lblPreoDaCostura.setForeground(Color.BLACK);
		lblPreoDaCostura.setBackground(Color.WHITE);
		lblPreoDaCostura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreoDaCostura.setBounds(12, 242, 148, 16);
		add(lblPreoDaCostura);
		
		btnAtualizarEstoque = new JButton("Atualizar Estoque");
		btnAtualizarEstoque.setForeground(Color.BLACK);
		btnAtualizarEstoque.setBackground(Color.WHITE);
		btnAtualizarEstoque.setBounds(875, 79, 159, 25);
		add(btnAtualizarEstoque);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(633, 538, 97, 25);
		add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(338, 538, 97, 25);
		add(btnCancelar);
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnAtualizarEstoque.addActionListener(this);
		
		preencherCombo();
		
	}
	
	private void preencherCombo() {
		Set<Modelo> a = ctrlCorteCostura.buscarModelos();
		cbModelo.removeAllItems();
		for(Modelo b : a) {
			cbModelo.addItem(b);
		}
	}
	
	private CorteCostura dadosCorteCostura() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		CorteCostura corteCostura = new CorteCostura();
		if(cbModelo.getSelectedItem() != null) {
			Modelo mod = (Modelo) cbModelo.getSelectedItem();
		}
		corteCostura.setletraGrade(txtGrade.getText());
		corteCostura.setQuantidadePecasCortadas(Integer.parseInt(txtQtd.getText()));
		corteCostura.setValorCorte(Float.parseFloat(txtCorte.getText()));
		corteCostura.setValorCostura(Float.parseFloat(txtCostura.getText()));
		try {
			corteCostura.setDataCorte(new java.sql.Date(sdf.parse(fttData.getText()).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return corteCostura;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getActionCommand().equals("Salvar")) {
			try {
				ctrlCorteCostura.adicionarCorteCostura(dadosCorteCostura());
			} catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
			}
			limpaTela();
		}else
		    if(a.getActionCommand().equals("Cancelar")) {
			    limpaTela();
		    }
		    if(a.getActionCommand().equals("Atualizar Estoque")) {
		    	try {
		    		  Modelo mod = new Modelo();
			    	  if(cbModelo.getSelectedItem() != null) {
			             mod = (Modelo) cbModelo.getSelectedItem();
			    	}
			    	String grade = txtGrade.getText();
			    	ctrlCorteCostura.atualizarEstoque(mod, grade, Integer.parseInt(txtQtd.getText()));
			    	limpaTela();
		    	} catch(Exception e) {
		    		e.printStackTrace();
		    		JOptionPane.showMessageDialog(null, "Campos não preenchidos", "Preenchidos", JOptionPane.INFORMATION_MESSAGE);
		    	}   
		    	
		    }	
	}
	
	private void limpaTela() {
		cbModelo.setSelectedIndex(-1);
		txtGrade.setText("");
		txtQtd.setText("");
		txtCorte.setText("");
		txtCostura.setText("");
		fttData.setText(null);
	}
}
