package br.com.uvass.ecommerce.controller;


import br.com.uvass.ecommerce.model.entity.Produto;
import br.com.uvass.ecommerce.model.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(JdbcTemplate jdbcTemplate){
        produtoRepository = new ProdutoRepository(jdbcTemplate);
    }

    /*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.listaTodos();
    }
     */

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Produto inserir(@RequestBody Produto produto) throws Exception {
        return produtoRepository.inserir(produto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable int id){
        return produtoRepository.buscarPorId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Produto> buscarProdutoPorNomeFaixaValor(@RequestParam(required = false) String nome, String valorMinimo, String valorMaximo) {
        return produtoRepository.buscarPorNomeFaixaValor(nome, valorMinimo, valorMaximo);
    }
}
