INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('EJGV','Sanmaniego',2,'vitoria',01003,'alava',945000000);
INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('LKS','Paseo de la esperanza',3,'Zaragoza',01002,'Zaragoza',948000000);
INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('EGIE','San Martin',3,'Vitoria',01008,'Alava',94500001);


	
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('X1234567X','Bruno','Castro','administracion','La Piedad',33,'vitoria',01120,'Alava',688000000,1);
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('12345678A','Jon','Iturrieta','logistica','La Esperanza',2,'Vitoria',01018,'Alava',688000001,1);
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('12345678B','Javier','Arnaiz','logistica','El Disgusto',3,'Irun',34351,'Irun',688000002,1);

	
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('Ford','Transit', '8897JGV');
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('Ford','Transit', '8898JGV');
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('Ford','Transit', '8899JGV');


insert into usuarios ('bcastrof', 'deh74f5c', 1);
insert into usuarios ('jon.iturrieta', 'deh74f5c', 2);
insert into usuarios ('javier.arnaiz', 'deh74f5c', 3);


