import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DeliveryBoySimulator {
    static private final Logger log = LoggerFactory.getLogger(DeliveryBoySimulator.class);

    private Double time = 0.00;
    private Integer acum = 0;
    private Integer ns = 0;
    private Integer deliveryBoys;
    private Integer tamanioPaquete;
    private Double finalTime;
    private FdpTA ta;
    private FdpIA ia;
    private double intervaloTiempoOcioso = 0.0;
    private double sumatoriaTiempoOcioso;
    private double TPLL = 0;
    private List<DeliveryBoy> listDeliveryBoys;

    public DeliveryBoySimulator(Integer deliveryBoys, Integer tamanioPaquete, Double finalTime, FdpTA ta, FdpIA ia) {
        this.deliveryBoys = deliveryBoys;       //variable M
        this.tamanioPaquete = tamanioPaquete;   //variable P
        this.finalTime = finalTime;
        this.ta = ta;
        this.ia = ia;
    }

    public void start() {

        this.listDeliveryBoys = new ArrayList<>();
        for (int i = 0; i < this.deliveryBoys; i++) {
            this.listDeliveryBoys.add(new DeliveryBoy());
        }

        while (time <= finalTime) {
            //Obtengo el db con menor tiempo de proxima salida.
            DeliveryBoy db = listDeliveryBoys.stream().min((d1, d2) -> Double.compare(d1.getTPS(), d2.getTPS())).get();
            if (db.isHighValue() || TPLL <= db.getTPS()) {
                time = TPLL;
                TPLL = time + ia.get(); //evt.getTime();
                acum++;
                if (acum >= tamanioPaquete) {
                    ns++;
                    acum = 0;
                    //si hay delivery boys disponibles, lo antiende
                    db = listDeliveryBoys.stream().filter(d -> d.isHighValue()).findFirst().orElse(null);
                    if (db != null) {
                        db.setTPS(time + ta.get());
                        db.setHighValue(false);
                        sumatoriaTiempoOcioso = sumatoriaTiempoOcioso + (time - intervaloTiempoOcioso);
                    }
                }
            } else {
                time = db.getTPS();
                ns--;
                int hayDbOciosos = listDeliveryBoys.stream().filter(d -> d.isHighValue()).collect(Collectors.toList()).size();
                if (ns >= hayDbOciosos) {
                    db.setTPS(time + ta.get());
                    db.setHighValue(false);
                } else {
                    db.setHighValue(true);
                    intervaloTiempoOcioso = time;
                }
            }
        }
        log.info("Tiempo ocioso final: " + sumatoriaTiempoOcioso + " segundos.");
    }

}
