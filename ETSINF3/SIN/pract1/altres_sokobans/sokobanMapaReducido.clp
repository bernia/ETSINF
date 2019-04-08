(defglobal ?*NODE* = 0)
(defglobal ?*L* = 25)
(deffacts bf (map 3 4)(obs 2 2)
(S 1 4 C 1 2 C 2 3 M 1 1 0 M 3 2 0 N 0))

(defrule baix
	(S ?f ?c $?z N ?n) (map ?maxF ?)
	(test (< ?n ?*L*))
	(test (< ?f ?maxF))
	(not (obs =(+ ?f 1) ?c))
	(test  (not (member$ (create$ C (+ ?f 1) ?c) $?z )))
	(test  (not (member$ (create$ M (+ ?f 1) ?c) $?z )))
	=> 
	(assert(S (+ ?f 1) ?c $?z N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule dalt
	(S ?f ?c $?z N ?n)
	(test (< ?n ?*L*))
	(test (> ?f 1))
	(not (obs =(- ?f 1) ?c))
	(test (not (member$ (create$ C (- ?f 1) ?c) $?z )))
	(test (not (member$ (create$ M (- ?f 1) ?c) $?z )))
	=> 
	(assert(S (- ?f 1) ?c $?z N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))

(defrule esquerra
	(S ?f ?c $?z N ?n)
	(test (< ?n ?*L*))
	(test (> ?c 1))
	(not (obs ?f =(- ?c 1)))
	(test  (not (member$ (create$ C ?f (- ?c 1)) $?z )))
	(test  (not (member$ (create$ M ?f (- ?c 1)) $?z )))
	=> 
	(assert(S ?f (- ?c 1) $?z N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule dreta
	(S ?f ?c $?z N ?n) (map ?maxF ?maxC)
	(test (< ?n ?*L*))
	(test (< ?c ?maxC))
	(not (obs ?f =(+ ?c 1)))
	(test  (not (member$ (create$ C ?f (+ ?c 1)) $?z )))
	(test  (not (member$ (create$ M ?f (+ ?c 1)) $?z )))
	=> 
	(assert(S ?f (+ ?c 1) $?z N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaAmunt
	(declare (salience 1))
	(S ?f ?c $?z C ?fc ?cc $?z1 N ?n)
	(test (< ?n ?*L*))
	(test (> ?f 2))
	(not (obs =(- ?f 2) ?c))
	(test (= ?f (+ ?fc 1)))
	(test (not (member$ (create$ C (- ?fc 1) ?c) $?z)))
	(test (not (member$ (create$ C (- ?fc 1) ?c) $?z1)))
	(test (not (member$ (create$ M (- ?fc 1) ?c) $?z1)))
	=>
	(assert (S (- ?f 1) ?c $?z C (- ?fc 1) ?c $?z1 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaAmuntMagatzem
	(declare (salience 2))
	(S ?f ?c $?z C ?fc ?c $?z1 M ?fm ?c ?e $?z2 N ?n)
	(test (< ?n ?*L*))
	(test (> ?f 2))
	(test (= ?f (+ ?fc 1)))
	(test (= ?f (+ ?fm 2)))
	(test (= ?e 0))
	=>
	(assert (S (- ?f 1) ?c $?z $?z1 M ?fm ?c (+ ?e 1) $?z2 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaAvall	
	(declare (salience 1))
	(S ?f ?c $?z C ?fc ?c $?z1 N ?n) (map ?maxF ?)
	(test (< ?n ?*L*))
	(test (< ?f (- ?maxF 1)))
	(not (obs =(+ ?f 2) ?c))
	(test (= ?f (- ?fc 1)))
	(test (not (member$ (create$ C (+ ?fc 1) ?c) $?z)))
	(test (not (member$ (create$ C (+ ?fc 1) ?c) $?z1)))
	(test (not (member$ (create$ M (+ ?fc 1) ?c) $?z1)))
	=>
	(assert (S (+ ?f 1) ?c $?z C (+ ?fc 1) ?c $?z1 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaAvallMagatzem
	(declare (salience 2))
	(S ?f ?c $?z C ?fc ?c $?z1 M ?fm ?c 0 $?z2 N ?n) (map ?maxF ?maxC)
	(test (< ?n ?*L*))
	(test (= ?f (- ?fc 1)))
	(test (= ?f (- ?fm 2)))
	=>
	(assert (S (+ ?f 1) ?c $?z $?z1 M ?fm ?c 1 $?z2 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaEsquerra
	(declare (salience 1))
	(S ?f ?c $?z C ?f ?cc $?z1 N ?n)
	(test (< ?n ?*L*))
	(test (> ?c 2))
	(not (obs ?f =(- ?c 2)))
	(test (= ?c (+ ?cc 1)))
	(test (not (member$ (create$ C ?f (- ?cc 1)) $?z)))
	(test (not (member$ (create$ C ?f (- ?cc 1)) $?z1)))
	(test (not (member$ (create$ M ?f (- ?cc 1)) $?z1)))
	=>
	(assert (S ?f (- ?c 1) $?z C ?f (- ?cc 1) $?z1 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaEsquerraMagatzem
	(declare (salience 2))
	(S ?f ?c $?z C ?f ?cc $?z1 M ?f ?cm 0 $?z2 N ?n)
	(test (< ?n ?*L*))
	(test (= ?c (+ ?cc 1)))
	(test (= ?c (+ ?cm 2)))
	=>
	(assert (S ?f (- ?c 1) $?z $?z1 M ?f ?cm 1 $?z2 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaDreta
	(declare (salience 1))
	(S ?f ?c $?z C ?f ?cc $?z1 N ?n) (map ?maxF ?maxC)
	(test (< ?n ?*L*))
	(test (< ?c (- ?maxC 1)))
	(not (obs ?f =(+ ?c 2)))
	(test (= ?c (- ?cc 1)))
	(test (not (member$ (create$ C ?f (+ ?cc 1)) $?z)))
	(test (not (member$ (create$ C ?f (+ ?cc 1)) $?z1)))
	(test (not (member$ (create$ M ?f (+ ?cc 1)) $?z1)))
	=>
	(assert (S ?f (+ ?c 1) $?z C ?f (+ ?cc 1) $?z1 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule caixaDretaMagatzem
	(declare (salience 2))
	(S ?f ?c $?z C ?f ?cc $?z1 M ?f ?cm 0 $?z2 N ?n) (map ?maxF ?maxC)
	(test (< ?n ?*L*))
	(test (= ?c (- ?cc 1)))
	(test (= ?c (- ?cm 2)))
	=> 
	(assert (S ?f (+ ?c 1) $?z $?z1 M ?f ?cm 1 $?z2 N (+ ?n 1)))
	(bind ?*NODE* (+ ?*NODE* 1)))
	
(defrule acaba
	(declare (salience 100))
	(S ? ? M $? N ?n)
	=> 
	(printout t "Solució trobada amb profunditat " ?n crlf)
	(printout t "S'han generat  " ?*NODE* " nodes." crlf)
	(halt))

(set-strategy breadth)	
(reset)
(run)
(exit)	