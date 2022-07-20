import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.awt.font.GlyphVector;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

        /* Recebe a imagem */
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        /* Cria nova imagem com tamanho novo e transparente */
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        var novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        /* Copia o conteúdo da imagem original */
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        /* Configura fonte */
        var fonte = new Font("Comic Sans", Font.BOLD, 150);
        graphics.setColor(Color.WHITE);
        graphics.setFont(fonte);
        
        /* Escreve frase na imagem */
        String frase = "TOPZERA";

        /* Centraliza frase abaixo da imagem */
        Integer fraseLarguraCentralizada = (largura-108*frase.length())/2; /* (Largura - Tamanho da fonte multiplicado pelo tamanho da frase)/2 */
        graphics.translate(fraseLarguraCentralizada, novaAltura-50);

        /* Contorno e exibição da frase */
        GlyphVector glyphVector = fonte.createGlyphVector(graphics.getFontRenderContext(), frase);
        
        graphics.draw(glyphVector.getOutline());
        graphics.setColor(Color.YELLOW);
        graphics.fill(glyphVector.getOutline());
        //graphics.drawString(frase, fraseLarguraCentralizada, novaAltura-50);

        /* Gera nova imagem */
        if(!new File("saida").exists()){
            new File("saida").mkdir();
        }

        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));      

    }

    /*public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        InputStream inputStream = new FileInputStream(new File("saida/entrada.jpg"));
        InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_2.jpg").openStream();
        String nomeArquivo = "teste.png";

        geradora.cria(inputStream, nomeArquivo);

    }*/

}
