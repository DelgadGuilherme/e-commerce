package br.com.uvass.ecommerce.model.repository;

import br.com.uvass.ecommerce.model.entity.PromocaoItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PromocaoItemMapper implements RowMapper<PromocaoItem> {

    @Override
    public PromocaoItem mapRow(ResultSet result, int i) throws SQLException {
        PromocaoItem promocaoItem = new PromocaoItem();
        promocaoItem.setId(result.getInt("id"));
        promocaoItem.setValorPromocao(result.getFloat("ValorPromocao"));
        promocaoItem.setDataCadastro(result.getString("dataCadastro"));
        promocaoItem.setDataUltimaAtualizacao(result.getString("dataUltimaAtualizacao"));
        promocaoItem.setProduto_id(result.getInt("produto_id"));
        promocaoItem.setPromocao_id(result.getInt("promocao_id"));

        return promocaoItem;
    }
}
