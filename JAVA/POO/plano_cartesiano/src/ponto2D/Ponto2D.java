package ponto2D;
import java.util.Scanner;

public class Ponto2D {
	public int x, y;
	
	//Cria um ponto na origem por default
	public Ponto2D(){
		this.x = 0;
		this.y = 0;
	}
	
	//Cria um ponto apartir das coordenadas passadas
	public Ponto2D(int p1, int p2){
		this.x = p1;
		this.y = p2;
	}

	//Cria um ponto com apenas um parâmetro, ficando x = y
	public Ponto2D(int p){
		this.x = y = p;
	}
	
	//Cria um ponto apartir de um existente, transformando no inverso dele
	public Ponto2D(Ponto2D ponto){
		this.x = -ponto.x;
		this.y = -ponto.y;
	}
}
