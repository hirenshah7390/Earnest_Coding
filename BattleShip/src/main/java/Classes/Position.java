package Classes;

import enums.enums.statuses;
import enums.enums.Direction;

public class Position
{

    private boolean hasShip;
    private statuses status;
    private int lengthOfShip;
    private Direction directionOfShip;

    public Position()
    {
        status = statuses.PENDING;
        hasShip = false;
        lengthOfShip = -1;
        directionOfShip = Direction.NONE;
    }

    public boolean hasShip()
    {
        return hasShip;
    }

    public void setShip(boolean val)
    {
        this.hasShip = val;
    }

    public void setStatus(statuses status)
    {
        this.status = status;
    }

    public statuses getStatus(){return this.status;}

    public int getLengthOfShip()
    {
        return lengthOfShip; 
    }
    
    public void setLengthOfShip(int val)
    {
        lengthOfShip = val;
    }
    
    public void setDirection(Direction val)
    {
        directionOfShip = val;
    }
}