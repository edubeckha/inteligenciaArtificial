/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author rr
 */
public class Minimax {

    public FuncaoUtilidade f;
    int profundidadeMaxima = 0;
    GeradorJogada gj;
    int turno = 1;

    public Minimax(int profundidade) {
        this.profundidadeMaxima = profundidade;
        this.f = new FuncaoUtilidade();
        this.gj = new GeradorJogada(15);

    }

    public void minimax(Nodo anterior, Nodo n, Tabuleiro t, int profundidadeAtual) {
        if (n.ehFolha() && !n.ehRaiz()) {
            n.setPai(anterior);
            n.setValor(f.valorNodo(n, t));
        } else {
            if (profundidadeAtual == profundidadeMaxima) {
                n.setPai(anterior);
                n.setValor(f.valorNodo(n, t));
                n.setFolha(true);

            } else {

                //se nao for o mais profundo, entao novas jogadas sao geradas
            /*Para cada nova jogada criada, o minimax deve ser invocado.
                 * Quando a volta da recursão ocorrer deve-se atualizar os valores de cada nodo.
                 * A primeira condicao serve para atualizar os valores de MAX(IA), já a segunda para atualizar o MIN(Humano)
                 */
                boolean jogadorAtual = t.getJogadorAtual();

                t.setJogadorAtual(!jogadorAtual);
                Nodo novoNodo;
                ArrayList<Nodo> nodos = new ArrayList<>();
              //  nodos = gj.criarJogada(turno);
                for (int i = 0; i < 2; i++) {
                    //turno só deveria ser atualizado antes do for.    
                    turno++;
                    //ao inves de pegar o jogador do tabuleiro, seria melhor inverter o jogador do nodo pai do novoNodo?
                    System.out.println("proximo jogador : " + !n.getJogadorAtual());
                    novoNodo = new Nodo(turno, !n.getJogadorAtual(), false);
                    int profundidadeAnterior = profundidadeAtual;
                    inicializaValorNodo(novoNodo, n);
                    //n.setFilho(novaJogada);
                    minimax(n, novoNodo, t, ++profundidadeAtual);
                    profundidadeAtual = profundidadeAnterior;
                    //retorno da arvore, onde os valores sao atualizados
                    int comparacao = Double.compare(n.getValor(), novoNodo.getValor());
                    //n.getValor() < novoNodo.getValor()
                    /*Inicio das possiveis podas. Atualizacao de alfa só em jogadas MAX e att de beta em jogadas MIN.*/
                    if (n.getJogador() == 0) {
                        //se o valor do novoNodo for mais relevante que o alfa anterior, entao é preciso atualizar o alfa antecessor.
                        if (novoNodo.getValor() > n.getAlfa()) {
                            n.setAlfa(novoNodo.getValor());
                        }
                        if (comparacao < 0) {
                            n.setValor(novoNodo.getValor());
                        }
                        //teoricamente n já teria o valor de beta, pois foi passado pelo seu pai.
                        if (n.getAlfa() > n.getBeta()) {
                            break;
                        }

                    } else {
                        if (novoNodo.getValor() < n.getBeta()) {
                            n.setBeta(novoNodo.getValor());
                        }
                        if (comparacao > 0) {
                            n.setValor(novoNodo.getValor());
                        }
                        if (n.getBeta() < n.getAlfa()) {
                            System.out.println("poda beta");
                            break;
                        }

                    }

                    /*if (comparacao < 0  && n.getJogador() == 0) {
                     n.setValor(novoNodo.getValor());

                     } else {
                     double resto = +n.getValor() - novoNodo.getValor();
                     System.out.println("comparacao: " + n.getValor() + "\n NOVOnODO : " + novoNodo.getValor() + "\n sub: " + resto);
                     //n.getValor() >= novoNodo.getValor()
                     if (comparacao > 0 && n.getJogador() == 1) {
                     n.setValor(novoNodo.getValor());

                     }
                     }*/
                }
                t.setJogadorAtual(!jogadorAtual);

            }

        }
    }
    /*metodo usado para iniciar os valores do nodo: pai, alfa e beta. Inserir apenas depois de terminar*/

    public void inicializaValorNodo(Nodo novoNodo, Nodo nodo) {
        novoNodo.setFolha(false);
        novoNodo.setRaiz(false);
        novoNodo.setPai(nodo);
        //atualizacao do alfa e beta na "descida"        
        novoNodo.setAlfa(nodo.getAlfa());
        novoNodo.setBeta(nodo.getBeta());
        nodo.setFilho(novoNodo);

    }

    /**
     * @param args the command line arguments
     */
  /*  public static void main(String[] args) {

        Minimax m = new Minimax(2);
        Jogada j = new Jogada(0);

        Nodo n = new Nodo(0, true, false);
        n.setRaiz(true);
        Tabuleiro t = new Tabuleiro(3, 3);
        t.setJogadorAtual(true);
        m.minimax(n, n, t, 0);

    }*/

}
