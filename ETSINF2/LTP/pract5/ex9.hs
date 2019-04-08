module DoubleAll where
doubleAll :: [Int] -> [Int]
doubleAll x = map (2*) x

doubleAll' [] = []
doubleAll' (x:xs) = (2*x) : doubleAll' xs
