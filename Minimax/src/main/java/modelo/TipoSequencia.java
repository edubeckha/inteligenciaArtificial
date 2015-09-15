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

    UNICA_FECHADA((int) Math.pow(4, 1)),
    UNICA_ABERTA((int) Math.pow(4, 1)),
    DUPLA_FECHADA((int) Math.pow(4, 2)),
    DUPLA_ABERTA((int) Math.pow(4, 3)),
    TRIPLA_FECHADA((int) Math.pow(4, 4)),
    TRIPLA_ABERTA((int) Math.pow(4, 5)),
    QUADRUPLA_FECHADA((int) Math.pow(4, 6)),
    QUADRUPLA_ABERTA((int) Math.pow(4, 7)),
    QUINTUPLA(Integer.MAX_VALUE);

    public int valorSequencia = 0;

    private TipoSequencia(int valor) {
    }

    public static TipoSequencia retornaTipoAPartirDeValor(int valor, boolean fechado) {
        switch (valor) {
            case 1:
                if (fechado) {
                    return UNICA_FECHADA;
                }
                return UNICA_ABERTA;
            case 2:
                if (fechado) {
                    return DUPLA_FECHADA;
                }
                return DUPLA_ABERTA;
            case 3:
                if (fechado) {
                    return TRIPLA_FECHADA;
                }
                return TRIPLA_ABERTA;
            case 4:
                if (fechado) {
                    return QUADRUPLA_FECHADA;
                }
                return QUADRUPLA_ABERTA;
            case 5:
                return QUINTUPLA;

        }
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

    public int retornaValorSequencia() {
        return valorSequencia;
    }
}
