package domino;

import java.util.ArrayList;

/**
 *
 * @author bandyjo
 */
public class CMain {

    public static void main(String[] args) {
        new CMain().run();
    }

    public void run() {
        //int[] dominoNums = {0, 1, 2, 3, 4, 5, 6};
        ArrayList<CDominoes> dominoDeck = new ArrayList<>();

        for (int i = 0; i < 7; i++) {//creates dominoes and places them in the deck
            for (int j = 0; j <= i; j++) {
                dominoDeck.add(new CDominoes(i, j));
            }
        }

        ArrayList<CDominoes> player1Hand = new ArrayList<>();
        ArrayList<CDominoes> player2Hand = new ArrayList<>();

        CPlayer player1 = new CPlayer("Jack", player1Hand, dominoDeck);
        //System.out.println("Player 1 Hand: ");
        for (int i = 0; i < 10; i++) {
            player1.pickPieces(dominoDeck, player1Hand);
        }
        System.out.println(" ");//Creating Player 1, and drawing 10 dominos to put in their hand

        CPlayer player2 = new CPlayer("Patrick", player2Hand, dominoDeck);

        //System.out.println("Player 2 Hand: ");
        for (int i = 0; i < 10; i++) {
            player2.pickPieces(dominoDeck, player2Hand);
        }
        System.out.println(" ");//Creating Player 2, and drawing 10 dominos to put in their hand

        player1.showHand(player1Hand);
        System.out.println(" ");
        player2.showHand(player2Hand);
        System.out.println(" ");

        int firstToPlay;
        CTable table = new CTable(player1Hand, player2Hand);
        firstToPlay = table.placeFirstDomino(player1Hand, player2Hand);
        
        boolean gameOver = false;
        while (!gameOver) {
            if (table.player1Turn(player1Hand)==0 && firstToPlay == 2) { 
                table.drawPiece(player1Hand, dominoDeck);
                firstToPlay -= 1;
            }
            table.player1Turn(player1Hand);
            
            if (table.player2Turn(player2Hand)==0 && firstToPlay == 1) {
                table.drawPiece(player2Hand, dominoDeck);
                firstToPlay += 1;
            }
            table.player2Turn(player2Hand);
            
            if (table.player1Turn(player1Hand)==0 && table.player2Turn(player2Hand)==0 && dominoDeck.isEmpty()) {
                System.out.println("Neither player can move and the deck is empty. The game is over.");
                gameOver = true;
            }
            if (player1Hand.isEmpty()) {
                System.out.println("Player1 has no more pieces. Player1 wins!");
                gameOver = true; 
            }            
            if (player2Hand.isEmpty()) {
                System.out.println("Player2 has no more pieces. Player2 wins!");
                gameOver = true; 
            }
        }
    }
}
