package br.com.uvass.ecommerce.model.repository;

import br.com.uvass.ecommerce.model.entity.Categoria;
import br.com.uvass.ecommerce.model.entity.Produto;
import br.com.uvass.ecommerce.model.entity.Promocao;
import br.com.uvass.ecommerce.model.entity.PromocaoItem;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
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

    public HashMap buscarPorId(int id)  {
        HashMap hashMap = new HashMap();

        Produto produto =  jdbcTemplate.queryForObject("SELECT * FROM produto WHERE id=?", new Object[]{id}, new ProdutoMapper());
        hashMap.put("Produto", produto);

        List<Categoria> categoria = jdbcTemplate.query("SELECT c.* FROM categoria c JOIN produtoCategoria e ON e.categoria_id = c.id JOIN produto p ON p.id = e.produto_id WHERE p.id = ?", new Object[]{id}, new CategoriaMapper());
        hashMap.put("Categoria", categoria);

        List<PromocaoItem> promocaoItem = jdbcTemplate.query("SELECT i.* FROM promocaoItem i JOIN produto p ON p.id = i.produto_id WHERE p.id = ?", new Object[]{id}, new PromocaoItemMapper());
        hashMap.put("PromocaoItem", promocaoItem);

        List<Promocao> promocao = jdbcTemplate.query("SELECT r.* FROM promocao r JOIN promocaoItem i ON i.promocao_id = r.id JOIN produto p ON p.id = i.produto_id WHERE p.id = ?", new Object[]{id}, new PromocaoMapper());
        hashMap.put("Promocao", promocao);

        return hashMap;
    }

    public List<Produto> buscarPorNomeFaixaValor(String nome, String valorMinimo, String valorMaximo) {
        String sql = "SELECT * FROM produto WHERE";
        List<Object> listObject = new ArrayList<Object>();

        if (nome != null && nome != " "){
            sql += " nome = ?";
           listObject.add(nome);
        }

        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome != null && nome != " "){
            sql += " AND valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }

        if (valorMaximo != null && valorMinimo != null && valorMaximo != " " && valorMinimo != " " && nome == null) {
            sql += " valorUnitario BETWEEN ? AND ?";
            listObject.add(Integer.parseInt(valorMinimo));
            listObject.add(Integer.parseInt(valorMaximo));
        }

        Object[] objeto = listObject.toArray(new Object[]{});

        return jdbcTemplate.query(sql, objeto, new ProdutoMapper());
    }
}
