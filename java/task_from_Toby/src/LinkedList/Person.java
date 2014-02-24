package LinkedList;

public class Person {
	private String firstname;
	private String lastname;

	public Person(String first, String last) {
		firstname = first;
		lastname = last;		
	}
	
	public String getFirst(){
		return firstname;
	}
	
	public String getLast(){
		return lastname;
	}
		
	public String toString(){		
		return firstname+ " " + lastname;
	}

}
