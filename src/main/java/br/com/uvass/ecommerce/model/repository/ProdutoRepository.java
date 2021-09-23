package br.com.uvass.ecommerce.model.repository;

import br.com.uvass.ecommerce.model.entity.Produto;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProdutoRepository {

    private JdbcTemplate jdbcTemplate;

    public ProdutoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Produto> listaTodos() {
        return jdbcTemplate.query("SELECT * FROM produto", new ProdutoMapper());
    }

    public Produto inserir(Produto produto) throws Exception {
        String sql = "INSERT INTO produto(id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario) VALUES (?,?,?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql,
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getFotoUrl(),
                produto.getDataCadastro(),
                produto.getDataUltimaAtualizacao(),
                produto.getValorUnitario()
        );

        if (insert == 1){
            return produto;
        } throw new Exception("O produto não foi cadastrado");
    }

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produto WHERE id=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProdutoMapper());
    }
}
