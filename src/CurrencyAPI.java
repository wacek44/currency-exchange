import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyAPI {
    private String apiEndpoint = "https://api.currencyapi.com/v3/latest?apikey=cur_live_CWxWcZYBqcqRIJPU07Z7BNdZGF54ySKmvFRz8W09";

    public String getExchangeRateJSON() throws IOException { // Wykonanie zapytania HTTP do API
        URL url = new URL(apiEndpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responceCode = connection.getResponseCode(); // Pobranie odpowiedzi z API
        if(responceCode == HttpURLConnection.HTTP_OK){
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responce = new StringBuilder();

            while((inputLine = reader.readLine()) != null){
                responce.append(inputLine);
            }
            reader.close();
            return responce.toString();
        } else{
            throw new IOException("API request failed with response code: " + responceCode);
        }
    }
}
