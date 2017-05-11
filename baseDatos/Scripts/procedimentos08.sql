create or replace procedure centrosFi
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

end centrosFi;

create or replace procedure centrosFn
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

end centrosFn;

create or replace procedure centrosList
(c out SYS_REFCURSOR)
as
begin
open c for
select * from centros
end centrosList;


create or replace procedure recuperarParte
(idt in TRABAJADORES.ID%type, 
fe out PARTES.FECHA%type,
kmi out PARTES.KMINICIAL%type,
kmf out PARTES.KMFINAL%type,
gp out PARTES.GASTOSPEAJE%type,
gd out PARTES.GASTOSDIETAS%type,
gc out PARTES.GASTOSCOMBUSTIBLE%type,
og out PARTES.OTROSGASTOS%type,
inc out PARTES.INCIDENCIAS%type,
es out PARTES.ESTADO%type,
va out PARTES.VALIDADO%type,
hor out PARTES.HORASEXTRAS%type,
idto  out PARTES.TRABAJADORES_ID%type,
nota out PARTES.NOTASADMINISTRATIVAS%type
)
as
begin

select fecha, kminicial, kmfinal, nvl(gastospeaje,0), nvl(gastosdietas,0), nvl(gastoscombustible,0), nvl(otrosgastos,0), nvl(incidencias,''),estado, validado, nvl(horasextras,0), trabajadores_id,nvl(notasadministrativas,'No')
into fe,kmi,kmf,gp,gd,gc,og,inc,es,va,hor,idto,nota
from partes
where TRABAJADORES_ID=idt and estado='ABIERTO';
end recuperarParte;


create or replace procedure notificacion
(idc in USUARIOS.TRABAJADORES_ID%type, ida out avisos.id%type, av out AVISOS.AVISO%type, fe out AVISOS.FECHA_ID%type)
as
to_many_rows EXCEPTION;
begin
select id, aviso, FECHA_ID into ida, av, fe
from avisos
where trabajadores_id=idc and leido='NO';

exception 
when NO_DATA_FOUND then
RAISE_APPLICATION_ERROR(-20001,'No se han encontrado registros');
when to_many_rows then
RAISE_APPLICATION_ERROR(-20002,'hay más de un registro por favor hable con Administración');
end notificacion;





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



create or replace procedure listartrabajadores 
(c out SYS_REFCURSOR)
as
begin
open c for
select * from trabajadores;
end listartrabajadores;


create or replace PROCEDURE ifTrabajadorid
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

end ifTrabajadorid;



create or replace PROCEDURE ifTrabajador 
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

end ifTrabajador;


create or replace procedure idTrabajador
(doc in trabajadores.dni%type, idi out trabajadores.id%type)
as
begin
select id into idi
from trabajadores
where dni = doc;
end idTrabajador;



create or replace procedure incrementCenter
(idc out centros.id%type)
as
begin
select SQCENTROS.NEXTVAL into idc from dual;
end incrementCenter;


create or replace procedure incrementTrabajadores
(idc out trabajadores.id%type )
as
begin 
select SQTRABAJADORES.NEXTVAL into idc from dual;
end incrementTrabajadores;


create or replace procedure logisticaViajes
(idt in VIAJES.TRABAJADORES_ID%type, fecha in VIAJES.FECHA_ID%type, c out SYS_REFCURSOR)
as 
begin 
OPEN C FOR 
SELECT albaran, horaInicial, horaFinal
from viajes where trabajadores_id=idt and fecha_id=fecha;
end logisticaViajes;


