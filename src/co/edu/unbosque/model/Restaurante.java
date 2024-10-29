package co.edu.unbosque.model;

import java.util.Random;

public class Restaurante {

	private int plata; //el puntaje que se tiene
	private int[] orden;
	private String[] rejistro;
	private int a = 0, b = 0, c = 0, d = 0;
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	public int getD() {
		return d;
	}
	public Restaurante() {
		// TODO Auto-generated constructor stub
	}
	public void Pedir(int n) {
	    int inicio = 7;
        int fin = 8;
	    orden = new int[n + 2];
	    Random a = new Random();
	    orden[0] = a.nextInt(fin - inicio + 1) + inicio;
	    System.out.println(orden[0]);
	    orden[n+1] = 9;
	    for (int i = 1; i <= n; i++) { 
	        orden[i] = a.nextInt(4);
	        System.out.println(orden[i]);
	    }
	}
	public void traducir() {
	    a = 0;
	    b = 0;
	    c = 0;
	    d = 0;
	    rejistro = new String[4];
	    for (int i = 1; i < orden.length; i++) { // Comienza desde la posición 1
	        if (orden[i] == 0) {
	            a++;
	        }
	        if (orden[i] == 1) {
	            b++;
	        }
	        if (orden[i] == 2) {
	            c++;
	        }
	        if (orden[i] == 3) {
	            d++;
	        }
	    }

	    System.out.println("------");
	    if (a > 0) {
	        rejistro[0] = a + "x";
	    }
	    if (b > 0) {
	        rejistro[1] = b + "x";
	    }
	    if (c > 0) {
	        rejistro[2] = c + "x";
	    }
	    if (d > 0) {
	        rejistro[3] = d + "x";
	    }
	}
	
	public int[] getOrden() {
		return orden;
	}
	public void setOrden(int[] orden) {
		this.orden = orden;
	}
	public void pagar(int pago) {
		setPlata(getPlata() + pago);
	}
	public int getPlata() {
		return plata;
	}
	public void setPlata(int plata) {
		this.plata = plata;
	}
	public String[] getRejistro() {
		return rejistro;
	}
	public void setRejistro(String[] comanda) {
		this.rejistro = comanda;
	}
}