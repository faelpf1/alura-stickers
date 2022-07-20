package Aula02;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class EndpointIMDB {

    public void endPoint(String url) throws Exception{

        /* Recebe os dados */
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        /* Extrai os dados */
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        /* Exibe os dados */
        var geradora = new GeradoraDeFigurinhas();

        for (Map<String, String> filme: listaDeFilmes){

            String titulo = filme.get("title");
            String urlImagem = filme.get("image");

            InputStream inputStream = new URL(urlImagem).openStream(); /* Transforma a imagem da URL em uma InputStream */
            String nomeArquivo = titulo + ".png"; /* Nome da saída */

            geradora.cria(inputStream, nomeArquivo);

            System.out.println();
        }

    }
    
}
