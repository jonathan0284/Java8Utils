package demo.optional.util;

import java.util.Optional;

public class OptionalOrElseThrow {

	public static void main(String[] args) {
		optionalEmpty();
	}

	private static void optionalEmpty() {
		// create a Optional
		Optional<Integer> op = Optional.empty();

		// print supplier
		System.out.println("Optional: " + op);

		try {

			// orElseThrow supplier
			System.out.println("Value by orElseThrow(" + "ArithmeticException::new) method: "
					+ op.orElseThrow(ArithmeticException::new));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void optionalWithValue() {
		// create a Optional
		Optional<Integer> op = Optional.of(9455);

		// print supplier
		System.out.println("Optional: " + op);

		// orElseThrow supplier
		System.out.println("Value by orElseThrow(" + "ArithmeticException::new) method: "
				+ op.orElseThrow(ArithmeticException::new));
	}
}
