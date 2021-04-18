package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.border.Border;

import controle.ArmazenaArquivoControle;
import controle.DespesaControle;
import controle.ReceitaControle;
import controle.SaldoControle;
import modelo.SaldoDiarioModelo;


public class Menu extends JFrame{
	private Container container;
	private GridLayout grid;
	private JButton buttonDespesa;
	private JButton buttonReceita;
	private JButton buttonHistorico;
	private JLabel labelTitle;
	private JLabel labelDespesa;
	private JLabel labelReceita;
	private JLabel labelSaldo;
	private JLabel labelValor;
	private JLabel labelHistorico;
	private JPanel panel1;
	private JPanel panel2;
//	private JPanel panel3;
	private JPanel panel4;
	private DespesaControle despesaControle;
	private ReceitaControle receitaControle;
	private SaldoControle saldo;
	private HashMap<LocalDate, SaldoDiarioModelo> mapa;
	private String filePathMapa;
	private String filePathSaldo;
	
	public Menu(HashMap<LocalDate, SaldoDiarioModelo> mapa, String filePathMapa, String filePathSaldo, DespesaControle despesaControle, ReceitaControle receitaControle, SaldoControle saldo){
		this.mapa = mapa;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo= filePathSaldo;
		this.saldo = saldo; 
		this.despesaControle = despesaControle;
		this.receitaControle = receitaControle;
		//Inicia layout padrao Grid e inicia Label
		grid = new GridLayout(3,2); // 4 linhas e 2 colunas 
		labelTitle = new JLabel();  
		labelDespesa = new JLabel();
		labelReceita = new JLabel();
		labelSaldo = new JLabel();
		labelValor = new JLabel();
		labelHistorico = new JLabel();
		
		// Cria container grid
		container = getContentPane();
		container.setLayout(grid);
		 
		// Cria painel
		panel1 = new JPanel(); 
		panel2 = new JPanel();
//		panel3 = new JPanel();
		panel4 = new JPanel();
		 
		// Arruma paineis 2 e 4
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(new GridLayout(3, 3));
//		panel3.setLayout(new GridLayout(1, 1));
		panel4.setLayout(new GridLayout(1, 2));
		 
		// Defina a cor da borda do Grid 
		Border border = BorderFactory.createLineBorder(new Color(240, 240, 240) , 3);
		Border border_2 = BorderFactory.createLineBorder(new Color(240, 240, 240), 4);
		 
		// Cria label CONTROLE FINANCEIRO  para painel 1
		labelTitle.setText("<html><u>CONTROLE FINANCEIRO</u>");  //Set text of label
		labelTitle.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 24));
		labelTitle.setBackground(new Color(240, 240, 240));
		labelTitle.setOpaque(true); 
		labelTitle.setVerticalAlignment(JLabel.CENTER); 
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setOpaque(true); 
		
		// Cria label para o painel 2 para despesa, receita e historico
		labelDespesa.setText("Nova Despesa");   
		labelDespesa.setFont(new Font("Serif", Font.PLAIN, 20));
		labelDespesa.setBackground(Color.white);
		labelDespesa.setOpaque(true);
		labelDespesa.setVerticalAlignment(JLabel.CENTER); 
		labelDespesa.setHorizontalAlignment(JLabel.CENTER);
		labelDespesa.setOpaque(true); 
		labelDespesa.setBorder(border);
		labelDespesa.setForeground(Color.black);
		 
		labelReceita.setText("Nova Receita");  
		labelReceita.setFont(new Font("Serif", Font.PLAIN, 20));
		labelReceita.setBackground(Color.white);
		labelReceita.setOpaque(true);
		labelReceita.setVerticalAlignment(JLabel.CENTER); 
		labelReceita.setHorizontalAlignment(JLabel.CENTER);
		labelReceita.setOpaque(true);
		labelReceita.setBorder(border);
		labelReceita.setForeground(Color.black);
		
		labelHistorico.setText("Historico");  
		labelHistorico.setFont(new Font("Serif", Font.PLAIN, 20));
		labelHistorico.setBackground(Color.white);
		labelHistorico.setOpaque(true);
		labelHistorico.setVerticalAlignment(JLabel.CENTER); 
		labelHistorico.setHorizontalAlignment(JLabel.CENTER);
		labelHistorico.setOpaque(true);
		labelHistorico.setBorder(border);
		labelHistorico.setForeground(Color.black);
		
		// Cria label para painel 3
		
		    // Futuro Calendário
		
		//Cria label para painel 4
		labelSaldo.setText("Saldo:"); 
		labelSaldo.setFont(new Font("Serif", Font.PLAIN, 22));
		labelSaldo.setBackground(Color.white);
		labelSaldo.setOpaque(true);
		labelSaldo.setVerticalAlignment(JLabel.CENTER); 
		labelSaldo.setHorizontalAlignment(JLabel.CENTER);
		labelSaldo.setOpaque(true);
		labelSaldo.setBorder(border);
		labelSaldo.setForeground(Color.black);
		labelSaldo.setBorder(border_2); 
		
		labelValor.setText("R$ " + saldo.getTotal().toString()); 
		labelValor.setFont(new Font("Serif", Font.PLAIN, 22));
		labelValor.setBackground(new Color(240, 240, 240));
		labelValor.setOpaque(true);
		labelValor.setVerticalAlignment(JLabel.CENTER); 
		labelValor.setHorizontalAlignment(JLabel.CENTER);
		labelValor.setOpaque(true); 
		labelValor.setBorder(border); 
		labelValor.setForeground(Color.black);
		
		// Cria botão 1 e 2 para painel 2
		buttonDespesa = new JButton("Adicionar"); 
		buttonReceita = new JButton("Adicionar");
		buttonHistorico = new JButton("Visualizar");
		buttonDespesa.setBackground(new Color(215, 215, 215));
		buttonReceita.setBackground(new Color(215, 215, 215));
		buttonHistorico.setBackground(new Color(215, 215, 215));
		buttonDespesa.setBorder(border);
		buttonReceita.setBorder(border);
		buttonHistorico.setBorder(border);
		
		// Action nos botoes
		buttonDespesa.addActionListener(new ButtonDespesa());
		buttonReceita.addActionListener(new ButtonReceita());
		buttonHistorico.addActionListener(new ButtonHistorico());
		
		
		// Adiciona cada objeto nos paineis
		panel1.add(labelTitle);
		panel2.add(labelDespesa);
		panel2.add(buttonDespesa);
		panel2.add(labelReceita);
		panel2.add(buttonReceita);
		panel2.add(labelHistorico);
		panel2.add(buttonHistorico);
		panel4.add(labelSaldo);
		panel4.add(labelValor);
	
		// Coloca paineis no container
		container.add(panel1, BorderLayout.NORTH);
		container.add(panel2, BorderLayout.NORTH);
//		container.add(panel3, BorderLayout.SOUTH); 
		container.add(panel4, BorderLayout.SOUTH);
		
		   
		// Set layout  
		this.setResizable(false); 
		this.setSize(400,400);
		this.setTitle("Controle Financeiro");
		this.setVisible(true); 
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	ArmazenaArquivoControle armazena = new ArmazenaArquivoControle(mapa, filePathMapa, filePathSaldo, saldo);
				//Armazena dados do Mapa
				armazena.ImprimeMapa();
				armazena.ImprimeSaldo();
				System.out.println("saindo");
				//System.exit(0);
		    }
		});
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Exit the app
		
		ImageIcon pig = new ImageIcon("dollar-icon4.jpg"); //Get the picture from downloaded
		this.setIconImage(pig.getImage()); //Change icon of this
		this.getContentPane().setBackground(new Color(234, 233, 233)); //BackGround color
		
	}
	
	private class ButtonDespesa implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Despesa aciona_despesa = new Despesa(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
			aciona_despesa.setVisible(true);
			setVisible(false);
		}
	} 
	
	private class ButtonReceita implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Receita aciona_receita = new Receita(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
			aciona_receita.setVisible(true);
			setVisible(false);
		}
	}
	
	private class ButtonHistorico implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Historico aciona_historico = new Historico(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
			aciona_historico.setVisible(true);
			setVisible(false);
		}
	}
	
	
}
