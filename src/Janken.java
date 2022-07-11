import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Janken {

    private int rand;
    private boolean saySaisyohaGu;
    private String userHand;
    private String cpHand;
    private String winner;
    private String gu;
    private String choki;
    private String pa;

    
    
    public Janken() {
        this.saySaisyohaGu = true;
        this.userHand = "";
        this.cpHand = "";
        this.gu = "gu ✊";
        this.choki = "choki ✌";
        this.pa = "pa 🖐";
    }


    public void setSaySaisyohaGu(boolean saySaisyohaGu) {
        this.saySaisyohaGu = saySaisyohaGu;
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
    }

    public void decideCPHand() {
        rand = new Random().nextInt(2) + 1;
        cpHand = decideHand(rand);
    }

    
    public String decideWinner() {
        if ((userHand.equals(gu) && cpHand.equals(choki))
                || (userHand.equals(choki) && cpHand.equals(pa) || (userHand.equals(pa) && cpHand.equals(gu))))
            winner = "user";
        else if (userHand.equals(cpHand)) {
            winner = "none";
        } else
            winner = "cp";

        return winner;
    }
    
    public void showResult(){
        System.out.println("================== ==================");
        System.out.println("      you                cp         ");
        System.out.printf("      %s            %s   \n",userHand,cpHand);
        System.out.println("================== ==================");
    }


    public void sayAikoDeSho() {
        if (winner.equals("none"))
            System.out.println("aiko de sho!");
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
            if (saySaisyohaGu) {
                System.out.printf("saisyo ha %s\n", gu);
                Thread.sleep(1000);
                System.out.println("jan ken poi!");
                saySaisyohaGu = false;
            }
            showOption();
            int userRand = s.nextInt();
            if (userRand < 1 || userRand > 3)
                throw new Exception();

            Thread.sleep(500);
            ClrScr.clrscr();
            
            decideUserHand(userRand);
            decideCPHand();
            showResult();

            Thread.sleep(1000);

            decideWinner();
            sayAikoDeSho();

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
