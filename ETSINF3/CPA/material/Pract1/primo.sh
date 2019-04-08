#!/bin/sh 
#PBS -q   cpa
#PBS -l  nodes=1,walltime=00:10:00
#PBS -d .
OMP_SCHEDULE=dynamic ./primo_numeros
OMP_SCHEDULE=static,1 ./primo_numeros
OMP_SCHEDULE=guided ./primo_numeros
OMP_SCHEDULE=static ./primo_numeros
