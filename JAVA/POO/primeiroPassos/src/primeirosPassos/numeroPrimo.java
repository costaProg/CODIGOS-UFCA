package primeirosPassos;
import java.util.Scanner;

public class numeroPrimo {
	public static void main(String [] args) {
		int x;
		//Sistema de leitura
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite um número: ");
		x = scan.nextInt();
		scan.close();
		//Verificar se o número é primo
		int div = 0;
		for(int i = 1; i <= x; i++) {
			if(x % i == 0) {
				div++;
			}
		}
		//Imprimindo o resultado para o usuário
		switch(div) {
			case 2:
				System.out.println(x + " é um número primo");
				break;
			default:
				System.out.println(x + " não é um número primo");
				break;
		};
	}
}
