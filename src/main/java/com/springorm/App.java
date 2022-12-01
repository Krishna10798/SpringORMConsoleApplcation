package com.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entities.Student;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Spring ORM crud operation project started..." );

		ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao=con.getBean("studentDao",StudentDao.class);

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean temp=true;
		while(temp) {
			System.out.println("Enter 1 for add new Student");
			System.out.println("Enter 2 to see any Perticular Student Details");
			System.out.println("Enter 3 to see all Students Details");
			System.out.println("Enter 4 to delete Perticular Student Details");
			System.out.println("Enter 5 to update any Perticular Student Details");
			System.out.println("Enter 6 for Exit");

			try {
				int input=Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// 1 for add new Student
					System.out.println("Enter Student ID : ");
					int sId=Integer.parseInt(br.readLine());
					System.out.println("Enter Student Name : ");
					String sName=(br.readLine());
					System.out.println("Enter Student City : ");
					String sCity=(br.readLine());
					
					Student s=new Student();
					
					s.setStudentId(sId);
					s.setStudentName(sName);
					s.setStudentCity(sCity);
					
					int r=studentDao.insert(s);
					System.out.println(r+ " student added");
					System.out.println("------------------------------------------");
					
					break;
				case 2:
					// 2 to see any Particular Student Details
					
					System.out.println("Enter student Id : ");
					int sId1=Integer.parseInt(br.readLine());
					Student student=studentDao.getStudent(sId1);
					System.out.println(student);
					System.out.println("------------------------------------------");
					break;
				case 3:
					// 3 to see all Students Details

					System.out.println("------------------------------------------");
					List<Student> students = studentDao.getStudents();
					students.forEach(System.out::println);
					System.out.println("------------------------------------------");
					break;
				case 4:
					// 4 to delete Particular Student Details
					
					System.out.println("Enter student Id : ");
					int sId2=Integer.parseInt(br.readLine());
					studentDao.deleteStudent(sId2);
					System.out.println("Student deleted");
					System.out.println("------------------------------------------");
					break;
				case 5:
					// 5 to update any Particular Student Details
					
					System.out.println("Enter Student ID : ");
					int sId3=Integer.parseInt(br.readLine());
					System.out.println("Enter Student Name : ");
					String sName1=(br.readLine());
					System.out.println("Enter Student City : ");
					String sCity1=(br.readLine());
					
					Student s1=new Student();
					
					s1.setStudentId(sId3);
					s1.setStudentName(sName1);
					s1.setStudentCity(sCity1);
					
					studentDao.updateStudent(s1);
					System.out.println(" student updated");
					System.out.println("------------------------------------------");
					break;
				case 6:
					// 6 for Exit
					temp=false;
					break;

					//				default:
					//					
					//					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid Input Please Enter Correct Number !!");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thank you for using my application...");
		System.out.println("Have a Nice Day...!!!");
	}
}