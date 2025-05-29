import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoneda {
    private final String API_KEY = "21c36cc6e6c2e7c91489c1fc";

    public double obtenerTasaCambio(String monedaBase, String monedaDestino) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + monedaBase;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            var json = new Gson().fromJson(response.body(), ExchangeRateResponse.class);
            return json.getConversion_rates().get(monedaDestino);

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API de cambio: " + e.getMessage());
        }
    }
}
