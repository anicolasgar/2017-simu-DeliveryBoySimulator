import java.util.Random;

/**
 * Created by anicolasgarcia on 5/8/17.
 */
public class FdpTA extends Fdp {
    public FdpTA(Double a, Double b, Double m) {
        super(a, b, m);
    }

    @Override
    public Double get() {
        Random r = new Random();
        return ((r.nextDouble() * (b - a)) + a);
    }
}
