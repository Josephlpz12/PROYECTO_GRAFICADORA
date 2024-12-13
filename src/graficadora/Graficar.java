/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graficadora;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author jose
 */
public class Graficar {
    
    public static Color obtenerColor(String color) {
        return switch (color) {
            case "rojo" -> Color.red;
            case "azul" -> Color.blue;
            case "celeste" -> new Color(135, 206, 235);
            case "verde" -> Color.green;
            case "negro" -> Color.black;
            case "morado" -> new Color(128, 0, 128);
            case "anaranjado" -> Color.orange;
            case "rosado" -> new Color(255, 192, 203);
            case "amarillo" -> Color.yellow;
            case "gris" -> Color.gray;
            case "cafe" -> new Color(139, 69, 19);
            default -> Color.black;
        };
    }

    
    public static void graficarCuadrado(int x, int y, int l, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        g.setColor(obtenerColor(color));
        
        if("rellena".equals(tipo)){
            g.fillRect(x, y, l, l);
        }else{
            g.drawRect(x, y, l, l);
        }
        
    }
    
    public static void graficarLinea(int x1, int y1, int x2, int y2, String color){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        g.setColor(obtenerColor(color));
        
        g.drawLine(x1, y1, x2, y2);
        
    }
        
    public static void graficarRectangulo(int x, int y, int b, int a, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        g.setColor(obtenerColor(color));
        
        if("rellena".equals(tipo)){
            g.fillRect(x, y, b, a);
        }else{
            g.drawRect(x, y, b, a);
        }
        
    }
    
    public static void graficarTrianguloRectangulo(int x, int y, int b, int a, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        g.setColor(obtenerColor(color));
        
        int [] xPoints = {x, x + b, x};
        int [] yPoints = {y, y, y - a};
        
        if("rellena".equals(tipo)){
            g.fillPolygon(xPoints, yPoints, 3);
        }else{
            g.drawPolygon(xPoints, yPoints, 3);
        }
        
    }
        
   public static void graficarCirculo(int x, int y, int radio, String color, String tipo) {
        Graphics g = Interfaz.jPanel1.getGraphics();

        g.setColor(obtenerColor(color));

        int topLeftX = x - radio;
        int topLeftY = y - radio;
        int diameter = radio * 2; 
    
        if("rellena".equals(tipo)){
        g.fillOval(topLeftX, topLeftY, diameter, diameter);  
        } else {
        g.drawOval(topLeftX, topLeftY, diameter, diameter);  
        }
    }
        
    public static void graficarOvalo(int x, int y, int ejex, int ejey,String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        g.setColor(obtenerColor(color));
        
        int topLeftX = x - (ejex / 2);  
        int topLeftY = y - (ejey / 2);  

        if("rellena".equals(tipo)){
        g.fillOval(topLeftX, topLeftY, ejex, ejey);  
        } else {
        g.drawOval(topLeftX, topLeftY, ejex, ejey);  
         }
         
    }
        
    public static void graficarEstrella(int x, int y, int p, String color, String tipo) {
        Graphics g = Interfaz.jPanel1.getGraphics();
        g.setColor(obtenerColor(color));
        int panelWidth = Interfaz.jPanel1.getWidth();
        int panelHeight = Interfaz.jPanel1.getHeight();
    
         p = p * 5;
    
        x = Math.max(p, Math.min(x, panelWidth - p));
        y = Math.max(p, Math.min(y, panelHeight - p));
    
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
    
        int radioExterior = p;
        int radioInterior = p * 2/5;
    
        double angulo = Math.PI / 2;
        double incrementoAngulo = 2 * Math.PI / 10;
    
        for (int i = 0; i < 10; i++) {
            int radio = (i % 2 == 0) ? radioExterior : radioInterior;
        
            double currentAngle = angulo - (i * incrementoAngulo);
            xPoints[i] = (int) (x + radio * Math.cos(currentAngle));
            yPoints[i] = (int) (y - radio * Math.sin(currentAngle));
        }
    
        if ("rellena".equals(tipo.toLowerCase())) {
            g.fillPolygon(xPoints, yPoints, 10);
        } else {
            g.drawPolygon(xPoints, yPoints, 10);
        }
    }
        
    public static void graficarPoligono(int [] x,int[] y, int n, String color , String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
            
        g.setColor(obtenerColor(color));
        
        if("rellena".equals(tipo)){
            g.fillPolygon(x, y, n);
        }else{
            g.drawPolygon(x, y, n);
        }
        
        } 
     
    
    public static void graficarPacman(int x, int y, int p, String color, String tipo) {
    Graphics g = Interfaz.jPanel1.getGraphics();
        
        g.setColor(obtenerColor(color));

        int x0 = x - p;
        int y0 = y - p;
        int diametro = 2 * p;

        if ("rellena".equals(tipo)) {
            g.fillArc(x0, y0, diametro, diametro, x0-x, y0);
        } else {
            g.drawArc(x0, y0, diametro, diametro, x0-x, y0);
        }
    
    
    }
    
    
}
