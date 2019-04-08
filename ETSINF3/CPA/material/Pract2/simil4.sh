#!/bin/sh
#PBS -l nodes=1,walltime=00:05:00 
#PBS -q cpa
#PBS -d .

OMP_NUM_THREADS=6 OMP_SCHEDULE=static ./simil4 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=6 OMP_SCHEDULE=static,1 ./simil4 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=6 OMP_SCHEDULE=dynamic,1 ./simil4 donantes.txt pacientes.txt salida1.txt


