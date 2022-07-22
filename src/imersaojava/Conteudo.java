/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imersaojava;

/**
 *
 * @author Lipmon
 */
public class Conteudo {
    private String titulo;
    private String urlImagem;
    private String plus;

    public Conteudo(String titulo, String urlImagem, String plus) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.plus = plus;
    }
    
    
    
    
    public String getTitulo(){
        return titulo;
    }
    public String getUrlImagem(){
        return urlImagem;
    }
    public String getPlus(){
        return plus;
    }
    
    public void putTitulo(String Titulo){
        titulo = Titulo;
    }
    
    public void putUrlImagem(String url){
        urlImagem = url;
    }
    public void putPlus(String Plus){
        plus = Plus;
    }
    
}
