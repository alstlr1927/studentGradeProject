package report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class QueryClass {

	public static Student selectQueryStudentWhereID(int inputID) throws Exception {
		Student student =null;
		Connection connection = DBUtil.getConnection();
		String selectQuery = "select * from studenttbl where id = ?";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement =connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, inputID);
			ResultSet set = preparedStatement.executeQuery();
			while(set.next()){
				int id = set.getInt(1);
				String name = set.getString(2);
				int java = set.getInt(3);
				int kotlin =set.getInt(4);
				int db =set.getInt(5);
				int c =set.getInt(6);
				int total =set.getInt(7);
				double avg =set.getDouble(8);
				String grade =set.getString(9);
				student = new Student(id, name, java, kotlin, db, c, total, avg, grade);
			}
		}catch(Exception e) {
			System.out.println("Error Select.");
		}finally {
			if(preparedStatement !=null) {
				preparedStatement.close();
			}
			if(connection !=null) {
				connection.close();
			}
		}
		return student;
	}

	public static boolean insertQueryStudent(Student student) throws Exception {
		boolean flag =false;
		Connection connection = DBUtil.getConnection();
		String insertQuery = "call cal_procedure(?,?,?,?,?,?)";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement =connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setInt(3, student.getJava());
			preparedStatement.setInt(4, student.getKotlin());
			preparedStatement.setInt(5, student.getDb());
			preparedStatement.setInt(6, student.getC());
			int count = preparedStatement.executeUpdate();
			if(count ==1) {
				System.out.println("Insert Success.");
				flag =true;
			}
		}catch(Exception e) {
			System.out.println("Error Insert.");
		}finally {
			if(preparedStatement !=null) {
				preparedStatement.close();
			}
			if(connection !=null) {
				connection.close();
			}
		}
		return flag;
	}

	public static boolean deleteQueryStudent(int id) throws Exception {
		boolean flag =false;
		Connection connection = DBUtil.getConnection();
		String deleteQuery = "delete from studenttbl where id = ?";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement =connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			int count = preparedStatement.executeUpdate();
			if(count ==1) {
				System.out.println("Delete Success.");
				flag =true;
			}
		}catch(Exception e) {
			System.out.println("Error Delete.");
		}finally {
			if(preparedStatement !=null) {
				preparedStatement.close();
			}
			if(connection !=null) {
				connection.close();
			}
		}
		return flag;
	}

	public static Set<Student> printQueryStudent() throws Exception {
		Set<Student> set = new HashSet<Student>();
		Student student =null;
		Connection connection = DBUtil.getConnection();
		String printQuery = "select * from studenttbl";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement =connection.prepareStatement(printQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int java = resultSet.getInt(3);
				int kotlin =resultSet.getInt(4);
				int db =resultSet.getInt(5);
				int c =resultSet.getInt(6);
				int total =resultSet.getInt(7);
				double avg =resultSet.getDouble(8);
				String grade =resultSet.getString(9);
				student = new Student(id, name, java, kotlin, db, c, total, avg, grade);
				set.add(student);
			}
		}catch(Exception e) {
			System.out.println("Error Print.");
		}finally {
			if(preparedStatement !=null) {
				preparedStatement.close();
			}
			if(connection !=null) {
				connection.close();
			}
		}
		
		return set;
	}

	public static boolean updateDeleteQueryStudent(int id) throws Exception {
		boolean flag =false;
		Connection connection = DBUtil.getConnection();
		String deleteQuery = "delete from studenttbl where id = ?";
		PreparedStatement preparedStatement1 =null;
		try {
			preparedStatement1 =connection.prepareStatement(deleteQuery);
			preparedStatement1.setInt(1, id);
			int count = preparedStatement1.executeUpdate();
			if(count ==1) {
				flag =true;
			}
		}catch(Exception e) {
			System.out.println("Error Update.");
		}finally {
			if(preparedStatement1 !=null) {
				preparedStatement1.close();
			}
			if(connection !=null) {
				connection.close();
			}
		}
		return flag;
	}

	public static boolean updateQueryStudent(Student student) throws Exception {
		boolean flag =false;
		Connection connection = DBUtil.getConnection();
		String updateQuery = "call cal_procedure(?,?,?,?,?,?)";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement =connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setInt(3, student.getJava());
			preparedStatement.setInt(4, student.getKotlin());
			preparedStatement.setInt(5, student.getDb());
			preparedStatement.setInt(6, student.getC());
			int count = preparedStatement.executeUpdate();
			if(count ==1) {
				System.out.println("Update Success.");
			}
		}catch(Exception e) {
			System.out.println("Error Update.");
		}finally {
			if(preparedStatement !=null) {
				preparedStatement.close();
			}
			if(connection !=null) {
				connection.close();
			}
		}
		
		return flag;
	}

}
