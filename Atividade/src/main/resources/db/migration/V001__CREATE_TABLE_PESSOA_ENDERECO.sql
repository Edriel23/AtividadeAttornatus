create table pessoa(
	id int auto_increment,
	nome varchar(50),
	data_de_nacimento date,
	primary key (id)
);


create table endereco(
	id int auto_increment,
	logradouro varchar(30),
	cep varchar(15),
	numero int,
	cidade varchar (30),
	fl_principal boolean,
	primary key (id)
);

create table pessoa_endereco(
	pessoa_id int,
	endereco_id int,
	foreign key (pessoa_id) references pessoa(id),
	foreign key (endereco_id) references endereco(id)
);