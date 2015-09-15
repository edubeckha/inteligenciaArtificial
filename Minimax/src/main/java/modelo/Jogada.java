/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Arrays;

/**
 *
 * @author rr
 * jogador = 1 -> Humano
 * jogador = 2 -> IA
 */
public class Jogada {
    public int jogador,idJogada;
    public int linhaOrigem = 0,colunaOrigem = 0;
    public int[][] posicaoJogada;
    
    
    //public Tabuleiro jogadaRealizada;
    
    public Jogada(int _jogador, int _idJogada){
        this.idJogada = _idJogada;
        this.jogador = _jogador;
    }
    
    public Jogada(int _jogador){
     
        this.jogador = _jogador;
    }
    public Jogada(int[][] tabuleiro, int _jogador, int linha, int coluna){
        posicaoJogada = new int[tabuleiro.length][tabuleiro[0].length];
        copyJogada(tabuleiro);
        this.jogador = _jogador;
        this.colunaOrigem = coluna;
        this.linhaOrigem = linha;
    }
    
    public Jogada(int[][] tabuleiro, int _jogador){
        posicaoJogada = new int[tabuleiro.length][tabuleiro[0].length];
        copyJogada(tabuleiro);
        this.jogador = _jogador;
    }
    public int obterProximoJogador(){
        return this.jogador == 1 ? 2 : 1;
    }
    public void copyJogada(int[][] tabuleiro){
         for(int i = 0; i < tabuleiro.length;i++){
             System.arraycopy(tabuleiro[i], 0, this.posicaoJogada[i], 0, tabuleiro[i].length);
        }
        
    }
    
        
    
}
