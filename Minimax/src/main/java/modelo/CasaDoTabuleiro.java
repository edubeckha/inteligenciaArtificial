/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.Color;
import javax.swing.JButton;

public class CasaDoTabuleiro extends JButton {
    
    public Color cor;
    public int x, y;
    public CasaDoTabuleiro(int x, int y){
        this.x = x;
        this.y = y;
        cor = Color.GRAY;
        setBackground(cor);
    }
    
    /**
     * Verifica se a casa pertence ao humano
     * @return 
     */
    public boolean ehDoHumano(){
        return cor.equals(Color.WHITE);
    }
    
    /**
     * Verifica se a casa ja esta ocupada
     * @return 
     */
    public boolean estaOcupada(){
       return !(cor == Color.GRAY);
    }

    /**
     * Escolhe esta casa e a pinta com a cor do jogador atual
     * @param cor 
     */
    public void escolherCasa(Color cor){
        this.cor = cor;
        setBackground(cor);
        //setText(x + " , " + y);
    }
}
