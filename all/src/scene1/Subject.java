package scene1;

public interface Subject {
	public void registerObserver(Security o);
	public void removeObsever(Security o);
	public void notifyObservers();
}
