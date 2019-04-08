#!/bin/sh 
#PBS -q   cpa
#PBS -l  nodes=1,walltime=00:10:00
#PBS -d .
OMP_NUM_THREADS=6 ./simil2 donantes.txt pacientes.txt salida2.txt

