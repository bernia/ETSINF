#!/bin/sh 
#PBS -q   cpa
#PBS -l  nodes=2:ppn=8,walltime=00:10:00
#PBS -d .

cat $PBS_NODEFILE
mpiexec ./newtonMod -c5

