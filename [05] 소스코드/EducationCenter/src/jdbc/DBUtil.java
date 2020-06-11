package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author �赿��
 * ����Ŭ ���� Ŭ�����Դϴ�.
 */
public class DBUtil {
	
	private Connection conn = null;
	
	/**
	 * oracle ���� ����
	 * @return ���� ��ü�� ��ȯ�մϴ�.
	 */
	public Connection open() {
		String url = "jdbc:oracle:thin:@211.63.89.53:1521:xe";
		String id = "project";
		String pw = "java1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			return conn;
		} catch (Exception e) {
			System.out.println("DBUtil.open()");
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * DB���� ����
	 */
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("DBUtil.close()");
			e.printStackTrace();
		}
	}
	
	
}
