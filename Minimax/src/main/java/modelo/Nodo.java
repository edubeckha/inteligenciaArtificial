package modelo;

import java.util.ArrayList;

public class Nodo {
    
    public long label;
    public Nodo pai;
    public ArrayList<Nodo> filhos;
    public boolean ehRaiz, ehFolha;
    
    public Nodo(Nodo pai){
        filhos = new ArrayList<>();
        if(pai == null){
            ehRaiz = true;
        }
        ehFolha = true;   
    }
    
    public void adicionarFilhos(Nodo filho){
        filhos.add(filho);
        
        ehFolha = false;
    }
    
}
