/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.CasaDoTabuleiro;
import modelo.Constantes;

public class Tabuleiro extends javax.swing.JFrame implements ActionListener {

    public boolean vezHumano;
    CasaDoTabuleiro[][] casasDoTabuleiro = new CasaDoTabuleiro[15][15];
    int linhas = 15, colunas = 15;

    public Tabuleiro(boolean vHumano) {
        initComponents();
        vezHumano = vHumano;
        painel.setLayout(new GridLayout(linhas, colunas));
        painel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        CasaDoTabuleiro aux;
        for (int x = 0; x < linhas; x++) {
            for (int y = 0; y < colunas; y++) {
                aux = new CasaDoTabuleiro(x, y);
                aux.addActionListener(this);
                painel.add(aux);
                casasDoTabuleiro[x][y] = aux;
            }
        }
    }

    public void realizaJogada(CasaDoTabuleiro casaClicada) {
        if (casaClicada.cor != Color.gray) {
            return;
        }
        casaClicada.adicionaPeca(vezHumano ? Color.WHITE : Color.BLACK);
        vezHumano = !vezHumano;
        verificaTabuleiro(casaClicada);
    }

    public void verificaTabuleiro(CasaDoTabuleiro casaClicada) {
        int aux_x = casaClicada.x;
        int aux_y = casaClicada.y;
        int contador = 1;

        //verifica na mesma linha
        for (int y = 0; y < colunas - 1; y++) {
            if (casasDoTabuleiro[aux_x][y].cor.equals(casasDoTabuleiro[aux_x][y + 1].cor) && casasDoTabuleiro[aux_x][y].estaOcupada()) {
                contador++;
            } else {
                contador = 1;
            }
            if (contador >= 5) {
                resultado("passou aqui");
                return;
            }
        }

        //verifica na mesma coluna
        for (int x = 0; x < linhas - 1; x++) {
            if (casasDoTabuleiro[x][aux_y].cor.equals(casasDoTabuleiro[x + 1][aux_y].cor) && casasDoTabuleiro[x][aux_y].estaOcupada()) {
                contador++;
            } else {
                contador = 1;
            }
            if (contador >= 5) {
                resultado("PASSOU AQ");
                return;
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
                resultado("passou na diagonal");
                return;
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
                resultado("passou na diagonal");
                return;
            }
        }

    }

    public void resultado(String resultado) {
        JOptionPane.showMessageDialog(this, resultado);
    }

    class MeuContadorEspecialFofinho {

        public int count = 1;
        public Color cor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabuleiro(false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        realizaJogada((CasaDoTabuleiro) e.getSource());
    }
}
