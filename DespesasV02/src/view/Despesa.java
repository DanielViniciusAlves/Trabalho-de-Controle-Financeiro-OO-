package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.Border;

import controle.DespesaControle;
import controle.ReceitaControle;
import controle.SaldoControle;
import modelo.SaldoDiarioModelo;


public class Despesa extends JFrame {
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private Container container;
	private GridLayout grid;
	private JLabel labelTitle;
	private JLabel labelValor;
	private JLabel labelDescricao;
	private JLabel labelData;
	private JLabel labelVazio;
	private JButton buttonSalvar;
	private GridLayout grid_cont;
	private JTextField getvalor, getdescricao, getdata;
	private DespesaControle despesaControle;
	private SaldoControle saldo;
	private HashMap<LocalDate, SaldoDiarioModelo> mapa;
	private String filePathMapa;
	private String filePathSaldo;
	private ReceitaControle receitaControle;
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public Despesa(HashMap<LocalDate, SaldoDiarioModelo> mapa, String filePathMapa, String filePathSaldo, DespesaControle despesaControle, ReceitaControle receitaControle, SaldoControle saldo) {
		this.saldo = saldo; 
		this.mapa = mapa;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo= filePathSaldo;
		this.saldo = saldo; 
		this.despesaControle = despesaControle;
		this.receitaControle = receitaControle;
		grid = new GridLayout(2,2); // 3 linhas e 2 colunas 
		grid_cont = new GridLayout(3,1);
	 
		// Criar container
		container = getContentPane();
		container.setLayout(grid_cont);
		
		// Criar JLabels
		labelTitle = new JLabel();
		labelValor = new JLabel();
		labelDescricao = new JLabel();
		labelData = new JLabel();
		labelVazio = new JLabel();
		
		// Criar 3 paineis
		panel1 = new JPanel(); 
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		//Criar JText
		getvalor = new JTextField("Digite o valor");
		getdescricao = new JTextField("Digite a descricao");
		getdata = new JTextField("yyyy-xx-dd");
		
		// Arruma paineis 
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(grid);
		panel3.setLayout(grid);
		panel2.setBackground(new Color(140, 252, 255));
		panel3.setBackground(new Color(140, 252, 255));
		
		
		// Defina a cor da borda do Grid 
		Border border = BorderFactory.createLineBorder(new Color(140, 252, 255) , 8);
		
		// Arruma JText
		getvalor.setBorder(border);
		getdata.setBorder(border);
		getdescricao.setBorder(border);
		
		 
		// Arrumar label para painel 1 -titulo
		labelTitle.setText("Nova Despesa");  //Set text of label
		labelTitle.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 24));
		labelTitle.setBackground(new Color(205, 249, 251));
		labelTitle.setOpaque(true);  
		labelTitle.setVerticalAlignment(JLabel.CENTER); 
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setOpaque(true); 
		labelTitle.setBorder(border);
		labelTitle.setForeground(Color.black);
		 
		// Criar label para painel 2 -valor, descricao, data
		labelValor.setText("Valor:");  
		labelValor.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		labelValor.setBackground(new Color(140, 252, 255));
		labelValor.setOpaque(true);   
		labelValor.setVerticalAlignment(JLabel.CENTER); 
		labelValor.setHorizontalAlignment(JLabel.CENTER);
		labelValor.setOpaque(true); 
		labelValor.setForeground(new Color(38, 40, 40));
		
		labelDescricao.setText("Descricao: ");  
		labelDescricao.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		labelDescricao.setBackground(new Color(140, 252, 255));
		labelDescricao.setOpaque(true);  
		labelDescricao.setVerticalAlignment(JLabel.CENTER); 
		labelDescricao.setHorizontalAlignment(JLabel.CENTER);
		labelDescricao.setOpaque(true); 
		labelDescricao.setForeground(new Color(38, 40, 40));
		
		labelData.setText("Data:");  
		labelData.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		labelData.setBackground(new Color(140, 252, 255));
		labelData.setOpaque(true);  
		labelData.setVerticalAlignment(JLabel.CENTER); 
		labelData.setHorizontalAlignment(JLabel.CENTER);
		labelData.setOpaque(true); 
		labelData.setForeground(new Color(38, 40, 40));
		 
		// Cria botão 1 e 2 para painel 2
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBackground(new Color(232, 253, 254));
		//buttonSalvar.setBorder(border);
		  
		// Adiciona as labels na Panel
		panel1.add(labelTitle);
		panel2.add(labelValor);
	    panel2.add(getvalor);
		panel2.add(labelDescricao);
	    panel2.add(getdescricao);
		panel3.add(labelData);
	    panel3.add(getdata);
	    panel3.add(labelVazio);
	    panel3.add(buttonSalvar);

		// Action
	    buttonSalvar.addActionListener(new ButtonSalvar());
	    
		// Adiciona as panels no Container
		container.add(panel1, BorderLayout.NORTH);
		container.add(panel2, BorderLayout.NORTH);
		container.add(panel3, BorderLayout.SOUTH);
		
		// Set layout   
		this.setResizable(false); 
		this.setSize(300,300); 
		this.setTitle("Despesas");
		this.setVisible(false);  // true = botão Adicionar for acionado
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		 
		ImageIcon pig = new ImageIcon("dollar-icon4.jpg"); //Get the picture from downloaded
		this.setIconImage(pig.getImage()); //Change icon of this
		this.getContentPane().setBackground(new Color(234, 233, 233)); //BackGround color
	}
	 
	private class ButtonSalvar implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String s = event.getActionCommand();
	        if (s.equals("Salvar")) {
	            // set the text of the label to the text of the field
	        	Double valor=Double.parseDouble(getvalor.getText());  
	        	LocalDate data =LocalDate.parse(getdata.getText(), formatoData);
	            String descricao = getdescricao.getText();
	            despesaControle.AddDespesa(valor, data, descricao);
	        }
			setVisible(false);
			GridLayoutDemo frame = new GridLayoutDemo(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
		}
	} 
	
}