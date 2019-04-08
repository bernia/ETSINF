module Exercici10 where
map' :: (a -> b) -> [a] -> [b]
map' f x = [f z | z <- x]

filter' :: (a -> Bool) -> [a] -> [a]
filter' f x = [y | y <- x , f y]


