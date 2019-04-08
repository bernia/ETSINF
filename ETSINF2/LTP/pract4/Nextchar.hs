module Nextchar where
import Data.Char
nextChar :: Char -> Char
nextChar c = chr ((ord c) + 1)

