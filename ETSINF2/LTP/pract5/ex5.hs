module IsPrime where
isPrime :: Int -> Bool
isPrime 1 = True
isPrime x = if length (divisors x) == 2 then True else False

divisors :: Int -> [Int]
divisors x = [y | y <- [1..x], mod x y == 0]

primes :: Int -> [Int]
primes n = take' n [x |x <- [1..], isPrime x]

take':: Int -> [a] -> [a]
take' _ [] = []
take' n (x:t)
     | n<=0 = []
     | otherwise = x : take' (n-1) t

