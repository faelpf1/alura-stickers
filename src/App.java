import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("1-Top 250 Filmes \n2-Filmes mais populares \n3-Top 250 Séries \n4-Séries mais populares");
        System.out.println("Digite uma das opções: ");
        Scanner opcao = new Scanner(System.in);

        EndpointIMDB endpoint = new EndpointIMDB();

        switch (opcao.nextInt()){
            case 1:
                //endpoint.endPoint("https://imdb-api.com/en/API/Top250Movies/k_a83ddg3k");
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b");
                break;
            case 2:
                //endpoint.endPoint("https://imdb-api.com/en/API/MostPopularMovies/k_a83ddg3k");
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b/MostPopularMovies");
                break;
            case 3:
                //endpoint.endPoint("https://imdb-api.com/en/API/Top250TVs/k_a83ddg3k");
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b/Top250TVs");
                break;
            case 4:
                //endpoint.endPoint("https://imdb-api.com/en/API/MostPopularTVs/k_a83ddg3k");
                endpoint.endPoint("https://api.mocki.io/v2/549a5d8b/MostPopularTVs");
                break;
            default:
                System.out.println("Opção invalida!");
        }
    }
}