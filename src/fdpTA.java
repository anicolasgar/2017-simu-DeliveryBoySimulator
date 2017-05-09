import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by anicolasgarcia on 5/8/17.
 */
public class FdpTA extends Fdp {
    static private final Logger log = LoggerFactory.getLogger(FdpTA.class);

    public FdpTA(Double a, Double b, Double m) {
        super(a, b, m);
    }

    @Override
    public Double get() {
        double _potencia;
        double _valorY;
        double _respuesta;
        _potencia = Math.pow((this.m - 5.9567), 2) / (19.4189);
        _potencia = _potencia * (-1);
        _valorY = Math.pow(Math.E, _potencia) / 7.811;

//        _valorY = new Random().nextDouble();
        _respuesta = (_valorY * (b - a)) + a;
        log.debug("fdpTA: {}",_respuesta);

        return _respuesta;
    }
}
