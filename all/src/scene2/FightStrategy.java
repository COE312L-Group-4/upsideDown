package scene2;

public abstract class FightStrategy implements ÒbserverStrategy {

	public abstract void fight();

	@Override
	public abstract void update(double accx, double accy, double accz, double gyrx, double gyry, double gyrz, int Orint,String act);

}
