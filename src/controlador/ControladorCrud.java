package controlador;

import modelo.*;
import vista.VistaCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorCrud implements ActionListener {
    private DatosCompartidos dc;
    UsuarioCrud crud = new UsuarioCrud();
    VistaCrud vistaCrud = new VistaCrud(dc);
    DefaultTableModel modelo = new DefaultTableModel();
    Usuario usuario = new Usuario();

    public ControladorCrud(VistaCrud v){
        this.vistaCrud = v;
        this.vistaCrud.listarButton.addActionListener(this);
        this.vistaCrud.guardarButton.addActionListener(this);
        this.vistaCrud.editarButton.addActionListener(this);
        this.vistaCrud.actualizarButton.addActionListener(this);
        this.vistaCrud.eliminarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCrud.listarButton){
            listar(vistaCrud.tabla);
        }
        if (e.getSource() == vistaCrud.guardarButton){
            agregar();
            //limpiarTabla();
            System.out.println(vistaCrud.tabla.getRowCount());

            listar(vistaCrud.tabla);
        }
        if (e.getSource() == vistaCrud.editarButton){
            vistaCrud.idtextField.setEnabled(false);
            int fila = vistaCrud.tabla.getSelectedRow();
            if (fila==-1){
                JOptionPane.showMessageDialog(null,"Debe seleccionar una fila");
            } else {
                int id = Integer.parseInt(String.valueOf(vistaCrud.tabla.getValueAt(fila,0)));
                String nombre = String.valueOf(vistaCrud.tabla.getValueAt(fila,1));
                String apellido = String.valueOf(vistaCrud.tabla.getValueAt(fila,2));
                String correo = String.valueOf(vistaCrud.tabla.getValueAt(fila,3));
                String telefono = String.valueOf(vistaCrud.tabla.getValueAt(fila,4));
                vistaCrud.idtextField.setText(String.valueOf(id));
                vistaCrud.nombretextField.setText(nombre);
                vistaCrud.apellidotextField.setText(apellido);
                vistaCrud.correotextField.setText(correo);
                vistaCrud.telefonotextField.setText(telefono);
            }
        }
        if (e.getSource()==vistaCrud.actualizarButton){
            actualizar();
            vistaCrud.idtextField.setEnabled(true);
        }
        if (e.getSource()==vistaCrud.eliminarButton){
            int fila = vistaCrud.tabla.getSelectedRow();
            if (fila == -1){
                JOptionPane.showMessageDialog(null,"Debe seleccionar una fila");
            } else{
                int id = Integer.parseInt(vistaCrud.tabla.getValueAt(fila,0).toString());
                crud.eliminar(id);
                JOptionPane.showMessageDialog(null,"Usuario eliminado");
            }
        }
    }

    public void actualizar(){
        int id = Integer.parseInt(vistaCrud.idtextField.getText());
        String nombre = vistaCrud.nombretextField.getText();
        String apellido = vistaCrud.apellidotextField.getText();
        String celular = vistaCrud.telefonotextField.getText();
        String correo = vistaCrud.correotextField.getText();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(celular);
        usuario.setCorreo(correo);
        if (crud.actualizar(usuario)==1){
            JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Error, no se pudo actualizar el usuario");
        }
    }
    public void agregar(){
        String id = vistaCrud.idtextField.getText();
        String nombre = vistaCrud.nombretextField.getText();
        String apellido = vistaCrud.apellidotextField.getText();
        String celular = vistaCrud.telefonotextField.getText();
        String correo = vistaCrud.correotextField.getText();
        usuario.setId(Integer.parseInt(id));
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(celular);
        usuario.setCorreo(correo);
        if (crud.agregar(usuario) == 1){
            JOptionPane.showMessageDialog(null, "USUARIO AGREGADO");
        } else{
            JOptionPane.showMessageDialog(null, "ERROR, NO SE PUDO AGREGAR EL USUARIO");
        }
    }
    public void listar(JTable tabla){
        List <Usuario> lista = crud.listar();
        Object[] objeto = new Object[5];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        for (int i=0; i<lista.size(); i++){
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getApellido();
            objeto[3] = lista.get(i).getCorreo();
            objeto[4] = lista.get(i).getTelefono();
            modelo.addRow(objeto);
        }
        vistaCrud.tabla.setModel(modelo);
        System.out.println("\n\t ===== DATOS ENLISTADOS =====");
    }

}
