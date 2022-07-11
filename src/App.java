import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

            Janken j = new Janken();
            Acchimuitehoi ah = new Acchimuitehoi();
            Scanner s = new Scanner(System.in);
            do {
                j.doJanken(s);
                if (j.decideWinner().equals("none"))
                    continue;
                ah.doAcchimuitehoi(j.decideWinner(), s);
            } while (j.decideWinner().equals("none") || ah.decideWinner().equals("none"));
            s.close();
        }

   

   
}
