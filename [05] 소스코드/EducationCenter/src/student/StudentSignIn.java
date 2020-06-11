package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import jdbc.DBUtil;

/**
 * 
 * @author �赿�� �л� ȸ�������� ���� Ŭ����
 */
public class StudentSignIn {

	public void signInInput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("ȸ������");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("���̵�(5~14���� �̳�): ");
		String id = sc.nextLine();
		System.out.print("�ֹε�Ϲ�ȣ(ex.950101-1111111) : ");
		String ssn = sc.nextLine();
		System.out.print("��ȭ��ȣ(ex.010-1234-5678) : ");
		String tel = sc.nextLine();
		System.out.print("���¹�ȣ : ");
		String account = sc.nextLine();
		System.out.println();
		StudentBasic student = new StudentBasic(name, id, ssn, tel, account);

		boolean nameFail, idFail, ssnFail, telFail, idOverlap, ssnOverlap = true;
		
		if (nameFail = !nameCheck(student.getName())) {
			System.out.println("�̸��� 2~6������ �ѱ۷� �Է����ּ���.");
		}

		if (idFail = !idCheck(student.getId())) {
			System.out.println("���̵�� 5~15������ ����, ���ڷ� �Է����ּ���.");
		}

		if (ssnFail = !ssnCheck(student.getSsn())) {
			System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�.");
		}

		if (telFail = !telCheck(student.getTel())) {
			System.out.println("��ȿ���� ���� ��ȭ��ȣ�Դϴ�.");
		}
		
		if(checkIdOverlap(student.getId()) != 0) {
			System.out.println("�̹� ������� ���̵� �Դϴ�.");
			idOverlap = true;
		} else {
			idOverlap = false;
		}
		
		if(checkSsnOverlap(student.getSsn()) != 0) {
			System.out.println("�̹� ��ϵ� �ֹι�ȣ�Դϴ�.");
			ssnOverlap = true;
		} else {
			ssnOverlap = false;
		}
		
		

		if (nameFail == true || idFail == true || ssnFail == true || telFail == true || idOverlap == true || idOverlap == true || ssnOverlap == true) {
			System.out.println("�ڷ� ���÷��� 0����, �ٽ� ������ �Է��Ͻ÷��� �ƹ� Ű�� �Է����ּ���.");
			String input = sc.nextLine();
			if (!input.equals("0")) {
				signInInput();
			}
		} else {
			
			try {
				
			} catch (Exception e) {
				System.out.println("StudentSignIn.signInInput()");
				e.printStackTrace();
			}
		}

	}

	// ��ȭ��ȣ ��ȿ���˻�
	private boolean telCheck(String tel) {
		String pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
		return tel.matches(pattern);
	}

	// �ֹι�ȣ ��ȿ���˻�
	private boolean ssnCheck(String ssn) {
		String pattern = "\\d{6}\\-[1-4]\\d{6}";
		return ssn.matches(pattern);
	}

	// id ���� �� ���� üũ �޼ҵ�
	private boolean idCheck(String id) {
		String pattern = "^[a-z0-9]{5,15}$";
		return id.toLowerCase().matches(pattern);
	}

	// �̸� ���� �� �ѱ� üũ �޼ҵ�
	private boolean nameCheck(String name) {
		String pattern = "^[��-�R]{2,6}$";
		return name.matches(pattern);
	}
	
	// id �ߺ�Ȯ��
	private int checkIdOverlap(String id) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {
			conn = util.open();
			// ���̵� �ߺ�Ȯ��
			String sql = "SELECT COUNT(*) AS CNT FROM TBL_STUDENT WHERE ID = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, id);
			rs = stat.executeQuery();

			if (rs.next()) {
				return rs.getInt("CNT");
			}
		}catch (Exception e) {
			System.out.println("StudentSignIn.checkIdOverlap()");
			e.printStackTrace();
		}
		return 1;

	}
	
	// �ֹι�ȣ �ߺ�Ȯ��
	private int checkSsnOverlap(String ssn) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {
			conn = util.open();
			// ���̵� �ߺ�Ȯ��
			String sql = "SELECT COUNT(*) AS CNT FROM TBL_STUDENT WHERE SSN = ?";

			stat = conn.prepareStatement(sql);
			stat.setString(1, ssn);
			rs = stat.executeQuery();

			if (rs.next()) {
				return rs.getInt("CNT");
			}
		}catch (Exception e) {
			System.out.println("StudentSignIn.checkIdOverlap()");
			e.printStackTrace();
		}
		return 1;

	}

	


}
