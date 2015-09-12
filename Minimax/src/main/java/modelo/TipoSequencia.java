/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rodrigom
 */
public enum TipoSequencia {

    UNICA((int)Math.pow(4, 1)),
    DUPLA_FECHADA((int)Math.pow(4, 2)),
    DUPLA_ABERTA((int)Math.pow(4, 3)),
    TRIPLA_FECHADA((int)Math.pow(4, 4)),
    TRIPLA_ABERTA((int)Math.pow(4, 5)),
    QUADRUPLA_FECHADA((int)Math.pow(4, 6)),
    QUADRUPLA_ABERTA((int)Math.pow(4, 7)),
    QUINTUPLA(Integer.MAX_VALUE);

    public int valorSequencia = 0;
    
    private TipoSequencia(int valor){
        retornaTipoAPartirDeValor(valor);
    }
    private TipoSequencia(int valor,int turno){
        retornaTipoAPartirDeValor(valor);
    }
    
    public TipoSequencia retornaTipoAPartirDeValor(int valor){
        return null;
    }
    
    public TipoSequencia retornaTipoAPartirDeValor(int valor, int turno){
        return null;
    }
/*
    private void tipoSequencia(TipoSequencia ts) {
        switch (ts) {
            case UNICA:
                valorSequencia = (int) Math.pow(4, 1);
                break;            
            case DUPLA_FECHADA:
                valorSequencia = (int) Math.pow(4, 2);
                break;
             case DUPLA_ABERTA:
                valorSequencia = (int) Math.pow(4, 3);
                break;            
            case TRIPLA_FECHADA:
                valorSequencia = (int) Math.pow(4, 4);
                break;
                
                case TRIPLA_ABERTA:
                valorSequencia = (int) Math.pow(4, 5);
                break;
            case QUADRUPLA_FECHADA:
                valorSequencia = (int) Math.pow(4, 7);
                break;            
            case QUADRUPLA_ABERTA:
                valorSequencia = (int) Math.pow(4, 8);
                break;            
             default:
                 valorSequencia = Integer.MAX_VALUE;
                 break;
        }

    }*/
    public int valorSequencia() {
        return valorSequencia;
    }
}
