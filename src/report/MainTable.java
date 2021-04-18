package report;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.management.Query;

public class MainTable {

	public static Scanner sc = new Scanner(System.in);
	public static final int INSERT = 1;
	public static final int DELETE = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int PRINT = 5;
	public static final int END = 6;
	
	public static void main(String[] args) throws Exception {
		runMenu();
	}

	private static void runMenu() throws Exception {
		boolean flag =false;
		while(!flag) {
			System.out.println("1. insert\n2. delete\n3. search\n4. update\n5. print\n6. end");
			System.out.print("--->");
			int select =sc.nextInt();
			
			switch(select) {
				case INSERT :
					insertStudent();
					break;
				case DELETE :
					deleteStudent();
					break;
				case SEARCH :
					searchStudent();
					break;
				case UPDATE :
					updateStudent();
					break;
				case PRINT :
					printStudent();
					break;
				case END :
					System.out.println("Thank you.");
					flag =true;
					break;
			}
		}
	}

	private static void updateStudent() throws Exception {
		Student student =null;
		Student inputStudent =null;
		int id =0;
		while(true) {
			System.out.println("input id : ");
			id =sc.nextInt();
			student = QueryClass.selectQueryStudentWhereID(id);
			if(student!=null && student.getId() == id) {
				break;
			} else {
				System.out.println("Not Exists.");
				continue;
			}
		}
		System.out.println("input Java : ");
		int java =sc.nextInt();
		System.out.println("input Kotlin : ");
		int kotlin =sc.nextInt();
		System.out.println("input Database : ");
		int db =sc.nextInt();
		System.out.println("input C : ");
		int c =sc.nextInt();
		inputStudent = new Student(id, student.getName(), java, kotlin, db, c);
		boolean returnValue = QueryClass.updateDeleteQueryStudent(id);
		if(returnValue ==false) {
			System.out.println("Update Fail.");
		}
		boolean returnValue2 = QueryClass.updateQueryStudent(inputStudent);
	}

	private static void searchStudent() throws Exception {
		Student student =null;
		while(true) {
			System.out.println("input id : ");
			int id =sc.nextInt();
			student = QueryClass.selectQueryStudentWhereID(id);
			if(student!=null && student.getId() == id) {
				System.out.println(student);
				break;
			} else {
				System.out.println("Not Exists.");
				continue;
			}
		}
	}

	private static void printStudent() throws Exception {
		Set<Student> set = new HashSet<Student>();
		set = QueryClass.printQueryStudent();
		for(Student s:set) {
			System.out.println(s);
		}
	}

	private static void deleteStudent() throws Exception {
		Student student =null;
		int id =0;
		while(true) {
			System.out.println("input id : ");
			id =sc.nextInt();
			student = QueryClass.selectQueryStudentWhereID(id);
			if(student!=null && student.getId() == id) {
				break;
			} else {
				System.out.println("Not Exists.");
				continue;
			}
		}
		boolean returnValue = QueryClass.deleteQueryStudent(id);
		if(returnValue ==false) {
			System.out.println("Delete Fail.");
		}
	}

	private static void insertStudent() throws Exception {
		Student student =null;
		Student inputStudent =null;
		while(true) {
			System.out.println("input id : ");
			int id =sc.nextInt();
			student = QueryClass.selectQueryStudentWhereID(id);
			if(student!=null && student.getId() == id) {
				System.out.println("Already Exists.");
				continue;
			}
			System.out.println("input name : ");
			String name =sc.next();
			System.out.println("input Java : ");
			int java =sc.nextInt();
			System.out.println("input Kotlin : ");
			int kotlin =sc.nextInt();
			System.out.println("input Database : ");
			int db =sc.nextInt();
			System.out.println("input C : ");
			int c =sc.nextInt();
			inputStudent = new Student(id, name, java, kotlin, db, c);
			break;
		}
		boolean returnValue = QueryClass.insertQueryStudent(inputStudent);
		if(returnValue ==false) {
			System.out.println("Insert Fail.");
		}
	}
}
