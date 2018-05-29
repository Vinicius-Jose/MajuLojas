package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import java.awt.Window.Type;
import java.text.ParseException;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.setBounds(0, 0, this.getWidth(), 31);
		contentPane.add(menuBar);
		
		JMenu mnModelo = new JMenu("Modelo");
		mnModelo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnModelo);
		
		JMenuItem mntmOpes = new JMenuItem("Op\u00E7\u00F5es");
		mnModelo.add(mntmOpes);
		
		JMenuItem mntmAviamento = new JMenuItem("Aviamento");
		mnModelo.add(mntmAviamento);
		
		JMenuItem mntmCorteCostura = new JMenuItem("Corte & Costura");
		mnModelo.add(mntmCorteCostura);
		
		JMenuItem mntmModelagem = new JMenuItem("Modelagem");
		mnModelo.add(mntmModelagem);
		
		JMenuItem mntmPiloto = new JMenuItem("Piloto");
		mnModelo.add(mntmPiloto);
		
		JMenuItem mntmTecido = new JMenuItem("Tecido");
		mnModelo.add(mntmTecido);
		
		JMenuItem mntmGrade = new JMenuItem("Grade");
		mnModelo.add(mntmGrade);
		
		JMenuItem mntmEncomenda = new JMenuItem("Encomenda\r\n");
		mntmEncomenda.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmEncomenda);
		
		JMenuItem mntmVenda = new JMenuItem("Venda\r\n");
		mntmVenda.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmVenda);
		
		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mntmEstoque.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmEstoque);
		
		JMenuItem mntmFornecedores = new JMenuItem("Fornecedores");
		mntmFornecedores.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmFornecedores);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmCliente);
		
		JMenuItem mntmMotorista = new JMenuItem("Motorista");
		mntmMotorista.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmMotorista);
		
		JMenuItem mntmRelatrio = new JMenuItem("Relat\u00F3rio");
		mntmRelatrio.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mntmRelatrio);
		
		final JPanel panel = new JPanel();
		panel.setBounds(0, 31, 1040, 660);
		contentPane.add(panel);
		
		
		
		mntmOpes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				try {
					panel.add(new FRMModelo());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				contentPane.repaint();
				
			}
		});
		
		mntmAviamento.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.repaint();
				contentPane.repaint();
				
			}
		});
	}
}
