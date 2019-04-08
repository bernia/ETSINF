module Member where
member :: Int -> [Int] -> Bool
member x [] = False
member x (a:as) = if a == x then True else member x as
