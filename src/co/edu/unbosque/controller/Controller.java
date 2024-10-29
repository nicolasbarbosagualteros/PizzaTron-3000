package co.edu.unbosque.controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

public class Controller implements ActionListener , MouseListener, MouseMotionListener {

	private Ventana v;
	private VentanaJuego vj;
    private Memoria guardar;
    private Restaurante hacer;
    private Cliente hacer2;
    private int[] pizza;
    private int bandera,opcion=1,cordinante;
    private String ruta1,ruta2,ruta3,ruta4,ruta5,ruta6,ruta7,nombre="felipe";
    private boolean modo = true,mousePresionado,parar = false; 
    private Clip audio;
    
    public void controller() {
    	guardar = new Memoria();
    	hacer = new Restaurante();
    	hacer2 = new Cliente();
        v=new Ventana();
        vj=new VentanaJuego();

        	v.inicializa();
        	v.setVisible(true);
            v.limpiarPaneles();
            v.repaint();
            v.revalidate();
            run();
    }
    
    public void asignarOyentes() {
        v.getPanelP().getBtnJugar().addActionListener(this);
        v.getPanelP().getBtnJugar().setActionCommand("10");       
        v.getPanelP().getBtnSalir().addActionListener(this);
        v.getPanelP().getBtnSalir().setActionCommand("50");       
        v.getPanelP().getBtnTutorial().addActionListener(this);
        v.getPanelP().getBtnTutorial().setActionCommand("20");       
        v.getPanelP().getBtnPuntajes().addActionListener(this);
        v.getPanelP().getBtnPuntajes().setActionCommand("30");        
        v.getPanelP().getBtnMusica().addActionListener(this);
        v.getPanelP().getBtnMusica().setActionCommand("40");  
        v.getPanelP().getBtnPizza().addActionListener(this);
        v.getPanelP().getBtnPizza().setActionCommand("60");
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		opcion=2;
		String com=e.getActionCommand();
		if(com=="back") {
			v.getPanelE().getBtnBack().addActionListener(this);
			com=e.getActionCommand();
			v.inicializaPA();
			asignarOyentes();
			System.out.println(com);
			com=e.getActionCommand();
			opcion=1;
		}
		if (com.equals("fa") || com.equals("me") || com.equals("di")) {
			v.limpiarPaneles();
			run();
		}
		if (opcion ==1) {
				switch (com) {
				case "10":
					/*v.inicializaPP();
					v.getPanelE().getBtnBack().addActionListener(this);
					v.getPanelE().getBtnBack().setActionCommand("back");
					v.getPanelE().getBtnUsar().addActionListener(this);
					v.getPanelE().getBtnUsar().setActionCommand("usar1");
					
					
					v.getPanelE().getBtnUsar2().addActionListener(this);
					v.getPanelE().getBtnUsar2().setActionCommand("usar2");
					v.getPanelE().getBtnFacil().addActionListener(this);
					v.getPanelE().getBtnFacil().setActionCommand("fa");
					v.getPanelE().getBtnMedio().addActionListener(this);
					v.getPanelE().getBtnMedio().setActionCommand("me");
					v.getPanelE().getBtnMuerte().addActionListener(this);
					v.getPanelE().getBtnMuerte().setActionCommand("di");
					nombre=v.getPanelE().getTxtNombre().getText();*/
					v.setVisible(false);
					opcion++;
					run();
					break;
				case "20":
					v.inicializaPT();
		    		v.getPanelE().getBtnBack().addActionListener(this);
					break;
				case "30":
					try {
						v.inicializaP(guardar.sacar());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		    		v.getPanelE().getBtnBack().addActionListener(this);
		    		
		    		try {
						v.getPanelE().puntajes(guardar.sacar());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					break;
				case "40":
					ImageIcon m=new ImageIcon();
					JButton n=new JButton();
					if (audio != null && audio.isRunning()) {
						audio.stop();
						m = new ImageIcon("assets/btnMusica2.png");
					} else {
						ControlMusica("assets/musica.wav", true);
						m = new ImageIcon("assets/btnMusica1.png");
					}
					n = v.getPanelP().getBtnMusica(); 
					n.setIcon(m);		        
					v.getPanelP().revalidate();
					v.getPanelP().repaint();
					break;
				case "50":
					System.exit(0);
					break;
				case "60":
					ImageIcon a=new ImageIcon();
					JButton b=new JButton();
					if (modo == true) {
						modo = false;
						a = new ImageIcon("assets/pizzaDulce.png");
					} else {
						modo = true;
						a = new ImageIcon("assets/pizzaSalada.png");
					}
					b = v.getPanelP().getBtnPizza(); 
					b.setIcon(a);		        
					v.getPanelP().revalidate();
					v.getPanelP().repaint();
					break;
				}
				}
		
		if (opcion == 2 && bandera < pizza.length) {
			 switch(e.getActionCommand()) {
	            case "1": // Salsa 1
	                vj.setSabor(ruta1);
	                cordinante = 7;
	                break;
	            case "2": // Salsa 2
	                vj.setSabor(ruta2);
	                cordinante = 8;
	                break;
	            case "3": // Ingrediente 1 (o queso o su contraparte dulce)
	                vj.setSabor(ruta3);
	                cordinante = 9;
	                break;
	            case "4": // Ingrediente 1 (o queso o su contraparte dulce)
	                vj.setSabor(ruta4);
	                cordinante = 0;
	                break;
	            case "5": // Ingrediente 1 (o queso o su contraparte dulce)
	                vj.setSabor(ruta5);
	                cordinante = 1;
	                break;
	            case "6": // Ingrediente 1 (o queso o su contraparte dulce)
	                vj.setSabor(ruta6);
	                cordinante = 2;
	                break;
	            case "7": // Ingrediente 1 (o queso o su contraparte dulce)
	                vj.setSabor(ruta7);
	                cordinante = 3;
	                break;
	        }
	        vj.getIngrediente().setIcon(vj.getSabor());
	        Point mousePos = MouseInfo.getPointerInfo().getLocation();
	        vj.getIngrediente().setLocation(mousePos.x-100, mousePos.y-80);
	        vj.getIngrediente().setVisible(true);
		 }	
	}

	public void run() {
        int dificultad = 5,delay = 20000,bandera2,bandera3=0,fila,columna,valor;
        boolean rep = true,rep2 = true; // variable para que el juego se repita o que cambie de modo
        String texto2 = "",texto3 = "",texto4 = "";
        opcion = 2;
        resetear();
        while (rep) {
            switch (opcion) { // el juego por defecto muestra el menu hasta que se elija una opcion
                case 1: // opcion para ejecutar la ventana de ajustes
                    break;
                case 2:
                	if (modo == true) {
                        v.setAtras("assets/fondoSalado.png");
                        valor=27;
                    } else {
                        v.setAtras("assets/fondoDulce.png");
                        valor=32;
                    }
                	texto2 = "assets/maestroPinguichelin_cortado.png"; //en esta linea se elije la skin del usuario
                	cambio();
                    vj.informar();
                    vj.generar();
                	vj.presionar();
                	vj.pizzaGuia();
                	vj.chef(texto2);
                	
                	texto2 = "assets/btnPauzza.png";
                	vj.pausa(texto2);
                	
                    v.add(vj.getIngrediente());
                    v.add(vj.getGrupo1());
                    v.add(vj.getGrupo2());
                    v.add(vj.getGrupo3());
                    v.add(vj.getChef());
                    v.add(vj.getGuia());
                    v.add(vj.getPila());
                    v.add(vj.getCuadro());
                    v.add(vj.getPizza());
                    v.add(vj.getPausa());

                    v.cargarFondo();
                    vj.pinguino();
                    v.add(vj.getPinguino());
             
                    vj.getBtn6().addActionListener(this);
                    vj.getBtn6().setActionCommand("2");
                    vj.getBtn7().addActionListener(this);
                    vj.getBtn7().setActionCommand("1");
                    vj.getBtn5().addActionListener(this);
                    vj.getBtn5().setActionCommand("3");
                	vj.getBtn1().addActionListener(this);
                    vj.getBtn1().setActionCommand("4");
                    vj.getBtn2().addActionListener(this);
                    vj.getBtn2().setActionCommand("5");
                    vj.getBtn3().addActionListener(this);
                    vj.getBtn3().setActionCommand("6");
                    vj.getBtn4().addActionListener(this);
                    vj.getBtn4().setActionCommand("7");
                    vj.getPausa().addActionListener(this);
                    vj.getPausa().setActionCommand("8");
                    vj.getIngrediente().addMouseListener(this);
                    v.repaint();
                    v.revalidate();
                    for (int i = 0;i<40;i++) { // repite el juego en ciclo para generar nuevas ordenes de pizza
                        vj.getPinguino().setBackground(Color.getHSBColor((float) Math.random(), 0.5f, 0.9f));
                        v.repaint();
                    	bandera = 0;
                        bandera2 = 0;
                        hacer.Pedir(dificultad);
                        hacer.traducir();
    	                vj.setSabor(ruta1);
    	                texto2 = "pizza "; 
                        if (hacer.getOrden()[0]==8) {
                        	texto2 += "picante de ";
        	                vj.setSabor(ruta2);
                        }
                        else {
                        	texto2 += "de ";
                        }
                        vj.getIngrediente().setBounds(100, 300, 100, 100); // Cambia el tamaño del JLabel a 90x90	    		
        	            vj.setSabor(new ImageIcon(vj.getSabor().getImage().getScaledInstance(279, 260, Image.SCALE_SMOOTH)));
        	            vj.getIngrediente().setIcon(vj.getSabor());
        	            vj.setMasa(vj.concatenarImagenes(vj.getMasa(), vj.getSabor(), 10, 20));
    	                vj.setSabor(ruta3);
        	            vj.getIngrediente().setBounds(100, 300, 100, 100); // Cambia el tamaño del JLabel a 90x90	    		
        	            vj.setSabor(new ImageIcon(vj.getSabor().getImage().getScaledInstance(279, 260, Image.SCALE_SMOOTH)));
        	            vj.getIngrediente().setIcon(vj.getSabor());
        	            vj.setMasa(vj.concatenarImagenes(vj.getMasa(), vj.getSabor(), 10, 20));    
        	            vj.getGuia().setBounds(225,35,180,180);
        	            vj.setMasa(new ImageIcon(vj.getMasa().getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
        		        vj.getGuia().setIcon(vj.getMasa());
                        vj.resetMasa();
                        vj.getPila().removeAll();
                        for(int r = 0; r < hacer.getA(); r++) {
                        	vj.setSabor(ruta4);
                            vj.setBase(new ImageIcon(vj.getSabor().getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                            vj.setIngredienteLabel(new JLabel(vj.getBase()));
                            fila = vj.getPila().getWidth();
                            columna = vj.getPila().getHeight();
                            Dimension tamañoLabel = new Dimension(fila --, columna--);
                            vj.getIngredienteLabel().setPreferredSize(tamañoLabel);
                            vj.getPila().add(vj.getIngredienteLabel());
                        }
        		        for(int r = 0;r<hacer.getB();r++) {
        		        	vj.setSabor(ruta5);
                            vj.setBase(new ImageIcon(vj.getSabor().getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                            vj.setIngredienteLabel(new JLabel(vj.getBase()));
                            int ancho = vj.getPila().getWidth();
                            int alto = vj.getPila().getHeight();
                            Dimension tamañoLabel = new Dimension(ancho--, alto --);
                            vj.getIngredienteLabel().setPreferredSize(tamañoLabel);
                            vj.getPila().add(vj.getIngredienteLabel());
        		        }
        		        for(int r = 0;r<hacer.getC();r++) {
        		        	vj.setSabor(ruta6);
                            vj.setBase(new ImageIcon(vj.getSabor().getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                            vj.setIngredienteLabel(new JLabel(vj.getBase()));
                            int ancho = vj.getPila().getWidth();
                            int alto = vj.getPila().getHeight();
                            Dimension tamañoLabel = new Dimension(ancho --, alto --);
                            vj.getIngredienteLabel().setPreferredSize(tamañoLabel);
                            vj.getPila().add(vj.getIngredienteLabel());        		        }
        		        for(int r = 0;r<hacer.getD();r++) {
        		        	vj.setSabor(ruta7);
                            vj.setBase(new ImageIcon(vj.getSabor().getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                            vj.setIngredienteLabel(new JLabel(vj.getBase()));
                            int ancho = vj.getPila().getWidth();
                            int alto = vj.getPila().getHeight();
                            Dimension tamañoLabel = new Dimension(ancho --, alto --);
                            vj.getIngredienteLabel().setPreferredSize(tamañoLabel);
                            vj.getPila().add(vj.getIngredienteLabel());        		        
                            }
                        if(hacer.getRejistro()[0]!=null) {//estos cuatro ifs crean la reseta en un solo string
                            texto3 += hacer.getRejistro()[0]+" "+ruta4.substring(7, ruta4.length()-4)+"\n";
                            texto2 += ruta4.substring(7, ruta4.length()-4);
                            bandera2 +=1;
                        }
                        if(hacer.getRejistro()[1]!=null) {
                        	texto3 += hacer.getRejistro()[1]+" "+ruta5.substring(7, ruta5.length()-4)+"\n";
                        	if(bandera2 > 0) {
                        		texto2 +=" y ";
                        	}
                            texto2 += ruta5.substring(7, ruta5.length()-4);
                            bandera2 +=1;
                        }
                        if(hacer.getRejistro()[2]!=null) {
                        	texto3 += hacer.getRejistro()[2]+" "+ruta6.substring(7, ruta6.length()-4)+"\n";
                        	if(bandera2 > 0) {
                        		texto2 +=" y ";
                        	}
                            texto2 += ruta6.substring(7, ruta6.length()-4);
                            bandera2 +=1;
                        }
                        if(hacer.getRejistro()[3]!=null) {
                        	texto3 += hacer.getRejistro()[3]+" "+ruta7.substring(7, ruta7.length()-4);
                        	if(bandera2 > 0) {
                        		texto2 +=" con ";
                        	}
                            texto2 += ruta7.substring(7, ruta7.length()-4);
                        }
                        texto4 = "vidas : "+hacer2.getRating()+"\npizzas faltantes : "+(40-i)+"\npizzas hechas : "+bandera3;
                        System.out.println(texto2);
                        vj.getTipo().setText(texto2);
                        vj.getReseta().setText(texto3);
                        vj.getInfo().setText(texto4);
                        vj.getPuntaje().setText("Coins : "+hacer.getPlata());
                        pizza = new int[hacer.getOrden().length];
                        v.revalidate();
                        v.repaint();
    	                while(parar == true) {
    	                	try {
                                Thread.sleep(1000); // retraso para dar un límite de tiempo para la creación de la pizza
                            } catch (InterruptedException a) {
                                a.printStackTrace();
                            }
    	                }
                        try {
                            Thread.sleep(delay); // retraso para dar un límite de tiempo para la creación de la pizza
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        hacer2.review(hacer.getOrden(), pizza, valor);
                        hacer.setPlata(hacer.getPlata() + hacer2.getDinero());
                        bandera3++;
                        texto3 = "";
                        vj.resetMasa();
                        vj.getPizza().setIcon(vj.getMasa());
                        if (hacer2.getRating() <= 0) {
                            i = 40;
                        }
                    }
                    try {
                        guardar.crear();
                        guardar.ingresar(nombre+" : "+hacer.getPlata() + " coins");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    v.getContentPane().removeAll();
                    v.getContentPane().setBackground(Color.BLACK);
                    vj.gameover();
                    v.getContentPane().add(vj.getChef());
                    v.getContentPane().revalidate();
                    v.repaint();
                    try {
                        Thread.sleep(5000); // retraso para dar un límite de tiempo para la creación de la pizza
                    } catch (InterruptedException a) {
                        a.printStackTrace();
                    }
                    opcion = 1;
                    break;
           
            }
        
        }
    }


    public void cambio() { //metodo que cambia direcciones de imagenes
    	if (modo == true) { //modo sal
    		ruta1 = "assets/salsaTomate.png"; //salsa1
    		ruta2 = "assets/salsaPicante.png"; //salsa2
    		ruta3 = "assets/Queso.png"; //queso 
    		ruta4 = "assets/Calamar.png"; //calamar
    		ruta5 = "assets/Pescado.png"; //pescado
    		ruta6 = "assets/Camaron.png"; //camaron 
    		ruta7 = "assets/Alga.png"; //alga
    	}
    	else { //modo dulce
    		ruta1 = "assets/salsaChocolate.png";
    		ruta2 = "assets/salsaFresa.png";
    		ruta3 = "assets/confites.png";
    		ruta4 = "assets/regaliz.png";
    		ruta5 = "assets/malvavisco.png";
    		ruta6 = "assets/grageas.png";
    		ruta7 = "assets/chipChocolate.png";
    	}
    }

    private void moverIngrediente(MouseEvent e) {
    	Point mousePos = e.getLocationOnScreen(); // Obtener posición absoluta del ratón
    	Point labelPos = vj.getIngrediente().getLocationOnScreen(); // Obtener posición absoluta del label
    	int deltaX = mousePos.x - labelPos.x;
    	int deltaY = mousePos.y - labelPos.y;
    	int newX = vj.getIngrediente().getX() + deltaX;
    	int newY = vj.getIngrediente().getY() + deltaY;
    	vj.getIngrediente().setLocation(newX-45, newY-40);
    }
    @Override
	public void mousePressed(MouseEvent e) {
	    mousePresionado = true;
	    vj.getIngrediente().addMouseMotionListener(this);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	    Point ingredienteLocationOnScreen = vj.getIngrediente().getLocationOnScreen();
	    Point pizzaLocationOnScreen = vj.getPizza().getLocationOnScreen();
	    int deltaX = ingredienteLocationOnScreen.x - pizzaLocationOnScreen.x;
	    int deltaY = ingredienteLocationOnScreen.y - pizzaLocationOnScreen.y;
	    vj.getIngrediente().setVisible(false);
	    Rectangle ingredienteBounds = vj.getIngrediente().getBounds();
	    Rectangle pizzaBounds = vj.getPizza().getBounds();
	    if (ingredienteBounds.intersects(pizzaBounds)) {
	    	if (cordinante > 6) {
	    		vj.getIngrediente().setBounds(deltaX, deltaY, 100, 100); // Cambia el tamaño del JLabel a 90x90	    		
	            vj.setSabor(new ImageIcon(vj.getSabor().getImage().getScaledInstance(279, 260, Image.SCALE_SMOOTH)));
	            vj.getIngrediente().setIcon(vj.getSabor());
	            vj.setMasa(vj.concatenarImagenes(vj.getMasa(), vj.getSabor(), 10, 20));
		        vj.getPizza().setIcon(vj.getMasa());
	    	}
	    	else {
	    		vj.setMasa(vj.concatenarImagenes(vj.getMasa(), vj.getSabor(), deltaX, deltaY));
		        vj.getPizza().setIcon(vj.getMasa());	
	    	}
	        pizza[bandera] = cordinante;
	        bandera++;
	    }
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if (mousePresionado) {
			moverIngrediente(e);
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
    public void resetear() {
    	hacer.setPlata(0);
    	hacer2.setRating(5);
    	hacer2.setDinero(0);
    	bandera = 0;
    }
    
	public void ControlMusica(String nombreArchivo,boolean music) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreArchivo).getAbsoluteFile());
			audio = AudioSystem.getClip();
			audio.open(audioInputStream);
			audio.loop(Clip.LOOP_CONTINUOUSLY);
		} 
		catch (Exception ex) {
			System.out.println("Error al reproducir la música= " + ex.getMessage());
		}
	}
	
}