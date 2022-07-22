
package imersaojava;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
public class GeradoraDeFigurinhas {
    
    public void criador(InputStream inputStream, String nomeArquivo) throws Exception {
        //Leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("Entrada/filme.jpg")); //--------> inputStream vindo de arquivo
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream(); //input vindo de URL
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);
        
        
        //Cria uma nova imagem em memória com tansparência e com tamanho novo
        var largura = ImagemOriginal.getWidth();
        var altura = ImagemOriginal.getHeight();
        var saida = "saida/" + nomeArquivo;
        int NovaAltura = altura + 200;
        var NovaImagem = new BufferedImage(largura, NovaAltura, BufferedImage.TRANSLUCENT);
        
        
        //copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) NovaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, null, 0, 0);
        
        
        //configurar a fonte
        var fonte = new Font(Font.MONOSPACED, Font.ITALIC, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.MAGENTA);
        
        
        //Escrever uma frase na nova imagem
        graphics.drawString("SUCESSO PAE", largura/5, NovaAltura-100);
        
        
        //escrever a imagem nova em um arquivo
        ImageIO.write(NovaImagem, "png", new File(saida));
        
        
    }
    
   
}
