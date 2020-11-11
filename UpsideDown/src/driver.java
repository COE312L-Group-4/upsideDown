
public class driver {

	public static void main(String[] args) {
		System.out.println("Hello world");
		Person p  = new PoliceOfficer("Polyy",40, 0); 
		System.out.println(p);
		Person v = Victim.getInstance("Visha",50, 0);
		System.out.println(v);

	}

}
