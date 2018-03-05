package Classes;

import Interface.IPlayer;
import enums.enums;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class GameTest {

    @Test
    public void testUpdateAlreadyTaken() throws IOException {
        String expected = "Already Taken";

        IPlayer player = new RealPlayer();
        IPlayer admin  = new ComputerPlayer();
        Game game = new Game(player, admin);

        File file = new File("input\\hit.txt");
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));

        int row = Integer.parseInt(reader.readLine());
        int col = Integer.parseInt(reader.readLine());

        game.updateStatus(row - 1, col - 1);

        Assert.assertEquals(expected,game.updateStatus(row - 1, col - 1));
    }

    @Test
    public void testUpdateHit() throws IOException {
        String expected = "HIT";
        IPlayer player = new RealPlayer();
        IPlayer admin  = new ComputerPlayer();
        Game game = new Game(player, admin);

        File file = new File("input\\hit.txt");
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));

        int row = Integer.parseInt(reader.readLine());
        int col = Integer.parseInt(reader.readLine());

        Assert.assertEquals(expected,game.updateStatus(row - 1, col - 1));
    }

    @Test
    public void testUpdateMiss() throws IOException {
        String expected = "MISS";
        IPlayer player = new RealPlayer();
        IPlayer admin  = new ComputerPlayer();
        Game game = new Game(player, admin);

        File file = new File("input\\miss.txt");
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));

        int row = Integer.parseInt(reader.readLine());
        int col = Integer.parseInt(reader.readLine());

        Assert.assertEquals(expected,game.updateStatus(row - 1, col - 1));
    }

    @Test
    public void testGameWin() throws IOException {
        boolean expected = true;
        IPlayer player = new RealPlayer();
        IPlayer admin  = new ComputerPlayer();
        Game game = new Game(player, admin);

        File file = new File("input\\win.txt");
        BufferedReader reader = null;

            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                int row = Integer.parseInt(text);
                int col = Integer.parseInt(reader.readLine());

               game.updateStatus(row - 1, col - 1);
            }

        game.getPlayer().getShipBoard().print(enums.printType.RESULT);
        Assert.assertEquals(expected,game.getPlayer().hasWon());
    }

    @Test
    public void testGameLose() throws IOException {
        boolean expected = true;
        IPlayer player = new RealPlayer();
        IPlayer admin  = new ComputerPlayer();
        Game game = new Game(player, admin);

        File file = new File("input\\lose.txt");
        BufferedReader reader = null;

        reader = new BufferedReader(new FileReader(file));
        String text = null;

        while ((text = reader.readLine()) != null) {
            int row = Integer.parseInt(text);
            int col = Integer.parseInt(reader.readLine());

            game.updateStatus(row - 1, col - 1);
        }

        game.getPlayer().getShipBoard().print(enums.printType.RESULT);
        Assert.assertEquals(expected,game.getPlayer().hasLost());
    }

}

