public class Reloj {
    private int hora, minuto, segundo;

    public Reloj() {
        this.hora = 12;
        this.minuto = 0;
        this.segundo = 0;
    }

    public Reloj(int hora, int minuto, int segundo) {
        if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59 || segundo < 0 || segundo > 59) {
            System.out.println("Hora, minuto o segundo no validos");
        }
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public Reloj(int valorSegundosMedianoche) {
        if (valorSegundosMedianoche < 0 || valorSegundosMedianoche > 86399) // 0 = 00:00:00 - 86399 = 23:59:59
            System.out.println("Valor no valido");

        this.hora = valorSegundosMedianoche / 3600; // 1 hora = 3600 segundos
        this.minuto = (valorSegundosMedianoche % 3600) / 60;
        this.segundo = valorSegundosMedianoche % 60;
    }

    public void setReloj(int valorSegundosMedianoche) {
        if (valorSegundosMedianoche < 0 || valorSegundosMedianoche > 86399) //1 dia = 86400 segundos
            System.out.println("Valor no valido");
        this.hora = valorSegundosMedianoche / 3600; // 1 hora = 3600 segundos
        this.minuto = (valorSegundosMedianoche % 3600) / 60;
        this.segundo = valorSegundosMedianoche % 60;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    public void tick() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            minuto++;
            if (minuto == 60) {
                minuto = 0;
                hora++;
                if (hora == 24) {
                    hora = 0;
                }
            }
        }
    }

    public void addReloj(Reloj otroReloj) {
        this.segundo += otroReloj.getSegundo();
        this.minuto += otroReloj.getMinuto();
        this.minuto +=(int)(this.segundo/60);
        this.segundo = this.segundo % 60;
        this.hora += otroReloj.getHora();
        this.hora +=(int)(this.minuto/60);
        this.minuto = this.minuto % 60;
        this.hora = this.hora % 24;

    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public void tickDecrement() {
        segundo--;
        if (segundo == -1) {
            segundo = 59;
            minuto--;
            if (minuto == -1) {
                minuto = 59;
                hora--;
                if (hora == -1) {
                    hora = 23;
                }
            }
        }
    }

    public void restaReloj(Reloj otroReloj) {
        int totalSegundosActual = this.hora * 3600 + this.minuto * 60 + this.segundo;
        int totalSegundosOtro = otroReloj.getHora() * 3600 + otroReloj.getMinuto() * 60 + otroReloj.getSegundo();
        int diferenciaSegundos = totalSegundosActual - totalSegundosOtro;

        //Este si consideramos solamente diferencia entre ambos sin tener en cuenta que haya pasado un dia
        if (diferenciaSegundos < 0) {
            diferenciaSegundos *= -1;
        }

        /*
        Esta parte por si consideramos que paso un dia
        if (diferenciaSegundos < 0) {
            diferenciaSegundos += 86400;
        }
        */

        this.hora = diferenciaSegundos / 3600;
        this.minuto = (diferenciaSegundos % 3600) / 60;
        this.segundo = diferenciaSegundos % 60;

    }
}
