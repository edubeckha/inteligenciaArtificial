/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rr
 */
public class Tabuleiro {
    private boolean jogadorAtual;
    
    public Tabuleiro(int linha, int coluna) {
    jogadorAtual = true;
    
}


    public boolean turnoIA(){
        return jogadorAtual;
    }

    public boolean getJogadorAtual(){
        return jogadorAtual;
    }

    public void setJogadorAtual(boolean valor){
        System.out.println("valor "+valor);
        this.jogadorAtual = valor;
    }

    
}
