package banco;
import java.util.Scanner;
import conta.*;

public class sistemaBancario {
	public static void main(String [] args) {
		contaBancaria c1 = new contaBancaria();
		int op = 1, r;
		double valor;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("(1) - Consultar Saldo\n(2) - Debitar\n(3) - Creditar\n(4) - Sair");
			System.out.println("Escolha uma opção: ");
			op = scan.nextInt();
			switch(op) {
				case 1:
					System.out.println(c1.consultarSaldo() + " R$");
					break;
				case 2:
					System.out.println("Digite o valor a ser sacado: ");
					valor = scan.nextDouble();
					r = c1.debitar(valor);
					if(r == 1) {
						System.out.println("Saque no valor de " + valor + " R$ realizado com sucesso!");
					}else {
						if(r == 0)
							System.out.println("Saque não efetuado, saldo insuficiente!");
						else
							System.out.println("Valor do saque não pode ser negativo!");
					}
					break;
				case 3:
					System.out.println("Digite o valor a ser depositado: ");
					valor = scan.nextDouble();
					r = c1.creditar(valor);
					if(r == 1) {
						System.out.println("Depósito realizado com sucesso!");	
					}else {
						System.out.println("Valor insuficiente para realizar um depósito!!");
					}
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
