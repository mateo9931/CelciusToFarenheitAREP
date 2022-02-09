package co.edu.escuelaing;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.text.DecimalFormat;

import co.edu.escuelaing.Service.*;


public class AppTest  extends TestCase {
	heatOperation heatCalculator = new heatOperationImpl();
	
	 public AppTest(){}
	 
	 public static Test suite()
	    {
	        return new TestSuite( AppTest.class );
	    }

	    public void testCF1()
	    {
	    	
	        String resultadoEsperado= new DecimalFormat("#.0#").format(4512.74d);
	        assertEquals(resultadoEsperado, new DecimalFormat("#.0#").format(Double.parseDouble(heatCalculator.convertCelciusToFarenheit("2489.3"))));

	    }
	    public void testCF2()
	    {
	    	String resultadoEsperado= new DecimalFormat("#.0#").format(2707.232d);
	    	assertEquals(resultadoEsperado, new DecimalFormat("#.0#").format(Double.parseDouble(heatCalculator.convertCelciusToFarenheit("1486.24"))));
	    }
	    public void testFC1()
	    {
	    	String resultadoEsperado= new DecimalFormat("#.0#").format(2489.3d);
	    	assertEquals(resultadoEsperado, new DecimalFormat("#.0#").format(Double.parseDouble(heatCalculator.convertFarenheiToCelcius("4512.74"))));
	    
	    }
	    public void testFC2()
	    {
	    	String resultadoEsperado= new DecimalFormat("#.0#").format(1486.24d);
	    	assertEquals(resultadoEsperado, new DecimalFormat("#.0#").format(Double.parseDouble(heatCalculator.convertFarenheiToCelcius("2707.232"))));
	    }

}
