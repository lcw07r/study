package LinkedList;

public class TestPersonList {

	public static void main(String[] args) {
		Person p1 = new Person("Ann", "A1");
		Person p2 = new Person("Ben", "B1");
		//System.out.println(p1);
		//System.out.println(p2);
		
		PersonList pl = new PersonList();
		pl.add(p1);
		pl.add(p2);
		
		Person searchPersonByLastname = pl.get("B1");
		System.out.println(searchPersonByLastname);
	}
}
