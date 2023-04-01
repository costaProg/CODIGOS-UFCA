package campeonato;

public class Clube {
	String nome;
	int pontos;
	int saldoGols;
	
	public Clube() {
		
	}
		
	public Clube(String n){
		this.nome = n;
		this.pontos = 0;
		this.saldoGols = 0;
	}
	
	void ganhar(int golsF, int golsS) {
		this.pontos += 3;
		this.saldoGols += (golsF - golsS);
	}
	
	void empatar() {
		this.pontos += 1;
	}
	
	void perder(int golsF, int golsS) {
		this.saldoGols += (golsF - golsS);
	}
	

@Override
	public String toString() {
		return "|Time: " + this.nome + "|Saldo de gols: " + this.saldoGols + "|Pontos: "+this.pontos+"|";
	}
}
