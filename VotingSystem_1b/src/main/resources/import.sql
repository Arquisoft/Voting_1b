insert into CONFIGURACION(id, name, description, application_Start, application_End, votation_Start, votation_End, multiple_Voting ) values ( 1,'Nombre', 'Descripcion', '2016-01-15 00:00:00', '2016-06-15 00:00:00', '2016-01-15 00:00:00', '2016-06-16 00:00:00', false);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(1, 'PP', 'PP', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(2, 'PSOE', 'PSOE', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(3, 'Cs', 'Cs', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(4, 'Podemos', 'Podemos', 1);

INSERT INTO ELECTORAL_COLLEGE(id, CODIGO, CONFIGURATION_ELECTION_ID) values(1, '12', 1);

insert into CONFIGURACION(id, name, description, application_Start, application_End, votation_Start, votation_End, multiple_Voting ) values ( 2,'Nombre2', 'Descripcion2', '2016-01-15 00:00:00', '2016-06-15 00:00:00', '2016-01-15 00:00:00', '2016-06-16 00:00:00', false);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(5, 'PP2', 'PP', 2);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(6, 'PSOE2', 'PSOE', 2);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(7, 'Cs2', 'Cs', 2);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(8, 'Podemos2', 'Podemos', 2);

INSERT INTO ELECTORAL_COLLEGE(id, CODIGO, CONFIGURATION_ELECTION_ID) values(2, '13', 2);

insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(1, 1, '12345', 'pepe@gmail.com', 'Pepe', '74213763W',0);
insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(2, 1, '12345', 'juan@gmail.com', 'Juan', '65432176T',0);
insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(3, 1, 'cambiar', 'administracion@juntaElectoral.es', 'Junta', '66666666A',1);
insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(2, 1, '12345', 'antonio@gmail.com', 'Antonio', '65432456T',0);
insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(2, 1, '12345', 'cristina@gmail.com', 'Cris', '78432176T',0);

insert into voto VALUES(10,31,NULL,1,1);
insert into voto VALUES(11,3,NULL,1,2);
insert into voto VALUES(12,50,NULL,1,3);
insert into voto VALUES(13,25,NULL,1,4);

insert into voto VALUES(14,1,NULL,2,1);
insert into voto VALUES(15,10,NULL,2,2);
insert into voto VALUES(16,5,NULL,2,3);
insert into voto VALUES(17,12,NULL,2,4);



