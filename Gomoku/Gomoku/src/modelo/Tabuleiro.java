package modelo;


public class Tabuleiro {

     public boolean vezHumano;
    int[][] casasDoTabuleiro = new int[15][15];
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
        adicionarCasas();
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
            if (casasDoTabuleiro[i][aux_y] == casasDoTabuleiro[i + 1][aux_y]  && casasDoTabuleiro[i][aux_y] != 0 ) {
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
    
    public void limpar(){
        instancia = null;
    }
}
