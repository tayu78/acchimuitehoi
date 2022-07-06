import java.util.Random;
import java.util.Scanner;

public class Janken {

    private int rand;
    private boolean isFirstTurn = true;
    private String userHand;
    private String cpHand;
    private String winner;
    
    // public Janken() {
    //     this.rand = new Random().nextInt(2) + 1;
    //         }
    
    // public Janken(int rand) {
    //     this.rand = rand;
    // }

    public String decideHand(int rand) {
        if (rand == 1)
            return "gu";
        else if (rand == 2)
            return "choki";
        return "pa";
    }


    public void decideUserHand(int rand) {
        userHand = decideHand(rand);
       System.out.println("you : " +  userHand);
    }

    public void decideCPHand() {
        rand = new Random().nextInt(2) + 1;
        cpHand = decideHand(rand);
        System.out.println("cp: " + cpHand);

    }

    public String decideWinner() {
        if ((userHand.equals("gu") && cpHand.equals("choki")) || (userHand.equals("choki") && cpHand.equals("pa") || (userHand.equals("pa") && cpHand.equals("gu"))))
            winner = "user";
        else if (userHand.equals(cpHand))
            winner = "none";
        else
            winner = "cp";

        return winner;
    }


    public void showWinner() {
        switch (winner) {
            case ("user"):
                System.out.println("You win!");
                break;
            case ("cp"):
                System.out.println("You lose...");
                break;
            default:
                System.out.println("aiko de ...");
        }
    }

    public void showOption() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("gu : press 1");
        System.out.println("choki : press 2");
        System.out.println("pa : press 3");
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }

    public void doJanken(Scanner s) {
        if (isFirstTurn) {
            System.out.println("saisyo ha gu");
            System.out.println("jan ken ...");
            isFirstTurn = false;
        }
        showOption();
        int userRand = s.nextInt();
        System.out.println("press the key");
        String a = s.next();
        System.out.println("you press" + a);
        decideUserHand(userRand);
        decideCPHand();
        decideWinner();
        showWinner();
    }
    
   
}
