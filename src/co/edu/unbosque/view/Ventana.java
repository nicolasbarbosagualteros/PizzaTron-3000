package co.edu.unbosque.view;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {
    private JLabel fondo;
    private String atras;
    private PanelE panelE;
    private panelP panelP;

    public Ventana() {    	
    	inicializa();
    }
    public void limpiarPaneles() {
        if (panelP != null) {
        	panelP.retirar();
            getContentPane().remove(panelP);
            panelP = null;
        }
        if (panelE != null) {
        	panelE.retirar();
            getContentPane().remove(panelE);
            panelE = null;
        }
        revalidate(); 
        repaint();
    }
    
    public void inicializa() {
    	setTitle("PizzaTron-3000");
    	setSize(1280, 720);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setLayout(new BorderLayout());
    	setLocationRelativeTo(null);
    	setResizable(false);
    	setVisible(true);
    }
    public void inicializaPA() {
    	getContentPane().remove(panelE);
    	revalidate(); 
    	repaint();
    	inicializa();
    	panelP = new panelP();
    	getContentPane().add(panelP, BorderLayout.CENTER);
    	panelP.setBounds(0, 0, 1265, 681);
    	panelP.getBtnJugar();
    	panelP.getBtnPuntajes();
    	panelP.getBtnTutorial();
    	panelP.getBtnPizza();
    	panelP.getBtnSalir();
    	panelP.getBtnMusica();
    	revalidate(); 
    	repaint();
    }
    public void inicializaPU() {
    	if(panelE!=null) {
        	getContentPane().remove(panelE);
        	revalidate(); 
        	repaint();
    	}
    	inicializa();
    	panelP = new panelP();
    	getContentPane().add(panelP, BorderLayout.CENTER);
    }
    public void inicializaPP() {
    	getContentPane().remove(panelP);
    	revalidate(); 
    	repaint();
    	inicializa();
    	panelE = new PanelE();
    	getContentPane().add(panelE, BorderLayout.CENTER);
    	getContentPane().revalidate();
    	getContentPane().repaint();
    	getPanelE().pinguino();
    }
    public void inicializaPT() {
    	getContentPane().remove(panelP);
    	revalidate(); 
    	repaint();
    	inicializa();
    	panelE = new PanelE();
    	getContentPane().add(panelE, BorderLayout.CENTER);
    	getContentPane().revalidate();
    	getContentPane().repaint();
    	getPanelE().tutorial();
    }
    public void inicializaP(String a) {
		getContentPane().remove(panelP);
		revalidate(); 
		repaint();
		inicializa();
		panelE = new PanelE();
		getContentPane().add(panelE, BorderLayout.CENTER);
		getContentPane().revalidate();
		getContentPane().repaint();
		getPanelE().puntajes(a);
    }
    
    public void cargarFondo() {
        fondo = new JLabel();
        fondo.setBounds(0, 0, getWidth(), getHeight());
        add(fondo); 
        ImageIcon imagen = new ImageIcon(atras);
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
        fondo.setIcon(imagen);
    }

    public String getAtras() {
        return atras;
    }
    public void setAtras(String atras) {
        this.atras = atras;
    }
    public panelP getPanelP() {
    	return panelP;
    }
    public void setPanelP(panelP panelP) {
    	this.panelP = panelP;
    }
    public PanelE getPanelE() {
    	return panelE;
    }
    public void setPanelE(PanelE panelE) {
    	this.panelE = panelE;
    }
}