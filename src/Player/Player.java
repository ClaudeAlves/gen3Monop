package Player;

import Game.*;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;

/**
 * class representing a player in a monopoly game
 * @author @author Guillaume Vetter & Luca Reis de Carvalho & Claude-André Alves
 */
public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private ArrayList<Die> dice;

    /**
     * Name Player constructor
     * @param name Player name
     */
    public Player(String name) {
        this.name = name;
    }
    /**
     * Player constructor
     * @param name Player name
     */
    public Player(String name, String piece, Board board, ArrayList<Die> dice) {
        this.piece = new Piece(piece, board.getSquare(0));
        this.board = board;
        this.dice = dice;
        this.name = name;
    }

    /**
     * Player getter
     * @return Player name
     */
    public String getName() {
        return name;
    }

    /**
     * Sequence of actions of a player taking his turn
     */
    public void takeTurn() {
        dice.get(0).roll();
        dice.get(1).roll();

        System.out.println("Player " + name +
                " rolled die 1 for " + dice.get(0).getFaceValue()
                + " and die 2 for " + dice.get(1).getFaceValue());
        piece.setLocation(board.getSquare(piece.getLocation(), dice.get(0).getFaceValue() + dice.get(1).getFaceValue()));
        System.out.println("Player " + name +
                " landed on square " + piece.getLocation().getName());
    }
}
