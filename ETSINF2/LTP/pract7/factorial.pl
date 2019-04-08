factorial(0,1).
factorial(N,S):-
	N>0, B is N - 1, factorial(B,Y), S is N*Y