module SelectEvenPos where
selectEvenPos :: [Int] -> [Int]
selectEvenPos x = [y | (y,p) <- zip x [0..],  even p]  

-- RECURSIU
selectEvenPos' [] = []
selectEvenPos' (x:[]) = (x:[])
selectEvenPos' (x:y:ys) = x : selectEvenPos' ys
