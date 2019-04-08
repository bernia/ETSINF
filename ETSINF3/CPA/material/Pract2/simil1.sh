#!/bin/sh 
#PBS -q   cpa
#PBS -l  nodes=1,walltime=00:10:00
#PBS -d .
OMP_NUM_THREADS=1 ./simil1 donantes.txt pacientes.txt salida1.txt

