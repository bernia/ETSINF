module DaysAMonth where
import Data.Int
daysAmonth' :: Int -> Int -> Int
daysAmonth' x y = if x == 2 then (if leapyear' y then 29 else 28) else
		  if x > 8 || x == 8 then (if mod x 2 == 0 then 31 else 30) else
		  if mod x 2 == 0 then 30 else 31

leapyear' :: Int -> Bool
leapyear' x = if mod x 4 == 0 && (mod x 100 /= 0 || mod x 400 == 0) then True 			else False
