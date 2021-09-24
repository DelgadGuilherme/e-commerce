package br.com.uvass.ecommerce.controller;

import br.com.uvass.ecommerce.model.entity.Produto;
import br.com.uvass.ecommerce.model.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(JdbcTemplate jdbcTemplate) {
        categoriaRepository = new CategoriaRepository(jdbcTemplate);
    }
    /*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/produto")
    public List<Produto> listarProdutos(@PathVariable int id) {
        return categoriaRepository.listarProdutos(id);
    }
    */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/produto")
    public List<Produto> listarProdutoPorNomeFaixaValor(@PathVariable int id, @RequestParam(required = false)String nome, String valorMinimo, String valorMaximo) {
        return categoriaRepository.listarProdutoPorNomeFaixaValor(id, nome, valorMinimo, valorMaximo);
    }




}
