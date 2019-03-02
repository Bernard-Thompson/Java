package encapsulation;
/*
 *
 * @author thomp
 * 
 * Encapsulation is when to keep data safe from interference and misuse by using methods and outside data that act on private data
 */

public class EmployeeTemplate {
    private double annual; /*this is an example of hiding data as this is no longer open to outside forces to misuse*/
    private double bonus; 
    
    void setAnnual (double annual){ /*this is a setter method created to grant safe access to private data*/
        if (annual >= 60000 && annual <= 200000){
            this.annual = annual; /*this is the copy of the private data that can be used throught the program*/
        } else {
            this.annual = 0;
            System.out.println("Is this the correct salary information?");
        }
    }
    
    public double getAnnual(){ /*In the case that we need to work with the annual value alone we could use a getter method to have our own protected value to work with*/
        return annual;
    }
    
    
    void setBonus (double bonus){
        if (bonus >= 6000 && bonus <= 200000){
            this.bonus = bonus;
        } else {
            this.bonus = 0;
            System.out.println("Could you kindly look over your bonus?");
        }
    }
    
    public double getBonus() {
        return bonus;
    }
    
    
    void totalPayCount (){
        double takeHome = annual + bonus;
        System.out.println("Take home pay = " + takeHome);
    }
}
