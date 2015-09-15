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
    
    public Minimax(int profundidade, int tamanho,int alcanceMaximoBusca) {
        this.profundidadeMaxima = profundidade;
        this.f = new FuncaoUtilidade();
        this.gj = new GeradorJogada(tamanho,alcanceMaximoBusca);

    }

    public void minimax(Nodo anterior, Nodo n, Tabuleiro t, int profundidadeAtual) {
        if (n.ehFolha() && !n.ehRaiz()) {
            //mudar o metodo ehFolha e verificar se é fim de jogo ou nao!!!
            n.setPai(anterior);
            n.setValor(f.valorNodo(n, turno));
        } else {
            if (profundidadeAtual == profundidadeMaxima) {
                n.setPai(anterior);
                n.setValor(f.valorNodo(n, turno));
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
                nodos = gj.criaJogada(t, n);
              //  nodos = gj.criarJogada(turno);
                turno++;
                

                for (Nodo novoN : nodos){
                    //nodos devem vir com jogador atual, tabuleiro, e coordenadas atualizados do gerador de jogada.
                    //aqui atualiza-se apenas os filhos, pai e etc...
                    
                    
                    System.out.println("proximo jogador : " + !n.getJogadorAtual());
                    //novoNodo = new Nodo(turno, !n.getJogadorAtual(), false);
                   // novoN.setValor(!n.getJogadorAtual());
                    int profundidadeAnterior = profundidadeAtual;
                    inicializaValorNodo(novoN, n);
                    //n.setFilho(novaJogada);
                    minimax(n, novoN, t, ++profundidadeAtual);
                    profundidadeAtual = profundidadeAnterior;
                    //retorno da arvore, onde os valores sao atualizados
                    int comparacao = Double.compare(n.getValor(), novoN.getValor());
                    //n.getValor() < novoNodo.getValor()
                    /*Inicio das possiveis podas. Atualizacao de alfa só em jogadas MAX e att de beta em jogadas MIN.*/
                    if (n.getJogador() == 1) {
                        //se o valor do novoNodo for mais relevante que o alfa anterior, entao é preciso atualizar o alfa antecessor.
                        if (novoN.getValor() > n.getAlfa()) {
                            n.setAlfa(novoN.getValor());
                        }
                        if (comparacao < 0) {
                            n.setValor(novoN.getValor());
                        }
                        //teoricamente n já teria o valor de beta, pois foi passado pelo seu pai.
                        if (n.getAlfa() > n.getBeta()) {
                            break;
                        }

                    } else {
                     
                        if (novoN.getValor() < n.getBeta()) {
                            n.setBeta(novoN.getValor());
                        }
                        if (comparacao > 0) {
                            n.setValor(novoN.getValor());
                        }
                        if (n.getBeta() < n.getAlfa()) {
                            System.out.println("poda beta");
                            break;
                        }

                    }

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
   public static void main(String[] args) {

        Minimax m = new Minimax(2,3,2);
        Jogada j = new Jogada(2);
        j.colunaOrigem = 1;
        j.linhaOrigem = 1;
        Tabuleiro t = new Tabuleiro(3, 3,false);
        t.casasDoTabuleiro[1][1] = 2;
        t.setJogadorAtual(true);
        j.posicaoJogada = t.casasDoTabuleiro;
        
        

        Nodo n = new Nodo(0, true, false);
        n.j = j;
        n.setRaiz(true);
        
        m.minimax(n, n, t, 0);

    }

}
