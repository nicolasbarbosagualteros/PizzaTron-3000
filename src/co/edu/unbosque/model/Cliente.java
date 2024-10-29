package co.edu.unbosque.model;
import java.util.Arrays;

public class Cliente {

	private int dinero = 0;
	private int rating = 5;
	private int propina = 0;
	
	public Cliente() {
	}

	public void review(int [] orden,int[] pizza,int valor) {
		boolean esperado;
		if((orden[1]!=9||orden[0]!=7||orden[0]!=8)&&dinero>5) {
			dinero -=5;
		}
        Arrays.sort(orden, 0, orden.length);//se ordenan las listas
        Arrays.sort(pizza, 0, pizza.length);
        esperado = Arrays.equals(orden, pizza); //se compaaran las listas
		if (esperado == true) {
			dinero += valor;
		}
		else {
			if(dinero>0) {
				dinero -= 5;
				propina -=1;
			}
			rating -= 1;	
		}
	}
	
	public int getDinero() {
		return dinero;
	}
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getPropina() {
		return propina;
	}
	public void setPropina(int propina) {
		this.propina = propina;
	}
}