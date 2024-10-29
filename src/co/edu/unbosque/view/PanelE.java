package co.edu.unbosque.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelE extends JPanel{
	private JButton btnBack,btnUsar,btnUsar2,btnFacil,btnMedio,btnMuerte;
	private ImageIcon iOP1,iOP2,iOP3,iOP4,iIcon,iBack,iUsar,iPuntajes,iiP;
	private JLabel lOP1,lOP2,lOP3,lOP4,lIcon,lPuntajes,llP;
	private JTextField nombre;
	private JTextArea txtNombre;
	
	public PanelE() {
		setLayout(null); 
		setVisible(true);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	public void puntajes(String a) {//no se que hacer:D
		iPuntajes=new ImageIcon("assets/zPuntajes.png");
		iBack = new ImageIcon("assets/btnAtras.png");
		txtNombre= new JTextArea(a);
		Font nuevaFuente = new Font("Arial", Font.BOLD, 20);
		
		txtNombre.setBounds(300, 200, 600, 300);
		txtNombre.setFont(nuevaFuente);
		
		lPuntajes=new JLabel();
		lPuntajes.setBounds(20, 20, 548, 55); 
		lPuntajes.setOpaque(false);
		lPuntajes.setIcon(iPuntajes);
		
		btnBack= new JButton();
		btnBack.setBounds(1110, 30, 120, 69); 
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setIcon(iBack);
		btnBack.setActionCommand("back");
		
		add(lPuntajes);
		add(btnBack);
		add(txtNombre);
	}
	
	public void tutorial() {
        iBack = new ImageIcon("assets/btnAtras.png");
        iiP=new ImageIcon("assets/fondoTutorial.png");
        
        llP=new JLabel();
        llP.setBounds(0, 0, 1270, 720); 
        llP.setOpaque(false);
        llP.setIcon(iiP); 
        
        btnBack= new JButton();
        btnBack.setBounds(1110, 30, 120, 69); 
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setIcon(iBack);
        btnBack.setActionCommand("back");
        
        add(llP);
		add(btnBack);
	    setComponentZOrder(btnBack, 0);
	}
	public void pinguino() {
        iOP1=new ImageIcon("assets/maestroPinguichelin.png");
        iOP2=new ImageIcon ("assets/maestroDelDulce.png");
        iOP3=new ImageIcon("assets/chefPinguinelli.png");
        iOP4=new ImageIcon("assets/chefGlacial.png");
        iIcon = new ImageIcon("assets/zEscoge.png");        
        iBack = new ImageIcon("assets/btnAtras.png");
        iUsar = new ImageIcon("assets/BtnUsar.png");
        Color customColor = new Color( 35, 146, 24 );
        
        nombre=new JTextField("Escriba su nombre");
        nombre.setBounds(100, 350, 200, 40);
        nombre.setForeground(Color.black);
        nombre.setOpaque(false);
        nombre.setBorder(null);
        nombre.setEditable(false);
        
        txtNombre=new JTextArea ();
        txtNombre.setBounds(100, 400, 120, 50);
        txtNombre.setEditable(true);
        
        btnFacil= new JButton("Facil");
        btnFacil.setBounds(100, 540, 150, 50); 
        btnFacil.setBackground(customColor);
        btnFacil.setForeground(Color.black);
        btnFacil.setActionCommand("fa");
        
        btnMedio= new JButton("Medio");
        btnMedio.setBackground(customColor);
        btnMedio.setForeground(Color.black);
        btnMedio.setBounds(260, 540, 150, 50); 
        btnMedio.setActionCommand("me");
        
        btnMuerte= new JButton("Dificil");
        btnMuerte.setBackground(customColor);
        btnMuerte.setForeground(Color.black);
        btnMuerte.setBounds(420, 540, 150, 50); 
        btnMuerte.setActionCommand("di");
        
        btnBack= new JButton();
        btnBack.setBounds(1110, 30, 120, 69); 
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setIcon(iBack);
        btnBack.setActionCommand("back");

        btnUsar= new JButton();
        btnUsar.setBounds(450, 200, 121, 71); 
        btnUsar.setOpaque(false);
        btnUsar.setContentAreaFilled(false);
        btnUsar.setBorderPainted(false);
        btnUsar.setIcon(iUsar);
        btnUsar.setActionCommand("usar1");
        
        btnUsar2= new JButton();
        btnUsar2.setBounds(450, 370, 121, 71); 
        btnUsar2.setOpaque(false);
        btnUsar2.setContentAreaFilled(false);
        btnUsar2.setBorderPainted(false);
        btnUsar2.setIcon(iUsar);
        btnUsar2.setActionCommand("usar2");

        lIcon=new JLabel();
        lIcon.setBounds(10, 10, 873, 113); 
        lIcon.setOpaque(false);
        lIcon.setIcon(iIcon);
        
        lOP1=new JLabel();
        lOP1.setBounds(700, 150, 500, 500); 
        lOP1.setOpaque(false);
        lOP1.setIcon(iOP1);
        
        lOP2=new JLabel();
        lOP2.setBounds(700, 150, 500, 500); 
        lOP2.setOpaque(false);
        lOP2.setIcon(iOP2);
        
        lOP3=new JLabel();
        lOP3.setBounds(700, 150, 500, 500); 
        lOP3.setOpaque(false);
        lOP3.setIcon(iOP3);        
        
        lOP4=new JLabel();
        lOP4.setBounds(700, 150, 500, 500); 
        lOP4.setOpaque(false);
        lOP4.setIcon(iOP4);
        
		add(lIcon);
		add(btnBack);
		add(btnUsar);
		add(nombre);
		add(txtNombre);
		add(btnUsar2);
		add(btnFacil);
		add(btnMedio);
		add(btnMuerte);
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("assets/fondoVacio.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
	public void ocultarPinguinos(JLabel a,JLabel b,JLabel c) {
		remove(a);
		remove(b);
		remove(c);
        revalidate();
        repaint();
	} 
	public void retirar() {
		remove(lIcon);
		remove(btnBack);
		remove(btnUsar);
		remove(nombre);
		remove(txtNombre);
		remove(btnUsar2);
		remove(btnFacil);
		remove(btnMedio);
		remove(btnMuerte);
		remove(llP);
		remove(lPuntajes);
	}
	
	public JButton getBtnFacil() {
		return btnFacil;
	}
	public void setBtnFacil(JButton btnFacil) {
		this.btnFacil = btnFacil;
	}
	public JButton getBtnMedio() {
		return btnMedio;
	}
	public void setBtnMedio(JButton btnMedio) {
		this.btnMedio = btnMedio;
	}
	public JButton getBtnMuerte() {
		return btnMuerte;
	}
	public void setBtnMuerte(JButton btnMuerte) {
		this.btnMuerte = btnMuerte;
	}
	public JButton getBtnUsar2() {
		return btnUsar2;
	}
	public void setBtnUsar2(JButton btnUsar2) {
		this.btnUsar2 = btnUsar2;
	}
	public JLabel getlOP1() {
		return lOP1;
	}
	public void setlOP1(JLabel lOP1) {
		this.lOP1 = lOP1;
	}
	public JLabel getlOP2() {
		return lOP2;
	}
	public void setlOP2(JLabel lOP2) {
		this.lOP2 = lOP2;
	}
	public JLabel getlOP3() {
		return lOP3;
	}
	public void setlOP3(JLabel lOP3) {
		this.lOP3 = lOP3;
	}
	public JLabel getlOP4() {
		return lOP4;
	}
	public void setlOP4(JLabel lOP4) {
		this.lOP4 = lOP4;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}
	public JButton getBtnUsar() {
		return btnUsar;
	}
	public void setBtnUsar(JButton btnUsar) {
		this.btnUsar = btnUsar;
	}
	public JTextArea getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextArea txtNombre) {
		this.txtNombre = txtNombre;
	}
}