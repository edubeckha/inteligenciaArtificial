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
public class GeradorJogada {

    private int teste = 4;
    private int areaJogadas = 1;
    private int alcanceMaximo = 5;
    private int indiceMaximo = 15;

    //vector<Nodo> jogadas;
    public GeradorJogada(int tamanhoTabuleiro) {
        this.indiceMaximo = tamanhoTabuleiro;
    }

    public Nodo criarJogada(int valor) {
        return null;

    }
    /*A partir da ultima jogada criar jogadas ao redor desse id
     Nodo anterior possui uma jogada associada a ele, e entao obtem-se em que posicao foi realizada a jogada
    
     */

    public ArrayList<Nodo> criaJogada(Tabuleiro t, Nodo anterior) {

        int[][] tabTemp = t.casasDoTabuleiro;
        int areaJogadaAux = this.areaJogadas;
        int coordenadaLinha, coordenadaColuna;
        ArrayList<Nodo> jogadasVerticais = new ArrayList<>();
        ArrayList<Nodo> jogadasHorizontais = new ArrayList<>();
        ArrayList<Nodo> jogadasDiagonalPrincipal = new ArrayList<>();
        ArrayList<Nodo> jogadasDiagonalSecundaria = new ArrayList<>();

        //colocar threads para realizar as verificacoes em todas as posicoes
        /*
         (x-3,y),(x-2,y),(x-1,y)  <- (x,y) -> (x+1,y), (x+2,y), (x+3,y)
        
         */
        while (areaJogadaAux < this.alcanceMaximo) {
            coordenadaLinha = anterior.j.linhaOrigem - areaJogadaAux;
            coordenadaColuna = anterior.j.colunaOrigem - areaJogadaAux;

            jogadasHorizontais = gerarJogadasHorizontal(tabTemp, anterior);

            if ((coordenadaLinha) >= 0 && (coordenadaColuna) >= 0) {//diagonal principal
                //se a condicao acima for verdadeira, entao existe a possibilidade de criar uma jogada.
                //    jogadasDiagonalPrincipal = gerarJogadasDiagonalPrincipal(tabTemp,anterior.getJogador());
            }

            areaJogadaAux++;
        }

        return null;

    }
    //modo XGH on
    private ArrayList<Nodo> gerarJogadasHorizontal(int[][] tab, Nodo anterior) {
          int areaJogadaAux = this.areaJogadas;
        int areaJogadaDec = this.alcanceMaximo;
        int coordenadaColunaInc, coordenadaColunaDec;
        ArrayList<Nodo> jogadasValidas = new ArrayList<>();
        int linhaAux = anterior.j.linhaOrigem;
        int colunaAux = anterior.j.colunaOrigem;

        while (areaJogadaAux < alcanceMaximo || areaJogadaDec > 0) {

            coordenadaColunaInc = anterior.j.colunaOrigem + areaJogadaAux;
            coordenadaColunaDec = --colunaAux;
            if (coordenadaColunaInc < this.indiceMaximo) {
                //posicao ainda é válida  
                if (tab[linhaAux][coordenadaColunaInc] == 0) {
                    Nodo nodo = new Nodo(linhaAux + " " + coordenadaColunaInc);
                    tab[linhaAux][coordenadaColunaInc] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), linhaAux, coordenadaColunaInc);
                    jogadasValidas.add(nodo);

                }

            }
            if (coordenadaColunaDec >= 0) {

                //posicao nao é negativa e ninguem jogou naquela posicao
                if (tab[linhaAux][coordenadaColunaDec] == 0) {
                    Nodo nodo = new Nodo(linhaAux + " " + coordenadaColunaDec);
                    tab[linhaAux][coordenadaColunaDec] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), linhaAux, coordenadaColunaDec);
                    jogadasValidas.add(nodo);

                }

            }
            areaJogadaAux++;
            areaJogadaDec--;
        }
        for (Nodo jogadasValida : jogadasValidas) {
            System.out.println(jogadasValida.j.linhaOrigem + " " + jogadasValida.j.colunaOrigem + " "+jogadasValida.getJogador());

        }
        return jogadasValidas;
    }

    private ArrayList<Nodo> gerarJogadasVertical(int[][] tab, Nodo anterior) {
        //valor para ir incrementando
        int areaJogadaAux = this.areaJogadas;
        int areaJogadaDec = this.alcanceMaximo;
        int coordenadaLinhaInc, coordenadaLinhaDec;
        ArrayList<Nodo> jogadasValidas = new ArrayList<>();
        int linhaAux = anterior.j.linhaOrigem;
        int colunaAux = anterior.j.colunaOrigem;

        while (areaJogadaAux < alcanceMaximo || areaJogadaDec > 0) {

            coordenadaLinhaInc = anterior.j.linhaOrigem + areaJogadaAux;
            coordenadaLinhaDec = --linhaAux;
            if (coordenadaLinhaInc < this.indiceMaximo) {
                //posicao ainda é válida  
                if (tab[coordenadaLinhaInc][colunaAux] == 0) {
                    Nodo nodo = new Nodo(coordenadaLinhaInc + " " + colunaAux);
                    tab[coordenadaLinhaInc][colunaAux] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), coordenadaLinhaInc, colunaAux);
                    jogadasValidas.add(nodo);

                }

            }
            if (coordenadaLinhaDec >= 0) {

                //posicao nao é negativa e ninguem jogou naquela posicao
                if (tab[coordenadaLinhaDec][colunaAux] == 0) {
                    Nodo nodo = new Nodo(coordenadaLinhaDec + " " + colunaAux);
                    tab[coordenadaLinhaDec][colunaAux] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), coordenadaLinhaDec, colunaAux);
                    jogadasValidas.add(nodo);

                }

            }
            areaJogadaAux++;
            areaJogadaDec--;
        }
        for (Nodo jogadasValida : jogadasValidas) {
            System.out.println(jogadasValida.j.linhaOrigem + " " + jogadasValida.j.colunaOrigem + " "+jogadasValida.getJogador());

        }
        return jogadasValidas;

    }

    private ArrayList<Nodo> gerarJogadasDiagonalPrincipal(int[][] tab, Nodo anterior) {
        //valor para ir incrementando
        int areaJogadaAux = this.areaJogadas;
        int areaJogadaDec = this.alcanceMaximo;
        int coordenadaInc, coordenadaDec;
        ArrayList<Nodo> jogadasValidas = new ArrayList<>();
        int linhaAux = anterior.j.linhaOrigem;
        int colunaAux = anterior.j.colunaOrigem;

        while (areaJogadaAux < alcanceMaximo || areaJogadaDec > 0) {

            coordenadaInc = anterior.j.linhaOrigem + areaJogadaAux;
            coordenadaDec = --linhaAux;
            if (coordenadaInc < this.indiceMaximo) {
                //posicao ainda é válida  
                if (tab[coordenadaInc][coordenadaInc] == 0) {
                    Nodo nodo = new Nodo(coordenadaInc + " " + coordenadaInc);
                    tab[coordenadaInc][coordenadaInc] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), coordenadaInc, coordenadaInc);
                    jogadasValidas.add(nodo);

                }

            }
            if (coordenadaDec >= 0) {

                //posicao nao é negativa e ninguem jogou naquela posicao
                if (tab[coordenadaDec][coordenadaDec] == 0) {
                    Nodo nodo = new Nodo(coordenadaDec + " " + coordenadaDec);
                    tab[coordenadaDec][coordenadaDec] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), coordenadaDec, coordenadaDec);
                    jogadasValidas.add(nodo);

                }

            }
            areaJogadaAux++;
            areaJogadaDec--;
        }
        for (Nodo jogadasValida : jogadasValidas) {
            System.out.println(jogadasValida.j.linhaOrigem + " " + jogadasValida.j.colunaOrigem + " "+jogadasValida.getJogador());

        }
        return jogadasValidas;
    }

    private ArrayList<Nodo> gerarJogadasDiagonalSecundaria(int[][] tab, Nodo anterior) {
        return null;
    }

    public boolean existeNovaJogada() {
        return false;
    }/*
    private ArrayList<Nodo> gerarJogadas(int[][] tab, Nodo anterior,int variaTab, int fixoTab) {
        //valor para ir incrementando
        int areaJogadaAux = this.areaJogadas;
        int areaJogadaDec = this.alcanceMaximo;
        int coordenadaLinhaInc, coordenadaLinhaDec;
        ArrayList<Nodo> jogadasValidas = new ArrayList<>();
        int incrAux = variaTab;
        int colunaAux = fixoTab;

        while (areaJogadaAux < alcanceMaximo || areaJogadaDec > 0) {

            coordenadaLinhaInc = variaTab + areaJogadaAux;
            coordenadaLinhaDec = --incrAux;
            if (coordenadaLinhaInc < this.indiceMaximo) {
                //posicao ainda é válida  
                if (tab[coordenadaLinhaInc][colunaAux] == 0) {
                    Nodo nodo = new Nodo(coordenadaLinhaInc + " " + colunaAux);
                    tab[coordenadaLinhaInc][colunaAux] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), coordenadaLinhaInc, colunaAux);
                    jogadasValidas.add(nodo);

                }

            }
            if (coordenadaLinhaDec >= 0) {

                //posicao nao é negativa e ninguem jogou naquela posicao
                if (tab[coordenadaLinhaDec][colunaAux] == 0) {
                    Nodo nodo = new Nodo(coordenadaLinhaDec + " " + colunaAux);
                    tab[coordenadaLinhaDec][colunaAux] = anterior.j.obterProximoJogador();
                    nodo.j = new Jogada(tab, anterior.j.obterProximoJogador(), coordenadaLinhaDec, colunaAux);
                    jogadasValidas.add(nodo);

                }

            }
            areaJogadaAux++;
            areaJogadaDec--;
        }
        for (Nodo jogadasValida : jogadasValidas) {
            System.out.println(jogadasValida.j.linhaOrigem + " " + jogadasValida.j.colunaOrigem);

        }
        return jogadasValidas;

    }*/
    

    

    public static void main(String[] args) {
        GeradorJogada gj = new GeradorJogada(8);
        Nodo raiz = new Nodo(1, true);
        Jogada j = new Jogada(2);
        j.colunaOrigem = 0;
        j.linhaOrigem = 0;
        raiz.j = j;
        Tabuleiro t = new Tabuleiro(8, 8, true);
        //t.realizarJogada(0, 6);
        //t.realizarJogada(0, 3);
//        gj.gerarJogadasVertical(t.casasDoTabuleiro, raiz);
//        gj.gerarJogadasHorizontal(t.casasDoTabuleiro, raiz);
        gj.gerarJogadasDiagonalPrincipal(t.casasDoTabuleiro, raiz);

    }

}
