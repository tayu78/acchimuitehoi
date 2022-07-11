import java.util.Random;
import java.util.Scanner;

import util.AhOption;
import util.ClrScr;

public class Acchimuitehoi {

    private String winner;
    private AhOption finger;
    private AhOption face;
    private String userDirection;
    private String cpDirection;
    private Boolean isUserTurn;


    public Acchimuitehoi() {
        finger = new AhOption("👉", "👈", "👆", "👇");
        face = new AhOption("🗣️", "🚶", "🙄", "🙃");
        userDirection =  "";
        cpDirection = "";
        isUserTurn = false;
    }

    public String getUserDirection() {
        return userDirection;
    }

    public void showOption(String up, String right, String down, String left) {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.printf("%s : press W\n", up);
        System.out.printf("%s : press D\n", right);
        System.out.printf("%s : press S\n", down);
        System.out.printf("%s : press A\n", left);
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }
    

    public void decideUserDirection(String directionKey, AhOption obj) throws Exception {
        switch (directionKey.toUpperCase()) {
            case ("W"):
                userDirection = obj.getUp();
                break;
            case ("D"):
                userDirection = obj.getRight();
                break;
            case ("S"):
                userDirection = obj.getDown();
                break;
            case ("A"):
                userDirection = obj.getLeft();
                break;
            default:
                throw new Exception();
        }
    }
    
    public void decideCPDirection(AhOption obj) {
        int rand = new Random().nextInt(4);
        cpDirection = obj.getOps().get(rand);
    }

    public void showResult(){
        System.out.println("================== ==================");
        System.out.println("      you                cp         ");
        System.out.printf("      %s            %s   \n",userDirection,cpDirection);
        System.out.println("================== ==================");
    }


    public String decideWinner() {
        if ((userDirection.contains("up") && cpDirection.contains("up")) ||
                (userDirection.contains("right") && cpDirection.contains("right")) ||
                (userDirection.contains("down") && cpDirection.contains("down")) ||
                (userDirection.contains("left") && cpDirection.contains("left"))) {
            return isUserTurn ? "user" : "cp";
        } else
            return "none";
    }
    
    private void showWinner() throws InterruptedException {
        switch (winner) {
            case ("user"):
                System.out.println("you win !!");
                break;
            case ("cp"):
                System.out.println("you lose...");
                break;
            case ("none"):
                System.out.println("winner not decided. back to janken!");
                Thread.sleep(2000);
                ClrScr.clrscr();
                break;
        }
    }



    public void doAcchimuitehoi(String jankenWinner, Scanner s) {
        userDirection = "";
        cpDirection = "";
        isUserTurn = false;
        
        System.out.println("acchimuite hoi!!");
        try {
             Thread.sleep(1000);
             if (jankenWinner.equals("user")) {
                isUserTurn = true;
                showOption(finger.getUp(), finger.getRight(), finger.getDown(), finger.getLeft());
                String directionKey = s.next();
                Thread.sleep(1000);
                ClrScr.clrscr(); 
                decideUserDirection(directionKey, finger);
                decideCPDirection(face);
                showResult();  
                winner = decideWinner();
                showWinner();
            } else {
                showOption(face.getUp(), face.getRight(), face.getDown(), face.getLeft());
                String directionKey = s.next();
                Thread.sleep(1000);
                ClrScr.clrscr();
                decideUserDirection(directionKey, face);
                decideCPDirection(finger);
                showResult();
                winner = decideWinner();
                showWinner();
            }
          
        } catch (Exception e) {
            ClrScr.clrscr();
            System.out.println("Wrong Input! Only enter the input displayed option. please select again!!!");
        }
       
    }

    

}
