package Classes;
import Interface.IPlayer;

import java.util.Scanner;

public class Start
{
    public static Scanner reader = new Scanner(System.in);
      
    public static void main(String[] args)
    {
        IPlayer rp = new RealPlayer();
        IPlayer cp = new ComputerPlayer();
        Game newGame = new Game(rp, cp);
        System.out.println("\n Press Enter to Start Game");
        reader.nextLine();
        newGame.start();
    }
}