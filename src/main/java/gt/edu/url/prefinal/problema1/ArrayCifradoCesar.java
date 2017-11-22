package gt.edu.url.prefinal.problema1;

/**
 *
 * @author tuxtor
 */
public class ArrayCifradoCesar implements CifradoCesar{
    
    /**
     * Search position of a given character in uppercase alphabet
     * @return 
     */
    
    private int searchInAlphabeth(String alphabet, char desiredChar){
        
        char[] chars = alphabet.toCharArray();
        
        for(int i=0; i< chars.length; i++){
            if(Character.toUpperCase(desiredChar) == Character.toUpperCase(chars[i]))
                return i;
        }
        return -1;
    }

    @Override
    public String cifrarCesar(String frase, int distancia) {
        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String nuevaFrase = "";
        
        char[] original = frase.toCharArray();
        
        for(int i  = 0; i < original.length; i++){
            char originalChar = original[i];
            
            if(originalChar == ' '){
                nuevaFrase += originalChar;
            }else{
                int shift = searchInAlphabeth(alfabeto, originalChar) + distancia;
                char newChar = ' ';
                if(shift > alfabeto.length()){
                    shift = shift - alfabeto.length();
                }
                
                if(Character.isUpperCase(originalChar)){
                    newChar = alfabeto.charAt(shift);
                }else{
                    newChar = Character.toLowerCase(alfabeto.charAt(shift));
                }
                nuevaFrase += newChar;
            }
            
        }
        
        return nuevaFrase;
    }

    @Override
    public String cifrarCesar(String frase, String alfabeto, int distancia) {
        String nuevaFrase = "";
        
        char[] original = frase.toCharArray();
        
        for(int i  = 0; i < original.length; i++){
            char originalChar = original[i];
            
            if(originalChar == ' '){
                nuevaFrase += originalChar;
            }else{
                int shift = i + distancia;
                
                if(shift > alfabeto.length()){
                    shift = shift - alfabeto.length();
                }
                
                if(Character.isUpperCase(originalChar)){
                    char newChar = alfabeto.charAt(shift);
                }else{
                    char newChar = Character.toLowerCase(alfabeto.charAt(shift));
                }
            }
            
        }
        
        return nuevaFrase;
    }
    
}
