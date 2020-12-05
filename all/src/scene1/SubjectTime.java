package scene1;
import scene2.*;


public interface SubjectTime {
	public void registerObserver(Security o);
	public void removeObsever(Security o);
	public void notifyObservers(int c);
}
