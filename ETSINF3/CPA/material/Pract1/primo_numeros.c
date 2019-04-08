#include <stdio.h>
#include <math.h>
#include <omp.h>

typedef unsigned long long Entero_grande;
#define N 100000000ULL

int primo(Entero_grande n)
{
  volatile int p;
  Entero_grande i, s;

  p = (n % 2 != 0 || n == 2);

  if (p) {
    s = sqrt(n);

    for (i = 3; p && i <= s; i += 2)
      if (n % i == 0) p = 0;
  }

  return p;
}

int main()
{
  Entero_grande i, n;

  n = 2; /* Por el 1 y el 2 */
double t = omp_get_wtime();
 #pragma omp parallel for schedule(runtime) reduction(+:n)
  for (i = 3; i <= N; i += 2)
    if (primo(i)) n++;
t = omp_get_wtime() - t;
int chunk;
omp_sched_t tipo;
#pragma omp parallel
#pragma omp single
{
	omp_get_schedule(&tipo,&chunk);
	printf("\tTiempo para %d hilos: %f\n", omp_get_num_threads(), t);
	printf("\tTipo de planificacion: %d chunk: %d\n", tipo, chunk);
}
  printf("Entre el 1 y el %llu hay %llu numeros primos.\n",
         N, n);

  return 0;
}
