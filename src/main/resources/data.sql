	create database investigadores;
	use investigadores;
	
	drop table if exists reserva;
	drop table if exists facultad;
	drop table if exists investigadores;
	drop table if exists equipos;
	drop table if exists usuario;
	
	create table facultad(
	id int primary key auto_increment ,
	nombre varchar(100)
	);
	
	create table investigadores(
	id varchar(8) primary key,
	nombre varchar(255),
	facultad int,
	foreign key(facultad) references facultad(id)
	on update cascade 
	on delete set null
	);
	
	create table equipos(
	id char(4) primary key,
	nombre varchar(100),
	facultad int,
	foreign key(facultad) references facultad(id)
	on update cascade
	on delete set null
	);
	
	create table reserva(
	id int primary key auto_increment,
	investigador varchar(8),
	equipo char(4),
	comienzo datetime,
	fin datetime,
	foreign key (investigador) references investigadores(id)
	on update cascade 
	on delete cascade,
	foreign key (equipo) references equipos(id)
	on update cascade
	on delete cascade
	);
	
	create table usuario (
	id int primary key auto_increment,
	username varchar (300),
	password varchar (300),
	role varchar (300)
	);
	
	insert into facultad (nombre) values
	('Filología'),
	('Matematicas'),
	('Química'),
	('Biología'),
	('Historia');
	
	insert into investigadores (id, nombre, facultad) values
	('1234567A', 'Veronika', 1),
	('1234567B', 'Isidre', 2),
	('1234567C', 'Adria', 3),
	('1234567D', 'Octavio', 4),
	('1234567E', 'Eloi', 5);
	
	insert into equipos (id, nombre, facultad) values
	('123A', 'Prometheus', 1),
	('123B', 'Nexus', 2),
	('123C', 'Interstaller', 3),
	('123D', 'Plexus', 4),
	('123E', 'Solaris', 5);
	
	insert into reserva (investigador, equipo, comienzo, fin) values
	('1234567A', '123A', now(), (now()+interval 3 hour)),
	('1234567B', '123B', now(), (now()+interval 3 hour)),
	('1234567C', '123C', now(), (now()+interval 3 hour)),
	('1234567D', '123D', now(), (now()+interval 3 hour)),
	('1234567E', '123E', now(), (now()+interval 3 hour));