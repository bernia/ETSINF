module Shape2 where
type Height = Float
type Width  = Float
type Radius = Float
data Shape  = Rectangle Height Width |
              Circle Radius
              deriving (Eq, Show)
area :: Shape -> Float
area (Rectangle h w) = h * w
area (Circle r) = pi * r**2

perimeter :: Shape -> Float
perimeter (Rectangle h w) = 2*h + 2*w
perimeter (Circle r) = 2 * pi * r

surfacePrism :: Shape -> Height -> Float
surfacePrism (Rectangle a b) h = (2*area (Rectangle a b)) + (perimeter (Rectangle a b)) * h
surfacePrism (Circle r) h = (2 * area (Circle r)) + (perimeter (Circle r)) * h
