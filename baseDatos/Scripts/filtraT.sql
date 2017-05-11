--para el login para que con el id busque la categoria

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

--para filtrar en la tabla por dni un solo trabajador
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

--recuperar la id del trabajador para el login
create or replace procedure idTrabajador
(doc in trabajadores.dni%type, idi out trabajadores.id%type)
as
begin
select id into idi
from trabajadores
where dni = doc;
end idTrabajador;

--listar trabajadores en tabla
create or replace procedure listartrabajadores 
(c out SYS_REFCURSOR)
as
begin
open c for
select * from trabajadores;
if (C%rowcount=0)then
raise NO_DATA_FOUND;
end if;
exception 
WHEN NO_DATA_FOUND THEN
   RAISE_APPLICATION_ERROR(-20002,'NO SE ENCUENTRAN REGISTROS.');
end listartrabajadores;


--para filtrar en tabla un solo centro
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

--para recuperar un parte
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

select fecha, kminicial, kmfinal, nvl(gastospeaje,0), nvl(gastosdietas,0), nvl(gastoscombustible,0), nvl(otrosgastos,0), nvl(incidencias,'No'),estado, validado, nvl(horasextras,0), trabajadores_id,nvl(notasadministrativas,'No')
into fe,kmi,kmf,gp,gd,gc,og,inc,es,va,hor,idto,nota
from partes
where TRABAJADORES_ID=idt and estado='ABIERTO';

end recuperarParte;