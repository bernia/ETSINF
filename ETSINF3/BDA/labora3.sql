--EXERCICI 11 (AMB SUBCONSULTES)
SELECT cod_peli, titulo
FROM CS_PELICULA P
WHERE P.DIRECTOR IN (
    SELECT A.nombre
    FROM CS_ACTOR A
    WHERE A.cod_act IN (
        SELECT B.cod_act
        FROM CS_ACTUA B
        WHERE B.cod_peli = P.cod_peli))
ORDER BY P.titulo;
        
--EXERCICI 12 (AMB SUBCONSULTES)
SELECT cod_peli, titulo
FROM CS_PELICULA P
WHERE P.cod_peli IN (
    SELECT C.cod_peli
    FROM CS_CLASIFICACION C
    WHERE C.cod_gen IN (
        SELECT G.cod_gen
        FROM CS_GENERO G
        WHERE G.nombre = 'Comedia'))
ORDER BY P.titulo;

--EXERCICI 13 (AMB SUBCONSULTES)
SELECT cod_peli, titulo
FROM CS_PELICULA P
WHERE P.cod_lib IN (
    SELECT cod_lib
    FROM CS_LIBRO
    WHERE anyo < 1950)
ORDER BY P.titulo;
    
--EXERCICI 14 (AMB SUBCONSULTES)
SELECT DISTINCT cod_pais, nombre
FROM CS_PAIS P
WHERE P.cod_pais IN (
    SELECT A.cod_pais 
    FROM CS_ACTOR A
    WHERE A.cod_act IN (
        SELECT T.cod_act
        FROM CS_ACTUA T
        WHERE T.cod_peli IN (
            SELECT L.cod_peli
            FROM CS_PELICULA L
            WHERE L.cod_peli IN (
                SELECT C.cod_peli
                FROM CS_CLASIFICACION C
                WHERE C.cod_gen IN (
                    SELECT G.cod_gen
                    FROM CS_GENERO G
                    WHERE G.nombre = 'Comedia')))))
ORDER BY P.nombre;

--EXERCICI 16
SELECT cod_act, nombre
FROM CS_ACTOR P
WHERE EXTRACT(YEAR FROM P.fecha_nac) < 1950
    AND P.cod_act IN (
        SELECT A.cod_act
        FROM CS_ACTUA A
        WHERE A.papel = 'Principal')
ORDER BY P.nombre;

--EXERCICI 17
SELECT cod_lib, titulo, autor
FROM CS_LIBRO L
WHERE L.cod_lib IN (
    SELECT P.cod_lib
    FROM CS_PELICULA P
    WHERE anyo BETWEEN 1990 AND 1999)
ORDER BY L.titulo;

