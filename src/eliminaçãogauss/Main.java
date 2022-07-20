/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminaçãogauss;

import UI_console.Console;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geovânio José da Silva & José João Mario Araújo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int escolha = -1;
        Console Tela = new Console();
        Scanner Scan = new Scanner(System.in); 
       
        while(escolha!=0){
            escolha = Tela.TelaPrincipal();
            switch(escolha){
                case 1:{
                    System.out.println(" @author Geovânio José da Silva & José João Mario Araújo de Andrade\n");
                    EliminacaoGauss g = new EliminacaoGauss();
                    g.CriarMatrizCoeficientes();
                    g.PreencherMatriz();
                    g.CriarVetor();
                    g.PreencherVetorTermosIndependentes();
                    g.OrganizarMatriz();
                    g.ResolucaoDoSistema();
                    g.MostrarResultados();
                    break;
                } 
                case 2:{
                    System.out.println("======================     PROJETO GAUSS POR PIVOTAÇÃO PARCIAL    ===================");
                    System.out.println("");
                    System.out.println("          =====================    Álgebra Linear    ==================\n");
                    System.out.println("\t             Desenvolvido pelos alunos do Curso de BCC:\n");
                    System.out.println("\t                   Geovânio José da Silva");
                    System.out.println("\t                José João Mario Araújo de Andrade\n\n");
                    System.out.println("\t                      Professor Orientador: ");
                    System.out.println("\t                         Murilo Chavedar     \n");
                    System.out.println("\t                             2016.2                 ");
                    System.out.println("===================================================================================\n\n");
                    break;    
                    }
                    case 3:{
                    System.out.println("======================     PROJETO GAUSS POR PIVOTAÇÃO PARCIAL    ===================");
                    System.out.println("===============================       Versão 1.0     ================================\n\n");
                    System.out.println("O método de Gauss consiste em operar transformações elementares sobre as equações de\n" +
                                       "um sistema Ax = b até que, depois de n ¡ 1 passos, se obtenha um sistema triangular\n " + 
                                       "superior, Ux = c, equivalente ao sistema dado, sistema esse que é resolvido por substituições\n" +
                                       "retroativas. A resolução deste sistema pelo método de Gauss envolve duas fases distintas.\n" + 
                                       "A primeira, chamada de fase de eliminação, consiste em transformar o sistema dado em um\n" +
                                       "sistema triangular superior. A segunda, chamada de fase de substituição, consiste em\n" +
                                       "resolver o sistema triangular superior através de substituições retroativas");
                    System.out.println("\n");
                    System.out.println("=====================================================================================\n\n");
                    break;
                    }
                case 0:{
                    System.out.println("========== VOCê DESEJA REALMENTE SAIR ? ======");
                    System.out.println("== 1 -- SIM \n== 2 -- NÃO\n");
                    System.out.println("==============================================");
                    int escolha2;
                    escolha2 = Scan.nextInt();
                    if(escolha2==1){
                        System.out.print("Obrigado por usar o Projeto Gauss por pivotação parcial!\n");
                        break;
                    }else{
                        Tela.TelaPrincipal();
                    }
                }       
            }
        }
    }
}

