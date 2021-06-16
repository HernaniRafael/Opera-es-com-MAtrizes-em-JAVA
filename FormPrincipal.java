/**OPERAÇÕES COM MATRIZES

Hernani Rafael - 21706 

------------------------**/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPrincipal extends JFrame
{
	PainelCentro centro;
	PainelSul sul;
	
	public FormPrincipal()
	{
		super("Principal");

		getContentPane().add( centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add( sul = new PainelSul(), BorderLayout.SOUTH);

		setSize(600, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public class PainelCentro extends JPanel
	{
		JTextField linhas, colunas;
                JLabel texto, texto2;
		
		public PainelCentro()
		{
			setLayout( new GridLayout(4, 1));
			add(texto = new JLabel("     PROJECTO DE FP3"));
                        
                        texto.setForeground(Color.BLUE);
                        texto.setFont(new java.awt.Font("Tahoma", 1, 49));
		}
	}
		
	public class PainelSul extends JPanel implements ActionListener
	{
		JButton gerarMatriz, preencherMatriz, fechar;

		public PainelSul()
		{
			setLayout( new GridLayout(1, 3));

			add(gerarMatriz = new JButton("Gerar Matriz"));
			add(preencherMatriz = new JButton("Preencher Matriz"));
                        add(fechar = new JButton("Sair"));
                        
                        gerarMatriz.setToolTipText("Clique para gerar uma matriz automaticamente");
			preencherMatriz.setToolTipText("Clique para preencher uma matriz com valores da sua escolha");
                        fechar.setToolTipText("Clique para sair do programa");

			gerarMatriz.addActionListener( this );
			preencherMatriz.addActionListener( this );
                        fechar.addActionListener( this );

		}

                @Override
		public void actionPerformed(ActionEvent evt)
		{
			//vai gerar a Matriz Automaticamente
			if (evt.getSource() == gerarMatriz)
			{
                           int n=0;
                           int linhas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número de linhas: "));
                           if(linhas>1 && linhas<5)
                           {
                               int colunas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número de colunas: "));
                               if(colunas>1 && colunas<5){
                                    ModeloM md = new ModeloM();
                                    md.setLinhas(linhas);
                                    md.setColunas(colunas);
                                    md.gerarMatriz();
                                    
                                    while(n!=-1){
                                    n = md.escolherOperacoes(md.matriz);
                                    md.chamaFuncaoN(n);
                                    }
                               }else
                               {
                                   JOptionPane.showMessageDialog(null, "Número de colunas inválido");
                               }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Número de linhas inválido");
                            }
                      
			}
			//vai Preencher a Matriz
			if(evt.getSource() == preencherMatriz)
			{
                            int n=0;
                           int linhas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número de linhas: "));
                           if(linhas>1 && linhas<5)
                           {
                               int colunas = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número de colunas: "));
                               if(colunas>1 && colunas<5){
                                    ModeloM md = new ModeloM();
                                    md.setLinhas(linhas);
                                    md.setColunas(colunas);
                                    md.lerMatriz();
                                    
                                    while(n!=-1){
                                    n = md.escolherOperacoes(md.matriz);
                                    md.chamaFuncaoN(n);
                                    }
                               }else
                               {
                                   JOptionPane.showMessageDialog(null, "Número de colunas inválido");
                               }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Número de linhas inválido");
                            }
			}
                        
                        if(evt.getSource() == fechar)
			{
                            System.out.println("Fechando a aplicação...");
                            dispose();
			}
		}
		
	}
	
	public static void main(String args[])
	{
            FormPrincipal formPrincipal = new FormPrincipal();		
	}
}
	
	
	
	
	
	
