package Classes;

import enums.enums.Direction;
import enums.enums.statuses;
import enums.enums.printType;

public class Board
{
    private static final int[] SHIP_LENGTHS = {2, 3, 4};
    private static final int TOTAL_SHIPS = 3;
    private int shipOccupancy;
    private Position[][] board;
    private Ship[] ships;

    // Constants for number of rows and columns.
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    
    public Board()
    {
        ships = new Ship[TOTAL_SHIPS];
        for (int i = 0; i < TOTAL_SHIPS; i++)
        {
            Ship newShip = new Ship(SHIP_LENGTHS[i]);
            ships[i] = newShip;
            shipOccupancy += SHIP_LENGTHS[i];
        }
        
        board = new Position[NUM_ROWS][NUM_COLS];
        
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                Position tempLoc = new Position();
                board[row][col] = tempLoc;
            }
        }
    }

    public Position[][] getPosition(){return this.board;}

    public Ship[] getShips(){ return this.ships;}

    public int getShipOccupancy(){return this.shipOccupancy;}

    public void addShip(Ship s)
    {
        int row = s.getRow();
        int col = s.getCol();
        int length = s.getLength();
        Direction dir = s.getDirection();

        if (dir == Direction.HORIZONTAL)
        {
            for (int i = col; i < col+length; i++)
            {
                board[row][i].setShip(true);
                board[row][i].setLengthOfShip(length);
                board[row][i].setDirection(dir);
            }
        }
        else if (dir == Direction.VERTICAL)
        {
            for (int i = row; i < row+length; i++)
            {
                board[i][col].setShip(true);
                board[i][col].setLengthOfShip(length);
                board[i][col].setDirection(dir);
            }
        }
    }

    public void print(printType type)
    {
        System.out.println();
        System.out.print("  ");
        for (int i = 1; i <= NUM_COLS; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // print rows
        for (int i = 1; i <= NUM_ROWS; i++)
        {
            System.out.print(i + " ");
            int k = i -1;
            for (int j = 0; j < NUM_COLS; j++)
            {
                if (type == printType.RESULT)
                {
                    if (board[k][j].getStatus() == statuses.PENDING)
                        System.out.print("- ");
                    else if (board[k][j].getStatus() == statuses.MISSED)
                        System.out.print("M ");
                    else if (board[k][j].getStatus() == statuses.HIT)
                        System.out.print("H ");
                }
                else if (type == printType.ARRANGEMENT) // type == 1; ships
                {
                    if (board[k][j].hasShip())
                    {
                        if (board[k][j].getLengthOfShip() == 2)
                        {
                            System.out.print("2 ");
                        }
                        else if (board[k][j].getLengthOfShip() == 3)
                        {
                            System.out.print("3 ");
                        }
                        else if (board[k][j].getLengthOfShip() == 4)
                        {
                            System.out.print("4 ");
                        }
                    }
                        
                    else if (!(board[k][j].hasShip()))
                    {
                        System.out.print("- ");
                    }
                        
                }
            }
            System.out.println();
        }
    }
}