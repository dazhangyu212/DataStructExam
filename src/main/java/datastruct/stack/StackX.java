package main.java.datastruct.stack;



/**
 * @类名:StackX
 * @描述:
 * @公司:北京海鑫科技高科技股份有限公司
 * @作者:zhangyu
 * @创建时间:2016年9月1日
 */
public class StackX {
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public StackX(int size) {
		maxSize = size;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	/**
	 * put item on top of stack
	 * @param j
	 */
	public void push(int j){
		stackArray[++top] = j;
	}
	
	/**
	 * take item from top of stack
	 * @return
	 */
	public int pop(){
		return stackArray[top--];
	}
	
	/**
	 * peek at top of stack 
	 * @return
	 */
	public int peek(){
		return stackArray[top];
	}
	
	/**
	 * true if stack is empty
	 * @return
	 */
	public boolean isEmpty(){
		return top == -1;
	}
	
	/**
	 * true if stack is full
	 * @return
	 */
	public boolean isFull(){
		return (top == maxSize -1);
	}
	
	/**
	 * return size
	 * @return
	 */
	public int size(){
		return top+1;
	}
	
	/**
	 * peek at index n
	 * @param n
	 * @return
	 */
	public int peekN(int n){
		return stackArray[n];
	}
	
	public void displayStack(String s){
		System.out.println(s);
		System.out.println("stack(bottom-->top):");
		for (int i = 0; i < stackArray.length; i++) {
			System.out.print(peekN(i));
			System.out.print(" ");
		}
		System.out.println("");
	}
	
}
