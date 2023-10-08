import com.google.gson.JsonObject; // Import klasy JsonObject
import com.google.gson.JsonParser; // Import klasy JsonParser

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        CurrencyAPI currencyAPI = new CurrencyAPI();

        try {
            String exchangeRateJSON = currencyAPI.getExchangeRateJSON();
            JsonParser parser = new JsonParser();
            JsonObject rootObject = parser.parse(exchangeRateJSON).getAsJsonObject();
            JsonObject dataObject = rootObject.getAsJsonObject("data"); // Pobranie obiektu "data"

            double euroValue = dataObject.get("EUR").getAsJsonObject().get("value").getAsDouble();
            double usdValue = dataObject.get("USD").getAsJsonObject().get("value").getAsDouble();
            double gbpValue = dataObject.get("GBP").getAsJsonObject().get("value").getAsDouble();

            Currency euro = new Currency("EUR", euroValue);
            Currency dolar = new Currency("USD",usdValue);
            Currency britischPound = new Currency("GBP",gbpValue);

            System.out.println("Enter the target currency name (e.g., USD, GBP, EUR): ");
            String targetCurrencyName = scn.nextLine().toUpperCase();

            Currency targetCurrency = null;
            switch(targetCurrencyName){
                case "USD":
                    targetCurrency = dolar;
                    break;
                case "EUR":
                    targetCurrency = euro;
                    break;
                case "GBP":
                    targetCurrency = britischPound;
                    break;
                default:
                    System.out.println("Unsupported target currency.");
                    System.exit(0);
            }

            System.out.println("Enter the amount to convert: ");
            double amountToConvert = scn.nextDouble();

            double targetAmount = euro.convertTo(amountToConvert, targetCurrency); //implementacja metody w odwolaniu do waluty

            double roundedTargetAmount = Math.round(targetAmount * 100.0) / 100.0; //wynik zaokraglony do 00 po przecinku
            System.out.println("Converted amount in " + targetCurrencyName + ": " + roundedTargetAmount);
        } catch(IOException e){
            System.out.println("Error while fetching data from API: " + e.getMessage());
        }
    }
}