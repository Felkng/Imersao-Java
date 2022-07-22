/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imersaojava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Felkng
 */
public class ContentExtractor implements ExtratorDeConteudo {
   
   public List<Conteudo> contentExtractor(String json){
       Scanner input = new Scanner(System.in);
       
        //EXTRAIR SÓ OS DADOS QUE INTERESSAM (TITULO, POSTER, CLASSIFICAÇÃO)
        var parser = new JsonParser();
        List<Map<String, String>>listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos =  new ArrayList<>();
        
        //ENCHER LISTA CONTEUDOS COM AS ATRIBUIÇÕES
        for(Map<String,String> atributos: listaDeAtributos){
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String plus = atributos.get("imDbRating");
            var conteudo = new Conteudo(titulo, urlImagem, plus);
            
            conteudos.add(conteudo);
        }
        
        
        return conteudos;
        
    }
}
