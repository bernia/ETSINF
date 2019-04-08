module Arbres where
data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show

symmetric :: Tree a -> Tree a
symmetric (Leaf x) = Leaf x
symmetric (Branch d e) = Branch (symmetric e) (symmetric d)

listToTree :: [a] -> Tree a
listToTree (x:[]) = Leaf x
listToTree (x:xs) = Branch (Leaf x) (listToTree xs)

treeToList :: Tree a -> [a]
treeToList (Leaf a) = [a]
treeToList (Branch a b) = treeToList a ++ treeToList b


