import javax.swing.*;

public class RelojDemo {
    public static void main(String[] args) {
        valorSegundos();
        conteoTick();
        restaReloj();
    }

    public static void valorSegundos() {
        int segundos = 0;
        do {
            segundos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los segundos correspondientes a una hora especifica\n- Los valores deben estar en el rango de [0 - 864000]"));
        } while (segundos < 0 || segundos > 86399);
        Reloj reloj = new Reloj(segundos);

        JOptionPane.showMessageDialog(null, "Hora equivalente: " + reloj.toString());
    }

    public static void conteoTick() {
        Reloj reloj = new Reloj(14, 59, 58);
        int cont = 0;
        while (cont < 10) {
            reloj.tick();
            System.out.println(reloj.toString());
            cont++;
        }
    }

    public static void restaReloj() {
        Reloj reloj = new Reloj(14, 23, 35);
        Reloj reloj2 = new Reloj(17, 51, 12);

        reloj.restaReloj(reloj2);
        JOptionPane.showMessageDialog(null, "Valor correspondiente a la diferencia entre [14:23:53] y [17:51:12] es:\n" + reloj.toString());
    }
}
