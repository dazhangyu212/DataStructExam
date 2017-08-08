package main.java.datastruct.linklist;



/**
 * @类名:Link
 * @描述:
 * @公司:北京海鑫科技高科技股份有限公司
 * @作者:zhangyu
 * @创建时间:2016年9月2日
 */
public class Link {
	/**
	 * data item
	 */
	public int iData;
	/**
	 * data item
	 */
	public double dData;
	/**
	 * next link in list
	 */
	public Link next;
	
	public Link(int id,double dd) {
		iData = id;
		dData = dd;//next is automatically set to null
		
	}
	
	public void displayLink(){
		System.out.println("{"+iData+","+dData+"}");
	}
	
}//end
