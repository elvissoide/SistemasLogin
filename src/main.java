import modelo.DatosCompartidos;
import vista.VistaLogin;

public class main {
    static int idusuario = 0;
    public static void main(String[] args) {
        DatosCompartidos dc = new DatosCompartidos();
        VistaLogin vl = new VistaLogin(dc);
        vl.setVisible(true);
    }

}
