CREATE TABLE categoria (
    id INT NOT NULL,
    imagemSimboloUrl VARCHAR(100),
    nome VARCHAR(90),
    descricao VARCHAR(90)
);

CREATE TABLE  produto (
    id INT NOT NULL,
    nome VARCHAR(90),
    descricao VARCHAR(90),
    fotoUrl VARCHAR(90),
    dataCadastro VARCHAR(30),
    dataUltimaAtualizacao VARCHAR(30),
    valorUnitario FLOAT,
    categoria_id INT
);

CREATE TABLE produtoCategoria (
    id INT NOT NULL,
    produto_id INT,
    categoria_id INT
);