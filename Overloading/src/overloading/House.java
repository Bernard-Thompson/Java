
package overloading;

/*
 *
 * @author thomp
 * 
 * overloading is when methods of the same name are differentiated by their passing arguments
 */


        
public class House{ 
    
    public void calcArea(int length) {
        System.out.println("Area = " + (length * length));
        /*this is a variable passing an int as an argument*/
    }
    
    public void calcArea(double length) {
        System.out.println("Double Area = " + (length * length));
        /*this is a variable passing a double as an argument*/
    }
        
    public void calcArea (int length, int width){
        System.out.println("Double Area = " + (length * width));
        /*this is a variable passing an int of length and width as an argument*/
    }
    }
    

