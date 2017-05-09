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
    private double sto = 0.0;
    private double ito;
    boolean primeraVez;
    boolean tiempoOcioso;
    boolean todoOcioso;

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
        //primeraVez = true;
        tiempoOcioso = true;
        todoOcioso = true;
        while (events.size()>0) {
            //get del proximo evento mas cercano en el tiempo
            Event evt = pullNextEvent();
            //actualizo variable tiempo
            time = evt.getTime();
            //SI ES LLEGADA
            if (evt.sosDeLlegada()) {
                // acumulo en el paquete
                acum++;
                // evento no condicionado = GENERO NUEVA LLEGADA
                double tpll = time + ia.get();
                if(tpll<finalTime){
                    events.add(new Event(EventType.LLEGADA,tpll ));
                }
                // si hay un paquete lleno, lo agrego al sistema
                if (acum >= tamanioPaquete) {
                    ns++;
                    acum = 0;
                    //si hay delivery boys disponibles, lo antiende
                    if (ns <= deliveryBoys) {
                        events.add(new Event(EventType.SALIDA, time + ta.get()));
                    }
                }
                // SI ES SALIDA
            } else {
                //saco el paquete del sistema
                ns--;
                // Si hay paquetes esperando, genero otra salida para el delivery boy que acaba de entregar
                if (ns >= deliveryBoys) {
                    events.add(new Event(EventType.SALIDA, time + ta.get()));
                }
            }

            // System.out.println("ns"+ns);
            if(!tiempoOcioso && ns<deliveryBoys){
                tiempoOcioso = true;
                ito = time;
            }
            if(tiempoOcioso && ns>=deliveryBoys){
                tiempoOcioso = false;
                todoOcioso = false;
                sto = sto + (time - ito);
            }

        }

        if(todoOcioso){
            sto = finalTime;
        }else if (tiempoOcioso && time<finalTime){
            sto = sto + (finalTime - ito);
        }

        System.out.println("Tiempo ocioso: " + sto + " minutos.");

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
