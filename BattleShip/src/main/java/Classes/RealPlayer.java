package Classes;
import Interface.IPlayer;


public class RealPlayer implements IPlayer
{
    private final int TOTAL_CHANCES = 10;
    private Board shipBoard;
    private int chances;
    private int totalHit;
    private final boolean isAdmin = false;
    
    public RealPlayer()
    {
        shipBoard = new Board();
        this.totalHit = 0;
        this.chances = TOTAL_CHANCES;
    }

    public boolean isAdmin() {return this.isAdmin;}

    public Board getShipBoard(){ return this.shipBoard;}

    public void addTotalHit(){this.totalHit += 1;}

    public void decreaseChances(){this.chances -= 1;}

    public boolean hasLost()
    {
        if (this.chances <= 0)
            return true;
        else
            return false;
    }

    public boolean hasWon()
    {
        if (this.totalHit == this.shipBoard.getShipOccupancy())
            return true;
        else
            return false;
    }


}