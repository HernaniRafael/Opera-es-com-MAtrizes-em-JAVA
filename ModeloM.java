
import javax.swing.JOptionPane;
import java.util.*;


public class ModeloM {
        
    int[][] matriz, matrizB;
    Random rnd = new Random();
    int linhas;
    int colunas;

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }
    
    //gerar uma matriz aleatoria
    public void gerarMatriz(){
        
        matriz = new int[linhas][colunas];

        for(int i=0; i<matriz.length; i++)
            for(int j=0; j<matriz[i].length; j++)
            {
                matriz[i][j] = rnd.nextInt(10);
            }
    }
    
    //preencher os valores da matriz
    public void lerMatriz(){
        matriz = new int[linhas][colunas];

        for(int i=0; i<matriz.length; i++)
            for(int j=0; j<matriz[i].length; j++)
            {
                matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o valor da Posição [" + i +"][" + j + "]"));
            }
        
        matrizNula(matriz);
    }
    
    public void lerMatrizB(){
        
        matrizB = new int[linhas][colunas];

        for(int i=0; i<matrizB.length; i++)
                for(int j=0; j<matrizB[i].length; j++)
                {
                    matrizB[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o valor da Posição [" + i +"][" + j + "]"));
                }
        mostrarMatriz(matrizB);
    }

    //mostrar(imprimir) os valores da matriz
    public void mostrarMatriz(int mat[][]){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mat.length; i++){
                for(int j=0; j < mat[i].length; j++)
                {
                        sb.append(mat[i][j]);
                        if(j != mat[1].length - 1)
                                sb.append("     ");
                }

                if(i != mat.length - 1)
                        sb.append('\n');
        }
        JOptionPane.showMessageDialog(null, "\t" + sb.toString());
    }

    //escolher as operações desejadas    
    public int escolherOperacoes(int mat[][]){
        String texto = "\t OPERAÇÕES COM MATRIZES";
        int n = Integer.parseInt(JOptionPane.showInputDialog(null,texto 
                                               + "\n 1 - Imprimir a Matriz"
                                               + "\n 2 - Diagonal Principal"
                                               + "\n 3 - Matriz Oposta"
                                               + "\n 4 - Busca"
                                               + "\n 5 - Determinante"
                                               + "\n 6 - Soma de Matrizes"
                                               + "\n 7 - Maior valor da Matriz"
                                               + "\n -1  - Para fechar"));
        
        return n;
    }

    //achar determinante da matriz
    public void determinante(int mat[][]){
        int deter=0;
        int [][] temp = new int[linhas][colunas];
        
        deter = (mat[0][0]*mat[1][1])-(mat[1][0]*mat[0][1]);
        JOptionPane.showMessageDialog(null, "Determinante = " + deter);
    
    }

    //achar diagonal principal da matriz
    public void diagonalPrincipal(int mat[][]){

        int soma = 0;
        for(int i=0; i<mat.length; i++){
            soma += mat[i][i];
        }

        JOptionPane.showMessageDialog(null,"Diagonal Principal = " + soma);
    }



    //achar diagonal secundária da matriz  
    public void diagonalSecundaria(int mat[][]){
        int soma = 0;
        int j = mat.length - 1;

        for(int i=0; i < mat.length; i++){
            soma += mat[i][j];
            j--;
        }

        JOptionPane.showMessageDialog(null,"Diagonal Secundaria = " + soma);
    }

    //achar a matriz oposta    
    public void mOposta(int mat[][]){
        int[][] oposta = new int[linhas][colunas];
        
        for(int i=0; i < mat.length; i++)
            for(int j=0; j < mat[i].length; j++)
                oposta[i][j] = mat[i][j] * (-1);
				
		
        mostrarMatriz(oposta);
    }

    //pesquisar um elemento na matriz    
    public void busca(int mat[][]){
        int temp=0;
        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o valor a pesquisar"));
        for(int i=0; i < mat.length; i++)
        {   
            for(int j=0; j < mat[i].length; j++){
                if(mat[i][j]==valor)
                {
                    temp++;
                }
            }
        }
        if(temp>0)
            JOptionPane.showMessageDialog (null, "O valor existe na Matriz. \nNúmero de ocorrências: " + temp + " vezes.");
        if(temp==0)
            JOptionPane.showMessageDialog (null, "O valor não existe na Matriz. \nNúmero de ocorrências: " + temp + " vezes.");
        
    }


	//somar uma linha da matriz    
    public void somaLinhaN(int matriz[][], int n){
        int soma=0;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j< matriz[i].length; j++){
                if( i == n-1)
                {
                    soma = soma + matriz[i][j];
                }
            }
        }
	JOptionPane.showMessageDialog(null, "A soma da linha " + n + " é " + soma);
    }
	

	//somar uma coluna da matriz
    public void somaColunaN(int matriz[][], int n){
        int soma=0;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j< matriz[i].length; j++){
                if( j == n-1)
                {
                    soma = soma + matriz[i][j];
                }
            }
        }
        JOptionPane.showMessageDialog(null, "A soma da coluna " + n + " é " + soma);

    }
    
	//multiplicar a matriz por um escalar 
    public void multEscalar(int mat[][], int n){
                
        int[][] resultado = new int[linhas][colunas];

        for (int i = 0; i< mat.length; i++)
        {
                for (int j =0; j < mat.length; j++)
                {
                        resultado[i][j] = mat[i][j] * n;
                }
        }
        
       mostrarMatriz(resultado);
    }


	//calcular a matriz identidade    
    public void identidade(int mat[][]){
        int[][] identidade = new int[linhas][colunas];
        
        for (int i = 0; i< mat.length; i++)
        {
                for (int j =0; j < mat.length; j++)
                {
                        identidade[i][j] = 0;
                }
        }
        
        for(int i=0; i<mat.length; i++)
            identidade[i][i]=1;
        
        mostrarMatriz(identidade);
    }

	//soma entre matrizes    
    public void somaMatrizes(int mat1[][], int mat2[][]){
        int[][] somaMat = new int[mat1[0].length][mat1.length];
        for (int i = 0; i< mat1.length; i++)
        {
            for (int j =0; j < mat1.length; j++)
            {
                somaMat[i][j] = mat1[i][j]+mat2[i][j];
            }
        }
        
        mostrarMatriz(somaMat);
    
    }
    	//multiplicação entre matrizes
    public void multMatrizes(int mat1[][], int mat2[][]){
        int[][] multMat = new int[mat1[0].length][mat1.length];
        for (int i = 0; i< mat1.length; i++)
        {
            for (int j =0; j < mat1.length; j++)
            {
                multMat[i][j] = mat1[i][j]*mat2[i][j];
            }
        }
        
        mostrarMatriz(multMat);
    
    }
    
    private void transposta( int matriz[][]) {
        
        int[][] matrizTransposta = new int[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
               matrizTransposta[j][i] = matriz[i][j];
            }
        }
        
        mostrarMatriz(matrizTransposta);
    }
    
    public void maiorElemento(int mat[][]){
            int maior=mat[0][0];
            for (int i = 0; i < matriz.length; i++)
            {
                for (int j = 0; j < matriz[i].length; j++)
                {
                    if(mat[i][j]>maior){
                        maior=mat[i][j];
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Maior elemento da matriz = " + maior);
    }
    
    public void menorElemento(int mat[][]){
            int menor=mat[0][0];
            for (int i = 0; i < matriz.length; i++)
            {
                for (int j = 0; j < matriz[i].length; j++)
                {
                    if(mat[i][j]<menor){
                        menor=mat[i][j];
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Menor elemento da matriz = " + menor);
    }
    
    public void chamaFuncaoN(int n){
        switch(n)
        {
            case 1:
                mostrarMatriz(matriz);
                break;
            case 2:
                diagonalPrincipal(matriz);
                break;
            case 3:
                mOposta(matriz);
                break;
            case 4:
                busca(matriz);
                break;
            case 5:
                determinante(matriz);
                break;
            case 6:
                lerMatrizB();
                somaMatrizes(matriz, matrizB);
                break;
                
            case 7:
                maiorElemento(matriz);
                break;
            case 8:
                matrizNula(matriz);
                break;
            case -1:
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
                break;
        }
        
        
    }


	//matriz nula    
    public void matrizNula(int mat[][]){
        int auxiliar=0;
        for(int i=0; i<matriz.length; i++)
            for(int j=0; j<matriz[i].length; j++)
            {
                if(matriz[i][j]==0)
                    auxiliar++;
            }
        
        if( linhas * colunas == auxiliar){
            JOptionPane.showMessageDialog(null," A MATRIZ É NULA. \n Volte a inserir os dados na MATRIZ!!!");
            lerMatriz();
        }
    }
    
}
