insert into CONFIGURACION(id, name, description, application_Start, application_End, votation_Start, votation_End, multiple_Voting ) values ( 1,'Nombre', 'Descripcion', '2016-01-15 00:00:00', '2016-06-15 00:00:00', '2016-01-15 00:00:00', '2016-06-16 00:00:00', false);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(1, 'PP', 'PP', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(2, 'PSOE', 'PSOE', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(3, 'Cs', 'Cs', 1);
insert into VOTABLE_OPTION(id, descripcion, nombre, configuration_election_id) values(4, 'Podemos', 'Podemos', 1);

INSERT INTO ELECTORAL_COLLEGE(id, CODIGO, CONFIGURATION_ELECTION_ID) values(1, '12', 1);

insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(1, 1, '12345', 'pepe@gmail.com', 'Pepe', '74213763W',0);
insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(2, 1, '12345', 'juan@gmail.com', 'Juan', '65432176T',0);
insert into USUARIOS(id, CODIGO_COLEGIO_ID, PASS, ENAME, NAME, NIF,ADMIN) VALUES(3, 1, 'cambiar', 'administracion@juntaElectoral.es', 'Junta', '66666666A',1);
