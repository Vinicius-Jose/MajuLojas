package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class TelaPrincipal extends JFrame implements ActionListener {


	private JPanel painelPrincipal;
	private JPanel painel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal tela = new TelaPrincipal();
					tela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 752);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		painelPrincipal.setBackground(SystemColor.activeCaption);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		menuBar.setForeground(Color.WHITE);
		menuBar.setBorderPainted(false);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.setBounds(0, 31, this.getWidth(), 31);
		painelPrincipal.add(menuBar);

		JMenu mnModelo = new JMenu("Modelo");
		mnModelo.setForeground(Color.WHITE);
		mnModelo.setBackground(Color.BLACK);
		mnModelo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnModelo);

		JMenuItem mntmOpes = new JMenuItem("Op\u00E7\u00F5es");
		mntmOpes.setForeground(Color.WHITE);
		mntmOpes.setBackground(Color.BLACK);
		mntmOpes.addActionListener(this);
		mnModelo.add(mntmOpes);

		JMenuItem mntmAviamento = new JMenuItem("Aviamento");
		mntmAviamento.setForeground(Color.WHITE);
		mntmAviamento.setBackground(Color.BLACK);
		mntmAviamento.addActionListener(this);
		mnModelo.add(mntmAviamento);

		JMenuItem mntmCorteCostura = new JMenuItem("Corte & Costura");
		mntmCorteCostura.setForeground(Color.WHITE);
		mntmCorteCostura.setBackground(Color.BLACK);
		mntmCorteCostura.addActionListener(this);
		mnModelo.add(mntmCorteCostura);

		JMenuItem mntmModelagem = new JMenuItem("Modelagem");
		mntmModelagem.setForeground(Color.WHITE);
		mntmModelagem.setBackground(Color.BLACK);
		mntmModelagem.addActionListener(this);
		mnModelo.add(mntmModelagem);

		JMenuItem mntmPiloto = new JMenuItem("Piloto");
		mntmPiloto.setForeground(Color.WHITE);
		mntmPiloto.setBackground(Color.BLACK);
		mntmPiloto.addActionListener(this);
		mnModelo.add(mntmPiloto);

		JMenuItem mntmTecido = new JMenuItem("Tecido");
		mntmTecido.setForeground(Color.WHITE);
		mntmTecido.setBackground(Color.BLACK);
		mntmTecido.addActionListener(this);
		mnModelo.add(mntmTecido);

		JMenuItem mntmGrade = new JMenuItem("Grade");
		mntmGrade.setForeground(Color.WHITE);
		mntmGrade.setBackground(Color.BLACK);
		mntmGrade.addActionListener(this);
		mnModelo.add(mntmGrade);
		mntmGrade.addActionListener(this);

		JMenuItem mntmEncomenda = new JMenuItem("Encomenda");
		mntmEncomenda.setForeground(Color.WHITE);
		mntmEncomenda.setBackground(Color.BLACK);
		mntmEncomenda.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmEncomenda);
		mntmEncomenda.addActionListener(this);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.setBackground(Color.BLACK);
		mntmVenda.setForeground(Color.WHITE);
		mntmVenda.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmVenda);
		mntmVenda.addActionListener(this);

		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mntmEstoque.setForeground(Color.WHITE);
		mntmEstoque.setBackground(Color.BLACK);
		mntmEstoque.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmEstoque);
		mntmEstoque.addActionListener(this);

		JMenuItem mntmFornecedores = new JMenuItem("Fornecedores");
		mntmFornecedores.setForeground(Color.WHITE);
		mntmFornecedores.setBackground(Color.BLACK);
		mntmFornecedores.addActionListener(this);
		mntmFornecedores.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmFornecedores);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setForeground(Color.WHITE);
		mntmCliente.setBackground(Color.BLACK);
		mntmCliente.setHorizontalAlignment(SwingConstants.CENTER);
		mntmCliente.addActionListener(this);
		mntmCliente.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmCliente);

		JMenuItem mntmMotorista = new JMenuItem("Motorista");
		mntmMotorista.setForeground(Color.WHITE);
		mntmMotorista.setBackground(Color.BLACK);
		mntmMotorista.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmMotorista);
		mntmMotorista.addActionListener(this);

		JMenuItem mntmRelatrio = new JMenuItem("Relat\u00F3rio");
		mntmRelatrio.setForeground(Color.WHITE);
		mntmRelatrio.setBackground(Color.BLACK);
		mntmRelatrio.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmRelatrio);
		mntmRelatrio.addActionListener(this);

		JLabel lblMaju = new JLabel("Maju Lojas");
		lblMaju.setBackground(SystemColor.activeCaption);
		lblMaju.setForeground(Color.WHITE);
		lblMaju.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaju.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaju.setBounds(0, 0, 1040, 31);
		painelPrincipal.add(lblMaju);

		painel = new JPanel();
		painel.setBackground(Color.WHITE);
		painel.setBounds(0, 61, 1040, 660);
		painelPrincipal.add(painel);
		painel.setLayout(null);

		try {
			FRMModelo modelo = new FRMModelo();
			painel.add(modelo);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getActionCommand().equals("Op\u00E7\u00F5es")) {
			try {
				trocaTela(new FRMModelo());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Aviamento")) {
			trocaTela(new FRMAviamento());
		} else if (a.getActionCommand().equals("Corte & Costura")) {
			try {
				trocaTela(new FRMCorteCostura());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Modelagem")) {
			try {
				trocaTela(new FRMModelagem());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Piloto")) {
			try {
				trocaTela(new FRMPiloto());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Tecido")) {
			try {
				trocaTela(new FRMTecido());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Grade")) {
			trocaTela(new FRMGrade());
		} else if (a.getActionCommand().equals("Cliente")) {
			try {
				trocaTela(new FRMCliente());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Fornecedores")) {
			try {
				trocaTela(new FRMFornecedor());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Motorista")) {
			try {
				trocaTela(new FRMMotorista());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Relat\u00F3rio")) {
			trocaTela(new FRMRelatorio());
		} else if (a.getActionCommand().equals("Venda")) {
			try {
				trocaTela(new FRMVenda());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Encomenda")) {
			try {
				trocaTela(new FRMEncomenda());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (a.getActionCommand().equals("Estoque")) {
			trocaTela(new FRMEstoque());
		}

	}

	public void trocaTela(JPanel a) {
		painel.removeAll();
		painel.add(a);
		painel.repaint();
		painel.setBackground(Color.WHITE);
	}
}
