module SelectEven where
selectEven :: [Int] -> [Int]
--selectEven x = [y | y <- x, even y]
selectEven x = filter even x
