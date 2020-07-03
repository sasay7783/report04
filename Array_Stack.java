package report04;

interface Stack{//스택이 갖춰야할 연산 선언
	boolean isEmpty(); //비어 있는, 빈
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class ArrayStack implements Stack{//선언한 연산들 구현
	private int top;            //스택의 마지막 자료 위치 추적
	private int stackSize;      //스택의 사이즈를 결정
	private char itemArray[];   //데이터가 문자인 배열 스택
	
	public ArrayStack(int stackSize) {
		top = -1;
		this.stackSize = stackSize;
		itemArray =  new char[this.stackSize];
	}
	public boolean isEmpty(){//스택이 비어있는지 검사
		return(top == -1);
	}
	public boolean isFull(){//스택이 꽉 찾는지 검사
		return (top == this.stackSize-1);
	}
	public void push(char item){//스택이 찼으면 스택에 push할수 없다는 문자 출력 
		                        //그렇지 않으면 탑의 값을 1증가 시키고 item을 itemArray의 top에 할당하고 삽입된 데이터값을 출력
		if(isFull()) {
			System.out.println("Inserting fail! Array Stack is full!!");
		}else {
			itemArray[++top] = item;
			System.out.println("Inserted Item : " + item);
		}
	}
	public char pop(){//스택이 비어있는지 검사하여 비어있다면 pop을 할 수 없다는 메세지 출력 
		              //그렇지 않으면 top이 가리키는 값을 리턴 한 후 top의 값을 1감소
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}else {
			return itemArray[top--];
		}
	}
	public void delete(){//스택이 비어있는지 검사하여 비어있다면 삭제 할 수 없다는 메세지 출력 
                         //그렇지 않으면 top의 값을 1감소 -> 삭제 이루어짐
		if(isEmpty()){
			System.out.println("Deleting fail! Array Stack is empty!!");
		}else {
			top--;
		}
	}
	public char peek(){//스택이 비어있는지 검사하여 비어있다면 데이터를 가져올 수 없다는 메세지 출력 
                       //그렇지 않으면 top이 가리키는 값을  리턴 -> 스택의 top포인터가 뭘 가르키는 지 알고자 할때 사용
		if(isEmpty()){
			System.out.println("Peeking fail! Array Stack is empty!!");
			return 0;
		}else {
			return itemArray[top];
		}
	}
	public void printStack(){//스택이 비어있는지 검사하여 비어있다면 비어있다는 메세지 출력 
                             //그렇지 않으면 스택의 값들을 스택에 들어온 순서대로 출력
		if(isEmpty()){
			System.out.println("Arrsy Stack is empty!! %n %n");
		}else {
			System.out.println("Array Stack>>");
			for(int i=0; i<= top; i++)
				System.out.printf("%c", itemArray[i]);
			                      //%c-> 문자형 변수
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
