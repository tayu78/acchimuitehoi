import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Janken {

    private int rand;
    private boolean isFirstTurn;
    private String userHand;
    private String cpHand;
    private String winner;
    private String gu;
    private String choki;
    private String pa;

    
    
    public Janken() {
        this.isFirstTurn = true;
        this.userHand = "";
        this.cpHand = "";
        this.gu = "gu ✊";
        this.choki = "choki ✌";
        this.pa = "pa 🖐";
    }


    public String decideHand(int rand) {
        if (rand == 1)
            return gu;
        else if (rand == 2)
            return choki;
        return pa;
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
        if ((userHand.equals(gu) && cpHand.equals(choki)) || (userHand.equals(choki) && cpHand.equals(pa) || (userHand.equals(pa) && cpHand.equals(gu))))
            winner = "user";
        else if (userHand.equals(cpHand)){
            winner = "none";
        }
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
                System.out.println("aiko de sho!");
        }
    }

    public void showOption() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.printf("%s : press 1\n",gu);
        System.out.printf("%s : press 2\n",choki);
        System.out.printf("%s : press 3\n",pa);
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }

    public void doJanken(Scanner s) {
        try {
            if (isFirstTurn) {
                System.out.printf("saisyo ha %s\n", gu);
                Thread.sleep(1000);
                System.out.println("jan ken poi!");
                isFirstTurn = false;
            }
            showOption();
            int userRand = s.nextInt();
            if (userRand < 1 || userRand > 3)
                throw new Exception();

            Thread.sleep(500);
            ClrScr.clrscr();
            
            decideUserHand(userRand);
            decideCPHand();

            Thread.sleep(1000);

            decideWinner();
            showWinner();
        } catch (InputMismatchException e) {
            ClrScr.clrscr();
            System.out.println("Wrong Input! Only enter the input displayed option. please select again!!!");
            s.next(); // prevent infinite loop because of input mismatch
        } catch(Exception e){
            ClrScr.clrscr();
            System.out.println("Wrong Input! Only enter the input displayed option. please select again!!!");
        }
    }


   
    
   
}
