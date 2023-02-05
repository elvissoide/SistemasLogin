import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class converter  extends JFrame {

    private JPanel panel1;

    private JTextField txtName;
    private JSpinner SpSize;
    private JComboBox comboBoxModelo;
    private JLabel JSize;
    private JLabel JModelo;
    private JButton calcularJButton;

    private JLabel JTalla;
    private JTextArea txtAreaMensaje;
    private JLabel JMarca;

    public converter(){

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Convertidor de Tallas");
        setResizable(false);

        //Inicializar el SpinnerSize
        String[] centimetros = {"22", "22.5", "23", "23.5", "24", "24.5", "25", "25.5", "26", "26.5", "27", "27.5", "28", "28.5", "29", "29.5"};
        SpinnerListModel tallas = new SpinnerListModel(Arrays.asList(centimetros));
        SpSize.setModel(tallas);



        // Restringir entrada en txtName a solo letras
        ((AbstractDocument) txtName.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[a-zA-Z]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });


        //Accio al presionar el boton de agregar
        calcularJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String nameShoe = txtName.getText();
                 Object Size = SpSize.getValue();
                String modelo = (String) comboBoxModelo.getSelectedItem();
                double tallaUSA = converterTOUSASize(String.valueOf(Size));
               txtAreaMensaje.setText("El zapato:  "+nameShoe+"\n"
                       +"Es un modelo:  "+modelo+"\n"
               +"Su talla en EEUU es:  "+tallaUSA);
               txtAreaMensaje.setLineWrap(true);
            }
        });
    }

    private double converterTOUSASize(String size){
        double[] centimetros = {22, 22.5, 23, 23.5, 24, 24.5, 25, 25.5, 26, 26.5, 27, 27.5, 28, 28.5, 29, 29.5};
        double[] tallasEEUU = {5, 5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 11.5, 12, 12.5};
        double tallaUSA = 0;

        for (int i = 0; i < centimetros.length; i++) {
            if (centimetros[i] == Double.parseDouble(size)) {
                tallaUSA = tallasEEUU[i];
                break;
            }
        }
        return tallaUSA;
    }


    public static void main(String[] args) {
        JFrame frame = new converter();
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
