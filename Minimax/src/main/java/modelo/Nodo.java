package modelo;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  int label,alfa,beta = 0;
    bool folha = false;
    std::vector <std::shared_ptr<Nodo>> filhos;
    std::shared_ptr<Nodo> pai;
    bool raiz = false;
    //seria ideal passar apenas a coordenada das casas ocupadas por esse nodo?
    std::shared_ptr<Tabuleiro> tabuleiro;
    //no lugar de passar um tabuleiro, é mais fácil passar um valor que representa a jogada atual.
    double valor = 0;
    Nodo(int label, Nodo pai);
    Nodo(int label);
    Nodo(int label, bool raiz);
    Nodo(const Nodo& orig);
    //virtual ~Nodo();
    void setFilho(std::shared_ptr<Nodo> filho);
    void setFilho(Nodo filho);
    void setFilhos(std::vector<std::shared_ptr<Nodo>> filhos);
    bool ehFolha();
    bool ehRaiz();
    void setNota(double nota);
    void setPai(Nodo pai);
  
 * @author rr
 */
public class Nodo {
    private int label,alfa,beta;
    private List<Nodo> filhos = new ArrayList<>();
    private Nodo pai;
    private boolean folha = false;
    private boolean raiz = false;
    private double valor = 0;
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
            this.j = new Jogada(0);
            
        }else{
            this.j = new Jogada(1);
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
    
    
    
    
    
    
    
    
}
