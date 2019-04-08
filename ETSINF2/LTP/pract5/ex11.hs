module Exercici11 where
type Person = String
type Book = String
type Database = [(Person,Book)]

exampleBase :: Database
exampleBase = [("Alicia", "El nombre de la rosa"), 
               ("Juan", "La hija del canibal"), 
               ("Pepe", "Odesa"), 
               ("Alicia", "La ciudad de las bestias")]

obtain :: Database -> Person -> [Book]
obtain dBase thisPerson = [b | (p,b) <- dBase, p == thisPerson]

borrow :: Database -> Book -> Person -> Database
borrow dBase b p = (p,b):dBase

return' :: Database -> (Person,Book) -> Database
return' dBase (p,b) = [(persona,llibre) | 
					 (persona,llibre) <- dBase,
					 (persona,llibre) /= (p,b)]

borrow' :: Database -> Book -> Person -> Database
borrow' bd llibre p 
	|obtain bd p == [] = (p,llibre):bd
	|otherwise = bd


return2 :: Database -> (Person,Book) -> Database
return2 [] _ = []
return2 ((p',llibre'):xs) (p,llibre)
			|(p'== p) && (llibre'== llibre) = xs
			|otherwise = (p',llibre') : return2 xs (p,llibre)

