module Shape where
type Height = Float
type Width  = Float
type Radius = Float
data Rectangle  = Rectangle Height Width 
data Circle = Circle Radius
class (Eq a, Show a) => Shape a where
   area :: a -> Float
   perimeter :: a -> Float

instance Shape Rectangle where
   area (Rectangle h w) = h * w
   perimeter (Rectangle h w) = h*2 + w*2
--   show (Rectangle h w) = "Height: " ++ h ++ " Width: " ++ w
   
instance Shape Circle where
   area (Circle r) = pi * r**2
   perimeter (Circle r) = 2 * pi * r
--   show (Circle r) = "Radius: " ++ r
   
type Volume = Float
volumePrism :: (Shape a) => a -> Height -> Volume
volumePrism base height = (area base) * height

surfacePrism :: (Shape a) => a -> Height -> Volume
surfacePrism base height =(area base) * 2 + height * (perimeter base)

--instance Show
--instance Show Rectangle where
--   show (Rectangle h w) = "Height: " ++ h ++ " Width: " ++ w
--instance Show Circle where
--   show (Circle r) = "Radius: " ++ r

--instance Eq
instance (Eq a) => Eq (Shape a) where
   (==) (Rectangle a b) (Rectangle c d) = (a==c) && (b==d)
   (==) (Rectangle a b) (Circle r) = False
   (==) (Circle r) (Rectangle a b) = False
   (==) (Circle r1) (Circle r2) = r1==r2

--instance show
instance (Show a) => Show (Shape a) where
   show (Rectangle h w) = "Height: " ++ h ++ " Width: " ++ w
   show (Circle r) = "Radius: " ++ r
