import assignment2.MyLinkedList;

import java.util.NoSuchElementException;

public class TestMyLinkedList {

	public static void test1() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("D");
		l.addLeft("C");
		l.addLeft("B");
		l.addLeft("A");
		l.addRight("X");
		l.addRight("Y");
		l.addRight("Z");

		if (l.size() == 7)
			System.out.println("test1 OK");
		else
			System.out.println("test1 ERROR");
	}

	public static void test2() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("D");
		l.addLeft("C");
		l.addLeft("B");
		l.addLeft("A");
		l.addRight("X");
		l.addRight("Y");
		l.addRight("Z");
		// A-B-C-D-X-Y-Z

		if (l.removeLeft().equals("A") 
				&& l.removeRight().equals("Z")
				&& l.size()==5)
			System.out.println("test2 OK");
		else
			System.out.println("test2 ERROR");
	}


	public static void test3() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("Q");
		l.addLeft("A");
		l.addLeft("A");
		l.addLeft("X");
		l.addRight("Q");
		l.addRight("Q");

		if (l.removeRight().equals("Q")
				&& l.removeRight().equals("Q")
				&& l.removeRight().equals("Q")
				&& l.size()==3)
			System.out.println("test3 OK");
		else
			System.out.println("test3 ERROR");
	}

	public static void test4() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("C");
		l.addLeft("B");
		l.addLeft("A");
		l.addRight("X");
		l.addRight("Y");
		l.addRight("Z");
		// A-B-C-X-Y-Z

		if (l.getMiddle().equals("X"))
			System.out.println("test4 getMiddle OK");
		else
			System.out.println("test4 getMiddle ERROR");

		l.reverse();
		// Z-Y-X-C-B-A

		if (l.getMiddle().equals("C"))
			System.out.println("test4 getMiddle after reverse OK");
		else
			System.out.println("test4 getMiddle after reverse ERROR");

		if (l.removeRight().equals("A")
				&& l.removeRight().equals("B")
				&& l.removeRight().equals("C")
				&& l.removeRight().equals("X")
				&& l.size()==2)
			System.out.println("test4 OK");
		else
			System.out.println("test4 ERROR");
	}


	public static void test5() {
		boolean flag = true;
		MyLinkedList<String> l = new MyLinkedList<String>();
		if (!l.isEmpty())
			flag = false;

		l.addLeft("A");
		l.addLeft("123");
		l.addRight("XYZ");

		l.removeRight();
		l.removeRight();
		
		if (l.isEmpty())
			flag = false;
		l.removeLeft();

		if (!l.isEmpty())
			flag = false;

		if (flag)
			System.out.println("test5 OK");
		else
			System.out.println("test5 ERROR");
	}

	public static void test6() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("D");
		l.addLeft("C");
		l.addLeft("B");
		l.addLeft("A");
		l.addRight("Z");

		if (l.getMiddle().equals("C"))
			System.out.println("test6 OK");
		else
			System.out.println("test6 ERROR");
	}

	public static void test7() {
		MyLinkedList<String> l = new MyLinkedList<String>();
		l.addLeft("D");
		l.removeLeft();
		try {
			l.removeRight();
			System.out.println("test7: ERROR didn't catch NoSuchElement");
		} catch(NoSuchElementException e) {
			System.out.println("test7: OK");
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
	}
}