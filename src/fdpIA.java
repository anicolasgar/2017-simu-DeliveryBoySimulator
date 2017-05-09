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
//            _potencia = Math.pow((x1 - 2.7572), 2) / (1.7175);
//            _potencia = _potencia * (-1);
//            _valorY = Math.pow(Math.E, _potencia) / 2.3229;
//
//            if (_valorY >= y1) {
//                return x1;
//            }
//        }
    }
}
