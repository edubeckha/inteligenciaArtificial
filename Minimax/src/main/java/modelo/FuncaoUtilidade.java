package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class FuncaoUtilidade {
   Sequencia sequencia;
   public int valorFuncaoUtilidade;
   
    
    public FuncaoUtilidade(){
        sequencia = new Sequencia();
    }
    public double valorNodo(Nodo n,Tabuleiro t){            
    /*n.setValor(sequencia.retornaMelhorSequenciaIA().retornaValorSequencia() - sequencia.retornaMelhorSequenciaHumano().retornaValorSequencia());
     return 0;*/
        this.sequencia.verificaCasas(n.j.posicaoJogada.length, n.j.posicaoJogada);
        return sequencia.retornaMelhorSequenciaIA().retornaValorSequencia() - sequencia.retornaMelhorSequenciaHumano().retornaValorSequencia();
    }    
    public double valorNodo(Nodo n,int turnoAtual){            
    /*n.setValor(sequencia.retornaMelhorSequenciaIA().retornaValorSequencia() - sequencia.retornaMelhorSequenciaHumano().retornaValorSequencia());
     return 0;*/
        this.sequencia.verificaCasas(n.j.posicaoJogada.length, n.j.posicaoJogada);
        return sequencia.retornaMelhorSequenciaIA().retornaValorSequencia() - sequencia.retornaMelhorSequenciaHumano().retornaValorSequencia();
        //return sequencia.retornaMelhorSequenciaIA().retornaValorSequencia() - sequencia.retornaMelhorSequenciaHumano().retornaValorSequencia() - turnoAtual;
        //return 1;
    }    
        
}
