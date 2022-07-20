import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json){

        /* Trata os dados em JSON */
        var parser = new JsonParser();
        //List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        /* Preenche lista com os conteudos dos dados */
        List<Conteudo> conteudos = new ArrayList<>();

        listaDeAtributos.forEach( atributos -> {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        });

        return conteudos;
        
    }
    
}
