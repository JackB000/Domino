package domino;

import java.util.ArrayList;

/**
 *
 * @author bandyjo
 * @author perkinspa
 */
public class CTable {

    int top, bottom, turnCounter = -1;

    public int turn() {
        return turnCounter;
    }

    public void topBottom() {
        System.out.println("Top " + top + " Bottom " + bottom);
    }

    public CTable(ArrayList<CDominoes> player1Hand, ArrayList<CDominoes> player2Hand) {

    }

    public void placeFirstDomino(ArrayList<CDominoes> player1Hand, ArrayList<CDominoes> player2Hand) {
        CDominoes highestTwin = new CDominoes(-1, -1);

        int highestTwinIndex = -1;
        for (int i = 0; i < player1Hand.size(); i++) {
            if (player1Hand.get(i).isTwin() && player1Hand.get(i).sum() > highestTwin.sum()) {
                highestTwin = player1Hand.get(i);
                highestTwinIndex = player1Hand.indexOf(player1Hand.get(i));
                turnCounter = 1;
            }
        }

        for (int i = 0; i < player2Hand.size(); i++) {
            if (player2Hand.get(i).isTwin() && player2Hand.get(i).sum() > highestTwin.sum()) {
                highestTwin = player2Hand.get(i);
                highestTwinIndex = player2Hand.indexOf(player2Hand.get(i));
                turnCounter = 2;
            }
        }
        top = highestTwin.getTop();
        bottom = highestTwin.getBottom();

        switch (turnCounter) {
            case 1:
                player1Hand.remove(highestTwinIndex);
                break;
            case 2:
                player2Hand.remove(highestTwinIndex);
                break;

        }
        System.out.println("The first piece played is " + highestTwin + " by Player "
                + turnCounter);
    }

    public int player2Turn(ArrayList<CDominoes> player2Hand) {
        if (turnCounter == 1) {//player 2 plays

            for (int i = 0; i < player2Hand.size(); i++) {
                if (player2Hand.get(i).getTop() == top) {
                    top = player2Hand.get(i).getBottom();
                    System.out.println("The next piece played by Player Patrick"
                            + " is " + player2Hand.get(i));
                    player2Hand.remove(player2Hand.get(i));
                    turnCounter = 2;
                    return turnCounter;

                }
            }

            for (int i = 0; i < player2Hand.size(); i++) {
                if (player2Hand.get(i).getTop() == bottom) {
                    bottom = player2Hand.get(i).getBottom();
                    System.out.println("The next piece played by Player Patrick"
                            + " is " + player2Hand.get(i));

                    player2Hand.remove(player2Hand.get(i));
                    turnCounter = 2;
                    return turnCounter;

                }
            }

            for (int i = 0; i < player2Hand.size(); i++) {
                if (player2Hand.get(i).getBottom() == top) {
                    top = player2Hand.get(i).getTop();
                    System.out.println("The next piece played by Player Patrick"
                            + " is " + player2Hand.get(i));

                    player2Hand.remove(player2Hand.get(i));
                    turnCounter = 2;
                    return turnCounter;

                }
            }

            for (int i = 0; i < player2Hand.size(); i++) {
                if (player2Hand.get(i).getBottom() == bottom) {
                    bottom = player2Hand.get(i).getTop();
                    System.out.println("The next piece played by Player Patrick"
                            + " is " + player2Hand.get(i));
                    player2Hand.remove(player2Hand.get(i));
                    turnCounter = 2;
                    return turnCounter;

                }
            }
            return 0;
        }
        else {
            return 3;
        }
    }

    public int player1Turn(ArrayList<CDominoes> player1Hand) {

        if (turnCounter == 2) {//player 1 plays
            for (int i = 0; i < player1Hand.size(); i++) {
                if (player1Hand.get(i).getTop() == top) {
                    top = player1Hand.get(i).getBottom();
                    System.out.println("The next piece played by Player Jack "
                            + " is " + player1Hand.get(i));
                    player1Hand.remove(player1Hand.get(i));
                    turnCounter = 1;
                    return turnCounter;

                }
            }

            for (int i = 0; i < player1Hand.size(); i++) {
                if (player1Hand.get(i).getTop() == bottom) {

                    bottom = player1Hand.get(i).getBottom();
                    System.out.println("The next piece played by Player Jack"
                            + " is " + player1Hand.get(i));
                    player1Hand.remove(player1Hand.get(i));
                    turnCounter = 1;
                    return turnCounter;

                }
            }
            for (int i = 0; i < player1Hand.size(); i++) {
                if (player1Hand.get(i).getBottom() == top) {
                    top = player1Hand.get(i).getTop();
                    System.out.println("The next piece played by Player Jack"
                            + " is " + player1Hand.get(i));
                    player1Hand.remove(player1Hand.get(i));
                    turnCounter = 1;
                    return turnCounter;

                }
            }

            for (int i = 0; i < player1Hand.size(); i++) {
                if (player1Hand.get(i).getBottom() == bottom) {
                    bottom = player1Hand.get(i).getTop();
                    System.out.println("The next piece played by Player Jack"
                            + " is " + player1Hand.get(i));
                    player1Hand.remove(player1Hand.get(i));
                    turnCounter = 1;
                    return turnCounter;

                }
            }
            return 0;
        }
        else{
            return 3;
        }
    }
    

    public void drawPiece(ArrayList<CDominoes> playerHand, ArrayList<CDominoes> tableDeck, CPlayer player) {
        for (int i = 0; i < tableDeck.size(); i++) {
            if (tableDeck.isEmpty()) {
                System.out.println("Player " + player.getName() + " skips");
                return;
            }
            if (tableDeck.get(i).getTop() == top) {
                playerHand.add(tableDeck.get(i));
                tableDeck.remove(tableDeck.get(i));
                System.out.println("Player " + player.getName() + " picked up a piece");
                return;
            }
            if (tableDeck.get(i).getTop() == bottom) {
                playerHand.add(tableDeck.get(i));
                tableDeck.remove(tableDeck.get(i));
                System.out.println("Player " + player.getName() + " picked up a piece");
                return;
            }
            if (tableDeck.get(i).getBottom() == top) {
                playerHand.add(tableDeck.get(i));
                tableDeck.remove(tableDeck.get(i));
                System.out.println("Player " + player.getName() + " picked up a piece");
                return;
            }            
            if (tableDeck.get(i).getBottom() == bottom) {
                playerHand.add(tableDeck.get(i));
                tableDeck.remove(tableDeck.get(i));
                System.out.println("Player " + player.getName() + " picked up a piece");
                return;
            }
            playerHand.add(tableDeck.get(i));
            tableDeck.remove(tableDeck.get(i));
            System.out.println("Player " + player.getName() + " picked up a piece");
        }
    }
}
