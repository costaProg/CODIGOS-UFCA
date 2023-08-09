#ifndef MATRIZ_H_INCLUDED
#define MATRIZ_H_INCLUDED

typedef struct matriz Matriz;

Matriz* cria(int, int);

void libera (Matriz*, int n);

void atribui(Matriz*, int, int, int);

int acessa(Matriz* , int, int);

int linhas(Matriz*);

int colunas(Matriz*);

#endif // MATRIZ_H_INCLUDED
