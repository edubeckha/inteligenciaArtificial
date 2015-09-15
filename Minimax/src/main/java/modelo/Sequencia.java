package modelo;

import java.util.ArrayList;
import java.util.Collections;

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
    synchronized private void verificaCasas(int ordem, int[][] tabuleiro) {

        ArrayList<ThreadCalculoMatriz> thread = new ArrayList<>();
        thread.add(new ThreadCalculoMatriz(ordem, TipoThread.LINHA, tabuleiro));
        thread.add(new ThreadCalculoMatriz(ordem, TipoThread.COLUNA, tabuleiro));
        thread.add(new ThreadCalculoMatriz(ordem, TipoThread.DIAGONALPRINCIPAL, tabuleiro));
        thread.add(new ThreadCalculoMatriz(ordem, TipoThread.DIAGONALSECUNDARIA, tabuleiro));
        int countThreads = 0;
        try {
            for (ThreadCalculoMatriz thread1 : thread) {
                thread1.start();
                thread1.join();
            }
        } catch (Exception ex) {}
        
        for (ThreadCalculoMatriz thread1 : thread) {
            sequenciasMaximasHumano.add(thread1.melhorSequenciaHumano);
            sequenciasMaximasIA.add(thread1.melhorSequenciaIA);
        }

        
        Collections.sort(sequenciasMaximasHumano);
        Collections.sort(sequenciasMaximasIA);
    }
    
    public TipoSequencia retornaMelhorSequenciaHumano(){
        return TipoSequencia.retornaTipoAPartirDeValor(sequenciasMaximasHumano.get(sequenciasMaximasHumano.size() - 1), false);
    }
    
    public TipoSequencia retornaMelhorSequenciaIA(){
        return TipoSequencia.retornaTipoAPartirDeValor(sequenciasMaximasIA.get(sequenciasMaximasIA.size() - 1), false);
    }
    
    

    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        matriz[0][0] = 2;
        matriz[0][1] = 0;
        matriz[0][2] = 0;
        matriz[0][3] = 0;

        matriz[1][0] = 1;
        matriz[1][1] = 2;
        matriz[1][2] = 0;
        matriz[1][3] = 0;

        matriz[2][0] = 0;
        matriz[2][1] = 1;
        matriz[2][2] = 0;
        matriz[2][3] = 0;

        matriz[3][0] = 0;
        matriz[3][1] = 0;
        matriz[3][2] = 1;
        matriz[3][3] = 0;

        Sequencia sequencia = new Sequencia();

        sequencia.verificaCasas(4, matriz);

    }
   

}
