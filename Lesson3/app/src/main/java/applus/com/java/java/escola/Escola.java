package applus.com.java.java.escola;

/**
 * Created by brunopinheiro on 5/22/15.
 */
public class Escola {

    public final Sala[] salas;

    public Escola() {
        salas = new Sala[3];

        for (int i = 0; i < salas.length; i++) {
            salas[i] = new Sala(i);
        }
    }

}
