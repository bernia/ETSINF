(deffacts bf (map 5 8)(obs 3 1) (obs 1 4) (obs 3 4) (obs 3 5) (obs 3 8) (obs 4 4) (obs 5 4)
(S 4 1 C 2 2 C 4 3 C 2 6 M 1 7 0 M 4 5 0 M 5 5 0))

(defrule baix
	(S ?f ?c $?z)
	(test (< ?f ?maxF))
	(not (obs =(+ ?f 1) ?c))
	(test  (not (member$ (create$ C =(+ ?f 1) ?c) $?z )))
	(test  (not (member$ (create$ M =(+ ?f 1) ?c) $?z )))
	=> 
	(assert(S (+ ?f 1) ?c $?z)))

(defrule dalt
	(S ?f ?c $?z) (map ?maxF ?maxC)
	(test (> ?f 1))
	(not (obs =(- ?f 1) ?c))
	(test (not (member$ (create$ C =(- ?f 1) ?c) $?z )))
	(test (not (member$ (create$ M =(- ?f 1) ?c) $?z )))
	=> 
	(assert(S (- ?f 1) ?c $?z)))

(defrule esquerra
	(S ?f ?c $?z)
	(test (> ?c 1))
	(not (obs ?f =(- ?c 1)))
	(test  (not (member$ (create$ C ?f =(- ?c 1)) $?z )))
	(test  (not (member$ (create$ M ?f =(- ?c 1)) $?z )))
	=> 
	(assert(S ?f (- ?c 1) $?z)))
	
(defrule dreta
	(S ?f ?c $?z) (map ?maxF ?maxC)
	(test (< ?c ?maxC))
	(not (obs ?f =(+ ?c 1)))
	(test  (not (member$ (create$ C ?f =(+ ?c 1)) $?z )))
	(test  (not (member$ (create$ M ?f =(+ ?c 1)) $?z )))
	=> 
	(assert(S ?f (+ ?c 1) $?z)))
	
(defrule caixaAmunt
	(S ?f ?c $?z C ?fc ?cc $?z1)
	(test (> ?f 2))
	(not obs =(- ?f 2) ?c)
	(test (= ?f =(+ ?fc 1)))
	(test (= ?c ?cc))
	(test not((member$ (create$ M =(- ?f 1) ?c) $?z1)))
	=>
	(assert (S (- ?f 1) ?c $?z C (- ?fc 1) ?cc $?z1))
	
(defrule caixaAmuntMagatzem
	(S ?f ?c $?z C ?fc ?cc $?z1 M ?fm ?cm ?e $?z2)
	(test (> ?f 2))
	(not obs =(- ?f 2) ?c)
	(test (= ?f =(+ ?fc 1)))
	(test (= ?c ?cc))
	(test (= ?f =(+ ?fm 2)))
	(test (= ?c ?cm))
	(test (= ?e 0))
	=>
	(assert (S (- ?f 1) ?c $?z C (- ?fc 1) ?cc $?z1 M ?fm ?cm (+ ?e 1) $?z2))
	