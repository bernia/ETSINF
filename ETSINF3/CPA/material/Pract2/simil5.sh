#!/bin/sh
#PBS -l nodes=1,walltime=00:05:00 
#PBS -q cpa
#PBS -d .

OMP_NUM_THREADS=2 OMP_SCHEDULE=dynamic,1 ./simil3 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=4 OMP_SCHEDULE=dynamic,1 ./simil3 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=8 OMP_SCHEDULE=dynamic,1 ./simil3 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=16 OMP_SCHEDULE=dynamic,1 ./simil3 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=32 OMP_SCHEDULE=dynamic,1 ./simil3 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=2 OMP_SCHEDULE=dynamic,1 ./simil4 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=4 OMP_SCHEDULE=dynamic,1 ./simil4 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=8 OMP_SCHEDULE=dynamic,1 ./simil4 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=16 OMP_SCHEDULE=dynamic,1 ./simil4 donantes.txt pacientes.txt salida1.txt
OMP_NUM_THREADS=32 OMP_SCHEDULE=dynamic,1 ./simil4 donantes.txt pacientes.txt salida1.txt
