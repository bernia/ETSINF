SELECT COUNT(DISTINCT A.autor_id)
FROM AUTOR A, ESCRIBIR E, OBRA O
WHERE A.autor_id = E.autor_id AND
        E.cod_ob = O.cod_ob AND
        O.titulo LIKE '%ciudad%';
        
SELECT O.titulo
FROM OBRA O, ESCRIBIR E, AUTOR A
WHERE O.cod_ob = E.cod_ob AND
        E.autor_id = A.autor_id AND
        A.nombre = 'Camús, Albert';
        
SELECT A.nombre
FROM AUTOR A, ESCRIBIR E, OBRA O
WHERE A.autor_id = E.autor_id AND
        E.cod_ob = O.cod_ob AND
        O.titulo = 'La tata';
        
SELECT DISTINCT AM.nombre
FROM AMIGO AM, LEER L, ESCRIBIR E, AUTOR A
WHERE AM.num = L.num AND
        L.cod_ob = E.cod_ob AND
        E.autor_id = A.autor_id AND
        A.autor_id = 'RUKI';
        
SELECT DISTINCT L.id_lib, L.titulo
FROM LIBRO L, ESTA_EN E1, ESTA_EN E2
WHERE NOT L.titulo IS NULL AND
        L.id_lib = E1.id_lib AND
        L.id_lib = E2.id_lib AND
        E1.cod_ob <> E2.cod_ob;
        
--SUBCONSULTAS
SELECT titulo, A.nombre
FROM AUTOR A , OBRA 
WHERE A.nacionalidad = 'Francesa' AND
        cod_ob IN (SELECT cod_ob
                    FROM ESCRIBIR
                    WHERE A.autor_id = autor_id
                    AND cod_ob NOT IN (SELECT cod_ob
                                        FROM ESCRIBIR
                                        WHERE autor_id <> A.autor_id));
                                        
SELECT nombre
FROM AUTOR
WHERE autor_id NOT IN (SELECT autor_id
                        FROM ESCRIBIR);
                        
SELECT nombre
FROM AUTOR A
WHERE nacionalidad = 'Española' AND
        2 <= (SELECT COUNT(*)
                FROM ESCRIBIR
                WHERE autor_id = A.autor_id);
                
SELECT nombre
FROM AUTOR A
WHERE nacionalidad = 'Española' AND
    A.autor_id IN (SELECT autor_id
                    FROM ESCRIBIR
                    WHERE cod_ob IN (SELECT cod_ob
                                     FROM OBRA A
                                     WHERE 2 <= (SELECT COUNT(*)
                                                 FROM ESTA_EN
                                                 WHERE cod_ob = A.cod_ob)));
                                                 
SELECT cod_ob, titulo
FROM OBRA O
WHERE cod_ob IN (SELECT cod_ob
                FROM ESCRIBIR
                WHERE 1 < (SELECT COUNT(*)
                            FROM ESCRIBIR
                            WHERE cod_ob = O.cod_ob));