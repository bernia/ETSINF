SELECT A.cod_act, A.nombre
FROM CS_ACTOR A
WHERE EXTRACT(YEAR FROM A.fecha_nac) < 1950 AND
    A.cod_act IN (SELECT C.cod_act
                    FROM CS_ACTUA C
                    WHERE papel = 'Principal')
ORDER BY A.nombre;

SELECT L.cod_lib, L.titulo, L.autor
FROM CS_LIBRO L
WHERE L.cod_lib IN (SELECT P.cod_lib
                    FROM CS_PELICULA P
                    WHERE P.ANYO BETWEEN 1990 AND 1999)
ORDER BY L.titulo;

SELECT cod_lib, titulo, autor
FROM CS_LIBRO
WHERE NOT cod_lib IN (SELECT cod_lib
                    FROM CS_PELICULA
                    WHERE NOT cod_lib IS NULL);
                    
SELECT DISTINCT nombre
FROM CS_GENERO
WHERE cod_gen IN (SELECT cod_gen
                    FROM CS_CLASIFICACION
                    WHERE cod_peli NOT IN (SELECT cod_peli
                                            FROM CS_ACTUA))
ORDER BY nombre;

SELECT titulo
FROM CS_LIBRO
WHERE cod_lib IN (SELECT cod_lib
                  FROM CS_PELICULA
                  WHERE cod_peli NOT IN (SELECT cod_peli
                                        FROM CS_ACTUA
                                        WHERE cod_act IN (SELECT cod_act
                                                          FROM CS_ACTOR
                                                          WHERE cod_pais IN (SELECT cod_pais
                                                                             FROM CS_PAIS
                                                                             WHERE nombre = 'USA'))))
ORDER BY titulo;

SELECT COUNT(*)
FROM CS_PELICULA P
WHERE cod_peli IN (SELECT cod_peli
                   FROM CS_CLASIFICACION
                   WHERE cod_gen IN (SELECT cod_gen
                                     FROM CS_GENERO
                                     WHERE nombre = 'Comedia'))
    AND 1 = (SELECT COUNT(*)
            FROM CS_ACTUA A
            WHERE A.cod_peli = P.cod_peli
                AND papel = 'Secundario');
                
SELECT MIN(ANYO)
FROM CS_PELICULA
WHERE cod_peli IN (SELECT cod_peli
                   FROM CS_ACTUA
                   WHERE cod_act IN (SELECT cod_act
                                     FROM CS_ACTOR
                                     WHERE nombre = 'Jude Law')
                        AND papel ='Principal');
                        
SELECT cod_act, nombre
FROM CS_ACTOR
WHERE fecha_nac <= ALL (
        SELECT fecha_nac
        FROM CS_ACTOR );
        
SELECT cod_act, nombre, fecha_nac
FROM CS_ACTOR
WHERE EXTRACT(YEAR FROM fecha_nac) = 1940
    AND fecha_nac <= ALL (SELECT fecha_nac
                          FROM CS_ACTOR
                          WHERE EXTRACT(YEAR FROM fecha_nac) = 1940);
                          
SELECT DISTINCT nombre
FROM CS_GENERO
WHERE cod_gen IN (SELECT cod_gen
                  FROM CS_CLASIFICACION
                  WHERE cod_peli IN (SELECT cod_peli
                                     FROM CS_PELICULA
                                     WHERE duracion >= ALL(SELECT duracion FROM CS_PELICULA)));

SELECT cod_lib, titulo
FROM CS_LIBRO
WHERE cod_lib IN (SELECT cod_lib
                  FROM CS_PELICULA
                  WHERE cod_peli IN (SELECT cod_peli
                                     FROM CS_ACTUA
                                     WHERE cod_act IN (SELECT cod_act
                                                       FROM CS_ACTOR
                                                       WHERE cod_pais IN ( SELECT cod_pais
                                                                           FROM CS_PAIS
                                                                           WHERE nombre = 'España'))))
ORDER BY titulo;

SELECT titulo
FROM CS_PELICULA P
WHERE anyo < 1950
    AND 1 < ( SELECT COUNT(*)
              FROM CS_CLASIFICACION C
              WHERE P.cod_peli = C.cod_peli)
ORDER BY titulo;

SELECT COUNT(*)
FROM CS_PELICULA P
WHERE 4 > (SELECT COUNT(*)
           FROM CS_ACTUA A
           WHERE A.cod_peli = P.cod_peli);
           
SELECT DISTINCT director
FROM CS_PELICULA P
WHERE 250 < ( SELECT SUM(duracion)
              FROM CS_PELICULA P2
              WHERE P.director = P2.director);
              
SELECT DISTINCT EXTRACT(YEAR FROM fecha_nac)
FROM CS_ACTOR A1
WHERE 3 < (SELECT COUNT(*)
            FROM CS_ACTOR A2
            WHERE EXTRACT(YEAR FROM A1.fecha_nac) = EXTRACT(YEAR FROM A2.fecha_nac));
            
SELECT cod_act, nombre
FROM CS_ACTOR A
WHERE fecha_nac = (SELECT MAX(fecha_nac)
                   FROM CS_ACTOR A2
                   WHERE A2.cod_act IN (SELECT cod_act
                                        FROM CS_ACTUA
                                        WHERE cod_peli IN (SELECT cod_peli
                                                            FROM CS_CLASIFICACION
                                                            WHERE cod_gen = 'DD8')));