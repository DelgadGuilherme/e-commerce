package br.com.uvass.ecommerce.model.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutoNaoAchado extends RuntimeException{

    public ProdutoNaoAchado() {
        super("Não existe o produto procurado");
    }
}
