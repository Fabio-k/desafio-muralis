INSERT INTO cliente (cli_nome, cli_cpf, cli_data_nascimento, cli_endereco)
VALUES 
('João Silva', '12345678901', '1990-05-15', 'Rua das Flores, 123, São Paulo'),
('Maria Oliveira', '98765432100', '1985-10-20', 'Avenida Brasil, 456, Rio de Janeiro'),
('Carlos Pereira', '45678912300', '1978-03-12', 'Rua dos Pinheiros, 789, Belo Horizonte'),
('Ana Costa', '32165498700', '1995-07-25', 'Praça da Liberdade, 101, Curitiba'),
('Paulo Souza', '65498732100', '1982-12-05', 'Rua das Palmeiras, 202, Porto Alegre');

INSERT INTO contato (con_cli_id, con_tipo, con_valor, con_observacao)
VALUES 
(1, 'EMAIL', 'joao.silva@email.com', 'Email pessoal'),
(1, 'TELEFONE', '(11) 98765-4321', 'Telefone celular'),
(2, 'EMAIL', 'maria.oliveira@email.com', 'Email profissional'),
(2, 'TELEFONE', '(21) 91234-5678', 'Telefone residencial'),
(3, 'EMAIL', 'carlos.pereira@email.com', 'Email pessoal'),
(3, 'TELEFONE', '(31) 99876-5432', 'Telefone celular'),
(4, 'EMAIL', 'ana.costa@email.com', 'Email pessoal'),
(4, 'TELEFONE', '(41) 98765-1234', 'Telefone celular'),
(5, 'EMAIL', 'paulo.souza@email.com', 'Email profissional'),
(5, 'TELEFONE', '(51) 91234-8765', 'Telefone residencial');