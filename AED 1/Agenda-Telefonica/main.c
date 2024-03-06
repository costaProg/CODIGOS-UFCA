#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include "agenda.h"

void imprimeMenu(){
    printf("\n[1] - INSERIR CONTATO\n[2] - BUSCAR CONTATO POR NOME\n[3] - EDITAR CONTATO\n[4] - APAGAR CONTATO PELO NOME");
    printf("\n[5] - APAGAR TODOS OS CONTATOS\n[6] - IMPRIMIR CONTATOS\n[7] - TOTAL DE CONTATOS\n[8] - ENCERRAR O PROGRAMA\n");
}

void preencheContato(struct contato *dados){
    printf("\nDigite o nome: ");
    fflush(stdin);
    scanf("%s",dados->nome);
    printf("\nDigite o telefone: ");
    fflush(stdin);
    scanf("%s",dados->telefone);
}

int main()
{
setlocale(LC_ALL,"");

    int op = 0, a;
    char name[50], number[11];
    Lista *contatos;

    contatos = NULL;
    contatos = criar();

    struct contato *dados;

    dados = (struct contato*)malloc(sizeof(struct contato));

    do{
        imprimeMenu();
        printf("\n[ESCOLHA UMA OPÇÃO]: ");
        scanf("%d",&op);
        switch(op){
            case 1:
                preencheContato(dados);
                insereContato(contatos, *dados);
                break;
            case 2:
                printf("\nDigite o nome do contato: ");
                fflush(stdin);
                scanf("%s",&name);
                buscaContato(contatos, name, dados);
                break;
            case 3:
                printf("\nDigite o número do contato que deseja editar: ");
                fflush(stdin);
                scanf("%s",&number);
                editaContato(contatos, number, dados);
                break;
            case 4:
                printf("\nDigite o nome do contato: ");
                fflush(stdin);
                scanf("%s",&name);
                removeContato(contatos, name);
                break;
            case 5:
                destruir(contatos);
                break;
            case 6:
                imprimeLista(contatos);
                break;
            case 7:
                tamanho(contatos);
                break;
            case 8:
                destruir(contatos);
                printf("\n------ PROGRAMA FINALIZADO ------\n");
                break;
            default:
                printf("\n-------------------------\n");
                printf("\nOpção inválida!!\n");
                printf("\n-------------------------\n");
                break;
        }

    }while(op != 8);

    return 0;
}
