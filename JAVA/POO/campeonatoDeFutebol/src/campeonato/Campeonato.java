package campeonato;
import java.util.ArrayList;
import java.util.Random;

public class Campeonato {
	Clube campeao[] = new Clube[1];
	ArrayList<Clube> clubes = new ArrayList<Clube>();
	
	public Campeonato(ArrayList<Clube> clubes) {
		this.clubes = clubes;
	}
	
	public void jogarPartida(Clube timeM, Clube timeV) {
		Random placar = new Random();
		
		int golsM = placar.nextInt(6);
		int golsV = placar.nextInt(6);
		
		System.out.println("\t   ------ PARTIDA ------\n");
		if(golsM > golsV) {
			timeM.ganhar(golsM, golsV);
			timeV.perder(golsV, golsM);
			System.out.println("\t| "+timeM.nome+" "+golsM+" X "+golsV+" "+timeV.nome+" |\n");
		}else if(golsM < golsV) {
			timeM.perder(golsM, golsV);
			timeV.ganhar(golsV, golsM);
			System.out.println("\t| "+timeM.nome+" "+golsM+" X "+golsV+" "+timeV.nome+" |\n");
		}else {
			timeM.empatar();
			timeV.empatar();
			System.out.println("\t| "+timeM.nome+" "+golsM+" X "+golsV+" "+timeV.nome+" |\n");
		}
	}
	
	public void jogarCampeonato() {
		for (int i = 0; i < clubes.size(); i++) {
			for(int j = i + 1; j < clubes.size(); j++) {
				jogarPartida(clubes.get(i), clubes.get(j));
				jogarPartida(clubes.get(j), clubes.get(i));
			}
		}
	}
	
	public 	void getClassificacao() {
		int n = clubes.size();
		for (int i = 0; i < clubes.size(); i++) {
			for(int j = i + 1; j < clubes.size(); j++) {
				if(clubes.get(i).pontos < clubes.get(j).pontos) {
					clubes.add(clubes.get(i));
					clubes.set(i, clubes.get(j));
					clubes.set(j, clubes.get(n));
					clubes.remove(n);
				}else if(clubes.get(i).pontos == clubes.get(j).pontos){
					if(clubes.get(i).saldoGols < clubes.get(j).saldoGols) {
						clubes.add(clubes.get(i));
						clubes.set(i, clubes.get(j));
						clubes.set(j, clubes.get(n));
						clubes.remove(n);	
					}
				}
			}
		}
		campeao[0] = clubes.get(0);
		System.out.println("\n-------------------- Tabela --------------------\n");
		for (Clube clube : clubes) {
			System.out.println(clube);
		}
		System.out.println("\n------------------------------------------------\n");
	}
	
	public String getCampeao() {
		return "Parabéns a equipe do " + campeao[0].nome + " Pelo grande título !!";
	}
	
}
