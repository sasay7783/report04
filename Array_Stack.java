package report04;

interface Stack{//������ ������� ���� ����
	boolean isEmpty(); //��� �ִ�, ��
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class ArrayStack implements Stack{//������ ����� ����
	private int top;            //������ ������ �ڷ� ��ġ ����
	private int stackSize;      //������ ����� ����
	private char itemArray[];   //�����Ͱ� ������ �迭 ����
	
	public ArrayStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		itemArray =  new char[this.stackSize];
	}
	public boolean isEmpty(){//������ ����ִ��� �˻�
		return(top == -1);
	}
	public boolean isFull(){//������ �� ã���� �˻�
		return (top == this.stackSize-1);
	}
	public void push(char item){//������ á���� ���ÿ� push�Ҽ� ���ٴ� ���� ��� 
		                        //�׷��� ������ ž�� ���� 1���� ��Ű�� item�� itemArray�� top�� �Ҵ��ϰ� ���Ե� �����Ͱ��� ���
		if(isFull()) {
			System.out.println("Inserting fail! Array Stack is full!!");
		}else {
			itemArray[++top] = item;
			System.out.println("Inserted Item : " + item);
		}
	}
	public char pop(){//������ ����ִ��� �˻��Ͽ� ����ִٸ� pop�� �� �� ���ٴ� �޼��� ��� 
		              //�׷��� ������ top�� ����Ű�� ���� ���� �� �� top�� ���� 1����
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}else {
			return itemArray[top--];
		}
	}
	public void delete(){//������ ����ִ��� �˻��Ͽ� ����ִٸ� ���� �� �� ���ٴ� �޼��� ��� 
                         //�׷��� ������ top�� ���� 1���� -> ���� �̷����
		if(isEmpty()){
			System.out.println("Deleting fail! Array Stack is empty!!");
		}else {
			top--;
		}
	}
	public char peek(){//������ ����ִ��� �˻��Ͽ� ����ִٸ� �����͸� ������ �� ���ٴ� �޼��� ��� 
                       //�׷��� ������ top�� ����Ű�� ����  ���� -> ������ top�����Ͱ� �� ����Ű�� �� �˰��� �Ҷ� ���
		if(isEmpty()){
			System.out.println("Peeking fail! Array Stack is empty!!");
			return 0;
		}else {
			return itemArray[top];
		}
	}
	public void printStack(){//������ ����ִ��� �˻��Ͽ� ����ִٸ� ����ִٴ� �޼��� ��� 
                             //�׷��� ������ ������ ������ ���ÿ� ���� ������� ���
		if(isEmpty()){
			System.out.println("Arrsy Stack is empty!! %n %n");
		}else {
			System.out.println("Array Stack>>");
			for(int i=0; i<= top; i++)
				System.out.printf("%c", itemArray[i]);
			                      //%c-> ������ ����
			System.out.println();
			System.out.println();
		}
	}
}

public class Array_Stack {

	public static void main(String[] args) {
		int stackSize =5;
		char deletedItem;
		ArrayStack S = new ArrayStack(stackSize);
		
		S.push('A');
		S.printStack();
		
		S.push('B');
		S.printStack();
		
		S.push('C');
		S.printStack();
		
		deletedItem = S.pop();
		if(deletedItem  != 0)
			System.out.println("deleted Item : " +deletedItem);
		S.printStack();

	}

}
