package demo.lambda.java;

public class TestMyInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseString();
	}
	
	
	public static void reverseString(){
		
		// declare a reference to MyInterfaceReverse
		MyInterfaceReverse ref = (str) ->{
			String result = "";
			
			for (int i = str.length()-1; i >= 0 ; i--)
	            result += str.charAt(i);
			
			return result;
		};
		
		// call the method of the interface
        System.out.println("Lambda reversed = " + ref.reverse("Lambda"));
        
	}

	public static void getPiValue() {

		// Declare a reference to MyInterface
		MyInterface ref;

		// Lambda expression
		ref = () -> 3.1415;

		System.out.println("Value of pi: " + ref.getPiValue());
	}

}
