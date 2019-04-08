/*Consultas sobre varia tablas*/

/*Ejercio 11*/
SELECT P.cod_peli,P.titulo
FROM CS_Actua R, CS_Actor A, CS_Pelicula P
WHERE A.nombre = P.director AND
    R.COD_ACT = A.COD_ACT AND
    R.COD_PELI = P.COD_PELI
ORDER BY titulo;

/*Ejercicio 12*/
SELECT C.cod_peli, P.titulo
FROM CS_Clasificacion C, CS_Pelicula P, CS_Genero G
WHERE C.cod_gen =  G.cod_gen AND
    P.cod_peli = C.cod_peli AND
    G.nombre = 'Comedia' 
ORDER BY titulo;

/*Ejercicio 13*/
SELECT P.cod_peli, P.titulo
FROM CS_Pelicula P, CS_Libro L
WHERE P.cod_lib = L.cod_lib AND
    L.anyo < 1950
ORDER BY titulo;

/*Ejercicio 14*/
SELECT DISTINCT P.cod_pais, P.nombre
FROM CS_Pais P, CS_Actor A, CS_Actua T, CS_Pelicula E, CS_Clasificacion C, CS_Genero G
WHERE G.cod_gen = C.cod_Gen AND
    G.nombre = 'Comedia' AND
    C.cod_peli = E.cod_peli AND
    E.cod_peli = T.cod_peli AND
    T.cod_act = A.cod_act AND
    A.cod_pais = P.cod_pais;

/*MÚSICA*/

/*Ejercicio 7*/
SELECT C.nombre, C.sede, G.nombre
FROM BDA.CLUB C, BDA.GRUPO G
WHERE C.cod_gru = G.cod AND G.pais = 'España';