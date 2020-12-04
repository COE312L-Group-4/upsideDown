package scene2;

import scene1.Object;

public interface SubjectFight {
	public void registerObserver(FightStrategy fs);
	public void removeObsever(FightStrategy fs);
	public void notifyObservers(double accx, double accy, double accz, double gyrx, double gyry, double gyrz,int orientation);

}
