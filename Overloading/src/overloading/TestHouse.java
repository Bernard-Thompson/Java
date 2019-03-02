
package overloading;

/*
 *
 * @author thomp
 * 
 * overloading is when methods of the same name are differentiated by their passing arguments
 */
public class TestHouse {
    
    public static void main(String[] args) {
    
    House place = new House();
    
    place.calcArea(50); /*this is a variable passing an int as an argument*/
    
    place.calcArea(40.9); /*this is a variable passing a double as an argument*/
    
    place.calcArea(35, 98); /*this is a variable passing the int of length and width as an argument*/
}
    
}
