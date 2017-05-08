import java.util.ArrayList;
import java.util.List;

public class DeliveryBoySimulator {
  Double time = 0.00;
  List<Event> events = new ArrayList<Event>();
  Integer acum = 0;
  Integer ns = 0;
  Integer deliveryBoys;
  Integer tamanioPaquete;
  Double finalTime;
  FDP ta;
  FDP ia;
  Double iTo = 0.0;
  
  public DeliveryBoySimulator(Integer deliveryBoys, Integer tamanioPaquete, Double finalTime, FDP ta, FDP ia){
	  this.deliveryBoys = deliveryBoys;
	  this.tamanioPaquete = tamanioPaquete;
	  this.finalTime = finalTime;
	  this.ta = ta;
	  this.ia = ia;
  }
   
 public void start(){
	 
	 //empiezo con una llegada
	 events.add(new Event("LLEGADA",ia.get()));
	 
	 while(time <= finalTime ){
		 //get del proximo evento mas cercano en el tiempo
		 Event evt = pullNextEvent();
	     //actualizo variable tiempo
		 time = evt.getTime();
		 
		 //SI ES LLEGADA
		 if(evt.getType().equals("LLEGADA")){
			// acumulo en el paquete
			acum++;
			// evento no condicionado = GENERO NUEVA LLEGADA
			events.add(new Event("LLEGADA",time+ia.get()));
			// si hay un paquete lleno, lo agrego al sistema
			if(acum>=tamanioPaquete){
				ns++;
				acum = 0;
				//si hay delivery boys disponibles, lo antiende
				if(ns <= deliveryBoys){
					events.add(new Event("SALIDA",time+ta.get()));
					//FIN DE TIEMPO OCIOSO? SUMARIZAR?
				}
			}
	     // SI ES SALIDA
		 }else{
			//saco el paquete del sistema
			ns--;
			// Si hay paquetes esperando, genero otra salida para el delivery boy que acaba de entregar
			if(ns >= deliveryBoys){
				events.add(new Event("SALIDA",time+ta.get()));
			}else{
				//COMIENZA TIEMPO OCIOSO?
			}
		
		 }

		 
	 }
	 
 }
 
 private Event pullNextEvent(){
	 Event min=null;
	 for(Event x:events){
	     min=(min==null||x.time<min.time)?x:min;
	 }
	 events.remove(min);
	 return min;
	
 }
  
  
}
