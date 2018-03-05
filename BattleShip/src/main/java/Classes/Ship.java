package Classes;

import enums.enums.Direction;

public class Ship
{

    private int row;
    private int col;
    private int length;
    private Direction direction;

    public Ship(int length)
    {
        this.length = length;
        this.row = -1;
        this.col = -1;
        this.direction = Direction.NONE;
    }

    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public int getLength()
    {
        return length;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public Direction getDirection()
    {
        return direction;
    }

}