#include <stdio.h>
#include <stdlib.h>
#include "matriz.h"

int main()
{
    Matriz* mat;
    int m, n, op;
    int valor;

    printf("Informe o total de linhas: ");
    scanf("%d", &m);

    printf("\nInforme o total de colunas: ");
    scanf("%d", &n);

    mat = cria(m, n);

    do{
        printf("\n[0] - Sair\n[1] - Atribuir valores para matriz\n[2] - Imprimir matriz\n[3] - Imprimir total de linhas\n[4] - Imprimir total de colunas\n");
        printf("\nEscolha uma opção: ");
        scanf("%d",&op);

        switch(op){
            case 0:
                libera(mat, n);
                printf("\n------ Programa Finalizado !! ------\n");
                break;
            case 1:
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        printf("\nInforme um valor: ");
                        scanf("%d", &valor);
                        atribui(mat,i, j,valor);
                    }
                }
                break;
            case 2:
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        printf(" %d", acessa(mat,i,j));
                    }
                    printf("\n");
                }
                break;
            case 3:
                printf("\nTotal de linhas: %d",linhas(mat));
                break;
            case 4:
                printf("\nTotal de colunas: %d",colunas(mat));
                break;
            default:
                printf("\nOpção inválida!!");
                break;
        }

    }while(op != 0);

    return 0;
}
