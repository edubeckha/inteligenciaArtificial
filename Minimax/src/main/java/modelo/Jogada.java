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
public class Jogada {
    public int jogador,idJogada;
    //public Tabuleiro jogadaRealizada;
    
    public Jogada(int _jogador, int _idJogada){
        this.idJogada = _idJogada;
        this.jogador = _jogador;
    }
    
    public Jogada(int _jogador){
     
        this.jogador = _jogador;
    }
    
        
    
}
