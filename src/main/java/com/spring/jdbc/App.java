package com.spring.jdbc;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Started" );

        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
//        Student student=new Student();
//        student.setId(10);
//        student.setName("Sanket Zanjad");
//        student.setCity("Ahmednagar");
//        int result=studentDao.insert(student);
//        System.out.println("number of rows inserted.."+result);

//        Student student=new Student();
//        student.setCity("Ahmednagar");
//        student.setName("Ram");
//        student.setId(2);
//        int result=studentDao.change(student);
//        System.out.println("data changed "+result);

          //Delete
//        int result=studentDao.delete(10);
//        System.out.println("Deleted "+result);
//        Student student=studentDao.getStudent(222);
//        System.out.println(student);

        /*List<Student> students=studentDao.getAllStudent();
        for(Student s:students)
        System.out.println(s);*/
        int ch=0;
        Scanner sc=new Scanner(System.in);
        Student student=new Student();
        System.out.println("***********Welcome to Spring orm Project****************");
        do {

            System.out.println("PRESS 1 for new student");
            System.out.println("PRESS 2 for displaying all student");
            System.out.println("PRESS 3 for getting details of single student");
            System.out.println("PRESS 4 for deleting a student");
            System.out.println("PRESS 5 for updating a student");
            System.out.println("PRESS 6 for exit");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Please Enter Student Details");
                    System.out.print("\nStudent Id:");
                    student.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Student Name:");
                    student.setName(sc.nextLine());
                    System.out.println("Student City");
                    student.setCity(sc.nextLine());
                    studentDao.insert(student);
                    System.out.println("Student with Id "+student.getId()+" is created");
                    break;
                case 2:
                    System.out.println("Student Details:");
                    List<Student> students=studentDao.getAllStudent();
                    for (Student s:students
                    ) {
                        System.out.print(s.getId()+"...");
                        System.out.print(s.getName()+"...");
                        System.out.print(s.getCity()+"\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter student Id: ");
                    Boolean flag=true;
                    while(flag==true) {
                        try {
                            student = studentDao.getStudent(sc.nextInt());
                            flag = false;
                        } catch (Exception e) {
                            System.out.println("Wrong Input... Try Again");
                            flag = true;
                        }
                    }
                    System.out.print(student.getId()+"...");
                    System.out.print(student.getName()+"...");
                    System.out.print(student.getCity()+"\n");
                    break;
                case 4:
                    System.out.println("Enter Student Id to be deleted: ");
                    student.setId(sc.nextInt());
                    sc.nextLine();
                    studentDao.delete(student.getId());
                    System.out.println("Student with Id "+student.getId()+" is deleted");
                    break;
                case 5:
                    System.out.println("Enter student details to be updated");
                    System.out.println("Student Id:");
                    student.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Student Name: ");
                    student.setName(sc.nextLine());
                    System.out.println("Student City: ");
                    student.setCity(sc.nextLine());
                    studentDao.change(student);
                    System.out.println("Student detail with "+ student.getId()+" updated");
                    break;
                default:
                    if(ch==6){
                        System.out.println("Visit Again..!!");
                        break;
                    }
                    System.out.println("Entered wrong input, Try again...");
            }
        }while (ch!=6);

    }
}
