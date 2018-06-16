package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import model.Aviamento;
import model.ItemPeca;
import model.Modelagem;
import model.Modelo;
import model.Piloto;
import model.Tecido;
import controller.ControleModelo;

public class FRMModelo extends JPanel implements ActionListener {
	private JTextField txtModelo;
	private JTextField txtQtd;
	private JTable tabelaAviamento;
	private JTextField txtModelagem;
	private JTextField qtdRolo;
	private JTextField txtMargemCusto;
	private JTextField txtCustoConfeccao;
	private JTextField txtPiloto;
	private JFormattedTextField fttData;
	private JComboBox cbTecido;
	private JButton btnCancelar, btnSalvar, btnAdicionar;
	private JComboBox cbAviamento;
	private JRadioButton rdbtnNo, rdbtnSim;
	private ControleModelo ctrlModelo = new ControleModelo();

	/**
	 * Create the panel.
	 * 
	 * @throws ParseException
	 */
	public FRMModelo() throws ParseException {
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setBounds(12, 0, 83, 34);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblModelo);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.WHITE);
		separator.setBounds(0, 44, 1034, 11);
		add(separator);

		JLabel lblModelo_1 = new JLabel("Modelo");
		lblModelo_1.setForeground(Color.BLACK);
		lblModelo_1.setBackground(Color.WHITE);
		lblModelo_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo_1.setBounds(10, 68, 69, 16);
		add(lblModelo_1);

		txtModelo = new JTextField();
		txtModelo.setForeground(Color.BLACK);
		txtModelo.setBackground(Color.WHITE);
		txtModelo.setBounds(91, 68, 315, 22);
		add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblNovoModelo = new JLabel("Novo Modelo ?");
		lblNovoModelo.setForeground(Color.BLACK);
		lblNovoModelo.setBackground(Color.WHITE);
		lblNovoModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNovoModelo.setBounds(484, 68, 124, 16);
		add(lblNovoModelo);

		rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setForeground(Color.BLACK);
		rdbtnSim.setBackground(Color.WHITE);
		rdbtnSim.setSelected(true);
		rdbtnSim.setBounds(616, 64, 69, 25);
		add(rdbtnSim);

		rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setForeground(Color.BLACK);
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(713, 64, 69, 25);
		add(rdbtnNo);

		ButtonGroup grupoBotao = new ButtonGroup();
		grupoBotao.add(rdbtnNo);
		grupoBotao.add(rdbtnSim);

		fttData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fttData.setForeground(Color.BLACK);
		fttData.setBackground(Color.WHITE);
		fttData.setBounds(888, 68, 83, 22);

		add(fttData);

		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.BLACK);
		lblData.setBackground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(835, 68, 53, 16);
		add(lblData);

		JLabel lblConfeco = new JLabel("Confec\u00E7\u00E3o");
		lblConfeco.setForeground(Color.BLACK);
		lblConfeco.setBackground(Color.WHITE);
		lblConfeco.setBounds(12, 143, 83, 16);
		add(lblConfeco);

		JLabel lblAviamento = new JLabel("Aviamento");
		lblAviamento.setForeground(Color.BLACK);
		lblAviamento.setBackground(Color.WHITE);
		lblAviamento.setBounds(38, 176, 83, 16);
		add(lblAviamento);

		cbAviamento = new JComboBox();
		cbAviamento.setForeground(Color.BLACK);
		cbAviamento.setBackground(Color.WHITE);
		cbAviamento.setBounds(118, 176, 200, 22);
		add(cbAviamento);

		txtQtd = new JTextField();
		txtQtd.setForeground(Color.BLACK);
		txtQtd.setBackground(Color.WHITE);
		txtQtd.setBounds(428, 173, 47, 22);
		add(txtQtd);
		txtQtd.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(Color.BLACK);
		lblQuantidade.setBackground(Color.WHITE);
		lblQuantidade.setBounds(330, 176, 86, 16);
		add(lblQuantidade);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(511, 172, 97, 25);
		add(btnAdicionar);

		tabelaAviamento = new JTable();
		tabelaAviamento.setFillsViewportHeight(true);
		tabelaAviamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaAviamento.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Aviamento", "Quantidade", "Custo Aviamento",
						"A\u00E7\u00E3o" }) {
			Class[] columnTypes = new Class[] { Aviamento.class, Object.class,
					Object.class, JButton.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			public boolean isCellEditable(int row, int column) {
				if (column == 3)
					return true;
				return false;
			}
		});
		tabelaAviamento.getColumnModel().getColumn(1).setPreferredWidth(252);
		tabelaAviamento.getColumnModel().getColumn(2).setPreferredWidth(107);
		tabelaAviamento.getColumnModel().getColumn(3).setPreferredWidth(188);
		tabelaAviamento.setBounds(38, 289, 570, -53);

		Label lblModelagem = new Label("Modelagem\r\n");
		lblModelagem.setForeground(Color.BLACK);
		lblModelagem.setBackground(Color.WHITE);
		lblModelagem.setBounds(38, 318, 70, 24);
		add(lblModelagem);

		txtModelagem = new JTextField();
		txtModelagem.setForeground(Color.BLACK);
		txtModelagem.setBackground(Color.WHITE);
		txtModelagem.setBounds(117, 320, 116, 22);
		add(txtModelagem);
		txtModelagem.setColumns(10);

		JLabel lblTecido = new JLabel("Tecido");
		lblTecido.setForeground(Color.BLACK);
		lblTecido.setBackground(Color.WHITE);
		lblTecido.setBounds(38, 392, 56, 16);
		add(lblTecido);

		cbTecido = new JComboBox();
		cbTecido.setForeground(Color.BLACK);
		cbTecido.setBackground(Color.WHITE);
		cbTecido.setBounds(91, 389, 200, 22);
		add(cbTecido);

		qtdRolo = new JTextField();
		qtdRolo.setForeground(Color.BLACK);
		qtdRolo.setBackground(Color.WHITE);
		qtdRolo.setBounds(479, 389, 53, 22);
		add(qtdRolo);
		qtdRolo.setColumns(10);

		JLabel lblQuantidadeDeRolos = new JLabel("Quantidade de Rolos");
		lblQuantidadeDeRolos.setForeground(Color.BLACK);
		lblQuantidadeDeRolos.setBackground(Color.WHITE);
		lblQuantidadeDeRolos.setBounds(330, 392, 145, 16);
		add(lblQuantidadeDeRolos);

		JLabel lblMargemDeCusto = new JLabel("Margem de Custo");
		lblMargemDeCusto.setForeground(Color.BLACK);
		lblMargemDeCusto.setBackground(Color.WHITE);
		lblMargemDeCusto.setBounds(12, 531, 116, 16);
		add(lblMargemDeCusto);

		txtMargemCusto = new JTextField();
		txtMargemCusto.setForeground(Color.BLACK);
		txtMargemCusto.setBackground(Color.WHITE);
		txtMargemCusto.setBounds(133, 528, 116, 22);
		add(txtMargemCusto);
		txtMargemCusto.setColumns(10);

		JLabel lblCustoDeConfeco = new JLabel("Custo de Confec\u00E7\u00E3o");
		lblCustoDeConfeco.setForeground(Color.BLACK);
		lblCustoDeConfeco.setBackground(Color.WHITE);
		lblCustoDeConfeco.setBounds(402, 531, 139, 16);
		add(lblCustoDeConfeco);

		txtCustoConfeccao = new JTextField();
		txtCustoConfeccao.setForeground(Color.BLACK);
		txtCustoConfeccao.setBackground(Color.WHITE);
		txtCustoConfeccao.setBounds(553, 528, 116, 22);
		add(txtCustoConfeccao);
		txtCustoConfeccao.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(733, 195, 97, 25);
		add(btnSalvar);

		btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(733, 350, 97, 25);
		add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 211, 494, 83);
		scrollPane.setViewportView(tabelaAviamento);
		add(scrollPane);

		JLabel lblPiloto = new JLabel("Piloto");
		lblPiloto.setForeground(Color.BLACK);
		lblPiloto.setBackground(Color.WHITE);
		lblPiloto.setBounds(310, 328, 70, 10);
		add(lblPiloto);

		txtPiloto = new JTextField();
		txtPiloto.setForeground(Color.BLACK);
		txtPiloto.setBackground(Color.WHITE);
		txtPiloto.setBounds(369, 322, 86, 20);
		add(txtPiloto);
		txtPiloto.setColumns(10);

		preencherCombo();

		
		txtMargemCusto.setEditable(false);
		txtCustoConfeccao.setEditable(false);
		rdbtnSim.addActionListener(this);
		rdbtnNo.addActionListener(this);
		btnAdicionar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnSalvar.addActionListener(this);

	}

	private void preencherCombo() {
		cbAviamento.removeAllItems();
		cbTecido.removeAllItems();
		for (Aviamento a : ctrlModelo.buscarAviamentos()) {
			cbAviamento.addItem(a);
		}

		for (Tecido a : ctrlModelo.buscarTecidos()) {
			cbTecido.addItem(a);
		}
		cbTecido.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Sim")) {
			txtModelagem.setEnabled(true);
			txtPiloto.setEnabled(true);
		} else if (a.getActionCommand().equals("Não")) {
			txtModelagem.setEnabled(false);
			txtPiloto.setEnabled(false);
		} else if (a.getActionCommand().equals("Adicionar")) {
			Aviamento av = (Aviamento) cbAviamento.getSelectedItem();
			cbAviamento.removeItem(av);
			try {
				int qtd = Integer.parseInt(txtQtd.getText());
				adicionarItemTabela(av, qtd);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Dados nao preenchidos corretamente", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (a.getActionCommand().equals("Salvar")) {
			try {
				salvarModelo(txtModelagem.isEnabled());
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			limparTela();
		} else if (a.getActionCommand().contains("Cancelar")) {
			limparTela();
		}

	}

	private void limparTela() {
		txtModelagem.setText("");
		txtModelo.setText("");
		txtMargemCusto.setText("");
		txtCustoConfeccao.setText("");
		txtQtd.setText("");
		preencherCombo();
		fttData.setText("");
	    ((DefaultTableModel)tabelaAviamento.getModel()).setRowCount(0);
	    qtdRolo.setText("");
	    txtPiloto.setText("");
	}

	private void salvarModelo(boolean novo) throws ParseException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Modelo mod = new Modelo();
			mod.setModelo(txtModelo.getText());
			Modelagem modelagem = new Modelagem();
			Piloto piloto = new Piloto();
			if (novo) {
				modelagem.setDataModelagem(new java.sql.Date(sdf.parse(
						fttData.getText()).getTime()));
				modelagem.setValor(Float.parseFloat(txtModelagem.getText()));
				piloto.setDataPiloto(new java.sql.Date(sdf.parse(
						fttData.getText()).getTime()));
				piloto.setValorPiloto(Float.parseFloat(txtPiloto.getText()));
				mod.setPiloto(piloto);
				mod.setModelagem(modelagem);
			}
			mod.setPiloto(piloto);
			mod.setModelagem(modelagem);
			mod.setDtCastastroPeca(new java.sql.Date(sdf.parse(
					fttData.getText()).getTime()));
			Set<ItemPeca> itens = new HashSet<>();
			
			for (int i = 0; i < tabelaAviamento.getRowCount(); i++) {
				ItemPeca item = new ItemPeca();
				item.setAviamento(ctrlModelo.buscarAviamentoEspecifico(tabelaAviamento
						.getValueAt(i, 0).toString()));
				item.setQuantidadeAviamento((int) tabelaAviamento.getValueAt(i,
						1));
				itens.add(item);
			}
			mod.setItemPeca(itens);
			Tecido tecido = (Tecido) cbTecido.getSelectedItem();
			tecido.setQuantidade(Integer.parseInt(qtdRolo.getText()));
			mod.setTecido(tecido);
			txtCustoConfeccao.setText(Float.toString(mod.getCustoConfeccao()));
			txtMargemCusto.setText(Float.toString(mod.getMargemCusto()));
			
			ctrlModelo.adicionarModelo(mod);
			limparTela();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Campos Obrigatórios estão vazios");
			e.printStackTrace();
		}

	}

	private void adicionarItemTabela(Aviamento av, int qtd) {
		final DefaultTableModel mdtab = (DefaultTableModel) tabelaAviamento
				.getModel();
		Object[] linha = new Object[4];
		linha[0] = av.getNome();
		linha[1] = qtd;
		linha[2] = av.getValorCompra();
		BotaoParaTabela btt = new BotaoParaTabela(tabelaAviamento, 3);
		final JButton btnApagar = btt.getBotao();
		btnApagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				cbAviamento.addItem(ctrlModelo
						.buscarAviamentoEspecifico(tabelaAviamento.getValueAt(
								tabelaAviamento.getSelectedRow(), 0).toString()));
				mdtab.removeRow(tabelaAviamento.getSelectedRow());
				btnApagar.setVisible(false);
				btnApagar.setEnabled(false);
				tabelaAviamento.remove(btnApagar);
			}
		});

		mdtab.addRow(linha);
		txtQtd.setText("");
	}
}




// Classe que adiciona o botao na tabela
class BotaoParaTabela extends AbstractCellEditor implements TableCellRenderer,
		TableCellEditor {
	JTable table;
	JButton renderButton;
	JButton editButton;
	String text;

	public BotaoParaTabela(JTable table, int column) {
		this.table = table;
		renderButton = new JButton();
		editButton = new JButton();
		editButton.setFocusPainted(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer(this);
		columnModel.getColumn(column).setCellEditor(this);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (hasFocus) {
			renderButton.setForeground(Color.RED);
			renderButton.setBackground(UIManager.getColor("Button.background"));
		} else if (isSelected) {
			renderButton.setForeground(Color.RED);
			renderButton.setBackground(table.getSelectionBackground());
		} else {
			renderButton.setForeground(Color.RED);
			renderButton.setBackground(UIManager.getColor("Button.background"));
		}
		renderButton.setText("X");
		return renderButton;
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		editButton.setText(text);
		return editButton;
	}

	public Object getCellEditorValue() {
		return text;
	}

	public JButton getBotao() {
		return editButton;
	}

}
