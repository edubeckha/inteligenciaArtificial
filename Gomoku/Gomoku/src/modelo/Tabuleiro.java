/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;

public class Tabuleiro {

    boolean vezHumano;
    CasaDoTabuleiro[][] casasDoTabuleiro = new CasaDoTabuleiro[15][15];
    int qttLinhas, qttColunas;
    public static Tabuleiro instancia;

    public static Tabuleiro retornaInstancia(boolean vezHumano) {
        if (instancia == null) {
            instancia = new Tabuleiro(vezHumano);
        }
        return instancia;
    }

    public Tabuleiro(boolean vezHumano) {
        this.vezHumano = vezHumano;
        qttLinhas = 15;
        qttColunas = 15;
    }

    public CasaDoTabuleiro[][] adicionarCasas() {
        CasaDoTabuleiro aux;
        for (int x = 0; x < qttLinhas; x++) {
            for (int y = 0; y < qttColunas; y++) {
                aux = new CasaDoTabuleiro(x, y);
                casasDoTabuleiro[x][y] = aux;
            }
        }

        return casasDoTabuleiro;
    }

    public boolean realizarJogada(CasaDoTabuleiro casaClicada) {
        if (casaClicada.estaOcupada()) {
            return false;
        }
        casaClicada.adicionaPeca(vezHumano ? Color.WHITE : Color.BLACK);
        vezHumano = !vezHumano;
        return verificaTabuleiro(casaClicada);
    }

    public boolean verificaTabuleiro(CasaDoTabuleiro casaClicada) {
        int aux_x = casaClicada.x;
        int aux_y = casaClicada.y;
        int contador = 1;

        //verifica na mesma linha
        for (int y = 0; y < qttColunas - 1; y++) {
            if (casasDoTabuleiro[aux_x][y].cor.equals(casasDoTabuleiro[aux_x][y + 1].cor) && casasDoTabuleiro[aux_x][y].estaOcupada()) {
                contador++;
            } else {
                contador = 1;
            }
            if (contador >= 5) {
                return true;
            }

        }

        //verifica na mesma coluna
        for (int x = 0; x < qttLinhas - 1; x++) {
            if (casasDoTabuleiro[x][aux_y].cor.equals(casasDoTabuleiro[x + 1][aux_y].cor) && casasDoTabuleiro[x][aux_y].estaOcupada()) {
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
                if (casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal].cor.equals(casasDoTabuleiro[aux_x_diagonal + 1][aux_y_diagonal + 1].cor) && casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal].estaOcupada()) {
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
                if (casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal].cor.equals(casasDoTabuleiro[aux_x_diagonal - 1][aux_y_diagonal + 1].cor) && casasDoTabuleiro[aux_x_diagonal][aux_y_diagonal].estaOcupada()) {
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
    
    public void limpar(){
        instancia = null;
    }
}
