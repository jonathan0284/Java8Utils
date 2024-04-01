package demo.optional.util;

import java.util.Optional;

public class OptionalisPresent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		integerIsPresent();
	}
	
	private static void integerIsPresent(){
		// create a Optional 
        Optional<Integer> op 
            = Optional.of(9455); 
  
        // print value 
        System.out.println("Optional: "
                           + op); 
  
        // check for the value 
        System.out.println("Is any value present: "
                           + op.isPresent()); 
	}

}
