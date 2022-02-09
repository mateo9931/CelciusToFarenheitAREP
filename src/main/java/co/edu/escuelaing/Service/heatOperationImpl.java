package co.edu.escuelaing.Service;

public class heatOperationImpl implements heatOperation {

	@Override
	public String convertCelciusToFarenheit(String value) {
		double response;
		double convert=Double.parseDouble(value);
		response=(convert*1.8) + 32;
		return response+"";
	}

	@Override
	public String convertFarenheiToCelcius(String value) {
		double response;
		double convert=Double.parseDouble(value);
		response=((convert - 32)*5)/9;
		return response+"";
	}

}
