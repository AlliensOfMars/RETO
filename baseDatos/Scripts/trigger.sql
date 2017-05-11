create or replace trigger horas
after insert or update
on viajes
FOR EACH ROW
declare
exceso_horas exception;
menos_horas exception;
HORAS NUMBER(2);
MINUTOS NUMBER(2);
TOTALMINUTOS NUMBER (4,2);
TOTAL NUMBER (4,2);
idt PARTES.TRABAJADORES_ID%type;
est partes.estado%type;
BEGIN
SELECT TRABAJADORES_ID , extract(hour from (to_timestamp((select max(horafinal) from viajes where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO')), 'HH24:MI') - to_timestamp((select min(horainicial)from viajes where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO')),  'HH24:MI'))) ,
   extract(minute from (to_timestamp((select max(horafinal) from VIAJES where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO')), 'HH24:MI') - to_timestamp((select min(HORAINICIAL)from viajes where TRABAJADORES_ID = (select trabajadores_id from partes where estado='ABIERTO') ),  'HH24:MI'))) INTO  idt, HORAS, MINUTOS
FROM VIAJES where TRABAJADORES_ID =(select trabajadores_id from partes where estado='ABIERTO') group by TRABAJADORES_ID ;
TOTALMINUTOS:=MINUTOS/100;
TOTAL:=HORAS+TOTALMINUTOS;
IF TOTAL < 8 THEN
RAISE menos_horas;
else 
RAISE exceso_horas;
end if;
EXCEPTION
when menos_horas then
 RAISE_APPLICATION_ERROR(-20001,'pocas horas');
when exceso_horas then
 RAISE_APPLICATION_ERROR(-20001,'muchas horas');
END horas;

CREATE OR REPLACE TRIGGER VALIDACION 
AFTER INSERT OR UPDATE
ON USER_EJERCICIO
FOR EACH ROW
DECLARE
ERROR_NO_CUMPLE_REQUISITOS EXCEPTION;
CURSOR C1 IS SELECT ORA_HASH(PASSWORD) AS PASSWORD FROM LIST_OF_PLAIN_PASSWORD;
BEGIN
  FOR REG
  IN C1
  LOOP 
    IF (:NEW.PASSWORD=REG.PASSWORD) THEN
      RAISE ERROR_NO_CUMPLE_REQUISITOS;
    END IF;
  END LOOP; 
EXCEPTION
  WHEN ERROR_NO_CUMPLE_REQUISITOS THEN
    RAISE ERROR_NO_CUMPLE_REQUISITOS;
END VALIDACION;