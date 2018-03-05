package Classes;
import java.util.Scanner;

public class Start
{
    public static Scanner reader = new Scanner(System.in);
      
    public static void main(String[] args)
    {
        Game newGame = new Game();
        System.out.println("\n Press Enter to Start Game");
        reader.nextLine();
        newGame.Start();
    }
}