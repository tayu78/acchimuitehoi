import java.util.Random;
import java.util.Scanner;

public class Acchimuitehoi {

    // private String winner;

    private AhOption hand = new AhOption("👉", "👈", "👆", "👇");
    private AhOption face = new AhOption("🗣️", "🚶", "🙄", "🙃");
    private String userDirection;
    private String cpDirection;
    private Boolean isUserTurn = false;

    public void showOption(String up, String right, String down, String left) {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.printf("%s : press W\n", up);
        System.out.printf("%s : press D\n", right);
        System.out.printf("%s : press S\n", down);
        System.out.printf("%s : press A\n", left);
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }
    
    public void doAcchimuitehoi(String jankenWinner, Scanner s) {
        if (jankenWinner.equals("user")) {
            showOption(hand.getUp(), hand.getRight(), hand.getDown(), hand.getLeft());
            String directionKey = s.next();
            decideUserDirection(directionKey, hand);
            decideCPDirection(face);      
            isUserTurn = true;
            System.out.println(decideWinner());
        } else {
            showOption(face.getUp(), face.getRight(), face.getDown(), face.getLeft());
            String directionKey = s.next();
            decideCPDirection(hand);       
            decideUserDirection(directionKey, face);
            System.out.println(decideWinner());
        }
    }


    public void decideUserDirection(String directionKey, AhOption obj) {
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
        }
        System.out.println("you: " + userDirection);
    }
    
    public void decideCPDirection(AhOption obj) {
        int rand = new Random().nextInt(4);
        cpDirection = obj.getOps().get(rand);
        System.out.println("cp: " + cpDirection);
    }


    public String decideWinner() {
        if((userDirection.contains("up") && cpDirection.contains("up")) ||
         (userDirection.contains("right") && cpDirection.contains("right")  ) ||
         (userDirection.contains("down") && cpDirection.contains("down")) ||
         (userDirection.contains("left") && cpDirection.contains("left"))) {
              return isUserTurn ? "user" : "cp";
         } else return "none";
    }

   
    

    



}
