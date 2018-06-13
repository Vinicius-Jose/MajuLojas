package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import model.ItemVenda;
import model.Modelo;
import model.Venda;
import controller.ControleVenda;

public class FRMVenda extends JPanel implements ActionListener {
	private JTextField txtQtd;
	private JTable tabelaVenda;
	private JTextField txtValortotal;
	private JFormattedTextField fttDataEncomenda;
	private JComboBox cbModelo;
	private JButton btnAdicionar, btnFinalizar,btnCancelar ;
	private ControleVenda ctrlVenda = new ControleVenda();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public FRMVenda() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblVenda = new JLabel("Venda");
		lblVenda.setForeground(Color.BLACK);
		lblVenda.setBackground(Color.WHITE);
		lblVenda.setBounds(12, 0, 224, 34);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblVenda);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);

		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.BLACK);
		lblData.setBackground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(736, 108, 61, 14);
		add(lblData);
		
		fttDataEncomenda = new JFormattedTextField(
				new MaskFormatter("##/##/####"));
		fttDataEncomenda.setForeground(Color.BLACK);
		fttDataEncomenda.setBackground(Color.WHITE);
		fttDataEncomenda.setBounds(791, 106, 83, 22);
		add(fttDataEncomenda);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(12, 114, 63, 14);
		add(lblModelo);

		cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(85, 111, 168, 20);
		add(cbModelo);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(Color.BLACK);
		lblQuantidade.setBackground(Color.WHITE);
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidade.setBounds(309, 116, 103, 17);
		add(lblQuantidade);
		
		txtQtd = new JTextField();
		txtQtd.setForeground(Color.BLACK);
		txtQtd.setBackground(Color.WHITE);
		txtQtd.setBounds(439, 113, 46, 20);
		add(txtQtd);
		txtQtd.setColumns(10);
		
		tabelaVenda = new JTable();
		tabelaVenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Modelo", "Qtd", "Valor"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Modelo.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaVenda.getColumnModel().getColumn(0).setResizable(false);
		tabelaVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tabelaVenda.setBounds(38, 197, 588, 159);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 197, 495, 159);
		add(scrollPane);
		scrollPane.setViewportView(tabelaVenda);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(509, 112, 89, 23);
		add(btnAdicionar);
		
		txtValortotal = new JTextField();
		txtValortotal.setForeground(Color.BLACK);
		txtValortotal.setBackground(Color.WHITE);
		txtValortotal.setBounds(446, 412, 86, 20);
		add(txtValortotal);
		txtValortotal.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setForeground(Color.BLACK);
		lblValorTotal.setBackground(Color.WHITE);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(351, 413, 89, 14);
		add(lblValorTotal);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(153, 539, 112, 23);
		add(btnCancelar);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(Color.BLACK);
		btnFinalizar.setBackground(Color.WHITE);
		btnFinalizar.setBounds(351, 539, 112, 23);
		add(btnFinalizar);
		
		btnAdicionar.addActionListener(this);
		fttDataEncomenda.setEditable(false);
		fttDataEncomenda.setText(sdf.format(Calendar.getInstance().getTime()));
		
		btnFinalizar.addActionListener(this);
		btnCancelar.addActionListener(this);
		preencherCombo();
	}
	
	
	private void preencherCombo() {
		Set<Modelo> mod  = ctrlVenda.buscarModelos();
		cbModelo.removeAllItems();
		for(Modelo a : mod ){
			cbModelo.addItem(a);
		}

	}


	@Override
	public void actionPerformed(ActionEvent a) {
		DefaultTableModel df = (DefaultTableModel) tabelaVenda.getModel();
		if(a.getActionCommand().equals("Adicionar")){
			adicionarItemTabela(df);
			txtQtd.setText("");
		}else if(a.getActionCommand().equals("Finalizar")){
		   try {
			ctrlVenda.adicionarVenda(montarVenda());
			limparTela();
		   } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (a.getActionCommand().equals("Cancelar")){
			limparTela();
		}
	}


	private void limparTela() {
		txtQtd.setText("");
		txtValortotal.setText("");
		tabelaVenda.revalidate();
		DefaultTableModel md = (DefaultTableModel) tabelaVenda.getModel();
		for(int i = 0; i< md.getRowCount(); i ++){
			md.removeRow(i);
		}
		
	}


	private Venda montarVenda() throws ParseException {
		Venda venda = new Venda();
		venda.setDtVenda(new java.sql.Date (sdf.parse(fttDataEncomenda.getText()).getTime()));
		venda.setValorTotal(Float.parseFloat(txtValortotal.getText()));
		List<ItemVenda> itens = new LinkedList<>();
		for(int i = 0; i<tabelaVenda.getRowCount(); i++){
			ItemVenda item = new ItemVenda();
			item.setQuantidade((int) tabelaVenda.getValueAt(i,1));
			item.setModelo((Modelo) tabelaVenda.getValueAt(i,0));
			item.setValorTotalPeca((float) tabelaVenda.getValueAt(i, 2));
			itens.add(item);
		}
		venda.setItemVenda(itens);
		return venda;
	}


	private void adicionarItemTabela(DefaultTableModel df) {
		Object[] linha = new Object[3];
		linha[0] = cbModelo.getSelectedItem();
		linha[1] = Integer.parseInt(txtQtd.getText());
		linha[2] = (((Modelo) cbModelo.getSelectedItem()).getMargemCusto()) * Integer.parseInt(txtQtd.getText());
		df.addRow(linha);
		float valor = 0;
		for(int i = 0; i<tabelaVenda.getRowCount(); i++){
			valor += Float.parseFloat((tabelaVenda.getValueAt(i,2).toString()));
		}
		txtValortotal.setText(Float.toString(valor));
	}
}
