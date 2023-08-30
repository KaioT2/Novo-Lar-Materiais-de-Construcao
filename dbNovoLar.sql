create database dbNovoLar;

drop database dbNovoLar;

use dbNovoLar;

create table fornecedor (
	idFornecedor int primary key not null auto_increment,
    nome varchar(30) not null,
    cnpj varchar(18) not null,
    endereco varchar(80) not null,
    telefone varchar(13) not null
);

create table produto(
	idProduto int primary key not null auto_increment,
    idFornecedor int not null,
    foreign key (idFornecedor)
    references fornecedor (idFornecedor),
    nome varchar(30) not null,
    codigo varchar(13) not null, 
    precoUn double(7,2) not null,
    quantidade float not null
);

create table funcionario(
	idFuncionario int primary key not null auto_increment,
    senha varchar(30) not null,
    nome varchar(30) not null,
	endereco varchar(80) not null,
    cpf varchar (14) not null,
    cargo varchar (30) not null,
    cargaHoraria double not null,
    salario double(7,2) not null,
    telefone varchar (15) not null
);

create table cliente(
	idCliente int primary key not null auto_increment,
    nome varchar(30) not null,
	endereco varchar(80) not null,
    cpf varchar (14) not null,
    telefone varchar (15) not null
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
    references funcionario (idFuncionario)
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
    subtotal double  not null
);

create table compra(
	idCompra int primary key not null auto_increment,
    data date not null,
    idFornecedor int not null,
    foreign key (idFornecedor)
    references fornecedor (idFornecedor),
    idProduto int not null,
    foreign key (idProduto)
    references produto (idProduto),
    quantidade double not null,
    subtotal double not null
);

select * from fornecedor;
select * from funcionario;
select * from cliente;

delete from funcionario where idFuncionario = 1;

insert into funcionario (idFuncionario, senha, nome, endereco, cpf, cargo, cargaHoraria, salario, telefone)
values(null, "admin", "Kaio", "Rua", "admin", "Gerente", 2, 3, "123333");
    
    
    
    