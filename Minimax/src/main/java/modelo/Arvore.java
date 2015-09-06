package modelo;

public class Arvore {
    public Nodo raiz;
    
    public static Arvore instancia;
    
    public static Arvore retornaInstancia(){
        if(instancia == null){
            instancia = new Arvore();
        }
        return instancia;
    }
    public Arvore(){
        raiz = new Nodo(null);
    }
    
    public void descerArvore(Nodo aux){
        while(!aux.ehFolha){ //verifica se o nodo nao eh folha
            for(Nodo nodo : aux.filhos){
                descerArvore(nodo);
            }
        }
        //chegou no nodo folha...fazer aqui o retorno para o pai
    }
}
