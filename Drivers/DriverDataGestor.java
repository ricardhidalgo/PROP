import Logic.Combination;
import Persistence.dataGestor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ricard.hidalgo
 */

public class DriverDataGestor {

    public static void main(String[] args) {
        Combination comb = new Combination();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Esta provando la clase DataGestor");
            while (true) {
                System.out.println();
                System.out.println("Indique qué desea hacer:");
                System.out.println("1. Generar nuevo usuario");
                System.out.println("2. Insertar puntuacion");
                System.out.println("3. Insertar partida");
                System.out.println("4. Borrar partida 2");
                System.out.println("5. Borrar puntuacion 2");
                System.out.println("6. Buscar usuario");
                System.out.println("7. Salir");
                dataGestor dg = new dataGestor();
                int op = sc.nextInt();
                switch (op) {
                    case 1:
                        dg.createUser("Ricard", "marica");
                        break;
                    case 2:
                        ArrayList<String> shit = new ArrayList<String>();
                        shit.add("Hard");
                        shit.add("010111");
                        dg.save("Ricard",shit,false);
                        break;
                    case 3:
                        ArrayList<String> shot = new ArrayList<String>();
                        shot.add("2300");
                        dg.save("Ricard",shot,true);
                        break;
                    case 4:
                        dg.deleteIndex("Ricard",0,false);
                        break;
                    case 5:
                        dg.deleteIndex("Ricard",1,true);
                        break;
                    case 6:
                        ArrayList<String> arr = dg.findUser("Ricardde");
                        System.out.println(arr.get(0));
                        System.out.println(arr.get(1));
                        break;
                    default:
                        System.out.println("Operación incorrecta");
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

