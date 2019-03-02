
package encapsulation;

/*
 *
 * @author thomp
 */


public class NewHire {

    public static void main(String[] args) {
       
        EmployeeTemplate Davis = new EmployeeTemplate();
        Davis.setAnnual(85000); /*Thanks to the setter method we can now use the protected data as if it was public*/
        Davis.setBonus(6500);
        Davis.totalPayCount();
        
    }
    
}
