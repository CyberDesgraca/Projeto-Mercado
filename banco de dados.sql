
/*Criação de banco de dados*/

use bancoestoque;
create table usuario(nome varchar(50), senha varchar(15), cargo varchar(15));
create table cadastros( codigo varchar(10) primary key, nome varchar(10), marca varchar(10),  preco float, quantidade varchar(10) );
