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

        double _valorY = new Random().nextDouble();
        return (_valorY * (b - a)) + a;

//        while (true) {
//            double d1 = new Random().nextDouble();
//            double d2 = new Random().nextDouble();
//
//            double x1 = d1 * (b - a) + a;
//            double y1 = d2 * m;
//
//            double _potencia;
//            double _valorY;
//            _potencia = Math.pow((x1 - 5.9567), 2) / (19.4189);
//            _potencia = _potencia * (-1);
//            _valorY = Math.pow(Math.E, _potencia) / 7.811;
//
//            if (_valorY >= y1) {
//                return x1;
//            }
//        }

    }
}
