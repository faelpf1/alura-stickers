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
 
        String corFundoCiano = "\u001b[46m";
        String corFundoMagenta = "\u001b[45m";
        String fonteNegrito = "\u001b[1m";
        String fonteItalico = "\u001b[3m";
        String codigoReset = "\u001b[m";
        
        /* Exibe os dados */

        for (Map<String, String> filme: listaDeFilmes){

            System.out.println(corFundoCiano + fonteNegrito + "Título: " + codigoReset + corFundoCiano + fonteItalico + filme.get("title") + codigoReset);
            System.out.println("Poster: "+ filme.get("image"));
            
            String rate = filme.get("imDbRating");
            System.out.println(corFundoMagenta +  "Classificação: " + rate + codigoReset);

            String stars = "";
            if(Float.parseFloat(rate) > 6){ //Classificacao acima de 6
                for (int i=0; i<Math.round(Float.parseFloat(rate)); i++){
                    stars += "\u2B50";
                }
            } else { // Classificacao abaixo de 6
                for (int i=0; i<Math.round(Float.parseFloat(rate)); i++){
                    stars += "\u2605";
                }
            }
            
            System.out.println(stars);

            System.out.println();
        }
        
    }
    
}
