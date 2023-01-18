create table Pessoa(
Id int auto_increment,
Nome varchar (50),
Data_De_Nacimento date,
FlPrincipal boolean,
primary key (Id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


create table Endereco(
Id int auto_increment,
Logradouro varchar(30),
CEP varchar(15),
Numero int,
Cidade varchar (30),
FlPrincipal boolean,
primary key (Id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table Pessoa_Endereco(
Pessoa_id int,
Endereco_id int,
foreign key (Pessoa_id) references Pessoa(Id),
foreign key (Endereco_id) references Endereco(Id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;