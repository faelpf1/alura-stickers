import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class EndpointIMDB {

    public void endPoint(String url) throws IOException, InterruptedException{

        /* Recebe os dados */
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        /* Extrai os dados */
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        /* Exibe os dados */
        for (Map<String, String> filme: listaDeFilmes){

            System.out.println("\u001b[1m" + "Título: \u001b[m" + "\u001b[3m"+ filme.get("title") + "\u001b[m");
            System.out.println("\u001b[1m" + "Poster: \u001b[m" + filme.get("image"));
            
            String rate = filme.get("imDbRating");
            System.out.println("\u001b[45m" +  "Classificação: " + rate + "\u001b[m");

            String stars = "";
            for (int i=0; i<Math.round(Float.parseFloat(rate)); i++){
                stars += "\u2B50";
            }
            System.out.println(stars);

            System.out.println();
        }
        
    }
    
}
