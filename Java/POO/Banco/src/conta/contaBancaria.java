package conta;

public class contaBancaria {
	
	public String numero;
	public double saldo;
	public String nome;
	
	public double consultarSaldo() {
		return saldo;
	}
	
	public int creditar(double valor) {
		if(valor > 0) {
			saldo += valor;
			return 1;
		}else {
			return 0;
		}
	}
	
	public int debitar(double valor) {
		if(valor <= saldo && valor > 0) {
			saldo -= valor;
			return 1;
		}else {
			if(valor > 0)
				return 0;
			else 
				return -1;
		}
	}

}
