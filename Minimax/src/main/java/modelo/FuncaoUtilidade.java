package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rr
 */
public class FuncaoUtilidade {
    private int counter = 4;
    
    
    public double valorNodo(Nodo n,Tabuleiro t){            
        double c = counter;
        counter--;
        return c;
        /*
        if(random > 0.5){
            return +1;
        }
            return -1;
        */
    }    
        
}
