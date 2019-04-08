-- module Stack v1
module Stack (Stack, empty, push, pop, top, isEmpty) where
data Stack a       = EmptyStack | Stk a (Stack a)
push x s           = Stk x s
top (Stk x s)      = x
pop (Stk _ s)      = s
empty              = EmptyStack
isEmpty EmptyStack = True
isEmpty (Stk x s)  = False

-- instance Show ...
instance (Show a) => Show (Stack a) where
   show EmptyStack = "|"
   show (Stk x y) = (show x) ++ " <- " ++ (show y)

instance  (Eq a) => Eq (Stack a)  where
   (==) EmptyStack EmptyStack = True
   (==) EmptyStack (Stk x _) = False
   (==) (Stk x _) EmptyStack = False
   (==) (Stk x xs) (Stk y ys) = (x==y) && ((==) xs ys)
