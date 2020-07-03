package report04;

interface Stack3{//스택이 갖춰야할 연산 선언
	boolean isEmpty(); //비어 있는, 빈
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class StackNode3{
	char data;
	StackNode link;
}

class LinkedStack3 implements Stack3{
	private StackNode top;
	
	public boolean isEmpty(){
		return (top == null);
	}
	
	public void push(char item){
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}
	public char pop(){
    if(isEmpty()) {
               System.out.println("Deleting fail! Linked Stack is empty!!");
               return 0;
    }else {
        char item = top.data;
        top = top.link;
        return item;
     }
  }
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Linked Stack is empty!!");
		}else {
			top = top.link;
			
		}
	}
	public char peek(){
		if(isEmpty()){
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}else {
			return top.data;
		}
	}
	public void printStack(){
    if(isEmpty()){
                System.out.println("Linked Stack is empty!! %n %n");
    }else {
        StackNode temp = top;
        System.out.println("Linked Stacck>>");
        while(temp != null) {
        	System.out.printf("\t %c \n",temp.data);
            temp = temp.link;
    }
         System.out.println();
   }
  }
}

class OptExp {
	private String exp;
	private int expSize;
	private char testCh, openPair;
	
	public boolean testPair(String exp) {
		this.exp = exp;
		LinkedStack3 S = new LinkedStack3();
		expSize = this.exp.length();
		for(int i=0; i<expSize; i++) {
			testCh = this.exp.charAt(i);
			switch(testCh) {
			case '(':
			case '{':
			case '[':
				S.push(testCh);
				break;
			case ')':
			case '}':
			case ']':
				if(S.isEmpty()) return false;
				else {
					openPair = S.pop();
					if((openPair == '(' && testCh != ')') ||
					  (openPair == '{' && testCh != '}') ||
					  (openPair == '[' && testCh != ']'))
					  return false;
					  else break;
				}
			}
		}
		if(S.isEmpty()) return true;
		else return false;
	}

}

public class Bracket_test {
	public static void main(String[] args) {
		OptExp opt = new OptExp();
		String exp = "(3*5)-(6/2)";
		
		System.out.println(exp);
		
		if(opt.testPair(exp))
			System.out.println("괄호 맞음!");
		else
			System.out.println("괄호 틀림!!");
			

	}

}
