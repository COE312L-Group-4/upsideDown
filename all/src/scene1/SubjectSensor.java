package scene1;
import scene2.*;


public interface SubjectSensor {
	public void registerObserver(Object o);
	public void removeObsever(Object o);
	public void notifyObservers(double accx, double accy, double accz, double gyrx, double gyry, double gyrz);
}
