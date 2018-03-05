
package Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Helper.Set;
import Interface.IPlayer;
import enums.enums;
import enums.enums.statuses;
import enums.enums.printType;

public class Game {

    private static Scanner reader = new Scanner(System.in);
    private IPlayer player;
    private IPlayer computer;

    public Game(IPlayer r, IPlayer c) {
        player = r;
        computer = c;

        assignBoard(computer);
        //assignBoard(player);
        System.out.println("\n Generated Board...");
        computer.getShipBoard().print(printType.ARRANGEMENT);
    }

    public IPlayer getPlayer(){return this.player;}

    public IPlayer getComputer() {return this.computer;}

    public void assignBoard(IPlayer p)
    {
        if(p.isAdmin()) {

            System.out.println();
            int normCounter = 0;

            HashMap<Integer,List<Set>> rowCol = Set.getSet();

            List<Set> lst = rowCol.get(2);
            int j = 0;

            for (Ship s : p.getShipBoard().getShips()) {

                Set st = lst.get(j);
                int row = st.row;
                int col = st.col;
                enums.Direction dir = st.dir;

                p.getShipBoard().getShips()[j].setLocation(row, col);
                p.getShipBoard().getShips()[j].setDirection(dir);
                p.getShipBoard().addShip(p.getShipBoard().getShips()[normCounter]);

                normCounter++;
                j++;
            }
        }
        else
        {
            System.out.println("Coming Soon for other player...");
        }
    }

    public void start() {
        String result = "";
        while (true) {
            System.out.println(result);
            System.out.println("\nAttack -->-->>>:");
            result = attack();

            if(player.hasWon()){
                System.out.println("\n "+result+"");
                player.getShipBoard().print(printType.RESULT);
                System.out.println("Congratulations :) You have Won!!");
                break;
            }

            if (player.hasLost()) {
                System.out.println("You have reached maximum attempt :( .. Try Again");
                break;
            }
        }
    }

    public String attack() {
        System.out.println("See at attack:");
        player.getShipBoard().print(printType.RESULT);
        String result = "";

        int row = -1;
        int col = -1;

        while (true) {
            System.out.print("Type in row (1-10): ");
            int userInputRow = Integer.parseInt(reader.next());
            row = userInputRow - 1;

            System.out.print("Type in column (1-10): ");
            col = reader.nextInt();
            col = col-1;

            if (col >= 0 && col <= 9 && row != -1) {
                result = updateStatus(row,col);
                break;
            }

            return("Invalid location!");
        }

        return result;
    }

    public String updateStatus(int row, int col){
        player.decreaseChances();

        if (computer.getShipBoard().getPosition()[row][col].hasShip()) {
            if (player.getShipBoard().getPosition()[row][col].getStatus() == statuses.HIT)
                return "Already Taken";

            else {
                player.getShipBoard().getPosition()[row][col].setStatus(statuses.HIT);
                player.addTotalHit();
                return "HIT";
            }
        }
        else {
            player.getShipBoard().getPosition()[row][col].setStatus(statuses.MISSED);
            return "MISS";
        }
    }
}
