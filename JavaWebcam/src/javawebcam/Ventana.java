/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebcam;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import com.github.sarxos.webcam.Webcam;


/**
 *
 * @author MarCardona
 */
public class Ventana extends JFrame {
    
    public JPanel panel;
    public JLabel etiqueta, imagen;
    public JButton boton;
    
    public Ventana() {
        setVentana();
        iniciarComponentes();
    }
    
    private void setVentana() {
        setSize(400, 400);
        setTitle("Mi primera ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setMinimumSize(new Dimension(200, 200));
        this.setMaximumSize(new Dimension(600, 600));
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
    }
    
    private void colocarPaneles() {
        // página con información sobre los layouts http://chuwiki.chuidiang.org/index.php?title=Uso_de_Layouts
        // página con fuentes gratis http://www.1001freefonts.com/es/index.php
        // página con los tipos de borde que hay https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
        panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setBounds(0, 0, 600, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
        
        
    }
    
    private void colocarEtiquetas() {
        etiqueta = new JLabel("Esto es una etiqueta", SwingConstants.CENTER);
        etiqueta.setBounds(10, 10, 400, 100);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBackground(Color.RED);
        etiqueta.setOpaque(true);
        // cambiar fuente del texto
        File fuente = new File("fuente.ttf");
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, fuente);
            Font sizedFont = font.deriveFont(40f); 
            etiqueta.setFont(sizedFont);
        } catch (FontFormatException ex) {
            System.err.println("Error en font format");
        } catch (IOException ex) {
            System.err.println("Error de entrada/salida");
        }
        panel.add(etiqueta);
        
        // imagen
        ImageIcon emoticono = new ImageIcon("emoticono.jpg");
        imagen = new JLabel();
        imagen.setBounds(100, 110, 250, 250);
        imagen.setIcon(new ImageIcon(emoticono.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(imagen);
    }
    
    private void colocarBotones() {
        boton = new JButton("Botón");
        boton.setBounds(100, 160, 200, 80);
        boton.setBorder(BorderFactory.createLineBorder(Color.yellow, 10, true));
        boton.setOpaque(true);
        boton.setBackground(Color.GREEN);
        panel.add(boton);
    }
    
    private void addWebcamPanel() {
    Webcam webcam = Webcam.getDefault();
    webcam.setViewSize(new Dimension(640, 480));
    WebcamPanel webcamPanel = new WebcamPanel(webcam);
    webcamPanel.setBounds(100, 160, 640, 480);
    panel.add(webcamPanel);
}

    

    private void iniciarComponentes() {
        colocarPaneles();
        //colocarEtiquetas();
        colocarBotones();
        addWebcamPanel();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
    
}