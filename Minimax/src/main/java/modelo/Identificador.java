package modelo;

/**
 *
 * @author rodrigom
 */
public class Identificador {
    public String turno, idJogador, i; 
    
    public Identificador(int _turno, int _idJogador, int _i){
        turno = Integer.toString(_turno);
        idJogador = Integer.toString(_idJogador);
        i = Integer.toString(_i);
    }
   
    /**
     * Retorna identificador
     * @return 
     */
   public String retornaIdentificador(){
        return (turno + idJogador + i);
   }    
}
