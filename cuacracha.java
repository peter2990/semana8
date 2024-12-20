import java.util.Random;

abstract class Insecto {
    protected String nombre;
    protected int edad;
    protected boolean vivo;

    public Insecto(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.vivo = true;
    }

    public abstract void alimentarse();
    public abstract void moverse();

    public void crecer() {
        if (vivo) {
            edad++;
            System.out.println(nombre + " ahora tiene " + edad + " días de vida.");
            if (edad > 30) {  // Por ejemplo, 30 días es la esperanza de vida de la cucaracha
                morir();
            }
        }
    }

    public void morir() {
        vivo = false;
        System.out.println(nombre + " ha muerto.");
    }

    public boolean estaVivo() {
        return vivo;
    }
}


class Cucaracha extends Insecto {

    public Cucaracha(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void alimentarse() {
        if (vivo) {
            System.out.println(nombre + " está comiendo migajas.");
        } else {
            System.out.println(nombre + " no puede comer porque está muerta.");
        }
    }

    @Override
    public void moverse() {
        if (vivo) {
            System.out.println(nombre + " está corriendo rápidamente.");
        } else {
            System.out.println(nombre + " no se puede mover porque está muerta.");
        }
    }

    public void esconderse() {
        if (vivo) {
            System.out.println(nombre + " se está escondiendo.");
        } else {
            System.out.println(nombre + " no puede esconderse porque está muerta.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Cucaracha cucaracha = new Cucaracha("Cuca", 1);
        Random random = new Random();

        while (cucaracha.estaVivo()) {
            int accion = random.nextInt(4);  // Genera un número aleatorio entre 0 y 3

            switch (accion) {
                case 0:
                    cucaracha.alimentarse();
                    break;
                case 1:
                    cucaracha.moverse();
                    break;
                case 2:
                    cucaracha.esconderse();
                    break;
                case 3:
                    cucaracha.crecer();
                    break;
            }

            try {
                Thread.sleep(1000);  // Pausa de 1 segundo para simular el paso del tiempo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fin de la simulación de la vida de la cucaracha.");
    }
}
