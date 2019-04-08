(deffacts bf (map 3 2)(obs 1 1)
(S 2 1 C 2 2 M 1 2 buit))

(defrule baix
	(S ?f ?c $?z) (map ?maxF ?maxC)
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
	(S ?f ?c $?z) (map ?maxF ?maxC)
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
	
	