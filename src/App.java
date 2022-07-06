import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Janken j = new Janken();
        Acchimuitehoi ah = new Acchimuitehoi();
        Scanner s = new Scanner(System.in);
       
       do{
           j.doJanken(s);
        //    ah.doAcchimuitehoi();
    } while (j.decideWinner().equals("none"));
        

        
        s.close();





    }
    
    

    
}
