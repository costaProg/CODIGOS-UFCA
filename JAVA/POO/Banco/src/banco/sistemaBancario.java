package banco;
import java.util.Scanner;

public class sistemaBancario {
	public static void main(String [] args) {
		double saldo = 0, valor = 0;
		int op = 1;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("(1) - Consultar Saldo\n(2) - Saque\n(3) - Depósito\n(4) - Sair");
			System.out.println("Escolha uma opção: ");
			op = scan.nextInt();
			switch(op) {
				case 1:
					System.out.println(saldo + " R$");
					break;
				case 2:
					System.out.println("Digite o valor a ser sacado: ");
					valor = scan.nextDouble();
					if(valor <= saldo && valor > 0) {
						System.out.println("Saque no valor de " + valor + " R$ realizado com sucesso!");
						saldo -= valor;
					
					}else {
						if(valor > 0)
							System.out.println("Saque não efetuado, saldo insuficiente!");
						else
							System.out.println("Valor do saque não pode ser negativo!");
					}
					break;
				case 3:
					System.out.println("Digite o valor a ser depositado: ");
					valor = scan.nextDouble();
					saldo += valor;
					System.out.println("Depósito realizado com sucesso!");
					break;
				case 4:
					System.out.println("Até breve!");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			};
		}while(op != 4);
		scan.close();
	}
}
