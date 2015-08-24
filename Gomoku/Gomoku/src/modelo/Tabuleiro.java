/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Tabuleiro {

    CasaDoTabuleiro[][] casasDoTabuleiro = new CasaDoTabuleiro[15][15];
   
    public Tabuleiro(int linhas, int colunas) {
        CasaDoTabuleiro aux;
        for (int x = 0; x < linhas; x++) {
            for (int y = 0; y < colunas; y++) {
                aux = new CasaDoTabuleiro(x, y);
                aux.addActionListener(this);
                painel.add(aux);
                casasDoTabuleiro[x][y] = aux;
            }
        }
    }
}
