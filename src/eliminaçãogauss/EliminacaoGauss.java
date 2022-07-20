/**
Criado por Geovanio Jose da Silva & José João Mario Andrade
como requisito de nota referente a segunda V.A da disciplina de Álgebra Linear
UFRPE-UAG em 2016.2; Por favor não usar esse codigo para outros proposito
sem expresso consentimento do autor, com exceção do Professor Murilo Chavedar. 
**/

/**
O método de Gauss consiste em operar transformações elementares sobre as equações de
um sistema Ax = b até que, depois de n ¡ 1 passos, se obtenha um sistema triangular 
superior, Ux = c, equivalente ao sistema dado, sistema esse que é resolvido por substituições
retroativas.
**/
package eliminaçãogauss;

import java.util.Scanner;

/**
 * @author Geovânio José & José João Mário
 */
public class EliminacaoGauss { 
    private double matriz [][];
    private double vetor [];    
    private int Tamlinhas;
    private int Tamcolunas;
    private double resultado []; 
    private int tam;
    
    /**
     * O construtor é deafault, logo o usuário não necessita fornecer todos os dados logo 
     * de inicio. Durante a execução será pedido para que o usuário forneça os dados. 
     */
    public EliminacaoGauss(){   
    }

    /**
     * @return a matriz com valores default, ou seja, 0.0
     */
    public double[][] CriarMatrizCoeficientes(){
        System.out.print("Digite a quantidade de linha(s) que o sistema possui\n");
        Scanner sc = new Scanner(System.in);
        Tamlinhas = sc.nextInt();
        System.out.print("Digite a quantidade de coluna(s) que o sistema possui\n");
        Tamcolunas = sc.nextInt();
        matriz = new double[Tamlinhas][Tamcolunas];
        return matriz;
    }

    /**
     * @return a matriz preenchida com os valores passados pelo usuário
     */
    public double [][] PreencherMatriz(){ 
        for(int linhas =0; linhas< matriz.length; linhas++){
            for(int colunas=0; colunas < matriz[0].length; colunas++){
                Scanner sc = new Scanner(System.in);
                System.out.print("Digite os valores ["+linhas+"]["+colunas+"] dos coeficientes da matriz ["+Tamlinhas+"]["+Tamcolunas+"]:\n");
                matriz[linhas][colunas]= sc.nextDouble();
            }  
        }
        return matriz; 
    } 

    /**
     * @return o vetor com valores default, ou seja, todos os termos são 0.0
     */
    public double[] CriarVetor(){
        vetor = new double[Tamlinhas];
        return vetor;
    }

    /**
     * @return o vetor preenchido com os valores passados pelo usuário
     */
    public double [] PreencherVetorTermosIndependentes(){
        Scanner sc = new Scanner(System.in);
        for(int indice =0; indice < vetor.length; indice++){
            System.out.print("Digite os termos independente(s) ["+indice+"] que o sistema possui\n");
            vetor[indice]= sc.nextDouble();
            }
        return vetor;
    }
    public void MostrarSistema() {
        System.out.println("---------------------------------------------------------\n");
        for(int linhas = 0; linhas <matriz.length; linhas++){
            for(int coluna = 0; coluna <matriz[0].length; coluna++){
                System.out.printf("\t%.3f", matriz[linhas][coluna]);
            }
            System.out.printf("\t=\t%.3f", vetor[linhas]);
            System.out.print("\n");
        }
        System.out.println("---------------------------------------------------------\n");
    }
    public void OrganizarMatriz(){
        int i, j, k;
        double m; 
        // 
        for(k = 0; k <matriz.length; k++){
            // Eliminação dos elementos da coluna abaixo da diagonal
            for(i = (k + 1);i<matriz[0].length; i++){
        /*
        Escolha como pivô o elemento de maior múdulo entre os coeficiente.
        Análise de propagação de erros de arredondamento para o algorítmo de Gauss indicam a
        conveniência de  serem todos multiplicadores(as constantes) menores que 1 em módulo; 
        ou seja o pivot deve ser o elemento de maior valor absoluto da coluna, da diagonal 
        (inclusive) para baixo. Podemos então em cada passo, escolher na coluna correspondente
        o elemento de maior valor absoluto, da diagonal (inclusive) para baixo, e fazer uma 
        permutação nas equações do sistema, de modo que esse elemento venha a ocupar a posição diagonal.
        */
                if(Math.abs(matriz[k][k]) < Math.abs(matriz[i][k])){
                MostrarSistema(); 
        //multiplicador necessário para a eliminação em cada linha da coluna que está sendo eliminada.
                m = matriz[i][k] / matriz[k][k];
                matriz[i][k]  = 0;
        // Calcula as próxima linhas com base nos multiplicadores encontrados.
                for(j = (k + 1); j <matriz[0].length; j++){
                    matriz[i][j] = matriz[i][j] - m * matriz[k][j];
                }
        // Cálculo do vetor dos resutados
                vetor[i] = vetor[i] - m * vetor[k];
                MostrarSistema();
                }
            }
        }
    }
    
    /*
    A resolução deste sistema pelo método de Gauss envolve duas fases distintas.
    A primeira, chamada de fase de eliminação, consiste em transformar o sistema
    dado em um sistema triangular superior, O que o método OrganizarMatriz() fez.
    A segunda, chamada de fase de substituição, consiste em  resolver o sistema 
    triangular superior através de substituições retroativas.
    */
    public void ResolucaoDoSistema(){
        resultado = new double[Tamlinhas];
    //procedimento Substituicao Retroativa
        tam = matriz.length; 
        tam--;        
        resultado[tam] = vetor[tam] / matriz[tam][tam];
        for(int k = tam; k > -1; k--){
            double soma = 0;
            for(int j = (k + 1); j < (tam+ 1); j++){
                soma = soma + matriz[k][j] * resultado[j];
                resultado[k] = (vetor[k] - soma) / matriz[k][k];
            }
        }
        tam++;    //normalizando o valor da variável.
    }
    // Este método mostra os resultados
    public void MostrarResultados(){
        System.out.println("---------------------------------------------------------\n");
        for(int i = 0; i < tam; i++){  
            System.out.printf("X[%d] = %.2f\n", i + 1, resultado[i]);
            System.out.println("---------------------------------------------------------");
        }
    
    // MÉTODOS PARA ANALISAR O TIPO DE SOLUÇÃO QUE O SISTEMA POSSUI
    
    // Esse método serve apenas para sistemas 2x2. 
    // Consideramos uma matriz arbitária:
    // (ax + bx =c)
    // (a'x + b'x = c')
    // Cada linha do sistema representa uma reta no plano. Então podemos ter:
              
    // Para facilitar a comparação dos valores resultados das divisões dos coeficientes da matriz e do vetor
    // criamos variáveis que recebem esses valores.
        double valor1= matriz[0][0]/matriz[1][0];
        double valor2= matriz[0][1]/matriz[1][1];
        double valor3= vetor[0]/vetor[1];
            
        while(matriz.length==2 & matriz[0].length==2){
                   
    // Que o sistema será possível e determinado quando a divisão a/a' é diferente de b/b'.
    // Geometricamente essa relação representa retas concorrentes, onde há um ponto 
    // (x, y) de intersecção que é solução única do sistema.
            if(valor1!=valor2){ 
                System.out.println("Sistema Possível e Determinado");
                break;
            }
    // Que o sistema será possível e indeterminado quando a divisão de a/a' é igual a b/b' e 
   // igual a c/c'.
   // Geometricamente representa retas coincidentes, onde infinitos pontos comuns fazem parte
   // do conjunto solução do sistema. 
            else if(valor1==valor2&&valor2==valor3){
                System.out.println("Sistema possível e Indeterminado");
                   break;  
            }
    // Que o sistema será impossível quando a divisão de  a/a' é igual a b/b' é diferente de c/c'.           
    // Geometricamente representa retas paralelas, onde não há nenhum ponto solução do sistema. 
            else if (valor1==valor2&&valor2!=valor3){
                System.out.println("Sistema Impossível");
                break;
            }
        }    
         
    // Esse método serve para sistema homogêneo.
    // O sistema será ou possível determinado (apenas a solução trivial) 
    // ou possível indeterminado (tem a solução trivial e mais outras).
        int i=0;
        for(int indice =0; indice < vetor.length; indice++){ 
            if(vetor[indice]==0){
                i++;                 
            }if(i!= 0){
                System.out.println("Sistema Possível Determinado ou Possível Indeterminado");
                break;
            }
        }
        
     while(matriz.length==3 && matriz[0].length==3){    
    // Esse método serve apenas para sistemas 3x3 ou superiores.
    // Seja det o determinante da matriz obtida dos coeficientes das incógnitas. 
    // Então temos:
    // Utilizando a regra de Sarrus
        double novaMatriz[][] = new double [5][3];
        double det = 0;
    // variaveis que guardam o resultado da multiplicação do coeficientes.
            
        for (int j = 0; j < 5; j ++){
            if (j < 3){
                System.arraycopy(matriz[i], 0, novaMatriz[i], 0, 3); // copia as 3 primeiras colunas
            }else{
                System.arraycopy(matriz[i - 3], 0, novaMatriz[i], 0, 3); // copia as 2 últimas colunas
            }   
        }    
        double esquerdaDireita = novaMatriz[0][0] * novaMatriz[1][1] * novaMatriz[2][2];
        esquerdaDireita += novaMatriz[1][0] * novaMatriz[2][1] * novaMatriz [3][2];
        esquerdaDireita += novaMatriz[2][0] * novaMatriz[3][2] * novaMatriz[4][2];
        double direitaEsquerda = -1 * novaMatriz[2][0] * novaMatriz[1][1] * novaMatriz[0][2];
        direitaEsquerda += -1 * novaMatriz[3][0] * novaMatriz[2][1] * novaMatriz[1][2];
        direitaEsquerda += -1 * novaMatriz[4][0] * novaMatriz[3][1] * novaMatriz[2][2];
        det= esquerdaDireita + direitaEsquerda;
    // Sistema Possível e Determinado: det D diferente 0 
        if (det!=0){
            System.out.println("Sistema Possível e Determinado");
        }else{
            System.out.println("Sistema Possível e indeterminado ou impossível");
        }
      }
    }
}