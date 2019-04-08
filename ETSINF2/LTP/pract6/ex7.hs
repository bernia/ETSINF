module Ex7 where
type Height = Float
type Width  = Float
type Radius = Float
data Shape = Rectangle Height Width | Circle Radius

--instance Show
instance (Show a) => Show (Shape a) where
   show (Rectangle h w) = "Height: " ++ h ++ " Width: " ++ w
   show (Circle r) = "Radius: " ++ r

--instance Eq
instance (Eq a) => Eq (Shape a) where
   (==) (Rectangle a b) (Rectangle c d) = (a==c) && (b==d)
   (==) (Rectangle a b) (Circle r) = False
   (==) (Circle r) (Rectangle a b) = False
   (==) (Circle r1) (Circle r2) = r1==r2
   
