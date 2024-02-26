package plano_cartesiano;
import java.util.Scanner;

import ponto2D.*;
import retangulo.*;

public class planoCartesiano {
	public static void main(String [] args) {
		int x, y, xy;
		
		//Auxiliares
		int op = 0, aux = 0;
		
		//Classe Scanner para ler dados do teclado
		Scanner scan = new Scanner(System.in);
		
		//ponto a ser criado
		Ponto2D ponto = new Ponto2D();
		
		//Retangulo a ser criado
		Retangulo retangulo = new Retangulo();
		
		//Possíveis extremos do retângulo
		Ponto2D ext1 = new Ponto2D();
		Ponto2D ext2 = new Ponto2D();
		int x1, x2, y1, y2;
		
		do {
			//Menu de interação com o usuário
			//cada caso do switch está especificado no menu
			System.out.println("[1] - Imprimir coordenada\n"
							 + "[2] - Criar ponto2D nas coordenadas indicadas\n"
							 + "[3] - Criar ponto2D com apenas um valor\n"
							 + "[4] - Criar ponto2D por outro ponto ja criado\n"
							 + "[5] - Criar retângulo\n"
							 + "[6] - Verificar se o ponto está no retangulo\n"
							 + "[7] - Sair do programa");
			System.out.println("Escolha uma opção: ");
			op = scan.nextInt();
			switch(op) {
				case 1:
					System.out.println("Coordenada : ("+ponto.x+","+ponto.y+")\n");
				break;
				case 2:
					System.out.println("Digite a coordenada x: ");
					x = scan.nextInt();
					System.out.println("Digite a coordenada y: ");
					y = scan.nextInt();
					ponto = new Ponto2D(x, y);
					System.out.println("Ponto criado com sucesso!!\n");
				break;
				case 3:
					System.out.println("Digite a coordenada xy: ");
					xy = scan.nextInt();
					ponto = new Ponto2D(xy);
					System.out.println("Ponto criado com sucesso!!\n");
				break;
				case 4:
					System.out.println("Coordenada antiga : ("+ponto.x+","+ponto.y+")\n");
					ponto = new Ponto2D(ponto);
					System.out.println("Coordenada nova :   ("+ponto.x+","+ponto.y+")\n");
				break;
				case 5:
					System.out.println("[1] - Criar retangulo por pontos2D extremos\n"
									 + "[2] - Criar retangulo apartir de coordenadas");
					System.out.println("Ecolha uma opção: ");
					aux = scan.nextInt();
					switch(aux) {
						case 1:
							System.out.println("Digite a coordenada x1: ");
							x1 = scan.nextInt();
							System.out.println("Digite a coordenada y1: ");
							y1 = scan.nextInt();
							System.out.println("Digite a coordenada x2: ");
							x2 = scan.nextInt();
							System.out.println("Digite a coordenada y2: ");
							y2 = scan.nextInt();
							ext1 = new Ponto2D(x1, y1);
							ext2 = new Ponto2D(x2, y2);
							retangulo = new Retangulo(ext1, ext2);
						break;
						case 2:
							System.out.println("Digite a coordenada x1: ");
							x1 = scan.nextInt();
							System.out.println("Digite a coordenada y1: ");
							y1 = scan.nextInt();
							System.out.println("Digite a coordenada x2: ");
							x2 = scan.nextInt();
							System.out.println("Digite a coordenada y2: ");
							y2 = scan.nextInt();
							retangulo = new Retangulo(x1, y1, x2, y2);
						break;
						default:
							System.out.println("OPÇÃO INVÁLIDA !!");
						break;
					}
				break;
				case 6 :
					
					if(retangulo.localizarPonto(ponto))
						System.out.println("Ponto contido no retângulo !");
					else
						System.out.println("Ponto não está contido no retângulo !");
				break;
				case 7:
					op = 7;
					System.out.println("PROGRAMA FINALIZADO !!");
				break;
				default:
					System.out.println("OPÇÃO INVÁLIDA !!");
				break;
			}
		}while(op != 7);
	}
}
