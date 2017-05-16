Para poder llevantar la estructura de la base datos, primero tenemos que ejecutar el script que pone estrcutura de datos.

el segundo script que pone procedimentos, contiene todos los procedimentos que necesita la base datos para trabajar correctamente con 
la aplicacion, aconsejo que se ejecute los paquetes por separado es decir:

Primero copiamos la cabeza del paquete la copiamos en el developer y ejecutamos, borramos copiamos la parte que pone package body
y ejecutamos y asi con todos los paquetes y procedimentos. Una cabecera empieza siempre con create or replace package (nombre) y termina con end (nombre); y el cuerpo empieza con create or replace package body (nombre) y termina con end (nombre);.

los procedimentos empienzan siempre por create or replace procedure (nombre) y termina end (nombre);