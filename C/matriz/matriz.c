#include <stdlib.h>
#include <stdio.h>
#include "matriz.h"

struct matriz{
    int m;
    int n;
    int** v;
};

//cria a matriz na memória
Matriz* cria(int m, int n){
    Matriz* mat;

    mat = (Matriz*)malloc(sizeof(Matriz));

    if(mat == NULL){
        printf("Memória insuficiente!!\n");
        exit(1);
    }
    mat->m = m;
    mat->n = n;
    mat->v = (int**)malloc(m*sizeof(int*));
    for(int i = 0; i < m; i++){
            mat->v[i] = (int*) malloc(n*sizeof(int));
    }
    return mat;
}

//libera o espaço na memória alocado
void libera(Matriz* mat, int n){
    if( mat->v != NULL){
        for(int i = 0; i < n; i++){
            free(mat->v[i]);
        }
        free(mat->v);
    }else{
        exit(1);
    }
}

//Atribui valores para a matriz
void atribui(Matriz* mat, int m, int n, int va){
    if(mat->v != NULL){
        mat->v[m][n] = va;
    }else{
        exit(1);
    }
}

//imprime matriz
int acessa(Matriz* mat, int m, int n){
    if(mat->v != NULL){
        return mat->v[m][n];
    }else{
        exit(1);
    }
}

//imprime total de linhas da matriz
int linhas(Matriz* mat){
    return mat->m;
}

//imprime total de colunas da matriz
int colunas(Matriz* mat){
    return mat->n;
}
