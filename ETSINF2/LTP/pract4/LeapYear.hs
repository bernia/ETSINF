module LeapYear where
import Data.Int
leapyear' :: Int -> Bool
leapyear' x = if mod x 4 == 0 && (mod x 100 /= 0 || mod x 400 == 0) then True else False

