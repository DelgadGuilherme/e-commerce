package br.com.uvass.ecommerce.model.repository;

import br.com.uvass.ecommerce.model.entity.Promocao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromocaoMapper implements RowMapper<Promocao> {

    @Override
    public Promocao mapRow(ResultSet result, int i) throws SQLException {
        Promocao promocao = new Promocao();
        promocao.setId(result.getInt("id"));
        promocao.setNome(result.getString("nome"));
        promocao.setDescricao(result.getString("descricao"));
        promocao.setDataInicio(result.getString("dataInicio"));
        promocao.setDataFim(result.getString("dataFim"));
        promocao.setDataCadastro(result.getString("dataCadastro"));
        promocao.setDataUltimaAtualizacao(result.getString("dataUltimaAtualizacao"));

        return promocao;
    }

}
