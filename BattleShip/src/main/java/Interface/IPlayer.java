package Interface;

import Classes.Board;
import Classes.Ship;

public interface IPlayer {
    Board getShipBoard();
    boolean isAdmin();
    boolean hasLost();
    boolean hasWon();
    void addTotalHit();
    void decreaseChances();
}
