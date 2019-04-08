module Remainder where
import Data.Int
remainder' :: Int -> Int -> Int
remainder' x y = if x == y then 0 else
		 if x > y then remainder' (x-y) y else x
