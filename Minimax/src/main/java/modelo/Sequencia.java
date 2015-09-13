package modelo;

import java.util.ArrayList;

/**
 *
 * @author rodrigom
 */
public class Sequencia {

    public TipoSequencia tipoSequencia;
    public ArrayList<Identificador> idsJogadas;
    public ArrayList<TipoSequencia> sequenciasHumano, sequenciasIA;

    public Sequencia() {
        idsJogadas = new ArrayList<>();
        sequenciasHumano = new ArrayList<>();
        sequenciasIA = new ArrayList<>();
        //tipoSequencia = verificaCasas(); 
    }

    //passar por todo o array de identificadores para criar uma determinada sequencia (tiposequencia)
    private TipoSequencia verificaCasas(int linhas, int colunas, int[][] tabuleiro) {
        int contadorSequenciaIA = 0, contadorSequenciaHumano = 0, maxContadorHumano = 0, maxContadorIA = 0;
        int pivo = 0;

        /**
         * Itera sobre as colunas da matriz, recebendo uma linha
         *
         * O pivo começa em zero e assim que receber um valor != 0, começa a
         * contar a sequencia. A partir do momento que a casa muda de valor, o
         * contador sabera qual o tamanho da sequencia
         *
         */
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (tabuleiro[i][j] == 0) { //acabou a sequencia e a casa proxima eh vazia
                    pivo = 0;
                    contadorSequenciaHumano = 0;
                    contadorSequenciaIA = 0;
                    continue;
                }

                //a jogada mudou
                if (tabuleiro[i][j] != pivo && pivo != 0) { //alguem me barrou - comeca outra sequencia
                    if (pivo == 1) { //caso anterior, para atualizar o valor de maxContador
                        if (contadorSequenciaHumano > maxContadorHumano) {
                            maxContadorHumano = contadorSequenciaHumano;
                            
                        }
                        contadorSequenciaHumano = 0;
                        pivo = 2;
                        contadorSequenciaIA++;
                    } else {
                        if (contadorSequenciaIA > maxContadorIA) {
                            maxContadorIA = contadorSequenciaIA;
                        }
                        contadorSequenciaIA = 0;
                        pivo = 1;
                        contadorSequenciaHumano++;
                    }
                    continue;
                }

                //continua com a mesma sequencia do jogador
                if (tabuleiro[i][j] == 1) { //eh do humano
                    contadorSequenciaHumano++;
                    pivo = 1;
                    if (contadorSequenciaHumano > maxContadorHumano) {
                        maxContadorHumano = contadorSequenciaHumano;
                    }
                    continue;
                }
                if (tabuleiro[i][j] == 2) {
                    contadorSequenciaIA++;
                    pivo = 2;
                    if (contadorSequenciaIA > maxContadorIA) {
                        maxContadorIA = contadorSequenciaIA;

                    }
                }

            }
        }
        System.out.println("humano " + maxContadorHumano + " contador " + contadorSequenciaHumano);
        System.out.println("ia " + maxContadorIA + " ia " + contadorSequenciaIA);
        return null;
    }
    
    public void verificaMatriz(){
        
    }

    public static void main(String[] args) {
        int[][] matriz = new int[1][11];

        matriz[0][0] = 1;
        matriz[0][1] = 1;
        matriz[0][2] = 2;
        matriz[0][3] = 2;
        matriz[0][4] = 1;
        matriz[0][5] = 1;
        matriz[0][6] = 1;
        matriz[0][7] = 1;
        matriz[0][8] = 1;
        matriz[0][9] = 0;
        matriz[0][10] = 1;


        /* matriz[1][0] = 0;
         matriz[1][1] = 0;
         matriz[1][2] = 0;
         matriz[1][3] = 2;
         matriz[1][4] = 2;
       
       
         matriz[2][0] = ;
         matriz[2][1] = 1;
         matriz[2][2] = 1;
         matriz[2][3] = 1;
         matriz[2][4] = 1;
       
       
         matriz[3][0] = 1;
         matriz[3][1] = 1;
         matriz[3][2] = 1;
         matriz[3][3] = 1;
         matriz[3][4] = 1;
       
       
         matriz[4][0] = 1;
         matriz[4][1] = 1;
         matriz[4][2] = 1;
         matriz[4][3] = 1;
         matriz[4][4] = 1;  */
        Sequencia sequencia = new Sequencia();
        sequencia.verificaCasas(1, 11, matriz);

    }

}
