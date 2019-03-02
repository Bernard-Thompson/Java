
package even.s.and.odds;
import java.util.*;
/**
 *
 * @author thomp
 */
public class EvenSAndOdds {

    /**
     * @param args the command line arguments
     */
    public static Scanner input = new Scanner(System.in);
    public static String nameChoice = "";
    public static String computerChoice = "";
    public static int namePlay;
    public static int computerPlay;
    public static String name;
    
    public static void main(String[] args) {
  
        intro();
        play();
        result(name, namePlay,computerPlay);
    }
 
    public static void intro(){
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        name = input.next();
        System.out.print("Hi " +  name + ", which do you choose? (O)dds or (E)vens? ");
        String nameShortChoice = input.next();
        nameChoice = nameShortChoice.equals("O") ? "odds" : "evens";
        computerChoice = nameShortChoice.equals("O") ? "evens" : "odds";
        System.out.println(name + " has picked " + nameChoice + "! The computer will be " + computerChoice + ".");
        closing();
    }
 
    public static void play(){
        System.out.println("How many “fingers” do you put out? ");
        Random rand = new Random();
        namePlay = input.nextInt();
        computerPlay = rand.nextInt(6);
        System.out.println("The computer plays " + computerPlay + " \"fingers\".");
        closing();
    }
 
    public static void result(String name,int namePlay, int computerPlay){
        int sum = namePlay + computerPlay;
        System.out.println(namePlay + " + " + computerPlay + " = " + sum);
        if(sum % 2 == 0){
            System.out.println( sum + " ...is even!");
            if(nameChoice.equals("evens")){
                System.out.println("That means " + name + " wins!  :)" );
            }else{
                System.out.println("That means the computer wins!  :)" );
            }
        }else{
            System.out.println( sum + " ...is odds!");
            if(nameChoice.equals("odds")){
                System.out.println("That means " + name + " wins!  :)" );
            }else{
                System.out.println("That means the computer wins!  :)" );
            }
        }
        closing();
    }
 
    public static void closing(){
        for(int i = 0 ; i<50 ; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
        
    
    

