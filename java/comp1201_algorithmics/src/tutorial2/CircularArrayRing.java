package tutorial2;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E>{
	
	private int ringSize;
	private ArrayList<E> arraylistRing;
	
	
//	public static void main(String argv[]) {
//		System.out.println("Hello");
//	}
	 
	// default constructor
	public CircularArrayRing() {
		// set default ring size to 10
		this.ringSize = 10;
		this.arraylistRing = new ArrayList<E>(ringSize);
	}
	
	//constructor taking the size of the ring as an argument
	public CircularArrayRing(int rSize) {
		// TODO Auto-generated constructor stub
		this.ringSize = rSize;
		this.arraylistRing = new ArrayList<E>(ringSize);
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (arraylistRing.size() ==0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(E e) {
		// if ring is not full, just add to the end of arraylist; if ring is full, remove one from the head of arraylist before add
						//////System.out.println("\n ringSize is:" + ringSize);
						/////System.out.println("\n no. of items is:" + arraylistRing.size());
		if(arraylistRing.size() < ringSize){
			arraylistRing.add(e);
						//////System.out.println("\n A is:" + e);
						//////System.out.println("\n no. of items after add is:" + arraylistRing.size());
			return true;
		}else if(arraylistRing.size() == ringSize){
			arraylistRing.remove(0);
			arraylistRing.add(e);
						//////System.out.println("\n B is:" + e);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// if the object is within the arraylist, remove it
		if (arraylistRing.contains(o)){
			arraylistRing.remove(o);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		/////System.out.println("\n index:" + index);	
		if (index < 0 || index >= ringSize){
			throw new IndexOutOfBoundsException();
		}else{
			return arraylistRing.get(this.size()-1-index);
		}
		
	}

	@Override
	public Iterator<E> iterator() {
		// SUB-CLASS         
		return new Iterator <E> (){

			@Override
	        public boolean hasNext() {
				if (arraylistRing.size() != 0){
					return true;
				}else{
					return false;
				}
			}
	
	        @Override
	        public E next() {
	        	//error here - not the size but the current index!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	            return arraylistRing.get(arraylistRing.size()-1);
	        }
	             
	        @Override
	        public void remove() {
	          
	    		if (ringSize == 0){
	    			throw new UnsupportedOperationException();
	    		}else{
	    			 arraylistRing.remove(arraylistRing.size()-1);
	    		}
	        }                       
	   	};
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return arraylistRing.size();
	}

}
