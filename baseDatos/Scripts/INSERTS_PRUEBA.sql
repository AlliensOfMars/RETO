--inserts 12C
  
INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('prueba1','prueba1',1,'prueba1',1,'prueba1',1);
INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('prueba2','prueba2',2,'prueba2',2,'prueba2',2);
INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('prueba3','prueba3',3,'prueba3',3,'prueba3',3);
INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('prueba4','prueba4',4,'prueba4',4,'prueba1',4);
INSERT INTO CENTROS (nombre, calle, numero, ciudad, codigoPostal, provincia, telefono) VALUES ('prueba5','prueba5',5,'prueba5',5,'prueba5',5);

	
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('00000000a','trabajador1','trabajador1','administracion','prueba1',1,'prueba1',1,'prueba1',1,1);
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('00000000b','trabajador2','trabajador2','logistica','prueba2',2,'prueba2',2,'prueba2',2,1);
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('00000000c','trabajador3','trabajador3','logistica','prueba3',3,'prueba3',3,'prueba3',3,1);
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('00000000d','trabajador4','trabajador4','logistica','prueba4',4,'prueba4',4,'prueba4',4,1);
INSERT INTO TRABAJADORES (dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
('00000000e','trabajador5','trabajador5','logistica','prueba5',5,'prueba5',5,'prueba5',5,1);	
	
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('prueba1','prueba1',1);
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('prueba2','prueba2',2);
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('prueba3','prueba3',3);
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('prueba4','prueba4',4);
insert into vehiculos (MARCA,MODELO,MATRICULA) values ('prueba5','prueba5',5);
	
--inserts 11g	
INSERT INTO CENTROS VALUES (SQCENTROS.NEXTVAL,'prueba1','prueba1',1,'prueba1',1,'prueba1',1);
INSERT INTO CENTROS VALUES (SQCENTROS.NEXTVAL,'prueba2','prueba2',2,'prueba2',2,'prueba2',2);
INSERT INTO CENTROS VALUES (SQCENTROS.NEXTVAL,'prueba3','prueba3',3,'prueba3',3,'prueba3',3);
INSERT INTO CENTROS VALUES (SQCENTROS.NEXTVAL,'prueba4','prueba4',4,'prueba4',4,'prueba1',4);
INSERT INTO CENTROS VALUES (SQCENTROS.NEXTVAL,'prueba5','prueba5',5,'prueba5',5,'prueba5',5);

	
INSERT INTO TRABAJADORES (ID,dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
(SQTRABAJADORES.NEXTVAL,'00000000a','trabajador1','trabajador1','administracion','prueba1',1,'prueba1',1,'prueba1',1,1);
INSERT INTO TRABAJADORES (ID,dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
(SQTRABAJADORES.NEXTVAL,'00000000b','trabajador2','trabajador2','logistica','prueba2',2,'prueba2',2,'prueba2',2,1);
INSERT INTO TRABAJADORES (ID,dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
(SQTRABAJADORES.NEXTVAL,'00000000c','trabajador3','trabajador3','logistica','prueba3',3,'prueba3',3,'prueba3',3,1);
INSERT INTO TRABAJADORES (ID,dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
(SQTRABAJADORES.NEXTVAL,'00000000d','trabajador4','trabajador4','logistica','prueba4',4,'prueba4',4,'prueba4',4,1);
INSERT INTO TRABAJADORES (ID,dni,nombre,primerApellido,categoria,calle,numero,ciudad,codigoPostal,provincia,movilEmpresa,CENTROS_ID) values
(SQTRABAJADORES.NEXTVAL,'00000000e','trabajador5','trabajador5','logistica','prueba5',5,'prueba5',5,'prueba5',5,1);
			
insert into vehiculos values (SQVEHICULOS.NEXTVAL,'prueba1','prueba1',1);
insert into vehiculos values (SQVEHICULOS.NEXTVAL,'prueba2','prueba2',2);
insert into vehiculos values (SQVEHICULOS.NEXTVAL,'prueba3','prueba3',3);
insert into vehiculos values (SQVEHICULOS.NEXTVAL,'prueba4','prueba4',4);
insert into vehiculos values (SQVEHICULOS.NEXTVAL,'prueba5','prueba5',5);
	
--procidimentos para auto incrementado en 11g (una gran chapuza)

create or replace procedure incrementCenter
(id out centros.id%type)
as
begin
select sqcentros.nextval into id
from dual;
end incrementCenter;


CREATE OR REPLACE PROCEDURE incrementAvisos
(id out avisos.id%type)
as
begin
select SQAVISOS.NEXTVAL INTO ID
FROM DUAL;
ENd incrementAvisos;


create or replace procedure incrementTrabajadores
(id out trabajadore.id%type)
as
begin
select SQTRABAJADORES.NEXTVAL INTO id 
from dual;
end incrementTrabajadores;

create or replace procedure incrementVehiculos
(id out vehiculos.id%type)
as
begin
select SQVEHICULOS.nextval into id
from dual;
end incrementVehiculos;

create or replace procedure incrementViajes
(id out viajes.id%type)
as
begin
select SQVIAJES.nextval into id
from dual;
end incrementViajes;

insert into partes values ('05/05/2017', 0,0,0,0,0,0,'ninguna','ABIERTO','NO',0,1);
INSERT INTO VIAJES VALUES (SQVIAJES.NEXTVAL, '10:00','10:30',1,'05/05/2017');