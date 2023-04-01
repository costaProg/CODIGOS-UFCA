package main;
import java.util.ArrayList;
import java.util.Scanner;
import campeonato.Campeonato;
import campeonato.Clube;

public class Teste {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int op, n;
		String nomeTime, t;
		System.out.println("\t---------- Campeonato ----------\n");
		System.out.println("\nInforme o total de equipes(preferência número par): ");
		n = scan.nextInt();
		ArrayList<Clube>equipes = new ArrayList<Clube>();
		Campeonato br = new Campeonato(equipes);
		Clube times[] = new Clube[n];
		do {
			System.out.println("\n---------- Menu ----------");
			System.out.println("(0) - Sair\n(1) - Adicionar Times\n(2) - Jogar Campeonato\n(3) - Classificação\n(4) - Campeão");
			System.out.println("--------------------------\n");
			System.out.println("Escolha uma opção: "); 	
			op = scan.nextInt();
			switch(op) {
				case 1:
					for(int i = 0; i < n; i++) {
						System.out.println("\nInforme o nome da equipe "+(i+1)+": ");
						nomeTime = scan.next();
						times[i] = new Clube(nomeTime);
						equipes.add(times[i]);
					}
					System.out.println("\nEquipes adicionadas com sucesso !!!\n");
					break;
				case 2:
					br.jogarCampeonato();
					break;
				case 3:
					br.getClassificacao();
					break;
				case 4:
					t = br.getCampeao();
					System.out.println(t);
					break;
				case 0:
					System.out.println("------| Finalizando o programa |------");
					break;
				default:
					System.out.println("-----| Opção inválida !!! |-----");
					break;
			}
		}while(op != 0);
		scan.close();
	}
	
}
