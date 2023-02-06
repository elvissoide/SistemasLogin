package vista;

import modelo.DatosCompartidos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaLogin extends JFrame{
    private JPanel panelLogin;
    private JTextField usuariotextField;
    private JPasswordField contrapasswordField;
    private JButton registrarButton;
    private DatosCompartidos dc;
    public VistaLogin(DatosCompartidos dc) {
        this.dc = dc;
        setContentPane(panelLogin);
        pack();
        setTitle("Registro de usuario");
        setLocation(600,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuariotextField.getText();
                char[] contra = contrapasswordField.getPassword();
                if (usuario.equals("elvis") && new String(contra).equals("123e")){
                    dc.setIdusuario(1);
                } else if (usuario.equals("wilson") && new String(contra).equals("123w")){
                    dc.setIdusuario(2);
                } else {
                    dc.setIdusuario(-1);
                    JOptionPane.showMessageDialog(null,"Datos ingresados incorrectos");
                }
                if (dc.getIdusuario()==1 || dc.getIdusuario()==2){
                    VistaOpciones vo = new VistaOpciones(dc);
                    vo.setVisible(true);
                    dispose();
                }
            }
        });
    }

}
