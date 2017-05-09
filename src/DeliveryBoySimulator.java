import java.util.ArrayList;
import java.util.List;

public class DeliveryBoySimulator {
    private Double time = 0.0;
    private List<Event> events = new ArrayList<Event>();
    private Integer acum = 0;
    private Integer ns = 0;
    private Integer deliveryBoys;
    private Integer tamanioPaquete;
    private Double finalTime;
    private FdpTA ta;
    private FdpIA ia;
    private double iTo = 0.0;
    private double contadorOcioso;
    boolean primeraVez;

    public DeliveryBoySimulator(Integer deliveryBoys, Integer tamanioPaquete, Double finalTime, FdpTA ta, FdpIA ia) {
        this.deliveryBoys = deliveryBoys;
        this.tamanioPaquete = tamanioPaquete;
        this.finalTime = finalTime;
        this.ta = ta;
        this.ia = ia;
    }

    public void start() {

        //empiezo con una llegada
        events.add(new Event(EventType.LLEGADA, ia.get()));
        primeraVez = true;
        while (time <= finalTime) {
            //get del proximo evento mas cercano en el tiempo
            Event evt = pullNextEvent();
            //actualizo variable tiempo
            time = evt.getTime();
            //SI ES LLEGADA
            if (evt.sosDeLlegada()) {
                // acumulo en el paquete
                acum++;
                if (primeraVez && ns == deliveryBoys) {
                    iTo = iTo + time;
                    primeraVez = false;
                }
                // evento no condicionado = GENERO NUEVA LLEGADA
                events.add(new Event(EventType.LLEGADA, time + ia.get()));
                // si hay un paquete lleno, lo agrego al sistema
                if (acum >= tamanioPaquete) {
                    ns++;
                    acum = 0;
                    //si hay delivery boys disponibles, lo antiende
                    if (ns <= deliveryBoys) {
                        events.add(new Event(EventType.SALIDA, time + ta.get()));
                        if (contadorOcioso > 0) {
                            iTo = iTo + (time - contadorOcioso);
                            contadorOcioso = 0;
                        }
                        //FIN DE TIEMPO OCIOSO? SUMARIZAR?
                    }
                }
                // SI ES SALIDA
            } else {
                //saco el paquete del sistema
                ns--;
                // Si hay paquetes esperando, genero otra salida para el delivery boy que acaba de entregar
                if (ns >= deliveryBoys) {
                    events.add(new Event(EventType.SALIDA, time + ta.get()));
                } else {
                    contadorOcioso = time;
                    //COMIENZA TIEMPO OCIOSO?
                }
            }

        }
        System.out.println("Tiempo ocioso: " + iTo + " segundos.");

    }

    private Event pullNextEvent() {
        Event min = null;
        for (Event x : events) {
            min = (min == null || x.time < min.time) ? x : min;
        }
        events.remove(min);
        return min;
    }

}
