SELECT COUNT(*)
FROM DISCO;

SELECT nombre
FROM GRUPO
WHERE pais <> 'España';

SELECT DISTINCT funcion
FROM PERTENECE;

SELECT nombre, num
FROM CLUB
ORDER BY num;

--VARIAS TABLAS
SELECT C.nombre, C.sede, G.nombre
FROM CLUB C, GRUPO G
WHERE C.cod_gru = G.cod
    AND G.pais = 'España';
    
SELECT A.nombre
FROM ARTISTA A, PERTENECE P, GRUPO G
WHERE A.dni = P.dni AND
    P.cod = G.cod AND
    G.pais = 'España';
    
SELECT DISTINCT D.nombre
FROM DISCO D, ESTA E, CANCION C
WHERE D.cod = E.cod AND
        E.can = C.cod AND
        C.duracion > 5;

SELECT C.titulo
FROM CANCION C, ESTA E, DISCO D
WHERE C.cod = E.can AND
        E.cod = D.cod AND
        C.titulo = D.nombre;
        
SELECT C.nombre, C.dir
FROM COMPANYIA C, DISCO D
WHERE C.cod = D.cod_comp AND
    D.nombre LIKE 'A%';
    
SELECT DISTINCT P.dni
FROM PERTENECE P, PERTENECE P2
WHERE P.dni = P2.dni AND
    P.cod <> P2.cod;
    
SELECT nombre
FROM DISCO
WHERE cod_gru IN (SELECT cod
                    FROM GRUPO
                    WHERE fecha <= ALL (SELECT fecha
                                        FROM GRUPO));
                                        
SELECT nombre
FROM DISCO
WHERE cod_gru IN (SELECT cod
                  FROM GRUPO
                  WHERE cod IN (SELECT cod_gru
                                FROM CLUB
                                WHERE num > 5000));
                                
SELECT nombre, num
FROM CLUB
WHERE num = (SELECT MAX(num)
                FROM CLUB);
                
SELECT titulo, duracion
FROM CANCION
WHERE duracion >= ALL(SELECT duracion
                    FROM CANCION);
    