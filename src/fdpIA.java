import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by anicolasgarcia on 5/8/17.
 */
public class FdpIA extends Fdp {
    static private final Logger log = LoggerFactory.getLogger(FdpIA.class);

    public FdpIA(Double a, Double b, Double m) {
        super(a, b, m);
    }

    @Override
    public Double get() {
        double _potencia;
        double _valorY;
        double _respuesta;
        _potencia = Math.pow((this.m - 2.7572), 2) / (1.7175);
        _potencia = _potencia * (-1);
        _valorY = Math.pow(Math.E, _potencia) / 2.3229;

//        _valorY = new Random().nextDouble();

        _respuesta = (_valorY * (b - a)) + a;
        log.debug("fdpIA: {}", _respuesta);

        return _respuesta;
    }
}
