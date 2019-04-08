%%
%% declaraciones
%%
isfather('juan', 'maria'). % juan es padre de maria
isfather('pablo', 'juan'). % pablo es padre de juan
isfather('pablo', 'marcela').
isfather('carlos', 'debora').
isfather('luisa', 'debora').
 
% A es hijo de B si B es padre de A
isson(A,B) :- isfather(B,A).

% A es abuelo de B si A es padre de C y C es padre B
isgrandfather(A,B) :- 
   isfather(A,C), 
   isfather(C,B).

% A y B son hermanos si el padre de A es tambi?n el padre de B y si A y B no son lo mismo
isbrother(A,B) :- 
   isfather(C,A), 
   isfather(C,B), 
   A \== B.        
% A es nieto de B si B es abuelo de A
isgrandson(A,B) :- isgrandfather(B,A).
 
% A y B son familiares si A es padre de B o A es hijo de B o A es hermano de B
isrelative(A,B) :- 
   isfather(A,B).
isrelative(A,B) :-
   isson(A,B). 
isrelative(A,B) :- 
   isbrother(A,B).
isrelative(A,B) :- 
   isgrandfather(A,B).
isrelative(A,B) :-
	isgrandson(A,B).