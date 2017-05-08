import java.util.Random;

/**
 * Created by anicolasgarcia on 5/8/17.
 */
public class FdpIA extends Fdp {
    public FdpIA(Double a, Double b, Double m) {
        super(a, b, m);
    }

    @Override
    public Double get() {
        double _potencia;
        double _valorY;
        _potencia = Math.pow((this.m - 2.7572), 2) / (1.7175);
        _potencia = _potencia * (-1);
        _valorY = Math.pow(Math.E, _potencia) / 2.3229;

//        _valorY = new Random().nextDouble();

        return ((_valorY * (b - a)) + a);
    }
}
