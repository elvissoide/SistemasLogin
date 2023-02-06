package vista;

import modelo.DatosCompartidos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCrud extends JFrame{
    public JTextField telefonotextField;
    public JTextField correotextField;
    public JTextField apellidotextField;
    public JTextField nombretextField;
    public JTextField idtextField;
    public JButton eliminarButton;
    public JButton editarButton;
    public JButton guardarButton;
    public JButton listarButton;
    public JButton actualizarButton;
    public JTable tabla;
    public JPanel panelCrud;
    private JButton regresarButton;
    private DatosCompartidos dc;
    public VistaCrud(DatosCompartidos dc){
        this.dc = dc;
        setContentPane(panelCrud);
        pack();
        setTitle("Sistema CRUD");
        setLocation(600,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaOpciones vo = new VistaOpciones(dc);
                vo.setVisible(true);
                dispose();
            }
        });
    }

}
