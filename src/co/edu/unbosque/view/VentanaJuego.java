package co.edu.unbosque.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaJuego {

	private JLabel guia;
	private JPanel pila;
	private JPanel cuadro;
	private JPanel grupo1;
	private JPanel grupo2;
	private JPanel grupo3;
	private JTextArea info;
	private JTextArea puntaje;
	private JTextArea reseta;
	private JTextArea tipo;
	private JLabel ingrediente;
	private JLabel pizza;
	private JLabel IngredienteLabel;
	private ImageIcon base;
	private ImageIcon masa;
	private ImageIcon sabor;
	private JLabel pinguino;
	private JLabel chef;
	private Image parauso;
	private JButton pausa;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;

	public VentanaJuego() {
	}

	public void presionar() {
	    // Configuración del grupo 1
		grupo1 = new JPanel();
	    grupo1.setLayout(null);
	    grupo1.setBounds(-10, 110, 180, 340);
	    btn1 = new JButton(); // Corregido
	    btn1.setBounds(11, 6, 160, 150);
	    btn1.setOpaque(false); 
	    btn1.setContentAreaFilled(false);
	    btn2 = new JButton(); // Corregido
	    btn2.setBounds(11, 166, 160, 150);
	    btn2.setOpaque(false); 
	    btn2.setContentAreaFilled(false);
	    grupo1.setOpaque(false);
	    grupo1.add(btn1);
	    grupo1.add(btn2);

	    grupo2 = new JPanel();
	    grupo2.setLayout(null);
	    grupo2.setBounds(1092, 115, 200, 340);
	    btn3 = new JButton(); // Corregido
	    btn3.setBounds(20, 0, 154, 150);
	    btn3.setOpaque(false); 
	    btn3.setContentAreaFilled(false);
	    btn4 = new JButton(); // Corregido
	    btn4.setBounds(20, 163, 154, 150);
	    btn4.setOpaque(false); 
	    btn4.setContentAreaFilled(false);
	    grupo2.setOpaque(false);
	    grupo2.add(btn3);
	    grupo2.add(btn4);

	    grupo3 = new JPanel();
	    grupo3.setLayout(null);
	    grupo3.setBounds(10, 410, 560, 200);
	    btn5 = new JButton(); // Corregido
	    btn5.setBounds(10, 30, 180, 150);
	    btn5.setOpaque(false); 
	    btn5.setContentAreaFilled(false);
	    btn6 = new JButton(); // Corregido
	    btn6.setBounds(220, 13, 60, 97);
	    btn6.setOpaque(false); 
	    btn6.setContentAreaFilled(false);
	    btn7 = new JButton(); // Corregido
	    btn7.setBounds(290, 95, 65, 100);
	    btn7.setOpaque(false); 
	    btn7.setContentAreaFilled(false);
	    grupo3.setOpaque(false);
	    grupo3.add(btn5); 
	    grupo3.add(btn6);
	    grupo3.add(btn7);
	   
	}

	public void informar() {
		cuadro = new JPanel();
	    cuadro.setLayout(null);
	    cuadro.setBounds(213, 22, 413, 248);
	    
	    info = new JTextArea();
	    info.setBounds(300, 40, 110, 80);
	    info.setEditable(false); // Hacer el JTextField de solo lectura
        info.setFocusable(false);
	    cuadro.add(info);

	    puntaje = new JTextArea();
	    puntaje.setBounds(250, 200, 200, 40);
	    puntaje.setEditable(false); // Hacer el JTextField de solo lectura
        puntaje.setFocusable(false);
	    cuadro.add(puntaje);
	    
	    reseta = new JTextArea();
	    reseta.setBounds(200, 70, 70, 70);
	    reseta.setForeground(Color.BLUE);
	    reseta.setEditable(false); // Hacer el JTextField de solo lectura
        reseta.setFocusable(false);
	    cuadro.add(reseta);
	    
	    tipo = new JTextArea();
	    tipo.setBounds(14, 5, 306, 20);
	    tipo.setForeground(Color.BLUE);
	    tipo.setEditable(false); // Hacer el JTextField de solo lectura
        tipo.setFocusable(false);
	    cuadro.add(tipo);

	}
	
	public void generar() {
		sabor = new ImageIcon("assets/calamar.png");
	    masa = new ImageIcon("assets/pizzaSola.png");
	    
	    parauso = masa.getImage();
	    parauso = parauso.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	    masa = new ImageIcon(parauso);
	    
	    pizza = new JLabel(masa);
	    pizza.setBounds(500, 400, 300, 300); 
	     
	    parauso = sabor.getImage();
	    parauso = parauso.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	    sabor = new ImageIcon(parauso);

	    ingrediente = new JLabel(sabor);
	    ingrediente.setVisible(false); 
	    ingrediente.setBounds(50, 50, 100, 100); 	
	}
	public void pausa(String texto2) {
		sabor = new ImageIcon(texto2);
	    parauso = sabor.getImage();
	    parauso = parauso.getScaledInstance(160, 180, Image.SCALE_SMOOTH);
	    sabor = new ImageIcon(parauso);
		pausa = new JButton(sabor);
		pausa.setBounds(1140,10,120,80);
        pausa.setOpaque(false);
        pausa.setContentAreaFilled(false);
        pausa.setBorderPainted(false);
        pausa.setFocusPainted(false);
        pausa.setBorder(null);
	}
	
	public ImageIcon concatenarImagenes(ImageIcon imagen1, ImageIcon imagen2,int x,int y) {
	    Image img1 = imagen1.getImage();
	    Image img2 = imagen2.getImage();
	    int width = Math.max(imagen1.getIconWidth(), imagen2.getIconWidth());
	    int height = Math.max(imagen1.getIconHeight(), imagen2.getIconHeight());
	    BufferedImage combinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = combinedImage.createGraphics();
	    g.drawImage(img1, 0, 0, null);
	    g.drawImage(img2, x, y, null);
	    g.dispose();
	    return new ImageIcon(combinedImage);
	}
	
	public void pizzaGuia() {
		base = new ImageIcon();		
		guia = new JLabel(masa);
	    guia.setBounds(190, 50, 300, 300);
	    
	    pila = new JPanel(new GridLayout(2, 8));
	    pila.setBounds(220, 189, 230, 80);
	}
	
	public void setSabor(String ruta) {
        this.sabor = new ImageIcon(ruta);
        parauso = sabor.getImage();
	    parauso = parauso.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	    sabor = new ImageIcon(parauso);
    }
	
	public void pinguino() {
		pinguino = new JLabel();
		pinguino.setBounds(950,460,300,400);
        pinguino.setOpaque(true);
	}
	
	public void chef(String ruta) {
		sabor = new ImageIcon(ruta);
        parauso = sabor.getImage();
	    parauso = parauso.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		chef = new JLabel(sabor);
		chef.setBounds(650,55,300,400);
	}
	
	public void gameover() {
		chef = new JLabel("Game Over");
	    chef.setForeground(Color.WHITE); 
	    chef.setFont(new Font("Arial", Font.BOLD, 100)); 
	    chef.setBounds(500, 500, 500, 500); 
        }
	
	public void resetMasa() {
		masa = new ImageIcon("assets/pizzaSola.png");
		parauso = masa.getImage();
		parauso = parauso.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		masa = new ImageIcon(parauso);
	}
	
	public JLabel getPinguino() {
		return pinguino;
	}
	public void setPinguino(JLabel pinguino) {
		this.pinguino = pinguino;
	}
	public JLabel getChef() {
		return chef;
	}
	public void setChef(JLabel chef) {
		this.chef = chef;
	}
	public JButton getPausa() {
		return pausa;
	}
	public void setPausa(JButton pausa) {
		this.pausa = pausa;
	}
	public JPanel getCuadro() {
		return cuadro;
	}
	public void setCuadro(JPanel cuadro) {
		this.cuadro = cuadro;
	}
	public JPanel getGrupo1() {
		return grupo1;
	}
	public void setGrupo1(JPanel grupo1) {
		this.grupo1 = grupo1;
	}
	public JPanel getGrupo2() {
		return grupo2;
	}
	public void setGrupo2(JPanel grupo2) {
		this.grupo2 = grupo2;
	}
	public JPanel getGrupo3() {
		return grupo3;
	}
	public void setGrupo3(JPanel grupo3) {
		this.grupo3 = grupo3;
	}
	public JTextArea getInfo() {
		return info;
	}
	public void setInfo(JTextArea info) {
		this.info = info;
	}
	public JTextArea getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(JTextArea puntaje) {
		this.puntaje = puntaje;
	}
	public JTextArea getReseta() {
		return reseta;
	}
	public void setReseta(JTextArea reseta) {
		this.reseta = reseta;
	}
	public JTextArea getTipo() {
		return tipo;
	}
	public void setTipo(JTextArea tipo) {
		this.tipo = tipo;
	}
	public JLabel getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(JLabel ingrediente) {
		this.ingrediente = ingrediente;
	}
	public JLabel getPizza() {
		return pizza;
	}
	public void setPizza(JLabel pizza) {
		this.pizza = pizza;
	}
	public JButton getBtn1() {
		return btn1;
	}
	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}
	public JButton getBtn2() {
		return btn2;
	}
	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}
	public JButton getBtn3() {
		return btn3;
	}
	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}
	public JButton getBtn4() {
		return btn4;
	}
	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}
	public JButton getBtn5() {
		return btn5;
	}
	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}
	public JButton getBtn6() {
		return btn6;
	}
	public void setBtn6(JButton btn6) {
		this.btn6 = btn6;
	}
	public JButton getBtn7() {
		return btn7;
	}
	public void setBtn7(JButton btn7) {
		this.btn7 = btn7;
	}
	public ImageIcon getMasa() {
		return masa;
	}
	public void setMasa(ImageIcon masa) {
		this.masa = masa;
	}
	public ImageIcon getSabor() {
		return sabor;
	}
	public void setSabor(ImageIcon sabor) {
		this.sabor = sabor;
	}
	public ImageIcon getBase() {
		return base;
	}
	public void setBase(ImageIcon base) {
		this.base = base;
	}
	public JLabel getGuia() {
		return guia;
	}
	public void setGuia(JLabel guia) {
		this.guia = guia;
	}
	public JPanel getPila() {
		return pila;
	}
	public void setPila(JPanel pila) {
		this.pila = pila;
	}
	public JLabel getIngredienteLabel() {
		return IngredienteLabel;
	}
	public void setIngredienteLabel(JLabel ingredienteLabel) {
		IngredienteLabel = ingredienteLabel;
	}
}