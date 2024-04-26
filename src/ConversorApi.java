import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorApi {

    public static void main(String[] args) {

        Scanner moneda = new Scanner(System.in);
        System.out.print("Ingrese la primera moneda: ");
        var primerMoneda = moneda.nextLine();
        System.out.print("Ingrese la segunda moneda: ");
        var segundaMoneda = moneda.nextLine();
        System.out.print("Ingrese la una cantidad a convetir: ");
        var calcular = moneda.nextLine();
        var respuesta = 0.0;
        var apiKey = "878227dd2d7c1a3e2cad6bd3";
        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + primerMoneda + "/" + segundaMoneda;
        //https://v6.exchangerate-api.com/v6/878227dd2d7c1a3e2cad6bd3/pair/EUR/USD

        try {
            HttpClient monedas = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = monedas.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting().create();
            ConversorMonedas myMonedas = gson.fromJson(json, ConversorMonedas.class);

            System.out.println(myMonedas);
            System.out.println(myMonedas);
            //respuesta = myMonedas*calcular;
            //System.out.println("Respusta : "+);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) { // Consider a more specific exception type
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }




}
