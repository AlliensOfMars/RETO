--PAQUETE DE CENTROS

create or replace package pcentros
as
procedure centrosList (c out SYS_REFCURSOR);
procedure centrosFi
(idu in CENTROS.ID%type,
ido out CENTROS.ID%type,
nom out CENTROS.NOMBRE%type,
cal out CENTROS.CALLE%type,
nu out CENTROS.NUMERO%type,
ci out CENTROS.CIUDAD%type,
co out CENTROS.CODIGOPOSTAL%type,
pro out CENTROS.PROVINCIA%type,
tel out CENTROS.TELEFONO%type
);
procedure centrosFn
(nomu in CENTROS.NOMBRE%type,
ido out CENTROS.ID%type,
nom out CENTROS.NOMBRE%type,
cal out CENTROS.CALLE%type,
nu out CENTROS.NUMERO%type,
ci out CENTROS.CIUDAD%type,
co out CENTROS.CODIGOPOSTAL%type,
pro out CENTROS.PROVINCIA%type,
tel out CENTROS.TELEFONO%type
);
end pcentros;

create or replace package body pcentros
as
procedure centrosList
(c out SYS_REFCURSOR)
as
begin
open c for
select * from centros;
end centrosList;

procedure centrosFi
(idu in CENTROS.ID%type,
ido out CENTROS.ID%type,
nom out CENTROS.NOMBRE%type,
cal out CENTROS.CALLE%type,
nu out CENTROS.NUMERO%type,
ci out CENTROS.CIUDAD%type,
co out CENTROS.CODIGOPOSTAL%type,
pro out CENTROS.PROVINCIA%type,
tel out CENTROS.TELEFONO%type
)
as
begin

select id, nombre, calle, numero, ciudad, codigoPostal, provincia, telefono into ido, nom, cal, nu, ci, co, pro, tel
from centros 
where id = idu;

exception 
when NO_DATA_FOUND then 
RAISE_APPLICATION_ERROR(-20001,'No se han encontrado registros de Centros');
WHEN TOO_MANY_ROWS THEN 
RAISE_APPLICATION_ERROR(-20002,'Se ha encontrado más de un registro por favor hable con el Administrador'); 
end centrosFi;

procedure centrosFn
(nomu in CENTROS.NOMBRE%type,
ido out CENTROS.ID%type,
nom out CENTROS.NOMBRE%type,
cal out CENTROS.CALLE%type,
nu out CENTROS.NUMERO%type,
ci out CENTROS.CIUDAD%type,
co out CENTROS.CODIGOPOSTAL%type,
pro out CENTROS.PROVINCIA%type,
tel out CENTROS.TELEFONO%type
)
as
begin

select id, nombre, calle, numero, ciudad, codigoPostal, provincia, telefono into ido, nom, cal, nu, ci, co, pro, tel
from centros 
where nombre = nomu;
exception 
when NO_DATA_FOUND then 
RAISE_APPLICATION_ERROR(-20001,'No se han encontrado registros de Centros');
WHEN TOO_MANY_ROWS THEN 
RAISE_APPLICATION_ERROR(-20002,'Se ha encontrado más de un registro por favor hable con el Administrador'); 
end centrosFn;
end pcentros;

--PAQUETE TRABAJADORES
create or replace package ptrabajadores
as
procedure listartrabajadores 
(c out SYS_REFCURSOR);

PROCEDURE ifTrabajadorid
(idi in TRABAJADORES.ID%type,
ido out TRABAJADORES.ID%type,
do out TRABAJADORES.DNI%type,
nou out TRABAJADORES.NOMBRE%type,
pa out TRABAJADORES.PRIMERAPELLIDO%type,
sa out TRABAJADORES.SEGUNDOAPELLIDO%type,
ca out TRABAJADORES.CATEGORIA%type,
cal out TRABAJADORES.CALLE%type,
nu out TRABAJADORES.NUMERO%type,
pi out TRABAJADORES.PISO%type,
ma out TRABAJADORES.MANO%type,
ci out TRABAJADORES.CIUDAD%type,
co out TRABAJADORES.CODIGOPOSTAL%type,
pro out TRABAJADORES.PROVINCIA%type,
mve out TRABAJADORES.MOVILEMPRESA%TYPE,
mvp out TRABAJADORES.MOVILPERSONAL%type,
sal out TRABAJADORES.SALARIO%type,
fe out TRABAJADORES.FECHANACIMIENTO%type,
cei out TRABAJADORES.CENTROS_ID%type
);

PROCEDURE ifTrabajador 
(doc in TRABAJADORES.DNI%type,
ido out TRABAJADORES.ID%type,
do out TRABAJADORES.DNI%type,
nou out TRABAJADORES.NOMBRE%type,
pa out TRABAJADORES.PRIMERAPELLIDO%type,
sa out TRABAJADORES.SEGUNDOAPELLIDO%type,
ca out TRABAJADORES.CATEGORIA%type,
cal out TRABAJADORES.CALLE%type,
nu out TRABAJADORES.NUMERO%type,
pi out TRABAJADORES.PISO%type,
ma out TRABAJADORES.MANO%type,
ci out TRABAJADORES.CIUDAD%type,
co out TRABAJADORES.CODIGOPOSTAL%type,
pro out TRABAJADORES.PROVINCIA%type,
mve out TRABAJADORES.MOVILEMPRESA%TYPE,
mvp out TRABAJADORES.MOVILPERSONAL%type,
sal out TRABAJADORES.SALARIO%type,
fe out TRABAJADORES.FECHANACIMIENTO%type,
cei out TRABAJADORES.CENTROS_ID%type
);
procedure idTrabajador
(doc in trabajadores.dni%type, idi out trabajadores.id%type);
end ptrabajadores;

create or replace package body ptrabajadores
as
procedure listartrabajadores 
(c out SYS_REFCURSOR)
as
begin
open c for
select * from trabajadores;
end listartrabajadores;

PROCEDURE ifTrabajadorid
(idi in TRABAJADORES.ID%type,
ido out TRABAJADORES.ID%type,
do out TRABAJADORES.DNI%type,
nou out TRABAJADORES.NOMBRE%type,
pa out TRABAJADORES.PRIMERAPELLIDO%type,
sa out TRABAJADORES.SEGUNDOAPELLIDO%type,
ca out TRABAJADORES.CATEGORIA%type,
cal out TRABAJADORES.CALLE%type,
nu out TRABAJADORES.NUMERO%type,
pi out TRABAJADORES.PISO%type,
ma out TRABAJADORES.MANO%type,
ci out TRABAJADORES.CIUDAD%type,
co out TRABAJADORES.CODIGOPOSTAL%type,
pro out TRABAJADORES.PROVINCIA%type,
mve out TRABAJADORES.MOVILEMPRESA%TYPE,
mvp out TRABAJADORES.MOVILPERSONAL%type,
sal out TRABAJADORES.SALARIO%type,
fe out TRABAJADORES.FECHANACIMIENTO%type,
cei out TRABAJADORES.CENTROS_ID%type
)
as
begin

select id, dni, nombre, PRIMERAPELLIDO, SEGUNDOAPELLIDO, CATEGORIA,
calle, numero, piso, mano, ciudad, CODIGOPOSTAL, PROVINCIA, MOVILEMPRESA,
MOVILPERSONAL, SALARIO, FECHANACIMIENTO, CENTROS_ID 
into ido, do ,nou, pa, sa, ca, cal, nu, pi, ma, ci, co, pro, mve, mvp, sal, fe, cei 
from trabajadores
where ID=idi;
exception 
when NO_DATA_FOUND then 
RAISE_APPLICATION_ERROR(-20001,'No se han encontrado registros de Trabajadores');
WHEN TOO_MANY_ROWS THEN 
RAISE_APPLICATION_ERROR(-20002,'Se ha encontrado más de un registro por favor hable con el Administrador'); 

end ifTrabajadorid;

PROCEDURE ifTrabajador 
(doc in TRABAJADORES.DNI%type,
ido out TRABAJADORES.ID%type,
do out TRABAJADORES.DNI%type,
nou out TRABAJADORES.NOMBRE%type,
pa out TRABAJADORES.PRIMERAPELLIDO%type,
sa out TRABAJADORES.SEGUNDOAPELLIDO%type,
ca out TRABAJADORES.CATEGORIA%type,
cal out TRABAJADORES.CALLE%type,
nu out TRABAJADORES.NUMERO%type,
pi out TRABAJADORES.PISO%type,
ma out TRABAJADORES.MANO%type,
ci out TRABAJADORES.CIUDAD%type,
co out TRABAJADORES.CODIGOPOSTAL%type,
pro out TRABAJADORES.PROVINCIA%type,
mve out TRABAJADORES.MOVILEMPRESA%TYPE,
mvp out TRABAJADORES.MOVILPERSONAL%type,
sal out TRABAJADORES.SALARIO%type,
fe out TRABAJADORES.FECHANACIMIENTO%type,
cei out TRABAJADORES.CENTROS_ID%type
)
as
begin

select id, dni, nombre, PRIMERAPELLIDO, SEGUNDOAPELLIDO, CATEGORIA,
calle, numero, piso, mano, ciudad, CODIGOPOSTAL, PROVINCIA, MOVILEMPRESA,
MOVILPERSONAL, SALARIO, FECHANACIMIENTO, CENTROS_ID 
into ido, do ,nou, pa, sa, ca, cal, nu, pi, ma, ci, co, pro, mve, mvp, sal, fe, cei 
from trabajadores
where DNI=doc;
exception 
when NO_DATA_FOUND then 
RAISE_APPLICATION_ERROR(-20001,'No se han encontrado registros de Trabajadores');
WHEN TOO_MANY_ROWS THEN 
RAISE_APPLICATION_ERROR(-20002,'Se ha encontrado más de un registro por favor hable con el Administrador'); 
end ifTrabajador;

procedure idTrabajador
(doc in trabajadores.dni%type, idi out trabajadores.id%type)
as
begin
select id into idi
from trabajadores
where dni = doc;

exception 
when NO_DATA_FOUND then 
RAISE_APPLICATION_ERROR(-20001,'No se han encontrado registros de Trabajadores');
WHEN TOO_MANY_ROWS THEN 
RAISE_APPLICATION_ERROR(-20002,'Se ha encontrado más de un registro por favor hable con el Administrador'); 
end idTrabajador;
end ptrabajadores;

--procedimento de viajes
create or replace procedure logisticaViajes
(idt in VIAJES.TRABAJADORES_ID%type, fecha in VIAJES.FECHA_ID%type, c out SYS_REFCURSOR)
as 
begin 
OPEN C FOR 
SELECT albaran, horaInicial, horaFinal
from viajes where trabajadores_id=idt and fecha_id=fecha;
end logisticaViajes;

--paquete de partesAdministracion 
create or replace package ppartes
as
procedure partesList (c out SYS_REFCURSOR);
procedure partesTFAI (idt in partes.trabajadores_id%type, fechain in partes.fecha%type, fechafi in partes.fecha%type, c out SYS_REFCURSOR);
procedure partesTFAF (fechain in partes.fecha%type, fechafi in partes.fecha%type, c out SYS_REFCURSOR);
end ppartes;

create or replace package body ppartes
as
procedure partesList (c out SYS_REFCURSOR)
as
begin
open c for
select * from partes;
end partesList;

procedure partesTFAI (idt in partes.trabajadores_id%type, fechain in partes.fecha%type, fechafi in partes.fecha%type, c out SYS_REFCURSOR)
as
begin

open c for
select * from partes
where fecha BETWEEN (fechain) and  (fechafi) and trabajadores_id=idt;
end partesTFAI;

procedure partesTFAF (fechain in partes.fecha%type, fechafi in partes.fecha%type, c out SYS_REFCURSOR)
as
begin
open c for
select * from partes
where fecha BETWEEN (fechain) and  (fechafi);
end partesTFAF;
end ppartes;

--procedimento de login
create or replace PROCEDURE LOGIN
(USER IN USUARIOS.USUARIO%TYPE, PASS IN USUARIOS.PASSWORD%TYPE, idu out usuarios.usuario%type, idt out usuarios.TRABAJADORES_ID%type)
AS
NO_DATA_FOUND EXCEPTION;
BEGIN
SELECT usuario, TRABAJADORES_ID into idu, idt
FROM usuarios
WHERE usuario=user and PASSWORD=pass;
EXCEPTION 
WHEN NO_DATA_FOUND THEN
   RAISE_APPLICATION_ERROR(-20002,'NO SE ENCUENTRAN REGISTROS.'); 
END LOGIN;

--paquete de vehiculos
create or replace package pvehiculos
as
procedure listarVehiculos (c out SYS_REFCURSOR);
procedure filtrarVehiculo (mat in vehiculos.matricula%type,
idv out vehiculos.id%type,
marc out vehiculos.marca%type,
model out vehiculos.modelo%type,
matt out vehiculos.matricula%type
);
end pvehiculos;

create or replace package body pvehiculos
as
procedure listarVehiculos (c out SYS_REFCURSOR)
as
begin
open c for 
select * from vehiculos;
end listarVehiculos;

procedure filtrarVehiculo (mat in vehiculos.matricula%type,
idv out vehiculos.id%type,
marc out vehiculos.marca%type,
model out vehiculos.modelo%type,
matt out vehiculos.matricula%type
)
as
begin
select id, marca, modelo, matricula into idv, marc, model, matt
from vehiculos
where matricula = mat;
exception 
when NO_DATA_FOUND then 
RAISE_APPLICATION_ERROR(-20001,'No se han encontrado registros de Vehiculos');
WHEN TOO_MANY_ROWS THEN 
RAISE_APPLICATION_ERROR(-20002,'Se ha encontrado más de un registro por favor hable con el Administrador'); 
end filtrarVehiculo;
end pvehiculos;



--trigger
--trigger
create or replace trigger horas
AFTER insert or update
on viajes
declare
exceso_horas exception;
menos_horas exception;
HORAS NUMBER(2);
MINUTOS NUMBER(2);
TOTALMINUTOS NUMBER (4,2);
TOTAL NUMBER (4,2);
IDT NUMBER(7);
TOTALH NUMBER(4,2);
BEGIN
SELECT TRABAJADORES_ID , extract(hour from (to_timestamp((select max(horafinal) from viajes where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO')), 'HH24:MI') - to_timestamp((select min(horainicial)from viajes where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO')),  'HH24:MI'))) ,
   extract(minute from (to_timestamp((select max(horafinal) from VIAJES where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO')), 'HH24:MI') - to_timestamp((select min(HORAINICIAL)from viajes where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO') ),  'HH24:MI'))) INTO  idt, HORAS, MINUTOS
FROM VIAJES where TRABAJADORES_ID =(select trabajadores_id from partes where estado='ABIERTO') group by TRABAJADORES_ID ;
TOTALMINUTOS:=MINUTOS/100;
TOTAL:=HORAS+TOTALMINUTOS;
SELECT TRABAJADORES_ID INTO IDT
FROM VIAJES 
WHERE TRABAJADORES_ID=(select trabajadores_id from partes where estado='ABIERTO');
IF TOTAL>8 THEN
TOTALH := TOTAL-8;
UPDATE PARTES SET HORASEXTRAS = TOTALH WHERE TRABAJADORES_ID = IDT;
end if;
END horas;