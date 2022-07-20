import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        /* URL */

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        /*String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        var clienteHttp = new ClienteHttp();       
        String json = clienteHttp.buscaDados(url);
        var extratorDeConteudoDaNasa = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudos = extratorDeConteudoDaNasa.extraiConteudos(json);*/


        String url = "https://api.mocki.io/v2/549a5d8b";
        var extratorDeConteudoDoIMDB = new ExtratorDeConteudoDoIMDB();
        var clienteHttp = new ClienteHttp();       
        String json = clienteHttp.buscaDados(url);
        List<Conteudo> conteudos = extratorDeConteudoDoIMDB.extraiConteudos(json);
       
        /* Exibe os dados */
        var geradora = new GeradoraDeFigurinhas();

        for (int i=0; i<3; i++){

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream(); //Transforma a imagem da URL em uma InputStream
            String nomeArquivo = conteudo.getTitulo() + ".png"; //Nome da saída 

            geradora.cria(inputStream, nomeArquivo);

            System.out.println();

        }

        /*
        for (Map<String, String> conteudo: listaDeConteudo){
            geradora.cria(inputStream, nomeArquivo);
        }*/
    }
}
