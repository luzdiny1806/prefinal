/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.url.prefinal.problema3;

/**
 *
 * @author tuxtor
 */
public class LinkedManoCartas implements ManoCartas {
    
    CategoriaCartas<Character> mano = new CategoriaCartas<>();
    Position<Character> espada, corazon, diamante, trebol;
    
    public Position<Character> agregarCarta(Character valor, String categoria){
        switch(categoria){
            case "espada":espada = addOrCreate(valor, espada, mano); return espada;
            case "corazon":corazon = addOrCreate(valor, corazon, mano); return corazon;
            case "diamante":diamante = addOrCreate(valor, diamante, mano); return diamante;
            case "trebol":trebol = addOrCreate(valor, trebol, mano); return trebol;
        }
        return  null;
    }
    
    
    public Character jugar(String categoria){
        //Probar si la categoria existe
        Character resultado = null;
        
        try {
            switch(categoria){
                case "espada": resultado = mano.remove(espada); break;
                case "corazon":resultado = mano.remove(corazon); break;
                case "diamante":resultado = mano.remove(diamante); break;
                case "trebol":resultado = mano.remove(trebol); break;
            }
            return resultado;
        } catch (IllegalArgumentException|NullPointerException e) {
            //Check one by one if not null
            System.out.println("La posicion no existe");
        }
        
        return null;
    }
    
    public Position<Character> addOrCreate(Character valor, Position<Character> referencia, CategoriaCartas<Character> coleccion){
        if(referencia == null){
            //Agregamos al inicio
            referencia = coleccion.addFirst(valor);
        }else{
            //Agregamos despues
            referencia = coleccion.addAfter(referencia, valor);
        }
        return referencia;
    }
}
