package scene2;

import scene1.*;

public interface SubjectFight {
	public void registerObserver(FightStrategy fs);
	public void removeObsever(FightStrategy fs);
	public void publishMessageFight(Message m);

}
