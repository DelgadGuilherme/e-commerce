package br.com.uvass.ecommerce.model.repository;

import br.com.uvass.ecommerce.model.entity.Produto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoMapper implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet result, int i) throws SQLException {
        Produto produto = new Produto();
        produto.setId(result.getInt("id"));
        produto.setNome(result.getString("nome"));
        produto.setDescricao(result.getString("descricao"));
        produto.setFotoUrl(result.getString("fotoUrl"));
        produto.setDataCadastro(result.getString("dataCadastro"));
        produto.setDataUltimaAtualizacao(result.getString("dataUltimaAtualizacao"));
        produto.setValorUnitario(result.getFloat("valorUnitario"));
        return produto;
    }
}
