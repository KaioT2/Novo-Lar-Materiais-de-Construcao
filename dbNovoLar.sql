drop database dbNovoLar;

create database dbNovoLar;

use dbNovoLar;

create table fornecedor (
	idFornecedor int primary key not null auto_increment,
    nome varchar(40) not null,
    cnpj varchar(18) not null,
    endereco varchar (30) not null,
    bairro varchar(30) not null,
    cidade varchar (30) not null,
    estado varchar (2) not null,
    CEP varchar(9) not null,
    telefone varchar(15) not null,
    email varchar(40) not null
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
    nome varchar(40) not null,
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
    email varchar(40) not null
);

create table venda(
	idVenda int primary key not null auto_increment,
    total double(7,2) not null,
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
	idItemVenda int primary key not null auto_increment,
	idVenda int not null,
    foreign key (idVenda)
    references venda (idVenda),
    data date not null,
    idProduto int not null,
    foreign key (idProduto)
    references produto (idProduto),
    quantidade double not null,
    precoUn double(7,2) not null,
    desconto double(5,2) not null,
    total double(7,2) not null
);

create table compra(
	idCompra int primary key not null auto_increment,
    idFornecedor int not null,
    foreign key (idFornecedor)
    references fornecedor (idFornecedor),
    idFuncionario int not null,
    foreign key (idFuncionario)
    references funcionario (idFuncionario),
    total double(7,2) not null,
    desconto double(5,2) not null,
    dataCompra date not null
);

create table itens_da_compra(
	idItemCompra int primary key not null auto_increment,
	idCompra int not null ,
    foreign key (idCompra)
    references compra (idCompra),
    idProduto int not null,
    foreign key (idProduto)
    references produto (idProduto),
    quantidade double not null,
    precoCusto double(7,2) not null,
    desconto double(5,2) not null,
    total double(7,2) not null
);


insert into funcionario (idFuncionario, senha, nome, endereco, bairro, cidade, cep, estado, cpf, cargo, cargaHoraria, salario, telefone, email, dataNasc, dataContrata, status, permissao)
values
	(null, "admin", "Kaio", "Rua", "Bairro", "cidade", "00", "MG" ,"admin", "Gerente", 2, 3, "123333", "email", '2022-07-22', '2022-10-25', "ativo", 1);

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
	('senha10', 'Mariana Silva', 'Avenida das Telhas, 67', 'Bairro G', 'Cidade F', '98765-432', 'SP', '901.234.567-88', 'Vendedor', 40.00, 2400.00, '(11) 7777-7777', 'mariana@example.com', '1990-04-10', '2022-03-10', 'Ativo', 1),
	('senha11', 'Fernando Sousa', 'Rua das Pedras, 78', 'Centro', 'Cidade G', '12345-678', 'SP', '123.456.789-00', 'Vendedor', 40.00, 2500.00, '(11) 1234-5678', 'fernando@example.com', '1988-09-25', '2022-04-15', 'Ativo', 1),
    ('senha12', 'Isabela Mendes', 'Avenida Principal, 34', 'Bairro A', 'Cidade H', '54321-876', 'SP', '987.654.321-00', 'Gerente', 45.00, 3500.00, '(11) 9876-5432', 'isabela@example.com', '1983-11-14', '2021-02-20', 'Ativo', 1),
    ('senha13', 'Lucas Ferreira', 'Rua dos Ladrilhos, 56', 'Centro', 'Cidade I', '98765-432', 'RJ', '234.567.890-11', 'Vendedor', 38.00, 2300.00, '(21) 5555-5555', 'lucas@example.com', '1996-05-07', '2022-06-20', 'Ativo', 1),
    ('senha14', 'Patrícia Alves', 'Travessa das Pedras, 23', 'Bairro B', 'Cidade J', '65432-109', 'RJ', '345.678.901-22', 'Vendedor', 40.00, 2400.00, '(21) 7777-7777', 'patricia@example.com', '1997-08-30', '2022-02-05', 'Ativo', 1),
    ('senha15', 'Rafaela Gomes', 'Avenida das Torres, 12', 'Bairro C', 'Cidade K', '76543-210', 'SP', '456.789.012-33', 'Caixa', 36.00, 2200.00, '(11) 3333-3333', 'rafaela@example.com', '1992-12-22', '2022-05-10', 'Ativo', 1),
    ('senha16', 'Gabriel Santos', 'Rua das Madeiras, 78', 'Centro', 'Cidade L', '54321-987', 'SP', '567.890.123-44', 'Vendedor', 38.00, 2300.00, '(11) 5555-5555', 'gabriel@example.com', '1998-03-12', '2022-06-30', 'Ativo', 1),
    ('senha17', 'Mariano Lima', 'Avenida das Ferragens, 34', 'Bairro D', 'Cidade M', '87654-321', 'RJ', '678.901.234-55', 'Gerente', 45.00, 3500.00, '(21) 9999-9999', 'mariano@example.com', '1986-06-18', '2021-03-05', 'Ativo', 1),
    ('senha18', 'Roberta Silva', 'Rua das Tintas, 67', 'Centro', 'Cidade N', '76543-210', 'SP', '789.012.345-66', 'Vendedor', 40.00, 2500.00, '(11) 4444-4444', 'roberta@example.com', '1984-01-28', '2022-04-15', 'Ativo', 1),
    ('senha19', 'Mateus Oliveira', 'Travessa dos Tijolos, 45', 'Bairro E', 'Cidade O', '23456-789', 'RJ', '890.123.456-77', 'Vendedor', 38.00, 2300.00, '(21) 6666-6666', 'mateus@example.com', '1995-10-15', '2022-01-30', 'Ativo', 1),
    ('senha20', 'Gustavo Mendes', 'Avenida das Telhas, 89', 'Bairro F', 'Cidade P', '98765-432', 'SP', '901.234.567-88', 'Vendedor', 40.00, 2400.00, '(11) 7777-7777', 'gustavo@example.com', '1989-02-10', '2022-03-15', 'Ativo', 1),
    ('senha21', 'Juliana Oliveira', 'Rua das Flores, 123', 'Centro', 'Cidade A', '12345-678', 'SP', '123.456.789-00', 'Vendedor', 40.00, 2500.00, '(11) 1234-5678', 'juliana@example.com', '1990-05-15', '2022-03-10', 'Ativo', 1),
    ('senha22', 'Ricardo Pereira', 'Avenida Principal, 456', 'Bairro B', 'Cidade A', '54321-876', 'SP', '987.654.321-00', 'Gerente', 45.00, 3500.00, '(11) 9876-5432', 'ricardo@example.com', '1985-08-20', '2021-01-05', 'Ativo', 1),
    ('senha23', 'Carolina Silva', 'Rua dos Ladrilhos, 789', 'Centro', 'Cidade B', '98765-432', 'RJ', '234.567.890-11', 'Vendedor', 38.00, 2300.00, '(21) 5555-5555', 'carolina@example.com', '1992-11-25', '2022-04-20', 'Ativo', 1),
    ('senha24', 'Daniel Rodrigues', 'Travessa das Pedras, 56', 'Bairro C', 'Cidade B', '65432-109', 'RJ', '345.678.901-22', 'Vendedor', 40.00, 2400.00, '(21) 7777-7777', 'daniel@example.com', '1993-03-03', '2022-02-15', 'Ativo', 1),
    ('senha25', 'Luisa Pereira', 'Avenida das Torres, 789', 'Bairro D', 'Cidade C', '76543-210', 'SP', '456.789.012-33', 'Caixa', 36.00, 2200.00, '(11) 3333-3333', 'luisa@example.com', '1991-07-12', '2022-05-30', 'Ativo', 1),
    ('senha26', 'Eduardo Santos', 'Rua das Madeiras, 23', 'Centro', 'Cidade C', '54321-987', 'SP', '567.890.123-44', 'Vendedor', 38.00, 2300.00, '(11) 5555-5555', 'eduardo@example.com', '1994-09-08', '2022-06-10', 'Ativo', 1),
    ('senha27', 'Amanda Almeida', 'Avenida das Ferragens, 456', 'Bairro E', 'Cidade D', '87654-321', 'RJ', '678.901.234-55', 'Gerente', 45.00, 3500.00, '(21) 9999-9999', 'amanda@example.com', '1987-12-18', '2021-03-20', 'Ativo', 1),
    ('senha28', 'Marcos Pereira', 'Rua das Tintas, 34', 'Bairro F', 'Cidade D', '76543-210', 'SP', '789.012.345-66', 'Vendedor', 40.00, 2500.00, '(11) 4444-4444', 'marcos@example.com', '1995-02-28', '2022-04-05', 'Ativo', 1),
    ('senha29', 'Camila Oliveira', 'Travessa dos Tijolos, 12', 'Centro', 'Cidade E', '23456-789', 'RJ', '890.123.456-77', 'Vendedor', 38.00, 2300.00, '(21) 6666-6666', 'camila@example.com', '1993-06-05', '2022-01-15', 'Ativo', 1),
    ('senha30', 'Roberto Silva', 'Avenida das Telhas, 67', 'Bairro G', 'Cidade F', '98765-432', 'SP', '901.234.567-88', 'Vendedor', 40.00, 2400.00, '(11) 7777-7777', 'roberto@example.com', '1990-04-10', '2022-03-10', 'Ativo', 1);

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
	('Fornecedor J', '76.543.210/0001-10', 'Rua das Luminárias, 123', 'Bairro G', 'Cidade F', 'SP', '98765-432', '(11) 7777-7777', 'fornecedorJ@example.com'),
	('Construções ABC Ltda', '12.345.678/0001-01', 'Avenida da Construção, 123', 'Centro', 'São Paulo', 'SP', '12345-678', '(11) 1234-5678', 'contato@construcoesabc.com'),
	('Materiais de Construção XYZ', '98.765.432/0001-02', 'Rua dos Materiais, 456', 'Jardim Botânico', 'Rio de Janeiro', 'RJ', '98765-432', '(21) 9876-5432', 'vendas@materiaisxyz.com'),
	('Casa das Ferramentas', '23.456.789/0001-03', 'Avenida das Ferramentas, 789', 'Setor Industrial', 'Belo Horizonte', 'MG', '23456-789', '(31) 2345-6789', 'contato@casadasferramentas.com'),
	('Madeireira Silva', '87.654.321/0001-04', 'Rua das Madeiras, 101', 'Jardim das Árvores', 'Salvador', 'BA', '87654-321', '(71) 8765-4321', 'madeireira.silva@email.com'),
	('Telhas & Cia', '45.678.912/0001-05', 'Avenida das Telhas, 555', 'Vila Telhado', 'Porto Alegre', 'RS', '45678-912', '(51) 4567-8912', 'contato@telhasecia.com'),
	('Construções Forte', '32.109.876/0001-06', 'Rua Forte, 222', 'Jardim Fortaleza', 'Joinville', 'SC', '32109-876', '(47) 3210-9876', 'vendas@construcoesforte.com'),
	('Materiais de Construção Suprema', '56.789.123/0001-07', 'Avenida Suprema, 333', 'Setor Supremo', 'Curitiba', 'PR', '56789-123', '(41) 5678-9123', 'contato@suprema.com'),
	('Madeireira do Norte', '78.912.345/0001-08', 'Avenida do Norte, 888', 'Bairro do Norte', 'Brasília', 'DF', '78912-345', '(61) 7891-2345', 'madeireiradonorte@email.com'),
	('Tubos e Canos Ltda', '67.891.234/0001-09', 'Rua dos Tubos, 777', 'Setor Tubular', 'Recife', 'PE', '67891-234', '(81) 6789-1234', 'vendas@tubosecanos.com'),
	('Tijolos & Cia', '45.678.912/0001-10', 'Avenida dos Tijolos, 999', 'Vila dos Tijolos', 'Fortaleza', 'CE', '45678-912', '(85) 4567-8912', 'contato@tijoloscia.com'),
	('Portas de Aço S.A.', '23.109.876/0001-11', 'Rua das Portas, 111', 'Setor das Portas', 'Goiânia', 'GO', '23109-876', '(62) 2310-9876', 'vendas@portasdeaco.com'),
	('Luminárias Modernas', '34.567.891/0001-12', 'Avenida das Luminárias, 777', 'Jardim das Luzes', 'Belém', 'PA', '34567-891', '(91) 3456-7891', 'contato@luminariasmodernas.com'),
	('Pisos & Revestimentos', '78.912.345/0001-13', 'Avenida dos Pisos, 888', 'Bairro dos Pisos', 'Manaus', 'AM', '78912-345', '(92) 7891-2345', 'vendas@pisoserevestimentos.com'),
	('Ferramentas Master', '45.678.912/0001-14', 'Rua das Ferramentas, 666', 'Setor de Ferramentas', 'Rio Branco', 'AC', '45678-912', '(68) 4567-8912', 'contato@ferramentasmaster.com'),
	('Parafusos & Parafusos', '23.109.876/0001-15', 'Avenida dos Parafusos, 333', 'Bairro dos Parafusos', 'Boa Vista', 'RR', '23109-876', '(95) 2310-9876', 'vendas@parafusosparafusos.com'),
	('Materiais de Construção 2000', '34.567.891/0001-16', 'Avenida das Construções, 222', 'Setor 2000', 'Palmas', 'TO', '34567-891', '(63) 3456-7891', 'contato@materiais2000.com'),
	('Construções Silva & Cia', '78.912.345/0001-17', 'Rua das Obras, 777', 'Jardim das Construções', 'Natal', 'RN', '78912-345', '(84) 7891-2345', 'vendas@silvaconstrucoes.com'),
	('Tintas & Pinturas Ltda', '67.891.234/0001-18', 'Avenida das Tintas, 888', 'Setor Pintura', 'João Pessoa', 'PB', '67891-234', '(83) 6789-1234', 'vendas@tintasepinturas.com'),
	('Elétrica & Eletrônica S.A.', '45.678.912/0001-19', 'Rua das Instalações, 666', 'Setor Elétrico', 'Teresina', 'PI', '45678-912', '(86) 4567-8912', 'contato@eletricaeletronica.com'),
	('Tubos de PVC & Cia', '23.109.876/0001-20', 'Avenida dos Tubos, 333', 'Vila do PVC', 'Aracaju', 'SE', '23109-876', '(79) 2310-9876', 'vendas@tubosdepvc.com'),
	('Materiais de Construção do Sul', '34.567.891/0001-21', 'Avenida do Sul, 222', 'Bairro do Sul', 'Cuiabá', 'MT', '34567-891', '(65) 3456-7891', 'contato@materiaisdosul.com'),
	('Ferramentas & Acessórios', '78.912.345/0001-22', 'Rua das Ferramentas, 777', 'Setor de Acessórios', 'Porto Velho', 'RO', '78912-345', '(69) 7891-2345', 'vendas@ferramentaseacessorios.com'),
	('Construções do Nordeste', '67.891.234/0001-23', 'Avenida do Nordeste, 888', 'Vila Nordeste', 'Campo Grande', 'MS', '67891-234', '(67) 6789-1234', 'vendas@construcoesdonordeste.com'),
	('Pisos & Acabamentos', '45.678.912/0001-24', 'Rua dos Acabamentos, 666', 'Setor de Acabamentos', 'Maceió', 'AL', '45678-912', '(82) 4567-8912', 'contato@pisoseacabamentos.com'),
	('Tintas & Cores', '23.109.876/0001-25', 'Avenida das Cores, 333', 'Bairro das Cores', 'Vitória', 'ES', '23109-876', '(27) 2310-9876', 'vendas@tintasecores.com'),
	('Materiais de Construção do Centro', '34.567.891/0001-26', 'Avenida do Centro, 222', 'Bairro do Centro', 'Macapá', 'AP', '34567-891', '(96) 3456-7891', 'contato@materiaisdocentro.com'),
	('Ferragens & Ferramentas', '78.912.345/0001-27', 'Rua das Ferragens, 777', 'Setor de Ferragens', 'Boa Vista', 'RR', '78912-345', '(95) 7891-2345', 'vendas@ferragenseferramentas.com'),
	('Construções do Sul ao Norte', '67.891.234/0001-28', 'Avenida do Sul ao Norte, 888', 'Vila Sul ao Norte', 'Belém', 'PA', '67891-234', '(91) 6789-1234', 'vendas@sulaonorte.com'),
	('Materiais & Mais', '45.678.912/0001-29', 'Rua dos Mais, 666', 'Setor dos Mais', 'São Luís', 'MA', '45678-912', '(98) 4567-8912', 'contato@materiaisemais.com'),
	('Construções do Oeste', '23.109.876/0001-30', 'Avenida do Oeste, 333', 'Bairro do Oeste', 'Florianópolis', 'SC', '23109-876', '(48) 2310-9876', 'vendas@construcoesdooeste.com');
  
-- Inserir produtos
INSERT INTO produto (idFornecedor, nome, codigo, idcategoria, precoUn, precoCusto, estoque)
VALUES
    (1, 'Cimento', 001, 1, 25.99, 18.99, 500),
    (2, 'Tijolos', 002, 1, 0.89, 0.55, 10000),
    (3, 'Tinta Branca', 003, 2, 19.99, 12.49, 300),
    (4, 'Pregos', 004, 3, 4.99, 3.25, 5000),
    (5, 'Telhas de Cerâmica', 005, 4, 5.49, 3.99, 1000),
    (6, 'Luminárias LED', 006, 5, 12.99, 8.99, 800),
    (7, 'Ferramenta Elétrica', 007, 6, 89.99, 65.99, 200),
    (8, 'Pisos de Madeira', 008, 7, 34.99, 28.99, 600),
    (9, 'Tubos de PVC', 009, 8, 2.49, 1.89, 3000),
    (10, 'Portas de Aço', 010, 9, 99.99, 79.99, 100),
    (1, 'Cimento Portland', 'CP001', 1, 25.99, 18.99, 500),
    (2, 'Tijolos Vermelhos', 'TV002', 1, 0.89, 0.55, 10000),
    (3, 'Tinta Branca Látex', 'TB003', 2, 19.99, 12.49, 300),
    (4, 'Pregos Galvanizados', 'PG004', 3, 4.99, 3.25, 5000),
    (5, 'Telhas de Cerâmica', 'TC005', 4, 5.49, 3.99, 1000),
    (6, 'Luminária de LED 10W', 'LL006', 5, 12.99, 8.99, 800),
    (7, 'Furadeira Elétrica', 'FE007', 6, 89.99, 65.99, 200),
    (8, 'Pisos de Madeira de Carvalho', 'PMC008', 7, 34.99, 28.99, 600),
    (9, 'Tubos de PVC 1/2"', 'TPVC009', 8, 2.49, 1.89, 3000),
    (10, 'Porta de Aço com Fechadura', 'PAF010', 9, 99.99, 79.99, 100),
    (11, 'Cimento Composto', 'CC011', 1, 28.99, 20.99, 400),
    (12, 'Tijolos de Concreto', 'TC012', 1, 0.79, 0.49, 12000),
    (13, 'Tinta para Exterior', 'TE013', 2, 24.99, 16.99, 500),
    (14, 'Parafusos para Madeira', 'PM014', 3, 3.49, 2.49, 8000),
    (15, 'Telhas de Metal', 'TM015', 4, 6.99, 4.99, 1500),
    (16, 'Luminária de LED 20W', 'LL016', 5, 24.99, 18.99, 500),
    (17, 'Serra Circular', 'SC017', 6, 129.99, 99.99, 300),
    (18, 'Pisos de Porcelanato', 'PP018', 7, 42.99, 36.99, 400),
    (19, 'Tubos de PVC 1"', 'TPVC019', 8, 3.99, 2.79, 2500),
    (20, 'Porta de Madeira Maciça', 'PMM020', 9, 149.99, 119.99, 80),
    (21, 'Cimento Branco', 'CB021', 1, 32.99, 24.99, 300),
    (22, 'Tijolos de Barro', 'TB022', 1, 0.99, 0.69, 8000),
    (23, 'Tinta para Interior', 'TI023', 2, 22.99, 15.99, 600),
    (24, 'Parafusos de Aço Inoxidável', 'PAI024', 3, 5.99, 4.49, 4000),
    (25, 'Telhas de Fibrocimento', 'TF025', 4, 7.99, 5.49, 1200),
    (26, 'Luminária de LED 30W', 'LL026', 5, 32.99, 25.99, 300),
    (27, 'Serra Elétrica de Bancada', 'SEB027', 6, 249.99, 189.99, 150),
    (28, 'Pisos de Granito', 'PG028', 7, 59.99, 49.99, 200),
    (29, 'Tubos de PVC 2"', 'TPVC029', 8, 4.99, 3.49, 1800),
    (30, 'Porta de Alumínio', 'PA030', 9, 119.99, 99.99, 120),
    (31, 'Cimento Rápido', 'CR031', 1, 34.99, 26.99, 250),
    (32, 'Tijolos de Vidro', 'TV032', 1, 1.29, 0.89, 6000),
    (33, 'Tinta Epóxi', 'TE033', 2, 29.99, 22.99, 350),
    (34, 'Parafusos de Latão', 'PL034', 3, 6.99, 5.29, 3200),
    (35, 'Telhas de Ardósia', 'TA035', 4, 9.99, 7.99, 900),
    (36, 'Luminária de LED 50W', 'LL036', 5, 49.99, 39.99, 180),
    (37, 'Serra de Esquadria', 'SE037', 6, 179.99, 139.99, 80),
    (38, 'Pisos de Mármore', 'PM038', 7, 79.99, 69.99, 100),
    (39, 'Tubos de PVC 3"', 'TPVC039', 8, 6.99, 4.99, 1200),
    (40, 'Porta de Vidro Temperado', 'PVT040', 9, 199.99, 159.99, 60);

    
-- Inserir clientes FÍSICA
INSERT INTO cliente (nome, endereco, bairro, cidade, estado, CEP, cnpj, cpf, sexo, dataNasc, telefone, email)
VALUES
	-- Consumidor para clientes não cadastrados ('Conumidor Final', '', '', ' ', '', '', NULL, '', '', '', '', ''),
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
    ('Rita Rodrigues', 'Av. Principal, 999', 'Bairro U', 'Cidade L', 'MG', '87654-321', NULL, '987.654.321-01', 'Feminino', '1986-04-20', '(31) 9876-5432', 'rita@example.com'),
    ('João da Silva', 'Rua A', 'Centro', 'São Paulo', 'SP', '01000-000', NULL, '123.456.789-09', 'Masculino', '1985-05-15', '(11) 1234-5678', 'joao.silva@email.com'),
    ('Maria Santos', 'Av. B', 'Vila Nova', 'Rio de Janeiro', 'RJ', '20000-000', NULL, '987.654.321-01', 'Feminino', '1990-07-20', '(21) 9876-5432', 'maria.santos@email.com'),
    ('José Pereira', 'Rua C', 'Jardim', 'Belo Horizonte', 'MG', '30000-000', NULL, '555.555.555-55', 'Masculino', '1980-03-10', '(31) 5555-5555', 'jose.pereira@email.com'),
    ('Ana Costa', 'Av. D', 'Barra', 'Salvador', 'BA', '40000-000', NULL, '777.777.777-77', 'Feminino', '1988-12-05', '(71) 7777-7777', 'ana.costa@email.com'),
    ('Carlos Santos', 'Rua E', 'Centro', 'Recife', 'PE', '50000-000', NULL, '444.444.444-44', 'Masculino', '1995-02-28', '(81) 4444-4444', 'carlos.santos@email.com'),
    ('Sônia Oliveira', 'Av. F', 'Vila Nova', 'Porto Alegre', 'RS', '90000-000', NULL, '666.666.666-66', 'Feminino', '1983-09-18', '(51) 6666-6666', 'sonia.oliveira@email.com'),
    ('Eduardo Silva', 'Rua G', 'Jardim', 'Brasília', 'DF', '70000-000', NULL, '888.888.888-88', 'Masculino', '1976-11-30', '(61) 8888-8888', 'eduardo.silva@email.com'),
    ('Patrícia Alves', 'Av. H', 'Barra', 'Curitiba', 'PR', '80000-000', NULL, '999.999.999-99', 'Feminino', '1992-08-12', '(41) 9999-9999', 'patricia.alves@email.com'),
    ('Luiz Pereira', 'Rua I', 'Centro', 'Fortaleza', 'CE', '60000-000', NULL, '222.222.222-22', 'Masculino', '1987-04-25', '(85) 2222-2222', 'luiz.pereira@email.com'),
    ('Fernanda Lima', 'Av. J', 'Vila Nova', 'Manaus', 'AM', '69000-000', NULL, '111.111.111-11', 'Feminino', '1998-06-08', '(92) 1111-1111', 'fernanda.lima@email.com');

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
    ('Construção e Reforma Constru', 'Rua dos Engenheiros, 777', 'Bairro X', 'Cidade Y', 'SP', '54321-876', '54.321.876/0001-10', NULL, 'Jurídico', '1996-07-01', '(11) 5678-9012', 'construConstru@example.com'),
    ('Empresa ABC Ltda', 'Rua X', 'Centro Empresarial', 'São Paulo', 'SP', '01000-000', '12.345.678/0001-01', NULL, 'Jurídico', '1990-10-10', '(11) 5555-5555', 'contato@empresaabc.com'),
    ('Comércio XYZ Eireli', 'Av. Y', 'Centro Comercial', 'Rio de Janeiro', 'RJ', '20000-000', '98.765.432/0001-02', NULL, 'Jurídico', '1995-06-15', '(21) 4444-4444', 'contato@comercioxyz.com'),
    ('Indústria 123 S.A.', 'Rua Z', 'Parque Industrial', 'Belo Horizonte', 'MG', '30000-000', '99.999.999/0001-03', NULL, 'Jurídico', '1987-03-20', '(31) 3333-3333', 'contato@industria123.com'),
    ('Serviços ABCD Ltda', 'Av. W', 'Centro de Serviços', 'Salvador', 'BA', '40000-000', '11.111.111/0001-04', NULL, 'Jurídico', '2000-12-01', '(71) 6666-6666', 'contato@servicosabcd.com'),
    ('Distribuidora XYZ S.A.', 'Rua V', 'Logística', 'Recife', 'PE', '50000-000', '22.222.222/0001-05', NULL, 'Jurídico', '1998-08-08', '(81) 7777-7777', 'contato@distribuidoraxyz.com'),
    ('Construtora 1234 Ltda', 'Av. U', 'Construção Civil', 'Porto Alegre', 'RS', '90000-000', '33.333.333/0001-06', NULL, 'Jurídico', '1993-05-25', '(51) 8888-8888', 'contato@construtora1234.com'),
    ('Transportadora ABCDE Ltda', 'Rua T', 'Logística', 'Brasília', 'DF', '70000-000', '44.444.444/0001-07', NULL, 'Jurídico', '1985-12-12', '(61) 9999-9999', 'contato@transportadoraabcde.com'),
    ('Consultoria XYZ123 S.A.', 'Av. S', 'Consultoria Empresarial', 'Curitiba', 'PR', '80000-000', '55.555.555/0001-08', NULL, 'Jurídico', '1996-09-30', '(41) 1111-1111', 'contato@consultoriaxyz123.com'),
    ('Comércio de Alimentos ABCDE Eireli', 'Rua R', 'Comércio Alimentício', 'Fortaleza', 'CE', '60000-000', '66.666.666/0001-09', NULL, 'Jurídico', '2002-02-22', '(85) 3333-3333', 'contato@comerciodealimentos.com'),
    ('Indústria Metalúrgica XYZ1234 S.A.', 'Av. Q', 'Indústria Metalúrgica', 'Manaus', 'AM', '69000-000', '77.777.777/0001-10', NULL, 'Jurídico', '1991-07-07', '(92) 7777-7777', 'contato@industriametalurgica.com');

INSERT INTO venda (total, idCliente, idFuncionario, status_venda, desconto, dataVenda)
VALUES
    (169.93, 1, 1, 'Concluída', 00.00, '2023-09-20'),
    (23.87, 2, 2, 'Concluída', 00.00, '2023-09-21'),
    (111.95, 3, 3, 'Concluída', 00.00, '2023-09-22'),
    (108.95, 4, 4, 'Concluída', 00.00, '2023-09-23'),
    (214.92, 5, 5, 'Concluída', 00.00, '2023-09-24'),
    (241.90, 6, 6, 'Concluída', 00.00, '2023-09-25'),
    (32.07, 7, 7, 'Concluída', 00.00, '2023-09-26'),
    (280.95, 8, 8, 'Concluída', 00.00, '2023-09-27'),
    (204.91, 9, 9, 'Concluída', 00.00, '2023-09-28'),
    (124.90, 10, 10, 'Concluída', 00.00, '2023-09-29'),
	(169.93, 1, 1, 'Concluída', 0.00, '2023-09-01'),
    (23.87, 2, 2, 'Concluída', 0.00, '2023-09-02'),
    (111.95, 3, 3, 'Concluída', 0.00, '2023-09-03'),
    (108.95, 4, 4, 'Concluída', 0.00, '2023-09-04'),
    (214.92, 5, 5, 'Concluída', 0.00, '2023-09-05'),
    (241.90, 6, 6, 'Concluída', 0.00, '2023-09-06'),
    (32.07, 7, 7, 'Concluída', 0.00, '2023-09-07'),
    (280.95, 8, 8, 'Concluída', 0.00, '2023-09-08'),
    (204.91, 9, 9, 'Concluída', 0.00, '2023-09-09'),
    (124.89, 10, 10, 'Concluída', 0.00, '2023-09-10');

INSERT INTO itens_da_venda (idVenda, data, idProduto, quantidade, precoUn, desconto, total)
VALUES
    (1, '2023-09-20', 1, 5, 25.99, 0.00, 129.95),
    (1, '2023-09-20', 3, 2, 19.99, 00.00, 39.98),
    (2, '2023-09-21', 2, 10, 0.89, 0.00, 8.90),
    (2, '2023-09-21', 4, 3, 4.99, 0.00, 14.97),
    (3, '2023-09-22', 5, 4, 5.49, 0.00, 21.96),
    (3, '2023-09-22', 7, 1, 89.99, 0.00, 89.99),
    (4, '2023-09-23', 6, 3, 12.99, 0.00, 38.97),
    (4, '2023-09-23', 8, 2, 34.99, 0.00, 69.98),
    (5, '2023-09-24', 9, 6, 2.49, 0.00, 14.94),
    (5, '2023-09-24', 10, 2, 99.99, 0.00, 199.98),
    (6, '2023-09-25', 11, 7, 25.99, 0.00, 181.93),
    (6, '2023-09-25', 13, 3, 19.99, 0.00, 59.97),
    (7, '2023-09-26', 12, 8, 0.89, 0.00, 7.12),
    (7, '2023-09-26', 14, 5, 4.99, 0.00, 24.95),
    (8, '2023-09-27', 15, 2, 5.49, 0.00, 10.98),
    (8, '2023-09-27', 17, 3, 89.99, 0.00, 269.97),
    (9, '2023-09-28', 16, 5, 12.99, 0.00, 64.95),
    (9, '2023-09-28', 18, 4, 34.99, 0.00, 139.96),
    (10, '2023-09-29', 19, 10, 2.49, 0.00, 24.90),
    (10, '2023-09-29', 20, 1, 99.99, 0.00, 100.00),
    (11, '2023-09-01', 21, 5, 25.99, 0.00, 129.95),
    (11, '2023-09-01', 23, 2, 19.99, 0.00, 39.98),
    (12, '2023-09-02', 22, 10, 0.89, 0.00, 8.90),
    (12, '2023-09-02', 24, 3, 4.99, 0.00, 14.97),
    (13, '2023-09-03', 25, 4, 5.49, 0.00, 21.96),
    (13, '2023-09-03', 27, 1, 89.99, 0.00, 89.99),
    (14, '2023-09-04', 26, 3, 12.99, 0.00, 38.97),
    (14, '2023-09-04', 28, 2, 34.99, 0.00, 69.98),
    (15, '2023-09-05', 29, 6, 2.49, 0.00, 14.94),
    (15, '2023-09-05', 10, 2, 99.99, 0.00, 199.98),
    (16, '2023-09-06', 21, 7, 25.99, 0.00, 181.93),
    (16, '2023-09-06', 23, 3, 19.99, 0.00, 59.97),
    (17, '2023-09-07', 22, 8, 0.89, 0.00, 7.12),
    (17, '2023-09-07', 24, 5, 4.99, 0.00, 24.95),
    (18, '2023-09-08', 25, 2, 5.49, 0.00, 10.98),
    (18, '2023-09-08', 27, 3, 89.99, 0.00, 269.97),
    (19, '2023-09-09', 26, 5, 12.99, 0.00, 64.95),
    (19, '2023-09-09', 8, 4, 34.99, 0.00, 139.96),
    (20, '2023-09-10', 9, 10, 2.49, 0.00, 24.90),
    (20, '2023-09-10', 10, 1, 99.99, 0.00, 99.99);

INSERT INTO compra (dataCompra, total, idfuncionario, idfornecedor, desconto)
VALUES
    ('2023-09-27', 39.63, 1, 1, 0.00),
    ('2023-09-27', 18.99, 2, 2, 0.00),
    ('2023-09-28', 16.97, 3, 3, 0.00),
    ('2023-09-29', 255.95, 4, 4, 0.00),
    ('2023-09-29', 163.76, 1, 2, 0.00),
    ('2023-09-30', 76.51, 2, 3, 0.00),
    ('2023-09-30', 43.97, 3, 4, 0.00),
    ('2023-10-01', 16.97, 4, 1, 0.00),
    ('2023-10-01', 416.92, 1, 2, 0.00),
    ('2023-10-02', 163.76, 2, 3, 0.00),
    ('2023-10-02', 21.97, 3, 4, 0.00),
    ('2023-10-03', 53.46, 4, 1, 0.00),
    ('2023-10-03', 28.97, 1, 2, 0.00),
    ('2023-10-04', 373.95, 2, 3, 0.00),
    ('2023-10-04', 125.57, 3, 4, 0.00),
    ('2023-10-05', 39.63, 4, 1, 0.00),
    ('2023-10-05', 18.99, 1, 2, 0.00),
    ('2023-10-06', 16.97, 2, 3, 0.00),
    ('2023-10-06', 255.95, 3, 4, 0.00),
    ('2023-10-07', 163.76, 4, 1, 0.00),
    ('2023-10-07', 21.97, 1, 2, 0.00),
    ('2023-10-08', 53.46, 2, 3, 0.00),
    ('2023-10-08', 28.97, 3, 4, 0.00),
    ('2023-10-09', 373.95, 4, 1, 0.00),
    ('2023-10-09', 125.57, 1, 2, 0.00),
    ('2023-10-10', 39.63, 2, 3, 0.00),
    ('2023-10-10', 18.99, 3, 4, 0.00),
    ('2023-10-11', 16.97, 4, 1, 0.00),
    ('2023-10-11', 255.95, 1, 2, 0.00),
    ('2023-10-12', 163.76, 2, 3, 0.00),
    ('2023-10-12', 21.97, 3, 4, 0.00),
    ('2023-10-13', 53.46, 4, 1, 0.00),
    ('2023-10-13', 28.97, 1, 2, 0.00),
    ('2023-10-14', 373.95, 2, 3, 0.00),
    ('2023-10-14', 125.57, 3, 4, 0.00),
    ('2023-10-15', 39.63, 4, 1, 0.00),
    ('2023-10-15', 18.99, 1, 2, 0.00),
    ('2023-10-16', 16.97, 2, 3, 0.00),
    ('2023-10-16', 255.95, 3, 4, 0.00),
    ('2023-10-17', 163.76, 4, 1, 0.00),
    ('2023-10-17', 21.97, 1, 2, 0.00),
    ('2023-10-18', 53.46, 2, 3, 0.00),
    ('2023-10-18', 28.97, 3, 4, 0.00),
    ('2023-10-19', 373.95, 4, 1, 0.00),
    ('2023-10-19', 125.57, 1, 2, 0.00),
    ('2023-10-20', 39.63, 2, 3, 0.00),
    ('2023-10-20', 18.99, 3, 4, 0.00);

INSERT INTO itens_da_compra (idcompra, idproduto, quantidade, precoCusto, total, desconto)
VALUES
    (1, 1, 2, 18.99, 37.98, 0.00), -- Compra 1, Produto 1
    (1, 2, 3, 0.55, 1.65, 0.00), -- Compra 1, Produto 2
    (2, 3, 1, 12.49, 12.49, 0.00), -- Compra 2, Produto 3
    (2, 4, 2, 3.25, 6.50, 0.00), -- Compra 2, Produto 4
    (3, 5, 2, 3.99, 7.98, 0.00), -- Compra 3, Produto 5
    (3, 6, 1, 8.99, 8.99, 0.00), -- Compra 3, Produto 6
    (4, 7, 3, 65.99, 197.97, 0.00), -- Compra 4, Produto 7
    (4, 8, 2, 28.99, 57.98, 0.00), -- Compra 4, Produto 8
    (5, 9, 2, 1.89, 3.78, 0.00), -- Compra 5, Produto 9
    (5, 10, 2, 79.99, 159.98, 0.00), -- Compra 5, Produto 10
    (6, 11, 4, 18.99, 75.96, 0.00), -- Compra 6, Produto 11
    (6, 12, 1, 0.55, 0.55, 0.00), -- Compra 6, Produto 12
    (7, 13, 3, 12.49, 37.47, 0.00), -- Compra 7, Produto 13
    (7, 14, 2, 3.25, 6.50, 0.00), -- Compra 7, Produto 14
    (8, 15, 2, 3.99, 7.98, 0.00), -- Compra 8, Produto 15
    (8, 16, 1, 8.99, 8.99, 0.00), -- Compra 8, Produto 16
    (9, 17, 5, 65.99, 329.95, 0.00), -- Compra 9, Produto 17
    (9, 18, 3, 28.99, 86.97, 0.00), -- Compra 9, Produto 18
    (10, 19, 2, 1.89, 3.78, 0.00), -- Compra 10, Produto 19
    (10, 20, 2, 79.99, 159.98, 0.00), -- Compra 10, Produto 20
    (11, 21, 1, 20.99, 20.99, 0.00), -- Compra 11, Produto 21
    (11, 22, 2, 0.49, 0.98, 0.00), -- Compra 11, Produto 22
    (12, 23, 3, 16.99, 50.97, 0.00), -- Compra 12, Produto 23
    (12, 24, 1, 2.49, 2.49, 0.00), -- Compra 12, Produto 24
    (13, 25, 2, 4.99, 9.98, 0.00), -- Compra 13, Produto 25
    (13, 26, 1, 18.99, 18.99, 0.00), -- Compra 13, Produto 26
    (14, 27, 3, 99.99, 299.97, 0.00), -- Compra 14, Produto 27
    (14, 28, 2, 36.99, 73.98, 0.00), -- Compra 14, Produto 28
    (15, 29, 2, 2.79, 5.58, 0.00), -- Compra 15, Produto 29
    (15, 30, 1, 119.99, 119.99, 0.00), -- Compra 15, Produto 30
    (16, 11, 2, 18.99, 37.98, 0.00), -- Compra 16, Produto 11
    (16, 12, 3, 0.55, 1.65, 0.00), -- Compra 16, Produto 12
    (17, 13, 1, 12.49, 12.49, 0.00), -- Compra 17, Produto 13
    (17, 14, 2, 3.25, 6.50, 0.00), -- Compra 17, Produto 14
    (18, 15, 2, 3.99, 7.98, 0.00), -- Compra 18, Produto 15
    (18, 16, 1, 8.99, 8.99, 0.00), -- Compra 18, Produto 16
    (19, 17, 3, 65.99, 197.97, 0.00), -- Compra 19, Produto 17
    (19, 18, 2, 28.99, 57.98, 0.00), -- Compra 19, Produto 18
    (20, 19, 2, 1.89, 3.78, 0.00), -- Compra 20, Produto 19
    (20, 20, 2, 79.99, 159.98, 0.00), -- Compra 20, Produto 20
    (21, 21, 1, 20.99, 20.99, 0.00), -- Compra 21, Produto 21
    (21, 22, 2, 0.49, 0.98, 0.00), -- Compra 21, Produto 22
    (22, 23, 3, 16.99, 50.97, 0.00), -- Compra 22, Produto 23
    (22, 24, 1, 2.49, 2.49, 0.00), -- Compra 22, Produto 24
    (23, 25, 2, 4.99, 9.98, 0.00), -- Compra 23, Produto 25
    (23, 26, 1, 18.99, 18.99, 0.00), -- Compra 23, Produto 26
    (24, 27, 3, 99.99, 299.97, 0.00), -- Compra 24, Produto 27
    (24, 28, 2, 36.99, 73.98, 0.00), -- Compra 24, Produto 28
    (25, 29, 2, 2.79, 5.58, 0.00), -- Compra 25, Produto 29
    (25, 30, 1, 119.99, 119.99, 0.00), -- Compra 25, Produto 30
    (26, 11, 2, 18.99, 37.98, 0.00), -- Compra 26, Produto 11
    (26, 12, 3, 0.55, 1.65, 0.00), -- Compra 26, Produto 12
    (27, 13, 1, 12.49, 12.49, 0.00), -- Compra 27, Produto 13
    (27, 14, 2, 3.25, 6.50, 0.00), -- Compra 27, Produto 14
    (28, 15, 2, 3.99, 7.98, 0.00), -- Compra 28, Produto 15
    (28, 16, 1, 8.99, 8.99, 0.00), -- Compra 28, Produto 16
    (29, 17, 3, 65.99, 197.97, 0.00), -- Compra 29, Produto 17
    (29, 18, 2, 28.99, 57.98, 0.00), -- Compra 29, Produto 18
    (30, 19, 2, 1.89, 3.78, 0.00), -- Compra 30, Produto 19
    (30, 20, 2, 79.99, 159.98, 0.00), -- Compra 30, Produto 20
    (31, 21, 1, 20.99, 20.99, 0.00), -- Compra 31, Produto 21
    (31, 22, 2, 0.49, 0.98, 0.00), -- Compra 31, Produto 22
    (32, 23, 3, 16.99, 50.97, 0.00), -- Compra 32, Produto 23
    (32, 24, 1, 2.49, 2.49, 0.00), -- Compra 32, Produto 24
    (33, 25, 2, 4.99, 9.98, 0.00), -- Compra 33, Produto 25
    (33, 26, 1, 18.99, 18.99, 0.00), -- Compra 33, Produto 26
    (34, 27, 3, 99.99, 299.97, 0.00), -- Compra 34, Produto 27
    (34, 28, 2, 36.99, 73.98, 0.00), -- Compra 34, Produto 28
    (35, 29, 2, 2.79, 5.58, 0.00), -- Compra 35, Produto 29
    (35, 30, 1, 119.99, 119.99, 0.00), -- Compra 35, Produto 30
    (36, 11, 2, 18.99, 37.98, 0.00), -- Compra 36, Produto 11
    (36, 12, 3, 0.55, 1.65, 0.00), -- Compra 36, Produto 12
    (37, 13, 1, 12.49, 12.49, 0.00), -- Compra 37, Produto 13
    (37, 14, 2, 3.25, 6.50, 0.00), -- Compra 37, Produto 14
    (38, 15, 2, 3.99, 7.98, 0.00), -- Compra 38, Produto 15
    (38, 16, 1, 8.99, 8.99, 0.00), -- Compra 38, Produto 16
    (39, 17, 3, 65.99, 197.97, 0.00), -- Compra 39, Produto 17
    (39, 18, 2, 28.99, 57.98, 0.00), -- Compra 39, Produto 18
    (40, 19, 2, 1.89, 3.78, 0.00), -- Compra 40, Produto 19
    (40, 20, 2, 79.99, 159.98, 0.00), -- Compra 40, Produto 20
    (41, 21, 1, 20.99, 20.99, 0.00), -- Compra 41, Produto 21
    (41, 22, 2, 0.49, 0.98, 0.00), -- Compra 41, Produto 22
    (42, 23, 3, 16.99, 50.97, 0.00), -- Compra 42, Produto 23
    (42, 24, 1, 2.49, 2.49, 0.00), -- Compra 42, Produto 24
    (43, 25, 2, 4.99, 9.98, 0.00), -- Compra 43, Produto 25
    (43, 26, 1, 18.99, 18.99, 0.00), -- Compra 43, Produto 26
    (44, 27, 3, 99.99, 299.97, 0.00), -- Compra 44, Produto 27
    (44, 28, 2, 36.99, 73.98, 0.00), -- Compra 44, Produto 28
    (45, 29, 2, 2.79, 5.58, 0.00), -- Compra 45, Produto 29
    (45, 30, 1, 119.99, 119.99, 0.00), -- Compra 45, Produto 30
    (46, 11, 2, 18.99, 37.98, 0.00), -- Compra 46, Produto 11
    (46, 12, 3, 0.55, 1.65, 0.00), -- Compra 46, Produto 12
    (47, 13, 1, 12.49, 12.49, 0.00), -- Compra 47, Produto 13
    (47, 14, 2, 3.25, 6.50, 0.00); -- Compra 47, Produto 14
 
 select count(*), sum(v.total) from vendas v where month(dataVenda) = month(now());