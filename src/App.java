import java.util.Scanner;
import util.ClrScr;

public class App {
    public static void main(String[] args) throws Exception {

            Janken j = new Janken();
            Acchimuitehoi ah = new Acchimuitehoi();
            Scanner s = new Scanner(System.in);
            ClrScr.clrscr();
            do {
                 j.doJanken(s);
                 if (j.decideWinner().equals("none"))
                     continue;

                // loop to retry acchimuitehoi without janken if user type wrong input
                while (!j.decideWinner().equals("none") && ah.decideWinner().equals("none")) {
                    ah.doAcchimuitehoi(j.decideWinner(), s);
                    j.setSaySaisyohaGu(true);
                    if (!ah.getUserDirection().equals("")) break; // this means no input mismatch error occured
                }
                
            } while (j.decideWinner().equals("none") || ah.decideWinner().equals("none"));
            s.close();
        }
}
