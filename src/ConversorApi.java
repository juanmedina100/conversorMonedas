import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorApi {

    public static void main(String[] args) {

        while (true){

        Scanner moneda = new Scanner(System.in);
        //Opciones
            System.out.println("*********************************");
            System.out.println("1 - Dolares a Euros"); //USD EUR
            System.out.println("2 - Dolares a Pesos Mexicano"); //USD MXN
            System.out.println("3 - Dolares a Pesos Argentino"); //USD ARS
            System.out.println("4 - Dolares a Real Brazileño"); //USD BRL
            System.out.println("5 - Pesos Mexicano a Dolares"); //MXN USD
            System.out.println("6 - Pesos Argentino a Dolares"); //ARS USD
            System.out.println("7 - Real Brazileño a Dolares"); //BRL USD
            System.out.println("9 - Salir");
            System.out.println("*********************************");


            System.out.print("Elije una opción: ");
            int seleccionar = Integer.parseInt(moneda.nextLine());

            

        if(seleccionar == 9){
            break;
        }
            System.out.print("Escribe una cantidad a convertir : ");
            int calcular = Integer.parseInt(moneda.nextLine());

            String primerMoneda = "";
            String segundaMoneda = "";
            switch (seleccionar) {
                case 1:
                    primerMoneda = "USD";
                    segundaMoneda = "EUR";
                    break;
                case 2:
                    primerMoneda = "USD";
                    segundaMoneda = "MXN";
                    break;
                case 3:
                    primerMoneda = "USD";
                    segundaMoneda = "ARS";
                    break;
                case 4:
                    primerMoneda = "USD";
                    segundaMoneda = "BRL";
                    break;
                case 5:
                    primerMoneda = "MXN";
                    segundaMoneda = "USD";
                    break;
                case 6:
                    primerMoneda = "ARS";
                    segundaMoneda = "USD";
                    break;
                case 7:
                    primerMoneda = "BRL";
                    segundaMoneda = "USD";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }



        var apiKey = "878227dd2d7c1a3e2cad6bd3";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"+primerMoneda+"/"+segundaMoneda;

        try {
            String url_str = direccion;

            // Making Request
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            // Accessing object
            double respuesta = 0.0;
            double myCalcular = Double.parseDouble(String.valueOf(calcular));
            double req_result = jsonobj.get("conversion_rate").getAsDouble();
            respuesta = req_result*myCalcular;
            System.out.println("Valor de cambio : "+req_result);
            System.out.println("El resultado es "+Math.round(respuesta*100.0)/100.0+" de "+primerMoneda+" a "+segundaMoneda);


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getCause());
        }





        }

    }
}
