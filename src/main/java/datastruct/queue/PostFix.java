package main.java.datastruct.queue;
/*
 * parses postfix arithmetic expressions
 * to run this program:c>java PostFixApp
 */


/**
 * @类名:PostFix
 * @描述:
 * @公司:北京海鑫科技高科技股份有限公司
 * @作者:zhangyu
 * @创建时间:2016年9月1日
 */
public class PostFix {
	public static void main(String[] args) {
		int m = 10;
		int n = 2;
		int r = m%n;
		while(r!= 0){
			m = n;
			n = r;
			r=m%n;
		}
	}

}
