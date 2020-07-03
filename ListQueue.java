package report04;
import java.util.NoSuchElementException;

public class ListQueue<E> {
	private Node<E> front, rear;
	private int size1;
	
	public ListQueue() {
		front = rear = null;
		size1 = 0;
	}
	public int size() {return size1;}
	public boolean isEmpty() {return size()==0;}

	public void add(E newItem) {
		Node newNode = new Node(newItem, null);
		if(isEmpty())
			front = newNode;
		else
			rear.setNext(newNode);
		rear = newNode;
		size1++;
	}
	public E remove() {
		if(isEmpty())
			throw new NoSuchElementException();
		E frontItem = front.getItem();
		front = front.getNext();
		if(isEmpty()) 
			rear = null;
		size1++;
		return frontItem;
	}
	public void print() {
		if(isEmpty()) 
			System.out.print("≈•∞° empty¿”");
		else 
			for(Node p= front; p != null; p = p.getNext())
				System.out.print(p.getItem()+"\t");
		System.out.println();
	}
	public static void main(String[] args) {
		ListQueue<String> q =new ListQueue<String>();
		
		q.add("apple");
		q.add("orange");
		q.add("cheery");
		q.add("pear");
		q.print();
		
		q.remove();
		q.print();
		q.remove();
		q.print();
		
		q.add("grape");
		q.print();
	}

}
