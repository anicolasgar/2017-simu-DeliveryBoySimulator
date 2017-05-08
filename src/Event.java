
public class Event {
   String type;
   public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Double getTime() {
	return time;
}
public void setTime(Double time) {
	this.time = time;
}
Double time;
   public Event(String type, Double time){
	   this.type = type;
	   this.time = time;
   }
}
