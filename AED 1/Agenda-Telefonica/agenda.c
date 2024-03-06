#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "agenda.h"

struct elemento{
    struct contato dados;
    struct elemento *proximo;
};

typedef struct elemento Elemento;

Lista* criar(){
    Lista *ldse;
    ldse = (Lista*)malloc(sizeof(Lista));
    if(ldse != NULL){
        *ldse = NULL;
    }
    return ldse;
}

void destruir(Lista *ldse){
    if(ldse != NULL){
        Elemento *aux;
        while(*ldse != NULL){
            aux = *ldse;
            *ldse = (*ldse)->proximo;
            free(aux);
        }
        printf("\n-------------------------\n");
        printf("\nLISTA APAGADA!!\n");
        printf("\n-------------------------\n");
        free(ldse);
    }
}


int tamanho(Lista *ldse){
    if(ldse == NULL){
        return -1;
    }else if(vazia(ldse)){
        printf("\n-------------------------\n");
        printf("\nLISTA DE CONTATOS VAZIA!!\n");
        printf("\n-------------------------\n");
        return 0;
    }else{
        int cont = 0;
        Elemento *aux = *ldse;
        while(aux != NULL){
            aux = aux->proximo;
            cont++;
        }
        printf("\n-------------------------\n");
        printf("\nTOTAL DE CONTATOS: %d\n",cont);
        printf("\n-------------------------\n");
        return cont;
    }
}

int cheia(Lista *ldse){
    return 0;
}

int vazia(Lista *ldse){
    if(ldse == NULL){
        return 1;
    }else if(*ldse == NULL){
        return 1;
    }else{
        return 0;
    }
}

int insereContato(Lista *ldse, struct contato dados){
    if(ldse == NULL){
        return 0;
    }else{
        Elemento *novo = (Elemento*)malloc(sizeof(Elemento));
        if(novo == NULL){
            return 0;
        }else{
            novo->dados = dados;
            novo->proximo = NULL;
            if(vazia(ldse)){
                *ldse = novo;
            }else{
                Elemento *aux = *ldse;
                Elemento *busc = *ldse;
                while(busc != NULL && strcmp(busc->dados.telefone, novo->dados.telefone) != 0){
                    busc = busc->proximo;
                }
                if( busc != NULL){
                    printf("\n----------------------------\n");
                    printf("\nNUMERO JA REGISTRADO!!\n");
                    printf("\n----------------------------\n");
                    return 0;
                }else{
                while(aux->proximo != NULL){
                    aux = aux->proximo;
                }
                aux->proximo = novo;
                }
            }
            printf("\n-------------------------------\n");
            printf("\nCADASTRO EFETUADO COM SUCESSO!!\n");
            printf("\n-------------------------------\n");
            return 1;
        }
    }
}

int removeContato(Lista *ldse, char nome[50]){
    if(vazia(ldse)){
        return 0;
    }else if(strcmp((*ldse)->dados.nome, nome) == 0){
        Elemento *aux = *ldse;
        *ldse = aux->proximo;
        free(aux);
        printf("\n-------------------------------\n");
        printf("\nCONTATO APAGADO COM SUCESSO!!\n");
        printf("\n-------------------------------\n");
        return 1;
    }else{
        Elemento *ant = *ldse;
        Elemento *aux = ant->proximo;
        while(aux != NULL && strcmp(aux->dados.nome, nome) != 0){
            ant = aux;
            aux = aux->proximo;
        }
        //chegou ao fim da lista e nao achou o elemento
        if(aux == NULL){
            printf("\n-------------------------\n");
            printf("\nCONTATO INEXISTENTE!!\n");
            printf("\n-------------------------\n");
            return 0;
        }
        //achou o elemento
        ant->proximo = aux->proximo;
        free(aux);
        printf("\n--------------------------------\n");
        printf("\nCONTATO APAGADO COM SUCESSO!!\n");
        printf("\n--------------------------------\n");
        return 1;
    }
}

int buscaContato(Lista* ldse, char nome[50], struct contato *dados){
    if(vazia(ldse)){
        printf("\n-------------------------\n");
        printf("\nLISTA VAZIA!!\n");
        printf("\n-------------------------\n");
        return 0;
    }else{
        Elemento *aux = *ldse;
        while(aux != NULL && strcmp(aux->dados.nome, nome) != 0){
            aux = aux->proximo;
        }
        //chegou ao fim da lista e nao achou
        if(aux == NULL){
            printf("\n-------------------------\n");
            printf("\nCONTATO NAO ENCONTRADO!!\n");
            printf("\n-------------------------\n");
            return 0;
        }else{
            strcpy(dados->nome, aux->dados.nome);
            strcpy(dados->telefone, aux->dados.telefone);
            printf("\n-------------------------\n");
            printf("\nNOME: %s\nCONTATO: %s\n", dados->nome, dados->telefone);
            printf("\n-------------------------\n");
            return 1;
        }
    }
}


int imprimeLista(Lista *ldse){
    if(ldse == NULL){
        return -1;
    }else if(vazia(ldse)){
        printf("\n-----------------------------\n");
        printf("\nNENHUM CONTATO ENCONTRADO!!\n");
        printf("\n-----------------------------\n");
        return 0;
    }else{
        Elemento *aux = *ldse;
        while(aux != NULL){
            printf("--------------------------------\n");
            printf("NOME: %s\nCONTATO: %s\n", aux->dados.nome, aux->dados.telefone);
            printf("--------------------------------\n");
            aux = aux->proximo;
        }
        return 1;
    }
}

int editaContato(Lista* ldse, char number[11], struct contato *dados){
    if(vazia(ldse)){
        printf("\n--------------------\n");
        printf("\nLISTA VAZIA!!\n");
        printf("\n--------------------\n");
        return 0;
    }else{
        Elemento *aux = *ldse;
        int op = 0;
        char novoN[50], novoT[15];
        printf("\n[1] - Editar nome\n[2] - Editar telefone\n");
        printf("\nEscolha uma opção: ");
        scanf("%d",&op);
        if(op == 1){
            while(aux != NULL && strcmp(aux->dados.telefone, number) != 0){
            aux = aux->proximo;
            }
            if(aux == NULL){
                printf("\n--------------------------------\n");
                printf("\nCONTATO NÃO ENCONTRADO\n");
                printf("\n--------------------------------\n");
                return 0;
            }else{
                printf("\nDigite o novo nome: ");
                fflush(stdin);
                scanf("%s",&novoN);
                strcpy(aux->dados.nome, novoN);
                strcpy(dados->nome, aux->dados.nome);
                printf("\n--------------------------------\n");
                printf("\nCONTATO EDITADO COM SUCESSO!!\n");
                printf("\n--------------------------------\n");
                return 1;
            }
        } else if(op == 2){
            while(aux != NULL && strcmp(aux->dados.telefone, number) != 0){
            aux = aux->proximo;
            }
            if(aux == NULL){
                printf("\n--------------------------------\n");
                printf("\nCONTATO NÃO ENCONTRADO\n");
                printf("\n--------------------------------\n");
                return 0;
            }else{
                printf("\nDigite o novo contato: ");
                fflush(stdin);
                scanf("%s",&novoT);
                Elemento *comp = *ldse;
                while(comp != NULL && strcmp(comp->dados.telefone, novoT) != 0){
                    comp = comp->proximo;
                }
                if(comp == NULL){
                strcpy(aux->dados.telefone, novoT);
                strcpy(dados->telefone, aux->dados.telefone);
                printf("\n--------------------------------\n");
                printf("\nCONTATO EDITADO COM SUCESSO!!\n");
                printf("\n--------------------------------\n");
                return 1;
                }else{
                printf("\n-----------------------------\n");
                printf("\nCONTATO EXISTENTE!!\n");
                printf("\n-----------------------------\n");
                return 0;
                }
            }
        }else{
            printf("\n----------------------------\n");
            printf("\nOPCAO INVALIDA!!\n");
            printf("\n----------------------------\n");
            return 0;
        }
    }
}
