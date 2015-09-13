package modelo;

import java.util.ArrayList;

/**
 *
 * @author rodrigom
 */
public class Sequencia {

    public TipoSequencia tipoSequencia;
    public ArrayList<Identificador> idsJogadas;
    public ArrayList<Integer> sequenciasMaximasHumano, sequenciasMaximasIA;
    int melhorSequenciaHumano, melhorSequenciaIA;

    public Sequencia() {
        sequenciasMaximasHumano = new ArrayList<>();
        sequenciasMaximasIA = new ArrayList<>();
        idsJogadas = new ArrayList<>();
    }

    //passar por todo o array de identificadores para criar uma determinada sequencia (tiposequencia)
    synchronized private TipoSequencia verificaCasas(int ordem, int[][] tabuleiro) {

        ArrayList<MinhaThreadFofinha> thread = new ArrayList<>();
        thread.add(new MinhaThreadFofinha(ordem, TipoThread.LINHA, tabuleiro));
        thread.add(new MinhaThreadFofinha(ordem, TipoThread.COLUNA, tabuleiro));
        thread.add(new MinhaThreadFofinha(ordem, TipoThread.DIAGONALPRINCIPAL, tabuleiro));
        //   thread.add(new MinhaThreadFofinha(ordem, TipoThread.DIAGONALSECUNDARIA, tabuleiro));
        int countThreads = 0;
        try {
            for (MinhaThreadFofinha thread1 : thread) {
                thread1.run();
                thread1.join();
            }
        } catch (Exception ex) {

        }

        return null;
    }

    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        matriz[0][0] = 1;
        matriz[0][1] = 1;
        matriz[0][2] = 1;
        matriz[0][3] = 1;

        matriz[1][0] = 0;
        matriz[1][1] = 2;
        matriz[1][2] = 2;
        matriz[1][3] = 1;

        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 2;
        matriz[2][3] = 1;

        matriz[3][0] = 0;
        matriz[3][1] = 0;
        matriz[3][2] = 2;
        matriz[3][3] = 0;

        Sequencia sequencia = new Sequencia();

        sequencia.verificaCasas(4, matriz);

    }

}
