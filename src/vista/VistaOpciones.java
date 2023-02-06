package vista;

import controlador.ControladorCrud;
import modelo.DatosCompartidos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class VistaOpciones extends JFrame{
    public JPanel panelOpciones;
    public JButton sistemaCrudButton;
    public JButton sistemaConversionButton;
    private JLabel nombreUsuario;
    private JLabel imagenLabel;
    private DatosCompartidos dc;
    public VistaOpciones(DatosCompartidos dc) {
        //Imagen Elvis
        String path = "/img/imagenE.jpg";
        URL url = getClass().getResource(path);
        ImageIcon imagen = new ImageIcon(url);
        Image imagenReducida = imagen.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        //Imagen Wilson
        String pathw = "/img/imageW.jpg";
        URL urlw = getClass().getResource(pathw);
        ImageIcon imagenw = new ImageIcon(urlw);
        Image imagenReducidaw = imagenw.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);

        setContentPane(panelOpciones);
        setSize(300,300);
        setTitle("Opciones del sistema");
        setLocation(600,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dc = dc;
        if (dc.getIdusuario()==1){
            nombreUsuario.setText("Elvis Guanoluisa");
            imagenLabel.setIcon(new ImageIcon(imagenReducida));
        } else if (dc.getIdusuario()==2){
            nombreUsuario.setText("Wilson Guayanay");
            imagenLabel.setIcon(new ImageIcon(imagenReducidaw));
        } else {
            nombreUsuario.setText("Desconocido");
        }

        sistemaCrudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaCrud vc = new VistaCrud(dc);
                ControladorCrud c = new ControladorCrud(vc);
                vc.setVisible(true);
                dispose();
            }
        });
        sistemaConversionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaConversion vco = new VistaConversion(dc);
                vco.setVisible(true);
                dispose();
            }
        });
    }


}
