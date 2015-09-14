/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
        this.posicaoJogada = tabuleiro;
        this.jogador = _jogador;
        this.colunaOrigem = coluna;
        this.linhaOrigem = linha;
    }
    
    public Jogada(int[][] tabuleiro, int _jogador){
        this.posicaoJogada = tabuleiro;
        this.jogador = _jogador;
    }
    public int obterProximoJogador(){
        
        return this.jogador == 1 ? 2 : 1;
    }
    
        
    
}
