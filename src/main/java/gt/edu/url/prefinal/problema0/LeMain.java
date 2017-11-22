package gt.edu.url.prefinal.problema0;

import gt.edu.url.prefinal.problema1.ArrayCifradoCesar;
import gt.edu.url.prefinal.problema1.CifradoCesar;
import gt.edu.url.prefinal.problema3.LinkedManoCartas;
import gt.edu.url.prefinal.problema3.ManoCartas;

/**
 *
 * @author tuxtor
 */
public class LeMain {

    
    public static void main(String[] args) {
//        CifradoCesar cesar = new ArrayCifradoCesar();
//        System.out.println(
//            cesar.cifrarCesar("HOLA MUNDO", 3)
//        );

        ManoCartas lasCartas = new LinkedManoCartas();
        
        lasCartas.agregarCarta('1', "espada");
        lasCartas.agregarCarta('2', "espada");
        
        lasCartas.agregarCarta('1', "trebol");
        
        lasCartas.agregarCarta('9', "trebol");
        
        Character test = lasCartas.jugar("corazon");
        
        if(test == '9'){
            System.out.println("Se obtuvo la mano correcta");
        }else{
            System.out.println("Se obtuvo un caracter diferente");
        }
            
        
    }
    
}
