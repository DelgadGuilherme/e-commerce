INSERT INTO categoria (id, imagemSimboloUrl, nome, descricao)
VALUES (1, 'LinkImagemCategoria1', 'Categoria 1', 'Essa é a categoria 1');

INSERT INTO categoria (id, imagemSimboloUrl, nome, descricao)
VALUES (2, 'LinkImagemCategoria2', 'Categoria 2', 'Essa é a categoria 2');

INSERT INTO produto (id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario)
VALUES(1, 'Produto1', 'descricao do produto 1', 'foto do produto 1', '2021-01-19 03:14:07', '2021-01-19 03:14:07', 11.00);

INSERT INTO produto (id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario)
VALUES(2, 'Produto2', 'descricao do produto 2', 'foto do produto 2', '2021-01-19 03:14:07', '2021-01-19 03:14:07', 10.00);

INSERT INTO produto (id, nome, descricao, fotoUrl, dataCadastro, dataUltimaAtualizacao, valorUnitario)
VALUES(3, 'Produto3', 'descricao do produto 3', 'foto do produto 3', '2021-01-19 03:14:07', '2021-01-19 03:14:07', 16.00);

INSERT INTO produtoCategoria (id, produto_id, categoria_id)
VALUES(1, 1, 1);

INSERT INTO produtoCategoria (id, produto_id, categoria_id)
VALUES(1, 3, 1);

INSERT INTO produtoCategoria (id, produto_id, categoria_id)
VALUES(1, 2, 2);
