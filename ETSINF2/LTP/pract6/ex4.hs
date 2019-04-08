module Ex4 where
import Stack
toList :: Stack a -> [a]
toList a
	| isEmpty a = []
	| otherwise = (top a) : (toList (pop a))

fromList :: [a] -> Stack a
fromList [] = empty
fromList (x:xs) = push x (fromList xs)
