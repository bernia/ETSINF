module AddRange where
import Data.Int
addRange :: Int -> Int -> Int
addRange x y = if x==y then x else
	       if x<y then x + addRange (x+1) y else
		x + addRange (x-1) y
