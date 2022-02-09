package co.edu.escuelaing.sparksimpleexample;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

public class Server {

    public static void main(String[] args) {
    	port(getPort());
        
        get("/hello", (req, res) -> "Hello World");

        get("/hello/:nombre", (req, res) -> "Hello World " + req.params(":nombre"));
    }
    
    static int getPort(){
        if(System.getenv("PORT")!= null){
            return  Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }

}
