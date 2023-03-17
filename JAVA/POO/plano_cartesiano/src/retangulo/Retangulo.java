package retangulo;
import ponto2D.*;

public class Retangulo {
	
	//Definindo os possíveis pontos de extremos do retângulo
	public int x1, y1, x2, y2;
	Ponto2D ext1 = new Ponto2D();
	Ponto2D ext2 = new Ponto2D();
	
	//Criando um retângulo com valores default
	public Retangulo() {
		
	}
	
	//Criando um retângulo com dois pontos(dois objetos Ponto2D)
	public Retangulo(Ponto2D ext1, Ponto2D ext2){
		x1 = ext1.x; y1 = ext1.y;
		x2 = ext2.x; y2 = ext2.y;
	}
	
	//Crinado um retângulo com coordenadas(quatro valores inteiros)
	public Retangulo(int codx1, int cordy1, int cordx2, int cordy2){
		x1 = codx1; y1 = cordy1;
		x2 = cordx2; y2 = cordy2;
	}
	
	//verifica se o ponto passado está localizado dentro de um retângulo
	public boolean localizarPonto(Ponto2D ponto){
		if((ponto.x >= ext1.x && ponto.x <= ext2.x) && (ponto.y <= ext1.y && ponto.y >= ext2.y)) {
			return true;
		}else if((ponto.x >= x1 && ponto.x <= x2) && (ponto.y <= y1 && ponto.y >= y2)){
			return true;
		}else {
			return false;
		}
	}
	
}
