package demo.lambda.java;

public class FunctionInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      // anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I just implemented the Runnable Functional Interface.");
            }
        }).start();
        
	}

}
