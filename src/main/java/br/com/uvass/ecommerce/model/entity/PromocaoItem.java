package br.com.uvass.ecommerce.model.entity;

public class PromocaoItem {

    private int id;
    private float valorPromocao;
    private String dataCadastro;
    private String dataUltimaAtualizacao;
    private int produto_id;
    private int promocao_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(float valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getPromocao_id() {
        return promocao_id;
    }

    public void setPromocao_id(int promocao_id) {
        this.promocao_id = promocao_id;
    }
}
