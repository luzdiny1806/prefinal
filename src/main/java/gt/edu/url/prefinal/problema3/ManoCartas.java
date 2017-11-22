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
public interface ManoCartas {
    public Position<Character> agregarCarta(Character valor, String categoria);
    public Character jugar(String categoria);
    
}
