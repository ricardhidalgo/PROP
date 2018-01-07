package Logic;

import Presentation.Screen;

import java.awt.*;

public class Controlador {

    private static void iniciar() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Screen miVentanaPrincipal = new Screen(screenSize.width, screenSize.height); // Autoajusta la pantalla


    }

    public static void main(String args[]) {
        iniciar();
    }


}
