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
    public boolean vezHumano;
    public int[][] casasDoTabuleiro = new int[15][15];
    int qttLinhas, qttColunas;
    public static Tabuleiro instancia;
    public int hX, hY;

    public static Tabuleiro retornaInstancia(boolean vezHumano) {
        if (instancia == null) {
            instancia = new Tabuleiro(vezHumano);
        }
        return instancia;
    }

    public Tabuleiro(int linha, int coluna, boolean vezHumano) {
        this.vezHumano = vezHumano;
        casasDoTabuleiro = new int[linha][coluna];
    }

    public Tabuleiro(boolean vezHumano) {
        this.vezHumano = vezHumano;
        qttLinhas = 15;
        qttColunas = 15;
        adicionarCasas();
    }
    public void executaMinimax(){
        if(!vezHumano){
            Nodo raiz = new Nodo(0);
            raiz.setRaiz(true);
            Jogada j = new Jogada(casasDoTabuleiro, obterJogador(), hX, hY);
            raiz.j = j;
            raiz.setValoresPadrao();
            Minimax m = new Minimax(4, qttLinhas, 2);
            m.minimax(raiz, raiz, this, 0);
            procuraJogadaRaiz(raiz);
        }
    }
    /*A partir da raiz obter a proxima jogada a ser realizada
    */
    public void procuraJogadaRaiz(Nodo raiz){
        for (Nodo filho : raiz.getFilhos()) {            
            if(Double.compare(filho.getValor(), raiz.getValor()) == 0){
                System.out.println("melhor jogada é humano: "+hX + " "+ hY);
                System.out.println("melhor jogada é: "+filho.j.linhaOrigem + " "+ filho.j.colunaOrigem);
                realizarJogada(filho.j.linhaOrigem, filho.j.colunaOrigem);
                break;
            }
        }
    }
    
    public int obterJogador(){
        return vezHumano == true ? 1 : 2;
    }
    /**
     * Adiciona todas as casas na matriz
     */
    public final void adicionarCasas() {

        for (int x = 0; x < qttLinhas; x++) {
            for (int y = 0; y < qttColunas; y++) {
                casasDoTabuleiro[x][y] = 0;
            }
        }
    }

    public boolean realizarJogada(int x, int y) {
        if (casasDoTabuleiro[x][y] != 0) {
            return false;
        }
        casasDoTabuleiro[x][y] = vezHumano ? 1 : 2;
        vezHumano = !vezHumano;
        this.hX = x;
        this.hY = y;
        return true;
    }

    public boolean verificaTabuleiro(int x, int y) {
        int aux_x = x;
        int aux_y = y;
        int contador = 1;

        //verifica na mesma linha
        for (int i = 0; i < qttColunas - 1; i++) {
            if (casasDoTabuleiro[aux_x][i] == casasDoTabuleiro[aux_x][i + 1] && casasDoTabuleiro[aux_x][i] != 0) {
                contador++;
            } else {
                contador = 1;
            }
            if (contador >= 5) {
                return true;
            }

        }

        //verifica na mesma coluna
        for (int i = 0; i < qttLinhas - 1; i++) {
            if (casasDoTabuleiro[i][aux_y] == casasDoTabuleiro[i + 1][aux_y] && casasDoTabuleiro[i][aux_y] != 0) {
                contador++;
            } else {
                contador = 1;
            }
            if (contador >= 5) {
                return true;
            }

        }

        int aux_x_diagonal = aux_x - 4;
        int aux_y_diagonal = aux_y - 4;

        //verifica diagonal
        contador = 1;
        for (int i = 0; i < 8; i++) {
            try {
                if (casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal] == casasDoTabuleiro[aux_x_diagonal + 1][aux_y_diagonal + 1] && casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal] != 0) {
                    contador++;
                } else {
                    contador = 1;
                }
            } catch (Exception e) {
                contador = 1;
            }
            aux_x_diagonal++;
            aux_y_diagonal++;
            if (contador >= 5) {
                return true;
            }
        }

        aux_x_diagonal = aux_x + 4;
        aux_y_diagonal = aux_y - 4;
        for (int j = 0; j < 8; j++) {
            try {
                if (casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal] == casasDoTabuleiro[aux_x_diagonal - 1][aux_y_diagonal + 1] && casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal] != 0) {
                    contador++;
                } else {
                    contador = 1;
                }
            } catch (Exception e) {

            }
            aux_x_diagonal--;
            aux_y_diagonal++;
            if (contador >= 5) {
                return true;
            }
        }
        return false;
    }

    public void limpar() {
        instancia = null;
    }

    public Tabuleiro(int linha, int coluna) {

        jogadorAtual = true;

    }

    public boolean turnoIA() {
        return jogadorAtual;
    }

    public boolean getJogadorAtual() {
        return jogadorAtual;
    }
//true é ia, e false é humano

    public void setJogadorAtual(boolean valor) {
        System.out.println("valor " + valor);
        this.jogadorAtual = valor;
    }

}
