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
              
                boolean jogadorAtual = t.getJogadorAtual();              
                
                t.setJogadorAtual(!jogadorAtual);
                Nodo novoNodo;
                for (int i = 0; i < 2; i++) {
                    
                    turno++;
                    //ao inves de pegar o jogador do tabuleiro, seria melhor inverter o jogador do nodo pai do novoNodo?
                    System.out.println("proximo jogador : "+!n.getJogadorAtual());
                    novoNodo = new Nodo(turno, !n.getJogadorAtual(), false);
                    novoNodo.setFolha(false);
                    novoNodo.setRaiz(false);
                    novoNodo.setPai(n);
                    n.setFilho(novoNodo);
                    int profundidadeAnterior = profundidadeAtual;
                    

                //n.setFilho(novaJogada);
                    minimax(n, novoNodo, t, ++profundidadeAtual);
                    profundidadeAtual = profundidadeAnterior;
                //retorno da arvore, onde os valores sao atualizados

                    if (n.getValor() < novoNodo.getValor() && n.getJogador() == 0) {
                        n.setValor(novoNodo.getValor());

                    } else {
                        double resto = +n.getValor()-novoNodo.getValor();
                        System.out.println("comparacao: "+n.getValor() +"\n NOVOnODO : "+novoNodo.getValor()+"\n sub: "+resto);
                        if (n.getValor() >= novoNodo.getValor() && n.getJogador() == 1) {
                            n.setValor(novoNodo.getValor());


                        }
                    }

                }
                t.setJogadorAtual(!jogadorAtual);


            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Minimax m = new Minimax(2);
        Jogada j = new Jogada(0);
        
        Nodo n = new Nodo(0, true,false);
        Tabuleiro t = new Tabuleiro(3, 3);
        t.setJogadorAtual(true);
        m.minimax(n, n, t, 0);

    }

}
