package modelo;

public class ThreadCalculoMatriz extends Thread {

    public int ordem, melhorSequenciaHumano, melhorSequenciaIA;
    int contadorSequenciaIA = 0, contadorSequenciaHumano = 0, pivo = 0;

    public TipoThread tipoThread;
    public int[][] matrizElementos;

    public ThreadCalculoMatriz(int nOrdem, TipoThread th, int[][] matriz) {
        ordem = nOrdem;
        tipoThread = th;
        matrizElementos = matriz;
    }

    @Override
    public void run() {
        switch (tipoThread) {
            case LINHA:
                iteraLinha();
                break;
            case COLUNA:
                iteraColuna();
                break;
            case DIAGONALPRINCIPAL:
                iteraDiagonalPrincipal();
                break;
            case DIAGONALSECUNDARIA:
                iteraDiagonalSecundaria();
                break;
            default:
                break;
        }
    }

    private void iteraLinha() {
        for (int i = 0; i < ordem; i++) {
            contadorSequenciaHumano = 0;
            contadorSequenciaIA = 0;
            for (int j = 0; j < ordem; j++) {
                verificaMatriz(i, j, matrizElementos);
            }
        }
        System.out.println("humano Linha" + melhorSequenciaHumano);
        System.out.println("IA Linha" + melhorSequenciaIA);

    }

    private void iteraColuna() {
        for (int i = 0; i < ordem; i++) {
            contadorSequenciaHumano = 0;
            contadorSequenciaIA = 0;
            for (int j = 0; j < ordem; j++) {
                verificaMatriz(j, i, matrizElementos);
            }
        }

        System.out.println("humano Coluna" + melhorSequenciaHumano);
        System.out.println("IA Coluna" + melhorSequenciaIA);
    }

    private void iteraDiagonalPrincipal() {
        for (int i = 0; i < ordem; i++) {
            verificaMatriz(i, i, matrizElementos);
        }

        System.out.println("humano Diagonal Principal " + melhorSequenciaHumano);
        System.out.println("IA Diagonal Principal" + melhorSequenciaIA);
    }

    //TODO: fazer depois
    private void iteraDiagonalSecundaria() {
        int linha, coluna = -1;
        for (int i = 0; i < ordem; i++) {
            linha = i;
            for (int j = 0; j < i + 1; j++) {
                //verificaMatriz(linha--, ++coluna, matrizElementos);
            }
            coluna = -1;
        }

        for (int i = ordem - 1 ; i >= 0; i--) {
            coluna = ordem - 1;
            linha = i ;
            
            for(int j = 0; j < (ordem-i); j++){
                verificaMatriz(linha++, coluna--, matrizElementos);
            }       
        }

        System.out.println("humano Diagonal secundaria " + melhorSequenciaHumano);
        System.out.println("IA Diagonal secundaria" + melhorSequenciaIA);
    }

    public void verificaMatriz(int i, int j, int[][] tabuleiro) {

        if (tabuleiro[i][j] == 0) { //acabou a sequencia e a casa proxima eh vazia
            pivo = 0;
            contadorSequenciaHumano = 0;
            contadorSequenciaIA = 0;
            return;
        }
        //a jogada mudou
        if (tabuleiro[i][j] != pivo && pivo != 0) { //alguem me barrou - comeca outra sequencia
            if (pivo == 1) { //caso anterior, para atualizar o valor de maxContador
                if (contadorSequenciaHumano > melhorSequenciaHumano) {
                    melhorSequenciaHumano = contadorSequenciaHumano;
                }
                contadorSequenciaHumano = 0;
                pivo = 2;
                contadorSequenciaIA++;
            } else {
                if (contadorSequenciaIA > melhorSequenciaIA) {
                    melhorSequenciaIA = contadorSequenciaIA;
                }
                contadorSequenciaIA = 0;
                pivo = 1;
                contadorSequenciaHumano++;
            }
            return;
        }

        //continua com a mesma sequencia do jogador
        if (tabuleiro[i][j] == 1) { //eh do humano
            contadorSequenciaHumano++;
            pivo = 1;
            if (contadorSequenciaHumano > melhorSequenciaHumano) {
                melhorSequenciaHumano = contadorSequenciaHumano;
            }
            return;
        }
        if (tabuleiro[i][j] == 2) {
            contadorSequenciaIA++;
            pivo = 2;
            if (contadorSequenciaIA > melhorSequenciaIA) {
                melhorSequenciaIA = contadorSequenciaIA;
            }
        }
    }

}
