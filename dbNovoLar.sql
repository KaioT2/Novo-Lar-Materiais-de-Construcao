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

create table produto(
	idProduto int primary key not null auto_increment,
    idFornecedor int not null,
    foreign key (idFornecedor)
    references fornecedor (idFornecedor),
    nome varchar(30) not null,
    codigo varchar(13) not null, 
    categoria varchar (30) not null,
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
    sexo varchar(1) not null,
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

insert into fornecedor(idFornecedor, nome, cnpj, endereco, bairro, cidade, estado, CEP, telefone, email)
values(null, "Forn", 1, "rua", "bairro", "cidade", "MG", 1, 1, "q"); 

insert into produto (idProduto, idfornecedor, nome, codigo, categoria, precoUn, precoCusto, estoque)
values(null, 1, "Teste", 12, "Teste", 12, 1, 1);

SELECT p.idProduto as pid, p.idFornecedor as pforn, p.nome as pnome, codigo, categoria, precoUn, precoCusto, estoque FROM produto p inner join fornecedor f ON f.idFornecedor = p.idFornecedor;    
    
    