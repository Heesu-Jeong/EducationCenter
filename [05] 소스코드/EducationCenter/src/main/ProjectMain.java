package main;

import java.util.Scanner;

import jdbc.DBUtil;
import student.StudentSignIn;

/**
 * 
 * @author �赿��
 * �ֿ� �������� JDBC ������Ʈ
 */
public class ProjectMain {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("�������� ���α׷�");
			System.out.println("1. �л� �α���");
			System.out.println("2. ���� �α���");
			System.out.println("3. ������ �α���");
			System.out.println("4. ȸ������");
			System.out.println("5. ���α׷� ����");
			System.out.print("�Է� : ");
			String input = sc.nextLine();
			
			if (input.equals("1")) {
				// �л� �α���
			} else if (input.equals("2")) {
				// ���� �α���
			} else if (input.equals("3")) {
				// ������ �α���
			} else if (input.equals("4")) {
				StudentSignIn signIn = new StudentSignIn();
				signIn.signInInput();
			} else if (input.equals("5")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else {
				System.out.println("�ùٸ� ��ȣ�� �Է����ּ���.");
				System.out.println("��� �Ͻ÷��� ���͸� �Է����ּ���.");
				sc.nextLine();
			}
			
		}
		
		sc.close();
	}

}
