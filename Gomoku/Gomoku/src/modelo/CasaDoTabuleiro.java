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
    
    public boolean estaOcupada(){
       return !(cor == Color.GRAY);
    }

    public void adicionaPeca(Color corPeca){
        cor = corPeca;
        setBackground(cor);
        setText(x + " , " + y);
    }
}
