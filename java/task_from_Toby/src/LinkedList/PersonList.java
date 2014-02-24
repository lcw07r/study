package LinkedList;

public class PersonList{
	private PersonListNode head;
	private int noElements;
	
	public PersonList() {
		// TODO Auto-generated constructor stub
		head = null;
		noElements = 0;
	}
	
	public void add(Person p){
		PersonListNode newNode = new PersonListNode();
		newNode.element = p;
		newNode.next = head;
		head = newNode;
		noElements++;
	}
		
	public Person get(String lastname){
		Person p = null;
		for (PersonListNode current = head; current != null; current = current.next){
			if (lastname.equals(current.element.getLast())){
				p = current.element;
			}			
		}
		return p;
	}

}
