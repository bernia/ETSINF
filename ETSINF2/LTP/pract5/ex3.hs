-- *** Exercise 3 - Practice 5 *** 
module Divisors where
divisors :: Int -> [Int]
divisors x = [y | y <- [1..x], mod x y == 0]
