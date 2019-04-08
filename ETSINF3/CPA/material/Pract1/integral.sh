#!/bin/sh
#PBS -l nodes=1,walltime=00:05:00 
#PBS -q cpa
#PBS -d .
OMP_NUM_THREADS=1 ./pintegral 1 1000000
OMP_NUM_THREADS=1 ./pintegral 2 1000000
OMP_NUM_THREADS=16 ./pintegral 1 1000000
OMP_NUM_THREADS=16 ./pintegral 2 1000000
