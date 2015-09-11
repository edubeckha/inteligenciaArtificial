/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimax;

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
        this.gj = new GeradorJogada();

    }

    public void minimax(Nodo anterior, Nodo n, Tabuleiro t, int profundidadeAtual) {
        if (n.ehFolha() && !n.ehRaiz()) {
            //se o nodo analisado for folha, então ele terá uma nota. Para ser folha a quantidade de filhos deve ser 0
            n.setPai(anterior);
            n.setValor(f.valorNodo(n, t));

        } else {
            if (profundidadeAtual == profundidadeMaxima) {
                //quando a profundidade maxima for atingida entao é retornado o valor aproximado daquele nodo
                n.setPai(anterior);
                n.setValor(f.valorNodo(n, t));
                n.setFolha(true);
            } else {

                //se nao for o mais profundo, entao novas jogadas sao geradas
            /*Para cada nova jogada criada, o minimax deve ser invocado.
                 * Quando a volta da recursão ocorrer deve-se atualizar os valores de cada nodo.
                 * A primeira condicao serve para atualizar os valores de MAX(IA), já a segunda para atualizar o MIN(Humano)
                 */
                for (int i = 0; i < 2; i++) {
                    
                    turno++;
                    t.setJogadorAtual(!t.getJogadorAtual());
                    Nodo novoNodo = new Nodo(turno, t.getJogadorAtual(), false);
                    novoNodo.setFolha(false);
                    novoNodo.setRaiz(false);
                    n.setFilho(novoNodo);
                    int profundidadeAnterior = profundidadeAtual;
                    

                //n.setFilho(novaJogada);
                    minimax(n, novoNodo, t, ++profundidadeAtual);
                    profundidadeAtual = profundidadeAnterior;
                //retorno da arvore, onde os valores sao atualizados

                    if (n.getValor() < novoNodo.getValor() && novoNodo.getJogador() == 0) {
                        n.setValor(novoNodo.getValor());
                        t.setJogadorAtual(!t.getJogadorAtual());

                    } else {
                        if (n.getValor() > novoNodo.getValor() && novoNodo.getJogador() == 1) {
                            n.setValor(novoNodo.getValor());
                            t.setJogadorAtual(!t.getJogadorAtual());

                        }
                    }

                }

            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nodo n = new Nodo(0, true);
        Minimax m = new Minimax(1);
        Tabuleiro t = new Tabuleiro(3, 3);
        t.setJogadorAtual(true);
        m.minimax(n, n, t, 0);

    }

}
