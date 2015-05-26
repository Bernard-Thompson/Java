
public class FizzBuzz {
         public static void main (String [ ] args) {
        	 /* print from 1 to 50 
        	  * if multiple of 3 print "Fizz"
        	  * if multiple of 5 print "Buzz"
        	  * if multiple of 3 and 5 print "FizzBuzz"
        	  */
        	 for (int i = 1;  i <= 50; i++) {
        		 if (i % 3 == 0 && i % 5 == 0) {
        		 System.out.println ("FizzBuzz");
        		 }else if (i % 3 == 0 ) {
        			 System.out.println ("Fizz");
        		 }else if ( i % 5 == 0 ) {
        			 System.out.println ("Buzz");
        		 }else {
        			 System.out.println ( i );
        		 }
        	 }
         }
}
