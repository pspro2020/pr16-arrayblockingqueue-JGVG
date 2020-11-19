package friegaplatos;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;

public class Bandeja {
    private final ArrayBlockingQueue<Plato> bandeja_platos = new ArrayBlockingQueue<>(10);

    public Bandeja( int num_platos) throws InterruptedException {
        for(int i = 0; i<num_platos; i++){
            bandeja_platos.put(new Plato(i+1));
        }
    }

    public Plato sacar(String nombre) throws InterruptedException {
        Plato plato;

        plato = bandeja_platos.take();
        System.out.println(nombre+" ha cogido el "+plato.toString()+" -> "+ LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());
        return plato;
    }

    public void colocar(Plato plato, String nombre) throws InterruptedException {
        System.out.println(nombre + " ha colocado el " +plato.toString()+" en bandeja -> "+ LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());
        bandeja_platos.put(plato);
    }
}
