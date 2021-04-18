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

import controle.SaldoDiarioModelo;
import modelo.ArmazenaArquivoControle;
import modelo.DespesaControle;
import modelo.ReceitaControle;
import modelo.SaldoControle;


public class Historico extends JFrame {
	private GridLayout grid;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4; 
	private Container container;
	private JLabel labelTitle;
	private JLabel labelData;
	private JLabel labelVisor;
	private JLabel labelDescricao;
	private JLabel labelVazio;
	private JButton buttonExcluir;
	private JButton buttonPesquisar;                                  
	private JTextField getdescricao, getdata;
	private DespesaControle despesaControle;
	private SaldoControle saldo;
	private HashMap<LocalDate, SaldoDiarioModelo> mapa;
	private String filePathMapa;
	private String filePathSaldo;
	private ReceitaControle receitaControle;
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static LocalDate data;
	
	public Historico(HashMap<LocalDate, SaldoDiarioModelo> mapa, String filePathMapa, String filePathSaldo, DespesaControle despesaControle, ReceitaControle receitaControle, SaldoControle saldo) {
		
		this.saldo = saldo; 
		this.mapa = mapa;
		this.filePathMapa = filePathMapa;
		this.filePathSaldo= filePathSaldo;
		this.saldo = saldo; 
		this.despesaControle = despesaControle;
		this.receitaControle = receitaControle;
		
		grid = new GridLayout(4,1); // 3 linhas e 2 colunas 
	 
		// Criar container
		container = getContentPane();
		container.setLayout(grid);
		
		// Criar JLabels
		labelTitle = new JLabel();
		labelVisor = new JLabel();
		labelDescricao = new JLabel(); 
		labelData = new JLabel();
		labelVazio = new JLabel();
		
		// Criar 3 paineis
		panel1 = new JPanel(); 
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		//Criar JText
		getdescricao = new JTextField("Digite a descricao");
		getdata = new JTextField("yyyy-xx-dd");
		   
		// Arruma paineis 
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(new GridLayout(1, 3));                 
		panel3.setLayout(new GridLayout(1, 1));
		panel4.setLayout(new GridLayout(2, 2));
		 
		panel1.setBackground(new Color(196, 255, 239));
		panel2.setBackground(new Color(65, 243, 193));
		panel3.setBackground(new Color(204, 233, 225));
		panel4.setBackground(new Color(65, 243, 193));
		
		// Defina a cor da borda do Grid 
		Border border1 = BorderFactory.createLineBorder(new Color(65, 243, 193) , 2);
		Border border2 = BorderFactory.createLineBorder(new Color(65, 243, 193) , 12);
		Border border3 = BorderFactory.createLineBorder(new Color(65, 243, 193) , 8);
		Border border4 = BorderFactory.createLineBorder(Color.black, 2);
		Border border_titulo = BorderFactory.createLineBorder(new Color(65, 243, 193) , 5);
		 
		panel3.setBorder(border1);
		
		// Arruma JText 
		panel2.setBorder(border_titulo);
		getdata.setBorder(border3);
		getdescricao.setBorder(border1);
		 
		// Arrumar label para painel 1 -titulo
		labelTitle.setText("Historico");  //Set text of label
		labelTitle.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 24));
		labelTitle.setBackground(new Color(196, 255, 239));
		labelTitle.setOpaque(true);  
		labelTitle.setVerticalAlignment(JLabel.CENTER); 
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setOpaque(true);  
		labelTitle.setBorder(border_titulo);
		labelTitle.setForeground(Color.black); 
		   
		// Criar label para painel 2 -valor, descricao, data
		labelVisor.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 10));
		labelVisor.setBackground(new Color(202, 204, 204 ));
		labelVisor.setOpaque(true);   
		//labelVisor.setVerticalAlignment(JLabel.CENTER); 
		//labelVisor.setHorizontalAlignment(JLabel.CENTER);
		labelVisor.setOpaque(true); 
		labelVisor.setBorder(border4); 
		labelVisor.setForeground(Color.black);
		labelVisor.setText("");  
		
		labelDescricao.setText("Descricao: ");  
		labelDescricao.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		labelDescricao.setBackground(new Color(65, 243, 193));
		labelDescricao.setOpaque(true);  
		labelDescricao.setVerticalAlignment(JLabel.CENTER); 
		labelDescricao.setHorizontalAlignment(JLabel.CENTER);
		labelDescricao.setOpaque(true); 
		labelDescricao.setForeground(new Color(38, 40, 40)); 
		
		labelData.setText("Data:");  
		labelData.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		labelData.setBackground(new Color(65, 243, 193));
		labelData.setOpaque(true);   
		labelData.setVerticalAlignment(JLabel.CENTER); 
		labelData.setHorizontalAlignment(JLabel.CENTER);
		labelData.setOpaque(true); 
		labelData.setForeground(new Color(38, 40, 40));
		   
		// Cria botão 1 e 2 para painel 2
		buttonExcluir = new JButton("Excluir");
		buttonExcluir.setBackground(new Color(185, 249, 231));
		buttonExcluir.setBorder(border1);
		buttonPesquisar = new JButton("Pesquisar");       
		buttonPesquisar.setBackground(new Color(185, 249, 231));
		buttonPesquisar.setBorder(border2); 
		
		
		// Adiciona as labels na Panel
		panel1.add(labelTitle);
		panel2.add(labelData);
	    panel2.add(getdata);
	    panel2.add(buttonPesquisar);
		panel3.add(labelVisor);
	    panel4.add(labelDescricao);
		panel4.add(getdescricao);
		panel4.add(labelVazio);
	    panel4.add(buttonExcluir);
 
		// Adiciona as panels no Container
		container.add(panel1, BorderLayout.NORTH);
		container.add(panel2, BorderLayout.NORTH);
		container.add(panel3, BorderLayout.NORTH);
		container.add(panel4, BorderLayout.SOUTH);
		
		// Action
	    buttonExcluir.addActionListener(new ButtonExcluir());
	    buttonPesquisar.addActionListener(new ButtonPesquisar());
		
		// Set layout    
		this.setResizable(false); 
		this.setSize(300,320);
		this.setTitle("Despesas");  
		this.setVisible(false);  // true = botão Adicionar for acionado
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	Menu frame = new Menu(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
				setVisible(false);
				
		    }
		});  
		
		ImageIcon pig = new ImageIcon("dollar-icon4.jpg"); //Get the picture from downloaded
		this.setIconImage(pig.getImage()); //Change icon of this
		this.getContentPane().setBackground(new Color(234, 233, 233)); //BackGround color
	}
	
	private class ButtonExcluir implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String descricao = getdescricao.getText();
			saldo.RemoveHistorico(data, descricao);
			Menu frame = new Menu(mapa, filePathMapa, filePathSaldo, despesaControle, receitaControle, saldo);
			setVisible(false);
		}
	} 
	
	private class ButtonPesquisar implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String s = event.getActionCommand();
	        if (s.equals("Pesquisar")) {
	            // set the text of the label to the text of the field
	        	Historico.data =LocalDate.parse(getdata.getText(), formatoData);
	        	labelVisor.setText(saldo.EmitirHistorico(data)); 
	        }
		}
	} 
}