/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Scanner;

public class Minimax {

    public static void main(String[] args) {

        int escolha = 0;
        while (escolha != 5) {
            System.out.print("1- Inserir novo nodo \n 2-Inserir valor no nodo folha \n 3-Verificar Valor do nodo Folha\n 5-Sair");
            Scanner scan = new Scanner(System.in);
            escolha = scan.nextInt();
            
            switch(escolha){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }

    }

}
