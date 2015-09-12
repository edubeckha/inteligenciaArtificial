package modelo;

import java.util.ArrayList;

/**
 *
 * @author rodrigom
 */
public class Sequencia {
    
    public TipoSequencia tipoSequencia;
    public ArrayList<Identificador> idsJogadas;
    
    public Sequencia(){
        idsJogadas = new ArrayList<>();
        //tipoSequencia = verificaCasas(); 
    }

    //passar por todo o array de identificadores para criar uma determinada sequencia (tiposequencia)
    private TipoSequencia verificaCasas(){
        return null;
    }
        
}
