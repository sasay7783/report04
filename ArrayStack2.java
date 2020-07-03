package report04;
import java.util.EmptyStackException;

public class ArrayStack2<E> {
	private E s[];               // ������ ���� �迭
	private int top;             // ������ top �׸��� �迭 ���� �ε���
	public ArrayStack2() {        // ���� ������
		s = (E[]) new Object[1]; // �ʱ⿡ ũ�Ⱑ 1�� �迭 ����
		top = -1;
	}
	public int size() {return top+1;}             // ���ÿ� �ִ� �׸��� ���� ����
	public boolean isEmpty() {return (top == -1);}// ������ empty�̸� true ����
    
	//peek(), push(), pop(), resize() �޼ҵ� ����
	
	public E peek() {//���� top �׸��� ���븸�� ����
		if(isEmpty()) 
			throw new EmptyStackException();//underflow �� ���α׷� ����
		return s[top];
	}
	public void resize(int newSize) {      // �迭ũ�� ����
		Object[] t = new Object[newSize];  //newSize ũ���� ���ο� �迭 t ����
		for(int i= 0; i< size(); i++)        
			t[i] = s[i];                   //�迭 a�� �迭 t�� ����
	       	s=(E[]) t;                     //�迭 t�� �迭 a��
	}
	public void push(E newItem) {//push ����
		if(size() == s.length)
			resize(2*s.length);  //������ 2�� ũ��� Ȯ��
		s[++top] = newItem;      //�� �׸��� push
	}
	public E pop() { //pop ����
		if(isEmpty())
			throw new EmptyStackException();//underflow �� ���α׷� ����
		E item = s[top];
		s[top--] = null;         //null�� �ʱ�ȭ
		if(size()> 0 && size()== s.length/4)
			resize(s.length/2);  //������ 1/2ũ��� ���
		return item;
	}
	public void print() {
		if(isEmpty())
			System.out.print("�迭�� �������.");
		else
			for(int i=0; i<s.length; i++)
				System.out.print(s[i] + "\t");
		System.out.println();
		}
	


	public static void main(String[] args) {
        ArrayStack2<String> stack = new ArrayStack2<String>();
		
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		System.out.println(stack.peek());
		stack.push("pear");
		stack.print();
		stack.pop();
		System.out.println(stack.peek());
		stack.push("grape");
		stack.print();
	}

	}


