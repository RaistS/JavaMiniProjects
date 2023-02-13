/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javawebcammaven;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author MarCardona
 */
public class Ventana extends JFrame {

    public JPanel panel;
    public JLabel etiqueta, imagen;
    public JButton boton1, boton2;

    public Ventana() {
        setVentana();
        iniciarComponentes();
    }

    private void setVentana() {
        setSize(600, 600);
        setTitle("Java Webcam");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setResizable(false);
        //this.setMinimumSize(new Dimension(200, 200));
        //this.setMaximumSize(new Dimension(600, 600));
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
    }

    private void colocarPaneles() {
        // página con información sobre los layouts http://chuwiki.chuidiang.org/index.php?title=Uso_de_Layouts
        // página con fuentes gratis http://www.1001freefonts.com/es/index.php
        // página con los tipos de borde que hay https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
        panel = new JPanel();
        //panel.setBackground(Color.BLUE);
        panel.setBackground(new Color(176, 196, 222));
        panel.setBounds(0, 0, 600, 600);

        panel.setLayout(null);

        /*try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }*/
        this.getContentPane().add(panel);
    }

    private void colocarBotones() {

        boton1 = new JButton("Iniciar");
        boton1.setBounds(50, 50, 100, 50);
        //boton1.setBorder(BorderFactory.createLineBorder(Color.yellow, 10, true));
        //boton1.setOpaque(true);
        //boton1.setBackground(Color.GREEN);
        boton1.setUI(new MetalButtonUI());
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para abrir la cámara y mostrar la imagen
                addWebcamPanel();
            }
        });
        panel.add(boton1);

        boton2 = new JButton("Apagar");
        boton2.setBounds(200, 50, 100, 50);
        //boton2.setBorder(BorderFactory.createLineBorder(Color.yellow, 10, true));
        //boton2.setOpaque(true);
        //boton2.setBackground(Color.BLUE);
        boton2.setUI(new MetalButtonUI());
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para cerrar la cámara
                removeWebcamPanel();
            }
        });
        panel.add(boton2);
    }
    private WebcamPanel webcamPanel;
    Webcam webcam = Webcam.getDefault();

    private void addWebcamPanel() {

        webcam.setViewSize(new Dimension(640, 480));
        webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        webcamPanel.setBounds(100, 150, 400, 300);
        panel.add(webcamPanel);
    }

    private void removeWebcamPanel() {
        panel.remove(webcamPanel);
        panel.repaint();
        webcam.close();
    }

    private void iniciarComponentes() {
        colocarPaneles();
        //colocarEtiquetas();
        colocarBotones();
        //addWebcamPanel();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }

}
