package domino;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author bandyjo
 */
public class CRandom {
    
    public int pickPieces(ArrayList<CDominoes> tableDeck, ArrayList<CDominoes> playerDeck) {
        Random randomNum = new Random();        
        int randomDomino = randomNum.nextInt(tableDeck.size());
        playerDeck.add(tableDeck.get(randomDomino));
        tableDeck.remove(randomDomino);
        /*System.out.print((tableDeck.remove(randomDomino)) + " ");*/
        return randomDomino;
    }
    
}
