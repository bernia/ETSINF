countTo(1,[1]).
countTo(2,[1,2]).
countTo(3,[1,2,3]).
countTo(4,[1,2,3,4]).

mymember(E,[E|_]).
mymember(E,[H|L]) :- mymember(E,L).

myappend([],L,L).
myappend([E|L1],L2,[X|L3]) :- X = E, myappend(L1,L2,L3).

flatten([],[]).
    flatten([X|L],[X|P]) :- atomic(X), flatten(L,P).
    flatten([X|L],P) :- not(atomic(X)), flatten(X,P_X), flatten(L,P_L), append(P_X,P_L,P).        

prefix(P,L) :- append(P,_,L).
suffix(P,L) :- append(_,P,L).
sublist(S,L) :- suffix(L1,L),prefix(S,L1).

sublistU(S,L) :- append(_,L1,L),append(S,_,L1).
                 
swap([],[]).
swap([X],[X]).
swap([X,Y|Z],[Y,X|Z]).

mistery([],0).
mistery([_|T],N) :- mistery(T,M), N is M + 1.

subset([],X).
subset([A|X],Y) :- member(A,Y), ?????.

sorted([X]).
??????? :- X =< Y, sorted([Y|Ys]).

remove(_,[],[]).
remove(C,[X|R],L) :- X == C, remove(C,R,L).
remove(C,[X|R],W) :- X \== C, ????? , ??????? .
