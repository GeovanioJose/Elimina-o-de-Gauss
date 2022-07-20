/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI_console;

import java.util.Scanner;

/**
 *
 * @author Geovânio José da Silva & José João Mario Araújo
 */
public class Console {
    
    public int TelaPrincipal(){
        int escolha=-1;
        Scanner Scan = new Scanner(System.in); 
        System.out.println(" @author Geovânio José da Silva & José João Mario Araújo de Andrade\n");
        System.out.println("=========    PROJETO MÉTODO DE GUASS    =========");
        System.out.println("============= Álgebra Linear ===================");
        System.out.println("== 1 -- FORNENCER MATRIZ \n== 2 -- CREDITOS \n== 3 -- SOBRE \n== 0 -- SAIR");
        System.out.println("==============================================");
        try{
            escolha = Scan.nextInt();
        }catch(Exception InputMismatchException){
            return escolha;
        } 
        switch(escolha){
            case 1:{
               return(escolha);
            }
            case 2:{
                return(escolha);
            }
            case 3:{
                return(escolha);
            }
            case 0:{
                return(escolha);
            }
        }
        return escolha;
    }
    
}
