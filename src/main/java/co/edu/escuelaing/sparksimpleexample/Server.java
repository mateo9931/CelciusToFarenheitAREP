package co.edu.escuelaing.sparksimpleexample;


import co.edu.escuelaing.Service.heatOperation;
import co.edu.escuelaing.Service.heatOperationImpl;

import static spark.Spark.*;

public class Server {
	

        
    	public static void main(String[] args) {
            port(getPort());
            get("/", (req, res) -> {
            return "<!DOCTYPE html>"+
                     "<html>"+
                    "<head>" +
                    "<title> Celcius To Farenheit </title>"+
                    "</head>"+
                    "<body>" +
                    "<div>" +
                    "<h2>Conversion celcius a Farenheit</h2>" +
                    "</div>"+
                    "<form action=\"/respuestaCelciusFarenheit\" method=\"get\">" +
                    "<div>" +
                    " <h4 for\"info\"> Celcius a Farenheit</h4>" +
                    " <input required name=\"datos\" id=\"datos\" value=\"\">" +
                    "</div>" +
                    "</br>"+
                    "<button> Calcular Celcius a Farenheit </button>" +
                    "</form>"+
                    "<form action=\"/respuestaFarenheitCelcius\" method=\"get\">" +
                            "<div>" +
                            " <h4 for\"info\"> Farenheit a Celcius</h4>" +
                            " <input required name=\"datos2\" id=\"datos2\" value=\"\">" +
                            "</div>" +
                            "</br>"+
                            "<button> Calcular Farenheit a Celcius</button>" +
                            "</form>"+
                    "</body>";
            });

            get("/respuestaCelciusFarenheit", (req, res) -> {
            	heatOperation heatCalculator = new heatOperationImpl();
                String value = req.queryParams("datos");
                String response;
                try {
                    
                    response = heatCalculator.convertCelciusToFarenheit(value);
                    
                    return "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<title> Respuesta </title>"+
                            "</head>"+
                            "<body>" +
                            "<form action=\"/\" method=\"get\">" +
                            " <label for\"media\"> El valor que ingresaste al convertirlo de celcius a Farenheit es: </label>" +
                            "</br>" +
                            "<label>" + response + "<p> Grados Farenheit</p>"+ "</label>\n" +
                            "</br>" +
                            "<button> Volver </button>" +
                            "</form>" +
                            "</body>";

                }
                
                catch (Exception e) {
                    return "<!DOCTYPE html>" +
                            "<html>" +
                            "<body>" +
                            "<head>" +
                            "<title> Invalid Transaction</title>"+
                            "</head>"+
                            "<form action=\"/\" method=\"get\">" +
                            "<h1>Invalid Transaction </h1>"+
                            "<button> Volver </button>" +
                            "</form>" +
                            "" +
                            "" +
                            "" ;
                }

            });
            
            get("/respuestaFarenheitCelcius", (req, res) -> {
            	heatOperation heatCalculator = new heatOperationImpl();
                String value = req.queryParams("datos2");
                String response;
                try {
                	response = heatCalculator.convertFarenheiToCelcius(value);
                    return "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<title> Respuesta </title>"+
                    "</head>"+
                    "<body>" +
                    "<form action=\"/\" method=\"get\">" +
                    " <label for\"media\"> El valor que ingresaste al convertirlo de Farenheit a celcius es: </label>" +
                    "</br>" +
                    "<label>" + response + "<p> Grados Celcius</p>"+ "</label>\n" +
                    "</br>" +
                    "<button> Volver </button>" +
                    "</form>" +
                    "</body>";
                }
                
                catch (Exception e) {
                    return "<!DOCTYPE html>" +
                            "<html>" +
                            "<body>" +
                            "<head>" +
                            "<title> Invalid Transaction</title>"+
                            "</head>"+
                            "<form action=\"/\" method=\"get\">" +
                            "<h1>Invalid Transaction </h1>"+
                            "<button> Volver </button>" +
                            "</form>" +
                            "" +
                            "" +
                            "" ;
                }

            });

        }
    
    static int getPort(){
        if(System.getenv("PORT")!= null){
            return  Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }

}
