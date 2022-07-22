
package imersaojava;

import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {

    public static void main(String[] args) throws Exception {
        
        
        // FAZER UMA CONEXÃO HTTP E BUSCAR OS TOP 250 FILMES
        
        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"; //API IMDB 250 filmes
        //String url = "https://api.nasa.gov/planetary/apod?api_key=fbdcduNITbu7sqRASLda8AgfVZbqox5kyh7ZygCv&start_date=2022-06-20&end_date=2022-07-20"; //API da nasa
        String url = "http://localhost:8080/linguagens";
        var http = new clientHTTP();
        String json = http.dataSearcher(url);
        
        
        //EXIBIR E MANIPULAR OS DADOS
        ExtratorDeConteudo extrator = new ContentExtractor();
        List<Conteudo> conteudos = extrator.contentExtractor(json);
        
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
        
        for (int i=0; i < conteudos.size();i++){
            Conteudo conteudo = conteudos.get(i);
            String nomeArquivo = conteudo.getTitulo().replace(":", "-")  + ".png"; //DOIS PONTOS não funciona para nomear arquivos no windows
            System.out.println(conteudo.getTitulo());
            System.out.println(conteudo.getPlus());
            
            
            //PEGANDO ALGUMAS EXCEÇÕES DE ARQUIVOS COM CORES INCOMPATÍVEIS
            try{
                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream(); ////new URL(urlImagem.subSequence(0, urlImagem.indexOf('_')) + ".jpg").openStream();           
                System.out.println("Gerando imagem - [" + conteudo.getTitulo() + "]");
                geradora.criador(inputStream, nomeArquivo);
            }catch(java.io.FileNotFoundException err){
                System.out.println("Imagem não encontrado ou link inválido");
            }catch(javax.imageio.IIOException Uns){
                System.out.println(">>>ARQUIVO INCOMPATÍVEL<<<");
            }
            System.out.println();
            
            
            //InputStream inputStream = new URL(urlImagem).openStream();
            //String nomeArquivo = titulo + ".png";
            //geradora.criador(inputStream, nomeArquivo);  
        }
        
    }

}
