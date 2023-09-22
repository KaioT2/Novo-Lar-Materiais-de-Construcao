create database dbNovoLar;

drop database dbNovoLar;

use dbNovoLar;

create table fornecedor (
	idFornecedor int primary key not null auto_increment,
    nome varchar(30) not null,
    cnpj varchar(18) not null,
    endereco varchar (30) not null,
    bairro varchar(30) not null,
    cidade varchar (30) not null,
    estado varchar (2) not null,
    CEP varchar(9) not null,
    telefone varchar(13) not null,
    email varchar(30) not null
);

create table categoria (
	idCategoria int primary key not null auto_increment,
    descricao varchar (30) not null
);

create table produto(
	idProduto int primary key not null auto_increment,
    idFornecedor int not null,
    foreign key (idFornecedor)
    references fornecedor (idFornecedor),
    nome varchar(30) not null,
    codigo varchar(13) not null, 
    idcategoria int not null,
    foreign key (idcategoria)
    references categoria (idCategoria),
    precoUn double(7,2) not null,
    precoCusto double(7,2) not null,
    estoque double not null
);

create table funcionario(
	idFuncionario int primary key not null auto_increment,
    senha varchar(30) not null,
    nome varchar(30) not null,
	endereco varchar (30) not null,
    bairro varchar(30) not null,
    cidade varchar (30) not null,
    CEP varchar(9) not null,
    estado varchar(2) not null,
    cpf varchar (14) not null,
    cargo varchar (30) not null,
    cargaHoraria double(4,2) not null,
    salario double(7,2) not null,
    telefone varchar (15) not null,
    email varchar (30) not null,
    dataNasc date not null,
    dataContrata date not null, 
    status varchar(10) not null, 
    permissao int(1) not null
);

create table cliente(
	idCliente int primary key not null auto_increment,
    nome varchar(30) not null,
	endereco varchar (30) not null,
    bairro varchar(30) not null,
    cidade varchar (30) not null,
    estado varchar(2) not null,
    CEP varchar(9) not null,
    cnpj varchar(18),
    cpf varchar (14),
    sexo varchar(9) not null,
    dataNasc date not null,
    telefone varchar (15) not null,
    email varchar(30) not null
);

create table venda(
	idVenda int primary key not null auto_increment,
    data date not null,
    total double not null,
    idCliente int not null,
    foreign key (idCliente)
    references cliente (idCliente),
    idFuncionario int not null,
    foreign key (idfuncionario)
    references funcionario (idFuncionario),
    status_venda varchar(12) not null,
    desconto double(5,2) not null,
    dataVenda date not null
);

create table itens_da_venda(
	idVenda int primary key not null,
    foreign key (idVenda)
    references venda (idVenda),
    data date not null,
    idProduto int not null,
    foreign key (idProduto)
    references produto (idProduto),
    quantidade double not null,
    subtotal double not null,
    total double not null
);

create table compra(
	idCompra int primary key not null auto_increment,
    data date not null,
    idFornecedor int not null,
    foreign key (idFornecedor)
    references fornecedor (idFornecedor),
    idFuncionario int not null,
    foreign key (idFuncionario)
    references funcionario (idFuncionario),
    total double not null,
    dataCompra date not null
);

create table itens_da_compra(
	idCompra int primary key not null auto_increment,
    foreign key (idCompra)
    references compra (idCompra),
    idFornecedor int not null,
    foreign key (idFornecedor)
    references fornecedor (idFornecedor),
    idProduto int not null,
    foreign key (idProduto)
    references produto (idProduto),
    quantidade double not null,
    subtotal double not null,
    total double not null
);

select * from fornecedor;
select * from funcionario;
select * from cliente;
select * from produto;

delete from funcionario where idFuncionario = 1;

insert into funcionario (idFuncionario, senha, nome, endereco, bairro, cidade, cep, estado, cpf, cargo, cargaHoraria, salario, telefone, email, dataNasc, dataContrata, status, permissao)
values(null, "admin", "Kaio", "Rua", "Bairro", "cidade", "00", "Estado" ,"admin", "Gerente", 2, 3, "123333", "email", 2022/07/22, 2022/07/22, "ativo", 1);
    
    -- Select que conecta tabelas com chave estrangeira no programa;
SELECT p.idProduto as pid, p.idFornecedor as pforn, p.nome as pnome, codigo, p.idcategoria as pcat, precoUn, precoCusto, estoque 
FROM produto p inner join fornecedor f on f.idFornecedor = p.idfornecedor inner join categoria c on p.idcategoria = c.idCategoria;

-- Inserção de funcionários
INSERT INTO funcionario (senha, nome, endereco, bairro, cidade, CEP, estado, cpf, cargo, cargaHoraria, salario, telefone, email, dataNasc, dataContrata, status, permissao)
VALUES
  ('senha1', 'João Silva', 'Rua das Flores, 123', 'Centro', 'Cidade A', '12345-678', 'SP', '123.456.789-00', 'Vendedor', 40.00, 2500.00, '(11) 1234-5678', 'joao@example.com', '1990-05-15', '2022-03-10', 'Ativo', 1),
  ('senha2', 'Maria Santos', 'Avenida Principal, 456', 'Bairro B', 'Cidade A', '54321-876', 'SP', '987.654.321-00', 'Gerente', 45.00, 3500.00, '(11) 9876-5432', 'maria@example.com', '1985-08-20', '2021-01-05', 'Ativo', 1),
  ('senha3', 'Pedro Oliveira', 'Rua dos Ladrilhos, 789', 'Centro', 'Cidade B', '98765-432', 'RJ', '234.567.890-11', 'Vendedor', 38.00, 2300.00, '(21) 5555-5555', 'pedro@example.com', '1992-11-25', '2022-04-20', 'Ativo', 1),
  ('senha4', 'Ana Rodrigues', 'Travessa das Pedras, 56', 'Bairro C', 'Cidade B', '65432-109', 'RJ', '345.678.901-22', 'Vendedor', 40.00, 2400.00, '(21) 7777-7777', 'ana@example.com', '1993-03-03', '2022-02-15', 'Ativo', 1),
  ('senha5', 'Luiz Pereira', 'Avenida das Torres, 789', 'Bairro D', 'Cidade C', '76543-210', 'SP', '456.789.012-33', 'Caixa', 36.00, 2200.00, '(11) 3333-3333', 'luiz@example.com', '1991-07-12', '2022-05-30', 'Ativo', 1),
  ('senha6', 'Carla Santos', 'Rua das Madeiras, 23', 'Centro', 'Cidade C', '54321-987', 'SP', '567.890.123-44', 'Vendedor', 38.00, 2300.00, '(11) 5555-5555', 'carla@example.com', '1994-09-08', '2022-06-10', 'Ativo', 1),
  ('senha7', 'Ricardo Almeida', 'Avenida das Ferragens, 456', 'Bairro E', 'Cidade D', '87654-321', 'RJ', '678.901.234-55', 'Gerente', 45.00, 3500.00, '(21) 9999-9999', 'ricardo@example.com', '1987-12-18', '2021-03-20', 'Ativo', 1),
  ('senha8', 'Lúcia Pereira', 'Rua das Tintas, 34', 'Bairro F', 'Cidade D', '76543-210', 'SP', '789.012.345-66', 'Vendedor', 40.00, 2500.00, '(11) 4444-4444', 'lucia@example.com', '1995-02-28', '2022-04-05', 'Ativo', 1),
  ('senha9', 'Carlos Oliveira', 'Travessa dos Tijolos, 12', 'Centro', 'Cidade E', '23456-789', 'RJ', '890.123.456-77', 'Vendedor', 38.00, 2300.00, '(21) 6666-6666', 'carlos@example.com', '1993-06-05', '2022-01-15', 'Ativo', 1),
  ('senha10', 'Mariana Silva', 'Avenida das Telhas, 67', 'Bairro G', 'Cidade F', '98765-432', 'SP', '901.234.567-88', 'Vendedor', 40.00, 2400.00, '(11) 7777-7777', 'mariana@example.com', '1990-04-10', '2022-03-10', 'Ativo', 1);

-- Inserção de categorias
INSERT INTO categoria (descricao)
VALUES
  ('Ferramentas Elétricas'),
  ('Madeira e Compensados'),
  ('Tintas e Pintura'),
  ('Hidráulica e Encanamento'),
  ('Ferragens e Parafusos'),
  ('Iluminação e Elétrica'),
  ('Pisos e Revestimentos'),
  ('Ferramentas Manuais'),
  ('Telhas e Coberturas'),
  ('Cimento e Argamassa');

-- Inserção de fornecedores
INSERT INTO fornecedor (nome, cnpj, endereco, bairro, cidade, estado, CEP, telefone, email)
VALUES
  ('Fornecedor A', '12.345.678/0001-01', 'Rua dos Materiais, 123', 'Centro', 'Cidade A', 'SP', '12345-678', '(11) 1234-5678', 'fornecedorA@example.com'),
  ('Fornecedor B', '98.765.432/0001-02', 'Avenida das Construções, 456', 'Bairro B', 'Cidade A', 'SP', '54321-876', '(11) 9876-5432', 'fornecedorB@example.com'),
  ('Fornecedor C', '76.543.210/0001-03', 'Travessa das Ferragens, 789', 'Centro', 'Cidade B', 'RJ', '98765-432', '(21) 5555-5555', 'fornecedorC@example.com'),
  ('Fornecedor D', '23.456.789/0001-04', 'Rua das Tintas, 456', 'Bairro C', 'Cidade B', 'RJ', '65432-109', '(21) 7777-7777', 'fornecedorD@example.com'),
  ('Fornecedor E', '45.678.901/0001-05', 'Avenida dos Tubos, 789', 'Bairro D', 'Cidade C', 'SP', '76543-210', '(11) 3333-3333', 'fornecedorE@example.com'),
  ('Fornecedor F', '67.890.123/0001-06', 'Rua das Madeiras, 234', 'Centro', 'Cidade C', 'SP', '54321-987', '(11) 5555-5555', 'fornecedorF@example.com'),
  ('Fornecedor G', '89.012.345/0001-07', 'Avenida das Telhas, 567', 'Bairro E', 'Cidade D', 'RJ', '87654-321', '(21) 9999-9999', 'fornecedorG@example.com'),
  ('Fornecedor H', '12.345.678/0001-08', 'Travessa dos Parafusos, 345', 'Bairro F', 'Cidade D', 'SP', '76543-210', '(11) 4444-4444', 'fornecedorH@example.com'),
  ('Fornecedor I', '98.765.432/0001-09', 'Avenida dos Pisos, 678', 'Centro', 'Cidade E', 'RJ', '23456-789', '(21) 6666-6666', 'fornecedorI@example.com'),
  ('Fornecedor J', '76.543.210/0001-10', 'Rua das Luminárias, 123', 'Bairro G', 'Cidade F', 'SP', '98765-432', '(11) 7777-7777', 'fornecedorJ@example.com');
  
  -- Inserir produtos 
INSERT INTO produto (idFornecedor, nome, codigo, idcategoria, precoUn, precoCusto, estoque)
VALUES
    (1, 'Cimento', 'CM001', 1, 25.99, 18.99, 500),
    (2, 'Tijolos', 'TJ002', 1, 0.89, 0.55, 10000),
    (3, 'Tinta Branca', 'TN003', 2, 19.99, 12.49, 300),
    (4, 'Pregos', 'PG004', 3, 4.99, 3.25, 5000),
    (5, 'Telhas de Cerâmica', 'TL005', 4, 5.49, 3.99, 1000),
    (6, 'Luminárias LED', 'LM006', 5, 12.99, 8.99, 800),
    (7, 'Ferramenta Elétrica', 'FE007', 6, 89.99, 65.99, 200),
    (8, 'Pisos de Madeira', 'PM008', 7, 34.99, 28.99, 600),
    (9, 'Tubos de PVC', 'TP009', 8, 2.49, 1.89, 3000),
    (10, 'Portas de Aço', 'PA010', 9, 99.99, 79.99, 100);
    
-- Inserir clientes FÍSICA
INSERT INTO cliente (nome, endereco, bairro, cidade, estado, CEP, cnpj, cpf, sexo, dataNasc, telefone, email)
VALUES
    ('João da Silva', 'Rua das Flores, 123', 'Centro', 'Cidade A', 'SP', '12345-678', NULL, '123.456.789-00', 'Masculino', '1990-05-15', '(11) 1234-5678', 'joao@example.com'),
    ('Maria Souza', 'Av. Principal, 456', 'Bairro X', 'Cidade B', 'RJ', '98765-432', NULL, '987.654.321-00', 'Feminino', '1988-08-25', '(21) 9876-5432', 'maria@example.com'),
    ('José Oliveira', 'Rua das Palmeiras, 789', 'Centro', 'Cidade C', 'MG', '54321-987', NULL, '456.789.123-00', 'Masculino', '1995-02-10', '(31) 4567-8901', 'jose@example.com'),
    ('Ana Rodrigues', 'Av. Principal, 101', 'Bairro Y', 'Cidade D', 'SP', '23456-789', NULL, '234.567.890-00', 'Feminino', '1980-11-30', '(11) 2345-6789', 'ana@example.com'),
    ('Carlos Santos', 'Rua das Pedras, 222', 'Centro', 'Cidade E', 'RJ', '87654-321', NULL, '345.678.901-00', 'Masculino', '1982-07-05', '(21) 8765-4321', 'carlos@example.com'),
    ('Patrícia Pereira', 'Av. das Árvores, 333', 'Bairro Z', 'Cidade F', 'MG', '76543-210', NULL, '567.890.123-00', 'Feminino', '1991-03-20', '(31) 5678-9012', 'patricia@example.com'),
    ('Fernando Lima', 'Rua dos Muros, 444', 'Centro', 'Cidade G', 'SP', '34567-890', NULL, '678.901.234-00', 'Masculino', '1987-12-10', '(11) 6789-0123', 'fernando@example.com'),
    ('Lúcia Alves', 'Av. das Flores, 555', 'Bairro W', 'Cidade H', 'RJ', '65432-109', NULL, '789.012.345-00', 'Feminino', '1993-09-18', '(21) 7890-1234', 'lucia@example.com'),
    ('Gustavo Pereira', 'Rua das Pedras, 666', 'Centro', 'Cidade I', 'MG', '98765-432', NULL, '890.123.456-00', 'Masculino', '1984-04-08', '(31) 8901-2345', 'gustavo@example.com'),
    ('Sandra Silva', 'Av. Principal, 777', 'Bairro V', 'Cidade J', 'SP', '12345-678', NULL, '901.234.567-00', 'Feminino', '1997-06-25', '(11) 9012-3456', 'sandra@example.com'),
    ('Pedro Oliveira', 'Rua das Palmeiras, 888', 'Centro', 'Cidade K', 'RJ', '23456-789', NULL, '123.456.789-01', 'Masculino', '1992-01-15', '(21) 1234-5678', 'pedro@example.com'),
    ('Rita Rodrigues', 'Av. Principal, 999', 'Bairro U', 'Cidade L', 'MG', '87654-321', NULL, '987.654.321-01', 'Feminino', '1986-04-20', '(31) 9876-5432', 'rita@example.com');

-- Inserir clientes JURÍDICA
INSERT INTO cliente (nome, endereco, bairro, cidade, estado, CEP, cnpj, cpf, sexo, dataNasc, telefone, email)
VALUES
    ('Empresa A Construções', 'Av. das Obras, 123', 'Centro', 'Cidade M', 'SP', '54321-876', '12.345.678/0001-01', NULL, 'Jurídico', '1990-01-15', '(11) 2345-6789', 'empresaA@example.com'),
    ('Construções B Ltda', 'Rua das Edificações, 456', 'Bairro P', 'Cidade N', 'RJ', '98765-432', '98.765.432/0001-02', NULL, 'Jurídico', '1995-03-20', '(21) 9876-5432', 'construcoesB@example.com'),
    ('Material de Construção XYZ', 'Av. da Indústria, 789', 'Centro', 'Cidade O', 'MG', '23456-789', '23.456.789/0001-03', NULL, 'Jurídico', '1992-05-10', '(31) 4567-8901', 'xyz@example.com'),
    ('Construtora ABC', 'Rua dos Engenheiros, 101', 'Bairro Q', 'Cidade R', 'SP', '76543-210', '76.543.210/0001-04', NULL, 'Jurídico', '1988-09-18', '(11) 5678-9012', 'construtoraABC@example.com'),
    ('Construções e Reformas 123', 'Av. das Torres, 222', 'Centro', 'Cidade S', 'RJ', '34567-890', '34.567.890/0001-05', NULL, 'Jurídico', '1997-02-25', '(21) 6789-0123', 'construcoes123@example.com'),
    ('Loja de Materiais de Construção W', 'Rua da Obra, 333', 'Bairro R', 'Cidade T', 'MG', '12345-678', '12.345.678/0001-06', NULL, 'Jurídico', '1991-06-08', '(31) 8901-2345', 'lojaW@example.com'),
    ('Material e Ferramentas LTDA', 'Av. da Construção, 444', 'Centro', 'Cidade U', 'SP', '65432-109', '65.432.109/0001-07', NULL, 'Jurídico', '1993-11-12', '(11) 9012-3456', 'materiaisLTDA@example.com'),
    ('Construções Avançadas S.A.', 'Rua das Obras Grandes, 555', 'Bairro V', 'Cidade V', 'RJ', '23456-789', '23.456.789/0001-08', NULL, 'Jurídico', '1985-08-30', '(21) 1234-5678', 'construcoesAvancadas@example.com'),
    ('Loja de Material para Construção M', 'Av. das Grandes Obras, 666', 'Centro', 'Cidade W', 'MG', '98765-432', '98.765.432/0001-09', NULL, 'Jurídico', '1999-04-15', '(31) 2345-6789', 'lojaM@example.com'),
    ('Construção e Reforma Constru', 'Rua dos Engenheiros, 777', 'Bairro X', 'Cidade Y', 'SP', '54321-876', '54.321.876/0001-10', NULL, 'Jurídico', '1996-07-01', '(11) 5678-9012', 'construConstru@example.com');