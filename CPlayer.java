package domino;

import java.util.ArrayList;

/**
 *
 * @author bandyjo
 */
public class CPlayer extends CRandom {

    ArrayList<CDominoes> dominoPlayerDeck = new ArrayList<>();
    ArrayList<CDominoes> dominoTableDeck = new ArrayList<>();
    String playerName = "";
    String domino;

    public CPlayer(String name, ArrayList<CDominoes> playerDeck, ArrayList<CDominoes> tableDeck) {
        playerName = name;
        for (int i = 0; i < playerDeck.size(); i++) {
            dominoPlayerDeck.add(playerDeck.get(i));
        }
    }

    public String getName() {
        return playerName;
    }

    public void showHand(ArrayList<CDominoes> dominoPlayerDeck) {
                    System.out.print("Player " + playerName + "'s hand ");
        for (int i = 0; i < dominoPlayerDeck.size(); i++) {
            System.out.print(dominoPlayerDeck.get(i) + " ");
           
        }
    }

    public boolean checkDeck(ArrayList<CDominoes> dominoTableDeck) {
        if (dominoTableDeck.size() > 0) {
            System.out.println("The Table Deck has " + dominoTableDeck.size() + " dominoes remaining.");
            return true;
        } else {
            System.out.println("The Table Deck has 0 dominoes remaining");
            return false;
        }

    }//method that prints the amount of remaining dominoes in the table deck

}
