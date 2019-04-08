module NumCbetw2 where
numcbetw2 :: Char -> Char -> Int
numcbetw2 a b = if ord(a) == ord(b) then 0 else
		if ord(a) /= ord(b) then (abs(ord(a)-ord(b))) - 1 else
