module SumFacts where
import Data.Int
sumFacts :: Int -> Int
sumFacts 0 = 0
sumFacts x = fact x + sumFacts (x-1)

fact :: Int -> Int
fact 0 = 1
fact n = n * fact (n - 1)
