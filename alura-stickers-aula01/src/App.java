import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("------------- MENU -------------\n");
        System.out.println("1-Top 250 Filmes \n2-Filmes mais populares \n3-Top 250 Séries \n4-Séries mais populares\n");
        System.out.println("Digite uma das opções: ");
        Scanner opcao = new Scanner(System.in);

        EndpointIMDB endpoint = new EndpointIMDB();

        //String apikey = System.getenv("API_KEY"); //Chave da API IMDB na variável de ambiente
        
        switch (opcao.nextInt()){
            case 1:
                System.out.println("------------- TOP 250 Filmes -------------\n");
                //endpoint.endPoint("https://imdb-api.com/en/API/Top250Movies/" + apikey);
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b");
                break;
            case 2:
                System.out.println("------------- Filmes Mais Populares -------------\n");
                //endpoint.endPoint("https://imdb-api.com/en/API/MostPopularMovies/" + apikey);
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b/MostPopularMovies");
                break;
            case 3:
                System.out.println("------------- TOP 250 Séries -------------\n");
                //endpoint.endPoint("https://imdb-api.com/en/API/Top250TVs/" + apikey);
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b/Top250TVs");
                break;
            case 4:
                System.out.println("------------- Séries Mais Populares -------------\n");
                //endpoint.endPoint("https://imdb-api.com/en/API/MostPopularTVs/" + apikey);
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b/MostPopularTVs");
                break;
            default:
                System.out.println("Opção invalida!");
        }

        opcao.close();
    
    }
    
}
