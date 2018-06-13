package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import javax.swing.JRadioButton;

import controller.ControleEncomenda;

import model.Cliente;
import model.Encomenda;
import model.ItemEncomenda;
import model.ItemVenda;
import model.Modelo;
import model.Motorista;
import model.Status;
import java.awt.Color;

public class FRMEncomenda extends JPanel implements ActionListener {
	private JTextField txtQtd;
	private JTable tabelaEncomenda;
	private JLabel lblMotorista;
	private JComboBox cbMotorista, cbModelo;
	private JRadioButton rdbtnSim, rdbtnNo;
	private JButton btnPesquisar, btnFinalizarEncomenda, btnAdicionar,
			btnCancelar;
	private JComboBox cbCliente;
	private JFormattedTextField fttDataRetirada, fttDataEncomenda;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private ControleEncomenda ctrlEncomenda = new ControleEncomenda();
	Status[] status = new Status[] { Status.ARETIRAR, Status.CANCELADO,
			Status.EMPRODUCAO, Status.RETIRADO };
	JComboBox<Status> cbStatus = new JComboBox(status);

	/**
	 * Create the panel.
	 * 
	 * @throws ParseException
	 */
	public FRMEncomenda() throws ParseException {
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setBounds(0, 31, 1040, 660);
		setLayout(null);

		JLabel lblEncomenda = new JLabel("Encomenda");
		lblEncomenda.setForeground(Color.BLACK);
		lblEncomenda.setBackground(Color.WHITE);
		lblEncomenda.setBounds(12, 0, 224, 34);
		lblEncomenda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		add(lblEncomenda);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 44, 1034, 11);
		add(separator);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.BLACK);
		lblCliente.setBackground(Color.WHITE);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCliente.setBounds(12, 74, 99, 14);
		add(lblCliente);

		cbCliente = new JComboBox();
		cbCliente.setForeground(Color.BLACK);
		cbCliente.setBackground(Color.WHITE);
		cbCliente.setBounds(102, 73, 168, 20);
		add(cbCliente);

		JLabel lblDataDaEncomenda = new JLabel("Data da Encomenda");
		lblDataDaEncomenda.setForeground(Color.BLACK);
		lblDataDaEncomenda.setBackground(Color.WHITE);
		lblDataDaEncomenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaEncomenda.setBounds(10, 185, 160, 14);
		add(lblDataDaEncomenda);

		fttDataEncomenda = new JFormattedTextField(new MaskFormatter(
				"##/##/####"));
		fttDataEncomenda.setForeground(Color.BLACK);
		fttDataEncomenda.setBackground(Color.WHITE);
		fttDataEncomenda.setBounds(168, 183, 83, 22);
		add(fttDataEncomenda);

		JLabel lblDataDaRetirada = new JLabel("Data da Retirada");
		lblDataDaRetirada.setForeground(Color.BLACK);
		lblDataDaRetirada.setBackground(Color.WHITE);
		lblDataDaRetirada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaRetirada.setBounds(299, 185, 132, 14);
		add(lblDataDaRetirada);

		fttDataRetirada = new JFormattedTextField(new MaskFormatter(
				"##/##/####"));
		fttDataRetirada.setForeground(Color.BLACK);
		fttDataRetirada.setBackground(Color.WHITE);
		fttDataRetirada.setBounds(441, 183, 83, 22);
		add(fttDataRetirada);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(10, 240, 63, 14);
		add(lblModelo);

		cbModelo = new JComboBox();
		cbModelo.setForeground(Color.BLACK);
		cbModelo.setBackground(Color.WHITE);
		cbModelo.setBounds(83, 237, 187, 20);
		add(cbModelo);

		JLabel lblQuantidadeEncomendada = new JLabel("Quantidade Encomendada");
		lblQuantidadeEncomendada.setForeground(Color.BLACK);
		lblQuantidadeEncomendada.setBackground(Color.WHITE);
		lblQuantidadeEncomendada.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeEncomendada.setBounds(299, 236, 199, 23);
		add(lblQuantidadeEncomendada);

		txtQtd = new JTextField();
		txtQtd.setForeground(Color.BLACK);
		txtQtd.setBackground(Color.WHITE);
		txtQtd.setBounds(521, 239, 35, 20);
		add(txtQtd);
		txtQtd.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 293, 682, 211);
		add(scrollPane);

		tabelaEncomenda = new JTable();
		tabelaEncomenda.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Cliente", "Modelo", "Qtd.", "Encomenda",
						"Retirada", "Status", "Valor Total" }) {
			Class[] columnTypes = new Class[] { Cliente.class, Modelo.class,
					Integer.class, Object.class, Object.class, Status.class,
					Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaEncomenda.getColumnModel().getColumn(0).setPreferredWidth(179);
		tabelaEncomenda.getColumnModel().getColumn(1).setPreferredWidth(193);
		tabelaEncomenda.getColumnModel().getColumn(3).setPreferredWidth(91);
		tabelaEncomenda.getColumnModel().getColumn(4).setPreferredWidth(83);
		scrollPane.setViewportView(tabelaEncomenda);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(568, 237, 89, 23);
		add(btnAdicionar);

		btnFinalizarEncomenda = new JButton("Finalizar Encomenda");
		btnFinalizarEncomenda.setForeground(Color.BLACK);
		btnFinalizarEncomenda.setBackground(Color.WHITE);
		btnFinalizarEncomenda.setBounds(793, 290, 151, 23);
		add(btnFinalizarEncomenda);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(793, 392, 151, 23);
		add(btnCancelar);

		lblMotorista = new JLabel("Motorista");
		lblMotorista.setForeground(Color.BLACK);
		lblMotorista.setBackground(Color.WHITE);
		lblMotorista.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMotorista.setBounds(12, 129, 89, 14);
		add(lblMotorista);

		cbMotorista = new JComboBox();
		cbMotorista.setForeground(Color.BLACK);
		cbMotorista.setBackground(Color.WHITE);
		cbMotorista.setBounds(111, 128, 206, 20);
		add(cbMotorista);

		JLabel lblRetiradaNaLoja = new JLabel("Retirada na Loja ?");
		lblRetiradaNaLoja.setForeground(Color.BLACK);
		lblRetiradaNaLoja.setBackground(Color.WHITE);
		lblRetiradaNaLoja.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetiradaNaLoja.setBounds(497, 76, 158, 14);
		add(lblRetiradaNaLoja);

		rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setForeground(Color.BLACK);
		rdbtnSim.setBackground(Color.WHITE);
		rdbtnSim.setSelected(true);
		rdbtnSim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSim.setBounds(661, 70, 71, 23);
		add(rdbtnSim);

		rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.setForeground(Color.BLACK);
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNo.setBounds(740, 70, 109, 23);
		add(rdbtnNo);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNo);
		grupo.add(rdbtnSim);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(294, 70, 97, 25);
		add(btnPesquisar);

		preencherCombo();
		btnAdicionar.addActionListener(this);
		btnFinalizarEncomenda.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
		lblMotorista.setEnabled(false);
		cbMotorista.setEnabled(false);
		lblMotorista.setVisible(false);
		cbMotorista.setVisible(false);

		rdbtnSim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblMotorista.setVisible(false);
				cbMotorista.setVisible(false);
			}
		});

		rdbtnNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblMotorista.setVisible(true);
				cbMotorista.setVisible(true);
				cbMotorista.setEnabled(true);
				lblMotorista.setEnabled(true);
			}
		});

		fttDataEncomenda.setText(sdf.format(Calendar.getInstance().getTime()));
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Pesquisar")) {
			adicionarDadoTabela(ctrlEncomenda
					.buscarEncomendas((Cliente) cbCliente.getSelectedItem()));
		} else if (a.getActionCommand().equals("Adicionar")) {
			adicionarDadoTabela();
		} else if (a.getActionCommand().equals("Cancelar")) {
			limpaTela();
		} else if (a.getActionCommand().contains("Finalizar"))
			try {
				ctrlEncomenda.finalizarEncomenda(montarEncomenda());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void preencherCombo() {
		cbCliente.removeAllItems();
		cbMotorista.removeAllItems();
		cbModelo.removeAllItems();
		for (Motorista a : ctrlEncomenda.buscarMotoristas()) {
			cbMotorista.addItem(a);
		}
		for (Cliente a : ctrlEncomenda.buscarClientes()) {
			cbCliente.addItem(a);
		}
		for (Modelo a : ctrlEncomenda.buscarModelos()) {
			cbModelo.addItem(a);
		}
	}

	private void adicionarDadoTabela(List<Encomenda> encomendas) {
		for (Encomenda a : encomendas) {
			Object linha[] = new Object[7];
			linha[0] = a.getCliente();
			linha[3] = a.getDataEncomenda();
			comboBoxTabela(a.getStatus());
			try {
				String data = (sdf.format(a.getDataRetirada()));
				linha[4] = data;
			} catch (Exception e) {
				linha[4] = null;
			}
			for (ItemEncomenda b : a.getItemEncomenda()) {
				linha[1] = b.getModelo();
				linha[2] = b.getQuantidade();
				linha[6] = b.getValorItemEncomenda();
			}
		}

	}

	private Encomenda montarEncomenda() throws ParseException {
		Encomenda encomenda = new Encomenda();
		Set<ItemEncomenda> itens = new HashSet<>();
		Cliente cliente = (Cliente) tabelaEncomenda.getValueAt(0, 0);
		encomenda.setCliente(cliente);
		for (int i = 0; i < tabelaEncomenda.getRowCount(); i++) {
			ItemEncomenda item = new ItemEncomenda();
			item.setModelo((Modelo) tabelaEncomenda.getValueAt(i, 1));
			item.setQuantidade((int) tabelaEncomenda.getValueAt(i, 2));
			item.setValorItemEncomenda((float) tabelaEncomenda.getValueAt(i, 6));
			itens.add(item);
		}
		try {
			encomenda.setDataRetirada(new java.sql.Date(sdf.parse(
					fttDataRetirada.getText()).getTime()));
		} catch (ParseException e) {
			encomenda.setDataRetirada(null);
		}
		encomenda.setItemEncomenda(itens);
		if (rdbtnNo.isSelected()) {
			encomenda.setMotorista((Motorista) cbMotorista.getSelectedItem());
		} else encomenda.setMotorista(null);
		
		encomenda.setStatus((Status) cbStatus.getSelectedItem());
		encomenda.setDataEncomenda(new java.sql.Date(sdf.parse(
					fttDataRetirada.getText()).getTime()));
		return encomenda;
	}

	private void limpaTela() {
		// TODO Auto-generated method stub

	}

	private void adicionarDadoTabela() {
		if (Integer.parseInt(txtQtd.getText()) < 30) {
			JOptionPane.showMessageDialog(null,
					"Encomenda não pode possuir menos que trinta (30) peças",
					"Erro", JOptionPane.ERROR_MESSAGE);
		} else {
			DefaultTableModel md = (DefaultTableModel) tabelaEncomenda
					.getModel();

			Object linha[] = new Object[7];
			linha[0] = cbCliente.getSelectedItem();
			linha[1] = cbModelo.getSelectedItem();
			linha[2] = Integer.parseInt(txtQtd.getText());
			linha[3] = fttDataEncomenda.getText();

			try {
				java.sql.Date data = new java.sql.Date(sdf.parse(
						fttDataRetirada.getText()).getTime());
				linha[4] = data;
			} catch (Exception e) {
				linha[4] = null;
			}
			linha[6] = ((Modelo) cbModelo.getSelectedItem()).getMargemCusto()
					* Integer.parseInt(txtQtd.getText());
			md.addRow(linha);
			cbCliente.setEnabled(false);
			cbMotorista.setEnabled(false);
			cbModelo.removeItem(cbModelo.getSelectedItem());
			comboBoxTabela(null);

		}

	}

	private void comboBoxTabela(Status selecionaStatus) {
		TableColumn combo = tabelaEncomenda.getColumnModel().getColumn(5);

		if (selecionaStatus != null) {
			cbStatus.setSelectedItem(selecionaStatus);
		} else
			cbStatus.setSelectedItem(cbStatus.getSelectedItem());
		combo.setCellEditor(new DefaultCellEditor(cbStatus));
		combo.setCellRenderer(new DefaultTableCellRenderer());
	}
}
