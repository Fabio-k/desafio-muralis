CREATE TABLE cliente (
    cli_id SERIAL NOT NULL PRIMARY KEY,
    cli_nome VARCHAR(100) NOT NULL,
    cli_cpf VARCHAR(11) NOT NULL UNIQUE,
    cli_data_nascimento DATE NOT NULL,
    cli_endereco VARCHAR(255)
);

CREATE TABLE contato (
    con_id SERIAL NOT NULL PRIMARY KEY,
    con_cli_id INT NOT NULL,
    con_tipo VARCHAR(20) NOT NULL,
    con_valor VARCHAR(100) NOT NULL,
    con_observacao VARCHAR(255),
    CONSTRAINT fk_con_cli FOREIGN KEY (con_cli_id) REFERENCES cliente(cli_id) ON DELETE CASCADE
);

