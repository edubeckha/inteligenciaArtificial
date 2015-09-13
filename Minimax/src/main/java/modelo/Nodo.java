package modelo;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  
public class Nodo {
    private int label;
    private double alfa = Integer.MIN_VALUE;
    private double beta = Integer.MAX_VALUE;
    private List<Nodo> filhos = new ArrayList<>();
    private Nodo pai;
    private boolean folha = false;
    private boolean raiz = false;
    private double valor;
    private Jogada j;
    
    public Nodo(int label, Nodo pai){
        this.label = label;
        this.pai = pai;
    }
    public Nodo(int label, boolean raiz){
        this.label = label;
        this.raiz = raiz;
        
        
        
    }
    public Nodo(int label){
        this.label = label;
       
        
    }
    public int getJogador(){
        return this.j.jogador;
    }
    public Nodo(int label, boolean turno, boolean folha){
        this.label = label;
        if(turno){
            //jogada MAX            
            this.j = new Jogada(0);
            valor = Integer.MIN_VALUE;
            
        }else{
            //jogada MIN
            this.j = new Jogada(1);
            valor = Integer.MAX_VALUE;
        }
       
        
    }
    public Nodo(Nodo n){
        //clonar o objeto
    }
    //obtem label do filho a partir do nodo passado por parametro. Verificar se é melhor passar por referencia ou realizar copia.
    public void setFilho(Nodo n){
        this.filhos.add(n);
    }
    public void setPai(Nodo pai){
        this.pai = pai;
    }
    public boolean ehFolha(){
        return this.folha;
    }
    public boolean ehRaiz(){
        return this.raiz;
        
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    public void setFolha(boolean valor){
        this.folha = valor;
    }
    public void setRaiz(boolean valor){
        this.raiz = valor;
    }
    public double getValor(){
        return this.valor;
    }

    boolean getJogadorAtual() {
        //se valor == 0, entao é a IA, se nao o humano
        return this.j.jogador == 0;
    }

    double getAlfa() {
        return alfa;
    }
    
    double getBeta() {
        return beta;
    }

    void setAlfa(double d) {
        this.alfa = d;
    }

    void setBeta(double d) {
        this.beta = d;
    }
    
    
    
    
    
    
    
    
}
