import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json){

        /* Trata os dados em JSON */
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        /* Preenche lista com os conteudos dos dados */
        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {

            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
            
        }

        return conteudos;
        
    }

}
