package br.com.uvass.ecommerce.model.repository;

import br.com.uvass.ecommerce.model.entity.Produto;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {

    private JdbcTemplate jdbcTemplate;

    public CategoriaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Produto> listarProdutos(int id) {
        String sql = "SELECT p.* FROM produto p JOIN produtoCategoria e ON e.produto_id = p.id JOIN categoria c ON e.categoria_id = c.id WHERE c.id = ?";

        return jdbcTemplate.query(sql, new Object[]{id}, new ProdutoMapper());
    }

    public List<Produto> listarProdutoPorNomeFaixaValor(int id, String nome, String valorMinimo, String valorMaximo) {
        String sql = "SELECT p.* FROM produto p JOIN produtoCategoria e ON e.produto_id = p.id JOIN categoria c ON e.categoria_id = c.id WHERE c.id = ? AND";
        List<Object> listObject = new ArrayList<Object>();
        listObject.add(id);

        if (nome != null && nome != " "){
            sql += " p.nome = ?";
            listObject.add(nome);
        }

        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome != null && nome != " "){
            sql += " AND p.valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }

        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome == null) {
            sql += " p.valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }

        Object[] objeto = listObject.toArray(new Object[]{});

        return jdbcTemplate.query(sql, objeto, new ProdutoMapper());
    }
}
