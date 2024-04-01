package demo.optional.util;

import java.util.Optional;

public class OptionalDouble {

	public static void main(String[] args) throws Exception {

		Optional<Double> tipoCambio = getTipoCambio();
		
		/*tipoCambio.orElseThrow(()->{
			return new Exception("Tipo de cambio no existe");
		});	
		*/
		
		Double tc = tipoCambio.orElseGet(()->{
			return new Double(0);
		});
		
		System.out.println("Tipo cambio: " + tc);
		
		
	}

	public static Optional<Double> getTipoCambio() {
		Double tipoCambio = null;
		
		//tipoCambio = new Double(100);

		return Optional.ofNullable(tipoCambio);
	}
}
