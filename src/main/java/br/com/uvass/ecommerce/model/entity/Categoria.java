package br.com.uvass.ecommerce.model.entity;

import java.util.List;

public class Categoria {

    private int id;
    private String imagemSimboloUlr;
    private String nome;
    private String descricacao;
    private List<Produto> produtoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagemSimboloUlr() {
        return imagemSimboloUlr;
    }

    public void setImagemSimboloUlr(String imagemSimboloUlr) {
        this.imagemSimboloUlr = imagemSimboloUlr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
}
