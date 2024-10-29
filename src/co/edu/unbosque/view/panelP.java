package co.edu.unbosque.view;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class panelP extends JPanel{
	private JButton btnJugar,btnSalir,btnTutorial,btnPuntajes,btnMusica,btnPizza;
	private ImageIcon iJugar,iSalir,iTutorial,iPuntajes,iMusica,iPizza;
	

	public panelP() {
		setLayout(null); 
		inicializaComponentes();
		setVisible(true);
	}
	
	private void inicializaComponentes() {
        iJugar=new ImageIcon("assets/btnJugar.png");
        iSalir=new ImageIcon ("assets/btnSalir.png");
        iTutorial=new ImageIcon("assets/btnTutorial.png");
        iPuntajes=new ImageIcon("assets/btnPuntajes.png");
        iMusica=new ImageIcon("assets/btnMusica1.png");
        iPizza=new ImageIcon("assets/pizzaSalada.png");
        
        btnJugar=new JButton(iJugar);
        btnJugar.setBounds(100, 490,  156, 64); 
        btnJugar.setOpaque(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setBorderPainted(false);
        btnJugar.setActionCommand("10");
        
        btnTutorial=new JButton(iTutorial);
        btnTutorial.setBounds(1000, 490,  173, 56); 
        btnTutorial.setOpaque(false);
        btnTutorial.setContentAreaFilled(false);
        btnTutorial.setBorderPainted(false);
        btnTutorial.setActionCommand("20");
        
        btnPuntajes=new JButton(iPuntajes);
        btnPuntajes.setBounds(1000, 590,  173, 56); 
        btnPuntajes.setOpaque(false);
        btnPuntajes.setContentAreaFilled(false);
        btnPuntajes.setBorderPainted(false);
        btnPuntajes.setActionCommand("30");
        
        btnSalir=new JButton(iSalir);
        btnSalir.setBounds(110, 590, 135, 56); 
        btnSalir.setOpaque(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setBorderPainted(false);
        btnSalir.setActionCommand("50");

        btnMusica=new JButton(iMusica);
        btnMusica.setBounds(1150, 1, 110, 110); 
        btnMusica.setOpaque(false);
        btnMusica.setContentAreaFilled(false);
        btnMusica.setBorderPainted(false);
        btnMusica.setActionCommand("40");
        
        btnPizza=new JButton(iPizza);
        btnPizza.setBounds(770, 400, 180, 177); 
        btnPizza.setOpaque(false);
        btnPizza.setContentAreaFilled(false);
        btnPizza.setBorderPainted(false);
        btnPizza.setActionCommand("60");
        
        add(btnPizza);
        add(btnJugar);
        add(btnTutorial);
        add(btnPuntajes);
        add(btnSalir);
        add(btnMusica);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("assets/fondoInicio.png");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
	public void retirar() {
		remove(btnJugar);
		remove(btnMusica);
		remove(btnPizza);
		remove(btnPuntajes);
		remove(btnSalir);
		remove(btnTutorial);
	}
	
	public ImageIcon getiPizza() {
		return iPizza;
	}
	public void setiPizza(ImageIcon iPizza) {
		this.iPizza = iPizza;
	}
	public JButton getBtnJugar() {
		return btnJugar;
	}
	public void setBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
	public JButton getBtnTutorial() {
		return btnTutorial;
	}
	public void setBtnTutorial(JButton btnTutorial) {
		this.btnTutorial = btnTutorial;
	}
	public JButton getBtnPuntajes() {
		return btnPuntajes;
	}
	public void setBtnPuntajes(JButton btnPuntajes) {
		this.btnPuntajes = btnPuntajes;
	}
	public JButton getBtnMusica() {
		return btnMusica;
	}
	public void setBtnMusica(JButton btnMusica) {
		this.btnMusica = btnMusica;
	}
	public JButton getBtnPizza() {
		return btnPizza;
	}
	public void setBtnPizza(JButton btnPizza) {
		this.btnPizza = btnPizza;
	}
}