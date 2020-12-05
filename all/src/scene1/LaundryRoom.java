package scene1;
import scene2.*;

public class LaundryRoom extends Place {
	String[] avaliablePos = { "hallway" };

	public LaundryRoom() {
		super("You entered the laundry room!.", 4, true);
		items.add(new Chair("Brown"));
	}

	@Override
	public void look() {
		if(!items.isEmpty()) {
			System.out.println("watch out from the wet floor, you can see the follwoing objects:");
			for (int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i).description);
			}
		}
		System.out.println("You can only walk to the hallway");
	}

	@Override
	public int walk(String s) {
		if ((s.contains(avaliablePos[0])) && (s.contains("walk"))) {
			return (1);
		} else {
			System.out.println("There is no such place, please try another place");
		}
		return pos;
	}
	
	@Override
	public void useInPlace(String s, Player p) {
		if (!items.isEmpty() || p.bag.size() > 0) {
			for (int i = 0; i < items.size(); i++) {
				if (s.contains(items.get(i).name.toLowerCase())) {
					if(s.contains("chair"))
					{
						items.get(i).use(p,this);

					}
					else {
						items.get(i).use(p);

					}
					return;
				}
			}
			for (int i = 0; i < p.bag.size(); i++) {
				if (s.contains(p.bag.get(i).name.toLowerCase())) {
					p.bag.get(i).use(p);
					return;
				}
			}
			System.out.println("This item doesn't exist in this place");
		} else {
			System.out.println("No items exist in this place or you don't have items in the bag");
		}
	}
	

}