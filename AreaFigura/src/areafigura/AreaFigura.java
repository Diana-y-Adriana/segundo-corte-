/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package areafigura;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author diana poveda  y adriana bonilla
 */
public class AreaFigura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        BufferedImage img = null;
        try {
            JFileChooser filechooser = new JFileChooser();
            File archivo;
            if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                archivo = filechooser.getSelectedFile();

            } else {
                //no se selecciono archivo termina
                return;
            }
            
            if (
                  !(  archivo.getName().toLowerCase().endsWith(".jpg") ||
                    archivo.getName().toLowerCase().endsWith(".gif") ||
                    archivo.getName().toLowerCase().endsWith(".png") ||
                    archivo.getName().toLowerCase().endsWith(".jpeg") ||
                    archivo.getName().toLowerCase().endsWith(".bmp") )
                    ) {
                //si no termina con la extension de imagen requerida termina
                JOptionPane.showMessageDialog(null, "Archivo no permitido.");
                return;
            }
            
            //pasa el archivo a el bufferImage
            img = ImageIO.read(archivo);

            int[][] matriz = new int[img.getHeight()][img.getWidth()];
            for (int h = 0; h < img.getHeight(); h++) {
                for (int w = 0; w < img.getWidth(); w++) {
                    matriz[h][w] = img.getRGB(w, h);
                }
            }
            //crea una imagen con las dimensiones de la original
            BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

            //rechana la imagen con pixeles blancos
            for (int h = 0; h < img.getWidth(); h++) {
                for (int w = 0; w < img.getHeight(); w++) {
                    img2.setRGB(h, w, Color.WHITE.getRGB());
                }
            }


            int ANCHO = img.getWidth();
            int ALTO = img.getHeight();
            Random generador = new Random();
            int n = 1000000;
            //solicita numero de puntos a generar
            String string = JOptionPane.showInputDialog("numero de puntos a generar?");
            try {
                n = Integer.parseInt(string);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "valor invalido.");
                return;
            }
            
            int puntosArea = 0;
            for (int i = 0; i < n; i++) {
                //coordenadas aleatorias
                int x = (int) (generador.nextDouble() * ANCHO);
                int y = (int) (generador.nextDouble() * ALTO);
                //revisa el color del pixel en la posicion
                //si es negro, el punto lo coloca en la nueva imagen
                if (img.getRGB(x, y) <= -8000000) {
                    img2.setRGB(x, y, Color.BLACK.getRGB());
                    puntosArea++;
                }
            }
            double porcentaje = 100 * puntosArea / n;
            System.out.println(porcentaje);
            int area = (int) ((ANCHO * ALTO) * porcentaje / 100);
            System.out.println("area figura = " + area);
            int areatotal = (ANCHO * ALTO);
            System.out.println("area imagen = " + areatotal);


            JFrame frame = new JFrame();
            frame.setPreferredSize(new Dimension(1250, 650));
            frame.getContentPane().setLayout(new FlowLayout());

            //panel image 1
            JScrollPane panel1 = new JScrollPane();
            ImageIcon imageIcon1 = new ImageIcon(img);
            panel1.setPreferredSize(new Dimension(600, 600));
            panel1.setViewportView(new JLabel(imageIcon1));
            //panel image 2
            JScrollPane panel2 = new JScrollPane();
            ImageIcon imageIcon2 = new ImageIcon(img2);
            panel2.setPreferredSize(new Dimension(600, 600));
            panel2.setViewportView(new JLabel(imageIcon2));

            //panel.add(new JLabel());
            //panel.add(new JLabel(new ImageIcon(img2)));
            frame.getContentPane().add(panel1);
            frame.getContentPane().add(panel2);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            
            String mensaje="Porcentaje figura: "+porcentaje+"%\n";
             mensaje+="Area figura: "+area+" px^2\n";
             mensaje+="Area Total Imagen: "+areatotal+" px^2";
            
            JOptionPane.showMessageDialog(frame, mensaje);
        } catch (IOException e) {
        }
    }

}
